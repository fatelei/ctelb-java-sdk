package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbGwlbDeleteApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbGwlbDeleteApi.GwlbDeleteRequest request = new CtelbGwlbDeleteApi.GwlbDeleteRequest();
        request.setRegionID("bb9fdb42056f11eda1610242ac110002");
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setProjectID("");
        request.setGwLbID("");

        CtelbGwlbDeleteApi.GwlbDeleteResponse response =
                apis.ctelbGwlbDeleteApi.send(credential, request);
        System.out.println(response);
    }
}
