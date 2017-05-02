# A6
## Group members
Patrick Johansen, Joachim Christensen
## Playing sound

### Defining sound
First of all whenever we work with digital sound it's called audio. Sound indicates that it is analogue (which is defined as sound which is 1 : 1 scale in relation to its source). So all sound we hear coming from biological sources such as rivers, animals etc. is considered sound, whereas a digital recreation of an analogue source is called audio. Everything you hear coming from speakers is audio.

### ADC vs DAC
In order to recreate biological sound we use a process called analogue to digital conversion. 
![image](http://support.azimadli.com/vibman/_AIntroduction%20to%20Machine%20Vibration-52.png)

The way an ADC works is fairly complex. There are a few different ways to achieve this feat (see Wikipedia for a list), but one of the most common technique uses the analog voltage to charge up an internal capacitor and then measure the time it takes to discharge across an internal resistor. The microcontroller monitors the number of clock cycles that pass before the capacitor is discharged. This number of cycles is the number that is returned once the ADC is complete.
[source](https://learn.sparkfun.com/tutorials/analog-to-digital-conversion)

Keywords:
1. Sampling rate
2. Resolution
3. ADC
4. DAC

