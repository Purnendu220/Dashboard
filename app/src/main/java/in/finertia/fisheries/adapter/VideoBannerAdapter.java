package in.finertia.fisheries.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import in.finertia.fisheries.R;
import in.finertia.fisheries.model.VideoBannerModel;

public class VideoBannerAdapter extends RecyclerView.Adapter<VideoBannerAdapter.ViewHolder> {

    public Context mContext;
    public List<VideoBannerModel> bannerList;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, VideoBannerModel banner, int position);
    }

    public void setOnItemClickListener(final VideoBannerAdapter.OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout layoutParent;
        public ImageView ivBanner;
        public TextView tvTitle;

        public ViewHolder(View view) {
            super(view);
            layoutParent = view.findViewById(R.id.layoutParent);
            ivBanner = view.findViewById(R.id.ivBanner);
            tvTitle = view.findViewById(R.id.tvTitle);
        }
    }

    public VideoBannerAdapter(Context context, List<VideoBannerModel> _bannerList) {
        this.mContext = context;
        this.bannerList = _bannerList;
    }

    @NonNull
    @Override
    public VideoBannerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_vertical_card_list_info, parent, false);
        return new VideoBannerAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoBannerAdapter.ViewHolder holder, final int position) {
        VideoBannerModel bannerModel = bannerList.get(position);
        if(null != bannerModel){
            holder.tvTitle.setText(bannerModel.getTitle());
            Glide.with(mContext).load(bannerModel.getThumbnailUrl())
                    .apply(new RequestOptions()
                            .fitCenter()
                            .format(DecodeFormat.PREFER_ARGB_8888)
                            .override(Target.SIZE_ORIGINAL) //.override(200, 200)
                            .skipMemoryCache(true))
                    .into(holder.ivBanner);
            //.placeholder(R.drawable.placeholder_img)
        }
        holder.layoutParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(view, bannerList.get(position), position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }
    
}
