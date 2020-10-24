package in.finertia.fisheries.profilelisting;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.finertia.fisheries.R;


public class SampleRecyclerAdapter extends RecyclerView.Adapter<SampleRecyclerAdapter.ViewHolder> {

    private final ArrayList<SampleModel> sampleData = DemoApp.getSampleData(20);
    private static Context context;
    public SampleRecyclerAdapter(Context ctx){
        context=ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parentViewGroup, int i) {

        View rowView = LayoutInflater.from (parentViewGroup.getContext())
            .inflate(R.layout.list_basic_item, parentViewGroup, false);

        return new ViewHolder (rowView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        final SampleModel rowData = sampleData.get(position);
        viewHolder.textViewSample.setText(rowData.getSampleText());

        viewHolder.itemView.setTag(rowData);
    }


    @Override
    public int getItemCount() {

        return sampleData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewSample;
        private  LinearLayout item_layout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewSample = (TextView) itemView.findViewById(
                R.id.textViewSample);
            item_layout =(LinearLayout) itemView.findViewById(
                    R.id.item_layout);
            item_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, ProfileActivity.class);
                    context.startActivity(i);
                }
            });
        }
    }

}
