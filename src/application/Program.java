package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
		Scanner sc = new Scanner(System.in);
		System.out.print("Número do quarto: ");
		int quarto = sc.nextInt();
		System.out.print("Data Check-in: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data Check-out: ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva. Data de checkout deve ser posterior a data de check-in.");
		} else {
			Reserva reserva = new Reserva(quarto, checkIn, checkOut);
			System.out.println("Dados da reserva: " + reserva);
			System.out.println();
			System.out.println("Entre com os dados de alteração da reserva:");
			System.out.print("Data Check-in: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data Check-out: ");
			checkOut = sdf.parse(sc.next());
			
			String erro = reserva.alteraReserva(checkIn, checkOut);
			if (erro != null ) {
				System.out.println("Erro na reserva: " + erro);
			} else {
				System.out.println("Dados da alteração da Reserva: " + reserva);
			}
		}
		sc.close();

	}

}
