package cn.lfz.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MySkill
  implements Serializable
{
  private List<Skill> skillList = new ArrayList();

  public void addSkill(Skill paramSkill)
  {
    this.skillList.add(paramSkill);
  }

  public List<Skill> getSkills()
  {
    return this.skillList;
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.person.MySkill
 * JD-Core Version:    0.6.2
 */