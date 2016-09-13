package nl.onlyonce.adapter.service.target;

/**
 * @author: Gerben
 */

import com.carerix.api.CREmployeeType;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.util.Base64;

public class SendRequest
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


            CREmployeeType type = new CREmployeeType();
            type.setFirstName("Jan");
            type.setLastName("Jansen");

            String result = TestUtils.convertEmployeeToString(type);

            Content content = Request.Post("https://api.carerix.com/CREmployee")

                    // Add headers
                    .addHeader("Authorization", "Basic " + encoding)
                    .addHeader("Content-Type", "application/xml")


                    // Add body
                    .bodyString(result, ContentType.DEFAULT_TEXT)

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

