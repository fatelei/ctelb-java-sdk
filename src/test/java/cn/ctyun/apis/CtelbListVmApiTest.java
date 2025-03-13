package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbListVmApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbListVmApi.ListVmRequest request = new CtelbListVmApi.ListVmRequest();
        request.setRegionID("81f7728662dd11ec810800155d307d5b");
        request.setTargetGroupID("xxxxx");
        request.setLoadBalanceID("xxxx");
        request.setQueryContent("query");

        CtelbListVmApi.ListVmResponse response = apis.ctelbListVmApi.send(credential, request);
        System.out.println(response);
    }
}
