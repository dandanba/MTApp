#[android-proguard-snippets](https://github.com/krschultz/android-proguard-snippets)

# This is a configuration file for ProGuard.
# http://proguard.sourceforge.net/index.html#manual/usage.html
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose
# Optimization is turned off by default. Dex does not like code run
# through the ProGuard optimize and preverify steps (and performs some
# of these optimizations on its own).
-dontoptimize
-dontpreverify
# Note that if you want to enable optimization, you cannot just
# include optimization flags in your own project configuration file;
# instead you will need to point to the
# "proguard-android-optimize.txt" file instead of this one from your
# project.properties file.
-keepattributes *Annotation*
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService
# For native methods, see http://proguard.sourceforge.net/manual/examples.html#native
-keepclasseswithmembernames class * {
    native <methods>;
}
# keep setters in Views so that animations can still work.
# see http://proguard.sourceforge.net/manual/examples.html#beans
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}
# We want to keep methods in Activity that could be used in the XML attribute onClick
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}
# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
-keepclassmembers class **.R$* {
    public static <fields>;
}
# The support library contains references to newer platform versions.
# Don't warn about those in case this app is linking against an older
# platform version.  We know about them, and they are safe.
-dontwarn android.support.**

## New rules for EventBus 3.0.x ##
# http://greenrobot.org/eventbus/documentation/proguard/

#-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

# Only required if you use AsyncExecutor
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}

## Retrolambda specific rules ##
# as per official recommendation: https://github.com/evant/gradle-retrolambda#proguard
-dontwarn java.lang.invoke.*

# https://raw.githubusercontent.com/JakeWharton/butterknife/master/butterknife/proguard-rules.txt
# Retain generated class which implement ViewBinder.
-keep public class * implements butterknife.internal.ViewBinder { public <init>(); }

# Prevent obfuscation of types which use ButterKnife annotations since the simple name
# is used to reflectively look up the generated ViewBinder.
-keep class butterknife.*
-keepclasseswithmembernames class * { @butterknife.* <methods>; }
-keepclasseswithmembernames class * { @butterknife.* <fields>; }

#https://docs.fabric.io/android/crashlytics/dex-and-proguard.html
#We’ve made it simple to set up ProGuard or DexGuard in your app and receive deobfuscated crash reports. First of all, Fabric uses annotations internally, so add the following line to your configuration file:
-keepattributes *Annotation*
#Next, in order to provide the most meaningful crash reports, add the following line to your configuration file:

-keepattributes SourceFile,LineNumberTable
#Crashlytics will still function without this rule, but your crash reports will not include proper file names or line numbers.
#If you are using custom exceptions, add this line so that custom exception types are skipped during obfuscation:

-keep public class * extends java.lang.Exception
#For Fabric to properly de-obfuscate your crash reports, you need to remove this line from your configuration file, or we won’t be able to automatically upload your mapping file:
#-printmapping mapping.txt

# jackson
-keepattributes *Annotation*,EnclosingMethod,Signature
-keepnames class com.fasterxml.jackson.** { *; }
-dontwarn com.fasterxml.jackson.databind.**
-keep class org.codehaus.** { *; }
-keepclassmembers public final enum org.codehaus.jackson.annotate.JsonAutoDetect$Visibility {
 public static final org.codehaus.jackson.annotate.JsonAutoDetect$Visibility *; }
-keep public class cn.maitian.model.** {
  public void set*(***);
  public *** get*();
}

#glide https://github.com/bumptech/glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
#java.io.IOException: proguard.ParseException: Unknown option '-keepresourcexmlelements' in line 112 of file 'D:\Android\MTApp\app\proguard-rules.pro'
#-keepresourcexmlelements manifest/application/meta-data@value=GlideModule

# Retrofit 2.X
## https://square.github.io/retrofit/ ##
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

# common https://github.com/Trinea/android-common
-keep class cn.trinea.android.** { *; }
-keepclassmembers class cn.trinea.android.** { *; }
-dontwarn cn.trinea.android.**

# LeakCanary
-keep class org.eclipse.mat.** { *; }
-keep class com.squareup.leakcanary.** { *; }

