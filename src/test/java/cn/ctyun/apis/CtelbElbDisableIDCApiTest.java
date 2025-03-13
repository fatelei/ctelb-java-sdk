package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbElbDisableIDCApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbElbDisableIDCApi.ElbDisableIDCRequest request =
                new CtelbElbDisableIDCApi.ElbDisableIDCRequest();
        request.setRegionID("");
        request.setVpcID("");

        CtelbElbDisableIDCApi.ElbDisableIDCResponse response =
                apis.ctelbElbDisableIDCApi.send(credential, request);
        System.out.println(response);
    }
}
