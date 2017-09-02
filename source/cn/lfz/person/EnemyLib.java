package cn.lfz.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnemyLib
  implements Serializable
{
  private static EnemyLib enemyLib;
  public List<Enemy> enemys = new ArrayList();

  private EnemyLib()
  {
    this.enemys.add(new Enemy("渣渣", 2130837554, 5, 1, ItemLib.getInstance().getItem("红龙卡"), 3));
    this.enemys.add(new Enemy("绩点", 2130837527, 5, 1, ItemLib.getInstance().getItem("红龙卡"), 3));
    this.enemys.add(new Enemy("黑化土豆", 2130837526, 5, 1, ItemLib.getInstance().getItem("红龙卡"), 3));
    this.enemys.add(new Enemy("没熟土豆", 2130837548, 5, 1, ItemLib.getInstance().getItem("红龙卡"), 3));
    this.enemys.add(new Enemy("人群", 2130837546, 5, 1, ItemLib.getInstance().getItem("红龙卡"), 3));
    this.enemys.add(new Enemy("情侣", 2130837526, 5, 1, ItemLib.getInstance().getItem("红龙卡"), 3));
    this.enemys.add(new Enemy("天边飞来的足球", 2130837556, 5, 1, ItemLib.getInstance().getItem("红龙卡"), 3));
    this.enemys.add(new Enemy("天边飞来的篮球", 2130837530, 5, 1, ItemLib.getInstance().getItem("红龙卡"), 3));
    this.enemys.add(new Enemy("编程课本", 2130837515, 5, 1, ItemLib.getInstance().getItem("红龙卡"), 3));
    this.enemys.add(new Enemy("英语书", 2130837519, 5, 1, ItemLib.getInstance().getItem("红龙卡"), 3));
    this.enemys.add(new Enemy("高等数学", 2130837522, 5, 1, ItemLib.getInstance().getItem("红龙卡"), 3));
    this.enemys.add(new Enemy("浓郁的气味", 2130837526, 5, 1, ItemLib.getInstance().getItem("红龙卡"), 3));
    this.enemys.add(new Enemy("偷壶贼", 2130837526, 5, 1, ItemLib.getInstance().getItem("红龙卡"), 3));
    this.enemys.add(new Enemy("偷被贼", 2130837526, 5, 1, ItemLib.getInstance().getItem("红龙卡"), 3));
  }

  public static EnemyLib getInstance()
  {
    if (enemyLib == null)
      enemyLib = new EnemyLib();
    return enemyLib;
  }

  public static void reload(EnemyLib paramEnemyLib)
  {
    enemyLib = paramEnemyLib;
  }

  public Enemy getEnemy(String paramString)
  {
    Iterator localIterator = this.enemys.iterator();
    Enemy localEnemy;
    do
    {
      if (!localIterator.hasNext())
        return null;
      localEnemy = (Enemy)localIterator.next();
    }
    while (localEnemy.getName() != paramString);
    return localEnemy;
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.person.EnemyLib
 * JD-Core Version:    0.6.2
 */