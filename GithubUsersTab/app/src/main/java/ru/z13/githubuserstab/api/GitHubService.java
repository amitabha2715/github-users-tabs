package ru.z13.githubuserstab.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.z13.githubuserstab.database.realm.model.User;

/**
 * Android Studio
 *
 * @author Yura Fedorchenko (www.android.z-13.ru)
 */
public interface GitHubService
{
	@GET("/users")
	Call<List<User>> users();

	@GET("/users/{user}")
	Call<User> user(@Path("user") String user);
}