package se.umu.cs.ht15.ens15bsf;

import se.umu.cs._5dv153.interfaces.Message;
import se.umu.cs.ht15.ens15bsf.rest.RestServer;

import java.util.Date;

/**
 * Created by ens15bsf on 2015-11-10.
 */
public class TestServerREST
{
  public static void main ( String[] args )
  {
    Storage strg = Storage.getInstance();
    //Message(String id, String sender, String topic, Long timestamp, String content) {
    Date time = new Date();
    long timeStamp = time.getTime();
    strg.postMessage( new Message( "0", "Yoda", "Jedi", timeStamp, "When nine hundred years old you reach, look as good you will not." ) );
    timeStamp = time.getTime();
    strg.postMessage( new Message( "1", "Obi-Wan", "Jedi", timeStamp, "You can't win Darth. If you strike me down, I shall become more powerful than you can possibly imagine." ) );
    timeStamp = time.getTime();
    strg.postMessage( new Message( "2", "Obi-Wan", "Jedi", timeStamp, "You can't win Darth. If you strike me down, I shall become more powerful than you can possibly imagine." ) );
    timeStamp = time.getTime();
    strg.postMessage( new Message( "3", "DarkVador", "Sith", timeStamp, "He will join us or die, my master." ) );
    RestServer server = new RestServer();
    try
    {
      server.start();
    }
    catch ( Exception e )
    {
      e.printStackTrace();
      System.exit( 1 );
    }
  }
}
