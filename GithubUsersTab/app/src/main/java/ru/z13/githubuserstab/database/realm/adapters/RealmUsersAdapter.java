package ru.z13.githubuserstab.database.realm.adapters;

import android.content.Context;

import io.realm.RealmResults;
import ru.z13.githubuserstab.database.realm.model.User;

/**
 * Android Studio
 *
 * @author Yura Fedorchenko (www.android.z-13.ru)
 */
public class RealmUsersAdapter extends RealmModelAdapter<User> {

	/**Static members**/

	/**Static getters and setters**/

	/**Static methods**/

	/**Members**/

	/**Getters and setters**/

	/**Constructor**/
	public RealmUsersAdapter(Context context, RealmResults<User> realmResults) {

		super(context, realmResults);
	}

	/**Methods**/
}