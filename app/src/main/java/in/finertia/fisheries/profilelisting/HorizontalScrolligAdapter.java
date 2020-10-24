package in.finertia.fisheries.profilelisting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.finertia.fisheries.R;
import in.finertia.fisheries.model.MenuModel;


public class HorizontalScrolligAdapter extends RecyclerView.Adapter<HorizontalScrolligAdapter.ViewHolder> {

    private static Context context;
    private List<MenuModel> menuList;

    private HorizontalScrolligAdapter.OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, MenuModel menuModel, int position);
    }

    public void setOnItemClickListener(final HorizontalScrolligAdapter.OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public HorizontalScrolligAdapter(Context ctx, List<MenuModel> menuList){
        this.context=ctx;
        this.menuList=menuList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parentViewGroup, int i) {

        View rowView = LayoutInflater.from (parentViewGroup.getContext())
            .inflate(R.layout.listing_menu_child, parentViewGroup, false);

        return new ViewHolder (rowView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        final MenuModel model = menuList.get(position);
        Drawable icon = context.getResources().getDrawable(context.getResources().getIdentifier(model.getMenuIconName(),"drawable",context.getPackageName()));
        viewHolder.textViewSample.setText(model.getMenuName());
        viewHolder.ivIcon.setImageDrawable(icon);
        viewHolder.ivIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(view, menuList.get(position), position);
                }
            }
        });
    }


    @Override
    public int getItemCount() {

        return menuList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewSample;
        private final ImageView ivIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewSample = (TextView) itemView.findViewById(
                R.id.tvMenuName);
            ivIcon = (ImageView) itemView.findViewById(
                R.id.ivIcon);
        }
    }

}
