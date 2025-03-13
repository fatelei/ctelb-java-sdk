package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbIplistenerUpdateApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbIplistenerUpdateApi.IplistenerUpdateRequest request =
                new CtelbIplistenerUpdateApi.IplistenerUpdateRequest();
        request.setRegionID("bb9fdb42056f11eda1610242ac110002");
        request.setIpListenerID("");
        request.setName("acl11");
        request.setTargetGroupID("");
        request.setWeight(0);

        CtelbIplistenerUpdateApi.IplistenerUpdateResponse response =
                apis.ctelbIplistenerUpdateApi.send(credential, request);
        System.out.println(response);
    }
}
