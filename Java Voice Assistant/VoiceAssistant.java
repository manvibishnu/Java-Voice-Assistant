package trial2023.maven;
import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class VoiceAssistant {

	public static void main(String[] st) {
		
		Configuration config = new Configuration();
		
		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		config.setDictionaryPath("src\\main\\java\\trial2023\\maven\\6843.dic");
		config.setLanguageModelPath("src\\main\\java\\trial2023\\maven\\6843.lm");
		
		try {
			LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
			speech.startRecognition(true);
			
			SpeechResult speechResult = null;
			
			while ((speechResult = speech.getResult()) != null) {
				String voiceCommand = speechResult.getHypothesis();
				System.out.println("Voice Command is " + voiceCommand);
				
				if (voiceCommand.equalsIgnoreCase("Open Facebook")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome https://www.facebook.com/AECTechClub/");
				} else if (voiceCommand.equalsIgnoreCase("Close Facebook")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
				} else if (voiceCommand.equalsIgnoreCase("Open Github")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome https://github.com/");
				} else if (voiceCommand.equalsIgnoreCase("Close Github")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
				} else if (voiceCommand.equalsIgnoreCase("Start Browser")) {
					Runtime.getRuntime().exec("cmd.exe /c start msedge");
				} else if (voiceCommand.equalsIgnoreCase("Close Browser")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM msedge.exe /F");
				} else if (voiceCommand.equalsIgnoreCase("Open Linkedin")) {
					Runtime.getRuntime().exec("cmd.exe /c start chrome https://www.linkedin.com/feed/");
				} else if (voiceCommand.equalsIgnoreCase("Close Linkedin")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM chrome.exe");
				} else if (voiceCommand.equalsIgnoreCase("Open Store")) {
					Runtime.getRuntime().exec("cmd.exe /c start ms-windows-store:");
				} else if (voiceCommand.equalsIgnoreCase("Close Store")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM ms-windows-store:.exe");
				} else if (voiceCommand.equalsIgnoreCase("Play Music")) {
					Runtime.getRuntime().exec("cmd.exe /c start spotify.exe");
				} else if (voiceCommand.equalsIgnoreCase("Stop Music")) {
					Runtime.getRuntime().exec("cmd.exe /c TASKKILL /IM spotify.exe");
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}