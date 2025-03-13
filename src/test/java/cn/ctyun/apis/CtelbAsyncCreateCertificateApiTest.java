package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbAsyncCreateCertificateApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbAsyncCreateCertificateApi.AsyncCreateCertificateRequest request =
                new CtelbAsyncCreateCertificateApi.AsyncCreateCertificateRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setRegionID("");
        request.setProjectID("");
        request.setName("acl11");
        request.setDescription("test");
        request.setType("");
        request.setPrivateKey("");
        request.setCertificate("");

        CtelbAsyncCreateCertificateApi.AsyncCreateCertificateResponse response =
                apis.ctelbAsyncCreateCertificateApi.send(credential, request);
        System.out.println(response);
    }
}
