package cn.lfz.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bag
  implements Serializable
{
  private List<Item> items = new ArrayList();

  public void addItem(Item paramItem)
  {
    this.items.add(paramItem);
  }

  public void deleteItem(String paramString)
  {
    Iterator localIterator = this.items.iterator();
    Item localItem;
    do
    {
      if (!localIterator.hasNext())
        return;
      localItem = (Item)localIterator.next();
    }
    while (!localItem.getItem_name().equals(paramString));
    this.items.remove(localItem);
  }

  public List<Item> getItems()
  {
    return this.items;
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.person.Bag
 * JD-Core Version:    0.6.2
 */