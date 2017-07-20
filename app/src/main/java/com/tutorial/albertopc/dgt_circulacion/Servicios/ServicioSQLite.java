package com.tutorial.albertopc.dgt_circulacion.Servicios;

import android.content.Context;

import com.tutorial.albertopc.dgt_circulacion.bbdd.BdCitas;
import com.tutorial.albertopc.dgt_circulacion.bbdd.BdUsers;
import com.tutorial.albertopc.dgt_circulacion.entity.Cita;
import com.tutorial.albertopc.dgt_circulacion.entity.Usuario;

/**
 * Created by Alberto PC on 30/04/2017.
 */

public class ServicioSQLite {
    BdCitas tablaCitas;
    BdUsers tablaUsers;

    public ServicioSQLite(Context cont) {
        tablaCitas = new BdCitas(cont,"citacion", null, 1);
        tablaUsers = new BdUsers(cont,"administracion", null, 1);
    }

    public BdCitas getTablaCitas() {
        return tablaCitas;
    }

    public BdUsers getTablaUsers() {
        return tablaUsers;
    }

    public void altaBD()
    {
        Usuario usu = new Usuario("alopez","dgt2015","Alberto López");
        tablaUsers.alta(usu);

        Cita c1 = new Cita(1, "11111111A",  "08/05/2017 08:00", "Pujol", "1435 CAT","alopez", "Creado");
        tablaCitas.alta(c1);
        Cita c2 = new Cita(2, "22222222B",  "08/05/2017 08:30", "Aguirre", "3645 MAD","alopez", "Creado");
        tablaCitas.alta(c2);
        Cita c3 = new Cita(3, "33333333C",  "08/05/2017 09:00", "Echenique", "8998 ARA","alopez", "Creado");
        tablaCitas.alta(c3);
        Cita c4 = new Cita(4, "44444444D",  "08/05/2017 09:30", "Arzallus", "5566 VAS","alopez", "Creado");
        tablaCitas.alta(c4);
        Cita c5 = new Cita(5, "55555555E",  "08/05/2017 10:00", "Bono", "1435 CLM","alopez", "Creado");
        tablaCitas.alta(c5);
        Cita c6 = new Cita(6, "66666666F",  "08/05/2017 10:30", "Diaz", "2235 AND","alopez", "Creado");
        tablaCitas.alta(c6);
        Cita c7 = new Cita(7, "77777777G",  "08/05/2017 12:00", "Fraga", "7742 GAL","alopez", "Creado");
        tablaCitas.alta(c7);
        Cita c8 = new Cita(8, "88888888H",  "08/05/2017 12:30", "Revilla", "6854 CAN","alopez", "Creado");
        tablaCitas.alta(c8);
        Cita c9 = new Cita(9, "99999999I",  "08/05/2017 13:00", "Barberá", "1435 VAL","alopez", "Creado");
        tablaCitas.alta(c9);
    }
}
