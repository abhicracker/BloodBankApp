package touch.one.life.lifeonetouch.adaptors;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import touch.one.life.lifeonetouch.POJO.Donor;
import touch.one.life.lifeonetouch.R;

public class AllDonorsAdaptor extends RecyclerView.Adapter<AllDonorsAdaptor.MyViewHolder> {
    private List<Donor> donorList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,phone,bg,address;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.donor_name);
            bg = (TextView) view.findViewById(R.id.donor_bg);
            phone = (TextView) view.findViewById(R.id.donor_phone);
            address = (TextView) view.findViewById(R.id.donor_address);

        }
    }


    public AllDonorsAdaptor(List<Donor> donorList, Context context) {
        this.donorList = donorList;
        this.context =context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_adaptor_donors, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Donor e = donorList.get(position);
        holder.name.setText("Name :"+e.getName());
        holder.bg.setText("Blood Group :"+e.getBg());
        holder.phone.setText("Contact :"+e.getPhone());
        holder.address.setText("Area :"+e.getAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+e.getPhone()));
                context.startActivity(callIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return donorList.size();
    }
}
