package com.example.florabliss




import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity




class bday : AppCompatActivity() {
   private lateinit var mediaPlayer: MediaPlayer
   private var songIndex = 0
   private val songs = listOf(
       R.raw.song1,
       R.raw.song2,
       R.raw.song3
   )




   @SuppressLint("MissingInflatedId")
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_bday)




       mediaPlayer = MediaPlayer.create(this, songs[songIndex])




       val playButton: Button = findViewById(R.id.playButton)
       val nextButton: Button = findViewById(R.id.nextButton)
       val previousButton: Button = findViewById(R.id.previousButton)
       val websiteButton: Button = findViewById(R.id.websiteButton)
       val CartButton = findViewById<Button>(R.id.cartbtn)




       playButton.setOnClickListener {
           if (!mediaPlayer.isPlaying) {
               mediaPlayer.start()
           } else {
               mediaPlayer.pause()
           }
       }




       nextButton.setOnClickListener {
           songIndex = (songIndex + 1) % songs.size
           mediaPlayer.reset()
           mediaPlayer = MediaPlayer.create(this, songs[songIndex])
           mediaPlayer.start()
       }




       previousButton.setOnClickListener {
           songIndex = if (songIndex - 1 < 0) songs.size - 1 else songIndex - 1
           mediaPlayer.reset()
           mediaPlayer = MediaPlayer.create(this, songs[songIndex])
           mediaPlayer.start()
       }




       websiteButton.setOnClickListener {
           val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fnp.com"))
           startActivity(intent)
       }




       Toast.makeText(this, "onCreate Called", Toast.LENGTH_LONG).show()




       CartButton.setOnClickListener {
           val intent = Intent(this,CartActivity::class.java)
           startActivity(intent)
       }
   }




   override fun onStart() {
       super.onStart()
       Toast.makeText(this, "onStart Called", Toast.LENGTH_LONG).show()
   }




   override fun onResume() {
       super.onResume()
       Toast.makeText(this, "onResume Called", Toast.LENGTH_LONG).show()
   }




   override fun onPause() {
       super.onPause()
       if (mediaPlayer.isPlaying) {
           mediaPlayer.pause()
       }
       Toast.makeText(this, "onPause Called", Toast.LENGTH_LONG).show()
   }




   override fun onStop() {
       super.onStop()
       if (mediaPlayer.isPlaying) {
           mediaPlayer.stop()
       }
       Toast.makeText(this, "onStop Called", Toast.LENGTH_LONG).show()
   }




   override fun onDestroy() {
       super.onDestroy()
       mediaPlayer.release()
       Toast.makeText(this, "onDestroy Called", Toast.LENGTH_LONG).show()
   }
}
