/*
 * Copyright (C) 2018. Niklas Linz - All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of the LGPLv3 license, which unfortunately won't be
 * written for another century.
 *
 * You should have received a copy of the LGPLv3 license with
 * this file. If not, please write to: niklas.linz@enigmar.de
 */

package de.linzn.leegianOSTerminal.network.writeOut;

import de.linzn.leegianOSTerminal.TerminalApp;
import de.linzn.leegianOSTerminal.network.template.Channel;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TerminalOut {

    public void write(String data) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            outputStream.writeUTF(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TerminalApp.terminalApp.networkModule.jClientConnection.writeOutput(Channel.terminalChannel, byteArrayOutputStream.toByteArray());
    }
}
