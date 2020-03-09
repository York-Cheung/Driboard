package com.sktbd.driboard.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sktbd.driboard.R
import com.sktbd.driboard.data.model.DraftEntity
import com.sktbd.driboard.databinding.DraftItemBinding
import com.sktbd.driboard.databinding.ShotItemBinding
import com.sktbd.driboard.ui.viewmodel.DraftListViewModel


class DraftList_RVAdapter(var draftList:List<DraftEntity>, var viewModel: DraftListViewModel) : RecyclerView.Adapter<DraftList_RVAdapter.VHolder>() {
    private var onItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.draft_item,parent,false)
        return VHolder(v,viewModel)
    }

    override fun getItemCount(): Int {
        return draftList.size
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        val draft: DraftEntity =draftList[position]
        holder.bindView(draft)

//        if (onItemClickListener != null) {
//            holder.itemView.imageView.setOnClickListener { onItemClickListener?.onclick(holder.itemView.imageView, position) }
//        }
    }

    inner class VHolder(itemView:View,var viewModelBoard:DraftListViewModel):RecyclerView.ViewHolder(itemView) {

        var lbinding: DraftItemBinding?=null
        init{
            lbinding=DataBindingUtil.bind(itemView)
        }
        fun bindView(draft: DraftEntity){
            this.lbinding!!.draft = draft
            lbinding!!.executePendingBindings()
        }
    }
}
