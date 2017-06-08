import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;


public class Jetty {
  private static final byte[] HELLO_WORLD_BYTES = toUtf8Bytes(
      "<!DOCTYPE html>\n" +
      "<html>\n" +
      "<head><title>Hello, World!</title></head>\n" + 
      "<body>Hello, World!</body>\n" +
      "</html>");
  
  private static final byte[] toUtf8Bytes(final String str) {
    try {
      return str.getBytes("UTF-8");
    } catch ( UnsupportedEncodingException e ) {
      throw new IllegalStateException(e);
    }
  }
  
  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);
    
    server.setHandler(new DefaultHandler() {
      @Override
      public void handle(
         String arg,
         Request request, 
         HttpServletRequest httpRequest,
         HttpServletResponse httpResponse)
         throws IOException, ServletException
      {
        request.setHandled(true);
        
        httpResponse.setStatus(HttpServletResponse.SC_OK);
        
        httpResponse.setContentType("text/html");
        httpResponse.setCharacterEncoding("UTF-8");
        
        httpResponse.getOutputStream().write(HELLO_WORLD_BYTES);
      }
    });
    
    server.start();
  }
}
