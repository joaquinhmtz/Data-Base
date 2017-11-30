package Web;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

public class MyViewModel {

	private int count;
	private String mensaje;


	@Init
	public void init() {
		count = 500;
		mensaje="Hola mundo";
	}

	@Command
	@NotifyChange("count")
	public void cmd() {
		++count;
	}

	public int getCount() {
		return count;
	}

	public String getMensaje(){
		return mensaje;
	}
}
