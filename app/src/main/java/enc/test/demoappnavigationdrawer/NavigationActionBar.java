package enc.test.demoappnavigationdrawer;

import android.content.pm.ActivityInfo;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import static enc.test.demoappnavigationdrawer.R.drawable.ic_beauty_health_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_business_service_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_dth_recharge_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_event_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_flight_ticket_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_giftcard_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_home_service_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_insurance_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_lessons_hobbies_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_money_transfer_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_movers_packers_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_online_booking_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_recharge2_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_reminder_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_shopping_white;


public class NavigationActionBar extends AppCompatActivity {

    protected DrawerLayout mDrawerLayout;
    private Button navButton;
    private NavigationActionBar inst;
    private ArrayList<String> smsMessagesList = new ArrayList<String>();
    private ArrayAdapter arrayAdapter;
    private Button mygroupbtn, cofigure;

    //Top recycler
    private RecyclerView topRecyclerView;
    private List<TopRecyclerPojo> topRecyclerPojoList = new ArrayList<>();;
    private TopRecyclerPojo topRecyclerPojo;
    private int[] images ={ic_money_transfer_white, ic_recharge2_white, ic_dth_recharge_white, ic_insurance_white, ic_reminder_white, ic_shopping_white, ic_online_booking_white, ic_home_service_white, ic_flight_ticket_white, ic_movers_packers_white, ic_event_white, ic_beauty_health_white, ic_lessons_hobbies_white, ic_giftcard_white, ic_business_service_white};

    public NavigationActionBar instance() {
        return inst;
    }
    @Override
    public void onStart() {
        super.onStart();
        inst =  this;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_navigation_action_bar);
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawerlayout);
        //send smsPackage
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, smsMessagesList);

//            // Dashboard Button Work
//            CircleImageView dashboard = (CircleImageView) findViewById(R.id.homedashboard);

        // Track Button work
       /* Button trackNowBtn = (Button) findViewById(R.id.tracknav);
        trackNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        // My Group Button work
        mygroupbtn = (Button) findViewById(R.id.groupnav);
        mygroupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        // Configuration Button Work
        cofigure = (Button) findViewById(R.id.btn_cofigure);
        cofigure.setVisibility(View.VISIBLE);
        cofigure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

       /* LinearLayout popupbtn = (LinearLayout) findViewById(R.id.popup);
        final PopupMenu popup = new PopupMenu(NavigationActionBar.this, popupbtn);
        popup.getMenuInflater().inflate(R.menu.popupmenu, popup.getMenu());
        MenuItem menuItem = popup.getMenu().findItem(R.id.unlink);*/

    /*    popupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {

                            case R.id.unlink:
                                return true;

                            case R.id.changePassword:
                                return true;

                            case R.id.about:
                                return true;

                            case R.id.about_us:
                                return true;

                            case R.id.faq:
                                return true;

                            case R.id.termsConditions:
                                return true;

                            case R.id.privacyPolicy:
                                return true;

                            case R.id.refundPolicy:
                                return true;

                            case R.id.logout:
                                return true;

                            default:
                                return false;
                        }
                    }
                });
                popup.show();
            }
        });*/

        //nav code starts from here
        ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, null, R.string.app_name, R.string.app_name) {
            public void onDrawerClosed(View view) {

            }

            public void onDrawerOpened(View drawerView) {

            }


        };
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        navButton = (Button) findViewById(R.id.navicon);
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.setVisibility(View.VISIBLE);
                mDrawerLayout.openDrawer(Gravity.LEFT);
                //navButton.setVisibility(View.GONE);
            }
        });
        mDrawerLayout.setDrawerListener(new RightMenuListener());
    }

    protected void configureTopRecycler(View view){
        topRecyclerView = (RecyclerView)view.findViewById(R.id.top_recycler_view);
        topRecyclerView.setHasFixedSize(true);
        topRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        String[] whiteIcons = getResources().getStringArray(R.array.main_category);
        int whiteIconsArrayLength = whiteIcons.length;
        for (int i = 0; i<whiteIconsArrayLength; i++){
            topRecyclerPojo = new TopRecyclerPojo(""+i, whiteIcons[i], images[i]);
            topRecyclerPojoList.add(topRecyclerPojo);
        }
        TopRecyclerAdapter adapter = new TopRecyclerAdapter(topRecyclerPojoList, R.layout.top_recycler_child_view,getApplicationContext());
        topRecyclerView.setAdapter(adapter);
        topRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(NavigationActionBar.this, topRecyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        if (position == 0){
                            //  onClickHomeServiceBtn(view);
                        }
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }

    private class RightMenuListener implements DrawerLayout.DrawerListener {
        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
           // navButton.setVisibility(View.GONE);
            if (slideOffset == 0.0) {
                navButton.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onDrawerOpened(View drawerView) {
        }

        @Override
        public void onDrawerClosed(View drawerView) {
            navButton.setVisibility(View.VISIBLE);
        }

        @Override
        public void onDrawerStateChanged(int newState) {
        }

    }
}