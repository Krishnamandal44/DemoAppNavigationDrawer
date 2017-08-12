package enc.test.demoappnavigationdrawer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

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
import static enc.test.demoappnavigationdrawer.R.drawable.ic_movers_packers_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_online_booking_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_recharge2_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_reminder_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_shopping_white;
import static enc.test.demoappnavigationdrawer.R.drawable.ic_money_transfer_white;

public class MainActivity extends NavigationActionBar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_main, null, false);
        mDrawerLayout.addView(contentView, 0);
        configureTopRecycler(contentView);
    }
}
