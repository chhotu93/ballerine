package com.qa.opencart.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateWorkFlowApi {

  @Test
  public void login() throws InterruptedException {
    long timestamp = System.currentTimeMillis();
    // Convert the timestamp to a string
    String timestampString = Long.toString(timestamp);
    System.out.println(timestampString);
    String jsonString =
        "{\n"
            + "    \"workflowId\": \"kyb_dynamic_ui_session_example\",\n"
            + "    \"context\": {\n"
            + "        \"entity\": {\n"
            + "            \"id\": \"my-user-"
            + timestampString
            + "\",\n"
            + "            \"data\": {\n"
            + "                \"companyName\": \"Dudi Inc\",\n"
            + "                \"additionalInfo\": {\n"
            + "                    \"mainRepresentative\": {\n"
            + "                        \"firstName\": \"Ben\",\n"
            + "                        \"lastName\": \"Dude\",\n"
            + "                        \"email\": \"testballe123@getnada.com\"\n"
            + "                    }\n"
            + "                }\n"
            + "            },\n"
            + "            \"type\": \"business\"\n"
            + "        },\n"
            + "        \"documents\": []\n"
            + "    },\n"
            + "    \"config\": {\n"
            + "        \"subscriptions\": [\n"
            + "            {\n"
            + "                \"type\": \"webhook\",\n"
            + "                \"url\": \"https://webhook.site/2af50189-9e14-445a-8a78-0ec6e2d07d52\",\n"
            + "                \"events\": [\n"
            + "                    \"workflow.completed\"\n"
            + "                ]\n"
            + "            }\n"
            + "        ]\n"
            + "    }\n"
            + "}";

    RequestSpecification request = RestAssured.given();
    request.baseUri("https://api-sb.eu.ballerine.app/api/v1/external/workflows/run");
    request.contentType(ContentType.JSON);
    request.header("Authorization", "Bearer " + "Clips-zaSyClzfrQciR9lv7qa12");
    request.header("Cookie", "session=e30=; session.sig=kvoQbZU-NBPi8iKVE5cflXaCA74");
    request.body(jsonString);
    Response response = request.post();
    String ResponseVariable = response.asString();
    System.out.println("Response as String Format is\t" + ResponseVariable);

    String CreateTwe = response.asString();
    JsonPath js1 = new JsonPath(CreateTwe);

    // Get Validatable response to perform validation
    ValidatableResponse validatableResponse = response.then();
    validatableResponse.statusCode(200);
    //    System.out.println("validatableResponse: " + response.getStatusCode());
    //    System.out.println("id is" + js1.get("userName"));
    String refreshToken = js1.get("ballerineEntityId");
    System.out.println(refreshToken);
  }
}
