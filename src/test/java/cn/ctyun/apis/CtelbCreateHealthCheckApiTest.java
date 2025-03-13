package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CtelbCreateHealthCheckApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbCreateHealthCheckApi.CreateHealthCheckRequest request =
                new CtelbCreateHealthCheckApi.CreateHealthCheckRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setRegionID("");
        request.setName("acl11");
        request.setDescription("");
        request.setProtocol("");
        request.setTimeout(2);
        request.setInterval(5);
        request.setMaxRetry(2);
        request.setHttpMethod("");
        request.setHttpUrlPath("");
        String request1 = "";
        List<String> request2 = new ArrayList<>();
        request2.add(request1);
        request.setHttpExpectedCodes(request2);
        request.setProtocolPort(0);

        CtelbCreateHealthCheckApi.CreateHealthCheckResponse response =
                apis.ctelbCreateHealthCheckApi.send(credential, request);
        System.out.println(response);
    }
}
