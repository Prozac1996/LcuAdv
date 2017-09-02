package cn.lfz.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class MyTask
  implements Serializable
{
  private ArrayList<Task> mainTasks = new ArrayList();
  private ArrayList<Task> otherTasks;

  public MyTask()
  {
    this.mainTasks.add(TaskLib.getInstance().getTask("生存之曙光"));
    this.otherTasks = new ArrayList();
    this.otherTasks.add(TaskLib.getInstance().getTask("支线任务"));
  }

  public void addMainTask(Task paramTask)
  {
    this.mainTasks.add(paramTask);
  }

  public void addOtherTask(Task paramTask)
  {
    this.otherTasks.add(paramTask);
  }

  public Task getMainTask(String paramString)
  {
    Iterator localIterator = this.mainTasks.iterator();
    Task localTask;
    do
    {
      if (!localIterator.hasNext())
        return null;
      localTask = (Task)localIterator.next();
    }
    while (!localTask.getName().equals(paramString));
    return localTask;
  }

  public ArrayList<Task> getMainTasks()
  {
    return this.mainTasks;
  }

  public Task getOtherTask(String paramString)
  {
    Iterator localIterator = this.otherTasks.iterator();
    Task localTask;
    do
    {
      if (!localIterator.hasNext())
        return null;
      localTask = (Task)localIterator.next();
    }
    while ((localTask == null) || (!localTask.getName().equals(paramString)));
    return localTask;
  }

  public ArrayList<Task> getOtherTasks()
  {
    return this.otherTasks;
  }

  public void setMainTasks(ArrayList<Task> paramArrayList)
  {
    this.mainTasks = paramArrayList;
  }

  public void setOtherTasks(ArrayList<Task> paramArrayList)
  {
    this.otherTasks = paramArrayList;
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.person.MyTask
 * JD-Core Version:    0.6.2
 */