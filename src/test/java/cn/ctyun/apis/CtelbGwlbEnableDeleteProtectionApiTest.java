package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbGwlbEnableDeleteProtectionApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbGwlbEnableDeleteProtectionApi.GwlbEnableDeleteProtectionRequest request =
                new CtelbGwlbEnableDeleteProtectionApi.GwlbEnableDeleteProtectionRequest();
        request.setRegionID("bb9fdb42056f11eda1610242ac110002");
        request.setGwLbID("");

        CtelbGwlbEnableDeleteProtectionApi.GwlbEnableDeleteProtectionResponse response =
                apis.ctelbGwlbEnableDeleteProtectionApi.send(credential, request);
        System.out.println(response);
    }
}
