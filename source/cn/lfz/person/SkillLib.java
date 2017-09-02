package cn.lfz.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SkillLib
  implements Serializable
{
  private static SkillLib skillLib;
  private List<Skill> skills = new ArrayList();

  private SkillLib()
  {
    this.skills.add(new Skill("测试技能", "萌萌哒", 2130837525)
    {
      public void Attr()
      {
      }
    });
  }

  public static SkillLib getInstance()
  {
    if (skillLib == null)
      skillLib = new SkillLib();
    return skillLib;
  }

  public static void reload(SkillLib paramSkillLib)
  {
    skillLib = paramSkillLib;
  }

  public Skill getSkill(String paramString)
  {
    Iterator localIterator = this.skills.iterator();
    Skill localSkill;
    do
    {
      if (!localIterator.hasNext())
        return null;
      localSkill = (Skill)localIterator.next();
    }
    while (!localSkill.getName().equals(paramString));
    return localSkill;
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.person.SkillLib
 * JD-Core Version:    0.6.2
 */