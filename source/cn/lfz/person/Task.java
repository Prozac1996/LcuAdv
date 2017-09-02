package cn.lfz.person;

import java.io.Serializable;

public class Task
  implements Serializable
{
  private String info;
  private String name;
  private String remand;
  private boolean status;

  public Task(String paramString1, String paramString2, String paramString3)
  {
    this.name = paramString1;
    this.info = paramString3;
    this.remand = paramString2;
    setStatus(false);
  }

  public String getInfo()
  {
    return this.info;
  }

  public String getName()
  {
    return this.name;
  }

  public String getRemand()
  {
    return this.remand;
  }

  public boolean isStatus()
  {
    return this.status;
  }

  public void setStatus(boolean paramBoolean)
  {
    this.status = paramBoolean;
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.person.Task
 * JD-Core Version:    0.6.2
 */