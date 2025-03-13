package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbIplistenerCreateApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbIplistenerCreateApi.IplistenerCreateRequest request =
                new CtelbIplistenerCreateApi.IplistenerCreateRequest();
        request.setRegionID("bb9fdb42056f11eda1610242ac110002");
        request.setGwLbID("");
        request.setName("acl11");
        CtelbIplistenerCreateApi.IplistenerCreateActionRequest request1 =
                new CtelbIplistenerCreateApi.IplistenerCreateActionRequest();
        request1.setType("forward");
        request.setAction(request1);

        CtelbIplistenerCreateApi.IplistenerCreateResponse response =
                apis.ctelbIplistenerCreateApi.send(credential, request);
        System.out.println(response);
    }
}
