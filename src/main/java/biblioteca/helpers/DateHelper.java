package biblioteca.helpers;

import java.util.Date;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DateHelper {

	Date fecha;
	
	public DateHelper() {
		// TODO Auto-generated constructor stub
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getFecha() {
		if (fecha != null)
			return fecha;
		return new Date();
	}
	
	
}
