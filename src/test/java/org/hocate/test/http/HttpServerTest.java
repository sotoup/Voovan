package org.hocate.test.http;

import java.io.IOException;
import java.util.Date;
import org.hocate.http.server.HttpServer;
import org.hocate.log.Logger;

public class HttpServerTest {
	public static void main(String[] args) {
		try {
			//HttpServer httpServer = new HttpServer("0.0.0.0",2080,100,"/Users/helyho/Downloads");
			HttpServer httpServer = HttpServer.newInstance();
			httpServer.get("/", (req,resp)->{
											    if(req.getSession()!=null && req.getSession().getAttributes("Time")!=null){
											    	Logger.simple("Session saved time"+req.getSession().getAttributes("Time"));
											    }
												req.getSession().setAttribute("Time", new Date().toString());
												resp.body().writeString("<b>This is HTTP test!</b><br>"+req.getQueryString());
											}
			);
			httpServer.Serve();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}