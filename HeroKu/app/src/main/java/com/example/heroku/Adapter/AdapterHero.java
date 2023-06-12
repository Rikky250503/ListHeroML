package com.example.heroku.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
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
import com.example.heroku.Activity.DetailActivity;
import com.example.heroku.Activity.MainActivity;

import com.example.heroku.Activity.UbahActivity;
import com.example.heroku.Model.ModelHero;
import com.example.heroku.Model.ModelResponse;
import com.example.heroku.R;
import com.squareup.picasso.Picasso;

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
    public VHHero onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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
        holder.tvFoto.setText(MH.getFoto());
        holder.tvDes_hero.setText(MH.getDes_hero());
        holder.tvSkill1.setText(MH.getSkill1());
        holder.tvDes1.setText(MH.getDes1());
        holder.tvSkill2.setText(MH.getSkill2());
        holder.tvDes2.setText(MH.getDes2());
        holder.tvSkill3.setText(MH.getSkill3());
        holder.tvDes3.setText(MH.getDes3());
        Picasso.get().load(MH.getFoto()).into(holder.ivFotoMain);

//        if (MH.getFoto().isEmpty())
//        {
//            holder.ivFotoMain.setImageResource(R.drawable.ic_launcher_background);
//        }
//        else {
//            Picasso.get().load(MH.getFoto()).into(holder.ivFotoMain);
//        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = MH.getNama();
                String role = MH.getRole();
                String lane = MH.getLane();
                String tahun_rilis = MH.getTahun_rilis();
                String des_hero = MH.getDes_hero();
                String skill1 = MH.getSkill1();
                String des1 = MH.getDes1();
                String skill2 = MH.getSkill2();
                String des2 = MH.getDes2();
                String skill3 = MH.getSkill3();
                String des3 = MH.getDes3();
                String gambar = MH.getFoto();

                Intent intent  = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("varNama",nama);
                intent.putExtra("varRole",role);
                intent.putExtra("varLane",lane);
                intent.putExtra("varTahun_rilis",tahun_rilis);
                intent.putExtra("varDes_hero",des_hero);
                intent.putExtra("varSkill1",skill1);
                intent.putExtra("varDes1",des1);
                intent.putExtra("varSkill2",skill2);
                intent.putExtra("varDes2",des2);
                intent.putExtra("varSkill3",skill3);
                intent.putExtra("varDes3",des3);
                intent.putExtra("varFoto",gambar);

                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return  listhero.size();
    }

    public class VHHero extends  RecyclerView.ViewHolder{

        TextView tvId, tvNama, tvRole, tvLane, tvTahun_rilis, tvDes_hero, tvSkill1, tvDes1, tvSkill2, tvDes2, tvSkill3, tvDes3,tvFoto;
        ImageView ivFotoMain;

        public VHHero(@NonNull View itemView) {
            super(itemView);

            ModelHero modelHero;

            tvId = itemView.findViewById(R.id.tv_id);
            tvNama= itemView.findViewById(R.id.tv_nama1);
            tvRole = itemView.findViewById(R.id.tv_role1);
            tvLane = itemView.findViewById(R.id.tv_lane1);
            tvTahun_rilis = itemView.findViewById(R.id.tv_tahun_rilis1);
            tvDes_hero = itemView.findViewById(R.id.tv_des_hero1);
            tvSkill1 = itemView.findViewById(R.id.tv_listskill1);
            tvDes1 = itemView.findViewById(R.id.tv_listdes1);
            tvSkill2 =itemView.findViewById(R.id.tv_listskill2);
            tvDes2 = itemView.findViewById(R.id.tv_listdes2);
            tvSkill3 = itemView.findViewById(R.id.tv_listskill3);
            tvDes3 = itemView.findViewById(R.id.tv_listdes3);
            ivFotoMain  = itemView.findViewById(R.id.iv_foto);
            tvFoto = itemView.findViewById(R.id.tv_linkFoto);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    AlertDialog.Builder pesan = new AlertDialog.Builder(ctx);

                    pesan.setTitle("Perhatian");
                    pesan.setMessage("Operasi apa yang akan di lakukan?");
                    pesan.setCancelable(true);

                    pesan.setNegativeButton("Hapus", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            hapusHero(tvId.getText().toString());
                            dialog.dismiss();
                        }
                    });

                    pesan.setPositiveButton("Ubah", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent pindah = new Intent(ctx, UbahActivity.class);

                            pindah.putExtra("xId",tvId.getText().toString());
                            pindah.putExtra("xnama",tvNama.getText().toString());
                            pindah.putExtra("xRole",tvRole.getText().toString());
                            pindah.putExtra("xLane",tvLane.getText().toString());
                            pindah.putExtra("xTahun",tvTahun_rilis.getText().toString());
                            pindah.putExtra("xDesHero", tvDes_hero.getText().toString());
                            pindah.putExtra("xSkill1", tvSkill1.getText().toString());
                            pindah.putExtra("xDes1", tvDes1.getText().toString());
                            pindah.putExtra("xSkill2", tvSkill2.getText().toString());
                            pindah.putExtra("xDes2", tvDes2.getText().toString());
                            pindah.putExtra("xSkill3", tvSkill3.getText().toString());
                            pindah.putExtra("xDes3", tvDes3.getText().toString());
                            pindah.putExtra("xFoto",tvFoto.getText().toString());

//                            Toast.makeText(ctx,",Pesan: " + pesan,Toast.LENGTH_SHORT).show();
                            ctx.startActivity(pindah);
                        }
                    });

                    pesan.show();
                    return false;
                }
            });
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
