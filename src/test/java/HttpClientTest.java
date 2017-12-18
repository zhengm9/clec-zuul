import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpHost;
import org.apache.commons.httpclient.methods.PostMethod;

import org.apache.http.conn.params.ConnRouteParams;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by zhengming on 17/6/27.
 */
public class HttpClientTest {

    @Test
    public void doPost() {
        int i = 0;
        while(i < 1000)
        {

            HttpClient client = new HttpClient();
            client.getHostConfiguration().setProxy("47.93.193.1", 3128);


            PostMethod httpPost = new PostMethod("https://110.76.8.25/baoxiangw/gpic/invoiceapply.do");

            httpPost.getParams().setVirtualHost("supergwext.alipay.com");
            try {
                client.executeMethod(httpPost);
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpPost.releaseConnection();
            i++;
        }
    }
}
