package com.example.recyclerviewp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewp.R;
import com.example.recyclerviewp.data.Contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private int lastPosition = -1;

    private List<Contacts> Clist;

    //checking

//    private List<Contacts> listfull;


    public ContactsAdapter(ArrayList<Contacts> Clist){
        this.Clist = Clist;
    }

    @NonNull
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ViewHolder holder, int position) {
//        Contacts model=list.get(position);
        holder.imageView.setImageResource(Clist.get(position).image);
        holder.textView1.setText(Clist.get(position).name);
        holder.textView2.setText(Clist.get(position).mobile_no);

        setAnimation(holder.itemView, position);

    }

    @Override
    public int getItemCount() {
        return Clist.size();
    }

//   public void filterList(List<Contacts> filteredList){
//        Clist = (ArrayList<Contacts>) filteredList;
//        notifyDataSetChanged();
//
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView1, textView2;
        LinearLayout ll_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image1);
            textView1 = itemView.findViewById(R.id.text1);
            textView2 = itemView.findViewById(R.id.text2);
            ll_layout = itemView.findViewById(R.id.ll_layout);

        }
//        public void setData(int resource, String msg1, String msg2)
//        {
//            imageView.setImageResource(resource);
//            textView1.setText(msg1);
//            textView2.setText(msg2);
//        }
    }

//    public ContactsAdapter(List<Contacts> list)
//    {
//        this.list = list;
//        listfull = new ArrayList<>(list);
//    }


    //animation
    private void setAnimation(View viewToAnimate, int position)  //send both view and position
    {
        if (position > lastPosition) {
            Animation slideIn = AnimationUtils.loadAnimation(viewToAnimate.getContext(), android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(slideIn);
            lastPosition = position;

        }
    }
}
