package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbShowAccessControlApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbShowAccessControlApi.ShowAccessControlRequest request =
                new CtelbShowAccessControlApi.ShowAccessControlRequest();
        request.setRegionID("");
        request.setId("");
        request.setAccessControlID("");

        CtelbShowAccessControlApi.ShowAccessControlResponse response =
                apis.ctelbShowAccessControlApi.send(credential, request);
        System.out.println(response);
    }
}
