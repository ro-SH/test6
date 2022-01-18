package com.example.test6



import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.test6.Adapter.Adapter
import com.example.test6.Model.MainActivitiViewModel
import dmax.dialog.SpotsDialog


class MainActivity : AppCompatActivity() {
    var mainActivityViewModel : MainActivitiViewModel? = null
     var Rec : RecyclerView? = null
    var adapter : Adapter? = null
    //lateinit var binding: ActivityMainBinding
    // lateinit var  mService: RetrofitService
     var linearLayoutManager: LinearLayoutManager? = null
    //lateinit var adapter: Adapter
    var alertDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {


        //binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this)
        mainActivityViewModel!!.getMovieList.observe(this){movieModels ->
           // Log.e("MainActivity","MovieList: " + movieModels.get(0))
        }
        alertDialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()
        alertDialog!!.show()
        Rec = findViewById(R.id.ResView)
        Rec!!.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        Rec!!.layoutManager = linearLayoutManager
        //adapter = Adapter(this, )
        adapter!!.notifyDataSetChanged()
        Rec!!.adapter = adapter
        alertDialog!!.dismiss()
    }

    private fun ViewModelProvider(mainActivity: MainActivity): MainActivitiViewModel? {
        MainActivitiViewModel:: class.java
        return ViewModelProvider(this)
    }
}


        /*mService = common.retrofitService
        Rec.setHasFixedSize(true)

        //binding.ResView.setHasFixedSize(true)

        linearLayoutManager = LinearLayoutManager(this)
        Rec.layoutManager=  linearLayoutManager

        alertDialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()
        //Rec.setAdapter(adapter)


        Rec.apply {
            Rec.layoutManager = GridLayoutManager(this@MainActivity, 2)
            Rec.adapter = adapter
            Rec.setAdapter(adapter)}



        getalllist()



    }


    private fun getalllist() {

        alertDialog.show()
        mService.getmoviesList().enqueue(object : Callback<MutableList<Movies>> {
            override fun onFailure(call: Call<MutableList<Movies>>, t: Throwable) {

            }
            override fun onResponse(call: Call<MutableList<Movies>>, response: Response<MutableList<Movies>>) {
                adapter = Adapter(baseContext, response.body() as MutableList<Movies>)
                adapter.notifyDataSetChanged()
                alertDialog.dismiss()

            }


        })
    }
}*/