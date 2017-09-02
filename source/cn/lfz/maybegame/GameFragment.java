package cn.lfz.maybegame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import cn.lfz.callback.EventListener;
import cn.lfz.person.Bag;
import cn.lfz.person.EnemyLib;
import cn.lfz.person.Event;
import cn.lfz.person.EventLib;
import cn.lfz.person.Item;
import cn.lfz.person.ItemLib;
import cn.lfz.person.Mission;
import cn.lfz.person.MyMission;
import cn.lfz.person.Person;
import cn.lfz.person.SkillLib;
import cn.lfz.person.TaskLib;
import cn.lfz.skilltree.SkillList;
import cn.lfz.util.Base64Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"HandlerLeak"})
public class GameFragment extends Fragment
  implements View.OnClickListener, Serializable, EventListener
{
  protected static final String ENEMYLIB_FLAG = "enemyLib.data";
  protected static final String ITEMLIB_FLAG = "itemLib.data";
  protected static final String PERSON_FLAG = "person.data";
  private static final String PERSON_INFO = "person_info";
  private static final int REQUEST_BATTLE = 1;
  private static final int REQUEST_MOVE = 0;
  protected static final String SKILLlIB_FLAG = "skillLib.data";
  private static final String SP = "sp";
  protected static final String TASKLIB_FLAG = "taskLib.data";
  private static final String VERSION = "version";
  private static LinearLayout event_button;
  private static FrameLayout event_view;
  private static TextView main_message;
  private static Button step;
  private Handler handler;
  private Button item_bag;
  private TextView life;
  private Context mContext;
  private LinearLayout main_layout;
  private Button mission_info;
  private ProgressBar person_hp;
  private Button person_info;
  private Button select_mission;
  private Button send;
  private Button skill_tree;
  private SharedPreferences sp;
  private Button store;
  private Timer timer;

  private void flashUI()
  {
    this.person_hp.setMax(Person.getInstance().getHp_max());
    this.person_hp.setProgress(Person.getInstance().getHp());
  }

  private List<? extends Map<String, ?>> getItemData()
  {
    Bag localBag = Person.getInstance().getBag();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localBag.getItems().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localArrayList;
      Item localItem = (Item)localIterator.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("item_name", localItem.getItem_name());
      localHashMap.put("item_info", localItem.getItem_info());
      localHashMap.put("item_icon", Integer.valueOf(localItem.getItem_icon()));
      localArrayList.add(localHashMap);
    }
  }

  private void initData(View paramView)
  {
    try
    {
      final int i = getActivity().getPackageManager().getPackageInfo("cn.lf.maybegame", 0).versionCode;
      if (i > this.sp.getInt("version", 0))
      {
        EventLib.createInstance(getActivity().getApplicationContext(), this);
        Mission.getInstance(this);
        EventLib.createInstance(getActivity().getApplicationContext(), this);
        final LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131165225);
        final FrameLayout localFrameLayout2 = (FrameLayout)paramView.findViewById(2131165222);
        final FrameLayout localFrameLayout3 = (FrameLayout)paramView.findViewById(2131165223);
        localLinearLayout.setVisibility(8);
        localFrameLayout2.setVisibility(0);
        AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
        localAlphaAnimation2.setDuration(2000L);
        final AlphaAnimation localAlphaAnimation3 = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation3.setDuration(2000L);
        localAlphaAnimation2.setAnimationListener(new Animation.AnimationListener()
        {
          private void initCreatePerson(final FrameLayout paramAnonymousFrameLayout)
          {
            final TextView localTextView1 = (TextView)paramAnonymousFrameLayout.findViewById(2131165195);
            final TextView localTextView2 = (TextView)paramAnonymousFrameLayout.findViewById(2131165191);
            final TextView localTextView3 = (TextView)paramAnonymousFrameLayout.findViewById(2131165192);
            final TextView localTextView4 = (TextView)paramAnonymousFrameLayout.findViewById(2131165193);
            final TextView localTextView5 = (TextView)paramAnonymousFrameLayout.findViewById(2131165194);
            final Button localButton1 = (Button)paramAnonymousFrameLayout.findViewById(2131165196);
            Button localButton2 = (Button)paramAnonymousFrameLayout.findViewById(2131165190);
            Random localRandom = new Random();
            int i = localRandom.nextInt(10);
            int j = localRandom.nextInt(10 - i);
            int k = localRandom.nextInt(10 - i - j);
            int m = 10 - i - j - k;
            localTextView2.setText(i);
            localTextView3.setText(j);
            localTextView4.setText(k);
            localTextView5.setText(m);
            localButton2.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                Random localRandom = new Random();
                int i = localRandom.nextInt(10);
                int j = localRandom.nextInt(10 - i);
                int k = localRandom.nextInt(10 - i - j);
                int m = 10 - i - j - k;
                localTextView2.setText(i);
                localTextView3.setText(j);
                localTextView4.setText(k);
                localTextView5.setText(m);
              }
            });
            localButton1.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                localButton1.setClickable(false);
                Toast.makeText(GameFragment.this.getActivity(), "登记成功，即将入学", 0).show();
                Person.createInstance(localTextView1.getText().toString(), localTextView2.getText().toString(), localTextView3.getText().toString(), localTextView4.getText().toString(), localTextView5.getText().toString());
                GameFragment.this.sp.edit().putInt("version", this.val$currentVersion).commit();
                AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
                localAlphaAnimation.setDuration(2000L);
                localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
                {
                  public void onAnimationEnd(Animation paramAnonymous3Animation)
                  {
                    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
                    localAlphaAnimation.setDuration(2000L);
                    this.val$createPerson.setVisibility(8);
                    this.val$main_copy.setVisibility(0);
                    this.val$main_copy.startAnimation(localAlphaAnimation);
                  }

                  public void onAnimationRepeat(Animation paramAnonymous3Animation)
                  {
                  }

                  public void onAnimationStart(Animation paramAnonymous3Animation)
                  {
                  }
                });
                paramAnonymousFrameLayout.startAnimation(localAlphaAnimation);
                GameFragment.main_message.setText("九月一号，开学的日子，你带着大包小包的东西，独自一人踏上了通往聊城大学的道路。");
                GameFragment.this.life.setText(Person.getInstance().getLife());
                GameFragment.this.person_hp.setMax(Person.getInstance().getHp_max());
                GameFragment.this.person_hp.setProgress(Person.getInstance().getHp());
              }
            });
          }

          public void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            localFrameLayout3.setVisibility(0);
            localFrameLayout3.startAnimation(localAlphaAnimation3);
            localFrameLayout2.setVisibility(8);
            initCreatePerson(localFrameLayout3);
          }

          public void onAnimationRepeat(Animation paramAnonymousAnimation)
          {
          }

          public void onAnimationStart(Animation paramAnonymousAnimation)
          {
          }
        });
        localFrameLayout2.startAnimation(localAlphaAnimation2);
        return;
      }
      this.main_layout.setVisibility(4);
      final FrameLayout localFrameLayout1 = (FrameLayout)paramView.findViewById(2131165224);
      localFrameLayout1.setVisibility(0);
      AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation1.setDuration(2000L);
      localAlphaAnimation1.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          localFrameLayout1.setVisibility(8);
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
          localAlphaAnimation.setDuration(1000L);
          GameFragment.this.person_hp.setMax(Person.getInstance().getHp_max());
          GameFragment.this.person_hp.setProgress(Person.getInstance().getHp());
          GameFragment.this.main_layout.startAnimation(localAlphaAnimation);
          GameFragment.this.main_layout.setVisibility(0);
          GameFragment.main_message.setText("欢迎回到游戏，你还在你上次停留的地方。");
          GameFragment.this.life.setText(Person.getInstance().getLife());
        }

        public void onAnimationRepeat(Animation paramAnonymousAnimation)
        {
        }

        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
        }
      });
      localFrameLayout1.startAnimation(localAlphaAnimation1);
      reloadObject();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void initGame(View paramView)
  {
    this.main_layout = ((LinearLayout)paramView.findViewById(2131165225));
    this.person_info = ((Button)paramView.findViewById(2131165226));
    this.item_bag = ((Button)paramView.findViewById(2131165227));
    this.mission_info = ((Button)paramView.findViewById(2131165228));
    this.select_mission = ((Button)paramView.findViewById(2131165232));
    step = (Button)paramView.findViewById(2131165234);
    this.send = ((Button)paramView.findViewById(2131165237));
    this.store = ((Button)paramView.findViewById(2131165235));
    this.skill_tree = ((Button)paramView.findViewById(2131165236));
    this.person_hp = ((ProgressBar)paramView.findViewById(2131165203));
    main_message = (TextView)paramView.findViewById(2131165230);
    this.life = ((TextView)paramView.findViewById(2131165231));
    event_button = (LinearLayout)paramView.findViewById(2131165233);
    event_view = (FrameLayout)paramView.findViewById(2131165229);
    this.person_info.setOnClickListener(this);
    this.item_bag.setOnClickListener(this);
    this.mission_info.setOnClickListener(this);
    this.select_mission.setOnClickListener(this);
    step.setOnClickListener(this);
    this.send.setOnClickListener(this);
    this.store.setOnClickListener(this);
    this.skill_tree.setOnClickListener(this);
  }

  private void reloadObject()
  {
    Log.i("lfz", "read");
    Person.reload((Person)Base64Util.loadObject("person.data", this.sp));
    Log.i("lfz", "read1");
    ItemLib.reload((ItemLib)Base64Util.loadObject("itemLib.data", this.sp));
    Log.i("lfz", "read2");
    SkillLib.reload((SkillLib)Base64Util.loadObject("skillLib.data", this.sp));
    Log.i("lfz", "read3");
    TaskLib.reload((TaskLib)Base64Util.loadObject("taskLib.data", this.sp));
    Log.i("lfz", "read4");
    EnemyLib.reload((EnemyLib)Base64Util.loadObject("enemyLib.data", this.sp));
    Log.i("lfz", "read5");
    EventLib.reload(getActivity(), this, this.sp);
    Log.i("lfz", "read6");
    Mission.getInstance(this);
    Mission.reload(this.sp);
    Log.i("lfz", "readEnd");
  }

  private void saveObject()
  {
    Log.i("lfz", "save");
    Base64Util.saveObject(Person.getInstance(), "person.data", this.sp.edit());
    Base64Util.saveObject(ItemLib.getInstance(), "itemLib.data", this.sp.edit());
    Base64Util.saveObject(SkillLib.getInstance(), "skillLib.data", this.sp.edit());
    Base64Util.saveObject(EnemyLib.getInstance(), "enemyLib.data", this.sp.edit());
    Base64Util.saveObject(TaskLib.getInstance(), "taskLib.data", this.sp.edit());
    EventLib.save(this.sp.edit());
    Mission.save(this.sp.edit());
    Log.i("lfz", "saveEnd");
  }

  public void addFragment(Fragment paramFragment)
  {
    getFragmentManager().beginTransaction().add(2131165197, paramFragment).addToBackStack(null).setTransition(4097).commit();
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
      return;
    switch (paramInt1)
    {
    default:
      return;
    case 0:
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
          localAlphaAnimation.setDuration(500L);
          GameFragment.this.main_layout.setBackgroundResource(Mission.getInstance().getNowMission().getBackground());
          GameFragment.this.main_layout.startAnimation(localAlphaAnimation);
          GameFragment.main_message.setText(Mission.getInstance().getNowMission().getInfo());
        }

        public void onAnimationRepeat(Animation paramAnonymousAnimation)
        {
        }

        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
        }
      });
      this.main_layout.startAnimation(localAlphaAnimation);
      return;
    case 1:
    }
    String str = paramIntent.getStringExtra("info");
    if (str != "")
      main_message.setText(str);
    flashUI();
  }

  public void onBattle(Fragment paramFragment)
  {
    paramFragment.setTargetFragment(this, 1);
    addFragment(paramFragment);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131165229:
    case 2131165230:
    case 2131165231:
    case 2131165233:
    default:
      return;
    case 2131165226:
      new PersonDialogFragment().show(getFragmentManager(), "person_info");
      return;
    case 2131165227:
      if (getItemData().size() == 0)
      {
        Toast.makeText(getActivity(), "你的背包空空如也", 0).show();
        return;
      }
      SimpleAdapter localSimpleAdapter = new SimpleAdapter(getActivity(), getItemData(), 2130903040, new String[] { "item_name", "item_info", "item_icon" }, new int[] { 2131165185, 2131165186, 2131165184 });
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
      localBuilder.setAdapter(localSimpleAdapter, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          Item localItem = (Item)Person.getInstance().getBag().getItems().get(paramAnonymousInt);
          if (localItem.isCanUse())
          {
            localItem.use();
            Person.getInstance().getBag().getItems().remove(paramAnonymousInt);
            GameFragment.this.flashUI();
            return;
          }
          Toast.makeText(GameFragment.this.getActivity(), "此物品不可使用。", 0).show();
        }
      }).create();
      localBuilder.show();
      return;
    case 2131165228:
      addFragment(new TaskFragment());
      return;
    case 2131165232:
      MoveFragment localMoveFragment = new MoveFragment();
      localMoveFragment.setTargetFragment(this, 0);
      addFragment(localMoveFragment);
      return;
    case 2131165234:
      main_message.setText("正在行进中。。。");
      event_button.removeAllViews();
      this.select_mission.setVisibility(4);
      this.timer = new Timer();
      this.timer.schedule(new TimerTask()
      {
        public void run()
        {
          Message localMessage = new Message();
          Event localEvent = Mission.getInstance().getNowMission().mainEventOk();
          if (localEvent == null)
            localEvent = Mission.getInstance().getNowMission().randomEvent();
          if ((localEvent != null) && (localEvent.isOk()))
          {
            localMessage.what = 1;
            localMessage.obj = localEvent;
          }
          while (true)
          {
            GameFragment.this.handler.sendMessage(localMessage);
            return;
            localMessage.what = 0;
          }
        }
      }
      , 2000L);
      Person.getInstance().setLife(-1);
      this.life.setText(Person.getInstance().getLife());
      return;
    case 2131165237:
      startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:4542879@qq.com")));
      return;
    case 2131165235:
      if (!Mission.getInstance().getMyMissionByName("紫藤公寓").isInto())
      {
        Toast.makeText(getActivity(), "暂未开启", 0).show();
        return;
      }
      addFragment(new ShopFragment());
      return;
    case 2131165236:
    }
    addFragment(new SkillList());
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mContext = getActivity();
    this.sp = getActivity().getSharedPreferences("sp", 0);
    this.handler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        default:
          return;
        case 0:
          GameFragment.main_message.setText(Mission.getInstance().getNowMission().ranStep());
          GameFragment.event_button.addView(GameFragment.step);
          GameFragment.this.select_mission.setVisibility(0);
          GameFragment.this.flashUI();
          return;
        case 1:
        }
        Event localEvent = (Event)paramAnonymousMessage.obj;
        localEvent.startEvent();
        localEvent.setAlready(true);
      }
    };
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903046, paramViewGroup, false);
    initGame(localView);
    initData(localView);
    this.main_layout.setBackgroundResource(Mission.getInstance().getNowMission().getBackground());
    this.person_hp.setMax(100);
    return localView;
  }

  public void onEventEnd()
  {
    event_button.removeAllViews();
    event_button.addView(step);
    event_view.setVisibility(4);
    this.select_mission.setVisibility(0);
    flashUI();
  }

  public void onEventStart(final Event paramEvent)
  {
    event_view.setVisibility(0);
    event_view.setBackgroundResource(paramEvent.getEventImage());
    paramEvent.addTip();
    paramEvent.addButton();
    final ArrayList localArrayList = paramEvent.getTip();
    main_message.setText((CharSequence)localArrayList.get(0));
    Button localButton = new Button(this.mContext);
    localButton.setGravity(17);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.weight = 1.0F;
    localButton.setLayoutParams(localLayoutParams);
    localButton.setText("确定");
    localButton.setOnClickListener(new View.OnClickListener()
    {
      int i = 1;

      public void onClick(View paramAnonymousView)
      {
        if (this.i != localArrayList.size())
        {
          TextView localTextView = GameFragment.main_message;
          ArrayList localArrayList = localArrayList;
          int j = this.i;
          this.i = (j + 1);
          localTextView.setText((CharSequence)localArrayList.get(j));
        }
        while (true)
        {
          return;
          GameFragment.event_button.removeAllViews();
          Iterator localIterator = paramEvent.getButtons().iterator();
          while (localIterator.hasNext())
          {
            Button localButton = (Button)localIterator.next();
            GameFragment.event_button.addView(localButton);
          }
        }
      }
    });
    event_button.addView(localButton);
  }

  public void onSmallGame(Fragment paramFragment)
  {
    addFragment(paramFragment);
  }

  public void onStop()
  {
    super.onStop();
    saveObject();
  }

  public void onTip(String paramString)
  {
    main_message.setText(paramString);
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.maybegame.GameFragment
 * JD-Core Version:    0.6.2
 */