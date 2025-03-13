package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbQuerySlaApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbQuerySlaApi.QuerySlaRequest request = new CtelbQuerySlaApi.QuerySlaRequest();
        request.setRegionID("");

        CtelbQuerySlaApi.QuerySlaResponse response =
                apis.ctelbQuerySlaApi.send(credential, request);
        System.out.println(response);
    }
}
