package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbShowRuleApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbShowRuleApi.ShowRuleRequest request = new CtelbShowRuleApi.ShowRuleRequest();
        request.setRegionID("");
        request.setID("");
        request.setPolicyID("");

        CtelbShowRuleApi.ShowRuleResponse response =
                apis.ctelbShowRuleApi.send(credential, request);
        System.out.println(response);
    }
}
