package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

class CtelbCreatePgelbApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbCreatePgelbApi.CreatePgelbRequest request =
                new CtelbCreatePgelbApi.CreatePgelbRequest();
        request.setClientToken("79fa97e3-c48b-xxxx-9f46-6a13d8163678");
        request.setRegionID("");
        request.setProjectID("0");
        request.setVpcID("");
        request.setSubnetID("");
        request.setName("acl11");
        request.setEipID("");
        request.setSlaName("elb.s2.small");
        request.setResourceType("internal");
        request.setPrivateIpAddress("");
        request.setCycleType("month");
        request.setCycleCount(1);
        request.setPayVoucherPrice("1");

        CtelbCreatePgelbApi.CreatePgelbResponse response =
                apis.ctelbCreatePgelbApi.send(credential, request);
        System.out.println(response);
    }
}
