package e2e;

import e2e.pages.*;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class AddPhoneTest extends BaseTest {
    LoginHelper loginHelper;
    Header header;
   // ContactsPage contactsPage;
    AddContactDialog addContactDialog;
    ContactInfoPage contactInfoPage;
    PhonesPage phonesPage;
    AddNewPhoneNumberDialog addNewPhoneNumberDialog;

    @Test
    public void successAddPhone() {
        String newContactFirstName = "Conto";
        String newContactLastName = "Norm";
        String newContactDescription = "SudoK";
        String phoneNumber = "1298123";
        String expectedCode = "+49";

        List<String> contactsInfo = new ArrayList<>();
        contactsInfo.add(newContactFirstName);
        contactsInfo.add(newContactLastName);
        contactsInfo.add(newContactDescription);

        loginHelper = new LoginHelper(BaseTest.app.driver);
        loginHelper.loginTestHelper();

        /*contactsPage = new ContactsPage(BaseTest.app.driver);
        contactsPage.waitForLoading();
        contactsPage.clickAddNewContactLink();*/
        header=new Header(app.driver);
        header.waitForLoading();
        header.clickAddNewContactLink();

        addContactDialog = new AddContactDialog(BaseTest.app.driver);
        addContactDialog.waitForLoading();
        addContactDialog.inputInfoForSaving(newContactFirstName, newContactLastName, newContactDescription);
        addContactDialog.saveContact();
        addContactDialog.waitForClose();

        contactInfoPage = new ContactInfoPage(app.driver);
        contactInfoPage.waitForLoading();
        Assert.assertEquals(contactInfoPage.getContactInfo() + " not equal " + contactsInfo, contactInfoPage.getContactInfo(), contactsInfo);


        phonesPage = new PhonesPage(app.driver);
        phonesPage.clickPhoneTab();
        phonesPage.waitForLoading();
        phonesPage.clickAddPhoneNumberButton();

        addNewPhoneNumberDialog = new AddNewPhoneNumberDialog(app.driver);
        addNewPhoneNumberDialog.waitForLoading();
        addNewPhoneNumberDialog.selectCountryCode();
        addNewPhoneNumberDialog.enterPhoneNumber(phoneNumber);
        addNewPhoneNumberDialog.savePhoneNumber();
        addNewPhoneNumberDialog.waitForClose();

        phonesPage.waitForLoading();
        assertTrue(phonesPage.isPhoneCode(expectedCode));
        assertTrue(phonesPage.isPhoneNumber(phoneNumber));
    }
// test-results:C:\Users\VivoBook\.jdks\corretto-17.0.8.1\bin\java.exe -ea -Didea.test.cyclic.buffer.size=1048576 "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.1\lib\idea_rt.jar=52775:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.1\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.1\lib\idea_rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.1\plugins\testng\lib\testng-rt.jar;C:\Users\VivoBook\IdeaProjects\ph23\target\test-classes;C:\Users\VivoBook\.m2\repository\org\seleniumhq\selenium\selenium-java\4.8.0\selenium-java-4.8.0.jar;C:\Users\VivoBook\.m2\repository\org\seleniumhq\selenium\selenium-api\4.8.0\selenium-api-4.8.0.jar;C:\Users\VivoBook\.m2\repository\org\seleniumhq\selenium\selenium-chrome-driver\4.8.0\selenium-chrome-driver-4.8.0.jar;C:\Users\VivoBook\.m2\repository\com\google\auto\service\auto-service-annotations\1.0.1\auto-service-annotations-1.0.1.jar;C:\Users\VivoBook\.m2\repository\com\google\auto\service\auto-service\1.0.1\auto-service-1.0.1.jar;C:\Users\VivoBook\.m2\repository\com\google\auto\auto-common\1.2\auto-common-1.2.jar;C:\Users\VivoBook\.m2\repository\com\google\guava\guava\31.1-jre\guava-31.1-jre.jar;C:\Users\VivoBook\.m2\repository\com\google\guava\failureaccess\1.0.1\failureaccess-1.0.1.jar;C:\Users\VivoBook\.m2\repository\com\google\guava\listenablefuture\9999.0-empty-to-avoid-conflict-with-guava\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;C:\Users\VivoBook\.m2\repository\com\google\code\findbugs\jsr305\3.0.2\jsr305-3.0.2.jar;C:\Users\VivoBook\.m2\repository\org\checkerframework\checker-qual\3.12.0\checker-qual-3.12.0.jar;C:\Users\VivoBook\.m2\repository\com\google\errorprone\error_prone_annotations\2.11.0\error_prone_annotations-2.11.0.jar;C:\Users\VivoBook\.m2\repository\com\google\j2objc\j2objc-annotations\1.3\j2objc-annotations-1.3.jar;C:\Users\VivoBook\.m2\repository\org\seleniumhq\selenium\selenium-chromium-driver\4.8.0\selenium-chromium-driver-4.8.0.jar;C:\Users\VivoBook\.m2\repository\org\seleniumhq\selenium\selenium-json\4.8.0\selenium-json-4.8.0.jar;C:\Users\VivoBook\.m2\repository\org\seleniumhq\selenium\selenium-devtools-v107\4.8.0\selenium-devtools-v107-4.8.0.jar;C:\Users\VivoBook\.m2\repository\org\seleniumhq\selenium\selenium-devtools-v108\4.8.0\selenium-devtools-v108-4.8.0.jar;C:\Users\VivoBook\.m2\repository\org\seleniumhq\selenium\selenium-devtools-v109\4.8.0\selenium-devtools-v109-4.8.0.jar;C:\Users\VivoBook\.m2\repository\org\seleniumhq\selenium\selenium-devtools-v85\4.8.0\selenium-devtools-v85-4.8.0.jar;C:\Users\VivoBook\.m2\repository\org\seleniumhq\selenium\selenium-edge-driver\4.8.0\selenium-edge-driver-4.8.0.jar;C:\Users\VivoBook\.m2\repository\org\seleniumhq\selenium\selenium-firefox-driver\4.8.0\selenium-firefox-driver-4.8.0.jar;C:\Users\VivoBook\.m2\repository\org\seleniumhq\selenium\selenium-http\4.8.0\selenium-http-4.8.0.jar;C:\Users\VivoBook\.m2\repository\dev\failsafe\failsafe\3.3.0\failsafe-3.3.0.jar;C:\Users\VivoBook\.m2\repository\org\seleniumhq\selenium\selenium-ie-driver\4.8.0\selenium-ie-driver-4.8.0.jar;C:\Users\VivoBook\.m2\repository\org\seleniumhq\selenium\selenium-remote-driver\4.8.0\selenium-remote-driver-4.8.0.jar;C:\Users\VivoBook\.m2\repository\io\netty\netty-buffer\4.1.87.Final\netty-buffer-4.1.87.Final.jar;C:\Users\VivoBook\.m2\repository\io\netty\netty-codec-http\4.1.87.Final\netty-codec-http-4.1.87.Final.jar;C:\Users\VivoBook\.m2\repository\io\netty\netty-codec\4.1.87.Final\netty-codec-4.1.87.Final.jar;C:\Users\VivoBook\.m2\repository\io\netty\netty-handler\4.1.87.Final\netty-handler-4.1.87.Final.jar;C:\Users\VivoBook\.m2\repository\io\netty\netty-common\4.1.87.Final\netty-common-4.1.87.Final.jar;C:\Users\VivoBook\.m2\repository\io\netty\netty-transport-classes-epoll\4.1.87.Final\netty-transport-classes-epoll-4.1.87.Final.jar;C:\Users\VivoBook\.m2\repository\io\netty\netty-transport-classes-kqueue\4.1.87.Final\netty-transport-classes-kqueue-4.1.87.Final.jar;C:\Users\VivoBook\.m2\repository\io\netty\netty-transport-native-epoll\4.1.87.Final\netty-transport-native-epoll-4.1.87.Final.jar;C:\Users\VivoBook\.m2\repository\io\netty\netty-transport-native-kqueue\4.1.87.Final\netty-transport-native-kqueue-4.1.87.Final.jar;C:\Users\VivoBook\.m2\repository\io\netty\netty-transport-native-unix-common\4.1.87.Final\netty-transport-native-unix-common-4.1.87.Final.jar;C:\Users\VivoBook\.m2\repository\io\netty\netty-transport\4.1.87.Final\netty-transport-4.1.87.Final.jar;C:\Users\VivoBook\.m2\repository\io\netty\netty-resolver\4.1.87.Final\netty-resolver-4.1.87.Final.jar;C:\Users\VivoBook\.m2\repository\io\opentelemetry\opentelemetry-api\1.22.0\opentelemetry-api-1.22.0.jar;C:\Users\VivoBook\.m2\repository\io\opentelemetry\opentelemetry-context\1.22.0\opentelemetry-context-1.22.0.jar;C:\Users\VivoBook\.m2\repository\io\opentelemetry\opentelemetry-exporter-logging\1.22.0\opentelemetry-exporter-logging-1.22.0.jar;C:\Users\VivoBook\.m2\repository\io\opentelemetry\opentelemetry-sdk-metrics\1.22.0\opentelemetry-sdk-metrics-1.22.0.jar;C:\Users\VivoBook\.m2\repository\io\opentelemetry\opentelemetry-sdk-logs\1.22.0-alpha\opentelemetry-sdk-logs-1.22.0-alpha.jar;C:\Users\VivoBook\.m2\repository\io\opentelemetry\opentelemetry-api-logs\1.22.0-alpha\opentelemetry-api-logs-1.22.0-alpha.jar;C:\Users\VivoBook\.m2\repository\io\opentelemetry\opentelemetry-sdk-common\1.22.0\opentelemetry-sdk-common-1.22.0.jar;C:\Users\VivoBook\.m2\repository\io\opentelemetry\opentelemetry-sdk-extension-autoconfigure-spi\1.22.0\opentelemetry-sdk-extension-autoconfigure-spi-1.22.0.jar;C:\Users\VivoBook\.m2\repository\io\opentelemetry\opentelemetry-sdk-extension-autoconfigure\1.22.0-alpha\opentelemetry-sdk-extension-autoconfigure-1.22.0-alpha.jar;C:\Users\VivoBook\.m2\repository\io\opentelemetry\opentelemetry-sdk-trace\1.22.0\opentelemetry-sdk-trace-1.22.0.jar;C:\Users\VivoBook\.m2\repository\io\opentelemetry\opentelemetry-sdk\1.22.0\opentelemetry-sdk-1.22.0.jar;C:\Users\VivoBook\.m2\repository\io\opentelemetry\opentelemetry-semconv\1.22.0-alpha\opentelemetry-semconv-1.22.0-alpha.jar;C:\Users\VivoBook\.m2\repository\io\ous\jtoml\2.0.0\jtoml-2.0.0.jar;C:\Users\VivoBook\.m2\repository\net\bytebuddy\byte-buddy\1.12.22\byte-buddy-1.12.22.jar;C:\Users\VivoBook\.m2\repository\org\apache\commons\commons-exec\1.3\commons-exec-1.3.jar;C:\Users\VivoBook\.m2\repository\org\asynchttpclient\async-http-client\2.12.3\async-http-client-2.12.3.jar;C:\Users\VivoBook\.m2\repository\org\asynchttpclient\async-http-client-netty-utils\2.12.3\async-http-client-netty-utils-2.12.3.jar;C:\Users\VivoBook\.m2\repository\io\netty\netty-codec-socks\4.1.60.Final\netty-codec-socks-4.1.60.Final.jar;C:\Users\VivoBook\.m2\repository\io\netty\netty-handler-proxy\4.1.60.Final\netty-handler-proxy-4.1.60.Final.jar;C:\Users\VivoBook\.m2\repository\io\netty\netty-transport-native-epoll\4.1.60.Final\netty-transport-native-epoll-4.1.60.Final-linux-x86_64.jar;C:\Users\VivoBook\.m2\repository\io\netty\netty-transport-native-kqueue\4.1.60.Final\netty-transport-native-kqueue-4.1.60.Final-osx-x86_64.jar;C:\Users\VivoBook\.m2\repository\org\reactivestreams\reactive-streams\1.0.3\reactive-streams-1.0.3.jar;C:\Users\VivoBook\.m2\repository\com\typesafe\netty\netty-reactive-streams\2.0.4\netty-reactive-streams-2.0.4.jar;C:\Users\VivoBook\.m2\repository\com\sun\activation\jakarta.activation\1.2.2\jakarta.activation-1.2.2.jar;C:\Users\VivoBook\.m2\repository\org\seleniumhq\selenium\selenium-manager\4.8.0\selenium-manager-4.8.0.jar;C:\Users\VivoBook\.m2\repository\org\seleniumhq\selenium\selenium-safari-driver\4.8.0\selenium-safari-driver-4.8.0.jar;C:\Users\VivoBook\.m2\repository\org\seleniumhq\selenium\selenium-support\4.8.0\selenium-support-4.8.0.jar;C:\Users\VivoBook\.m2\repository\junit\junit\4.13.2\junit-4.13.2.jar;C:\Users\VivoBook\.m2\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;C:\Users\VivoBook\.m2\repository\io\github\bonigarcia\webdrivermanager\5.5.3\webdrivermanager-5.5.3.jar;C:\Users\VivoBook\.m2\repository\org\slf4j\slf4j-api\2.0.7\slf4j-api-2.0.7.jar;C:\Users\VivoBook\.m2\repository\com\google\code\gson\gson\2.10.1\gson-2.10.1.jar;C:\Users\VivoBook\.m2\repository\com\github\docker-java\docker-java\3.3.3\docker-java-3.3.3.jar;C:\Users\VivoBook\.m2\repository\com\github\docker-java\docker-java-core\3.3.3\docker-java-core-3.3.3.jar;C:\Users\VivoBook\.m2\repository\com\github\docker-java\docker-java-api\3.3.3\docker-java-api-3.3.3.jar;C:\Users\VivoBook\.m2\repository\commons-io\commons-io\2.6\commons-io-2.6.jar;C:\Users\VivoBook\.m2\repository\org\apache\commons\commons-compress\1.21\commons-compress-1.21.jar;C:\Users\VivoBook\.m2\repository\org\bouncycastle\bcpkix-jdk18on\1.75\bcpkix-jdk18on-1.75.jar;C:\Users\VivoBook\.m2\repository\org\bouncycastle\bcprov-jdk18on\1.75\bcprov-jdk18on-1.75.jar;C:\Users\VivoBook\.m2\repository\org\bouncycastle\bcutil-jdk18on\1.75\bcutil-jdk18on-1.75.jar;C:\Users\VivoBook\.m2\repository\org\slf4j\jcl-over-slf4j\1.7.30\jcl-over-slf4j-1.7.30.jar;C:\Users\VivoBook\.m2\repository\com\github\docker-java\docker-java-transport-httpclient5\3.3.3\docker-java-transport-httpclient5-3.3.3.jar;C:\Users\VivoBook\.m2\repository\com\github\docker-java\docker-java-transport\3.3.3\docker-java-transport-3.3.3.jar;C:\Users\VivoBook\.m2\repository\net\java\dev\jna\jna\5.12.1\jna-5.12.1.jar;C:\Users\VivoBook\.m2\repository\org\brotli\dec\0.1.2\dec-0.1.2.jar;C:\Users\VivoBook\.m2\repository\org\apache\commons\commons-lang3\3.13.0\commons-lang3-3.13.0.jar;C:\Users\VivoBook\.m2\repository\org\apache\httpcomponents\client5\httpclient5\5.2.1\httpclient5-5.2.1.jar;C:\Users\VivoBook\.m2\repository\org\apache\httpcomponents\core5\httpcore5\5.2\httpcore5-5.2.jar;C:\Users\VivoBook\.m2\repository\org\apache\httpcomponents\core5\httpcore5-h2\5.2\httpcore5-h2-5.2.jar;C:\Users\VivoBook\.m2\repository\org\testng\testng\7.8.0\testng-7.8.0.jar;C:\Users\VivoBook\.m2\repository\com\beust\jcommander\1.82\jcommander-1.82.jar;C:\Users\VivoBook\.m2\repository\org\webjars\jquery\3.6.1\jquery-3.6.1.jar;C:\Users\VivoBook\.m2\repository\io\rest-assured\rest-assured\5.3.2\rest-assured-5.3.2.jar;C:\Users\VivoBook\.m2\repository\org\apache\groovy\groovy\4.0.11\groovy-4.0.11.jar;C:\Users\VivoBook\.m2\repository\org\apache\groovy\groovy-xml\4.0.11\groovy-xml-4.0.11.jar;C:\Users\VivoBook\.m2\repository\org\apache\httpcomponents\httpclient\4.5.13\httpclient-4.5.13.jar;C:\Users\VivoBook\.m2\repository\org\apache\httpcomponents\httpcore\4.4.13\httpcore-4.4.13.jar;C:\Users\VivoBook\.m2\repository\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;C:\Users\VivoBook\.m2\repository\commons-codec\commons-codec\1.11\commons-codec-1.11.jar;C:\Users\VivoBook\.m2\repository\org\apache\httpcomponents\httpmime\4.5.13\httpmime-4.5.13.jar;C:\Users\VivoBook\.m2\repository\org\hamcrest\hamcrest\2.2\hamcrest-2.2.jar;C:\Users\VivoBook\.m2\repository\org\ccil\cowan\tagsoup\tagsoup\1.2.1\tagsoup-1.2.1.jar;C:\Users\VivoBook\.m2\repository\io\rest-assured\json-path\5.3.2\json-path-5.3.2.jar;C:\Users\VivoBook\.m2\repository\org\apache\groovy\groovy-json\4.0.11\groovy-json-4.0.11.jar;C:\Users\VivoBook\.m2\repository\io\rest-assured\rest-assured-common\5.3.2\rest-assured-common-5.3.2.jar;C:\Users\VivoBook\.m2\repository\io\rest-assured\xml-path\5.3.2\xml-path-5.3.2.jar;C:\Users\VivoBook\.m2\repository\org\projectlombok\lombok\1.18.30\lombok-1.18.30.jar;C:\Users\VivoBook\.m2\repository\com\fasterxml\jackson\core\jackson-databind\2.15.2\jackson-databind-2.15.2.jar;C:\Users\VivoBook\.m2\repository\com\fasterxml\jackson\core\jackson-annotations\2.15.2\jackson-annotations-2.15.2.jar;C:\Users\VivoBook\.m2\repository\com\fasterxml\jackson\core\jackson-core\2.15.2\jackson-core-2.15.2.jar;C:\Users\VivoBook\.m2\repository\com\github\javafaker\javafaker\1.0.2\javafaker-1.0.2.jar;C:\Users\VivoBook\.m2\repository\org\yaml\snakeyaml\1.23\snakeyaml-1.23-android.jar;C:\Users\VivoBook\.m2\repository\com\github\mifmif\generex\1.0.2\generex-1.0.2.jar;C:\Users\VivoBook\.m2\repository\dk\brics\automaton\automaton\1.11-8\automaton-1.11-8.jar" com.intellij.rt.testng.RemoteTestNGStarter -usedefaultlisteners false -socket52774 @w@C:\Users\VivoBook\AppData\Local\Temp\idea_working_dirs_testng.tmp -temp C:\Users\VivoBook\AppData\Local\Temp\idea_testng.tmp
//SLF4J: No SLF4J providers were found.
//SLF4J: Defaulting to no-operation (NOP) logger implementation
//SLF4J: See https://www.slf4j.org/codes.html#noProviders for further details.
//Starting ChromeDriver 117.0.5938.149 (e3344ddefa12e60436fa28c81cf207c1afb4d0a9-refs/branch-heads/5938@{#1539}) on port 45224
//Only local connections are allowed.
//Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
//ChromeDriver was started successfully.
//Okt. 11, 2023 12:19:52 AM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
//WARNUNG: Unable to find CDP implementation matching 117
//Okt. 11, 2023 12:19:52 AM org.openqa.selenium.chromium.ChromiumDriver lambda$new$3
//WARNUNG: Unable to find version of CDP to use for . You may need to include a dependency on a specific version of the CDP using something similar to `org.seleniumhq.selenium:selenium-devtools-v86:4.8.0` where the version ("v86") matches the version of the chromium-based browser you're using and the version number of the artifact is the same as Selenium's.
//Okt. 11, 2023 12:20:19 AM org.openqa.selenium.remote.http.WebSocket$Listener onError
//WARNUNG: Connection reset
//java.net.SocketException: Connection reset
//	at java.base/sun.nio.ch.SocketChannelImpl.throwConnectionReset(SocketChannelImpl.java:394)
//	at java.base/sun.nio.ch.SocketChannelImpl.read(SocketChannelImpl.java:426)
//	at io.netty.buffer.PooledByteBuf.setBytes(PooledByteBuf.java:259)
//	at io.netty.buffer.AbstractByteBuf.writeBytes(AbstractByteBuf.java:1132)
//	at io.netty.channel.socket.nio.NioSocketChannel.doReadBytes(NioSocketChannel.java:357)
//	at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:151)
//	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:788)
//	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:724)
//	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:650)
//	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:562)
//	at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:997)
//	at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
//	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
//	at java.base/java.lang.Thread.run(Thread.java:833)
//
//
//===============================================
//Default Suite
//Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
//===============================================
//
//
//Process finished with exit code 0
}
