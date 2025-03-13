package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbDisableElbIpv6ApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbDisableElbIpv6Api.DisableElbIpv6Request request =
                new CtelbDisableElbIpv6Api.DisableElbIpv6Request();
        request.setRegionID("");
        request.setElbID("");

        CtelbDisableElbIpv6Api.DisableElbIpv6Response response =
                apis.ctelbDisableElbIpv6Api.send(credential, request);
        System.out.println(response);
    }
}
