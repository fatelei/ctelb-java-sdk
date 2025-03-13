package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CtelbAsyncCreateTargetApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbAsyncCreateTargetApi.AsyncCreateTargetRequest request =
                new CtelbAsyncCreateTargetApi.AsyncCreateTargetRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setRegionID("81f7728662dd11ec810800155d307d5b");
        request.setTargetGroupID("xxxxxxxx");
        CtelbAsyncCreateTargetApi.AsyncCreateTargetTargetsRequest request1 =
                new CtelbAsyncCreateTargetApi.AsyncCreateTargetTargetsRequest();
        request1.setInstanceID("xxxxxxxxxx");
        request1.setProtocolPort(80);
        request1.setInstanceType("vm");
        request1.setWeight(1);
        request1.setAddress("192.168.0.1");
        List<CtelbAsyncCreateTargetApi.AsyncCreateTargetTargetsRequest> request2 =
                new ArrayList<>();
        request2.add(request1);
        request.setTargets(request2);

        CtelbAsyncCreateTargetApi.AsyncCreateTargetResponse response =
                apis.ctelbAsyncCreateTargetApi.send(credential, request);
        System.out.println(response);
    }
}
