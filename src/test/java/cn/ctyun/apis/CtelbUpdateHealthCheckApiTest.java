package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CtelbUpdateHealthCheckApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbUpdateHealthCheckApi.UpdateHealthCheckRequest request =
                new CtelbUpdateHealthCheckApi.UpdateHealthCheckRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setRegionID("");
        request.setID("");
        request.setHealthCheckID("hc-m2zb05f7s8");
        request.setName("acl11");
        request.setDescription("test");
        request.setTimeout(2);
        request.setMaxRetry(2);
        request.setInterval(5);
        request.setHttpMethod("");
        request.setHttpUrlPath("");
        String request1 = "";
        List<String> request2 = new ArrayList<>();
        request2.add(request1);
        request.setHttpExpectedCodes(request2);

        CtelbUpdateHealthCheckApi.UpdateHealthCheckResponse response =
                apis.ctelbUpdateHealthCheckApi.send(credential, request);
        System.out.println(response);
    }
}
