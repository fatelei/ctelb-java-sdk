package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbRenewPgelbApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbRenewPgelbApi.RenewPgelbRequest request = new CtelbRenewPgelbApi.RenewPgelbRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setRegionID("");
        request.setElbID("lb-xxxx");
        request.setCycleType("month");
        request.setCycleCount(1);
        request.setPayVoucherPrice("1");

        CtelbRenewPgelbApi.RenewPgelbResponse response =
                apis.ctelbRenewPgelbApi.send(credential, request);
        System.out.println(response);
    }
}
