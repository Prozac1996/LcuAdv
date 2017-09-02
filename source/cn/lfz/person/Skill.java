package cn.lfz.person;

import java.io.Serializable;

public abstract class Skill
  implements Serializable
{
  private int image;
  private String info;
  private String name;

  public Skill(String paramString1, String paramString2, int paramInt)
  {
    this.name = paramString1;
    this.info = paramString2;
    this.image = paramInt;
  }

  public abstract void Attr();

  public int getImage()
  {
    return this.image;
  }

  public String getInfo()
  {
    return this.info;
  }

  public String getName()
  {
    return this.name;
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.person.Skill
 * JD-Core Version:    0.6.2
 */