package lyon.calculator.lyoncalculator

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.*
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * https://ithelp.ithome.com.tw/articles/10203735
 */
class NavigationDialog{
    val TAG:String = "NavigationDialog"//NavigationDialog::class.simpleName.toString()//
    lateinit var dialog:Dialog
    lateinit var inflater: View
    lateinit var version:TextView
    lateinit var text2:TextView

    var array:Array<String> = emptyArray<String>()

    fun showRightDialog(context: Context){
        //自定义dialog显示布局
         inflater = LayoutInflater.from(context).inflate(R.layout.menu_view, null)
        //自定义dialog显示风格
         dialog= Dialog(context,R.style.DialogRight)
        //弹窗点击周围空白处弹出层自动消失弹窗消失(false时为点击周围空白处弹出层不自动消失)
        dialog.setCanceledOnTouchOutside(true)
        //将布局设置给Dialog
        dialog.setContentView(inflater)
        //获取当前Activity所在的窗体
        var window: Window = dialog.window!!
        var wlp: WindowManager.LayoutParams = window!!.attributes
        wlp.gravity = Gravity.RIGHT
        wlp.width = Tool().dpToPx(context,200);
        wlp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(wlp);
        dialog.show()

        version = inflater.findViewById(R.id.version)
        var ver = "ver:"+Tool().getVersionName(context)+"("+Tool().getVersionCode(context)+")"
        version.text=ver

        var closeBtn:ImageButton = inflater.findViewById(R.id.closeBtn)
        closeBtn.setOnClickListener { close() }

        array = arrayOf(
            context.getString(R.string.about_Me)
        )
        val recyclerView = inflater.findViewById<RecyclerView>(R.id.MenuRecyclerView)
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = RecyclerView.VERTICAL// RecyclerView.HORIZONTAL
        val menuAdapter = MenuAdaper(context, array)
        menuAdapter.setOnItemClick(object :MenuAdaper.ItemOnCLick{
            override fun OnCLick(holder: MenuAdaper.ViewHolder, position: Int) {
                Log.d(TAG,"MenuList You chose:"+array[position])

                when(array[position]){
                    context.getString(R.string.app_name)->{
                        AlertDialog.Builder(context).setTitle(context.getString(R.string.app_name)).setMessage("you chose "+array[position]).setCancelable(true).create().show()

                    }
                    context.getString(R.string.about_Me)->{
                        AlertDialog.Builder(context).setTitle(context.getString(R.string.about_Me)).setMessage("This is Lyon make Calculator App on kotlin. ").setCancelable(true).create().show()
                        close()
                    }
                }
            }

        })
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = menuAdapter
    }

    fun close(){
        if(dialog!=null) {
            dialog.dismiss()
        }
    }
}