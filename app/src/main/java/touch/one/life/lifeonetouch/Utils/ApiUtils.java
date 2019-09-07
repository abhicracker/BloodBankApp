package touch.one.life.lifeonetouch.Utils;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://yoururl.com/welcome/";
    //Example : public static final String BASE_URL = "http://abhisarkate.in/welcome/";
    //welcome/ in URL is a Controller name DO NOT REMOVE  welcome.

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
