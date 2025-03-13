package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbGwlbUpdateTargetGroupApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbGwlbUpdateTargetGroupApi.GwlbUpdateTargetGroupRequest request =
                new CtelbGwlbUpdateTargetGroupApi.GwlbUpdateTargetGroupRequest();
        request.setRegionID("bb9fdb42056f11eda1610242ac110002");
        request.setTargetGroupID("tg-xxx");
        request.setName("acl11");
        request.setHealthCheckID("hc-xxxx");
        request.setSessionStickyMode(0);
        request.setFailoverType(0);
        request.setBypassType(0);

        CtelbGwlbUpdateTargetGroupApi.GwlbUpdateTargetGroupResponse response =
                apis.ctelbGwlbUpdateTargetGroupApi.send(credential, request);
        System.out.println(response);
    }
}
