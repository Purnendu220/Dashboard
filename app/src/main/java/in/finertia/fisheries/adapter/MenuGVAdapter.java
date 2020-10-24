package in.finertia.fisheries.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import in.finertia.fisheries.databinding.DashboardMenuChildBinding;
import in.finertia.fisheries.model.MenuModel;

public class MenuGVAdapter extends BaseAdapter {

    private Context context;
    private List<MenuModel> menuList;
    private DashboardMenuChildBinding binding;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, MenuModel menuModel, int position);
    }

    public void setOnItemClickListener(final MenuGVAdapter.OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public MenuGVAdapter(Context context, List<MenuModel> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    @Override
    public int getCount() {
        return menuList.size();
    }

    @Override
    public Object getItem(int i) {
        return menuList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        binding = DashboardMenuChildBinding.inflate(LayoutInflater.from(context));
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            view = binding.getRoot();
            holder.ivIcon = binding.ivIcon;
            holder.tvMenu = binding.tvMenuName;
            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }
        try {
            MenuModel model = (MenuModel) getItem(position);
            //Drawable icon = context.getResources().getDrawable(context.getResources().getIdentifier(model.getMenuIconName(),"drawable",context.getPackageName()));
            holder.tvMenu.setText(model.getMenuName());
            holder.ivIcon.setImageDrawable(model.getMenuIcon());
        }catch (Exception e){
            Log.e("Error", "Error on MenuGVAdapter! ex: "+e.getMessage());
        }
        holder.ivIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(view, menuList.get(position), position);
                }
            }
        });
        return view;
    }

    private class ViewHolder{
        ImageView ivIcon;
        TextView tvMenu;
    }
}
