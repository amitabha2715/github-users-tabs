package ru.z13.githubuserstab.database.realm.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import io.realm.RealmBaseAdapter;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Android Studio
 *
 * @author Yura Fedorchenko (www.android.z-13.ru)
 */
public class RealmModelAdapter<T extends RealmObject> extends RealmBaseAdapter<T>
{
	/**Static members**/

	/**Static getters and setters**/

	/**Static methods**/

	/**Members**/

	/**Getters and setters**/
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		return null;
	}

	/**Constructor**/
	public RealmModelAdapter(Context context, RealmResults<T> realmResults) {

		super(context, realmResults);
	}

	/**Methods**/
}