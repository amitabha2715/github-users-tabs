package ru.z13.githubuserstab.database.realm;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmResults;
import ru.z13.githubuserstab.database.realm.model.User;

/**
 * Android Studio
 *
 * @author Yura Fedorchenko (www.android.z-13.ru)
 */
public class RealmController
{
	/**Static members**/
	private static RealmController instance;

	/**Static getters and setters**/

	/**Static methods**/
	public static RealmController with(Fragment fragment) {

		if (instance == null) {
			instance = new RealmController(fragment.getActivity().getApplication());
		}
		return instance;
	}

	public static RealmController with(Activity activity) {

		if (instance == null) {
			instance = new RealmController(activity.getApplication());
		}
		return instance;
	}

	public static RealmController with(Application application) {

		if (instance == null) {
			instance = new RealmController(application);
		}
		return instance;
	}

	public static RealmController getInstance() {

		return instance;
	}

	/**Members**/
	private final Realm realm;
	private String suggestionsText = "";

	/**Getters and setters**/
	public Realm getRealm() {

		return realm;
	}

	/**Constructor**/
	public RealmController(Application application) {
		realm = Realm.getDefaultInstance();
	}

	/**Methods**/
	public void clearUsers() {
		realm.beginTransaction();
		realm.delete(User.class);
		realm.commitTransaction();
	}

	public void createOrUpdateUser(List<User> users){
		realm.beginTransaction();
		realm.copyToRealmOrUpdate(users);
		realm.commitTransaction();
	}

	public void updateUser(User user){
		realm.beginTransaction();
		realm.copyToRealmOrUpdate(user);
		realm.commitTransaction();
	}

	public RealmResults<User> getAllUsers() {

		return realm.where(User.class).findAll();
	}

	public User getUserForId(int id) {

		return realm.where(User.class).equalTo("id", id).findFirst();
	}

	public RealmResults<User> getSuggestions(String text) {
		return realm.where(User.class).contains(User.LOGIN, text, Case.INSENSITIVE).findAll();
	}

	public void setSuggestions(String text) {
		suggestionsText = text;
	}

	public RealmResults<User> getUsersAH() {
		return realm.where(User.class)
				.contains(User.LOGIN, suggestionsText, Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "i", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "j", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "k", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "l", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "m", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "n", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "o", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "p", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "q", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "r", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "s", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "t", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "u", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "v", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "w", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "x", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "y", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "z", Case.INSENSITIVE)
				.findAll();
	}

	public RealmResults<User> getUsersIP() {

		return realm.where(User.class)
				.contains(User.LOGIN, suggestionsText, Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "a", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "b", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "c", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "d", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "e", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "f", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "g", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "h", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "q", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "r", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "s", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "t", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "u", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "v", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "w", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "x", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "y", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "z", Case.INSENSITIVE)
				.findAll();
	}

	public RealmResults<User> getUsersQZ() {

		return realm.where(User.class)
				.contains(User.LOGIN, suggestionsText, Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "a", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "b", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "c", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "d", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "e", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "f", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "g", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "h", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "i", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "j", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "k", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "l", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "m", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "n", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "o", Case.INSENSITIVE)
				.not()
				.beginsWith(User.LOGIN, "p", Case.INSENSITIVE)
				.findAll();
	}
}