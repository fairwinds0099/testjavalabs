package webservices;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface Connector<T> {

    static<T> Connector<T> of (Class<T> clss, boolean isRest) throws IOException {
        if(isRest) {
            return new RESTConnector<>();
        } else {
            return new SOAPConnector<>();
        }
    }

    default CloseableHttpClient buildClient() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        return httpClient;
    }

    <R> R post(T requestObject, R responseObject, String url) throws IOException, JAXBException;

    <R> R get(R responseObject, String url) throws IOException;



}
