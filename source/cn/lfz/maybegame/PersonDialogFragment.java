package cn.lfz.maybegame;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import cn.lfz.person.Person;
import java.io.Serializable;

public class PersonDialogFragment extends DialogFragment
  implements View.OnClickListener, Serializable
{
  private ProgressBar exp_bar;
  private TextView gold;
  private Person person;
  private TextView person_exp;
  private TextView person_level;
  private TextView person_name;
  private TextView person_point;
  private TextView person_power;
  private Button person_power_add;
  private TextView person_speed;
  private Button person_speed_add;
  private TextView person_strong;
  private Button person_strong_add;
  private TextView person_study;
  private Button person_study_add;
  private View v;

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131165258:
    case 2131165260:
    case 2131165262:
    default:
      return;
    case 2131165257:
      if (this.person.getPoint() > 0)
      {
        this.person.setStrong(1);
        this.person_strong.setText(this.person.getStrong());
        this.person.setPoint(-1 + this.person.getPoint());
        this.person_point.setText(this.person.getPoint());
        return;
      }
      Toast.makeText(getActivity(), "无可用属性点", 0).show();
      return;
    case 2131165259:
      if (this.person.getPoint() > 0)
      {
        this.person.setSpeed(1);
        this.person_speed.setText(this.person.getSpeed());
        this.person.setPoint(-1 + this.person.getPoint());
        this.person_point.setText(this.person.getPoint());
        return;
      }
      Toast.makeText(getActivity(), "无可用属性点", 0).show();
      return;
    case 2131165261:
      if (this.person.getPoint() > 0)
      {
        this.person.setStudy(1);
        this.person_study.setText(this.person.getStudy());
        this.person.setPoint(-1 + this.person.getPoint());
        this.person_point.setText(this.person.getPoint());
        return;
      }
      Toast.makeText(getActivity(), "无可用属性点", 0).show();
      return;
    case 2131165263:
    }
    if (this.person.getPoint() > 0)
    {
      this.person.setPower(1);
      this.person_power.setText(this.person.getPower());
      this.person.setPoint(-1 + this.person.getPoint());
      this.person_point.setText(this.person.getPoint());
      return;
    }
    Toast.makeText(getActivity(), "无可用属性点", 0).show();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.v = getActivity().getLayoutInflater().inflate(2130903051, null);
    this.gold = ((TextView)this.v.findViewById(2131165270));
    this.person_name = ((TextView)this.v.findViewById(2131165202));
    this.person_level = ((TextView)this.v.findViewById(2131165253));
    this.person_exp = ((TextView)this.v.findViewById(2131165255));
    this.person_strong = ((TextView)this.v.findViewById(2131165256));
    this.person_speed = ((TextView)this.v.findViewById(2131165258));
    this.person_study = ((TextView)this.v.findViewById(2131165260));
    this.person_power = ((TextView)this.v.findViewById(2131165262));
    this.person_point = ((TextView)this.v.findViewById(2131165264));
    this.exp_bar = ((ProgressBar)this.v.findViewById(2131165254));
    this.person_strong_add = ((Button)this.v.findViewById(2131165257));
    this.person_speed_add = ((Button)this.v.findViewById(2131165259));
    this.person_study_add = ((Button)this.v.findViewById(2131165261));
    this.person_power_add = ((Button)this.v.findViewById(2131165263));
    this.person_strong_add.setOnClickListener(this);
    this.person_speed_add.setOnClickListener(this);
    this.person_study_add.setOnClickListener(this);
    this.person_power_add.setOnClickListener(this);
    this.person = Person.getInstance();
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    this.person_name.setText(this.person.getName());
    this.person_level.setText(this.person.getLevel());
    this.person_exp.setText(this.person.getExp_now() + "/" + this.person.getExp_max());
    this.exp_bar.setMax(this.person.getExp_max());
    this.exp_bar.setProgress(this.person.getExp_now());
    this.person_strong.setText(this.person.getStrong());
    this.person_speed.setText(this.person.getSpeed());
    this.person_study.setText(this.person.getStudy());
    this.person_power.setText(this.person.getPower());
    this.person_point.setText(this.person.getPoint());
    this.gold.setText(this.person.getGold());
    return new AlertDialog.Builder(getActivity()).setView(this.v).create();
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.maybegame.PersonDialogFragment
 * JD-Core Version:    0.6.2
 */