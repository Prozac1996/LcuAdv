package cn.lfz.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public abstract class MyMission
  implements Serializable
{
  private int background;
  private ArrayList<Enemy> enemys;
  private ArrayList<String> events;
  private String info;
  private boolean into;
  private ArrayList<String> mainEvents;
  private String name;
  private String state;

  MyMission(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, ArrayList<Enemy> paramArrayList, ArrayList<String> paramArrayList1, String[] paramArrayOfString)
  {
    this.name = paramString1;
    this.state = paramString2;
    this.info = paramString3;
    this.background = paramInt;
    this.mainEvents = paramArrayList1;
    this.enemys = paramArrayList;
    this.events = new ArrayList();
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfString.length)
      {
        this.into = paramBoolean;
        return;
      }
      this.events.add(paramArrayOfString[i]);
    }
  }

  public int getBackground()
  {
    return this.background;
  }

  public ArrayList<Enemy> getEnemys()
  {
    return this.enemys;
  }

  public String getInfo()
  {
    return this.info;
  }

  public String getName()
  {
    return this.name;
  }

  public String getState()
  {
    return this.state;
  }

  public boolean isInto()
  {
    return this.into;
  }

  public Event mainEventOk()
  {
    Iterator localIterator = this.mainEvents.iterator();
    Event localEvent;
    do
    {
      if (!localIterator.hasNext())
        return null;
      String str = (String)localIterator.next();
      localEvent = EventLib.getInstance().getEvent(str);
    }
    while (!localEvent.isOk());
    return localEvent;
  }

  public abstract String ranStep();

  public Event randomEvent()
  {
    Random localRandom = new Random();
    if (this.events.size() == 0);
    int i;
    do
    {
      return null;
      i = localRandom.nextInt(2 * this.events.size());
    }
    while (i >= this.events.size());
    return EventLib.getInstance().getEvent((String)this.events.get(i));
  }

  public void setInto(boolean paramBoolean)
  {
    this.into = paramBoolean;
  }

  public String toString()
  {
    return this.name;
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.person.MyMission
 * JD-Core Version:    0.6.2
 */