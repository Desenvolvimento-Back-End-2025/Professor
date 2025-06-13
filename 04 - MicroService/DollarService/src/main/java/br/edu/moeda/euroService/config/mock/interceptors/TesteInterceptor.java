package br.edu.moeda.euroService.config.mock.interceptors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class TesteInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                        ClientHttpRequestExecution execution)
            throws IOException {
        System.out.println(request.getURI().getPath());
        if (request.getURI().getPath().contains("/teste")){
            return new ClientHttpResponse() {
                @Override
                public HttpStatusCode getStatusCode() throws IOException {
                    return HttpStatus.OK;
                }

                @Override
                public String getStatusText() throws IOException {
                    return "OK";
                }

                @Override
                public void close() {

                }

                @Override
                public InputStream getBody() throws IOException {
                    return new ByteArrayInputStream("200".getBytes());
                }

                @Override
                public HttpHeaders getHeaders() {
                    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
                    headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
                    return new HttpHeaders(headers);
                }
            };
        }
        return null;
    }
}
