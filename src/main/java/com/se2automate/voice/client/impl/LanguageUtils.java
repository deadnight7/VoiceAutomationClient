package com.se2automate.voice.client.impl;

import com.se2automate.voice.client.Language;

/**
 * created by Gaurav Tiwari
 * An util class for fetching language codes
 */
public class LanguageUtils {

    public static final String getStringFor(final Language language) {
        switch (language) {
            case CATALAN:
                return "ca-es";

            case CHINESE_CHINA:
                return "zh-cn";

            case CHINESE_HONGKONG:
                return "zh-hk";

            case CHINESE_TAIWAN:
                return "zh-tw";

            case DANISH:
                return "da-dk";

            case DUTCH:
                return "nl-nl";

            case ENGLISH_AUSTRALIA:
                return "en-au";

            case ENGLISH_CANADA:
                return "en-ca";

            case ENGLISH_INDIA:
                return "en-in";

            case ENGLISH_UK:
                return "en-gb";

            case ENGLISH_US:
                return "en-us";

            case FINNISH:
                return "fi-fi";

            case FRENCH_CANADA:
                return "fr-ca";

            case FRENCH_FRANCE:
                return "fr-fr";

            case GERMAN:
                return "de-de";

            case ITALIAN:
                return "it-it";

            case JAPANESE:
                return "ja-jp";

            case KOREAN:
                return "ko-kr";

            case NORWEGIAN:
                return "nb-no";

            case POLISH:
                return "pl-pl";

            case PORTUGUESE_BRAZIL:
                return "pt-br";

            case PORTUGUESE_PORTUGAL:
                return "pt-pt";

            case RUSSIAN:
                return "ru-ru";

            case SPANISH_MEXICO:
                return "es-mx";

            case SPANISH_SPAIN:
                return "es-es";

            case SWEDISH_SWEDEN:
                return "sv-se";


            default:
                return "en-us";


        }
    }
}
