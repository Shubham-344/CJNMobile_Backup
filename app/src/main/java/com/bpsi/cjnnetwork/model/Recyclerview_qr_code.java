package com.bpsi.cjnnetwork.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bpsi.cjnnetwork.R;
import com.bpsi.cjnnetwork.utils.qrcode;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Recyclerview_qr_code extends RecyclerView.Adapter<Recyclerview_qr_code.ViewHolder> {
    Context context;
    ArrayList<qrcode>arrayList;
    OnClick_dashboard onClick;

    public Recyclerview_qr_code(ArrayList<qrcode> arrayList, Context context,OnClick_dashboard onClick) {
        this.arrayList = arrayList;
        this.onClick=onClick;
        this.context = context;
    }

    @NonNull
    @Override
    public Recyclerview_qr_code.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.qr_code_item,null);
        return new ViewHolder(view,onClick);
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerview_qr_code.ViewHolder holder, int position) {
        String test="dev";
        holder.textView.setText(arrayList.get(position).assessment_name);
        Picasso.get().load("https://"+test+".cjnnow.com/actionbar/"+arrayList.get(position).qrcode_filename).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView,OnClick_dashboard onClick_dashboard) {
            super(itemView);
            imageView=itemView.findViewById(R.id.qr1);
            textView=itemView.findViewById(R.id.test);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick_dashboard.onClick_dashboard_tapped(getPosition(),1);
                }
            });
        }
    }
}
