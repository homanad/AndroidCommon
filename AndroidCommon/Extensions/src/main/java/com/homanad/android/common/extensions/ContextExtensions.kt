package com.homanad.android.common.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.view.animation.Interpolator
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.annotation.StyleRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.use

fun Context.showAlertDialog(
    positiveButtonText: String,
    title: String,
    message: String,
    cancelable: Boolean = false,
    action: () -> Unit
) {
    val dialog = AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setCancelable(cancelable)
        .setPositiveButton(positiveButtonText) { dialog, _ ->
            dialog.cancel()
            action()
        }.create()
    dialog.show()
}

fun Context.showShortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showLongToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

@ColorInt
@SuppressLint("Recycle")
fun Context.themeColor(
    @AttrRes themeAttrId: Int
): Int {
    return obtainStyledAttributes(
        intArrayOf(themeAttrId)
    ).use {
        it.getColor(0, Color.MAGENTA)
    }
}

/**
 * Retrieve a style from the current [android.content.res.Resources.Theme].
 */
@StyleRes
fun Context.themeStyle(@AttrRes attr: Int): Int {
    val tv = TypedValue()
    theme.resolveAttribute(attr, tv, true)
    return tv.data
}

@SuppressLint("Recycle")
fun Context.themeInterpolator(@AttrRes attr: Int): Interpolator {
    return AnimationUtils.loadInterpolator(
        this,
        obtainStyledAttributes(intArrayOf(attr)).use {
            it.getResourceId(0, android.R.interpolator.fast_out_slow_in)
        }
    )
}

fun Context.getDrawableOrNull(@DrawableRes id: Int?): Drawable? {
    return if (id == null || id == 0) null else AppCompatResources.getDrawable(this, id)
}

fun Context.dismissKeyboard(view: View) {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.showKeyboard(view: View, delay: Long) {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    view.postDelayed({
        view.requestFocus()
        imm.showSoftInput(view, 0)
    }, delay)
}

val Context.versionName: String?
    get() = try {
        val pInfo = packageManager.getPackageInfo(packageName, 0);
        pInfo?.versionName
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        null
    }

val Context.versionCode: Long?
    get() = try {
        val pInfo = packageManager.getPackageInfo(packageName, 0)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            pInfo?.longVersionCode
        } else {
            @Suppress("DEPRECATION")
            pInfo?.versionCode?.toLong()
        }
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        null
    }

@Suppress("DEPRECATION")
val Context.screenSize: Point
    get() {
        val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size
    }