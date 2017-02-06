package ru.z13.githubuserstab;

import android.util.Log;

public class Tracer
{
	/**Static members**/

	/**Static getters and setters**/

	/**Static methods**/
	public static void print(Object value)
	{
		Log.d("tracer", value.toString());
	}

	public static void e(Object value)
	{
		Log.e("tracer", value.toString());
	}

	/**Members**/

	/**Getters and setters**/

	/**Constructor**/
	public Tracer() {
	}

	/**Methods**/
}
