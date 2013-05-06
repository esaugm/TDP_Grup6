/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.exception;

import common.utils.TDSLanguageUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.MissingResourceException;

/**
 *
 * @author josi
 */
public class AppException extends Exception {

	private String msgEx = null;

	public AppException() {
		super();
		this.msgEx = TDSLanguageUtils.getMessage("Server.Exception.Generic");
                //printErr(this);
	}

	public AppException(String message) {
		super(message);
                this.msgEx = message;
                //printErr(this);
	}

	public AppException(FileNotFoundException ex) {
		super();
                this.msgEx = TDSLanguageUtils.getMessage("Server.Exception.FileNotFound");
		printErr(ex);
	}

	public AppException(IOException ex) {
                super();
		this.msgEx = TDSLanguageUtils.getMessage("Server.Exception.IOError");
		printErr(ex);
	}

	public AppException(SQLException ex) {
                super();
		this.msgEx = TDSLanguageUtils.getMessage("Server.Exception.SQLError");
		printErr(ex);
	}

	public AppException(MissingResourceException ex) {
		// Si no se ha cargado el resource, no tenemos mensajes: hardcoded
		super("Server: Resource file not found");
		printErr(ex);
	}

	public AppException(ClassNotFoundException ex) {
		// Si no se ha cargado el resource, no tenemos mensajes: hardcoded
		super("Server: Resource file not found");
		printErr(ex);
	}

        private void printErr(Exception ex) {
            System.err.println("------------------");
            System.err.println("ServerAppException:: "+this.msgEx);
            System.err.println("------------------");
            //ex.printStackTrace(System.out);
            System.err.println(ex.getMessage());
            System.err.println("------------------");

        }
}
