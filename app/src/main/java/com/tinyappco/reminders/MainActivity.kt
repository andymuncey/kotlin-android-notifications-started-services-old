package com.tinyappco.reminders

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun scheduleAlert(view: View){
        val message = etMessage.text.toString()
        val hours = etHours.text.toString().toLongOrNull() ?: 0
        val mins = etMinutes.text.toString().toLongOrNull() ?: 0
        val delay = (hours * 60) + mins

//        val notifier = Notifier(this)
//        notifier.sendNotification(message,"")

        val intent = Intent(this, NotificationService::class.java)

        intent.putExtra("title",message)
        intent.putExtra("delay", delay)
        startService(intent)


        etHours.text.clear()
        etMinutes.text.clear()
        etMessage.text.clear()

        Toast.makeText(this,"Reminder to $message set in $delay minutes", Toast.LENGTH_SHORT).show()

    }

}
