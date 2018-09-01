package com.farehawker.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.farehawker.Model.ServicereturnModel;
import com.farehawker.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by FareHawker on 4/11/2018.
 */

public class ServicereturnAdaptr extends BaseAdapter {
    Context mcontext;
    private LayoutInflater inflater;
    private List<ServicereturnModel> returnservicelist;
    public ServicereturnAdaptr(Context mcontext, List<ServicereturnModel> returnservice) {
       this.mcontext = mcontext;
       this.returnservicelist = returnservice;
    }
    @Override
    public int getCount() {
        return returnservicelist.size();
    }

    @Override
    public Object getItem(int position) {
        return returnservicelist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }if (convertView == null) {
            convertView = inflater.inflate(R.layout.returnservice_layout, null);
        }
        //this is for return by mistake write originvalue only...
        TextView origincity=(TextView)convertView.findViewById(R.id.origin_origin);
        TextView origindestinaton=(TextView)convertView.findViewById(R.id.origin_destination);
        TextView originairline=(TextView)convertView.findViewById(R.id.origin_airline);
        TextView origindetails=(TextView)convertView.findViewById(R.id.orgin_details);
        ImageView originimage=(ImageView)convertView.findViewById(R.id.origin_image);

        ServicereturnModel returnlist=returnservicelist.get(position);
        String origins=returnlist.getRorigin();
        String destinations=returnlist.getRdestination();
        String detailss=returnlist.getRdetails();
        String airlines=returnlist.getRairline();

        String retrations=returnlist.getRretraction();
        origincity.setText(origins);
        origindestinaton.setText(destinations);
        originairline.setText(airlines);
        origindetails.setText(detailss);
        String key = originairline.getText().toString();
        Picasso.with(mcontext)
                .load("https://www.farehawker.com/img/Airlines_logo/"+key+".gif")
                // .load(mDataset.get(position).toString())
                .into(originimage);
        return convertView;
    }
   }
