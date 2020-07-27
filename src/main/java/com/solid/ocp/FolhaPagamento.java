package com.solid.ocp;

public class FolhaPagamento {

    public Double calculate(Contrato contrato) {
        if (contrato instanceof ContratoClt)
            return ((ContratoClt) contrato).salario();

        if (contrato instanceof Estagio)
            return ((Estagio) contrato).bolsaAuxilio();

        return 0d;
    }
}
