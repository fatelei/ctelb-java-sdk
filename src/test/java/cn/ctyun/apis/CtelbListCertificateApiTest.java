package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbListCertificateApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbListCertificateApi.ListCertificateRequest request =
                new CtelbListCertificateApi.ListCertificateRequest();
        request.setRegionID("");
        request.setIDs("cert-75ex90k9v0,cert-r4cfhgrsss");
        request.setName("");
        request.setType("");

        CtelbListCertificateApi.ListCertificateResponse response =
                apis.ctelbListCertificateApi.send(credential, request);
        System.out.println(response);
    }
}
