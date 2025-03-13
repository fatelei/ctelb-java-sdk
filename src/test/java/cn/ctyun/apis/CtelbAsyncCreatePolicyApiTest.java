package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CtelbAsyncCreatePolicyApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbAsyncCreatePolicyApi.AsyncCreatePolicyRequest request =
                new CtelbAsyncCreatePolicyApi.AsyncCreatePolicyRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setRegionID("");
        request.setListenerID("");
        request.setName("acl11");
        request.setDescription("test");
        CtelbAsyncCreatePolicyApi.AsyncCreatePolicyConditionsRequest request1 =
                new CtelbAsyncCreatePolicyApi.AsyncCreatePolicyConditionsRequest();
        request1.setRuleType("PATH");
        request1.setMatchType("REGEX");
        request1.setMatchValue("/foo");
        List<CtelbAsyncCreatePolicyApi.AsyncCreatePolicyConditionsRequest> request2 =
                new ArrayList<>();
        request2.add(request1);
        request.setConditions(request2);
        CtelbAsyncCreatePolicyApi.AsyncCreatePolicyTargetGroupRequest request3 =
                new CtelbAsyncCreatePolicyApi.AsyncCreatePolicyTargetGroupRequest();
        request3.setName("test");
        request3.setAlgorithm("rr");
        CtelbAsyncCreatePolicyApi.AsyncCreatePolicyTargetGroupTargetsRequest request4 =
                new CtelbAsyncCreatePolicyApi.AsyncCreatePolicyTargetGroupTargetsRequest();
        request4.setInstanceID("xxxxxxxxxx");
        request4.setProtocolPort(80);
        request4.setInstanceType("vm");
        request4.setWeight(1);
        request4.setAddress("192.168.0.1");
        List<CtelbAsyncCreatePolicyApi.AsyncCreatePolicyTargetGroupTargetsRequest> request5 =
                new ArrayList<>();
        request5.add(request4);
        request3.setTargets(request5);
        CtelbAsyncCreatePolicyApi.AsyncCreatePolicyTargetGroupHealthCheckRequest request6 =
                new CtelbAsyncCreatePolicyApi.AsyncCreatePolicyTargetGroupHealthCheckRequest();
        request6.setProtocol("");
        request6.setTimeout(2);
        request6.setInterval(5);
        request6.setMaxRetry(2);
        request6.setHttpMethod("");
        request6.setHttpUrlPath("/");
        request6.setHttpExpectedCodes("200");
        request3.setHealthCheck(request6);
        CtelbAsyncCreatePolicyApi.AsyncCreatePolicyTargetGroupSessionStickyRequest request7 =
                new CtelbAsyncCreatePolicyApi.AsyncCreatePolicyTargetGroupSessionStickyRequest();
        request7.setCookieName("test");
        request7.setPersistenceTimeout(10000);
        request7.setSessionType("APP_COOKIE");
        request3.setSessionSticky(request7);
        request.setTargetGroup(request3);

        CtelbAsyncCreatePolicyApi.AsyncCreatePolicyResponse response =
                apis.ctelbAsyncCreatePolicyApi.send(credential, request);
        System.out.println(response);
    }
}
