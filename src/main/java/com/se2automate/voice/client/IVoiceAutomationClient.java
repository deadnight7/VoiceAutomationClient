package com.se2automate.voice.client;


import com.se2automate.voice.clientresources.impl.ClientOperationException;
import com.se2automate.voice.clientresources.impl.Voice;

/**
 * created by Gaurav Tiwari
 * <p>
 * Interface for Voice Automation client.
 */
public interface IVoiceAutomationClient {

    /**
     * Call Voice automation server to load the voice file. If url of the voice object is not null,
     * send it to VoiceAutomation client;
     * else, first get url from Voice RSS service, then send it to VoiceAutomation client.
     *
     * @param voice - voice object includes metadata of the voice
     * @throws ClientOperationException - exception in loading voice
     */
    void load(final Voice voice) throws ClientOperationException;

    /**
     * Request the server to play the voice to device.
     *
     * @param voice - voice to play
     * @throws ClientOperationException - exception in playing voice
     */
    void play(final Voice voice) throws ClientOperationException;

    /**
     * Request the server to record the output from a certain mixer
     *
     * @param duration - the amount of time to record for
     * @return - returns the recorded audio in a byte array format
     * @throws ClientOperationException - exception in recording audio
     */
    byte[] record(final long duration) throws ClientOperationException;
}
