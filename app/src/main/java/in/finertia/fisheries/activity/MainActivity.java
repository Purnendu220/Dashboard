package in.finertia.fisheries.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import in.finertia.fisheries.R;
import in.finertia.fisheries.adapter.MenuGVAdapter;
import in.finertia.fisheries.databinding.ActivityMainBinding;
import in.finertia.fisheries.enums.MenuServiceType;
import in.finertia.fisheries.model.MenuModel;
import in.finertia.fisheries.profilelisting.ProfileActivity;
import in.finertia.fisheries.profilelisting.ProfileListing;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView bottomNavigationView;
    private BottomNavigationView topNavigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        setNavView();
        setActionBar();
        setDashboardMenu();
    }

    private void setNavView() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        //bottom and top navigation
        bottomNavigationView = findViewById(R.id.bottomNavigationView); //Bottom navigation View
        topNavigationView = findViewById(R.id.topNavigationView); //Bottom navigation View
        //bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //topNavigationView.setOnNavigationItemSelectedListener(mOnTopNavigationItemSelectedListener);
        ImageView ivListing = findViewById(R.id.ivListing);
        ImageView ivKnowledgeBase = findViewById(R.id.ivKnowledgeBase);
        ImageView ivPMMSY = findViewById(R.id.ivPMMSY);
        ImageView ivWeather = findViewById(R.id.ivWeather);
        ImageView ivFisher = findViewById(R.id.ivFisher);
        ImageView ivFishFarmer = findViewById(R.id.ivFishFarmer);
        ImageView ivFishVendor = findViewById(R.id.ivFishVendor);
        ImageView ivSupplier = findViewById(R.id.ivSupplier);

        ivListing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileListing.class).putExtra("type", MenuServiceType.NONE));
            }
        });
        ivKnowledgeBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, KnowledgeBaseActivity.class));
            }
        });
        ivPMMSY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileListing.class).putExtra("type", MenuServiceType.PMMSY_SCHEME));
            }
        });
        ivWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileListing.class).putExtra("type", MenuServiceType.REAL_TIME_WEATHER));
            }
        });
        ivFisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileListing.class).putExtra("type", MenuServiceType.FISHERS));
            }
        });
        ivFishFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileListing.class).putExtra("type", MenuServiceType.FISHERMAN));
            }
        });
        ivFishVendor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileListing.class).putExtra("type", MenuServiceType.FISH_VENDORS));
            }
        });
        ivSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileListing.class).putExtra("type", MenuServiceType.SUPPLIERS));
            }
        });
    }

    private void setActionBar() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.hamburger_icon);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.training) {
            Intent i = new Intent(MainActivity.this, TrainingCalenderActivity.class);
            startActivity(i);
            return true;
        }
        else if (item.getItemId() == R.id.knowledgeBase) {
            Intent i = new Intent(MainActivity.this, KnowledgeBaseActivity.class);
            startActivity(i);
            return true;
        } if (item.getItemId() == R.id.about_us) {
            Intent i = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(i);
            return true;
        } if (item.getItemId() == R.id.nav_fishers) {
            Intent i = new Intent(MainActivity.this, ProfileListing.class);
            startActivity(i);
            return true;
        } if (item.getItemId() == R.id.nav_fisherman) {
            Intent i = new Intent(MainActivity.this, ProfileListing.class);
            startActivity(i);
            return true;
        } if (item.getItemId() == R.id.nav_fishvendor) {
            Intent i = new Intent(MainActivity.this, ProfileListing.class);
            startActivity(i);
            return true;
        } if (item.getItemId() == R.id.nav_buyers) {
            Intent i = new Intent(MainActivity.this, ProfileListing.class);
            startActivity(i);
            return true;
        } if (item.getItemId() == R.id.nav_supplier) {
            Intent i = new Intent(MainActivity.this, ProfileListing.class);
            startActivity(i);
            return true;
        } else {
            return false;
        }
    }

    private void setDashboardMenu() {
        List<MenuModel> menuList = new ArrayList<>();
        MenuModel model;

        model = new MenuModel();
        model.setMenuServiceType(MenuServiceType.NONE);
        model.setMenuName("Fish Feeds");
        model.setMenuIcon(getDrawable(R.drawable.ic_fish_feeds));
        menuList.add(model);

        model = new MenuModel();
        model.setMenuServiceType(MenuServiceType.NONE);
        model.setMenuName("Seeds & Fingerling");
        model.setMenuIcon(getDrawable(R.drawable.ic_seeds_fingerlings));
        menuList.add(model);

        model = new MenuModel();
        model.setMenuServiceType(MenuServiceType.NONE);
        model.setMenuName("Hatchery");
        model.setMenuIcon(getDrawable(R.drawable.ic_hatchery));
        menuList.add(model);

        model = new MenuModel();
        model.setMenuServiceType(MenuServiceType.NONE);
        model.setMenuName("Buyers");
        model.setMenuIcon(getDrawable(R.drawable.ic_buyer));
        menuList.add(model);

        model = new MenuModel();
        model.setMenuServiceType(MenuServiceType.NONE);
        model.setMenuName("Pond Management");
        model.setMenuIcon(getDrawable(R.drawable.ic_pond_management));
        menuList.add(model);

        model = new MenuModel();
        model.setMenuServiceType(MenuServiceType.NONE);
        model.setMenuName("Training Provider");
        model.setMenuIcon(getDrawable(R.drawable.ic_training));
        menuList.add(model);

        model = new MenuModel();
        model.setMenuServiceType(MenuServiceType.NONE);
        model.setMenuName("Laboratories");
        model.setMenuIcon(getDrawable(R.drawable.ic_lab));
        menuList.add(model);

        model = new MenuModel();
        model.setMenuServiceType(MenuServiceType.NONE);
        model.setMenuName("Fishing Gears");
        model.setMenuIcon(getDrawable(R.drawable.ic_gears));
        menuList.add(model);

        model = new MenuModel();
        model.setMenuServiceType(MenuServiceType.NONE);
        model.setMenuName("Processing Units");
        model.setMenuIcon(getDrawable(R.drawable.ic_processing));
        menuList.add(model);

        MenuGVAdapter adapter = new MenuGVAdapter(this,menuList);
        binding.gvDashboard.setAdapter(adapter);
        adapter.setOnItemClickListener(new MenuGVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, MenuModel menuModel, int position) {
                openActivityAsPerServiceType(menuModel);
            }
        });
    }

    private void openActivityAsPerServiceType(MenuModel menuModel){
        switch (menuModel.getMenuServiceType()){
            case KNOWLEDGE_BASE:{
                Intent i = new Intent(MainActivity.this, KnowledgeBaseActivity.class);
                startActivity(i);
                break;
            }
            case FISHERS:case FISHERMAN:case FISH_VENDORS:case BUYERS:case SUPPLIERS: {
                startActivity(new Intent(MainActivity.this, ProfileListing.class).putExtra("type",menuModel.getMenuServiceType()));
                break;
            }
        }
    }

    /*private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.layoutListing : {
                    //mNavigationManager.showHomeFragmentAction();
                    startActivity(new Intent(MainActivity.this, ProfileListing.class).putExtra("type", MenuServiceType.NONE));
                    return true;
                }
                case R.id.layoutKnowledgeBase:{
                    startActivity(new Intent(MainActivity.this, KnowledgeBaseActivity.class));
                    return true;
                }
                case R.id.layoutPMMSY : {
                    startActivity(new Intent(MainActivity.this, ProfileListing.class).putExtra("type",  MenuServiceType.PMMSY_SCHEME));
                    return true;
                }
                case R.id.layoutWeather : {
                    startActivity(new Intent(MainActivity.this, ProfileListing.class).putExtra("type", MenuServiceType.REAL_TIME_WEATHER));
                    return true;
                }
            }
            return false;
        }
    };*/

   /* private BottomNavigationView.OnNavigationItemSelectedListener mOnTopNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.layoutFisher : {
                    //mNavigationManager.showHomeFragmentAction();
                    startActivity(new Intent(MainActivity.this, ProfileListing.class).putExtra("type", MenuServiceType.FISHERS));
                    return true;
                }
                case R.id.layoutFishFarmer:{
                    startActivity(new Intent(MainActivity.this, ProfileListing.class).putExtra("type",  MenuServiceType.FISHERMAN));
                    return true;
                }
                case R.id.layoutFishVendor : {
                    startActivity(new Intent(MainActivity.this, ProfileListing.class).putExtra("type",  MenuServiceType.FISH_VENDORS));
                    return true;
                }
                case R.id.layoutSupplier : {
                    startActivity(new Intent(MainActivity.this, ProfileListing.class).putExtra("type", MenuServiceType.SUPPLIERS));
                    return true;
                }
            }
            return false;
        }
    };*/
}