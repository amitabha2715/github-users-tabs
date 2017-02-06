package ru.z13.githubuserstab;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.android.common.view.SlidingTabLayout;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.realm.Realm;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import ru.z13.githubuserstab.api.ApiFactory;
import ru.z13.githubuserstab.api.GitHubService;
import ru.z13.githubuserstab.api.RetrofitCallback;
import ru.z13.githubuserstab.database.realm.RealmController;
import ru.z13.githubuserstab.database.realm.model.User;
import ru.z13.githubuserstab.enums.FragmentEnums;
import ru.z13.githubuserstab.fragments.UserListFragment;

public class MainActivity extends AppCompatActivity
{
	private ViewPager viewPager;
	private SlidingTabLayout tabLayout;
	private PagerAdapter pagerAdapter;
	private GitHubService githubService;
	private List<User> users;
	private ProgressDialog progressDialog;
	private UserListFragment ahFragment;
	private UserListFragment ipFragment;
	private UserListFragment qzFragment;
	private Realm realm;
	private boolean isFirstStart = true;

	static class Error {
		String message;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		realm = RealmController.with(this).getRealm();
		if(!realm.isEmpty()) isFirstStart = false;

		tabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
		tabLayout.setSelectedIndicatorColors(Color.WHITE);
		tabLayout.setDistributeEvenly(true);

		viewPager = (ViewPager) findViewById(R.id.pager);

		progressDialog = new ProgressDialog(this);
		progressDialog.setMessage(getString(R.string.loading));
		progressDialog.setCancelable(false);

		initTabs();

		loadGitHubUsers();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		realm.close();
	}

	private void initTabs()
	{
		ahFragment = new UserListFragment();
		ahFragment.setType(FragmentEnums.A_H);

		ipFragment = new UserListFragment();
		ipFragment.setType(FragmentEnums.I_P);

		qzFragment = new UserListFragment();
		qzFragment.setType(FragmentEnums.Q_Z);

		pagerAdapter = new PagerAdapter(getSupportFragmentManager(), FragmentEnums.TABS);
		viewPager.setAdapter(pagerAdapter);

		tabLayout.setViewPager(viewPager);
	}

	private void loadGitHubUsers()
	{
		if(isFirstStart) progressDialog.show();

		githubService = ApiFactory.getGitHubService();
		Call<List<User>> call = githubService.users();
		call.enqueue(new Callback<List<User>>(){

			@Override
			public void onResponse(Call<List<User>> call, Response<List<User>> response)
			{
				Tracer.print("onResponse | loadGitHubUsers");

				closeProgressDialog();

				if (response.isSuccessful()) {
					users = response.body();

					if (users.size() > 0) {
						saveUsersDB();
						loadFollowers();
					}

				}else{
					Converter<ResponseBody, Error> errorConverter = ApiFactory.getGitHubRetrofit().responseBodyConverter(Error.class, new Annotation[0]);

					try
					{
						Error error = errorConverter.convert(response.errorBody());

						if(isFirstStart) {
							showConnectionAlert(error.message);
						}else{
							showSnackbar(error.message, getResources().getString(R.string.btn_refresh), new View.OnClickListener() {
								@Override
								public void onClick(View view) {
									loadGitHubUsers();
								}
							});
						}
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}

			@Override
			public void onFailure(Call<List<User>> call, Throwable t)
			{
				Tracer.print("onFailure | onFailure");

				closeProgressDialog();

				if(isFirstStart) {
					showConnectionAlert(t.getMessage());
				}else{
					showSnackbar(t.getMessage(), getResources().getString(R.string.btn_refresh), new View.OnClickListener() {
						@Override
						public void onClick(View view) {
							loadGitHubUsers();
						}
					});
				}
			}
		});
	}

	private void saveUsersDB(){
		Collections.sort(users, new Comparator<User>() {
			@Override
			public int compare(final User user1, final User user2) {
				return user1.getLogin().toLowerCase().compareTo(user2.getLogin().toLowerCase());
			}
		});

		RealmController.with(this).clearUsers();
		RealmController.with(this).createOrUpdateUser(users);
	}

	private void loadFollowers()
	{
		for(User user : users)
		{
			loadUserData(user.getLogin());
		}

	}

	private void loadUserData(String username)
	{
		Call<User> call = githubService.user(username);
		call.enqueue(new RetrofitCallback<User>() {
			@Override
			public void onResponse(Call<User> call, Response<User> response) {
				if (response.isSuccessful()) {
					User user = response.body();

					RealmController.with(getApplication()).updateUser(user);
				} else {

				}
			}
		});
	}

	private void closeProgressDialog(){
		if(progressDialog != null && progressDialog.isShowing()) progressDialog.dismiss();
	}

	private void showSnackbar(String title, String btnText, View.OnClickListener onClickListener)
	{
		Snackbar snackbar = Snackbar.make(tabLayout, title, Snackbar.LENGTH_LONG).setAction(btnText, onClickListener);
		snackbar.show();
	}

	private void showConnectionAlert(String message)
	{
		final DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()
		{
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				if (which == DialogInterface.BUTTON_POSITIVE)
				{
					loadGitHubUsers();
				}
			}
		};

		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.error_no_connection_title);
		builder.setMessage(message);
		builder.setCancelable(false);
		builder.setPositiveButton(R.string.btn_refresh, listener);
		builder.show();
	}

	private class PagerAdapter extends FragmentStatePagerAdapter
	{
		private List<String> tabTypes;

		@Override
		public int getCount()
		{
			return tabTypes.size();
		}

		@Override
		public CharSequence getPageTitle(int position)
		{
			return tabTypes.get(position);
		}

		@Override
		public android.support.v4.app.Fragment getItem(int i)
		{
			switch (tabTypes.get(i))
			{
				case FragmentEnums.A_H:
					return ahFragment;

				case FragmentEnums.I_P:
					return ipFragment;

				default:
					return qzFragment;
			}
		}

		public PagerAdapter(FragmentManager fm, List<String> tabTypes)
		{
			super(fm);
			this.tabTypes = tabTypes;
		}
	}
}
