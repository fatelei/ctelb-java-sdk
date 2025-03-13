package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbShowHealthCheckApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbShowHealthCheckApi.ShowHealthCheckRequest request =
                new CtelbShowHealthCheckApi.ShowHealthCheckRequest();
        request.setRegionID("81f7728662dd11ec810800155d307d5b");
        request.setId("");
        request.setHealthCheckID("hc-m2zb05f7s8");

        CtelbShowHealthCheckApi.ShowHealthCheckResponse response =
                apis.ctelbShowHealthCheckApi.send(credential, request);
        System.out.println(response);
    }
}
