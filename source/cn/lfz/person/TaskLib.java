package cn.lfz.person;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TaskLib
  implements Serializable
{
  private static TaskLib taskLib;
  private Map<String, Task> tasks = new HashMap();

  private TaskLib()
  {
    this.tasks.put("生存之曙光", new Task("生存之曙光", "你进入了这所大学，而生命是一切的基础，你能平安度过你的大学时光吗？", "活到毕业"));
    this.tasks.put("报道", new Task("报道", "到达十号楼", "新生怎么能不先报道呢，不报道怎么获得和学长学姐接触的机会呢？"));
    this.tasks.put("回宿舍", new Task("回宿舍", "目标，紫藤6", "宿舍是什么样的呢？期待啊。"));
    this.tasks.put("班会", new Task("班会", "去班里开班会", "大学怎么能少了班会呢？天真少年的梦想要破灭了。"));
    this.tasks.put("丢失的狗", new Task("丢失的狗", "未知", "老人丢失了一条狗，不知道会在哪里呢？"));
  }

  public static TaskLib getInstance()
  {
    if (taskLib == null)
      taskLib = new TaskLib();
    return taskLib;
  }

  public static void reload(TaskLib paramTaskLib)
  {
    taskLib = paramTaskLib;
  }

  public Task getTask(String paramString)
  {
    return (Task)this.tasks.get(paramString);
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.person.TaskLib
 * JD-Core Version:    0.6.2
 */