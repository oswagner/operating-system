import java.io.IOException;
import java.util.ArrayList;

public class SchedulerSJF {

	public static void main(String[] args) {
		Reader reader = new Reader();
		try {
			ArrayList<Process> allProcess = reader.readFileInput("data.txt");
			for(int i = 1; i < allProcess.size(); i++) {
				if(allProcess.get(i).getUltimoTempoCPU() == 0) {
					System.out.println("Finish");
				}
				else{
					System.out.println(allProcess.get(i).evaluateNextBurst(allProcess.get(0).getLastWeight()));
				}			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
