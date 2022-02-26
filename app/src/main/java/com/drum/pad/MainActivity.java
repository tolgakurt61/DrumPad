package com.drum.pad;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);

		final Button giris = (Button) findViewById(R.id.butongiris);

		final Button hakkimizda = (Button) findViewById(R.id.butonhakkimizda);

		Typeface font;
		font = Typeface.createFromAsset(getResources().getAssets(),
				"ObelixProIt-cyr.ttf");

		giris.setTypeface(font);
		hakkimizda.setTypeface(font);

		giris.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(getApplicationContext(), Dubdis.class);
				startActivity(i);

			}
		});

		hakkimizda.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				AlertDialog.Builder ddDialog = new AlertDialog.Builder(
						MainActivity.this);

				ddDialog.setMessage("Do You Want To Rate App?")
						.setCancelable(false)

						.setPositiveButton("Later",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {

									}
								})
						.setNegativeButton("Yes",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {

										String url = "https://play.google.com/store/apps/details?id=com.dubsstepapp.in";
										Intent i = new Intent(
												Intent.ACTION_VIEW);
										i.setData(Uri.parse(url));
										startActivity(i);
									}
								});

				AlertDialog alert = ddDialog.create();

				alert.show();

			}
		});

	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			onDestroy();
			Intent intent = new Intent(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_HOME);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			finish();
			System.exit(0);
			return true;
		}
		return false;
	}
}