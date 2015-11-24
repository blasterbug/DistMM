package se.umu.cs.ht15.ens15bsf;

import se.umu.cs._5dv153.interfaces.Message;
import se.umu.cs.ht15.ens15bsf.rest.clients.RestClient;
import se.umu.cs.ht15.ens15bsf.rest.RestServer;

import java.io.IOException;
import java.util.Date;

/**
 * Created by ens15bsf on 2015-11-10.
 */
public class TestClientREST
{
  public static void main ( String[] args ) throws IOException
  {
    RestClient client = new RestClient( "http://localhost:" + RestServer.PORT + "/" );
    System.out.println( client.getTopics() );
    System.out.println( client.getMessages( "Jedi" ) );
    System.out.println( client.getMessage( "0" ) );
    // Message(String id, String sender, String topic, Long timestamp, String content)
    client.postMessage(
            new Message(
                    "100",
                    "DarkVador",
                    "Sith",
                    new Date().getTime(),
                    "Obi-Wan once thought as you do. You don't know the power of the Dark Side, I must obey my master."
            )
    );
    System.out.println( client.getMessagesWithTimeStamps( "Jedi" ) );
  }
}
