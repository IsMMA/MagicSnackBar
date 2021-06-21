package com.ismadev.magicsnackbar;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MagicSnackBar {

    private Activity activity;
    private View view;

    private LinearLayout capaNotificacion, capaNotificacionAviso;

    private int duracion = 3000;

    public MagicSnackBar(Activity activity) {
        this.activity = activity;
        this.view = activity.findViewById(android.R.id.content).getRootView();
        capaNotificacion = (LinearLayout) view.findViewById(R.id.capaNotificacion);
        capaNotificacionAviso = (LinearLayout) view.findViewById(R.id.capaNotificacionAviso);
    }

    public void snackBarError(String text) {
        crearSnackBar(text, R.color.red);
    }

    public void snackBar(String text) {
        crearSnackBar(text, R.color.azulNotifiacion);
    }

    private void crearSnackBar(String texto, int color) {
        final int fcolor = color;
        TextView textoNotificacion = (TextView) view.findViewById(R.id.textoNotificacion);

        LinearLayout capaNotificacionPre = this.capaNotificacion;
        if (color == R.color.azulNotifiacion) {
            capaNotificacionPre = capaNotificacionAviso;
            if (textoNotificacion != null) {
                textoNotificacion = (TextView) view.findViewById(R.id.textoNotificacion2);
            }
        }
        final LinearLayout capaUsando = capaNotificacionPre;
        if (capaUsando != null) {
            capaUsando.setVisibility(View.VISIBLE);
        }
        if (textoNotificacion != null) {
            textoNotificacion.setText(texto);
        }
        final Animation apareceNotificacion = AnimationUtils.loadAnimation(activity.getBaseContext(),
                R.anim.down_anim);

        if (capaUsando != null) {
            capaUsando.startAnimation(apareceNotificacion);
        }

        apareceNotificacion.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation arg0) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    //    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(fcolor)));
                    //getWindow().setNavigationBarColor(getResources().getColor(colorActual));
                    activity.getWindow().setStatusBarColor(activity.getBaseContext().getResources().getColor(fcolor));
                }
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Animation desapareceNotificacion = AnimationUtils.loadAnimation(activity.getBaseContext(),
                                R.anim.up_anim);
                        if (capaUsando != null) {
                            capaUsando.startAnimation(desapareceNotificacion);
                        }
                        desapareceNotificacion.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation arg0) {
                            }

                            @Override
                            public void onAnimationRepeat(Animation arg0) {
                            }

                            @Override
                            public void onAnimationEnd(Animation arg0) {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                    //       getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(colorActual2)));
                                    //getWindow().setNavigationBarColor(getResources().getColor(colorActual));
                                    activity.getWindow().setStatusBarColor(activity.getBaseContext().getResources().getColor(R.color.white));
                                }
                                if (capaUsando != null) {
                                    capaUsando.setVisibility(View.GONE);
                                }
                            }
                        });

                    }
                }, duracion);
            }
        });
    }

    public void setDuration(int duracion) {
        this.duracion = duracion;
    }
}
