package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbDeleteDomainCertLinksApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbDeleteDomainCertLinksApi.DeleteDomainCertLinksRequest request =
                new CtelbDeleteDomainCertLinksApi.DeleteDomainCertLinksRequest();
        request.setRegionID("");
        request.setDomainCertID("dcl-xxxx");

        CtelbDeleteDomainCertLinksApi.DeleteDomainCertLinksResponse response =
                apis.ctelbDeleteDomainCertLinksApi.send(credential, request);
        System.out.println(response);
    }
}
