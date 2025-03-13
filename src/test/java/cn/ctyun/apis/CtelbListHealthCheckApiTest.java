package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CtelbListHealthCheckApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbListHealthCheckApi.ListHealthCheckRequest request =
                new CtelbListHealthCheckApi.ListHealthCheckRequest();
        request.setClientToken("");
        request.setRegionID("");
        String request1 = "";
        List<String> request2 = new ArrayList<>();
        request2.add(request1);
        request.setIDs(request2);
        request.setName("");

        CtelbListHealthCheckApi.ListHealthCheckResponse response =
                apis.ctelbListHealthCheckApi.send(credential, request);
        System.out.println(response);
    }
}
