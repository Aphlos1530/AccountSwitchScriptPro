package lang;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;
public class Translator {
    public static void main(String[] args) throws Exception {
        String text = "Hello, how are you?";
        String apiKey = "your_api_key_here";

        apiKey="x9wAZmZAteFecOp5SdJGswjUMMOcwSyN";

        String langFrom = "en";
        String langTo = "zh-CHS";
        String urlStr = "https://openapi.youdao.com/api?q=" + URLEncoder.encode(text, "UTF-8") + "&from=" + langFrom + "&to=" + langTo + "&appKey=" + apiKey + "&salt=1&sign=your_sign_here";
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String output;
        String result = "";
        while ((output = br.readLine()) != null) {
            result += output;
        }
        conn.disconnect();
        JSONObject json = new JSONObject(result);
        JSONArray translations = json.getJSONArray("translation");
        String translatedText = translations.getString(0);
        System.out.println(translatedText);
    }
}