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
import touch.one.life.lifeonetouch.POJO.BloodBanks;
import touch.one.life.lifeonetouch.POJO.Donor;
import touch.one.life.lifeonetouch.R;

public class BloodBankAdaptor extends RecyclerView.Adapter<BloodBankAdaptor.MyViewHolder> {
    private List<BloodBanks> bloodBanksList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,contact,address;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.bb_name);
            contact = (TextView) view.findViewById(R.id.bb_contact);
            address = (TextView) view.findViewById(R.id.bb_address);


        }
    }


    public BloodBankAdaptor(List<BloodBanks> bloodBanksList, Context context) {
        this.bloodBanksList = bloodBanksList;
        this.context =context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_adaptor_blood_bank, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final BloodBanks e = bloodBanksList.get(position);
        holder.name.setText("Name :"+e.getName());
        holder.contact.setText("Contact :"+e.getContact());
        holder.address.setText("Address :"+e.getAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=20.881925, 77.747045&daddr="+e.getLat()+","+e.getLon()));

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return bloodBanksList.size();
    }
}
