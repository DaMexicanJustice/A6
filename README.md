# A6
## Group members
Patrick Johansen, Joachim Christensen
## Playing sound

* We will need to do some Kotlin refactoring together on our code examples to improve them. We tried to get the code blocks as Kotlin-like as possible. 

### Defining sound
First of all whenever we work with digital sound it's called audio. Sound indicates that it is analogue (which is defined as sound which is 1 : 1 scale in relation to its source). So all sound we hear coming from biological sources such as rivers, animals etc. is considered sound, whereas a digital recreation of an analogue source is called audio. Everything you hear coming from speakers is audio.

### ADC vs DAC
In order to recreate biological sound we use a process called analogue to digital conversion. 
![image](http://support.azimadli.com/vibman/_AIntroduction%20to%20Machine%20Vibration-52.png)

The way an ADC works is fairly complex. There are a few different ways to achieve this feat (see Wikipedia for a list), but one of the most common technique uses the analog voltage to charge up an internal capacitor and then measure the time it takes to discharge across an internal resistor. The microcontroller monitors the number of clock cycles that pass before the capacitor is discharged. This number of cycles is the number that is returned once the ADC is complete.
[source](https://learn.sparkfun.com/tutorials/analog-to-digital-conversion)

The higher the sampling rate the more accuratately the sound imitates its source. Raw audio formats take up a lot of space, whereas some audio formats are more compressed. A popular compressed format is MP3 and a known raw audio format are .raw, .pcm, or .sam. A very compressed format is .midi

Keywords:
1. Sampling rate
2. Resolution
3. Accuracy
4. ADC
5. DAC

### Hardware
Most Android phones (well most any phone really) has 2 or more audio devices. A microphone for recording audio (your voice) which is the signal used in ADC and speakers which produce audio using DAC(Digital to Analogue conversion). The processes are similar, one reconstructs an audio signal from a recorded file (the file has bits used as values for voltage, which in terms defines the sound we get out of our speakers) and the other records one such file. 

![speaker](https://images.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.carmako.nl%2Fmedia%2Fcarmako%2Fcache%2F20%2F1d%2F201dd99b29e7ae8e4dc9fdadc3ad2bbd.jpg&f=1) 
![microphone](https://images.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.myboyfriendgifts.com%2Fwp-content%2Fuploads%2F2015%2F01%2FIK-Multimedia-iRig-Mic-Cast-podcasting-mic-for-smartphones-and-tablets-0-1.jpg&f=1)

### MediaPlayer

[MediaPlayer](https://developer.android.com/guide/topics/media/mediaplayer.html) is a framework we can use when developing Android apps to play audio, video and images. It is basically a multimedia player and can handle a handful of media types. 
We will use this to play sound utilizing our speakers.

#### What we need
The following classes are used to play sound and video in the Android framework:

##### MediaPlayer
This class is the primary API for playing sound and video.

##### AudioManager
This class manages audio sources and audio output on a device

##### Manifest declarations
Before starting development on your application using MediaPlayer, make sure your manifest has the appropriate declarations to allow use of related features.

Internet Permission - 

If you are using MediaPlayer to stream network-based content, your application must request network access.

`<uses-permission android:name="android.permission.INTERNET" />`

Wake Lock Permission - 

If your player application needs to keep the screen from dimming or the processor from sleeping, or uses the MediaPlayer.setScreenOnWhilePlaying() or MediaPlayer.setWakeMode() methods, you must request this permission.

`<uses-permission android:name="android.permission.WAKE_LOCK" />`

### MediaRecorder

[MediaRecorder](https://developer.android.com/guide/topics/media/mediarecorder.html) is a framework that allows us to record audio utilizing the microphone of our smart phones. 

### App demonstration audio recording & playing

#### Using Media Player to play audio from raw directory
Navigate to your res directory and add a new folder 'raw' and add an MP3 file of your choosing to the raw directory. File must be all lowercase and include .fileformat eg: bomberman.mp3

```
val mediaPlayer = MediaPlayer.create(this, R.raw.bomberman)
mediaPlayer.start()
```

#### Using Media Player to play audio from the ringtone directory
We choose whatever is set as the current tune for notications in this example to ensure it works on all platforms and not only for my emulator/phone
```
val ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
val mp = MediaPlayer.create(this, ringtoneUri)
mp.start()
```

#### Playing a user-defined tune from SD card
```
mp = MediaPlayer()
val path = android.os.Environment.getExternalStorageDirectory()
val filename = "urmp3filename"
mp.setDataSource(path.toString() + filename)
```

#### Recording audio using microphone
Android has a list of "dangerous permissions" which pose a security risk to the user. These are:
1. Manifest.permission.READ_CALENDAR	Read calendar events
2. Manifest.permission.WRITE_CALENDAR	Write calendar events
3. Manifest.permission.CAMERA	Access camera object
4. Manifest.permission.READ_CONTACTS	Read phone contacts
5. Manifest.permission.WRITE_CONTACTS	Write phone contacts
6. Manifest.permission.ACCESS_FINE_LOCATION	Access precise location
7. Manifest.permission.ACCESS_COARSE_LOCATION	Access general location
8. **Manifest.permission.RECORD_AUDIO	Record with microphone**
9. Manifest.permission.CALL_PHONE	Call using the dialer
10. Manifest.permission.READ_EXTERNAL_STORAGE	Read external or SD
11. Manifest.permission.WRITE_EXTERNAL_STORAGE

When dealing with these we need to have the user give us permission to access the feature at run-time. 

Code example goes here....
