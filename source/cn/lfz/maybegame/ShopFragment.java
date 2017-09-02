package cn.lfz.maybegame;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import cn.lfz.person.Bag;
import cn.lfz.person.Item;
import cn.lfz.person.ItemLib;
import cn.lfz.person.Person;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ShopFragment extends Fragment
  implements Serializable
{
  private GridView grid_view;
  ArrayList<Item> items;
  private TextView now_money;

  private List<? extends Map<String, ?>> getData()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.items.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localArrayList;
      Item localItem = (Item)localIterator.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("item_icon", Integer.valueOf(localItem.getItem_icon()));
      localHashMap.put("item_name", localItem.getItem_name());
      localArrayList.add(localHashMap);
    }
  }

  public void flushMoney()
  {
    this.now_money.setText(String.valueOf(Person.getInstance().getGold()));
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.items = ItemLib.getInstance().getShopItems();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903044, paramViewGroup, false);
    this.now_money = ((TextView)localView.findViewById(2131165213));
    this.grid_view = ((GridView)localView.findViewById(2131165212));
    this.now_money.setText(String.valueOf(Person.getInstance().getGold()));
    SimpleAdapter localSimpleAdapter = new SimpleAdapter(getActivity(), getData(), 2130903052, new String[] { "item_icon", "item_name" }, new int[] { 2131165184, 2131165185 });
    this.grid_view.setAdapter(localSimpleAdapter);
    this.grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        final Item localItem = (Item)ShopFragment.this.items.get(paramAnonymousInt);
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(ShopFragment.this.getActivity());
        localBuilder.setTitle("确定要买吗？");
        localBuilder.setMessage(localItem.getItem_name() + "\n" + localItem.getItem_info() + "\n" + "这需要花费你" + localItem.getPrice() + "元。");
        localBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            int i = localItem.getPrice();
            if (Person.getInstance().getGold() < i)
            {
              Toast.makeText(ShopFragment.this.getActivity(), "你没钱了", 0).show();
              return;
            }
            Person.getInstance().getBag().addItem(localItem);
            Person.getInstance().setGold(-i);
            ShopFragment.this.flushMoney();
            Toast.makeText(ShopFragment.this.getActivity(), "购买成功", 0).show();
          }
        });
        localBuilder.setNegativeButton("不要", null);
        localBuilder.create().show();
      }
    });
    return localView;
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.maybegame.ShopFragment
 * JD-Core Version:    0.6.2
 */