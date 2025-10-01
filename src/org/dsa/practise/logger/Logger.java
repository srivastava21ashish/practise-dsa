package org.dsa.practise.logger;

import org.dsa.practise.Constants;
import org.dsa.practise.Constants.ENV.DebugMode;

public class Logger {

	private Logger(Class myClass) {
		// TODO Auto-generated constructor stub
	}

	private static Class myClass;

	public static final void debug(String format, Object... objects) {
		Logger.print(format, DebugMode.DEBUG, objects);
	}
	
	public static final void info(String format, Object... objects) {
		Logger.print(format, DebugMode.DEBUG, objects);
	}
	
	public static final void trace(String format, Object... objects) {
		Logger.print(format, DebugMode.DEBUG, objects);
	}
	
	public static final void print(String format,DebugMode mode, Object... objects) {
		if (Constants.ENV.DEBUG_MODE == mode) {
			String formattedString = String.format(format, objects);
			System.out.println(formattedString);
		}
	}

	public static Logger getLogger(Class myClass) {
		return new Logger(myClass);
	}

}
