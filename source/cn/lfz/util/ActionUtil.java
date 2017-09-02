package cn.lfz.util;

import android.content.Context;
import android.widget.Toast;
import cn.lfz.person.Bag;
import cn.lfz.person.Item;
import cn.lfz.person.ItemLib;
import cn.lfz.person.Mission;
import cn.lfz.person.MyMission;
import cn.lfz.person.MySkill;
import cn.lfz.person.MyTask;
import cn.lfz.person.Person;
import cn.lfz.person.Skill;
import cn.lfz.person.SkillLib;
import cn.lfz.person.Task;
import cn.lfz.person.TaskLib;

public class ActionUtil
{
  public static void acceptMainTask(Context paramContext, String paramString)
  {
    Task localTask = TaskLib.getInstance().getTask(paramString);
    Person.getInstance().getMyTask().addMainTask(localTask);
    Toast.makeText(paramContext, "你接受了主线任务：" + localTask.getName(), 0).show();
  }

  public static void acceptOtherTask(Context paramContext, String paramString)
  {
    Task localTask = TaskLib.getInstance().getTask(paramString);
    Person.getInstance().getMyTask().addOtherTask(localTask);
    Toast.makeText(paramContext, "你接受了支线任务：" + localTask.getName(), 0).show();
  }

  public static void finishMainTask(Context paramContext, String paramString)
  {
    Task localTask = Person.getInstance().getMyTask().getMainTask(paramString);
    Toast.makeText(paramContext, "你完成了主线任务：" + localTask.getName(), 0).show();
    localTask.setStatus(true);
  }

  public static void finishOtherTask(Context paramContext, String paramString)
  {
    Task localTask = Person.getInstance().getMyTask().getOtherTask(paramString);
    Toast.makeText(paramContext, "你完成了支线任务：" + localTask.getName(), 0).show();
    localTask.setStatus(true);
  }

  public static void gainItem(Context paramContext, String paramString)
  {
    Item localItem = ItemLib.getInstance().getItem(paramString);
    Person.getInstance().getBag().addItem(localItem);
    Toast.makeText(paramContext, "你获得了物品：" + paramString, 0).show();
  }

  public static void loseItem(Context paramContext, String paramString)
  {
    Person.getInstance().getBag().deleteItem(paramString);
    Toast.makeText(paramContext, "你失去了物品：" + paramString, 0).show();
  }

  public static void openMap(Context paramContext, String paramString)
  {
    Mission.getInstance().getMyMissionByName(paramString).setInto(true);
    Toast.makeText(paramContext, "场景已开放：" + paramString, 0).show();
  }

  public static void studySkill(Context paramContext, String paramString)
  {
    Skill localSkill = SkillLib.getInstance().getSkill(paramString);
    Person.getInstance().getMySkill().addSkill(localSkill);
    Toast.makeText(paramContext, "你习得了技能：" + paramString, 0).show();
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.util.ActionUtil
 * JD-Core Version:    0.6.2
 */