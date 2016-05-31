## The Realtime Framework Pub/Sub messaging system
Part of the [The Realtime® Framework](http://framework.realtime.co), Realtime Cloud Messaging (aka ORTC) is a secure, fast and highly scalable cloud-hosted Pub/Sub real-time message broker for web and mobile apps.

If your website or mobile app has data that needs to be updated in the user’s interface as it changes (e.g. real-time stock quotes or ever changing social news feed) Realtime Cloud Messaging is the reliable, easy, unbelievably fast, “works everywhere” solution.

## The Android + GCM Push Notifications sample app
This sample app uses the Realtime® Framework Pub/Sub Android library to connect, send and receive messages through a Realtime® Server in the cloud. Through the integrated use of Google Cloud Messaging (GCM) messages are delivered to users as push notifications when the app is not running. 

![ScreenShot](http://messaging-public.realtime.co/screenshots/2.1.0/Android/example1.png) ![ScreenShot](http://messaging-public.realtime.co/screenshots/2.1.0/Android/example2.png)

###This app is compatible with the iOS sample. See [https://github.com/realtime-framework/MessagingObjectivecChat](https://github.com/realtime-framework/MessagingObjectivecChat)


> NOTE: For simplicity these samples assume you're using a Realtime® Framework developers' application key with the authentication service disabled (every connection will have permission to publish and subscribe to any channel). For security guidelines please refer to the [Security Guide](http://messaging-public.realtime.co/documentation/starting-guide/security.html). 
> 
> **Don't forget to replace `YOUR_APPLICATION_KEY` with your own application key and `YOUR_PROJECT_ID` with your GCM Project Number. If you don't already own a free Realtime® Framework application key, [get one now](https://accounts.realtime.co/signup/).**

## Prerequisites

* [Download Android Studio](http://developer.android.com/sdk/installing/studio.html).  

* Under Tools / Android / Android SDK Manager make sure "Extras/Google Repository","Extras/Google Play services","Extras/Android Support Repository" and "Extras/Android Support Library", are installed.

## Documentation
The Mobile Push Notifications Starting Guide can be found [here](http://messaging-public.realtime.co/documentation/starting-guide/mobilepush.html)
 
The complete Realtime® Cloud Messaging reference documentation is available [here](http://framework.realtime.co/messaging/#documentation)
