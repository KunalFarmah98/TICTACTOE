package com.apps.kunalfarmah.realtimetictactoe.Fragments


import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.apps.kunalfarmah.realtimetictactoe.EnterActivity
import com.example.kunalfarmah.realtimetictactoe.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AboutMe : Fragment() {


    var email: TextView?=null
    var fb: TextView?=null
//     var number: TextView?=null




//    override fun onPrepareOptionsMenu(menu: Menu?) {
//        super.onPrepareOptionsMenu(menu)
//
//        //removing the sorting adn searching options as they r not needed
//
//        val item = menu?.findItem(R.id.action_sort)
//        item?.isVisible=false
//
//        val item1 = menu?.findItem(R.id.action_search)
//        item1?.isVisible=false
//    }




    fun AboutMe() {
        // Required empty public constructor
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //        Toast.makeText(getContext(), "onCreateview", Toast.LENGTH_SHORT).show();


        // Inflate the layout for this fragment


        var view = inflater.inflate(R.layout.fragment_about_us, container, false)


        setHasOptionsMenu(true)

        email = view.findViewById(R.id.email) as TextView
        fb = view.findViewById(R.id.fb) as TextView
//        number = view.findViewById(R.id.extra1)

        email!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("kunalfarmah98@gmail.com"))
            try {
                startActivity(intent)
                activity!!.supportFragmentManager.popBackStack()
            } catch (e: Exception) {
                Toast.makeText(context, "No Email Apps found on the device", Toast.LENGTH_SHORT).show()
            }

            EnterActivity.fragments.visibility = GONE
        }

        fb!!.setOnClickListener {
            val url = "https://www.facebook.com/kunal.farmah"
            val fb = Intent(Intent.ACTION_VIEW)
            fb.data = Uri.parse(url)
            try {
                startActivity(fb)
                activity!!.supportFragmentManager.popBackStack()
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context, "No Web Browsers found on the device", Toast.LENGTH_SHORT).show()
            }

            EnterActivity.fragments.visibility=GONE

        }

//        number!!.setOnClickListener {
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:" + "+919654211634")
//
//            startActivity(intent)
//            activity!!.supportFragmentManager.popBackStack()
//        }

//        MainActivity.Statified.AboutOn=true

        return view
    }


    override fun onStart() {
        super.onStart()
        activity!!.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


    }

}

