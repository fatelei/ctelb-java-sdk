package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbListListenerApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbListListenerApi.ListListenerRequest request =
                new CtelbListListenerApi.ListListenerRequest();
        request.setClientToken("");
        request.setRegionID("");
        request.setProjectID("");
        request.setIDs("'listener-75ex90k9v0,listener-cert-r4cfhgrsss'");
        request.setName("");
        request.setLoadBalancerID("");
        request.setAccessControlID("");

        CtelbListListenerApi.ListListenerResponse response =
                apis.ctelbListListenerApi.send(credential, request);
        System.out.println(response);
    }
}
