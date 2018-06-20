package com.se2automate.voice.clientresources.impl;

import com.se2automate.voice.client.Language;
import com.se2automate.voice.client.impl.LanguageUtils;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;

/**
 * created by Gaurav Tiwari
 * <p>
 * This class is used for doing any action via VoiceRSS TTS service
 */
public class VoiceRSSUrlClient {

    private static final Logger LOG = LoggerFactory.getLogger(VoiceRSSUrlClient.class);

    private static final String VOICERSS_BASEURL = "https://api.voicerss.org/?";
    private String VOICERSS_APIKEY;

    /**
     * Default constructor for VoiceRSSUrlClient.
     */
    public VoiceRSSUrlClient(String apiKey) {
        this.VOICERSS_APIKEY = apiKey;
    }

    /**
     * Get voice url from VOICE RSS service.
     *
     * @param text     - voice text
     * @param language - voice language
     * @return - voice url
     * @throws ClientOperationException - exception thrown when communicating to Voice RSS service
     */
    public String getVoiceUrl(final String text, final Language language) throws ClientOperationException {
        String voiceUrl = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(VOICERSS_BASEURL);
            uriBuilder.addParameter("key", VOICERSS_APIKEY);
            uriBuilder.addParameter("c", "WAV");
            uriBuilder.addParameter("hl", LanguageUtils.getStringFor(language));
            uriBuilder.addParameter("src", text);
            voiceUrl = uriBuilder.toString();
        } catch (URISyntaxException ue) {
            ue.printStackTrace();
            LOG.error(ue.getMessage());
        }
        return voiceUrl;
    }

}
