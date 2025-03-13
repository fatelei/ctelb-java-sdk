package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbListDomainCertLinksApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbListDomainCertLinksApi.ListDomainCertLinksRequest request =
                new CtelbListDomainCertLinksApi.ListDomainCertLinksRequest();
        request.setRegionID("");
        request.setListenerID("listener-xxxxx");

        CtelbListDomainCertLinksApi.ListDomainCertLinksResponse response =
                apis.ctelbListDomainCertLinksApi.send(credential, request);
        System.out.println(response);
    }
}
