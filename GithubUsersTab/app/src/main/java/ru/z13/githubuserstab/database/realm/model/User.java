package ru.z13.githubuserstab.database.realm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Android Studio
 *
 * @author Yura Fedorchenko (www.android.z-13.ru)
 */
public class User extends RealmObject
{
	/**Static members**/
	public static final String LOGIN = "login";

	/**Static getters and setters**/

	/**Static methods**/

	/**Members**/
	@PrimaryKey
	private int id;

	@SerializedName("login")
	@Expose
	private String login;

	@SerializedName("avatar_url")
	@Expose
	private String avatarUrl;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("followers")
	@Expose
	private int followers = -1;

	@SerializedName("following")
	@Expose
	private int following = -1;

	/**Getters and setters**/
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public int getFollowing() {
		return following;
	}

	public void setFollowing(int following) {
		this.following = following;
	}

	/**Constructor**/

	/**Methods**/
}