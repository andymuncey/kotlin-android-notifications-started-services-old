package com.tinyappco.reminders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tinyappco.reminders.databinding.ActivityViewReminderBinding


class ViewReminderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewReminderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewReminderBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvMessage.text = intent.getStringExtra("title") ?: ""

    }
}
