package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbDeleteAccessControlApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbDeleteAccessControlApi.DeleteAccessControlRequest request =
                new CtelbDeleteAccessControlApi.DeleteAccessControlRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setRegionID("");
        request.setID("");
        request.setAccessControlID("");

        CtelbDeleteAccessControlApi.DeleteAccessControlResponse response =
                apis.ctelbDeleteAccessControlApi.send(credential, request);
        System.out.println(response);
    }
}
