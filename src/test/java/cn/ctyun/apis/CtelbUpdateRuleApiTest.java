package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CtelbUpdateRuleApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbUpdateRuleApi.UpdateRuleRequest request = new CtelbUpdateRuleApi.UpdateRuleRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setRegionID("");
        request.setID("");
        request.setPolicyID("");
        request.setPriority(100);
        CtelbUpdateRuleApi.UpdateRuleConditionsRequest request1 =
                new CtelbUpdateRuleApi.UpdateRuleConditionsRequest();
        request1.setType("");
        CtelbUpdateRuleApi.UpdateRuleConditionsServerNameConfigRequest request2 =
                new CtelbUpdateRuleApi.UpdateRuleConditionsServerNameConfigRequest();
        request2.setServerName("");
        request1.setServerNameConfig(request2);
        CtelbUpdateRuleApi.UpdateRuleConditionsUrlPathConfigRequest request3 =
                new CtelbUpdateRuleApi.UpdateRuleConditionsUrlPathConfigRequest();
        request3.setUrlPaths("");
        request3.setMatchType("");
        request1.setUrlPathConfig(request3);
        List<CtelbUpdateRuleApi.UpdateRuleConditionsRequest> request4 = new ArrayList<>();
        request4.add(request1);
        request.setConditions(request4);
        CtelbUpdateRuleApi.UpdateRuleActionRequest request5 =
                new CtelbUpdateRuleApi.UpdateRuleActionRequest();
        request5.setType("");
        CtelbUpdateRuleApi.UpdateRuleActionForwardConfigRequest request6 =
                new CtelbUpdateRuleApi.UpdateRuleActionForwardConfigRequest();
        CtelbUpdateRuleApi.UpdateRuleActionForwardConfigTargetGroupsRequest request7 =
                new CtelbUpdateRuleApi.UpdateRuleActionForwardConfigTargetGroupsRequest();
        request7.setTargetGroupID("");
        request7.setWeight(100);
        List<CtelbUpdateRuleApi.UpdateRuleActionForwardConfigTargetGroupsRequest> request8 =
                new ArrayList<>();
        request8.add(request7);
        request6.setTargetGroups(request8);
        request5.setForwardConfig(request6);
        request5.setRedirectListenerID("");
        request.setAction(request5);

        CtelbUpdateRuleApi.UpdateRuleResponse response =
                apis.ctelbUpdateRuleApi.send(credential, request);
        System.out.println(response);
    }
}
