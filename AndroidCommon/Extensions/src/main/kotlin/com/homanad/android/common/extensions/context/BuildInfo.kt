package com.homanad.android.common.extensions.context

import android.content.Context
import android.content.pm.PackageManager

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