package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CtelbAsyncCreateListenerApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbAsyncCreateListenerApi.AsyncCreateListenerRequest request =
                new CtelbAsyncCreateListenerApi.AsyncCreateListenerRequest();
        request.setClientToken("");
        request.setRegionID("");
        request.setLoadBalanceID("");
        request.setName("acl11");
        request.setDescription("");
        request.setProtocol("");
        request.setProtocolPort(8080);
        request.setCertificateID("");
        request.setCaEnabled(false);
        request.setClientCertificateID("");
        CtelbAsyncCreateListenerApi.AsyncCreateListenerTargetGroupRequest request1 =
                new CtelbAsyncCreateListenerApi.AsyncCreateListenerTargetGroupRequest();
        request1.setName("test");
        request1.setAlgorithm("rr");
        CtelbAsyncCreateListenerApi.AsyncCreateListenerTargetGroupTargetsRequest request2 =
                new CtelbAsyncCreateListenerApi.AsyncCreateListenerTargetGroupTargetsRequest();
        request2.setInstanceID("xxxxxxxxxx");
        request2.setProtocolPort(80);
        request2.setInstanceType("vm");
        request2.setWeight(1);
        request2.setAddress("192.168.0.1");
        List<CtelbAsyncCreateListenerApi.AsyncCreateListenerTargetGroupTargetsRequest> request3 =
                new ArrayList<>();
        request3.add(request2);
        request1.setTargets(request3);
        CtelbAsyncCreateListenerApi.AsyncCreateListenerTargetGroupHealthCheckRequest request4 =
                new CtelbAsyncCreateListenerApi.AsyncCreateListenerTargetGroupHealthCheckRequest();
        request4.setProtocol("");
        request4.setTimeout(2);
        request4.setInterval(5);
        request4.setMaxRetry(2);
        request4.setHttpMethod("");
        request4.setHttpUrlPath("/");
        request4.setHttpExpectedCodes("200");
        request1.setHealthCheck(request4);
        CtelbAsyncCreateListenerApi.AsyncCreateListenerTargetGroupSessionStickyRequest request5 =
                new CtelbAsyncCreateListenerApi
                        .AsyncCreateListenerTargetGroupSessionStickyRequest();
        request5.setSessionType("APP_COOKIE");
        request5.setCookieName("test");
        request5.setPersistenceTimeout(10000);
        request1.setSessionSticky(request5);
        request.setTargetGroup(request1);
        request.setAccessControlID("");
        request.setAccessControlType("");
        request.setForwardedForEnabled(true);

        CtelbAsyncCreateListenerApi.AsyncCreateListenerResponse response =
                apis.ctelbAsyncCreateListenerApi.send(credential, request);
        System.out.println(response);
    }
}
