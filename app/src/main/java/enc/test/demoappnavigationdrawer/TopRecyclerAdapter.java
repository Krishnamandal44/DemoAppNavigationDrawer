package enc.test.demoappnavigationdrawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import enc.test.demoappnavigationdrawer.TopRecyclerPojo;

import java.util.List;

/**
 * Created by Admin on 29-07-2017.
 */

public class TopRecyclerAdapter extends RecyclerView.Adapter<TopRecyclerAdapter.ViewHolder>{

    private List<TopRecyclerPojo> topRecyclerPojos;
    private Context context;
    private int child;

    public TopRecyclerAdapter(List<TopRecyclerPojo> itemList, Context context) {
        this.topRecyclerPojos = itemList;
        this.context = context;
    }

    public TopRecyclerAdapter(List<TopRecyclerPojo> itemList, int child, Context context) {
        this.topRecyclerPojos = itemList;
        this.context = context;
        this.child = child;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(child,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        TopRecyclerPojo topRecyclerPojo = topRecyclerPojos.get(position);
        holder.textView.setText(topRecyclerPojo.getText());
        holder.imageView.setImageResource(topRecyclerPojo.getIcon());
    }

    @Override
    public int getItemCount() {
        return topRecyclerPojos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        LinearLayout view;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.top_rcv_child_text);
            imageView = (ImageView) itemView.findViewById(R.id.top_rcv_child_icon);
            view = (LinearLayout) itemView;
        }
    }
}
