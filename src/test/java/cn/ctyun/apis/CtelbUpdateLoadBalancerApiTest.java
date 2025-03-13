package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbUpdateLoadBalancerApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbUpdateLoadBalancerApi.UpdateLoadBalancerRequest request =
                new CtelbUpdateLoadBalancerApi.UpdateLoadBalancerRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setRegionID("");
        request.setID("");
        request.setElbID("");
        request.setSlaName("");
        request.setName("acl11");
        request.setDescription("test");
        request.setDeleteProtection(false);

        CtelbUpdateLoadBalancerApi.UpdateLoadBalancerResponse response =
                apis.ctelbUpdateLoadBalancerApi.send(credential, request);
        System.out.println(response);
    }
}
