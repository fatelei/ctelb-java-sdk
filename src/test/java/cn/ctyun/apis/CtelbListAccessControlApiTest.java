package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CtelbListAccessControlApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbListAccessControlApi.ListAccessControlRequest request =
                new CtelbListAccessControlApi.ListAccessControlRequest();
        request.setRegionID("");
        String request1 = "";
        List<String> request2 = new ArrayList<>();
        request2.add(request1);
        request.setIDs(request2);
        request.setName("");

        CtelbListAccessControlApi.ListAccessControlResponse response =
                apis.ctelbListAccessControlApi.send(credential, request);
        System.out.println(response);
    }
}
