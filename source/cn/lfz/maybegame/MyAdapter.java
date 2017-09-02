package cn.lfz.maybegame;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

class MyAdapter extends PagerAdapter
{
  public List<View> listViews;

  public MyAdapter(ArrayList<View> paramArrayList)
  {
    this.listViews = paramArrayList;
  }

  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewPager)paramView).removeView((View)this.listViews.get(paramInt));
  }

  public int getCount()
  {
    return this.listViews.size();
  }

  public Object instantiateItem(View paramView, int paramInt)
  {
    ((ViewPager)paramView).addView((View)this.listViews.get(paramInt), 0);
    return this.listViews.get(paramInt);
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.maybegame.MyAdapter
 * JD-Core Version:    0.6.2
 */