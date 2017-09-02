package cn.lfz.util;

import android.app.Application;
import android.content.Context;

public class ApplicationUtils extends Application
{
  private static Context context;

  public static Context getContext()
  {
    return context;
  }

  public void onCreate()
  {
    context = getApplicationContext();
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.util.ApplicationUtils
 * JD-Core Version:    0.6.2
 */