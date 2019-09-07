package touch.one.life.lifeonetouch.adaptors;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import touch.one.life.lifeonetouch.POJO.Emergency;
import touch.one.life.lifeonetouch.POJO.Helplines;
import touch.one.life.lifeonetouch.R;

public class EmergencyAdaptor extends RecyclerView.Adapter<EmergencyAdaptor.MyViewHolder> {
    private List<Emergency> emergencyList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,phone,description;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.helpline_name);
            description = (TextView) view.findViewById(R.id.helpline_desc);
            phone = (TextView) view.findViewById(R.id.helpline_phone);


        }
    }


    public EmergencyAdaptor(List<Emergency> emergencyList, Context context) {
        this.emergencyList = emergencyList;
        this.context =context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_adaptor_helplines, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Emergency e = emergencyList.get(position);
        holder.name.setText(e.getName());
        holder.description.setText("Description : "+e.getDescription());
        holder.phone.setText("Contact : "+e.getPhone());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Are you sure you want to Call?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent callIntent = new Intent(Intent.ACTION_CALL);
                                callIntent.setData(Uri.parse("tel:"+e.getPhone()));
                                context.startActivity(callIntent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();


            }
        });

    }

    @Override
    public int getItemCount() {
        return emergencyList.size();
    }
}
