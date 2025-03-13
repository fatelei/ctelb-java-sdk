package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbCreateDomainCertLinkApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbCreateDomainCertLinkApi.CreateDomainCertLinkRequest request =
                new CtelbCreateDomainCertLinkApi.CreateDomainCertLinkRequest();
        request.setRegionID("");
        request.setDomainName("example.com");
        request.setCertificateID("cert-xxxxx");
        request.setListenerID("listener-xxxxx");
        request.setDescription("test");

        CtelbCreateDomainCertLinkApi.CreateDomainCertLinkResponse response =
                apis.ctelbCreateDomainCertLinkApi.send(credential, request);
        System.out.println(response);
    }
}
