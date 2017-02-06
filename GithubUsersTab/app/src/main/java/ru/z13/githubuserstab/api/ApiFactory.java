package ru.z13.githubuserstab.api;

import android.support.annotation.NonNull;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import io.realm.RealmObject;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.z13.githubuserstab.api.enums.ApiEnums;

/**
 * Android Studio
 *
 * @author Yura Fedorchenko (www.android.z-13.ru)
 */
public class ApiFactory
{
	/**Static members**/
	private static final int TIMEOUT = 60;
	private static final int WRITE_TIMEOUT = 120;
	private static final int CONNECT_TIMEOUT = 10;

	private static OkHttpClient sClient;

	/**Static getters and setters**/
	@NonNull
	private static OkHttpClient getClient() {
		OkHttpClient client = sClient;
		if (client == null) {
			synchronized (ApiFactory.class) {
				client = sClient;
				if (client == null) {
					client = sClient = buildClient();
				}
			}
		}
		return client;
	}

	@NonNull
	public static Retrofit getGitHubRetrofit() {
		return buildRetrofit(ApiEnums.API_GITHUB_ENDPOINT);
	}

	@NonNull
	public static GitHubService getGitHubService() {
		return buildRetrofit(ApiEnums.API_GITHUB_ENDPOINT).create(GitHubService.class);
	}

	/**Static methods**/
	@NonNull
	private static Retrofit buildRetrofit(String baseUrl) {
		return new Retrofit.Builder()
				.baseUrl(baseUrl)
				.client(getClient())
				.addConverterFactory(GsonConverterFactory.create())
				.build();
	}

	@NonNull
	private static OkHttpClient buildClient() {
		return new OkHttpClient.Builder()
				.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
				.readTimeout(TIMEOUT, TimeUnit.SECONDS)
				.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
				.addInterceptor(new HttpLoggingInterceptor())
				.build();
	}

	/**Members**/

	/**Getters and setters**/

	/**Constructor**/

	/**Methods**/
}