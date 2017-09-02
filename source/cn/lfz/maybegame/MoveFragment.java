package cn.lfz.maybegame;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import cn.lfz.person.Mission;
import cn.lfz.person.MyMission;
import java.io.Serializable;

public class MoveFragment extends Fragment
  implements View.OnClickListener, Serializable
{
  private Button canteen;
  private Button dafu;
  private Button dorm;
  private Button library;
  private Button num_ten;
  private Button pavilion;
  private Button pe;
  private Button rainbow_bridge;
  private Button south_gate;
  private Button trial;

  private void resultMove(MyMission paramMyMission)
  {
    if (!paramMyMission.isInto())
    {
      Toast.makeText(getActivity(), "暂未开放", 0).show();
      return;
    }
    Mission.getInstance().setNowMission(paramMyMission);
    sendResult(-1);
    getActivity().getFragmentManager().beginTransaction().remove(this).commit();
  }

  private void sendResult(int paramInt)
  {
    if (getTargetFragment() == null)
      return;
    Intent localIntent = new Intent();
    getTargetFragment().onActivityResult(getTargetRequestCode(), paramInt, localIntent);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131165239:
      resultMove(Mission.getInstance().getMyMissionByName("南大门"));
      return;
    case 2131165240:
      resultMove(Mission.getInstance().getMyMissionByName("实验楼"));
      return;
    case 2131165241:
      resultMove(Mission.getInstance().getMyMissionByName("计算机学院"));
      return;
    case 2131165247:
      resultMove(Mission.getInstance().getMyMissionByName("操场"));
      return;
    case 2131165244:
      resultMove(Mission.getInstance().getMyMissionByName("食堂"));
      return;
    case 2131165246:
      resultMove(Mission.getInstance().getMyMissionByName("彩虹桥"));
      return;
    case 2131165242:
      resultMove(Mission.getInstance().getMyMissionByName("大服"));
      return;
    case 2131165248:
      resultMove(Mission.getInstance().getMyMissionByName("图书馆"));
      return;
    case 2131165243:
      resultMove(Mission.getInstance().getMyMissionByName("紫藤公寓"));
      return;
    case 2131165245:
    }
    resultMove(Mission.getInstance().getMyMissionByName("湖上小亭"));
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903048, paramViewGroup, false);
    this.south_gate = ((Button)localView.findViewById(2131165239));
    this.trial = ((Button)localView.findViewById(2131165240));
    this.num_ten = ((Button)localView.findViewById(2131165241));
    this.dorm = ((Button)localView.findViewById(2131165243));
    this.dafu = ((Button)localView.findViewById(2131165242));
    this.library = ((Button)localView.findViewById(2131165248));
    this.rainbow_bridge = ((Button)localView.findViewById(2131165246));
    this.pe = ((Button)localView.findViewById(2131165247));
    this.canteen = ((Button)localView.findViewById(2131165244));
    this.pavilion = ((Button)localView.findViewById(2131165245));
    this.south_gate.setOnClickListener(this);
    this.trial.setOnClickListener(this);
    this.num_ten.setOnClickListener(this);
    this.dorm.setOnClickListener(this);
    this.dafu.setOnClickListener(this);
    this.library.setOnClickListener(this);
    this.rainbow_bridge.setOnClickListener(this);
    this.pe.setOnClickListener(this);
    this.canteen.setOnClickListener(this);
    this.pavilion.setOnClickListener(this);
    return localView;
  }

  public void onDestroy()
  {
    super.onDestroy();
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.maybegame.MoveFragment
 * JD-Core Version:    0.6.2
 */