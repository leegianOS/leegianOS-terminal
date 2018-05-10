/*
 * Copyright (C) 2018. Niklas Linz - All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of the LGPLv3 license, which unfortunately won't be
 * written for another century.
 *
 * You should have received a copy of the LGPLv3 license with
 * this file. If not, please write to: niklas.linz@enigmar.de
 */

package de.linzn.leegianOSTerminal;

import de.linzn.leegianOSTerminal.configuration.AppConfiguration;
import de.linzn.leegianOSTerminal.network.NetworkModule;


public class TerminalApp {
    public static TerminalApp terminalApp;
    public AppConfiguration appConfiguration;
    public NetworkModule networkModule;

    public TerminalApp(String[] args) {
        terminalApp = this;
        this.appConfiguration = new AppConfiguration(this);
        this.networkModule = new NetworkModule(this);

        this.startup();
    }

    public static void main(String[] args) {
        new TerminalApp(args);
    }

    private void startup() {
        this.networkModule.createNetwork();
    }


}
