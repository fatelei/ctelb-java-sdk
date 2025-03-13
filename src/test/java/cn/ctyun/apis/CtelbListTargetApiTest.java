package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbListTargetApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbListTargetApi.ListTargetRequest request = new CtelbListTargetApi.ListTargetRequest();
        request.setRegionID("");
        request.setTargetGroupID("");
        request.setIDs("target-75ex90k9v0,target-r4cfhgrsss");

        CtelbListTargetApi.ListTargetResponse response =
                apis.ctelbListTargetApi.send(credential, request);
        System.out.println(response);
    }
}
