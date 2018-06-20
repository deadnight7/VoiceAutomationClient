package test;


import com.se2automate.voice.client.impl.VoiceAutomationClient;
import com.se2automate.voice.clientresources.impl.ClientOperationException;
import com.se2automate.voice.clientresources.impl.Voice;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class VoiceAutomationClientTest {

    @Test
    public void testVoiceInstantiatedFromText() {
        Voice voice = new Voice("hello");
        Assert.assertNotNull(voice.getText());
        Assert.assertNull(voice.getUrl());
        Assert.assertNull(voice.getFilename());
    }

    @Test
    public void testVoiceInstantiatedFromUrl() throws MalformedURLException {
        Voice voice = new Voice(new URL("http://foo.bar"));
        Assert.assertNotNull(voice.getUrl());
        Assert.assertNull(voice.getText());
        Assert.assertNull(voice.getFilename());
    }

    @Test(expectedExceptions = ClientOperationException.class)
    public void testInstantiateVAClientWithoutVAServerEndpoint() throws ClientOperationException {
        System.clearProperty("VoiceAutomationServerEndpoint");
        VoiceAutomationClient voiceAutomationClient = new VoiceAutomationClient(); // jvm arg VAServerEndpoint not set
    }
}
