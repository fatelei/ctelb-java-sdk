package cn.ctyun.apis;

import cn.ctyun.sdk.*;
import cn.ctyun.sdk.Credential;
import cn.ctyun.sdk.CtyunClient;
import cn.ctyun.sdk.CtyunRequestException;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CtelbQueryElbHistoryMetricApiTest {
    @Test
    void send() throws CtyunRequestException {
        CtyunClient ctyunClient = CtyunClient.defaultClient();
        Credential credential = new Credential("<YOUR_AK>", "<YOUR_SK>");
        // Credential credential = Credential.credentialFromEnv();
        Apis apis = new Apis("<YOUR_ENDPOINT>", ctyunClient);

        CtelbQueryElbHistoryMetricApi.QueryElbHistoryMetricRequest request =
                new CtelbQueryElbHistoryMetricApi.QueryElbHistoryMetricRequest();
        request.setRegionID("");
        String request1 = "";
        List<String> request2 = new ArrayList<>();
        request2.add(request1);
        request.setDeviceIDs(request2);
        String request3 = "";
        List<String> request4 = new ArrayList<>();
        request4.add(request3);
        request.setMetricNames(request4);
        request.setStartTime("");
        request.setEndTime("");
        request.setPeriod(60);
        request.setPageNumber(1);
        request.setPageNo(1);
        request.setPageSize(10);

        CtelbQueryElbHistoryMetricApi.QueryElbHistoryMetricResponse response =
                apis.ctelbQueryElbHistoryMetricApi.send(credential, request);
        System.out.println(response);
    }
}
