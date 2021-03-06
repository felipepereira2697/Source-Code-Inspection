package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};
//    refatorei aqui
    public TicketMachine(){
    
    }
    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[i] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return saldo;
    }

    public Integer getTroco() {
       return this.saldo-this.valor;
    }
    
    //refatorei aqui
//    public boolean verificaSaldo() throws SaldoInsuficienteException{
//        //retorna true se o saldo disponivel for maior ou igual ao valor
//       if(saldo<valor){
//           throw new SaldoInsuficienteException();
//       }
//       return true;
//    }
    public boolean verificaSaldo() throws SaldoInsuficienteException{
        if(saldo<valor){
            throw new SaldoInsuficienteException();
        }
        return true;
    }
    public String imprimir() throws SaldoInsuficienteException{
        this.verificaSaldo();//caso o saldo seja menor que o valor ele lança a exception
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
    
    //refatorei aqui
    //public void setSaldo(int saldo) {
        //this.saldo = saldo;
    //}
    
}
