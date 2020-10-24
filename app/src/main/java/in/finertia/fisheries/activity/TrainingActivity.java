package in.finertia.fisheries.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import in.finertia.fisheries.adapter.TrainingLVAdapter;
import in.finertia.fisheries.databinding.ActivityTrainingBinding;
import in.finertia.fisheries.model.TrainingModel;

public class TrainingActivity extends AppCompatActivity {

    private ActivityTrainingBinding binding;
    private List<TrainingModel>  trainingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrainingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        trainingList = new ArrayList<>();
        createTrainingList();
    }

    private void createTrainingList() {
        TrainingModel model;

        model = new TrainingModel();
        model.setDate("2");
        model.setMonthYear("Jan, 2020");
        model.setTrainingTitle("Fisherman training");
        model.setTrainingDetails("Fisherman will know how to do fishing in stormy season");
        trainingList.add(model);

        model = new TrainingModel();
        model.setDate("15");
        model.setMonthYear("Jan, 2020");
        model.setTrainingTitle("Sales training");
        model.setTrainingDetails("Sales person need to know about new market");
        trainingList.add(model);

        model = new TrainingModel();
        model.setDate("8");
        model.setMonthYear("Feb, 2020");
        model.setTrainingTitle("Vendors training");
        model.setTrainingDetails("New rules are changed for vendors listing");
        trainingList.add(model);

        model = new TrainingModel();
        model.setDate("22");
        model.setMonthYear("Feb, 2020");
        model.setTrainingTitle("Marketing training");
        model.setTrainingDetails("New markets are opened and training will be given");
        trainingList.add(model);

        model = new TrainingModel();
        model.setDate("17");
        model.setMonthYear("Mar, 2020");
        model.setTrainingTitle("Fisherman training");
        model.setTrainingDetails("Fisherman will know how to do fishing in stormy season");
        trainingList.add(model);

        TrainingLVAdapter adapter = new TrainingLVAdapter(this,trainingList);
        binding.lvTrainings.setAdapter(adapter);

    }
}