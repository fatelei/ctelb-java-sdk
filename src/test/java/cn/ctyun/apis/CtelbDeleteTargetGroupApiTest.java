package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbDeleteTargetGroupApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbDeleteTargetGroupApi.DeleteTargetGroupRequest request =
                new CtelbDeleteTargetGroupApi.DeleteTargetGroupRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setRegionID("81f7728662dd11ec810800155d307d5b");
        request.setID("");
        request.setTargetGroupID("tg-vzedsj8s49");

        CtelbDeleteTargetGroupApi.DeleteTargetGroupResponse response =
                apis.ctelbDeleteTargetGroupApi.send(credential, request);
        System.out.println(response);
    }
}
