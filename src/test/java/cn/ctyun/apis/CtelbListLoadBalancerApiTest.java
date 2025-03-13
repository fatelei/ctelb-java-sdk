package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbListLoadBalancerApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbListLoadBalancerApi.ListLoadBalancerRequest request =
                new CtelbListLoadBalancerApi.ListLoadBalancerRequest();
        request.setRegionID("");
        request.setIDs("lb-75ex90k9v0,lb-r4cfhgrsss");
        request.setResourceType("");
        request.setName("");
        request.setSubnetID("");

        CtelbListLoadBalancerApi.ListLoadBalancerResponse response =
                apis.ctelbListLoadBalancerApi.send(credential, request);
        System.out.println(response);
    }
}
