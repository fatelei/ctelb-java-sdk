package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbElbBindLabelsApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbElbBindLabelsApi.ElbBindLabelsRequest request =
                new CtelbElbBindLabelsApi.ElbBindLabelsRequest();
        request.setRegionID("");
        request.setElbID("lb-xxxx");
        request.setLabelKey("aaaaaa");
        request.setLabelValue("aaaaaa");

        CtelbElbBindLabelsApi.ElbBindLabelsResponse response =
                apis.ctelbElbBindLabelsApi.send(credential, request);
        System.out.println(response);
    }
}
