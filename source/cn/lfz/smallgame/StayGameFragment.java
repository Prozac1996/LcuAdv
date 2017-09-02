package cn.lfz.smallgame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import java.io.Serializable;
import java.util.Random;

public class StayGameFragment extends Fragment
  implements Serializable
{
  public static final String STAY_GAME_TAG = "stay_game";
  int birdNum = 0;
  private Context context;
  private Display display;
  private DisplayMetrics dm;
  private Button left;
  int note = 1;
  private ImageView person;
  private RelativeLayout piao;
  private Button right;
  private Button start_button;
  private FrameLayout start_view;
  private LinearLayout stay_game_view;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dm = new DisplayMetrics();
    this.display = getActivity().getWindowManager().getDefaultDisplay();
    this.display.getMetrics(this.dm);
    this.context = getActivity();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903045, paramViewGroup, false);
    this.start_button = ((Button)localView.findViewById(2131165221));
    this.stay_game_view = ((LinearLayout)localView.findViewById(2131165214));
    this.start_view = ((FrameLayout)localView.findViewById(2131165220));
    this.left = ((Button)localView.findViewById(2131165217));
    this.right = ((Button)localView.findViewById(2131165218));
    this.person = ((ImageView)localView.findViewById(2131165216));
    this.piao = ((RelativeLayout)localView.findViewById(2131165215));
    this.left.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        StayGameFragment localStayGameFragment = StayGameFragment.this;
        localStayGameFragment.note = (-2 + localStayGameFragment.note);
        return true;
      }
    });
    this.right.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        StayGameFragment localStayGameFragment = StayGameFragment.this;
        localStayGameFragment.note = (2 + localStayGameFragment.note);
        return true;
      }
    });
    final ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 90.0F });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      private void createBird(final ValueAnimator paramAnonymousValueAnimator, Random paramAnonymousRandom)
      {
        final ImageView localImageView = new ImageView(StayGameFragment.this.getActivity());
        localImageView.setImageResource(2130837505);
        localImageView.setPadding(paramAnonymousRandom.nextInt(StayGameFragment.this.piao.getWidth()), 0, 0, 0);
        StayGameFragment.this.piao.addView(localImageView);
        int i = paramAnonymousRandom.nextInt(4);
        if (i == 0)
          i = 1;
        float[] arrayOfFloat = new float[2];
        arrayOfFloat[0] = 0.0F;
        arrayOfFloat[1] = StayGameFragment.this.piao.getHeight();
        final ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localImageView, "translationY", arrayOfFloat).setDuration(i * 3000);
        localObjectAnimator.addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            super.onAnimationEnd(paramAnonymous2Animator);
            if (paramAnonymousValueAnimator.isRunning())
              StayGameFragment.3.this.gameOver(paramAnonymousValueAnimator);
          }

          @SuppressLint({"NewApi"})
          public void onAnimationPause(Animator paramAnonymous2Animator)
          {
            super.onAnimationPause(paramAnonymous2Animator);
          }
        });
        localImageView.setOnTouchListener(new View.OnTouchListener()
        {
          @SuppressLint({"NewApi"})
          public boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
          {
            localObjectAnimator.pause();
            StayGameFragment localStayGameFragment = StayGameFragment.this;
            localStayGameFragment.birdNum = (-1 + localStayGameFragment.birdNum);
            localImageView.setImageResource(2130837506);
            return true;
          }
        });
        localObjectAnimator.start();
      }

      private void gameOver(ValueAnimator paramAnonymousValueAnimator)
      {
        paramAnonymousValueAnimator.cancel();
        StayGameFragment.this.piao.removeAllViews();
        Toast.makeText(StayGameFragment.this.context, "Game Over", 0).show();
      }

      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        Random localRandom = new Random();
        if ((localRandom.nextInt(100) < 1) && (StayGameFragment.this.birdNum < 3))
        {
          StayGameFragment localStayGameFragment3 = StayGameFragment.this;
          localStayGameFragment3.birdNum = (1 + localStayGameFragment3.birdNum);
          createBird(localValueAnimator, localRandom);
        }
        StayGameFragment localStayGameFragment2;
        if (StayGameFragment.this.note > 0)
          localStayGameFragment2 = StayGameFragment.this;
        StayGameFragment localStayGameFragment1;
        for (localStayGameFragment2.note = (1 + localStayGameFragment2.note); ; localStayGameFragment1.note = (-1 + localStayGameFragment1.note))
        {
          if ((StayGameFragment.this.note > 90) || (StayGameFragment.this.note < -90))
            gameOver(localValueAnimator);
          StayGameFragment.this.person.setPivotY(StayGameFragment.this.person.getY() - 250.0F);
          StayGameFragment.this.person.setRotation(StayGameFragment.this.note);
          return;
          localStayGameFragment1 = StayGameFragment.this;
        }
      }
    });
    this.start_button.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        StayGameFragment.this.start_view.setVisibility(8);
        StayGameFragment.this.stay_game_view.setVisibility(0);
        localValueAnimator.setRepeatCount(-1);
        localValueAnimator.setDuration(2L).start();
      }
    });
    return localView;
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.smallgame.StayGameFragment
 * JD-Core Version:    0.6.2
 */