# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in G:\adt-bundle-windows-x86_64-20140702\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-ignorewarnings
-optimizationpasses 5
-dontusemixedcaseclassnames

-keepattributes Signature

-dontwarn net.slidingmenu.tools.**
-keep class net.slidingmenu.tools.** {
    *;
}

#以下这一句为消除v4包被混淆
-keep class android.support.v4.** { *; }

-keepclasseswithmembers class c.b.** { *; }
-keep interface c.b.PListener{ *; }
-keep interface c.b.QListener{ *; }

-keep class com.ktplay.**{*;}
-keep class com.kryptanium.**{*;}

-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}

## youmi sdk
#-dontwarn net.youmi.android.**
#-keep class net.youmi.android.** {
#    *;
#}
#
## xiaomi ad monitor sdk
#-keep public class com.mi.adtracker.MiAdTracker{ *; }