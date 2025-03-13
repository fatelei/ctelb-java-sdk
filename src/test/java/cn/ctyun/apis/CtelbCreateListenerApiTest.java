package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CtelbCreateListenerApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbCreateListenerApi.CreateListenerRequest request =
                new CtelbCreateListenerApi.CreateListenerRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setRegionID("");
        request.setLoadBalancerID("");
        request.setName("acl11");
        request.setDescription("");
        request.setProtocol("");
        request.setProtocolPort(8080);
        request.setCertificateID("");
        request.setCaEnabled(false);
        request.setClientCertificateID("");
        CtelbCreateListenerApi.CreateListenerDefaultActionRequest request1 =
                new CtelbCreateListenerApi.CreateListenerDefaultActionRequest();
        request1.setType("");
        CtelbCreateListenerApi.CreateListenerDefaultActionForwardConfigRequest request2 =
                new CtelbCreateListenerApi.CreateListenerDefaultActionForwardConfigRequest();
        CtelbCreateListenerApi.CreateListenerDefaultActionForwardConfigTargetGroupsRequest
                request3 =
                        new CtelbCreateListenerApi
                                .CreateListenerDefaultActionForwardConfigTargetGroupsRequest();
        request3.setTargetGroupID("");
        request3.setWeight(100);
        List<CtelbCreateListenerApi.CreateListenerDefaultActionForwardConfigTargetGroupsRequest>
                request4 = new ArrayList<>();
        request4.add(request3);
        request2.setTargetGroups(request4);
        request1.setForwardConfig(request2);
        request1.setRedirectListenerID("");
        request.setDefaultAction(request1);
        request.setAccessControlID("");
        request.setAccessControlType("");
        request.setForwardedForEnabled(true);

        CtelbCreateListenerApi.CreateListenerResponse response =
                apis.ctelbCreateListenerApi.send(credential, request);
        System.out.println(response);
    }
}
