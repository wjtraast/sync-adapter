package nl.onlyonce.adapter.service.target;

/**
 * @author: Gerben
 */

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.Base64;

public class SearchEmployeeRequest
{
    public static void main(String[] args) {
        sendRequest();
    }

    private static void sendRequest() {

        // Add Employee (POST )

        try {

            // Create request

            String encoding  = new String(Base64.getEncoder().encode("publictest:31cc110c197021804e37fcd58c9e5844a64fb964013e4496".getBytes()));
            System.out.println(" ##### enconding " + encoding);

            Content content = Request.Get("https://api.carerix.com/CREmployee?qualifier=notes%3D%27%5Bcardid%3D12124125%5D%27")
                    // Add headers
                    .addHeader("Authorization", "Basic " + encoding)
                    .addHeader("Content-Type", "application/xml")

                    // Fetch request and return content
                    .execute().returnContent();

            // Print content
            System.out.println(content);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}

