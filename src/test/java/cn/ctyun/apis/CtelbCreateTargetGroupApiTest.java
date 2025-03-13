package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbCreateTargetGroupApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbCreateTargetGroupApi.CreateTargetGroupRequest request =
                new CtelbCreateTargetGroupApi.CreateTargetGroupRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setProtocol("");
        request.setRegionID("");
        request.setName("acl11");
        request.setVpcID("");
        request.setHealthCheckID("");
        request.setAlgorithm("");
        CtelbCreateTargetGroupApi.CreateTargetGroupSessionStickyRequest request1 =
                new CtelbCreateTargetGroupApi.CreateTargetGroupSessionStickyRequest();
        request1.setSessionStickyMode("");
        request1.setCookieExpire(1);
        request1.setRewriteCookieName("test");
        request1.setSourceIpTimeout(1);
        request.setSessionSticky(request1);
        request.setProxyProtocol(0);

        CtelbCreateTargetGroupApi.CreateTargetGroupResponse response =
                apis.ctelbCreateTargetGroupApi.send(credential, request);
        System.out.println(response);
    }
}
