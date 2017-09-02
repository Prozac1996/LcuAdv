package cn.lfz.callback;

import android.app.Fragment;
import cn.lfz.person.Event;

public abstract interface EventListener
{
  public abstract void onBattle(Fragment paramFragment);

  public abstract void onEventEnd();

  public abstract void onEventStart(Event paramEvent);

  public abstract void onSmallGame(Fragment paramFragment);

  public abstract void onTip(String paramString);
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.callback.EventListener
 * JD-Core Version:    0.6.2
 */