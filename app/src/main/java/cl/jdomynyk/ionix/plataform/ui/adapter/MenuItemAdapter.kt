package cl.jdomynyk.ionix.plataform.ui.adapter

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.jdomynyk.ionix.R
import cl.jdomynyk.ionix.presentation.HomePresenter
import cl.jdomynyk.ionix.presentation.view.MenuItemCellView
import kotlinx.android.synthetic.main.activity_home_item.view.*


class MenuItemAdapter(private val context: Context, private val presenter: HomePresenter) :
    RecyclerView.Adapter<MenuItemAdapter.ItemHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ItemHolder {
        if (viewGroup is RecyclerView) {
            val view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_home_item, viewGroup, false)
            return ItemHolder(view)
        } else {
            throw RuntimeException("Not bound")
        }
    }

    override fun onBindViewHolder(hitsHolder: ItemHolder, position: Int) {
        presenter.populateItem(hitsHolder, position)
    }

    override fun getItemCount(): Int {
        return presenter.getItemsCount()
    }

    fun refresh() {
        notifyDataSetChanged()
    }

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView), MenuItemCellView {

        init {
            itemView.cardView.setOnClickListener { presenter.onItemClick(adapterPosition) }
        }

        override fun setIcon(icon: String) {
            val newIcon = try {
                context.getString(
                    context.resources.getIdentifier(
                        icon,
                        "string",
                        context.packageName
                    )
                )
            } catch (exception: Exception) { // En caso de no existir el icono
                context.getString(R.string.fa_tag)
            }

            itemView.tvIcon.text = newIcon
        }

        override fun setName(title: String) {
            itemView.tvName.text = title
        }
    }
}