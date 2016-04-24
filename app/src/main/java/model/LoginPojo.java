package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sunny PC on 4/21/2016.
 */
public class LoginPojo {

    @SerializedName("username")
    String username;

    @SerializedName("password")
    String password;

    public LoginPojo(String username, String password)
    {
        this.username=username;
        this.password=password;

    }


}
