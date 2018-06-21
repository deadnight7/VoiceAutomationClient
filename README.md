[![badge-jdk](https://img.shields.io/badge/jdk-8-green.svg)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
[![License badge](https://img.shields.io/badge/license-Apache2-green.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Twitter](Follow On Twitter)](https://twitter.com/se2automate)

# VoiceAutomationClient
Client for sending request to VoiceServer for playing files

VoiceAutomationClient is open source, released under the terms of [Apache 2.0 License]. It is used along with VoiceAutomationServer

##Pre-requisite

You have to use this library along with VoiceAutomationServer Standalone jar. 
Download the Standalone jar from [VoiceAutomationServer-Jar](https://github.com/g-tiwari/VoiceAutomationServer/blob/master/VoiceAutomationServer-1.0.0.jar)
Then start the server from terminal by typing 
```bash
java -jar VoiceAutomationServer-1.0.0.jar
```

After this you will see something similar to below - 

```bash
INFO [main] (VoiceAutomationServer.java:100) - Initializing Voice Automation Server
Jun 20, 2018 8:11:38 PM com.sun.jersey.api.core.PackagesResourceConfig init
INFO: Scanning for root resource and provider classes in the packages:
  com.se2automate.voice.ServerResources
Jun 20, 2018 8:11:38 PM com.sun.jersey.api.core.ScanningResourceConfig logClasses
INFO: Root resource classes found:
  class com.se2automate.voice.ServerResources.impl.VoiceAutomationServerAPI
Jun 20, 2018 8:11:38 PM com.sun.jersey.api.core.ScanningResourceConfig logClasses
INFO: Provider classes found:
  class com.se2automate.voice.ServerResources.impl.JSONParseExceptionMapper
Jun 20, 2018 8:11:38 PM com.sun.jersey.server.impl.application.WebApplicationImpl _initiate
INFO: Initiating Jersey application, version 'Jersey: 1.17 01/17/2013 03:31 PM'
Jun 20, 2018 8:11:39 PM org.glassfish.grizzly.http.server.NetworkListener start
INFO: Started listener bound to [10.48.129.41:9090]
Jun 20, 2018 8:11:39 PM org.glassfish.grizzly.http.server.HttpServer start
INFO: [HttpServer] Started.
 INFO [main] (VoiceAutomationServer.java:109) - Voice Automation Server started at http://10.48.129.41:9090/

```


## Usage

In order to use VoiceAutomationClient in a Maven project, you need to add the following dependency in your `pom.xml` (Java 8 or upper required):

```xml
<dependency>
    <groupId>com.se2automate.voice</groupId>
    <artifactId>VoiceAutomationClient</artifactId>
    <version>1.0.0</version>
</dependency>
```

VoiceAutomationClient is typically used by tests, and therefore, the typical scope would be *test* (`<scope>test</scope>`).

Once we have included this dependency, you can let VoiceAutomationClient to manage the voice play request on the server. Take a look at this below Sample Test

```java
public class VoiceTest {
    public static void main(String[] args){
        textToSpeechTest();
        playInternetVoiceFile();
    }

    public static void textToSpeechTest(){
        final Logger LOG = LoggerFactory.getLogger(VoiceTest.class);
        //Start the server on your target machine by command java -jar VoiceAuotmationServer.jar
        System.setProperty("VoiceAutomationServerEndpoint","<VoiceAutomationServerIP:Port>");
        //Signup to voicerss and get your api key
        System.setProperty("VoiceRssKey","<VoiceRSSAPIKEy>");
        Voice voice = new Voice("Hey Google, whats the current time", Language.ENGLISH_US);

        try {
            VoiceAutomationClient voiceAutomationClient = new VoiceAutomationClient();
            voiceAutomationClient.load(voice);
            voiceAutomationClient.play(voice);
            LOG.info(voice.getFilename());
            LOG.info(voice.getText());
            LOG.info(voice.getVoiceName());
            LOG.info(voice.getVoiceLanguage().toString());
        }catch (ClientOperationException e){
            e.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void playInternetVoiceFile(){
        final Logger LOG = LoggerFactory.getLogger(VoiceTest.class);
        //Start the server on your target machine by command java -jar VoiceAuotmationServer.jar
        System.setProperty("VoiceAutomationServerEndpoint","<VoiceAutomationServerIP:Port>");
        //Signup to voicerss and get your api key
        System.setProperty("VoiceRssKey","<VoiceRSSAPIKEy>");
        Voice voice = new Voice("http://www.pacdv.com/sounds/voices/thank-god-its-friday.wav");

        try {
            VoiceAutomationClient voiceAutomationClient = new VoiceAutomationClient();
            voiceAutomationClient.load(voice);
            voiceAutomationClient.play(voice);
            LOG.info(voice.getFilename());
            LOG.info(voice.getText());
            LOG.info(voice.getVoiceName());
            LOG.info(voice.getVoiceLanguage().toString());
        }catch (ClientOperationException e){
            e.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

```

1. It send a request to get the voice file from the TTS API or directly from the url
2. It downloads voice wav file on the target machine and save it with some random name in temp folder
3. Then It plays the file on the machine where server is running, on specified audio port

## Help

If you have questions on how to use VoiceAutomationClient properly with a special configuration or suchlike, please consider asking a question on [Github Queries].

## About

VoiceAutomationClient (Copyright &copy; 2018) is a project created by [Gaurav Tiwari] and licensed under the terms of the [Apache 2.0 License]. Comments, questions and suggestions are always very [welcome][VoiceAutomationClient issues]!

[Apache HTTP Client]: https://hc.apache.org/httpcomponents-client-ga/
[Apache HTTP Client logging practices]: https://hc.apache.org/httpcomponents-client-ga/logging.html
[Apache 2.0 License]: http://www.apache.org/licenses/LICENSE-2.0
[authenticated requests]: https://developer.github.com/v3/#rate-limiting
[Gaurav Tiwari]: http://g-tiwari.github.io/
[GitHub account]: https://github.com/settings/tokens
[GitHub Repository]: https://github.com/g-tiwari/VoiceAutomationClient
[VoiceAutomationClient issues]: https://github.com/g-tiwari/VoiceAutomationClient/issues
