package nl.onlyonce.adapter.service.api;

import com.carerix.api.CREmployee;
import lombok.extern.java.Log;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.springframework.stereotype.Service;

import java.util.Base64;

import static nl.onlyonce.adapter.AppConfig.CARERIX_TOKEN;
import static nl.onlyonce.adapter.AppConfig.CARERIX_USERNAME;

/**
 * @author: Gerben
 */

@Service
@Log
public class CarerixApiServiceImpl implements CarerixApiService {

    @Override
    public void addEmployee(CREmployee employee) {

        try {
            postRequest(CarerixApiConfiguration.Endpoints.CREMPLOYEE, CarerixModelHelper.convertEmployee(employee));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void postRequest(String endPoint, String data) throws Exception {

        Request.Post(CarerixApiConfiguration.DOMAIN + endPoint)
                .addHeader("Authorization", "Basic " + getAuthorization())
                .addHeader("Content-Type", "application/xml")
                .bodyString(data, ContentType.DEFAULT_TEXT)
                .execute().returnContent();

    }

    private String getAuthorization(){
        String authString = CARERIX_USERNAME + ":" + CARERIX_TOKEN;
        return new String(Base64.getEncoder().encode(authString.getBytes()));

    }

    @Override
    public void getEmployee() {

    }

    @Override
    public void updateEmployee() {

    }
}
