package com.zzptc.sky.netnews.mvp.ui.activities;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zzptc.sky.netnews.R;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.logo_outer_iv)
    ImageView logoOut;
    @BindView(R.id.logo_inner_iv)
    ImageView logoInner;
    @BindView(R.id.app_name_tv)
    TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        initAnimation();

        finishActivity();
    }

    /**
     * 初始化欢迎界面的所有动画操作
     */
    private void initAnimation(){
        startLogoInnerAnim();
        startAppNameAnim();
    }

    /**
     * 开始内部图标的动画
     */
    private void startLogoInnerAnim(){
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.top_in);
        animatorSet.setTarget(logoInner);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.start();
    }

    /**
     * 开始文字的显示动画
     */
    private void startAppNameAnim(){
        Animator animator = AnimatorInflater.loadAnimator(this,R.animator.fade_in);
        animator.setTarget(appName);
        animator.start();
    }

    /**
     * 跳转到主界面
     */
    private void finishActivity(){
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        startActivity(new Intent(SplashActivity.this,NewsActivity.class));
                        overridePendingTransition(0,android.R.anim.fade_out);
                        finish();
                    }
                });
    }
}
