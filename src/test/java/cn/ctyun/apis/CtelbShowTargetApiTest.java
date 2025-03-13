package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbShowTargetApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbShowTargetApi.ShowTargetRequest request = new CtelbShowTargetApi.ShowTargetRequest();
        request.setRegionID("");
        request.setID("");
        request.setTargetID("");

        CtelbShowTargetApi.ShowTargetResponse response =
                apis.ctelbShowTargetApi.send(credential, request);
        System.out.println(response);
    }
}
