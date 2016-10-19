/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import org.junit.Assert;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Felipe
 */
public class TicketMachineTeste {
    
    public TicketMachineTeste() {
    }
    
    @Test
    public void testarVerificarSaldo() throws SaldoInsuficienteException{
        //saldo a ser verificado menor que o valor
        //necessariamente o valor tem que ser maior que o saldo
        int valor = 3;
        int saldo = 2100;
        TicketMachine t = new TicketMachine(valor);
        //t.setSaldo(saldo);
        Assert.assertTrue(t.verificaSaldo());
        
    }
    
    @Test
    public void testarImprimir() throws SaldoInsuficienteException{
        TicketMachine t = new TicketMachine();    
        assertNotNull(t.imprimir());
    }
    
}
