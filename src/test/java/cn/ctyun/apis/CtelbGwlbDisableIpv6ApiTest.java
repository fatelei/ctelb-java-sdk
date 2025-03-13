package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbGwlbDisableIpv6ApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbGwlbDisableIpv6Api.GwlbDisableIpv6Request request =
                new CtelbGwlbDisableIpv6Api.GwlbDisableIpv6Request();
        request.setRegionID("bb9fdb42056f11eda1610242ac110002");
        request.setGwLbID("");

        CtelbGwlbDisableIpv6Api.GwlbDisableIpv6Response response =
                apis.ctelbGwlbDisableIpv6Api.send(credential, request);
        System.out.println(response);
    }
}
