package cn.lfz.person;

import android.widget.Toast;
import cn.lfz.util.ApplicationUtils;
import java.io.Serializable;
import java.util.Random;

public class Person
  implements Serializable
{
  private static Person person;
  private Bag bag;
  private int exp_max;
  private int exp_now;
  private int gold;
  private int hp;
  private int hp_max;
  private int level;
  private int life;
  private MySkill mySkill;
  private MyTask myTask;
  private String name;
  private int point;
  private int power;
  private int speed;
  private int strong;
  private int study;

  private Person(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.name = paramString1;
    this.bag = new Bag();
    this.myTask = new MyTask();
    this.mySkill = new MySkill();
    this.gold = 900;
    this.exp_max = 10;
    this.exp_now = 0;
    this.level = 1;
    this.strong = Integer.parseInt(paramString2);
    this.speed = Integer.parseInt(paramString3);
    this.study = Integer.parseInt(paramString4);
    this.power = Integer.parseInt(paramString5);
    this.hp_max = 10;
    this.hp = 10;
    this.point = 0;
    this.life = 120;
  }

  public static Person createInstance(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    person = new Person(paramString1, paramString2, paramString3, paramString4, paramString5);
    return person;
  }

  public static Person getInstance()
  {
    return person;
  }

  public static void reload(Person paramPerson)
  {
    person = paramPerson;
  }

  private void upgrade()
  {
    this.exp_max = (2 * this.exp_max);
    this.exp_now -= this.exp_now;
    this.level = (1 + this.level);
    Toast.makeText(ApplicationUtils.getContext(), "你升级了！", 0).show();
    switch (new Random().nextInt(4))
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      this.point = (1 + this.point);
      this.hp_max = (3 + this.hp_max);
      this.hp = this.hp_max;
      return;
      this.strong = (1 + this.strong);
      continue;
      this.study = (1 + this.study);
      continue;
      this.speed = (1 + this.speed);
      continue;
      this.power = (1 + this.power);
    }
  }

  public void addHp(int paramInt)
  {
    this.hp = (paramInt + this.hp);
    if (this.hp > getHp_max())
      this.hp = getHp_max();
  }

  public Bag getBag()
  {
    return this.bag;
  }

  public int getExp_max()
  {
    return this.exp_max;
  }

  public int getExp_now()
  {
    return this.exp_now;
  }

  public int getGold()
  {
    return this.gold;
  }

  public int getHp()
  {
    return this.hp;
  }

  public int getHp_max()
  {
    return this.hp_max;
  }

  public int getLevel()
  {
    return this.level;
  }

  public int getLife()
  {
    return this.life;
  }

  public MySkill getMySkill()
  {
    return this.mySkill;
  }

  public MyTask getMyTask()
  {
    return this.myTask;
  }

  public String getName()
  {
    return this.name;
  }

  public int getPoint()
  {
    return this.point;
  }

  public int getPower()
  {
    return this.power;
  }

  public int getSpeed()
  {
    return this.speed;
  }

  public int getStrong()
  {
    return this.strong;
  }

  public int getStudy()
  {
    return this.study;
  }

  public void setBag(Bag paramBag)
  {
    this.bag = paramBag;
  }

  public void setExp_max(int paramInt)
  {
    this.exp_max = paramInt;
  }

  public void setExp_now(int paramInt)
  {
    this.exp_now = (paramInt + this.exp_now);
    if (this.exp_now > this.exp_max)
      upgrade();
  }

  public void setGold(int paramInt)
  {
    this.gold = (paramInt + this.gold);
  }

  public void setHp(int paramInt)
  {
    this.hp = 1;
  }

  public void setHp_max(int paramInt)
  {
    this.hp_max = (paramInt + this.hp_max);
  }

  public void setLife(int paramInt)
  {
    this.life = (paramInt + this.life);
  }

  public void setPoint(int paramInt)
  {
    this.point = paramInt;
  }

  public void setPower(int paramInt)
  {
    this.power = (paramInt + this.power);
  }

  public void setSpeed(int paramInt)
  {
    this.speed = (paramInt + this.speed);
  }

  public void setStrong(int paramInt)
  {
    this.strong = (paramInt + this.strong);
  }

  public void setStudy(int paramInt)
  {
    this.study = (paramInt + this.study);
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.person.Person
 * JD-Core Version:    0.6.2
 */