package ru.z13.githubuserstab.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import ru.z13.githubuserstab.R;
import ru.z13.githubuserstab.database.realm.RealmController;
import ru.z13.githubuserstab.database.realm.adapters.RealmUsersAdapter;
import ru.z13.githubuserstab.database.realm.adapters.UsersAdapter;
import ru.z13.githubuserstab.database.realm.model.User;
import ru.z13.githubuserstab.enums.FragmentEnums;

/**
 * Android Studio
 *
 * @author Yura Fedorchenko (www.android.z-13.ru)
 */
public class UserListFragment extends Fragment
{
	/**Static members**/

	/**Static getters and setters**/

	/**Static methods**/

	/**Members**/
	private RecyclerView recyclerView;
	private UsersAdapter adapter;
	private Realm realm;
	private String type;

	/**Getters and setters**/
	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	/**Constructor**/

	/**Methods**/
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.fragment_userlist, container, false);

		recyclerView = (RecyclerView) v.findViewById(R.id.main_list);

		final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
		layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		recyclerView.setLayoutManager(layoutManager);

		adapter = new UsersAdapter(getActivity());
		recyclerView.setAdapter(adapter);

		realm = RealmController.with(this).getRealm();
		RealmResults<User> users = null;
		switch (type)
		{
			case FragmentEnums.A_H:
				users = RealmController.with(this).getUsersAH();
				break;

			case FragmentEnums.I_P:
				users = RealmController.with(this).getUsersIP();
				break;

			case FragmentEnums.Q_Z:
				users = RealmController.with(this).getUsersQZ();
				break;
		}

		users.addChangeListener(callback);
		RealmUsersAdapter realmAdapter = new RealmUsersAdapter(getActivity(), users);

		adapter.setRealmAdapter(realmAdapter);
		adapter.notifyDataSetChanged();

		return v;
	}

	private RealmChangeListener callback = new RealmChangeListener() {
		@Override
		public void onChange(Object element)
		{
			if(adapter != null)
			{
				adapter.notifyDataSetChanged();
			}
		}
	};


}