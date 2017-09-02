package cn.lfz.maybegame;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import java.io.Serializable;

public abstract class SingleFragmentActivity extends Activity
  implements Serializable
{
  private static final String FRAGMENT_TAG = "android.cn.lfz.maybegame.gamefragment";

  public abstract Fragment createFragment();

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
      paramBundle.remove("android.cn.lfz.maybegame.gamefragment");
    requestWindowFeature(1);
    setContentView(2130903042);
    FragmentManager localFragmentManager = getFragmentManager();
    if (localFragmentManager.findFragmentById(2131165197) == null)
    {
      Fragment localFragment = createFragment();
      localFragmentManager.beginTransaction().add(2131165197, localFragment, "android.cn.lfz.maybegame.gamefragment").commit();
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.maybegame.SingleFragmentActivity
 * JD-Core Version:    0.6.2
 */