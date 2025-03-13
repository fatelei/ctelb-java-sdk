package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbUpdateListenerAttrApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbUpdateListenerAttrApi.UpdateListenerAttrRequest request =
                new CtelbUpdateListenerAttrApi.UpdateListenerAttrRequest();
        request.setRegionID("");
        request.setListenerID("");
        request.setName("acl11");
        request.setDescription("");
        request.setAccessControlID("");
        request.setAccessControlType("");

        CtelbUpdateListenerAttrApi.UpdateListenerAttrResponse response =
                apis.ctelbUpdateListenerAttrApi.send(credential, request);
        System.out.println(response);
    }
}
