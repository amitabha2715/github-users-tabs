package ru.z13.githubuserstab.api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Android Studio
 *
 * @author Yura Fedorchenko (www.android.z-13.ru)
 */
public abstract class RetrofitCallback<T> implements Callback<T>
{
	/**Static members**/

	/**Static getters and setters**/

	/**Static methods**/
	@Override
	public void onResponse(Call<T> call, Response<T> response) {
	}

	@Override
	public void onFailure(Call<T> call, Throwable t) {
	}

	/**Members**/

	/**Getters and setters**/

	/**Constructor**/

	/**Methods**/
}