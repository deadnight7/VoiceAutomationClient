package com.se2automate.voice.clientresources.impl;

import com.se2automate.voice.client.Language;

import java.net.URL;

/**
 * created by Gaurav Tiwari
 * <p>
 * Voice class used to wrap all metadata of the voice.
 */
public class Voice {

    private URL url;
    private String text;
    private Language language;
    private String filename;
    private String voiceName = "";

    /**
     * Constructor for Voice object.
     *
     * @param url - URL object
     */
    public Voice(final URL url) {
        this.url = url;
    }

    /**
     * Constructor for Voice object.
     *
     * @param text - text of the voice
     */
    public Voice(final String text) {
        this.text = text;
    }

    /**
     * Constructor for Voice object.
     *
     * @param text - text of the voice
     */
    public Voice(final String text, final Language language) {
        this.text = text;
        this.language = language;
    }

    /**
     * Getter for url field.
     *
     * @return - URL object
     */
    public URL getUrl() {
        return url;
    }

    /**
     * Setter for url field.
     *
     * @param url - URL object
     */
    public void setUrl(final URL url) {
        this.url = url;
    }

    /**
     * Getter for text field.
     *
     * @return - text of the voice
     */
    public String getText() {
        return text;
    }

    /**
     * Setter for text field.
     *
     * @param text - text of the voice
     */
    public void setText(final String text) {
        this.text = text;
    }

    /**
     * Getter for filename field.
     *
     * @return - filename of the voice
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Setter for filename field.
     *
     * @param filename - filename of the voice
     */
    public void setFilename(final String filename) {
        this.filename = filename;
    }

    /**
     * Getter for voiceName field.
     *
     * @return - voiceName of the voice
     */
    public String getVoiceName() {
        return voiceName;
    }

    /**
     * Setter for voiceName field.
     *
     * @param voiceName - voiceName of the voice
     */
    public void setVoiceName(final String voiceName) {
        this.voiceName = voiceName;
    }

    /**
     * Getter for voiceLanguage field.
     *
     * @return - voiceLanguage of the voice
     */
    public Language getVoiceLanguage() {
        return language;
    }

    /**
     * Setter for voiceLanguage field.
     *
     * @param language - voiceLanguage of the voice
     */
    public void setVoiceLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return String.format("Voice with text: \"%s\" %nfilename: \"%s\" %nvoiceName: \"%s\" ", this.text, this.filename, this.voiceName);
    }

}
