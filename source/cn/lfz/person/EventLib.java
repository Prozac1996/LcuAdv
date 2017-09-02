package cn.lfz.person;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import cn.lfz.callback.EventListener;
import cn.lfz.smallgame.StayGameFragment;
import cn.lfz.util.ActionUtil;
import cn.lfz.util.Base64Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EventLib
  implements Serializable
{
  private static String EVENT_ALREADY = "event_already";
  private static Map<String, Boolean> alreadyMap;
  private static EventLib eventLib;
  private static Map<String, Event> events;
  private static EventListener listener;
  private static Context mContext;

  private EventLib(Context paramContext, EventListener paramEventListener)
  {
    events = new HashMap();
    mContext = paramContext;
    listener = paramEventListener;
    initEvent();
  }

  public EventLib(Map<String, Event> paramMap)
  {
    events = paramMap;
  }

  public static void createInstance(Context paramContext, EventListener paramEventListener)
  {
    eventLib = new EventLib(paramContext, paramEventListener);
  }

  public static EventLib getInstance()
  {
    return eventLib;
  }

  private void initEvent()
  {
    events.put("开学", new Event(2130837520)
    {
      public void addButton()
      {
        Button localButton = EventLib.this.createButton("出发");
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            ActionUtil.openMap(EventLib.mContext, "计算机学院");
            ActionUtil.acceptMainTask(EventLib.mContext, "报道");
            EventLib.listener.onEventEnd();
          }
        });
        getButtons().add(localButton);
      }

      public void addTip()
      {
        ArrayList localArrayList = getTip();
        localArrayList.add("你第一次跨进了这所大学，看着这个陌生的地方，感到有些茫然。");
        localArrayList.add("通知书上写着需要到十号楼报道。");
        localArrayList.add("先去十号楼——计算机学院看看吧。");
      }

      public boolean isOk()
      {
        return !isAlready();
      }

      public void startEvent()
      {
        EventLib.listener.onEventStart(this);
      }
    });
    events.put("报道", new Event(2130837520)
    {
      public void addButton()
      {
        setAlready(true);
        Button localButton = EventLib.this.createButton("完成");
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            Person.getInstance().setGold(-780);
            ActionUtil.gainItem(EventLib.mContext, "发票");
            ActionUtil.finishMainTask(EventLib.mContext, "报道");
            ActionUtil.acceptMainTask(EventLib.mContext, "回宿舍");
            ActionUtil.openMap(EventLib.mContext, "紫藤公寓");
            EventLib.listener.onEventEnd();
          }
        });
        getButtons().add(localButton);
      }

      public void addTip()
      {
        ArrayList localArrayList = getTip();
        localArrayList.add("你来到了十号楼的三楼，还有几个背着书包的新生随你一起上来，刚上到楼梯口，楼上正在等待新生的学长就迎了上来。");
        localArrayList.add("你好，你是新生吗？");
        localArrayList.add("你点了点头，拿出报名表晃了晃。");
        localArrayList.add("新生请到里面办理报到手续，被褥费用要780块钱，请准备好。");
        localArrayList.add("你进入了办公室，里面坐着几位学长学姐，交了被褥钱，很快的为你办好了手续。");
        localArrayList.add("你出来之后，想了想该到了去看看新宿舍的时候了。");
      }

      public boolean isOk()
      {
        return (!isAlready()) && (EventLib.this.getEvent("开学").isAlready());
      }

      public void startEvent()
      {
        EventLib.listener.onEventStart(this);
      }
    });
    events.put("帮助老人", new Event(2130837520)
    {
      public void addButton()
      {
        setAlready(true);
        ArrayList localArrayList = getButtons();
        Button localButton1 = new Button(EventLib.mContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
        localLayoutParams.weight = 1.0F;
        localButton1.setLayoutParams(localLayoutParams);
        localButton1.setGravity(17);
        localButton1.setText("帮忙");
        localButton1.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            EventLib.listener.onTip("谢谢你啊，年轻人。");
            ActionUtil.acceptOtherTask(EventLib.mContext, "丢失的狗");
            EventLib.listener.onEventEnd();
          }
        });
        localArrayList.add(localButton1);
        Button localButton2 = new Button(EventLib.mContext);
        localButton2.setLayoutParams(localLayoutParams);
        localButton2.setText("不帮");
        localButton2.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            EventLib.listener.onTip("我还是自己找一找吧，不麻烦你了。");
            EventLib.listener.onEventEnd();
          }
        });
        localArrayList.add(localButton2);
        setButtons(localArrayList);
      }

      public void addTip()
      {
        ArrayList localArrayList = getTip();
        localArrayList.add("小伙子，你好哇。");
        localArrayList.add("我的狗丢了。");
        localArrayList.add("你能帮我找狗吗？");
      }

      public boolean isOk()
      {
        return !isAlready();
      }

      public void startEvent()
      {
        EventLib.listener.onEventStart(this);
      }
    });
    events.put("回宿舍", new Event(2130837520)
    {
      public void addButton()
      {
        Button localButton = EventLib.this.createButton("待我歇一歇，该去开班会了");
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            ActionUtil.loseItem(EventLib.mContext, "发票");
            ActionUtil.finishMainTask(EventLib.mContext, "回宿舍");
            ActionUtil.acceptMainTask(EventLib.mContext, "班会");
            EventLib.listener.onEventEnd();
          }
        });
        getButtons().add(localButton);
      }

      public void addTip()
      {
        setAlready(true);
        ArrayList localArrayList = getTip();
        localArrayList.add("到达了宿舍，已经有几个室友先到。");
        localArrayList.add("大家互相打了招呼，用发票了被褥，各自开始收拾东西。");
        localArrayList.add("当你铺好床铺，仔细的看了一下通知单，发现上面写了在十号楼开班会的信息。");
      }

      public boolean isOk()
      {
        return (EventLib.this.getEvent("报道").isAlready()) && (!isAlready());
      }

      public void startEvent()
      {
        EventLib.listener.onEventStart(this);
      }
    });
    events.put("班会", new Event(2130837516)
    {
      public void addButton()
      {
        setAlready(true);
        Button localButton = EventLib.this.createButton("天哪，这是我想象中的大学么？");
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            Toast.makeText(EventLib.mContext, "你受到了噪声伤害：全属性降低1", 0).show();
            Person.getInstance().setPower(-1);
            Person.getInstance().setSpeed(-1);
            Person.getInstance().setStrong(-1);
            Person.getInstance().setStudy(-1);
            ActionUtil.openMap(EventLib.mContext, "操场");
            ActionUtil.finishMainTask(EventLib.mContext, "班会");
            EventLib.listener.onEventEnd();
          }
        });
        getButtons().add(localButton);
      }

      public void addTip()
      {
        ArrayList localArrayList = getTip();
        localArrayList.add("开班会了！");
        localArrayList.add("叽里呱啦");
        localArrayList.add("叽里呱啦叽里呱啦");
        localArrayList.add("叽里呱啦叽里呱啦叽里呱啦");
        localArrayList.add("叽里呱啦叽里呱啦叽里呱啦叽里呱啦");
        localArrayList.add("叽里呱啦叽里呱啦叽里呱啦叽里呱啦叽里呱啦");
        localArrayList.add("老师：.....好了今天的班会就开到这里。");
        localArrayList.add("你的身心受到了摧残,好在班会终于结束了。");
        localArrayList.add("快回宿舍吧，从明天开始就是为期两周的军训了。");
      }

      public boolean isOk()
      {
        return (!isAlready()) && (EventLib.this.getEvent("回宿舍").isAlready());
      }

      public void startEvent()
      {
        EventLib.listener.onEventStart(this);
      }
    });
    events.put("丢失的狗", new Event(2130837520)
    {
      public void addButton()
      {
        ArrayList localArrayList = new ArrayList();
        if ((!TaskLib.getInstance().getTask("丢失的狗").isStatus()) && (Person.getInstance().getMyTask().getOtherTask("丢失的狗") != null))
        {
          setAlready(true);
          Button localButton2 = EventLib.this.createButton("这不是老头丢的小狗么,快过来");
          localButton2.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              ActionUtil.finishOtherTask(EventLib.mContext, "丢失的狗");
              Toast.makeText(EventLib.mContext, "获得任务奖励：20块钱", 0).show();
              Person.getInstance().setGold(20);
              EventLib.listener.onEventEnd();
            }
          });
          localArrayList.add(localButton2);
        }
        while (true)
        {
          setButtons(localArrayList);
          return;
          Button localButton1 = EventLib.this.createButton("这只小狗真可怜");
          localButton1.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              EventLib.listener.onEventEnd();
            }
          });
          localArrayList.add(localButton1);
        }
      }

      public void addTip()
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("一条小狗在路上游荡着，身上脏兮兮的。");
        setTip(localArrayList);
      }

      public boolean isOk()
      {
        return !isAlready();
      }

      public void startEvent()
      {
        EventLib.listener.onEventStart(this);
      }
    });
    events.put("军训训练", new Event(2130837520)
    {
      public void addButton()
      {
        ArrayList localArrayList = new ArrayList();
        Button localButton = EventLib.this.createButton("接受训练");
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            StayGameFragment localStayGameFragment = new StayGameFragment();
            EventLib.listener.onSmallGame(localStayGameFragment);
            EventLib.listener.onEventEnd();
          }
        });
        localArrayList.add(localButton);
        setButtons(localArrayList);
      }

      public void addTip()
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("开始训练啦！");
        setTip(localArrayList);
      }

      public boolean isOk()
      {
        return true;
      }

      public void startEvent()
      {
        EventLib.listener.onEventStart(this);
      }
    });
    events.put("军训", new Event(2130837520)
    {
      public void addButton()
      {
        setAlready(true);
        ArrayList localArrayList = getButtons();
        Button localButton = EventLib.this.createButton("训练完成");
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            Toast.makeText(EventLib.mContext, "由于军训劳累，体力下降3，体质上升1，获得经验值2", 0).show();
            Person.getInstance().setStrong(1);
            Person.getInstance().setHp_max(1);
            Person.getInstance().addHp(-3);
            Person.getInstance().setExp_now(2);
            EventLib.listener.onEventEnd();
          }
        });
        localArrayList.add(localButton);
      }

      public void addTip()
      {
        ArrayList localArrayList = getTip();
        localArrayList.add("你来到了操场，看见了周围陌生的同学，和你的教官。");
        localArrayList.add("教官：\n\t同学们好，我是你们的教官。接下来两周你们的军训由我来带领，你们可要做好准备。先站十分钟军姿。");
        localArrayList.add("由于天气炎热，军训服也是严严实实，同学们额头上挂满了汗珠。");
        localArrayList.add("或者因为陌生，或者畏于纪律，没有人说话，都认真地站着军姿。");
      }

      public boolean isOk()
      {
        return (EventLib.this.getEvent("班会").isAlready()) && (!isAlready());
      }

      public void startEvent()
      {
        EventLib.listener.onEventStart(this);
      }
    });
  }

  public static void reload(Context paramContext, EventListener paramEventListener, SharedPreferences paramSharedPreferences)
  {
    eventLib = new EventLib(paramContext, paramEventListener);
    alreadyMap = (Map)Base64Util.loadObject(EVENT_ALREADY, paramSharedPreferences);
    Iterator localIterator = alreadyMap.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((Event)events.get(localEntry.getKey())).setAlready(((Boolean)localEntry.getValue()).booleanValue());
    }
  }

  public static void save(SharedPreferences.Editor paramEditor)
  {
    paramEditor.remove(EVENT_ALREADY);
    alreadyMap = new HashMap();
    Iterator localIterator = events.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        Base64Util.saveObject(alreadyMap, EVENT_ALREADY, paramEditor);
        return;
      }
      String str = (String)localIterator.next();
      alreadyMap.put(str, Boolean.valueOf(((Event)events.get(str)).isAlready()));
    }
  }

  public Button createButton(String paramString)
  {
    Button localButton = new Button(mContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.weight = 1.0F;
    localButton.setLayoutParams(localLayoutParams);
    localButton.setGravity(17);
    localButton.setText(paramString);
    return localButton;
  }

  public Event getEvent(String paramString)
  {
    return (Event)events.get(paramString);
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.person.EventLib
 * JD-Core Version:    0.6.2
 */