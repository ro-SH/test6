package com.example.test6



import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test6.adapter.Adapter
import com.example.test6.model.MainActivitiViewModel
import dmax.dialog.SpotsDialog


class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewModel: MainActivitiViewModel
    private lateinit var rvAdapter: Adapter
    private var alertDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this)[MainActivitiViewModel::class.java]

        alertDialog = SpotsDialog.Builder()
            .setCancelable(false)
            .setContext(this)
            .build()
        alertDialog!!.show()

        rvAdapter = Adapter()
        val rv = findViewById<RecyclerView>(R.id.ResView)
        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)

        mainActivityViewModel.urlList.observe(this){
            if (it != null) {
                rvAdapter.setData(it)
                alertDialog?.dismiss()
            }
        }
    }
}
