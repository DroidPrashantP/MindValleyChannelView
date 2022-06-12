package com.paddy.mindvalley.channel.ui.fragment

import androidx.recyclerview.widget.RecyclerView
import com.paddy.mindvalley.channel.data.model.Category
import com.paddy.mindvalley.channel.databinding.LayoutCategorySectionIndividualItemBinding

class CategoriesSectionAdapterViewHolder(var binding : LayoutCategorySectionIndividualItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindData(category: Category?){
        binding.tvCategorySectionLabel.text = category?.name
    }
}