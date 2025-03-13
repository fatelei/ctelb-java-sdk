package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CtelbRemoveVmApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbRemoveVmApi.RemoveVmRequest request = new CtelbRemoveVmApi.RemoveVmRequest();
        request.setRegionID("81f7728662dd11ec810800155d307d5b");
        request.setTargetGroupID("xxxxxx");
        String request1 = "";
        List<String> request2 = new ArrayList<>();
        request2.add(request1);
        request.setTargetIDs(request2);

        CtelbRemoveVmApi.RemoveVmResponse response =
                apis.ctelbRemoveVmApi.send(credential, request);
        System.out.println(response);
    }
}
