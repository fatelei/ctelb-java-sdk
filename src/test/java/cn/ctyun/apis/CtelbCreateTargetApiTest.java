package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbCreateTargetApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbCreateTargetApi.CreateTargetRequest request =
                new CtelbCreateTargetApi.CreateTargetRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setInstanceIP("");
        request.setRegionID("");
        request.setTargetGroupID("");
        request.setInstanceType("");
        request.setInstanceID("");
        request.setProtocolPort(2000);
        request.setWeight(256);

        CtelbCreateTargetApi.CreateTargetResponse response =
                apis.ctelbCreateTargetApi.send(credential, request);
        System.out.println(response);
    }
}
