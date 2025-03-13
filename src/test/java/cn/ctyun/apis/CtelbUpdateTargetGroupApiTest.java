package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbUpdateTargetGroupApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbUpdateTargetGroupApi.UpdateTargetGroupRequest request =
                new CtelbUpdateTargetGroupApi.UpdateTargetGroupRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setRegionID("");
        request.setProjectID("");
        request.setID("");
        request.setTargetGroupID("tg-vzedsj8s49");
        request.setName("acl11");
        request.setHealthCheckID("");
        request.setAlgorithm("");
        request.setProxyProtocol(0);
        CtelbUpdateTargetGroupApi.UpdateTargetGroupSessionStickyRequest request1 =
                new CtelbUpdateTargetGroupApi.UpdateTargetGroupSessionStickyRequest();
        request1.setSessionStickyMode("");
        request1.setCookieExpire(1);
        request1.setRewriteCookieName("");
        request1.setSourceIpTimeout(10);
        request.setSessionSticky(request1);
        request.setProtocol("");

        CtelbUpdateTargetGroupApi.UpdateTargetGroupResponse response =
                apis.ctelbUpdateTargetGroupApi.send(credential, request);
        System.out.println(response);
    }
}
