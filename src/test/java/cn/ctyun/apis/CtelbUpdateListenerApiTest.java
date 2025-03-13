package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CtelbUpdateListenerApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbUpdateListenerApi.UpdateListenerRequest request =
                new CtelbUpdateListenerApi.UpdateListenerRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setRegionID("");
        request.setID("");
        request.setListenerID("");
        request.setName("acl11");
        request.setDescription("");
        request.setCertificateID("");
        request.setCaEnabled(false);
        request.setClientCertificateID("");
        CtelbUpdateListenerApi.UpdateListenerDefaultActionRequest request1 =
                new CtelbUpdateListenerApi.UpdateListenerDefaultActionRequest();
        request1.setType("");
        CtelbUpdateListenerApi.UpdateListenerDefaultActionForwardConfigRequest request2 =
                new CtelbUpdateListenerApi.UpdateListenerDefaultActionForwardConfigRequest();
        CtelbUpdateListenerApi.UpdateListenerDefaultActionForwardConfigTargetGroupsRequest
                request3 =
                        new CtelbUpdateListenerApi
                                .UpdateListenerDefaultActionForwardConfigTargetGroupsRequest();
        request3.setTargetGroupID("");
        request3.setWeight(100);
        List<CtelbUpdateListenerApi.UpdateListenerDefaultActionForwardConfigTargetGroupsRequest>
                request4 = new ArrayList<>();
        request4.add(request3);
        request2.setTargetGroups(request4);
        List<CtelbUpdateListenerApi.UpdateListenerDefaultActionForwardConfigRequest> request5 =
                new ArrayList<>();
        request5.add(request2);
        request1.setForwardConfig(request5);
        request1.setRedirectListenerID("");
        List<CtelbUpdateListenerApi.UpdateListenerDefaultActionRequest> request6 =
                new ArrayList<>();
        request6.add(request1);
        request.setDefaultAction(request6);
        request.setAccessControlID("");
        request.setAccessControlType("");
        request.setForwardedForEnabled(false);

        CtelbUpdateListenerApi.UpdateListenerResponse response =
                apis.ctelbUpdateListenerApi.send(credential, request);
        System.out.println(response);
    }
}
