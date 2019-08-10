package webservices;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import javax.xml.bind.*;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;
import java.io.*;
import java.util.Properties;

public class SOAPConnector<T> extends AbstractConnector<T> {

    private String namespace;
    private String endPoint;

    SOAPConnector() throws IOException {
        this.readFromConfig();
    }
    @Override
    String buildRequestBody(T request) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(request.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        marshaller.marshal(request, sw);
        String body = "<soap:Envelope xmlns:soap=" + namespace + "><soap:Body>" + sw.toString().substring(55) + "</soap:Body></soap:Envelope>";
        return body;
    }

    @Override
    HttpPost buildPOSTRequest(String bodyPayload, String url) throws UnsupportedEncodingException {
        StringEntity stringEntity = new StringEntity(bodyPayload);
        HttpPost httpPost = new HttpPost(endPoint + url);
        httpPost.setHeader("Content-type", "text/xml");
        httpPost.setEntity(stringEntity);
        return httpPost;
    }

    @Override
    HttpGet buildGETRequest(String url) {
        return null;
    }

    @Override
    <R> R handleResponse(R responseObject, String response) {
        R r = null;
        SOAPMessage message;
        try {
            message = MessageFactory.newInstance().createMessage(null, new ByteArrayInputStream(response.getBytes()));
            Unmarshaller unmarshaller = JAXBContext.newInstance(responseObject.getClass()).createUnmarshaller();
            r = (R) unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    private void readFromConfig() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("src/main/resources/soapconnection.properties");
        properties.load(inputStream);
        this.namespace = properties.getProperty("soap.namespace");
        this.endPoint = properties.getProperty("soap.endpoint");
    }
}
