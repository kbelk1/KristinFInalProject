package kristinfinalproject.aleademo;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationActivity extends BaseActivity {

    @BindView(R.id.anim_tv)
    TextView tv;


    @BindView(R.id.anim_tv3)
    TextView tv3;

    private Animation alphaAnimation;
    private Animation rotateAnimation;
    private Animation scaleAnimation;
    private Animation setAnimation;
    private Animation transAnimation;


    @OnClick(R.id.anim_alpha)
    public void alpha(){
    tv.startAnimation(alphaAnimation);
        tv3.startAnimation(alphaAnimation);
    }

    @OnClick(R.id.anim_rotate)
    public void rotate() {
    tv.startAnimation(rotateAnimation);
        tv3.startAnimation(rotateAnimation);
    }
    @OnClick(R.id.anim_scale)
    public void scale(){
        tv.startAnimation(scaleAnimation);
        tv3.startAnimation(scaleAnimation);
    }
    @OnClick(R.id.anim_set)
    public void set(){
        tv.startAnimation(setAnimation);
        tv3.startAnimation(setAnimation);
    }
    @OnClick(R.id.anim_trans)
    public void trans(){
        tv.startAnimation(transAnimation);
        tv3.startAnimation(transAnimation);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
        initialAnimation();


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastShort("Click");
            }
        });


        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastShort("Click");
            }
        });

    }
private void initialAnimation(){
    alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
    rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
    scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
    setAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
    transAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_trans);
}
}

