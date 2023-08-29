import org.json.JSONObject;
import org.json.XML;

public class Converter {

    public static void main(String[] args) {

        String url = "https://www.boredapi.com/api/activity";
        String response = SharedHttpRequest.getRequest(url);

        JSONObject json = new JSONObject(response);

        System.out.println(XML.toString(json));
    }
}
