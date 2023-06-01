package com.example.heroku.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.heroku.API.APIRequestData;
import com.example.heroku.API.RetroServer;
import com.example.heroku.Activity.MainActivity;
import com.example.heroku.Activity.UbahActivity;
import com.example.heroku.Model.ModelHero;
import com.example.heroku.Model.ModelResponse;
import com.example.heroku.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterHero extends RecyclerView.Adapter<AdapterHero.VHHero>  {

    private Context ctx;
    private List<ModelHero> listhero;

    public AdapterHero(Context ctx,List<ModelHero> listhero){
        this.ctx = ctx;
        this.listhero = listhero;
    }


    @NonNull
    @Override
    public AdapterHero.VHHero onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_hero,parent,false);
        return new VHHero(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull VHHero holder, int position) {
        ModelHero MH = listhero.get(position);

        holder.tvId.setText(MH.getId());
        holder.tvNama.setText(MH.getNama());
        holder.tvRole.setText(MH.getRole());
        holder.tvLane.setText(MH.getLane());
        holder.tvTahun_rilis.setText(MH.getTahun_rilis());
        holder.tvDes_hero.setText(MH.getDes_hero());
        holder.tvSkill1.setText(MH.getSkill1());
        holder.tvDes1.setText(MH.getDes1());
        holder.tvSkill2.setText(MH.getSkill2());
        holder.tvDes2.setText(MH.getDes2());
        holder.tvSkill3.setText(MH.getSkill3());
        holder.tvDes3.setText(MH.getDes3());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String id = MH.getId();
//                String nama = MH.getNama();
//                String role = MH.getRole();
//                String lane = MH.getLane();
//                String tahun_rilis = MH.getTahun_rilis();
//                String des_hero = MH.getDes_hero();
//                String skill1 = MH.getSkill1();
//                String des1 = MH.getDes1();
//                String skill2 = MH.getSkill2();
//                String des2 = MH.getDes2();
//                String skill3 = MH.getSkill3();
//                String des3 = MH.getDes3();
////                String des3 = MH.getId(); buat foto
//
////                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
////                intent.putExtra("varnama",nama);
////                intent.putExtra("varrole",role);
////                intent.putExtra("varnama",lane);
////                intent.putExtra("varnama",tahun_rilis);
////                intent.putExtra("varnama",des_hero);
////                intent.putExtra("varnama",skill1);
////                intent.putExtra("varnama",des1);
////                intent.putExtra("varnama",skill2);
////                intent.putExtra("varnama",des2);
////                intent.putExtra("varnama",skill3);
////                intent.putExtra("varnama",des3);
//////                intent.putExtra("varnama",nama);  buat foto jikalau bisa
////                holder.itemView.getContext().startActivity(intent);
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return  listhero.size();
    }

    public class VHHero extends  RecyclerView.ViewHolder{

        TextView tvId, tvNama, tvRole, tvLane, tvTahun_rilis, tvDes_hero, tvSkill1, tvDes1, tvSkill2, tvDes2, tvSkill3, tvDes3;

        ImageView iv_foto;
        public VHHero(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_id);
            tvNama= itemView.findViewById(R.id.tv_nama1);
            tvRole = itemView.findViewById(R.id.tv_role1);
            tvLane = itemView.findViewById(R.id.tv_lane1);
            tvTahun_rilis = itemView.findViewById(R.id.tv_tahun_rilis1);
//            tvDes_hero = itemView.findViewById(R.id.tv_isiDes);
//            tvSkill1 = itemView.findViewById(R.id.tv_namaSkill1);
//            tvDes1 = itemView.findViewById(R.id.tv_isiDesSkill1);
//            tvSkill2 = itemView.findViewById(R.id.tv_namaSkill2);
//            tvDes2 = itemView.findViewById(R.id.tv_isiDesSkill2);
//            tvSkill3 = itemView.findViewById(R.id.tv_namaSkill3);
//            tvDes3 = itemView.findViewById(R.id.tv_isiDesSkill3);
//            iv_foto = itemView.findViewById(R.id.iv_foto);
        }
    }
    private  void hapusHero(String idHero){
        APIRequestData ARD = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ModelResponse> proses = ARD.ardDelete(idHero);

        proses.enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
                String kode = response.body().getKode();
                String pesan= response.body().getPesan();

                Toast.makeText(ctx,"Kode" + kode +",Pesan" + pesan, Toast.LENGTH_SHORT).show();
                ((MainActivity)ctx).retrieveHeroku();
            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {

            }
        });

    }
}
