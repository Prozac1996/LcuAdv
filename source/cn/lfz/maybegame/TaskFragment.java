package cn.lfz.maybegame;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import cn.lfz.person.MyTask;
import cn.lfz.person.Person;
import cn.lfz.person.Task;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TaskFragment extends Fragment
  implements View.OnClickListener, Serializable
{
  private Display display;
  private ArrayList<View> listViews;
  private LinearLayout.LayoutParams lp;
  private ImageView mTabline;
  private TextView main_text;
  private View main_view;
  private DisplayMetrics metrics;
  private TextView other_text;
  private View other_view;
  private ViewPager viewPager;
  private int width;

  private List<? extends Map<String, ?>> getItem(ArrayList<Task> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    new HashMap();
    Iterator localIterator = paramArrayList.iterator();
    Task localTask;
    do
    {
      if (!localIterator.hasNext())
        return localArrayList;
      localTask = (Task)localIterator.next();
    }
    while (localTask == null);
    HashMap localHashMap = new HashMap();
    localHashMap.put("task_name", localTask.getName());
    localHashMap.put("task_info", localTask.getInfo());
    localHashMap.put("task_remand", localTask.getRemand());
    if (localTask.isStatus())
      localHashMap.put("task_status", Integer.valueOf(2130837538));
    while (true)
    {
      localArrayList.add(localHashMap);
      break;
      localHashMap.put("task_status", Integer.valueOf(2130837542));
    }
  }

  private void initTask()
  {
    ((ListView)this.main_view.findViewById(2131165238)).setAdapter(new SimpleAdapter(getActivity(), getItem(Person.getInstance().getMyTask().getMainTasks()), 2130903056, new String[] { "task_name", "task_info", "task_remand", "task_status" }, new int[] { 2131165280, 2131165282, 2131165281, 2131165279 }));
    ((ListView)this.other_view.findViewById(2131165252)).setAdapter(new SimpleAdapter(getActivity(), getItem(Person.getInstance().getMyTask().getOtherTasks()), 2130903056, new String[] { "task_name", "task_info", "task_remand", "task_status" }, new int[] { 2131165280, 2131165282, 2131165281, 2131165279 }));
  }

  private void initViewPager()
  {
    this.listViews = new ArrayList();
    LayoutInflater localLayoutInflater = LayoutInflater.from(getActivity());
    this.main_view = localLayoutInflater.inflate(2130903047, null);
    this.other_view = localLayoutInflater.inflate(2130903050, null);
    this.listViews.add(this.main_view);
    this.listViews.add(this.other_view);
    this.viewPager.setAdapter(new MyAdapter(this.listViews));
    this.viewPager.setCurrentItem(0);
    this.main_text.setTextColor(-16777216);
    this.other_text.setTextColor(2263842);
    this.viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt)
      {
      }

      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        TaskFragment.this.lp.leftMargin = ((int)((paramAnonymousFloat + paramAnonymousInt1) * TaskFragment.this.width));
        TaskFragment.this.mTabline.setLayoutParams(TaskFragment.this.lp);
      }

      public void onPageSelected(int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 0:
          TaskFragment.this.main_text.setTextColor(-16777216);
          TaskFragment.this.other_text.setTextColor(2263842);
          return;
        case 1:
        }
        TaskFragment.this.main_text.setTextColor(2263842);
        TaskFragment.this.other_text.setTextColor(-16777216);
      }
    });
  }

  private void initWidth()
  {
    this.lp = ((LinearLayout.LayoutParams)this.mTabline.getLayoutParams());
    this.width = (this.metrics.widthPixels / 2);
    this.lp.width = this.width;
    this.mTabline.setLayoutParams(this.lp);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165275:
      this.viewPager.setCurrentItem(0);
      return;
    case 2131165276:
    }
    this.viewPager.setCurrentItem(1);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.display = getActivity().getWindowManager().getDefaultDisplay();
    this.metrics = new DisplayMetrics();
    this.display.getMetrics(this.metrics);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903055, paramViewGroup, false);
    this.viewPager = ((ViewPager)localView.findViewById(2131165278));
    this.mTabline = ((ImageView)localView.findViewById(2131165277));
    this.main_text = ((TextView)localView.findViewById(2131165275));
    this.other_text = ((TextView)localView.findViewById(2131165276));
    this.main_text.setOnClickListener(this);
    this.other_text.setOnClickListener(this);
    initWidth();
    initViewPager();
    initTask();
    return localView;
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.maybegame.TaskFragment
 * JD-Core Version:    0.6.2
 */