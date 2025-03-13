package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbUpdateDomainCertLinksApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbUpdateDomainCertLinksApi.UpdateDomainCertLinksRequest request =
                new CtelbUpdateDomainCertLinksApi.UpdateDomainCertLinksRequest();
        request.setRegionID("");
        request.setDomainCertID("dcl-xxxx");
        request.setDescription("");
        request.setCertificateID("cert-xxxxx");

        CtelbUpdateDomainCertLinksApi.UpdateDomainCertLinksResponse response =
                apis.ctelbUpdateDomainCertLinksApi.send(credential, request);
        System.out.println(response);
    }
}
