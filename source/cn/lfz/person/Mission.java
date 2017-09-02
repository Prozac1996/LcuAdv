package cn.lfz.person;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.lfz.callback.EventListener;
import cn.lfz.maybegame.BattleFragment;
import cn.lfz.util.Base64Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Mission
  implements Serializable
{
  private static final String MISSIONS = "missions";
  private static final String NOWMISSION = "nowMission";
  private static final int RANDOM_STEP = 5;
  private static ArrayList<Enemy> enemys;
  private static EventListener listener;
  private static Mission mission;
  private static List<MyMission> mission_list;
  private static MyMission nowMission;
  private Random random;

  private Mission()
  {
    mission_list = new ArrayList();
    this.random = new Random();
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add("开学");
    enemys = new ArrayList();
    enemys.add(EnemyLib.getInstance().getEnemy("渣渣"));
    mission_list.add(new MyMission("南大门", "轻松", "气派的南大门，花了不少钱。", 2130837523, true, enemys, localArrayList1, new String[] { "帮助老人" })
    {
      public String ranStep()
      {
        switch (Mission.this.random.nextInt(5))
        {
        default:
          return "你随便走了走，没有发现什么特别的。";
        case 0:
          return "人来人往，没有人驻足，大学平静的呼吸着。";
        case 1:
          return "微风吹来，吹走了些许阳光的炙热。";
        case 2:
          return "一些赶路的人被大门的宏伟所惊讶，在大门前摆起了造型。";
        case 3:
          return "跳广场舞的老太太们占据了大门一侧的空地，兴高采烈，悠然自得。";
        case 4:
        }
        BattleFragment localBattleFragment = new BattleFragment();
        Mission.listener.onBattle(localBattleFragment);
        return "遭遇战斗！";
      }
    });
    ArrayList localArrayList2 = new ArrayList();
    enemys = new ArrayList();
    mission_list.add(new MyMission("实验楼", "简单", "各种实验室，童鞋你带鞋套了吗？", 2130837532, false, enemys, localArrayList2, new String[] { "帮助老人" })
    {
      public String ranStep()
      {
        switch (Mission.this.random.nextInt(5))
        {
        default:
          return "你随便走了走，没有发现什么特别的。";
        case 0:
          return "红旗飘扬在大楼前的广场上。";
        case 1:
          return "校门内的路边有一块路标，经历风雨后有些颜色褪去了。";
        case 2:
          return "几个学生坐在实验楼的台阶上，书声琅琅。";
        case 3:
          return "石子路上有些水洼，不久之前下过小雨。";
        case 4:
        }
        return "几辆自行车驶过，有些还载着异性。";
      }
    });
    ArrayList localArrayList3 = new ArrayList();
    localArrayList3.add("报道");
    localArrayList3.add("班会");
    enemys = new ArrayList();
    enemys.add(EnemyLib.getInstance().getEnemy("绩点"));
    mission_list.add(new MyMission("计算机学院", "普通", "这个学院不仅藏有最好的人才，还拥有全校最烂的多媒体。", 2130837537, false, enemys, localArrayList3, new String[] { "丢失的狗" })
    {
      public String ranStep()
      {
        switch (Mission.this.random.nextInt(5))
        {
        default:
          return "你随便走了走，没有发现什么特别的。";
        case 0:
          return "一楼贴出了新的告示，新一周的减分表。";
        case 1:
          return "值日的同学坐在门口的岗位上摆弄着手机。";
        case 2:
          return "走廊里总有同学向下望，一定没有恐高症。";
        case 3:
        }
        BattleFragment localBattleFragment = new BattleFragment();
        Mission.listener.onBattle(localBattleFragment);
        return "遭遇战斗！";
      }
    });
    ArrayList localArrayList4 = new ArrayList();
    enemys = new ArrayList();
    mission_list.add(new MyMission("湖上小亭", "轻松", "晨读必备,时常有情侣出没。", 2130837528, false, enemys, localArrayList4, new String[] { "帮助老人" })
    {
      public String ranStep()
      {
        switch (Mission.this.random.nextInt(5))
        {
        default:
          return "你随便走了走，没有发现什么特别的。";
        case 0:
          return "假山的树林里不知道有什么东西。";
        case 1:
          return "站在这里，西校区的风景一览无余。";
        case 2:
        }
        return "清净之地，有些同学经常来这里背书。";
      }
    });
    ArrayList localArrayList5 = new ArrayList();
    enemys = new ArrayList();
    enemys.add(EnemyLib.getInstance().getEnemy("黑化土豆"));
    enemys.add(EnemyLib.getInstance().getEnemy("没熟土豆"));
    enemys.add(EnemyLib.getInstance().getEnemy("人群"));
    mission_list.add(new MyMission("食堂", "炼狱", "西校区有三个食堂，饭菜还可以。", 2130837513, false, enemys, localArrayList5, new String[] { "帮助老人" })
    {
      public String ranStep()
      {
        switch (Mission.this.random.nextInt(5))
        {
        default:
          return "你随便走了走，没有发现什么特别的。";
        case 0:
          return "上午下课的时候食堂人挤人，买到如意的饭是很难的。";
        case 1:
        }
        return "这个学期食堂的饭涨价了5毛。";
      }
    });
    ArrayList localArrayList6 = new ArrayList();
    localArrayList6.add("回宿舍");
    enemys = new ArrayList();
    enemys.add(EnemyLib.getInstance().getEnemy("浓郁的气味"));
    mission_list.add(new MyMission("紫藤公寓", "休闲", "位于西校区中部的紫藤公寓，也是学校里时间最长的学生宿舍。", 2130837555, false, enemys, localArrayList6, new String[0])
    {
      public String ranStep()
      {
        switch (Mission.this.random.nextInt(5))
        {
        default:
          return "你随便走了走，没有发现什么特别的。";
        case 0:
          return "传说中环境不好，却意外地干净。";
        case 1:
          return "虽然见不到小强的身影，但是宿舍每年都发蟑螂药。";
        case 2:
        }
        BattleFragment localBattleFragment = new BattleFragment();
        Mission.listener.onBattle(localBattleFragment);
        return "遭遇战斗!";
      }
    });
    ArrayList localArrayList7 = new ArrayList();
    localArrayList7.add("军训");
    enemys = new ArrayList();
    enemys.add(EnemyLib.getInstance().getEnemy("天边飞来的足球"));
    enemys.add(EnemyLib.getInstance().getEnemy("天边飞来的篮球"));
    mission_list.add(new MyMission("操场", "炼狱", "任何时候都有人的操场。", 2130837539, false, enemys, localArrayList7, new String[] { "军训训练" })
    {
      public String ranStep()
      {
        switch (Mission.this.random.nextInt(5))
        {
        default:
          return "你随便走了走，没有发现什么特别的。";
        case 0:
          return "传说中环境不好，却意外地干净。";
        case 1:
          return "虽然见不到小强的身影，但是宿舍每年都发蟑螂药。";
        case 2:
        }
        BattleFragment localBattleFragment = new BattleFragment();
        Mission.listener.onBattle(localBattleFragment);
        return "遭遇战斗！";
      }
    });
    ArrayList localArrayList8 = new ArrayList();
    enemys = new ArrayList();
    mission_list.add(new MyMission("大服", "普通", "卖东西，交话费，祛痘的地方。", 2130837518, false, enemys, localArrayList8, new String[0])
    {
      public String ranStep()
      {
        return "";
      }
    });
    ArrayList localArrayList9 = new ArrayList();
    enemys = new ArrayList();
    mission_list.add(new MyMission("彩虹桥", "严重", "连接东西校的通道，单身狗来此散步请慎重。", 2130837543, false, enemys, localArrayList9, new String[0])
    {
      public String ranStep()
      {
        return "";
      }
    });
    ArrayList localArrayList10 = new ArrayList();
    enemys = new ArrayList();
    mission_list.add(new MyMission("图书馆", "普通", "除了刚考完研，任何时候都是满满当当的，占座的也很多。", 2130837531, false, enemys, localArrayList10, new String[0])
    {
      public String ranStep()
      {
        return "";
      }
    });
    ArrayList localArrayList11 = new ArrayList();
    enemys = new ArrayList();
    nowMission = new MyMission("汽车", "安全", "通往学校的汽车。", 2130837509, true, enemys, localArrayList11, new String[0])
    {
      public String ranStep()
      {
        return "汽车缓缓地向前开着。";
      }
    };
  }

  private Mission(MyMission paramMyMission, List<MyMission> paramList)
  {
    mission_list = paramList;
    nowMission = paramMyMission;
  }

  public static Mission getInstance()
  {
    return mission;
  }

  public static Mission getInstance(EventListener paramEventListener)
  {
    if (mission == null)
      mission = new Mission();
    listener = paramEventListener;
    return mission;
  }

  public static void reload(SharedPreferences paramSharedPreferences)
  {
    mission_list = (List)Base64Util.loadObject("missions", paramSharedPreferences);
    nowMission = (MyMission)Base64Util.loadObject("nowMission", paramSharedPreferences);
    mission = new Mission(nowMission, mission_list);
  }

  public static void save(SharedPreferences.Editor paramEditor)
  {
    Base64Util.saveObject(mission_list, "missions", paramEditor);
    Base64Util.saveObject(nowMission, "nowMission", paramEditor);
  }

  public List<MyMission> getMission_list()
  {
    return mission_list;
  }

  public MyMission getMyMissionByName(String paramString)
  {
    Iterator localIterator = mission_list.iterator();
    MyMission localMyMission;
    do
    {
      if (!localIterator.hasNext())
        return null;
      localMyMission = (MyMission)localIterator.next();
    }
    while (!localMyMission.getName().equals(paramString));
    return localMyMission;
  }

  public MyMission getNowMission()
  {
    return nowMission;
  }

  public void setNowMission(MyMission paramMyMission)
  {
    nowMission = paramMyMission;
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.person.Mission
 * JD-Core Version:    0.6.2
 */