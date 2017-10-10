package com.jonmid.quizdos.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codigoestudiante.taller2.Models.Country;
import com.codigoestudiante.taller2.R;
import com.codigoestudiante.taller2.Views.DetailActivity;
import com.jonmid.quizdos.Models.UserModelReyesErika;
import com.jonmid.quizdos.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by software on 26/09/2017.
 */

public class AdapterUserModelReyesErika extends RecyclerView.Adapter<AdapterUserModelReyesErika.ViewHolder>{

    List<UserModelReyesErika> userList = new ArrayList<>();
    Context context;

    // Constructor de la clase
    public AdapterUserModelReyesErika(List<UserModelReyesErika> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Configuracion del ViewAdapter

        // Obtener la vista (item.xml)
        View item_user = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);

        // Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item_user);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Encargado de trabajar con el item.xml y sus componentes
        holder.textViewName.setText(userList.get(position).getName());
        holder.textViewUsername.setText(userList.get(position).getUsername());
        holder.textViewEmail.setText(userList.get(position).getEmail());
        holder.textViewPhone.setText(userList.get(position).getPhone());
        holder.textViewNamecompany.setText(userList.get(position).getNamecompany());
        holder.textViewAdress.setText(userList.get(position).getAdress());
    }

    @Override
    public int getItemCount() {
        return  userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewName;
        TextView textViewUsername;
        TextView textViewEmail;
        TextView textViewPhone;
        TextView textViewNamecompany;
        TextView textViewAdress;



        public ViewHolder(View item_user) {
            super(item_user);

            item_user.setOnClickListener(this);

            textViewName = (TextView) item_user.findViewById(R.id.id_tv_userinput_name);
            textViewUsername = (TextView) item_user.findViewById(R.id.id_tv_userinput_username);
            textViewEmail = (TextView) item_user.findViewById(R.id.id_tv_userinput_email);
            textViewPhone = (TextView) item_user.findViewById(R.id.id_tv_userinput_phone);
            textViewNamecompany = (TextView) item_user.findViewById(R.id.id_tv_userinput_namecompany);
            textViewAdress = (TextView) item_user.findViewById(R.id.id_tv_userinput_address);
        }

        @Override
       public void onClick(View view) {
            //Context contextItem = view.getContext();
            //Intent intent = new Intent(context,.class);
            //contextItem.startActivity(intent);
        }
    }

}
