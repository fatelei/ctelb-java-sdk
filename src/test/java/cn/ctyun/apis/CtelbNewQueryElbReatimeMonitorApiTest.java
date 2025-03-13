package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CtelbNewQueryElbReatimeMonitorApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbNewQueryElbReatimeMonitorApi.NewQueryElbReatimeMonitorRequest request =
                new CtelbNewQueryElbReatimeMonitorApi.NewQueryElbReatimeMonitorRequest();
        request.setRegionID("");
        String request1 = "";
        List<String> request2 = new ArrayList<>();
        request2.add(request1);
        request.setDeviceIDs(request2);
        request.setPageNumber(1);
        request.setPageNo(1);
        request.setPageSize(10);

        CtelbNewQueryElbReatimeMonitorApi.NewQueryElbReatimeMonitorResponse response =
                apis.ctelbNewQueryElbReatimeMonitorApi.send(credential, request);
        System.out.println(response);
    }
}
