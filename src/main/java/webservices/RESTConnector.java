package webservices;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

public class RESTConnector<T> extends AbstractConnector<T> {

    @Override
    String buildRequestBody(T request) {
        return null;
    }

    @Override
    HttpPost buildPOSTRequest(String bodyPayload, String url) {
        return null;
    }

    @Override
    HttpGet buildGETRequest(String url) {
        return null;
    }

    @Override
    <R> R handleResponse(R responseObject, String response) {
        return null;
    }
}
