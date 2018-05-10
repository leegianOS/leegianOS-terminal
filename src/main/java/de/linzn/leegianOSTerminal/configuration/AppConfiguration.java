/*
 * Copyright (C) 2018. Niklas Linz - All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of the LGPLv3 license, which unfortunately won't be
 * written for another century.
 *
 * You should have received a copy of the LGPLv3 license with
 * this file. If not, please write to: niklas.linz@enigmar.de
 */

package de.linzn.leegianOSTerminal.configuration;

import de.linzn.leegianOSTerminal.TerminalApp;

import java.io.*;
import java.util.Properties;

public class AppConfiguration {

    /* Variables */
    public String socketHost;
    public int socketPort;
    private TerminalApp terminalApp;
    private String fileName = "terminal.properties";

    /* Create class instance */
    public AppConfiguration(TerminalApp terminalApp) {
        this.terminalApp = terminalApp;
        this.init();

    }

    /* Create folders and files*/
    public void init() {
        File file = new File(this.fileName);
        if (!file.exists()) {
            create();
        }
        this.load();

    }

    /* Setup properies file with values */
    public void create() {

        Properties prop = new Properties();
        OutputStream output;

        try {

            output = new FileOutputStream(this.fileName);
            // set the properties value
            prop.setProperty("socketHost", "0.0.0.0");
            prop.setProperty("socketPort", "11102");

            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    /* Load the file in the memory */
    public void load() {

        Properties prop = new Properties();
        InputStream input;

        try {
            input = new FileInputStream(this.fileName);

            prop.load(input);

            this.socketHost = prop.getProperty("socketHost");
            this.socketPort = Integer.parseInt(prop.getProperty("socketPort"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
