package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbUpdateTargetApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbUpdateTargetApi.UpdateTargetRequest request =
                new CtelbUpdateTargetApi.UpdateTargetRequest();
        request.setRegionID("");
        request.setID("");
        request.setTargetID("");
        request.setProtocolPort(80);
        request.setWeight(100);

        CtelbUpdateTargetApi.UpdateTargetResponse response =
                apis.ctelbUpdateTargetApi.send(credential, request);
        System.out.println(response);
    }
}
