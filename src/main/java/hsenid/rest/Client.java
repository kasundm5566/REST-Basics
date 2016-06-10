package hsenid.rest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class Client {
	public static void main(String[] args) {
		HttpClient httpClient = HttpClientBuilder.create().build();
		try {
			HttpGet httpGet=new HttpGet("http://localhost:8080/rest-demo/rest/demo/test/test/34");
			HttpResponse httpResponse=httpClient.execute(httpGet);
			HttpEntity httpEntity=httpResponse.getEntity();
			String string=EntityUtils.toString(httpEntity);
			System.out.println(string);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
