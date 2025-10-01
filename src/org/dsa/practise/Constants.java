package org.dsa.practise;

public class Constants {
	
	private Constants() {
		/**
		 * prevent initialization.
		 */
	}
	
	public static class ENV {
		public enum DebugMode{
			OFF,
			DEBUG,
			INFO,
			TRACE
		}
		
		public static final DebugMode DEBUG_MODE = DebugMode.OFF;
		
	}

}
