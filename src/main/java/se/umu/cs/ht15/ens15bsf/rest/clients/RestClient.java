package se.umu.cs.ht15.ens15bsf.rest.clients;

import org.restlet.resource.ClientResource;
import se.umu.cs._5dv153.interfaces.Message;
import se.umu.cs.ht15.ens15bsf.rest.JsonAgent;
import se.umu.cs.ht15.ens15bsf.rest.ServerKeywords;

import java.io.IOException;

import static se.umu.cs.ht15.ens15bsf.rest.ServerKeywords.*;

/**
 * Created by ens15bsf on 2015-11-10.
 * Client exemple for Message restlet server.
 */
public class RestClient
{

  private ClientResource messages;
  private ClientResource message;
  private ClientResource topics;

  /**
   * Create the client
   *
   * @param url Address of the restlet server
   */
  public RestClient ( String url )
  {
    message = new ClientResource( url + ServerKeywords.URI.MESSAGE + "/" );
    messages = new ClientResource( url + ServerKeywords.URI.MESSAGES + "/" );
    topics = new ClientResource( url + ServerKeywords.URI.TOPICS + "/" );
  }

  public String getTopics () throws IOException
  {
    return topics.get().getText();
  }

  public String getMessages ( String topic ) throws IOException
  {
    messages.addQueryParameter( TOPIC_NAME, topic );
    return messages.get().getText();
  }

  public String getMessagesWithTimeStamps ( String topic ) throws IOException
  {
    messages.setQueryValue( MESSAGES_WITH_TIMESTAMPS, MESSAGES_WITH_TIMESTAMPS );
    messages.addQueryParameter( TOPIC_NAME, topic );
    return messages.get().getText();
  }

  public String getMessage ( String id ) throws IOException
  {
    message.setQueryValue( MESSAGE, MESSAGE );
    message.addQueryParameter( MESSAGE_ID, id );
    return message.get().getText();
  }

  public String postMessage ( Message msg ) throws IOException
  {
    message.setQueryValue( POST, MESSAGE );
    /**
     addQueryParameter( MESSAGE_ID, id );
     addQueryParameter( MSG_SENDER, sender );
     addQueryParameter( TOPIC_NAME, topic );
     addQueryParameter( MSG_CONTENT, content );
     addQueryParameter( MSG_TIME, time );
     **/
    String msgJson = JsonAgent.toJson( msg ).toString();
    return message.post( msgJson ).getText();
  }
}
