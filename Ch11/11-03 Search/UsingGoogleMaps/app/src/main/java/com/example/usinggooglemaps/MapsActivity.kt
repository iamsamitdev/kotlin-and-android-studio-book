package com.example.usinggooglemaps

import android.Manifest
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*
import java.io.IOException
import java.util.*


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    var Lat = 13.803742
    var Lng = 100.554603
    private val LOCATION_REQUEST_CODE = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val status = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this@MapsActivity)
        if (status == ConnectionResult.SUCCESS) {
            if (ActivityCompat.checkSelfPermission(this@MapsActivity, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this@MapsActivity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_REQUEST_CODE)
            }
        }

        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        cmdSearch.setOnClickListener{
            val q = edtSearch.getText().toString().trim()
            if (q != "") {
                val geo = Geocoder(this@MapsActivity, Locale.getDefault())
                try {
                    val addLists = geo.getFromLocationName(q, 7)
                    if (addLists.size > 0) {
                        mMap.clear()
                        var add: Address? = null
                        var CurrentAddress: LatLng? = null
                        for (i in 0 until addLists.size) {
                            add = addLists.get(i) as Address
                            CurrentAddress = LatLng(add.getLatitude(), add.getLongitude())
                            var str = ""
                            for (j in 0 until add.getMaxAddressLineIndex()) {
                                str = str + add.getAddressLine(j) + "\n"
                            }
                            val m = mMap.addMarker(MarkerOptions()
                                    .position(CurrentAddress)
                                    .title((add.getAddressLine(0) + " (Lat : " + add.getLatitude()
                                            + ") (Lng : " + add.getLongitude() + ")"))
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                                    .snippet(str))
                        }
                        val cam = CameraPosition.Builder()
                                .target(CurrentAddress)
                                .zoom(15F)
                                .build()
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cam))
                    } else {
                        Toast.makeText(getBaseContext(), "ไม่พบที่อยู่ตามที่คุณระบุ!!!", Toast.LENGTH_LONG).show()
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }

        cmdClear.setOnClickListener {
            mMap.clear()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            LOCATION_REQUEST_CODE -> {
                if (grantResults.size == 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "ไม่สามารถใช้งานแผนที่ได้", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val jj = LatLng(Lat, Lng)
        if (ActivityCompat.checkSelfPermission(this@MapsActivity, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this@MapsActivity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_REQUEST_CODE)
        } else {
            mMap.isMyLocationEnabled = true
            mMap.uiSettings.isZoomControlsEnabled = true
        }

        mMap.addMarker(MarkerOptions().position(jj).title("จตุจักร"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(jj))
        mMap.setOnMapClickListener { latLng ->
            val strAddress = ("Lat : " + latLng.latitude.toString() + " "
                    + "Lng : " + latLng.longitude.toString())
            val m = MarkerOptions()
            m.position(latLng)
            m.title(strAddress)
            mMap.addMarker(m)
        }
    }
}