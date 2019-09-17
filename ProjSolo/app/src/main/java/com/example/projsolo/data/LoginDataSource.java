package com.example.projsolo.data;

import com.example.projsolo.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            /*
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);
            */
            LoggedInUser senai =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "senai");
            if(password.equals("senai")) return new Result.Success<>(senai);



        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
        return null;
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
