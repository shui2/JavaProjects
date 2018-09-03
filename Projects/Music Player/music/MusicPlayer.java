package music;

import javax.sound.midi.*;

public class MusicPlayer {

	public void play() {
		try
		{
			Sequencer a = MidiSystem.getSequencer();
			a.open();
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			ShortMessage b = new ShortMessage();
			b.setMessage(144, 1, 44, 100);
			MidiEvent noteOn = new MidiEvent(b, 1);
			track.add(noteOn);
			
			ShortMessage c = new ShortMessage();
			b.setMessage(128, 1, 44, 100);
			MidiEvent noteOff = new MidiEvent(c, 16);
			track.add(noteOff);
			
			a.setSequence(seq);
			a.start();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MusicPlayer mp = new MusicPlayer();
		mp.play();
	}
}