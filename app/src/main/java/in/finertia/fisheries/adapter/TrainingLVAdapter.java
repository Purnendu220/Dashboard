package in.finertia.fisheries.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import in.finertia.fisheries.R;
import in.finertia.fisheries.model.TrainingModel;

public class TrainingLVAdapter extends BaseAdapter {

    private Context context;
    private List<TrainingModel> trainingList;

    public TrainingLVAdapter(Context context, List<TrainingModel> trainingList) {
        this.context = context;
        this.trainingList = trainingList;
    }

    @Override
    public int getCount() {
        return trainingList.size();
    }

    @Override
    public Object getItem(int i) {
        return trainingList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.training_lv_child,null);
        TextView tvDate = view.findViewById(R.id.tvDate);
        TextView tvMonthYear = view.findViewById(R.id.tvMonthYear);
        TextView tvTitle = view.findViewById(R.id.tvTrainTitle);
        TextView tvDetails = view.findViewById(R.id.tvTrainDetails);

        TrainingModel model = (TrainingModel)getItem(i);
        tvDate.setText(model.getDate());
        tvMonthYear.setText(model.getMonthYear());
        tvTitle.setText(model.getTrainingTitle());
        tvDetails.setText(model.getTrainingDetails());
        return view;
    }
}
