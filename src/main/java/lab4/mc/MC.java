package lab4.mc;

import java.util.*;

public class MC {
  public static void main(String[] args) {
    demo();
  }

  public static void demo() {
    Synth synth = new Synth();
    if(synth.turnON()) {
      // This is a list of MIDI pitches representing different medolies.
      // You can try those or make your own!
      ArrayList<Integer> gameOfThrone = new ArrayList<Integer>(List.of(67,60,63,65,67,60,63,65,67,60,63,65,62,65,58,63,62,65,58,63,62,60,67,60,63,65,67,60,63,65,67,60,63,65,62,65,58,63,62,65,58,63,62,60));
      ArrayList<Integer> itCrowd = new ArrayList<Integer>(List.of(60,60,60,67,63,63,63,70,67,67,67,74,70,70,70,67,60,60,60,67,63,63,63,70,67,67,67,74,75,75,75,67,60,60,60,67,63,63,63,70,67,67,67,74,70,70,70,67,60,60,56,56,63,63,60,60,67,67,63,63,60,60,63,63));
      ArrayList<Integer> odeToJoy = new ArrayList<Integer>(List.of(71, 71, 72, 74, 74, 72, 71, 69, 67, 67, 69, 71, 71, 69, 69, 71, 71, 72, 74, 74, 72, 71, 69, 67, 67, 69, 71, 69, 67, 67, 69, 69, 71, 67, 69, 71, 72, 71, 67, 69, 71, 72, 71, 69, 67, 69, 62, 71, 71, 72, 74, 74, 72, 71, 69, 67, 67, 69, 71, 69 ,67, 67));

      // Here we create a new note for each pitch that we play for 250ms.
      for(Integer pitch : itCrowd) {
        synth.startNote(pitch);
        synth.wait(250);
        synth.stopNote(pitch);
      }

      // Play a chord for 2 seconds (several notes at the same time).
      synth.startNote(60);
      synth.startNote(62);
      synth.startNote(64);
      synth.wait(2000);
      synth.stopNote(60);
      synth.stopNote(62);
      synth.stopNote(64);

      synth.turnOFF();
    }
  }
}