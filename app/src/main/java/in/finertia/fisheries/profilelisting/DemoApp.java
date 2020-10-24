package in.finertia.fisheries.profilelisting;

import java.util.ArrayList;

/**
 * Created by wtf on 06/10/14.
 */
public class DemoApp {

    public static ArrayList<SampleModel> getSampleData (int size) {

        ArrayList<SampleModel> sampleData = new ArrayList<SampleModel>(size);

        for (int i = 0; i < size; i++) {
            sampleData.add(new SampleModel("Krishna  "+i));
        }

        return sampleData;

    }
}
