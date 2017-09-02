package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

class IntentCompatHoneycomb
{
  public static Intent makeMainActivity(ComponentName paramComponentName)
  {
    return Intent.makeMainActivity(paramComponentName);
  }

  public static Intent makeRestartActivityTask(ComponentName paramComponentName)
  {
    return Intent.makeRestartActivityTask(paramComponentName);
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.content.IntentCompatHoneycomb
 * JD-Core Version:    0.6.2
 */