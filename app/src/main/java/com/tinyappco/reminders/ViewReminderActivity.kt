package com.tinyappco.reminders

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_reminder.*

class ViewReminderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_reminder)

        tvMessage.text = intent.getStringExtra("title") ?: ""

    }
}
