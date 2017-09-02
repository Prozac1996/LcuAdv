package cn.lfz.maybegame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import cn.lfz.person.Bag;
import cn.lfz.person.Enemy;
import cn.lfz.person.Item;
import cn.lfz.person.Mission;
import cn.lfz.person.MyMission;
import cn.lfz.person.MySkill;
import cn.lfz.person.Person;
import cn.lfz.person.Skill;
import cn.lfz.util.ActionUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class BattleFragment extends Fragment
  implements View.OnClickListener, Serializable
{
  private Button attack;
  private LinearLayout control;
  private Enemy enemy;
  private ProgressBar enemy_hp;
  private ImageView enemy_icon;
  private TextView enemy_name;
  private Button exit;
  private Handler handler;
  private Button item;
  private ListView itemList;
  private ProgressBar person_hp;
  private ImageView person_icon;
  private TextView person_name;
  private Random random;
  private Button return_button;
  private Button skill;
  private Timer timer;
  private TextView tip;

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

  private List<? extends Map<String, ?>> getSkillData()
  {
    List localList = Person.getInstance().getMySkill().getSkills();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localArrayList;
      Skill localSkill = (Skill)localIterator.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("skill_image", Integer.valueOf(localSkill.getImage()));
      localHashMap.put("skill_name", localSkill.getName());
      localHashMap.put("skill_info", localSkill.getName());
      localArrayList.add(localHashMap);
    }
  }

  private void sendResult(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("info", paramString);
    if (getTargetFragment() == null)
      return;
    getTargetFragment().onActivityResult(getTargetRequestCode(), -1, localIntent);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131165207:
    default:
      return;
    case 2131165208:
      this.tip.setText("回合开始\n");
      this.control.setVisibility(4);
      this.timer.schedule(new TimerTask()
      {
        public void run()
        {
          Message localMessage = new Message();
          localMessage.what = 1;
          BattleFragment.this.handler.sendMessage(localMessage);
        }
      }
      , 1000L);
      return;
    case 2131165210:
      SimpleAdapter localSimpleAdapter2 = new SimpleAdapter(getActivity(), getItemData(), 2130903040, new String[] { "item_name", "item_info", "item_icon" }, new int[] { 2131165185, 2131165186, 2131165184 });
      this.itemList.setAdapter(localSimpleAdapter2);
      this.itemList.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          Item localItem = (Item)Person.getInstance().getBag().getItems().get(paramAnonymousInt);
          if (localItem.isCanUse())
          {
            localItem.use();
            Person.getInstance().getBag().deleteItem(localItem.getItem_name());
            BattleFragment.this.itemList.setVisibility(4);
            BattleFragment.this.tip.setText("你使用了" + localItem.getItem_name());
            BattleFragment.this.timer.schedule(new TimerTask()
            {
              public void run()
              {
                BattleFragment.this.handler.sendEmptyMessage(3);
              }
            }
            , 0L);
            return;
          }
          Toast.makeText(BattleFragment.this.getActivity(), "此物品不可在战斗中使用。", 0).show();
        }
      });
      this.itemList.setVisibility(0);
      this.control.setVisibility(4);
      this.return_button.setVisibility(0);
      return;
    case 2131165209:
      SimpleAdapter localSimpleAdapter1 = new SimpleAdapter(getActivity(), getSkillData(), 2130903053, new String[] { "skill_image", "skill_name", "skill_info" }, new int[] { 2131165271, 2131165272, 2131165273 });
      this.itemList.setAdapter(localSimpleAdapter1);
      this.itemList.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
        }
      });
      this.itemList.setVisibility(0);
      this.control.setVisibility(4);
      this.return_button.setVisibility(0);
      return;
    case 2131165211:
      this.tip.setText("你蹲下身子 准备逃跑。\n");
      this.timer.schedule(new TimerTask()
      {
        public void run()
        {
          BattleFragment.this.handler.sendEmptyMessage(4);
        }
      }
      , 1000L);
      return;
    case 2131165206:
    }
    this.return_button.setVisibility(4);
    this.itemList.setVisibility(4);
    this.control.setVisibility(0);
  }

  @SuppressLint({"HandlerLeak"})
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int i = Mission.getInstance().getNowMission().getEnemys().size();
    this.enemy = ((Enemy)Mission.getInstance().getNowMission().getEnemys().get(i - 1));
    this.timer = new Timer();
    this.random = new Random();
    this.handler = new Handler()
    {
      private void flushHp()
      {
        BattleFragment.this.person_hp.setProgress(Person.getInstance().getHp());
        if (BattleFragment.this.enemy_hp.getProgress() <= 0)
        {
          BattleFragment.this.tip.setText("战斗结束！\n");
          Person.getInstance().setExp_now(BattleFragment.this.enemy.getExp());
          str = "";
          if (BattleFragment.this.random.nextInt(10) < 1)
          {
            str = "你获得了 " + BattleFragment.this.enemy.getName() + " 掉落的宝物 " + BattleFragment.this.enemy.getItem().getItem_name() + "!";
            ActionUtil.gainItem(BattleFragment.this.getActivity(), BattleFragment.this.enemy.getItem().getItem_name());
          }
          BattleFragment.this.sendResult(str);
          BattleFragment.this.getFragmentManager().popBackStack();
        }
        while (Person.getInstance().getHp() > 0)
        {
          String str;
          return;
        }
        BattleFragment.this.tip.setText("战斗失败！");
        Person.getInstance().setHp(1);
        BattleFragment.this.sendResult("");
        BattleFragment.this.getFragmentManager().popBackStack();
      }

      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        case 2:
        default:
        case 0:
        case 1:
        case 3:
        case 4:
        }
        do
        {
          return;
          switch (BattleFragment.this.random.nextInt(10))
          {
          default:
          case 0:
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          case 7:
          case 8:
          case 9:
          }
          while (true)
          {
            flushHp();
            BattleFragment.this.control.setVisibility(0);
            return;
            BattleFragment.this.tip.setText("你巧妙的躲过了 " + BattleFragment.this.enemy.getName() + " 的攻击！\n");
            continue;
            int m = BattleFragment.this.enemy.getDamage();
            BattleFragment.this.tip.setText(BattleFragment.this.enemy.getName() + " 对你进行了攻击！\n你损失了 " + m + " 点生命值。\n");
            Person.getInstance().addHp(-m);
            continue;
            int k = 2 * BattleFragment.this.enemy.getDamage();
            BattleFragment.this.tip.setText(BattleFragment.this.enemy.getName() + " 狂躁地向你奔来！\n你损失了" + k + "点生命值。\n");
            Person.getInstance().addHp(-k);
          }
          switch (BattleFragment.this.random.nextInt(10))
          {
          default:
          case 0:
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          case 7:
          case 8:
          case 9:
          }
          while (true)
          {
            sendEmptyMessageDelayed(0, 1000L);
            return;
            BattleFragment.this.tip.setText("哎呀！你对 " + BattleFragment.this.enemy.getName() + " 的攻击落空了！\n");
            continue;
            int j = Person.getInstance().getPower();
            BattleFragment.this.tip.setText("你对 " + BattleFragment.this.enemy.getName() + "进行了攻击！" + BattleFragment.this.enemy.getName() + " 损失了 " + j + " 点生命值。\n");
            BattleFragment.this.enemy_hp.setProgress(BattleFragment.this.enemy_hp.getProgress() - j);
            continue;
            int i = 2 * Person.getInstance().getPower();
            BattleFragment.this.tip.setText("你对 " + BattleFragment.this.enemy.getName() + "造成了惊叹一击！" + BattleFragment.this.enemy.getName() + "损失了" + i + "点生命值。\n");
            BattleFragment.this.enemy_hp.setProgress(BattleFragment.this.enemy_hp.getProgress() - i);
          }
          BattleFragment.this.enemy_hp.setProgress(BattleFragment.this.enemy_hp.getProgress());
          sendEmptyMessageDelayed(0, 1000L);
          return;
          if (BattleFragment.this.random.nextInt(10) >= 6)
            break;
          BattleFragment.this.tip.append("逃跑成功!");
        }
        while (BattleFragment.this.getFragmentManager().getBackStackEntryCount() <= 0);
        BattleFragment.this.sendResult("");
        BattleFragment.this.getFragmentManager().popBackStack();
        return;
        BattleFragment.this.tip.append("敌人识破了你的逃跑计划！");
        sendEmptyMessageDelayed(0, 1000L);
      }
    };
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903043, paramViewGroup, false);
    this.enemy_name = ((TextView)localView.findViewById(2131165198));
    this.enemy_hp = ((ProgressBar)localView.findViewById(2131165199));
    this.enemy_icon = ((ImageView)localView.findViewById(2131165200));
    this.person_name = ((TextView)localView.findViewById(2131165202));
    this.person_hp = ((ProgressBar)localView.findViewById(2131165203));
    this.person_icon = ((ImageView)localView.findViewById(2131165201));
    this.itemList = ((ListView)localView.findViewById(2131165205));
    this.tip = ((TextView)localView.findViewById(2131165204));
    this.attack = ((Button)localView.findViewById(2131165208));
    this.item = ((Button)localView.findViewById(2131165210));
    this.skill = ((Button)localView.findViewById(2131165209));
    this.exit = ((Button)localView.findViewById(2131165211));
    this.return_button = ((Button)localView.findViewById(2131165206));
    this.control = ((LinearLayout)localView.findViewById(2131165207));
    this.enemy_name.setText(this.enemy.getName());
    this.enemy_icon.setImageResource(this.enemy.getIcon());
    this.enemy_hp.setMax(this.enemy.getHp());
    this.enemy_hp.setProgress(this.enemy.getHp());
    this.person_name.setText(Person.getInstance().getName());
    this.person_icon.setImageResource(2130837505);
    this.person_hp.setMax(Person.getInstance().getHp_max());
    this.person_hp.setProgress(Person.getInstance().getHp());
    this.attack.setOnClickListener(this);
    this.item.setOnClickListener(this);
    this.skill.setOnClickListener(this);
    this.exit.setOnClickListener(this);
    this.return_button.setOnClickListener(this);
    return localView;
  }

  public void onDestroy()
  {
    super.onDestroy();
    Intent localIntent = new Intent("child.fragment.return");
    getActivity().sendBroadcast(localIntent);
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.maybegame.BattleFragment
 * JD-Core Version:    0.6.2
 */