package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbListElbLabelsApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbListElbLabelsApi.ListElbLabelsRequest request =
                new CtelbListElbLabelsApi.ListElbLabelsRequest();
        request.setRegionID("81f7728662dd11ec810800155d307d5b");
        request.setElbID("lb-xxxx");
        request.setPageNo(1);
        request.setPageSize(10);

        CtelbListElbLabelsApi.ListElbLabelsResponse response =
                apis.ctelbListElbLabelsApi.send(credential, request);
        System.out.println(response);
    }
}
