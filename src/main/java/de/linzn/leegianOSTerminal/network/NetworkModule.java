/*
 * Copyright (C) 2018. Niklas Linz - All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of the LGPLv3 license, which unfortunately won't be
 * written for another century.
 *
 * You should have received a copy of the LGPLv3 license with
 * this file. If not, please write to: niklas.linz@enigmar.de
 */

package de.linzn.leegianOSTerminal.network;

import de.linzn.jSocket.client.JClientConnection;
import de.linzn.leegianOSTerminal.TerminalApp;
import de.linzn.leegianOSTerminal.network.readIn.ConnectionEvents;
import de.linzn.leegianOSTerminal.network.readIn.TerminalStream;
import de.linzn.leegianOSTerminal.network.template.Channel;

public class NetworkModule {
    public JClientConnection jClientConnection;

    private TerminalApp terminalApp;

    public NetworkModule(TerminalApp terminalApp) {
        this.terminalApp = terminalApp;
        this.jClientConnection = new JClientConnection(this.terminalApp.appConfiguration.socketHost, this.terminalApp.appConfiguration.socketPort);
        this.registerEvents();
    }

    private void registerEvents() {
        this.jClientConnection.registerIncomingDataListener(Channel.terminalChannel, new TerminalStream(this.terminalApp));
        this.jClientConnection.registerConnectionListener(new ConnectionEvents());
    }

    public void createNetwork() {
        this.jClientConnection.setEnable();
    }

    public void deleteNetwork() {
        this.jClientConnection.setDisable();
    }

}
