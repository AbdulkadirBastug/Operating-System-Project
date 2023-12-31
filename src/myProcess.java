package packet;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class myProcess extends Thread{
	
	private int _arrivalTime;
	private int _priority;
	private int _processorTime;
	private int _remainingTime;
	private int _id;
	private int _lastCallTime;
	private int _memory;
	private int _printer;
	private int _scanner;
	private int _modem;
	private int _CD;

	public myProcess(String arrivalTime, String priority, String processorTime, String memory, String printer, String scanner, String modem, String CD){		
		_arrivalTime = Integer.parseInt(arrivalTime);
		_priority = Integer.parseInt(priority);
		_processorTime = Integer.parseInt(processorTime);
		_remainingTime = Integer.parseInt(processorTime);
		_memory = Integer.parseInt(memory);
		_printer = Integer.parseInt(printer);
		_scanner = Integer.parseInt(scanner);
		_modem = Integer.parseInt(modem);
		_CD = Integer.parseInt(CD);
		_lastCallTime = _arrivalTime;
		_id = Dispatcher.idCounter;
		Dispatcher.idCounter++;

	}
	
	public void execute() {
		
		// çalıştırılmak istenen proses için bu fonksiyon kullanılır
		// proses, oluşturduğumuz jar dosyasını çalıştırır

		String priority = String.valueOf(this._priority);
		String remainingTime = String.valueOf(this._processorTime);
		String processId = String.valueOf((this._id));
		String memory = String.valueOf((this._memory));
		String printer = String.valueOf((this._printer));
		String scanner = String.valueOf((this._scanner));
		String modem = String.valueOf((this._modem));
		String CD = String.valueOf((this._CD));
		String jar = "java -jar Java_Process.jar";
		String parameter = jar + " " + processId + " " + priority + " " + remainingTime + " " + memory + " " + printer + " " + scanner + " " + modem + " " + CD ;		
		try {
	          runProcess(parameter); 
	    } 
		catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	

	private void runProcess(String command) throws Exception {		
		// yeni bir proses oluşturur.
        Process process = Runtime.getRuntime().exec(command);    	
        printLines(process.getInputStream());
        printLines(process.getErrorStream());    
        process.waitFor();// prosesin bitmesini bekler.
      }
	
    private void printLines(InputStream ins) throws Exception {
    	// Main programdan ayrı olan prosesler ekrana yazdırılır.
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(" " +line);
        }
      }

    public void executeMessage() {
		System.out.print (Dispatcher.timer + " sn proses basladi			" );
	}
	public void runningMessage() {
		System.out.print(Dispatcher.timer + " sn proses yurutuluyor		" );
	}	
	public void suspendedMessage() { 
		System.out.print(Dispatcher.timer + " sn proses askida			" ); }
	public void endMessage() {
		System.out.print(Dispatcher.timer + " sn proses sonlandi		" );
	}
	public void overTimeMessage() {
		System.out.print(Dispatcher.timer + " sn proses zaman asimi 		");
	}
	public void overRtMemoryMessage() {
		System.out.println(Dispatcher.timer + " sn proses HATA - Gerçek-zamanlı proses (64MB) tan daha fazla bellek talep ediyor - proses silindi 		");
	}
	public void overRtResourcesMessage() {
		System.out.println(Dispatcher.timer + " sn proses HATA - Gerçek-zamanlı proses çok sayıda kaynak talep ediyor - proses silindi		");
	}
	public void overMemoryMessage() {
		System.out.println(Dispatcher.timer + " sn proses HATA - Proses (960 MB) tan daha fazla bellek talep ediyor – proses silindi 		");
	}
	public void overResourcesMessage() {
		System.out.println(Dispatcher.timer + " sn proses HATA - Proses çok sayıda kaynak talep ediyor - proses silindi		");
	}
	
	
	public int get_arrivalTime() { return _arrivalTime; }
	public int get_priority() { return _priority; }
	public int get_processorTime() { return _processorTime; }
	public int get_RemainingTime() { return _remainingTime; }
	public int get_lastCallTime() {return _lastCallTime;}
	public int get_memory() {return _memory;}
	public int get_printer() {return _printer;}
	public int get_scanner() {return _scanner;}
	public int get_modem() {return _modem;}
	public int get_CD() {return _CD;}

	
	public void set_lastCallTime(int _lastCallTime) {this._lastCallTime = _lastCallTime;}
	public void set_arrivalTime(int _arrivalTime) {this._arrivalTime = _arrivalTime;}
	public void set_priority(int _priority) {this._priority = _priority;}
	public void set_processorTime(int _processorTime) {this._processorTime = _processorTime;}
	public void set_memory(int _memory) {this._memory = _memory;}
	public void set_printer(int _printer) {this._printer = _printer;}
	public void set_scanner(int _scanner) {this._scanner = _scanner;}
	public void set_modem(int _modem) {this._modem = _modem;}
	public void set_CD(int _CD) {this._CD = _CD;}
}
	

