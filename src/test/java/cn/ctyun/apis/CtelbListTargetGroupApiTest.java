package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbListTargetGroupApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbListTargetGroupApi.ListTargetGroupRequest request =
                new CtelbListTargetGroupApi.ListTargetGroupRequest();
        request.setClientToken("");
        request.setRegionID("");
        request.setIDs("tg-75ex90k9v0,tg-r4cfhgrsss");
        request.setVpcID("");
        request.setHealthCheckID("");
        request.setName("");

        CtelbListTargetGroupApi.ListTargetGroupResponse response =
                apis.ctelbListTargetGroupApi.send(credential, request);
        System.out.println(response);
    }
}
