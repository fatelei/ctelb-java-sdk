package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbUpdateListenerCpsApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbUpdateListenerCpsApi.UpdateListenerCpsRequest request =
                new CtelbUpdateListenerCpsApi.UpdateListenerCpsRequest();
        request.setRegionID("81f7728662dd11ec810800155d307d5b");
        request.setListenerID("listener-2exqi1zcs8");
        request.setListenerCps(1);

        CtelbUpdateListenerCpsApi.UpdateListenerCpsResponse response =
                apis.ctelbUpdateListenerCpsApi.send(credential, request);
        System.out.println(response);
    }
}
