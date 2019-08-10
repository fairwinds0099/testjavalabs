package webservices;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

abstract class AbstractConnector<T> implements Connector<T> {

    abstract String buildRequestBody(T request) throws JAXBException;

    abstract HttpPost buildPOSTRequest(String bodyPayload, String url) throws UnsupportedEncodingException;

    abstract HttpGet buildGETRequest(String url);

    abstract <R> R handleResponse(R responseObject, String response);


    @Override
    public <R> R post(T requestObject, R responseObject, String url) throws IOException, JAXBException {
        String response = EntityUtils.toString(Connector.super.buildClient()
                .execute(buildPOSTRequest(buildRequestBody(requestObject), url)).getEntity());
        return handleResponse(responseObject, response);
    }

    @Override
    public <R> R get(R responseObject, String url) throws IOException {
        String response = EntityUtils.toString(Connector.super.buildClient()
        .execute(buildGETRequest(url)).getEntity());
        return handleResponse(responseObject, response);
    }
}
