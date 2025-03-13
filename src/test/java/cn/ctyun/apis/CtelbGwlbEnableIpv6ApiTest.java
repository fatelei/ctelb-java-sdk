package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbGwlbEnableIpv6ApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbGwlbEnableIpv6Api.GwlbEnableIpv6Request request =
                new CtelbGwlbEnableIpv6Api.GwlbEnableIpv6Request();
        request.setRegionID("bb9fdb42056f11eda1610242ac110002");
        request.setGwLbID("");

        CtelbGwlbEnableIpv6Api.GwlbEnableIpv6Response response =
                apis.ctelbGwlbEnableIpv6Api.send(credential, request);
        System.out.println(response);
    }
}
