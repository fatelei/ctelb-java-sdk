package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbEnableElbIpv6ApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbEnableElbIpv6Api.EnableElbIpv6Request request =
                new CtelbEnableElbIpv6Api.EnableElbIpv6Request();
        request.setRegionID("");
        request.setElbID("");
        request.setIp("");

        CtelbEnableElbIpv6Api.EnableElbIpv6Response response =
                apis.ctelbEnableElbIpv6Api.send(credential, request);
        System.out.println(response);
    }
}
