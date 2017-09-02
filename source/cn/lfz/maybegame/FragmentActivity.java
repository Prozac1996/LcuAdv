package cn.lfz.maybegame;

import android.app.Fragment;
import java.io.Serializable;

public class FragmentActivity extends SingleFragmentActivity
  implements Serializable
{
  public Fragment createFragment()
  {
    return new GameFragment();
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.maybegame.FragmentActivity
 * JD-Core Version:    0.6.2
 */