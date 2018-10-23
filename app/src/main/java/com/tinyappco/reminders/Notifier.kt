package com.tinyappco.reminders

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat

class Notifier(val context: Context) {

    init {
        createNotificationChannel()
    }

    private fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channelName = context.getString(R.string.channelName)
            val channelDescription = context.getString(R.string.channelDescription)
            val channelId = channelName
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = channelDescription
            }

            val notificationManager: NotificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

        }
    }

    fun sendNotification(title: String, content: String){

        val notification = notification(title, content)

        with(NotificationManagerCompat.from(context)){

            val notificationId = title.hashCode() //pretty much unique

            notify(notificationId, notification)
        }

    }


    private fun notification(title: String, content: String) : Notification {

        val intent = Intent(context, ViewReminderActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        intent.putExtra("title",title)

        val requestCode = title.hashCode()
        val pendingIntent = PendingIntent.getActivity(context,requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(context, context.getString(R.string.channelName))
        builder.setSmallIcon(R.drawable.baseline_done_outline_black_18)
        builder.setContentTitle(title)
        builder.setContentText(content)
        builder.priority = NotificationCompat.PRIORITY_DEFAULT
        builder.setContentIntent(pendingIntent)
        return builder.build()
    }




}