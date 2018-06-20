package com.se2automate.voice.client.impl;

import com.se2automate.voice.client.IVoiceAutomationClient;
import com.se2automate.voice.client.Language;
import com.se2automate.voice.clientresources.impl.ClientOperationException;
import com.se2automate.voice.clientresources.impl.Voice;
import com.se2automate.voice.clientresources.impl.VoiceRSSUrlClient;
import com.se2automate.voice.model.VoiceAutomationMessage;
import com.se2automate.voice.model.VoiceAutomationMessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * created by Gaurav Tiwari
 * Voice Automation client used for voice automation tests.
 */
public class VoiceAutomationClient implements IVoiceAutomationClient {
    private static final Logger LOG = LoggerFactory.getLogger(VoiceAutomationClient.class);
    private HTTPClient httpClient;
    private VoiceRSSUrlClient voiceRSSUrlClient;

    /**
     * Constructor for VoiceAutomationClient.
     *
     * @throws ClientOperationException - exception in instantiating voice automation client
     */
    public VoiceAutomationClient() throws ClientOperationException {
        String serverEndpoint = System.getProperty("VoiceAutomationServerEndpoint");
        if (null == serverEndpoint) {
            throw new ClientOperationException("Please specify url of the voice automation server by passing JVM argument 'VoiceAutomationServerEndpoint'.");
        }
        this.httpClient = new HTTPClient(serverEndpoint);
    }

    public void load(final Voice voice) throws ClientOperationException {
        // If the voice is instantiated from text, set its url first, then ask the server to load it.
        // If the voice is instantiated from url, directly ask the server to load it.
        VoiceAutomationMessage message;
        String voiceUrl;

        if (voice.getUrl() == null) {
            // use voiceRss service here and make an url here
            String voiceText = voice.getText();
            Language targetedLanguage = voice.getVoiceLanguage();

            if (voiceText == null) {
                throw new ClientOperationException("Voice text is null, please initialise the Voice object with text and language");
            }
            if (targetedLanguage == null) {
                targetedLanguage = Language.ENGLISH_US;
            }
            //Now create the URL -
            String apikey = System.getProperty("VoiceRssKey");
            if (apikey != null) {

                this.voiceRSSUrlClient = new VoiceRSSUrlClient(apikey);
            } else {
                throw new ClientOperationException("Please specify VoiceRss cloud service api key by passing JVM argument 'VoiceRssKey'.");
            }
            voiceUrl = voiceRSSUrlClient.getVoiceUrl(voiceText, targetedLanguage);
            LOG.info("Voice url is " + voiceUrl);
            try {
                voice.setUrl(new URL(voiceUrl));
            } catch (MalformedURLException e) {
                throw new ClientOperationException("URL got from Voice RSS service is malformed.", e);
            }

        } else {// voice is instantiated from url
            voiceUrl = voice.getUrl().toString();
        }

        message = httpClient.load(voiceUrl);
        LOG.info("voice file path " + message.getVoiceFilePath());
        if (message.getStatus() != VoiceAutomationMessageStatus.SUCCESS) {
            throw new ClientOperationException(message.getMessage());
        }

        voice.setFilename(message.getVoiceFilePath());
    }

    public void play(final Voice voice) throws ClientOperationException {
        VoiceAutomationMessage message = httpClient.play(voice.getFilename());
        if (message.getStatus() != VoiceAutomationMessageStatus.SUCCESS) {
            throw new ClientOperationException(message.getMessage());
        }
    }

    public byte[] record(final long duration) throws ClientOperationException {
        VoiceAutomationMessage message = httpClient.record(duration);
        if (message.getStatus() != VoiceAutomationMessageStatus.SUCCESS) {
            throw new ClientOperationException(message.getMessage());
        } else {
            return message.getAudioData();
        }
    }
}
