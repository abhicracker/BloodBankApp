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
import touch.one.life.lifeonetouch.MainActivity;
import touch.one.life.lifeonetouch.POJO.Donor;
import touch.one.life.lifeonetouch.POJO.Helplines;
import touch.one.life.lifeonetouch.R;

public class HelplinesAdaptor extends RecyclerView.Adapter<HelplinesAdaptor.MyViewHolder> {
    private List<Helplines> helplinesList;
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


    public HelplinesAdaptor(List<Helplines> helplinesList, Context context) {
        this.helplinesList = helplinesList;
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
        final Helplines e = helplinesList.get(position);
        holder.name.setText(e.getName());
        holder.description.setText("Description : "+e.getDescription());
        holder.phone.setText("Contact : "+e.getContact());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Are you sure you want to Call?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Intent callIntent = new Intent(Intent.ACTION_CALL);
                                callIntent.setData(Uri.parse("tel:"+e.getContact()));
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
        return helplinesList.size();
    }
}
