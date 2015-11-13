package se.umu.cs.ht15.ens15bsf.rest;

import org.restlet.resource.*;
import se.umu.cs._5dv153.interfaces.Message;
import se.umu.cs.ht15.ens15bsf.Storage;

import static se.umu.cs.ht15.ens15bsf.rest.ServerKeywords.*;

/**
 * Created by ens15bsf on 2015-11-09.
 */
public class RessourceMessageAccessor extends ServerResource
{
  @Get
  public String read ()
  {
    String reply = "";
    String argData = getQueryValue( GET );
    if ( null != argData )
    {
      Storage messages = Storage.getInstance();
      // get list of topics
      if ( argData.equals( TOPICS ) )
        reply = JsonAgent.toJson( messages.listTopics() ).toString();
        // messages list for a topic
      else if ( argData.equals( MESSAGES ) )
      {
        String topic = getQueryValue( TOPIC_NAME );
        reply = JsonAgent.toJson( messages.listMessages( topic ) ).toString();
      }
      else if ( argData.equals( MESSAGE ) )
      {
        String id = getQueryValue( MESSAGE_ID );
        reply = JsonAgent.toJson( messages.retrieveMessage( id ) ).toString();
      }
      else if ( argData.equals( MESSAGES_WITH_TIMESTAMPS ) )
      {
        String topic = getQueryValue( TOPIC_NAME );
        reply = JsonAgent.toJson( messages.listMessagesWithTimestamps( topic ) ).toString();
      }
      else
      {
        reply = "Unknown request";
      }
    }
    return reply;
  }

  @Put
  public String Update ( String arg )
  {
    return "update!\n" + arg + "\n";
  }

  @Post
  public String Create ( String arg )
  {
    String reply = "OK";
    Message newMsg = JsonAgent.readMessage( arg );
    Storage.getInstance().postMessage( newMsg );
    return reply;
  }

  @Delete
  public String Delete ()
  {
    return "delete!\n";
  }
}
