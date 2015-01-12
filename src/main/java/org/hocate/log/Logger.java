package org.hocate.log;

public class Logger {
	private static Formater formater = Formater.newInstance();

	public static void debug(Object msg){
		Message message = Message.newInstance("DEBUG", msg.toString());
		formater.writeLog(message);
	}
	public static void info(Object msg){
		Message message = Message.newInstance("INFO", msg.toString());
		formater.writeLog(message);
	}
	public static void warn(Object msg){
		Message message = Message.newInstance("WARN", msg.toString());
		formater.writeLog(message);
	}
	public static void error(Object msg){
		Message message = Message.newInstance("ERROR", msg.toString());
		formater.writeLog(message);
	}
	public static void fatal(Object msg){
		Message message = Message.newInstance("FATAL", msg.toString());
		formater.writeLog(message);
	}
}
