package lab4.mc;

import javax.sound.midi.*;

// Code inspired by:
//   https://stackoverflow.com/questions/16462854/midi-beginner-need-to-play-one-note
public class Synth {
  Synthesizer midiSynth;
  Instrument[] instr;
  MidiChannel[] mChannels;

  public Synth() {}

  //! This method must be called before any call to `startNote`.
  public boolean turnON() {
    try {
       /* Create a new Sythesizer and open it. Most of
       * the methods you will want to use to expand on this
       * example can be found in the Java documentation here:
       * https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/Synthesizer.html
       */
      midiSynth = MidiSystem.getSynthesizer();
      midiSynth.open();

      // Get and load default instrument and channel lists
      instr = midiSynth.getDefaultSoundbank().getInstruments();
      mChannels = midiSynth.getChannels();
      midiSynth.loadInstrument(instr[0]); // load an instrument
      return true;
    }
    catch (MidiUnavailableException e) {
      e.printStackTrace();
      return false;
    }
  }

  //! Turning OFF the synthesizer.
  public void turnOFF() {
    midiSynth.close();
  }

  //! Play the note number `pitch` with velocity 100.
  public void startNote(int pitch) {
    mChannels[0].noteOn(pitch, 100);
  }

  //! Turn off the note `pitch`.
  public void stopNote(int pitch) {
    mChannels[0].noteOff(pitch, 100);
  }

  //! Suspend the program for a number `timeInMS` of milliseconds.
  //! This is useful to wait between `startNote` and `endNote`.
  public void wait(int timeInMS) {
    try {
      Thread.sleep(timeInMS); // wait time in milliseconds to control duration
    } catch(InterruptedException e) {
        e.printStackTrace();
    }
  }
}