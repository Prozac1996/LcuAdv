package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

class NavUtilsJB
{
  public static Intent getParentActivityIntent(Activity paramActivity)
  {
    return paramActivity.getParentActivityIntent();
  }

  public static String getParentActivityName(ActivityInfo paramActivityInfo)
  {
    return paramActivityInfo.parentActivityName;
  }

  public static void navigateUpTo(Activity paramActivity, Intent paramIntent)
  {
    paramActivity.navigateUpTo(paramIntent);
  }

  public static boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent)
  {
    return paramActivity.shouldUpRecreateTask(paramIntent);
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.NavUtilsJB
 * JD-Core Version:    0.6.2
 */