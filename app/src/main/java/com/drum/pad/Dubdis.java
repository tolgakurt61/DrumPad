package com.drum.pad;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class Dubdis extends Activity implements ActionListener {

	String durum = "0";

	private AdView adView;

	private InterstitialAd interstitialAd;
	private static final String AD_UNIT_ID = "ca-app-pub-6027750153735611/9509322927";


	private int adscount=0;

	private MediaPlayer mediaPlayer;
	// AlertDialog levelDialog;


	AlertDialog levelDialoggg;

	private MediaPlayer mp, tog2, tog3, mb1, mb2, mb3, mb4, mb5, mb6, mb7, mb8,
			mb9,mb10,mb11,mb12;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.dubdis);




		adView = (AdView) this.findViewById(R.id.adView);
		AdRequest adRequest2 = new AdRequest.Builder()
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				.addTestDevice("TEST_DEVICE_ID").build();
		adView.loadAd(adRequest2);

		interstitialAd = new InterstitialAd(this);
		interstitialAd.setAdUnitId(AD_UNIT_ID);

		// Check the logcat output for your hashed device ID to get test ads on
		// a physical device.
		AdRequest adRequest = new AdRequest.Builder()
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				.addTestDevice("INSERT_YOUR_HASHED_DEVICE_ID_HERE").build();

		// Load the interstitial ad.
		interstitialAd.loadAd(adRequest);

		// Set the AdListener.

		interstitialAd.setAdListener(new AdListener() {
			public void onAdLoaded() {
				Log.d("", "onAdLoaded");
				// Toast.makeText(YoutubePlay.this, "onAdLoaded",
				// Toast.LENGTH_SHORT).show();
				if (interstitialAd.isLoaded()) {
					interstitialAd.show();
				} else {
					Log.d("here",
							"Interstitial ad was not ready to be shown.");
				}

			}
		});

		final Button b15 = (Button) findViewById(R.id.Button15);
		final Button b16 = (Button) findViewById(R.id.Button16);
		final Button b17 = (Button) findViewById(R.id.Button17);

		final ToggleButton tgbutton = (ToggleButton) findViewById(R.id.toggleButton1);
		final ToggleButton tgbutton2 = (ToggleButton) findViewById(R.id.toggleButton2);
		final ToggleButton tgbutton3 = (ToggleButton) findViewById(R.id.toggleButton3);
		final Button b4 = (Button) findViewById(R.id.button4);
		final Button b8 = (Button) findViewById(R.id.button8);
		final Button b9 = (Button) findViewById(R.id.button9);

		final Button b5 = (Button) findViewById(R.id.button5);
		final Button b6 = (Button) findViewById(R.id.button6);
		final Button b7 = (Button) findViewById(R.id.button7);






		final Animation mAnimation = new AlphaAnimation(1, 0);
		mAnimation.setDuration(1000);
		mAnimation.setInterpolator(new LinearInterpolator());
		mAnimation.setRepeatCount(Animation.INFINITE);
		mAnimation.setRepeatMode(Animation.REVERSE);

		final Animation mAnimation2 = new AlphaAnimation(1, 0);
		mAnimation2.setDuration(33);
		mAnimation2.setInterpolator(new LinearInterpolator());
		mAnimation2.setRepeatCount(Animation.INFINITE);
		mAnimation2.setRepeatMode(Animation.REVERSE);

		tgbutton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View view) {
				// TODO Auto-generated method stub
				if (tgbutton.isChecked()) {

					tgbutton.setBackgroundResource(R.drawable.ustbas);

					mp = MediaPlayer.create(getBaseContext(), R.raw.s1);
					mp.start();
					mp.setLooping(true);
				} else {

					tgbutton.setBackgroundResource(R.drawable.ust);
					stopPlaying();
					view.clearAnimation();

					adscount++;

					if(adscount%20 ==0) {

						reklamcagir();
					}
					// Toast.makeText(activity, &quot;OFF&quot;,
					// Toast.LENGTH_SHORT).show();
				}
			}
		});

		tgbutton2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View view) {
				// TODO Auto-generated method stub
				if (tgbutton2.isChecked()) {

					tgbutton2.setBackgroundResource(R.drawable.ustbas);

					tog2 = MediaPlayer.create(getBaseContext(), R.raw.s9);
					tog2.start();
					tog2.setLooping(true);
				} else {
					tgbutton2.setBackgroundResource(R.drawable.ust);
					stopPlaying2();
					view.clearAnimation();
					// Toast.makeText(activity, &quot;OFF&quot;,
					// Toast.LENGTH_SHORT).show();

					adscount++;

					if(adscount%20 ==0) {

						reklamcagir();
					}
				}
			}
		});

		tgbutton3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View view) {
				// TODO Auto-generated method stub
				if (tgbutton3.isChecked()) {

					tgbutton3.setBackgroundResource(R.drawable.ustbas);
					tog3 = MediaPlayer.create(getBaseContext(), R.raw.s3);
					tog3.start();
					tog3.setLooping(true);
				} else {

					adscount++;

					if(adscount%20 ==0) {

						reklamcagir();
					}

					tgbutton3.setBackgroundResource(R.drawable.ust);
					stopPlaying3();
					view.clearAnimation();
					// Toast.makeText(activity, &quot;OFF&quot;,
					// Toast.LENGTH_SHORT).show();
				}
			}
		});
		b4.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(final View view, MotionEvent event) {
				// TODO Auto-generated method stub

				if (event.getAction() == MotionEvent.ACTION_DOWN) {

					// cal.setBackgroundResource(R.drawable.ic_launcher);

					try {
						// butontikla.prepare();

						b4.setBackgroundResource(R.drawable.ortabas);

						mb4 = MediaPlayer.create(Dubdis.this, R.raw.s4);
						mb4.start();
						mb4.setLooping(true);

					} catch (IllegalStateException e) {

						e.printStackTrace();
					}

				}

				if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						b4.setBackgroundResource(R.drawable.orta);
						// cal.setBackgroundResource(R.drawable.ic_launcher);
						stopmb4();

						adscount++;

						if(adscount%20 ==0) {

							reklamcagir();
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

				return false;
			}

		});

		b5.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(final View view, MotionEvent event) {
				// TODO Auto-generated method stub

				if (event.getAction() == MotionEvent.ACTION_DOWN) {

					// cal.setBackgroundResource(R.drawable.ic_launcher);

					try {
						// butontikla.prepare();

						b5.setBackgroundResource(R.drawable.ortabas);
						mb5 = MediaPlayer.create(Dubdis.this, R.raw.s5);
						mb5.start();
						mb5.setLooping(true);

					} catch (IllegalStateException e) {

						e.printStackTrace();
					}

				}

				if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						b5.setBackgroundResource(R.drawable.orta);
						// cal.setBackgroundResource(R.drawable.ic_launcher);
						stopmb5();

						adscount++;

						if(adscount%20 ==0) {

							reklamcagir();
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

				return false;
			}

		});

		b6.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(final View view, MotionEvent event) {
				// TODO Auto-generated method stub

				if (event.getAction() == MotionEvent.ACTION_DOWN) {

					// cal.setBackgroundResource(R.drawable.ic_launcher);

					try {
						// butontikla.prepare();

						b6.setBackgroundResource(R.drawable.ortabas);

						mb6 = MediaPlayer.create(Dubdis.this, R.raw.s6);
						mb6.start();
						mb6.setLooping(true);

					} catch (IllegalStateException e) {

						e.printStackTrace();
					}

				}

				if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						b6.setBackgroundResource(R.drawable.orta);
						// cal.setBackgroundResource(R.drawable.ic_launcher);
						stopmb6(); adscount++;

						if(adscount%20 ==0) {

							reklamcagir();
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

				return false;
			}

		});

		b7.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(final View view, MotionEvent event) {
				// TODO Auto-generated method stub

				if (event.getAction() == MotionEvent.ACTION_DOWN) {

					// cal.setBackgroundResource(R.drawable.ic_launcher);

					try {
						// butontikla.prepare();

						b7.setBackgroundResource(R.drawable.ortabas);

						mb7 = MediaPlayer.create(Dubdis.this, R.raw.s7);
						mb7.start();
						mb7.setLooping(true);

					} catch (IllegalStateException e) {

						e.printStackTrace();
					}

					// mb3.setOnCompletionListener(new OnCompletionListener() {
					//
					// public void onCompletion(MediaPlayer mp) {
					// mp.release();
					//
					// }
					// });

				}

				if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						b7.setBackgroundResource(R.drawable.orta);
						// cal.setBackgroundResource(R.drawable.ic_launcher);
						stopmb7(); adscount++;

						if(adscount%20 ==0) {

							reklamcagir();
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

				return false;
			}

		});

		b8.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(final View view, MotionEvent event) {
				// TODO Auto-generated method stub

				if (event.getAction() == MotionEvent.ACTION_DOWN) {

					// cal.setBackgroundResource(R.drawable.ic_launcher);

					try {
						// butontikla.prepare();

						b8.setBackgroundResource(R.drawable.ortabas);

						mb8 = MediaPlayer.create(Dubdis.this, R.raw.s16);
						mb8.start();
						mb8.setLooping(true);

					} catch (IllegalStateException e) {

						e.printStackTrace();
					}

				}

				if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						b8.setBackgroundResource(R.drawable.orta);
						// cal.setBackgroundResource(R.drawable.ic_launcher);
						stopmb8(); adscount++;

						if(adscount%20 ==0) {

							reklamcagir();
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

				return false;
			}

		});

		b9.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(final View view, MotionEvent event) {
				// TODO Auto-generated method stub

				if (event.getAction() == MotionEvent.ACTION_DOWN) {

					// cal.setBackgroundResource(R.drawable.ic_launcher);

					try {
						// butontikla.prepare();

						b9.setBackgroundResource(R.drawable.ortabas);

						mb9 = MediaPlayer.create(Dubdis.this, R.raw.m6);
						mb9.start();
						mb9.setLooping(true);

					} catch (IllegalStateException e) {

						e.printStackTrace();
					}

				}

				if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						b9.setBackgroundResource(R.drawable.orta);
						// cal.setBackgroundResource(R.drawable.ic_launcher);
						stopmb9(); adscount++;

						if(adscount%20 ==0) {

							reklamcagir();
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

				return false;
			}

		});

		b15.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(final View view, MotionEvent event) {
				// TODO Auto-generated method stub

				if (event.getAction() == MotionEvent.ACTION_DOWN) {

					// cal.setBackgroundResource(R.drawable.ic_launcher);

					try {
						// butontikla.prepare();

						b15.setBackgroundResource(R.drawable.altbas);

						mb10 = MediaPlayer.create(Dubdis.this, R.raw.m4);
						mb10.start();
						mb10.setLooping(true);

					} catch (IllegalStateException e) {

						e.printStackTrace();
					}

				}

				if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						b15.setBackgroundResource(R.drawable.alt);
						// cal.setBackgroundResource(R.drawable.ic_launcher);
						stopmb10(); adscount++;

						if(adscount%20 ==0) {

							reklamcagir();
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

				return false;

			}

		});

		b16.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(final View view, MotionEvent event) {
				// TODO Auto-generated method stub

				if (event.getAction() == MotionEvent.ACTION_DOWN) {

					// cal.setBackgroundResource(R.drawable.ic_launcher);

					try {
						// butontikla.prepare();

						b16.setBackgroundResource(R.drawable.altbas);

						mb11 = MediaPlayer.create(Dubdis.this, R.raw.m2);
						mb11.start();
						mb11.setLooping(true);

					} catch (IllegalStateException e) {

						e.printStackTrace();
					}

				}

				if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						b16.setBackgroundResource(R.drawable.alt);
						// cal.setBackgroundResource(R.drawable.ic_launcher);
						stopmb11(); adscount++;

						if(adscount%20 ==0) {

							reklamcagir();
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

				return false;

			}
		});

		b17.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(final View view, MotionEvent event) {
				// TODO Auto-generated method stub

				if (event.getAction() == MotionEvent.ACTION_DOWN) {

					// cal.setBackgroundResource(R.drawable.ic_launcher);

					try {
						// butontikla.prepare();

						b17.setBackgroundResource(R.drawable.altbas);

						mb12 = MediaPlayer.create(Dubdis.this, R.raw.e_1);
						mb12.start();
						mb12.setLooping(true);

					} catch (IllegalStateException e) {

						e.printStackTrace();
					}

				}

				if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						b17.setBackgroundResource(R.drawable.alt);
						// cal.setBackgroundResource(R.drawable.ic_launcher);
						stopmb12(); adscount++;

						if(adscount%20 ==0) {

							reklamcagir();
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

				return false;
			}
		});

	}

	private void stopPlaying() {
		if (mp != null) {
			mp.stop();
			mp.release();
			mp = null;
		}
	}

	private void stopPlaying2() {
		if (tog2 != null) {
			tog2.stop();
			tog2.release();
			tog2 = null;
		}
	}

	private void stopPlaying3() {
		if (tog3 != null) {
			tog3.stop();
			tog3.release();
			tog3 = null;
		}
	}

	private void stopmb1() {
		if (mb1 != null) {
			mb1.stop();
			mb1.release();
			mb1 = null;
		}
	}

	private void stopmb2() {
		if (mb2 != null) {
			mb2.stop();
			mb2.release();
			mb2 = null;
		}
	}

	private void stopmb3() {
		if (mb3 != null) {
			mb3.stop();
			mb3.release();
			mb3 = null;
		}
	}

	private void stopmb4() {
		if (mb4 != null) {
			mb4.stop();
			mb4.release();
			mb4 = null;
		}
	}

	private void stopmb5() {
		if (mb5 != null) {
			mb5.stop();
			mb5.release();
			mb5 = null;
		}
	}

	private void stopmb6() {
		if (mb6 != null) {
			mb6.stop();
			mb6.release();
			mb6 = null;
		}
	}

	private void stopmb7() {
		if (mb7 != null) {
			mb7.stop();
			mb7.release();
			mb7 = null;
		}
	}

	private void stopmb8() {
		if (mb8 != null) {
			mb8.stop();
			mb8.release();
			mb8 = null;
		}
	}

	private void stopmb9() {
		if (mb9 != null) {
			mb9.stop();
			mb9.release();
			mb9 = null;
		}
	}


	private void stopmb10() {
		if (mb10 != null) {
			mb10.stop();
			mb10.release();
			mb10 = null;
		}
	}

	private void stopmb11() {
		if (mb11 != null) {
			mb11.stop();
			mb11.release();
			mb11 = null;
		}
	}


	private void stopmb12() {
		if (mb12 != null) {
			mb12.stop();
			mb12.release();
			mb12 = null;
		}
	}


	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			AlertDialog.Builder ddDialog = new AlertDialog.Builder(Dubdis.this);

			ddDialog.setMessage("Do You Want To Exit ?");
			ddDialog.setTitle("Exit");

			LinearLayout layout = new LinearLayout(Dubdis.this);
			layout.setOrientation(LinearLayout.VERTICAL);
			ddDialog.setView(layout);

			ddDialog.setPositiveButton("Exit",
					new DialogInterface.OnClickListener() {
						// do something when the button is clicked
						public void onClick(DialogInterface arg0, int arg1) {

							try {

								mp.release();
								tog3.release();
								tog2.release();

							} catch (Exception e) {
								// TODO: handle exception
							}

							finish();

						}
					});

			ddDialog.setNegativeButton("No",
					new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub

						}
					});
			ddDialog.show();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onSuccess() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFailure(int reason) {
		// TODO Auto-generated method stub

	}

	public void reklamcagir() {


		interstitialAd = new InterstitialAd(this);
		interstitialAd.setAdUnitId(AD_UNIT_ID);

		// Check the logcat output for your hashed device ID to get test ads on
		// a physical device.
		AdRequest adRequest = new AdRequest.Builder()
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				.addTestDevice("INSERT_YOUR_HASHED_DEVICE_ID_HERE").build();

		// Load the interstitial ad.
		interstitialAd.loadAd(adRequest);

		// Set the AdListener.

		interstitialAd.setAdListener(new AdListener() {
			public void onAdLoaded() {
				Log.d("", "onAdLoaded");
				// Toast.makeText(YoutubePlay.this, "onAdLoaded",
				// Toast.LENGTH_SHORT).show();
				if (interstitialAd.isLoaded()) {
					interstitialAd.show();
				} else {
					Log.d("here",
							"Interstitial ad was not ready to be shown.");
				}

			}
		});

	}

}
