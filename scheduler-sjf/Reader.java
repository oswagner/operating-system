import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

	public Reader(){}

	public ArrayList<Process> readFileInput(String fileInputName) throws IOException {
		ArrayList<Process> allProcess = new ArrayList<Process>();
		int cpuBurst = 0, lastTimeCPU = 0, outOfCPU = 0;
		
		FileReader file = new FileReader(fileInputName);
		
		BufferedReader fileBuffer = new BufferedReader(file);
		String line = fileBuffer.readLine();
		double weight = Double.parseDouble(line.replace(',','.')); 
		allProcess.add(new Process(weight));
		
		line = fileBuffer.readLine();
		while (line != null) {
			String[] lineValues = line.trim().split("\\s+|\\/");
	
			cpuBurst = Integer.parseInt(lineValues[0]);
			lastTimeCPU = Integer.parseInt(lineValues[1]);
			outOfCPU= Integer.parseInt(lineValues[2]);
				
			allProcess.add(new Process(cpuBurst, lastTimeCPU, outOfCPU));
			line = fileBuffer.readLine();
		}
		return allProcess;
	}
	
	
}
