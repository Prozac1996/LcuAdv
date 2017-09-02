package cn.lfz.person;

import java.io.Serializable;

public abstract class Item
  implements Serializable
{
  private boolean canUse;
  private int item_icon;
  private String item_info;
  private String item_name;
  private int price;

  public Item(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.item_name = paramString1;
    this.item_info = paramString2;
    this.item_icon = paramInt1;
    this.canUse = paramBoolean;
    this.price = paramInt2;
  }

  public int getItem_icon()
  {
    return this.item_icon;
  }

  public String getItem_info()
  {
    return this.item_info;
  }

  public String getItem_name()
  {
    return this.item_name;
  }

  public int getPrice()
  {
    return this.price;
  }

  public boolean isCanUse()
  {
    return this.canUse;
  }

  public void setItem_icon(int paramInt)
  {
    this.item_icon = paramInt;
  }

  public void setItem_info(String paramString)
  {
    this.item_info = paramString;
  }

  public void setItem_name(String paramString)
  {
    this.item_name = paramString;
  }

  public abstract void use();
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.person.Item
 * JD-Core Version:    0.6.2
 */