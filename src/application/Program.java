package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("N�mero do quarto: ");
			int quarto = sc.nextInt();
			System.out.print("Data Check-in: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data Check-out: ");
			Date checkOut = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(quarto, checkIn, checkOut);
			System.out.println("Dados da reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com os dados de altera��o da reserva:");
			System.out.print("Data Check-in: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data Check-out: ");
			checkOut = sdf.parse(sc.next());
			
			reserva.alteraReserva(checkIn, checkOut);
			System.out.println("Dados da altera��o da Reserva: " + reserva);
		} catch (ParseException e) {
			System.out.println("Formato da data incorreto.");
		} catch (DomainException e) {
			System.out.println("Erro na reserva: "+ e.getMessage());			
		}
		sc.close();
	}
}
