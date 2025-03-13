package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CtelbUpdateVmPoolAttrApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbUpdateVmPoolAttrApi.UpdateVmPoolAttrRequest request =
                new CtelbUpdateVmPoolAttrApi.UpdateVmPoolAttrRequest();
        request.setRegionID("");
        request.setTargetGroupID("");
        request.setName("acl11");
        CtelbUpdateVmPoolAttrApi.UpdateVmPoolAttrHealthCheckRequest request1 =
                new CtelbUpdateVmPoolAttrApi.UpdateVmPoolAttrHealthCheckRequest();
        request1.setProtocol("");
        request1.setTimeout(2);
        request1.setInterval(5);
        request1.setMaxRetry(2);
        request1.setHttpMethod("");
        request1.setHttpUrlPath("/");
        request1.setHttpExpectedCodes("200");
        List<CtelbUpdateVmPoolAttrApi.UpdateVmPoolAttrHealthCheckRequest> request2 =
                new ArrayList<>();
        request2.add(request1);
        request.setHealthCheck(request2);
        CtelbUpdateVmPoolAttrApi.UpdateVmPoolAttrSessionStickyRequest request3 =
                new CtelbUpdateVmPoolAttrApi.UpdateVmPoolAttrSessionStickyRequest();
        request3.setCookieName("test");
        request3.setPersistenceTimeout(10000);
        request3.setSessionType("APP_COOKIE");
        List<CtelbUpdateVmPoolAttrApi.UpdateVmPoolAttrSessionStickyRequest> request4 =
                new ArrayList<>();
        request4.add(request3);
        request.setSessionSticky(request4);

        CtelbUpdateVmPoolAttrApi.UpdateVmPoolAttrResponse response =
                apis.ctelbUpdateVmPoolAttrApi.send(credential, request);
        System.out.println(response);
    }
}
