package se.umu.cs.ht15.ens15bsf.rest.resources;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import se.umu.cs.ht15.ens15bsf.Storage;
import se.umu.cs.ht15.ens15bsf.rest.JsonAgent;

import static se.umu.cs.ht15.ens15bsf.rest.ServerKeywords.*;
import static se.umu.cs.ht15.ens15bsf.rest.ServerKeywords.TOPIC_NAME;

/**
 * Created by ens15bsf on 2015-11-24.
 */
public class ResourceMessages extends ServerResource
{
  @Get
  public String read ()
  {
    String reply = "";
    Storage messages = Storage.getInstance();
    String topicName = getQueryValue( TOPIC_NAME );
    String timestamp = getQueryValue( MESSAGES_WITH_TIMESTAMPS );
    // if request contains a topic name
    if ( null != topicName )
    {
      // if reauest is about messages ID with timestamps
      if ( null != timestamp )
      {
        // return a map id -> timestamp
        return JsonAgent.toJson( messages.listMessagesWithTimestamps( topicName ) ).toString();
      }
      else
      {
        // return the list of messages regarding the topic
        return JsonAgent.toJson( messages.listMessages( topicName ) ).toString();
      }
    }
    else
      return "Unknown request";
  }
}
