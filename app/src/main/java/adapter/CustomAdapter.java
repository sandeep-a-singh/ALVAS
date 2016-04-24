package adapter;

/**
 * Created by DELL1 on 1/6/2016.
 */
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pojo.EventDetail;
import students.alvas.school.alvas.R;


public class CustomAdapter extends BaseAdapter{

    Context context;
Bitmap on,off;
    private  LayoutInflater mInflater;
    private ArrayList<EventDetail> student_detail;
    private static LayoutInflater inflater=null;
Typeface typeface;
    public String user_code;

    public CustomAdapter(Context context, ArrayList<EventDetail> student_detail,String code,Typeface typeface) {
        // TODO Auto-generated constructor stub

this.typeface=typeface;
        this.user_code= code;
        this.student_detail= student_detail;
        this.context=context;
        this.mInflater = (LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return student_detail.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        public TextView number,event_name;
        public ImageView status_image;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        Holder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(
                    R.layout.event_list_items, null);


            holder = new Holder();
            holder.number = (TextView) convertView
                    .findViewById(R.id.student_event__sr_no);
            holder.number.setTypeface(typeface);

            holder.event_name = (TextView) convertView
                    .findViewById(R.id.student_event_name);
            holder.event_name.setTypeface(typeface);
holder.status_image =(ImageView) convertView.findViewById(R.id.student_events_status);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        final String name = (student_detail.get(position)).getEvent_name();
        final String id= (student_detail.get(position)).getNumber();
        final Boolean status = (student_detail.get(position)).isStatus();

        holder.number.setText(id);
        holder.event_name.setText(name);


        try
        {
            if (status)
            holder.status_image.setImageBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.done_default_48));
            else
                holder.status_image.setImageBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.done_disabled_48));


        }catch (Exception e)
        {
            e.printStackTrace();
            holder.status_image.setImageBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.done_disabled_48));
        }

convertView.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {

        Toast.makeText(context, "You Clicked "+name+" at position "+position, Toast.LENGTH_SHORT).show();
       /* Intent myIntent = new Intent(context,app.contacts.sunny.addressbook.Details.class);
        myIntent.putExtra("contact_id", id);
        myIntent.putExtra("contact_name", name);
        myIntent.putExtra("contact_uri", URI);
        //Optional parameters
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(myIntent);*/
}
});

/*
        View rowView;
        rowView = inflater.inflate(R.layout.contact_item, null);
        holder.tv=(TextView) rowView.findViewById(R.id.tv_label);
        holder.img=(ImageView) rowView.findViewById(R.id.rounded_iv_profile);
        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            }
        });
*/

        Animation animation = AnimationUtils.loadAnimation(context, R.anim.push_up_in);
        animation.setDuration(500);
        convertView.startAnimation(animation);
        animation = null;
        return convertView;

    }

}
