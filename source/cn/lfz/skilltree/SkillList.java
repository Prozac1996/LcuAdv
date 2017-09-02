package cn.lfz.skilltree;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import cn.lfz.person.MySkill;
import cn.lfz.person.Person;
import cn.lfz.person.Skill;
import java.io.Serializable;
import java.util.List;

public class SkillList extends Fragment
  implements Serializable
{
  private List<Skill> list;
  private ListView list_view;

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.list = Person.getInstance().getMySkill().getSkills();
    View localView = paramLayoutInflater.inflate(2130903054, paramViewGroup, false);
    this.list_view = ((ListView)localView.findViewById(2131165274));
    SkillTreeItemAdapter localSkillTreeItemAdapter = new SkillTreeItemAdapter(getActivity(), 2130903053, this.list);
    this.list_view.setAdapter(localSkillTreeItemAdapter);
    return localView;
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.skilltree.SkillList
 * JD-Core Version:    0.6.2
 */