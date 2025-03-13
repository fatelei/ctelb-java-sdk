package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbShowTargetGroupApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbShowTargetGroupApi.ShowTargetGroupRequest request =
                new CtelbShowTargetGroupApi.ShowTargetGroupRequest();
        request.setRegionID("");
        request.setID("");
        request.setTargetGroupID("tg-vzedsj8s49");

        CtelbShowTargetGroupApi.ShowTargetGroupResponse response =
                apis.ctelbShowTargetGroupApi.send(credential, request);
        System.out.println(response);
    }
}
