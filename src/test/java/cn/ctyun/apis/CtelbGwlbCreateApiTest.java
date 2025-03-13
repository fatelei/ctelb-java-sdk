package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbGwlbCreateApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbGwlbCreateApi.GwlbCreateRequest request = new CtelbGwlbCreateApi.GwlbCreateRequest();
        request.setRegionID("81f7728662dd11ec810800155d307d5b");
        request.setClientToken("");
        request.setProjectID("");
        request.setSubnetID("");
        request.setName("acl11");
        request.setPrivateIpAddress("");
        request.setIpv6Address("");
        request.setDeleteProtection(false);
        request.setIpv6Enabled(false);
        request.setCycleType("on_demand");
        request.setPayVoucherPrice("");

        CtelbGwlbCreateApi.GwlbCreateResponse response =
                apis.ctelbGwlbCreateApi.send(credential, request);
        System.out.println(response);
    }
}
