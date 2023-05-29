package com.example.gestos.database;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.example.gestos.R;

import java.util.List;

public class CustomAdapterManageCartas extends ArrayAdapter<Carta> {
    public Context ctx;
    int layoutTemplate;
    List<Carta> cartaList;
    CheckedTextView tvPlayer;
    ViewHolder holder;
    int checkedCount;
    int checkedLevelSum;
    TextView countTv;
    TextView sumaLevelsTv;
    CartaLab cartaLab;

    public CustomAdapterManageCartas(@NonNull Context context, int resource, @NonNull List<Carta> objects, CartaLab cartaLab) {
        super(context, resource, objects);

        this.ctx = context;
        this.layoutTemplate = resource;
        this.cartaList = objects;
        this.countTv = countTv;
        this.sumaLevelsTv = sumaLevelsTv;
        this.cartaLab = cartaLab;
    }

    //Aquest mètode es llança automaticament cada vegada per element
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        try {
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(ctx).inflate(layoutTemplate, parent, false);
                holder.tv = convertView.findViewById(R.id.tvManage);
                holder.tvNivel = convertView.findViewById(R.id.tvManageDificultad);
                holder.deleteBtn = convertView.findViewById(R.id.btnManageDelete);
                holder.editBtn = convertView.findViewById(R.id.btnManageEdit);


//                holder.ctv.setOnLongClickListener(new View.OnLongClickListener() {
//                    @Override
//                    public boolean onLongClick(View v) {
//                        CheckedTextView ctv = v.findViewById(R.id.checkedTextView);
//                        String playerDelete = ctv.getText().toString();
//
//                        for (Player player : playersList) {
//                            if (player.getNombre() == playerDelete) {
//                                playersList.remove(player);
//                                break;
//                            }
//                        }
//                        notifyDataSetChangedAux();
//                        return false;
//                    }
//                });

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Carta player = getItem(position);

            holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    TextView tv = v.findViewById(R.id.tvManage);

                    //test
                    //Player player = getItem(position);
                    Carta carta = cartaList.get(position);

                    AlertDialog.Builder builder = new AlertDialog.Builder(getThisContext());

                    // Set the message show for the Alert time
                    builder.setMessage("Eliminar palabra '" + carta.getPalabra() + "'?");

                    // Set Alert Title
                    builder.setTitle("Epa");

                    // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                    builder.setCancelable(false);

                    // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
                    builder.setPositiveButton("Sí", (DialogInterface.OnClickListener) (dialog, which) -> {
                        // When the user click yes button then app will close

                        cartaLab.delete(carta);
                        cartaList.remove(carta);
                        //playersList = playerLab.getPlayers();
                        notifyDataSetChangedAux();
                    });

                    // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
                    builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                        // If user click no then dialog box is canceled.
                        dialog.cancel();
                    });

                    // Create the Alert dialog
                    AlertDialog alertDialog = builder.create();
                    // Show the Alert Dialog box
                    alertDialog.show();

                }
            });


            holder.editBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    TextView tv = v.findViewById(R.id.tvManage);

                    //test
                    //Player player = getItem(position);
                    Carta carta = cartaList.get(position);

//                    Intent intent = new Intent(getThisContext(), CreatePlayer.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    intent.putExtra("carta", carta.getPalabra());
//                    getThisContext().startActivity(intent);

                }
            });


            Carta cartaAux = cartaList.get(position);
            holder.tv.setTag(convertView.getTag());
            holder.tvNivel.setTag(convertView.getTag());
            holder.editBtn.setTag(convertView.getTag());
            holder.deleteBtn.setTag(convertView.getTag());
            holder.tv.setText(cartaAux.getPalabra());
            holder.tvNivel.setText(cartaAux.getDificultad()+"");


            Log.i("tttttt", "playerAux: " + cartaAux.getPalabra() + ", " + cartaAux.getDificultad());

        } catch (Exception ex) {
            Log.i("tttttt", "getView error: " + ex.getMessage());
        }
        return convertView;
    }

    class ViewHolder {
        Button deleteBtn;
        Button editBtn;
        TextView tv;
        TextView tvNivel;

    }

    public void notifyDataSetChangedAux() {
        //this.playersList = playerLab.getPlayers();
        Log.i("tttttt", "size: " + this.cartaList.size());
        this.notifyDataSetChanged();
    }

    public Context getThisContext() {
        return this.ctx;
    }

}
