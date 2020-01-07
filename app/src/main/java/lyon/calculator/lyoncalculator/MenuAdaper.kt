package lyon.calculator.lyoncalculator

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdaper : RecyclerView.Adapter<MenuAdaper.ViewHolder> {
    val TAG:String=MenuAdaper::class.toString()
    lateinit var holder: ViewHolder
    private var context:Context
    lateinit var array:Array<String>

    interface ItemOnCLick {
        fun OnCLick(holder: ViewHolder,position: Int)
    }
    lateinit var itemOnCLick:ItemOnCLick


    constructor(context: Context, array: Array<String>) : super() {
        this.context = context
        this.array = array
        Log.d(TAG,"getItemCount() constructor:"+array.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cell = LayoutInflater.from(context).inflate(R.layout.menu_cell, parent, false)
        val viewHolder = ViewHolder(cell)
        this.holder=viewHolder;
        viewHolder.menuText = cell.findViewById(R.id.menuText)
        viewHolder.menuText

        return holder
    }

    override fun getItemCount(): Int {
        Log.d(TAG,"getItemCount():"+array.size)
        return array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = array[position]
        holder.menuText.text=model;
        holder.menuText.setOnClickListener {
            if(itemOnCLick!=null)
                itemOnCLick.OnCLick(holder,position);
        }
    }

    public fun setOnItemClick(itemOnCLick:ItemOnCLick ){
        this.itemOnCLick=itemOnCLick;
    }

    class ViewHolder : RecyclerView.ViewHolder {
        lateinit var menuText: TextView

        constructor(itemView: View) : super(itemView)
    }
}