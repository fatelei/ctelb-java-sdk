package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbListQueryApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbListQueryApi.ListQueryRequest request = new CtelbListQueryApi.ListQueryRequest();
        request.setRegionID("");
        request.setIDs("rule-75ex90k9v0,rule-r4cfhgrsss");
        request.setLoadBalancerID("");

        CtelbListQueryApi.ListQueryResponse response =
                apis.ctelbListQueryApi.send(credential, request);
        System.out.println(response);
    }
}
