/*
 * Copyright (C) 2018. Niklas Linz - All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of the LGPLv3 license, which unfortunately won't be
 * written for another century.
 *
 * You should have received a copy of the LGPLv3 license with
 * this file. If not, please write to: niklas.linz@enigmar.de
 */

package de.linzn.leegianOSTerminal.network.readIn;

import de.linzn.jSocket.core.IncomingDataListener;
import de.linzn.leegianOSTerminal.TerminalApp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.UUID;

public class TerminalStream implements IncomingDataListener {

    private TerminalApp terminalApp;

    public TerminalStream(TerminalApp terminalApp) {
        this.terminalApp = terminalApp;
    }

    @Override
    public void onEvent(String channel, UUID uuid, byte[] bytes) {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(bytes));
        String values = null;
        try {
            values = in.readUTF();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
