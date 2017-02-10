package ru.z13.githubuserstab.database.realm.adapters;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.TextView;

/**
 * Android Studio
 *
 * @author Yura Fedorchenko (www.android.z-13.ru)
 */
public class SuggestionSimpleCursorAdapter extends SimpleCursorAdapter
{
	/**Static members**/

	/**Static getters and setters**/

	/**Static methods**/

	/**Members**/

	/**Getters and setters**/

	/**Constructor**/
	public SuggestionSimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
		super(context, layout, c, from, to, flags);
	}

	/**Methods**/
	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		super.bindView(view, context, cursor);

		TextView textView = (TextView) view.findViewById(android.R.id.text1);
		textView.setTextColor(Color.BLACK);

		view.setBackgroundColor(Color.WHITE);
	}
}