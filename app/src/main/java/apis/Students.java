package apis;

import java.util.HashMap;

import model.LoginPojo;
import model.StudentDetail;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.EncodedPath;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Sunny PC on 4/21/2016.
 */
public interface Students {

    @GET("/sunny/{query}")
    public void getStudent(@EncodedPath("query") String user_code, Callback<StudentDetail> response);
@Multipart
    @POST("/corlogin")
    public void loginResult(@Field("username") String username,@Field("password") String password, Callback<String> result);





}
