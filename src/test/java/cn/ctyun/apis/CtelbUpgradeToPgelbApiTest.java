package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbUpgradeToPgelbApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbUpgradeToPgelbApi.UpgradeToPgelbRequest request =
                new CtelbUpgradeToPgelbApi.UpgradeToPgelbRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setRegionID("");
        request.setElbID("lb-xxxx");
        request.setSlaName("elb.s2.small");
        request.setCycleType("month");
        request.setCycleCount(1);

        CtelbUpgradeToPgelbApi.UpgradeToPgelbResponse response =
                apis.ctelbUpgradeToPgelbApi.send(credential, request);
        System.out.println(response);
    }
}
