package com.tinyappco.reminders

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.tinyappco.reminders.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun scheduleAlert(view: View){
        val message = binding.etMessage.text.toString()
        val hours = binding.etHours.text.toString().toLongOrNull() ?: 0
        val mins = binding.etMinutes.text.toString().toLongOrNull() ?: 0
        val delay = (hours * 60) + mins

//        val notifier = Notifier(this)
//        notifier.sendNotification(message,"")

        val intent = Intent(this, NotificationService::class.java)

        intent.putExtra("title",message)
        intent.putExtra("delay", delay)
        startService(intent)


        binding.etHours.text.clear()
        binding.etMinutes.text.clear()
        binding.etMessage.text.clear()

        Toast.makeText(this,"Reminder to $message set in $delay minutes", Toast.LENGTH_SHORT).show()

    }

}
