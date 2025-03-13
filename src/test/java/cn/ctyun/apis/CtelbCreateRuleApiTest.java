package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CtelbCreateRuleApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbCreateRuleApi.CreateRuleRequest request = new CtelbCreateRuleApi.CreateRuleRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setRegionID("");
        request.setListenerID("");
        request.setPriority(100);
        CtelbCreateRuleApi.CreateRuleConditionsRequest request1 =
                new CtelbCreateRuleApi.CreateRuleConditionsRequest();
        request1.setType("");
        CtelbCreateRuleApi.CreateRuleConditionsServerNameConfigRequest request2 =
                new CtelbCreateRuleApi.CreateRuleConditionsServerNameConfigRequest();
        request2.setServerName("");
        request1.setServerNameConfig(request2);
        CtelbCreateRuleApi.CreateRuleConditionsUrlPathConfigRequest request3 =
                new CtelbCreateRuleApi.CreateRuleConditionsUrlPathConfigRequest();
        request3.setUrlPaths("");
        request3.setMatchType("");
        request1.setUrlPathConfig(request3);
        List<CtelbCreateRuleApi.CreateRuleConditionsRequest> request4 = new ArrayList<>();
        request4.add(request1);
        request.setConditions(request4);
        CtelbCreateRuleApi.CreateRuleActionRequest request5 =
                new CtelbCreateRuleApi.CreateRuleActionRequest();
        request5.setType("");
        CtelbCreateRuleApi.CreateRuleActionForwardConfigRequest request6 =
                new CtelbCreateRuleApi.CreateRuleActionForwardConfigRequest();
        CtelbCreateRuleApi.CreateRuleActionForwardConfigTargetGroupsRequest request7 =
                new CtelbCreateRuleApi.CreateRuleActionForwardConfigTargetGroupsRequest();
        request7.setTargetGroupID("");
        request7.setWeight(100);
        List<CtelbCreateRuleApi.CreateRuleActionForwardConfigTargetGroupsRequest> request8 =
                new ArrayList<>();
        request8.add(request7);
        request6.setTargetGroups(request8);
        request5.setForwardConfig(request6);
        request5.setRedirectListenerID("");
        request.setAction(request5);

        CtelbCreateRuleApi.CreateRuleResponse response =
                apis.ctelbCreateRuleApi.send(credential, request);
        System.out.println(response);
    }
}
