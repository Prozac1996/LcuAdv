package cn.lfz.skilltree;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.lfz.person.Skill;
import java.io.Serializable;
import java.util.List;

public class SkillTreeItemAdapter extends ArrayAdapter<Skill>
  implements Serializable
{
  private Context context;
  private List<Skill> list;
  private int resoureId;

  public SkillTreeItemAdapter(Context paramContext, int paramInt, List<Skill> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.context = paramContext;
    this.list = paramList;
    this.resoureId = paramInt;
  }

  public int getCount()
  {
    return this.list.size();
  }

  public Skill getItem(int paramInt)
  {
    return (Skill)this.list.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Skill localSkill = (Skill)this.list.get(paramInt);
    View localView;
    ViewHolder localViewHolder;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.context).inflate(this.resoureId, null);
      localViewHolder = new ViewHolder();
      localViewHolder.SkillImage = ((ImageView)localView.findViewById(2131165271));
      localViewHolder.SkillName = ((TextView)localView.findViewById(2131165272));
      localViewHolder.SkillInfo = ((TextView)localView.findViewById(2131165273));
      localView.setTag(localViewHolder);
    }
    while (true)
    {
      localViewHolder.SkillImage.setBackgroundResource(localSkill.getImage());
      localViewHolder.SkillName.setText(localSkill.getName());
      localViewHolder.SkillInfo.setText(localSkill.getInfo());
      return localView;
      localView = paramView;
      localViewHolder = (ViewHolder)localView.getTag();
    }
  }

  class ViewHolder
  {
    ImageView SkillImage;
    TextView SkillInfo;
    TextView SkillName;

    ViewHolder()
    {
    }
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.skilltree.SkillTreeItemAdapter
 * JD-Core Version:    0.6.2
 */