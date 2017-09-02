package cn.lfz.person;

import android.widget.Button;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Event
  implements Serializable
{
  private boolean already;
  private ArrayList<Button> buttons;
  private int eventImage;
  private ArrayList<String> tip;

  public Event(int paramInt)
  {
    setEventImage(paramInt);
    this.already = false;
    this.tip = new ArrayList();
    this.buttons = new ArrayList();
  }

  public abstract void addButton();

  public abstract void addTip();

  public ArrayList<Button> getButtons()
  {
    return this.buttons;
  }

  public int getEventImage()
  {
    return this.eventImage;
  }

  public ArrayList<String> getTip()
  {
    return this.tip;
  }

  public boolean isAlready()
  {
    return this.already;
  }

  public abstract boolean isOk();

  public void setAlready(boolean paramBoolean)
  {
    this.already = paramBoolean;
  }

  protected void setButtons(ArrayList<Button> paramArrayList)
  {
    this.buttons = paramArrayList;
  }

  public void setEventImage(int paramInt)
  {
    this.eventImage = paramInt;
  }

  protected void setTip(ArrayList<String> paramArrayList)
  {
    this.tip = paramArrayList;
  }

  public abstract void startEvent();
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.person.Event
 * JD-Core Version:    0.6.2
 */