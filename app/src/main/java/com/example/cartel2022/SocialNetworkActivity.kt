package com.example.cartel2022

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SocialNetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_network)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Réseaux Sociaux"
    }

    fun switchInstagram(view: View) {
        val openURL = Intent(android.content.Intent.ACTION_VIEW)
        val url :String = getString(R.string.url_instagram)
        openURL.data = Uri.parse(url)
        startActivity(openURL)
    }

    fun switchFacebook(view:View){
        val openURL = Intent(android.content.Intent.ACTION_VIEW)
        val url :String = getString(R.string.url_facebook)
        openURL.data = Uri.parse(url)
        startActivity(openURL)
    }

    fun switchWebSite(view:View){
        val openURL = Intent(android.content.Intent.ACTION_VIEW)
        val url :String = getString(R.string.url_web_site)
        openURL.data = Uri.parse(url)
        startActivity(openURL)
    }

}