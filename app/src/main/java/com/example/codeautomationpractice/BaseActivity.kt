package com.example.codeautomationpractice

import android.Manifest
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.Window
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.codeautomationpractice.common.LocaleUtils
import org.jetbrains.annotations.NotNull


abstract class BaseActivity : AppCompatActivity(), BaseView {
    @LayoutRes
    abstract fun getResource(): Int
    var OPEN_MEDIA_PICKER = 100
    private lateinit var binding: ViewDataBinding
    abstract fun initView()

    // abstract fun initProgressBar()
    abstract fun initObserver()
    abstract fun handleListener()

    //  abstract fun showLoadingIndicator(isShow: Boolean)
    //abstract fun displayMessage(message: String)
    var isInternetConnected: Boolean = true
    var dialog: Dialog? = null


    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        /* when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
             Configuration.UI_MODE_NIGHT_YES ->{
                 AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
             }
             Configuration.UI_MODE_NIGHT_NO ->{
                 AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
             }

         }*/
        super.onCreate(savedInstanceState)
        setView(getResource(), savedInstanceState)
    }


    private fun setView(@LayoutRes layoutId: Int, savedInstanceState: Bundle?) {
        try {
            binding = DataBindingUtil.setContentView(this, layoutId)
/*
            initProgressBar()
*/
            initObserver()
            initView()
            handleListener()

        } catch (e: Exception) {
            Log.e(this.localClassName, e.printStackTrace().toString())
            // resToast(e.message!!)
        }
    }

//    fun initProgressBar() {
//        dialog = Dialog(this)
//        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog!!.setContentView(R.layout.progress_dialog)
//        dialog!!.window!!.setBackgroundDrawableResource(android.R.color.transparent)
//        dialog!!.setCancelable(false)
//    }

//    fun displayMessage(message: String) {
//        CustomToast.showToast(this, message)
//    }
//
//    fun showLoadingIndicator(isShow: Boolean) {
//        isVisible(isShow, dialog)
//    }

    protected fun <T : ViewDataBinding> getBinding(): T {
        @Suppress("UNCHECKED_CAST")
        return binding as T
    }

/*
    private lateinit var mToolbar: Toolbar

    @SuppressLint("RestrictedApi")
    protected fun setToolbar(
        @NotNull toolbar: Toolbar, @NotNull title: String, isBackEnabled: Boolean = false,
        backgroundColor: Int = R.color.colorPrimary
    ) {
        this.mToolbar = toolbar
        super.setSupportActionBar(toolbar)
        toolbar.setBackgroundColor(ContextCompat.getColor(this, backgroundColor))
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.title = title

        toolbar.title = title

        if (isBackEnabled) {
            supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeButtonEnabled(true)
            //if (backgroundColor == R.color.white)
            // toolbar.setNavigationIcon(R.drawable.ic_back_arrow)
            toolbar.setNavigationOnClickListener { onBackPressed() }
        }
    }
*/

   /* fun setTitle(@NotNull title: String) {
        this.mToolbar.title = title
    }


    fun setNavigationIcon(navigationIconResId: Int) {
        if (::mToolbar.isInitialized) {
            mToolbar.setNavigationIcon(navigationIconResId)
        }
    }
*/
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }


    fun changeFragment(
        fragmentManager: FragmentManager,
        fragment: Fragment,
        layout: Int,
        addToBackStack: Boolean = false
    ) {
        fragmentManager.beginTransaction().replace(layout, fragment, fragment::class.java.name)
            .commit()
    }

    fun checkFragmentVisible(fragmentManager: FragmentManager, fragmentName: String): Boolean {
        return fragmentManager.findFragmentByTag(fragmentName)?.isVisible ?: false
    }

    override fun onUnknownError(error: String?) {
        error?.let {
            Log.d("Error","Base Activity Unknown error $error")
        }
    }

    override fun internalServer() {
        Log.d("Error","Base Activity API Internal server")
    }

    override fun onTimeout() {
        Log.d("Error","Base Activity API Timeout")
    }

    override fun onNetworkError() {
        Log.d("Error","Base Activity  network error")

    }

    override fun onConnectionError() {
        Log.d("Error","Base Activity  internet issue")
    }

    override fun attachBaseContext(newBase: Context?) {
        //super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
        super.attachBaseContext(LocaleUtils.setLocale(newBase!!, "en"))
    }

    fun isStoragePermissionGranted(): Boolean {
        return if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED && checkSelfPermission(
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            Log.v("TAG", "Permission is granted")
            true
        } else {
            Log.v("TAG", "Permission is revoked")
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA),
                OPEN_MEDIA_PICKER
            )
            false
        }
    }


    fun isLocationPermissionGranted():Boolean{
        return  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && checkSelfPermission(
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                Log.v("TAG", "Permission is granted")
                true
            } else {
                Log.v("TAG", "Permission is revoked")
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1
                )
                false
            }
        } else {
            Log.v("TAG", "Permission is granted")
            true
        }
    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        when (requestCode) {
//            1 -> {
//                if (grantResults.isNotEmpty() && grantResults[0] ==
//                    PackageManager.PERMISSION_GRANTED) {
//                    if ((ContextCompat.checkSelfPermission(this@BaseActivity,
//                            Manifest.permission.ACCESS_FINE_LOCATION) ===
//                                PackageManager.PERMISSION_GRANTED)) {
//                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
//                    }
//                } else {
//                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
//                }
//                return
//            }
//            2->{
//
//            }
//        }
//    }

/* override fun autoLogout() {
     mUserHolder?.clearData()
     val intent = Intent(this, SignInActivity::class.java)
     intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
             or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
     startActivity(intent)
 }*/

}