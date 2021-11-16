package com.example.cartel2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.cartel2022.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = intent.getStringExtra(EXTRA_MENU)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Marker
        val saintetienne = LatLng(45.41700653746735, 4.4137146977643065)
        val ecole = LatLng(45.42289033717162, 4.408448297764533)
        val gymnaseVolley = LatLng(45.43527080151072, 4.378916453157492)
        val gymnaseBasket = LatLng(45.43758249016208, 4.394937572092885)
        val gymnaseHandball = LatLng(45.42455944946987, 4.422770910724117)
        // Add marker
        mMap.addMarker(MarkerOptions().position(saintetienne).title("ME"))
        mMap.addMarker(MarkerOptions().position(ecole).title("École des Mines de Saint-Étienne"))
        mMap.addMarker(MarkerOptions().position(gymnaseVolley).title("Gymnase volley"))
        mMap.addMarker(MarkerOptions().position(gymnaseBasket).title("Gymnase basket"))
        mMap.addMarker(MarkerOptions().position(gymnaseHandball).title("Gymnase handball"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(45.436026705799726, 4.38689569776504), 13F))
    }
}