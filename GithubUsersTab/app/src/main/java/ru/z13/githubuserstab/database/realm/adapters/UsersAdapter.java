package ru.z13.githubuserstab.database.realm.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import io.realm.Realm;
import ru.z13.githubuserstab.R;
import ru.z13.githubuserstab.database.realm.RealmController;
import ru.z13.githubuserstab.database.realm.model.User;

/**
 * Android Studio
 *
 * @author Yura Fedorchenko (www.android.z-13.ru)
 */
public class UsersAdapter extends RealmRecyclerViewAdapter<User>
{
	/**Static members**/

	/**Static getters and setters**/

	/**Static methods**/

	/**Members**/
	private final Context context;
	private Realm realm;

	/**Getters and setters**/
	@Override
	public int getItemCount()
	{
		if (getRealmAdapter() != null) {
			return getRealmAdapter().getCount();
		}

		return 0;
	}

	/**Constructor**/
	public UsersAdapter(Context context) {

		this.context = context;
	}

	/**Methods**/
	@Override
	public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
		return new UserViewHolder(view);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
	{
		realm = RealmController.getInstance().getRealm();

		final User user = getItem(position);
		final UserViewHolder cardHolder = (UserViewHolder) holder;

		cardHolder.textLogin.setText(user.getLogin());

		if(user.getFollowers() >= 0 && user.getFollowing() >= 0)
		{
			String followText = new StringBuilder().append(user.getFollowers()).append("/").append(user.getFollowing()).toString();

			cardHolder.textFollow.setText(followText);
		}

		if (user.getAvatarUrl() != null) {
			Glide.with(context)
					.load(user.getAvatarUrl().replace("https", "http"))
					.thumbnail(0.5f)
					.crossFade()
					.diskCacheStrategy(DiskCacheStrategy.ALL)
					.fitCenter()
					.into(cardHolder.imageAvatar);
		}
	}

	public static class UserViewHolder extends RecyclerView.ViewHolder {

		public ImageView imageAvatar;
		public TextView textLogin;
		public TextView textFollow;


		public UserViewHolder(View itemView) {
			super(itemView);

			imageAvatar = (ImageView) itemView.findViewById(R.id.image_avatar);
			textLogin = (TextView) itemView.findViewById(R.id.text_login);
			textFollow = (TextView) itemView.findViewById(R.id.text_follow);
		}
	}
}