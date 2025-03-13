package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbGwlbDisableDeleteProtectionApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbGwlbDisableDeleteProtectionApi.GwlbDisableDeleteProtectionRequest request =
                new CtelbGwlbDisableDeleteProtectionApi.GwlbDisableDeleteProtectionRequest();
        request.setRegionID("bb9fdb42056f11eda1610242ac110002");
        request.setGwLbID("");

        CtelbGwlbDisableDeleteProtectionApi.GwlbDisableDeleteProtectionResponse response =
                apis.ctelbGwlbDisableDeleteProtectionApi.send(credential, request);
        System.out.println(response);
    }
}
