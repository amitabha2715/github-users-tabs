package ru.z13.githubuserstab.database.realm.adapters;

import android.support.v7.widget.RecyclerView;

import io.realm.RealmBaseAdapter;
import io.realm.RealmObject;

/**
 * Android Studio
 *
 * @author Yura Fedorchenko (www.android.z-13.ru)
 */
public abstract class RealmRecyclerViewAdapter<T extends RealmObject> extends RecyclerView.Adapter
{
	/**Static members**/

	/**Static getters and setters**/

	/**Static methods**/

	/**Members**/
	private RealmBaseAdapter<T> realmBaseAdapter;

	/**Getters and setters**/
	public T getItem(int position) {

		return realmBaseAdapter.getItem(position);
	}

	public RealmBaseAdapter<T> getRealmAdapter() {

		return realmBaseAdapter;
	}

	public void setRealmAdapter(RealmBaseAdapter<T> realmAdapter) {

		realmBaseAdapter = realmAdapter;
	}

	/**Constructor**/

	/**Methods**/
}