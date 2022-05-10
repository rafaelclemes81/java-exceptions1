package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	
	private Integer quarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer quarto, Date checkIn, Date checkOut) throws DomainException {
		
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Erro na reserva. Data de checkout deve ser posterior a data de check-in.");
		}
		this.quarto = quarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getQuarto() {
		return quarto;
	}

	public void setQuarto(Integer quarto) {
		this.quarto = quarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}	
	
	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public void alteraReserva(Date checkIn, Date ckeckOut) throws DomainException{
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			 throw new DomainException("Datas de check-in e check-out precisam ser datas futuras.");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Erro na reserva. Data de checkout deve ser posterior a data de check-in.");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Quarto "
				+ quarto
				+ ", checkin: "
				+ sdf.format(checkIn)
				+ ", checkout: "
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+ " noites";
	}
	
	
}
