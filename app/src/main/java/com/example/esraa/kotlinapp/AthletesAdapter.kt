package com.example.esraa.kotlinapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


import kotlinx.android.synthetic.main.athletes.view.*
import android.content.Intent
import android.icu.text.DisplayContext
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.appcompat.R.id.message
import android.widget.RelativeLayout


public class AthletesAdapter(context: Context, athletesss: List<Athletes>?) : RecyclerView.Adapter<AthletesAdapter.CustomViewHolder>() {

     var athletesLi: List<Athletes>? = athletesss
    var mcontext: Context = context


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.athletes, parent, false)

            return CustomViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
            val ath = athletesLi!![position]
            holder.name.setText(ath.getName())
            holder.breif.setText(ath.getBrief())

            if (ath.getImage() != "") {
                Glide.with(this.mcontext!!)
                    .load(ath.getImage())
                    .into(holder.imageAth)

            }else {
                holder.imageAth.visibility=View.GONE
               /* val params = holder.breif.getLayoutParams() as RelativeLayout.LayoutParams
                params.width = 600
                params.marginStart =60
                moviename.setLayoutParams(params)
                val params1 = brief.getLayoutParams() as RelativeLayout.LayoutParams
                params1.width = 800
                params1.marginStart =60
                brief.setLayoutParams(params1)*/
            }




//            Glide.with(this.mcontext!!)
//                .load(ath.getImage())
//                .into(holder.imageAth)



            holder?.imageAth.setOnClickListener {

          val intent=Intent(mcontext, DetailsActivity::class.java)
                intent.putExtra("key",holder.breif.text.toString())
                intent.putExtra("imagekey",ath.getImage())
                mcontext.startActivity(intent)


            }


        }

        override fun getItemCount(): Int {
            return athletesLi!!.size
        }


        inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var name: TextView
            var breif: TextView
            var imageAth: ImageView

            init {
                name = view.findViewById(R.id.name) as TextView
                breif = view.findViewById(R.id.brief) as TextView

                imageAth = view.findViewById(R.id.imageview) as ImageView

            }
        }
    }