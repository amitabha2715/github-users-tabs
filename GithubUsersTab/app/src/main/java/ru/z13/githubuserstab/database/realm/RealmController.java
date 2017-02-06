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

	public User getUserForId(String id) {

		return realm.where(User.class).equalTo("id", id).findFirst();
	}

	public RealmResults<User> getUsersAH() {

		return realm.where(User.class)
				.beginsWith(User.LOGIN, "a", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "b", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "c", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "d", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "e", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "f", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "g", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "h", Case.INSENSITIVE)
				.findAll();
	}

	public RealmResults<User> getUsersIP() {

		return realm.where(User.class)
				.beginsWith(User.LOGIN, "i", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "j", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "k", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "l", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "m", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "n", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "o", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "p", Case.INSENSITIVE)
				.findAll();
	}

	public RealmResults<User> getUsersQZ() {

		return realm.where(User.class)
				.beginsWith(User.LOGIN, "q", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "r", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "s", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "t", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "u", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "v", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "w", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "x", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "y", Case.INSENSITIVE)
				.or()
				.beginsWith(User.LOGIN, "z", Case.INSENSITIVE)
				.findAll();
	}
}