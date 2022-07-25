package com.example.bpmonitor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    List<details> detailsList;

    public MyAdapter(Context context, List<details> detailsList) {
        this.context = context;
        this.detailsList = detailsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        details data=detailsList.get(position);
        holder.sp_id.setText(data.getSp());
        int temp=Integer.parseInt(holder.sp_id.getText().toString());
        if(temp<90 || temp>140){
            holder.sp_id.setTextColor(Color.RED);
        }
        holder.dp_id.setText(data.getDd());
        temp=Integer.parseInt(holder.dp_id.getText().toString());
        if(temp<60 || temp>90){
            holder.dp_id.setTextColor(Color.RED);
        }
        holder.bpm_id.setText(data.getBpm());
        holder.date_id.setText(data.getDate());

        //ShowActivity on item click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ShowActivity.class);
                intent.putExtra("spLocation",data.getSp());
                intent.putExtra("dpLocation",data.getDd());
                intent.putExtra("bpmLocation",data.getBpm());
                intent.putExtra("dateLocation",data.getDate());
                intent.putExtra("timeLocation",data.getTime());
                intent.putExtra("notesLocation",data.getNotes());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    public class  MyViewHolder extends RecyclerView.ViewHolder {
        TextView sp_id,dp_id,bpm_id,date_id;
         public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sp_id=itemView.findViewById(R.id.spShow);
            dp_id=itemView.findViewById(R.id.dpShow);
            bpm_id=itemView.findViewById(R.id.bpmShow);
            date_id=itemView.findViewById(R.id.dateShow);
        }
    }
}
