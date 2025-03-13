package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbListVmPoolApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbListVmPoolApi.ListVmPoolRequest request = new CtelbListVmPoolApi.ListVmPoolRequest();
        request.setRegionID("81f7728662dd11ec810800155d307d5b");
        request.setTargetGroupID("edbe1a3e-bac3-48a5-9357-d9239d7d1577");
        request.setName("yacos_test_target_group3");

        CtelbListVmPoolApi.ListVmPoolResponse response =
                apis.ctelbListVmPoolApi.send(credential, request);
        System.out.println(response);
    }
}
