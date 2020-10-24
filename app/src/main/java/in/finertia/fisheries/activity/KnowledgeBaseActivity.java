package in.finertia.fisheries.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import in.finertia.fisheries.R;
import in.finertia.fisheries.adapter.VideoBannerAdapter;
import in.finertia.fisheries.model.VideoBannerModel;

public class KnowledgeBaseActivity extends AppCompatActivity {

    //private LinearLayout bannerLayout;
    private RecyclerView rvBannerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_base);
        rvBannerList = findViewById(R.id.rvBannerList);
        //bannerLayout = findViewById(R.id.bannerLayout);
        //getActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);
        initVideoBannerList();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initVideoBannerList(){
        List<VideoBannerModel> bannerModelList = new ArrayList<>();
        VideoBannerModel banner1 = new VideoBannerModel();
        banner1.setTitle("Indian Fisheries");
        banner1.setVideoId("lzCVD2ZZdY8"); //https://www.youtube.com/watch?v=-B1P6OqVx8E
        banner1.setThumbnailUrl("https://img.youtube.com/vi/lzCVD2ZZdY8/2.jpg");
        banner1.setVideoUrl("https://www.youtube.com/watch?v=lzCVD2ZZdY8");
        bannerModelList.add(banner1);

        VideoBannerModel banner2 = new VideoBannerModel();
        banner2.setTitle("Fisheries for small farmer");
        banner2.setVideoId("iV_t3VaNWXg");
        banner2.setThumbnailUrl("https://img.youtube.com/vi/iV_t3VaNWXg/2.jpg");
        banner2.setVideoUrl("https://www.youtube.com/watch?v=iV_t3VaNWXg");
        bannerModelList.add(banner2);

        VideoBannerModel banner3 = new VideoBannerModel();
        banner3.setTitle("How to Start Fish Farming in Odisha || Start Fish Farming Business in Odisha.");
        banner3.setVideoId("JY06tSIrQIc");
        banner3.setThumbnailUrl("https://img.youtube.com/vi/JY06tSIrQIc/2.jpg");
        banner3.setVideoUrl("https://www.youtube.com/watch?v=JY06tSIrQIc");
        bannerModelList.add(banner3);

        VideoBannerModel banner4 = new VideoBannerModel();
        banner4.setTitle("Hybrid Magur Fish Farming Business in India -Part2 | হাইব্রিড মাগুর চাষ | Catfish Farming");
        banner4.setVideoId("ahQueMY-O3U");
        banner4.setThumbnailUrl("https://img.youtube.com/vi/ahQueMY-O3U/2.jpg");
        banner4.setVideoUrl("https://www.youtube.com/watch?v=ahQueMY-O3U");
        bannerModelList.add(banner4);

        VideoBannerModel banner5 = new VideoBannerModel();
        banner5.setTitle("Hybrid Magur Fish Farming Business in India | Million Catfish Eating Food in Pond | হাইব্রিড মাগুর");
        banner5.setVideoId("sonWdMh7vzk");
        banner5.setThumbnailUrl("https://img.youtube.com/vi/sonWdMh7vzk/2.jpg");
        banner5.setVideoUrl("https://www.youtube.com/watch?v=sonWdMh7vzk");
        bannerModelList.add(banner5);

        VideoBannerModel banner6 = new VideoBannerModel();
        banner6.setTitle("ബയോ ഫ്ലോക്ക് അറിഞ്ഞിരിക്കേണ്ട ചില കാര്യങ്ങൾ | ബയോഫ്ലോക്ക് തുടങ്ങാൻ ആഗ്രഹിക്കുന്നവർ ഇത് കാണുക");
        banner6.setVideoId("XNvkHnuEsX8");
        banner6.setThumbnailUrl("https://img.youtube.com/vi/XNvkHnuEsX8/2.jpg");
        banner6.setVideoUrl("https://www.youtube.com/watch?v=XNvkHnuEsX8");
        bannerModelList.add(banner6);
        //showVerticalBannerList(bannerModelList); //show banner

        VideoBannerAdapter videoBannerAdapter = new VideoBannerAdapter(getApplicationContext(), bannerModelList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvBannerList.setLayoutManager(layoutManager);
        rvBannerList.setAdapter(videoBannerAdapter);
        videoBannerAdapter.setOnItemClickListener(new VideoBannerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, VideoBannerModel banner, int position) {
                Intent intent = new Intent(getApplicationContext(), YoutubePlayerActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("video_url", banner.getVideoId());
                bundle.putString("video_title", banner.getTitle());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}