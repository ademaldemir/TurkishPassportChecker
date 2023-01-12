package org.ademaldemir;

import com.squareup.okhttp.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/soap+xml; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n  <soap12:Body>\n    <TCKimlikNoDogrula xmlns=\"http://tckimlik.nvi.gov.tr/WS\">\n      <TCKimlikNo>1234567890</TCKimlikNo>\n      <Ad>Elon</Ad>\n      <Soyad>Musk</Soyad>\n      <DogumYili>1971</DogumYili>\n    </TCKimlikNoDogrula>\n  </soap12:Body>\n</soap12:Envelope>");
        Request request = new Request.Builder()
                .url("https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx")
                .method("POST", body)
                .addHeader("Content-Type", "application/soap+xml; charset=utf-8")
                .addHeader("Cookie", "TS0193588c=01e4b3044213d997cd0ce94d8189eac405a4afcc3ea4b2802bf9d6d3adb2d07e8d8f64d0ec1e37ac3ec4df4facd457cb9127a36394")
                .build();
        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }
}