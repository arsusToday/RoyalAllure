package com.netease.m

import android.app.Application
import android.content.Context
import android.util.Log
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.my.tracker.MyTracker
import com.netease.m.AppClass.Companion.C1
import com.netease.m.AppClass.Companion.MAIN_ID
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.UUID

class AppClass: Application() {
    companion object {
        const val AF_DEV_KEY = "XjeAd7nZJTPBTQoxsnMgTT"
        const val SDK_KEY = "50803854048421985041"
        const val jsoupCheck = "1v4b"
        const val ONESIGNAL_APP_ID = "78c02d03-2384-4b28-bcfe-1846f3a1b73a"

        val linkFilterPart1 = "http://royal"
        val linkFilterPart2 = "allure.xyz/go.php?to=1&"

        val odone = "sub_id_1="

        var MAIN_ID: String? = ""
        var C1: String? = "c11"
        var LOG_DATA: String? = "logData"
        var USER_SAVED: String? = "userSaved"
        var MYID: String? = "myID"
        var INSTID: String? = "instID"

    }
        override fun onCreate() {
            super.onCreate()

            OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
            // OneSignal Initialization
            OneSignal.initWithContext(this)
            OneSignal.setAppId(ONESIGNAL_APP_ID)
            Hawk.init(this).build()

        val trackerParams = MyTracker.getTrackerParams()
        val trackerConfig = MyTracker.getTrackerConfig()
        val instID = MyTracker.getInstanceId(this)
            trackerConfig.isTrackingLaunchEnabled=true
            val ID = UUID.randomUUID().toString()
            trackerParams.setCustomUserId(ID)
            Hawk.put(MYID, ID)
            Hawk.put(INSTID, instID)
            Log.d("dev_test", instID)
            MyTracker.initTracker(SDK_KEY, this)


        }

    }
