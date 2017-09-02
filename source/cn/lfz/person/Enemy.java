package cn.lfz.person;

import java.io.Serializable;

public class Enemy
  implements Serializable
{
  private int damage;
  private int exp;
  private int hp;
  private int icon;
  private Item item;
  private String name;

  public Enemy(String paramString, int paramInt1, int paramInt2, int paramInt3, Item paramItem, int paramInt4)
  {
    this.name = paramString;
    this.icon = paramInt1;
    this.hp = paramInt2;
    setDamage(paramInt3);
    this.item = paramItem;
    this.exp = paramInt4;
  }

  public int getDamage()
  {
    return this.damage;
  }

  public int getExp()
  {
    return this.exp;
  }

  public int getHp()
  {
    return this.hp;
  }

  public int getIcon()
  {
    return this.icon;
  }

  public Item getItem()
  {
    return this.item;
  }

  public String getName()
  {
    return this.name;
  }

  public void setDamage(int paramInt)
  {
    this.damage = paramInt;
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.person.Enemy
 * JD-Core Version:    0.6.2
 */