package in.finertia.fisheries.profilelisting;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import in.finertia.fisheries.R;
import in.finertia.fisheries.enums.MenuServiceType;
import in.finertia.fisheries.model.MenuModel;

public class ProfileListing extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_listing);

        setUpHorizontalMenuList();
         // RecyclerView
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        // RecyclerView layout manager
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        // RecyclerView ItemDecoration (divider)
        final RecyclerView.ItemDecoration itemDecoration = new SampleDivider(this);
        recyclerView.addItemDecoration(itemDecoration);

        // RecyclerView adapter
        final SampleRecyclerAdapter sampleRecyclerAdapter = new SampleRecyclerAdapter(this);
        recyclerView.setAdapter(sampleRecyclerAdapter);

    }

    private void setUpHorizontalMenuList() {
        List<MenuModel> menuList = new ArrayList<>();
        MenuModel model;

        model = new MenuModel();
        model.setMenuServiceType(MenuServiceType.FISHERS);
        model.setMenuName("Fishers");
        model.setMenuIconName("ic_fishers");
        menuList.add(model);

        model = new MenuModel();
        model.setMenuServiceType(MenuServiceType.FISHERMAN);
        model.setMenuName("Fishermen");
        model.setMenuIconName("ic_fish_farmer");
        menuList.add(model);

        model = new MenuModel();
        model.setMenuServiceType(MenuServiceType.FISH_VENDORS);
        model.setMenuName("Fish vendors");
        model.setMenuIconName("ic_fish_vendor");
        menuList.add(model);

        model = new MenuModel();
        model.setMenuServiceType(MenuServiceType.BUYERS);
        model.setMenuName("Buyers");
        model.setMenuIconName("ic_buyer");
        menuList.add(model);

        model = new MenuModel();
        model.setMenuServiceType(MenuServiceType.SUPPLIERS);
        model.setMenuName("Suppliers");
        model.setMenuIconName("ic_supplier");
        menuList.add(model);

        HorizontalScrolligAdapter horizontalAdapter = new HorizontalScrolligAdapter(this,menuList);

        RecyclerView mHorizontalRecyclerView =(RecyclerView)findViewById(R.id.recycler_view_horizontal);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(ProfileListing.this, LinearLayoutManager.HORIZONTAL, false);
        mHorizontalRecyclerView.setLayoutManager(horizontalLayoutManager);
        mHorizontalRecyclerView.setAdapter(horizontalAdapter);

        horizontalAdapter.setOnItemClickListener(new HorizontalScrolligAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, MenuModel menuModel, int position) {
                fetchMenuData(menuModel);
            }
        });
    }

    private void fetchMenuData(MenuModel menuModel) {

    }
}
