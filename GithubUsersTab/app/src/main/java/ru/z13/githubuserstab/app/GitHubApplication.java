package ru.z13.githubuserstab.app;

import android.app.Application;

import io.realm.Realm;

/**
 * Android Studio
 *
 * @author Yura Fedorchenko (www.android.z-13.ru)
 */
public class GitHubApplication extends Application
{
	/**Static members**/

	/**Static getters and setters**/

	/**Static methods**/

	/**Members**/

	/**Getters and setters**/

	/**Constructor**/

	/**Methods**/
	@Override
	public void onCreate()
	{
		super.onCreate();

		Realm.init(this);
	}
}