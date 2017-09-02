package cn.lfz.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ItemLib
  implements Serializable
{
  private static ItemLib itemLib;
  private Map<String, Item> map = new HashMap();

  private ItemLib()
  {
    initItem();
  }

  public static ItemLib getInstance()
  {
    if (itemLib == null)
      itemLib = new ItemLib();
    return itemLib;
  }

  private void initItem()
  {
    this.map.put("发票", new Item("发票", "领取被褥的时候需要的凭证。", 2130837521, 0, false)
    {
      public void use()
      {
      }
    });
    this.map.put("烤肠", new Item("烤肠", "大家都爱吃。可以回复5点体力值。", 2130837529, 2, true)
    {
      public void use()
      {
        Person.getInstance().addHp(2);
      }
    });
    this.map.put("冰露", new Item("冰露", "高端人士专用饮料。可以回复2点体力值。", 2130837504, 1, true)
    {
      public void use()
      {
        Person.getInstance().addHp(1);
      }
    });
    this.map.put("面包", new Item("面包", "食堂早饭最大的敌人。可以回复7点体力值。", 2130837508, 3, true)
    {
      public void use()
      {
        Person.getInstance().addHp(7);
      }
    });
    this.map.put("红龙卡", new Item("红龙卡", "渣渣的第一张传说卡,在其他游戏里可以召唤一堆龙。", 2130837545, 0, false)
    {
      public void use()
      {
      }
    });
  }

  public static void reload(ItemLib paramItemLib)
  {
    itemLib = paramItemLib;
  }

  public Item getItem(String paramString)
  {
    return (Item)this.map.get(paramString);
  }

  public ArrayList<Item> getShopItems()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(getItem("烤肠"));
    localArrayList.add(getItem("冰露"));
    localArrayList.add(getItem("面包"));
    return localArrayList;
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.person.ItemLib
 * JD-Core Version:    0.6.2
 */