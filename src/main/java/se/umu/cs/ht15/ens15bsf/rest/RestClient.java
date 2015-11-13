package se.umu.cs.ht15.ens15bsf.rest;

import org.restlet.resource.ClientResource;
import se.umu.cs._5dv153.interfaces.Message;

import java.io.IOException;

import static se.umu.cs.ht15.ens15bsf.rest.ServerKeywords.*;

/**
 * Created by ens15bsf on 2015-11-10.
 * Client exemple for Message restlet server.
 */
public class RestClient extends ClientResource
{
  /**
   * Create the client
   *
   * @param url Address of the restlet server
   */
  public RestClient ( String url )
  {
    super( url );
  }

  public String getTopics () throws IOException
  {
    setQueryValue( GET, TOPICS );
    return get().getText();
  }

  public String getMessages ( String topic ) throws IOException
  {
    setQueryValue( GET, MESSAGES );
    addQueryParameter( TOPIC_NAME, topic );
    return get().getText();
  }

  public String getMessagesWithTimeStamps ( String topic ) throws IOException
  {
    setQueryValue( GET, MESSAGES_WITH_TIMESTAMPS );
    addQueryParameter( TOPIC_NAME, topic );
    return get().getText();
  }

  public String getMessage ( String id ) throws IOException
  {
    setQueryValue( GET, MESSAGE );
    addQueryParameter( MESSAGE_ID, id );
    return get().getText();
  }

  public String postMessage ( Message msg ) throws IOException
  {
    setQueryValue( POST, MESSAGE );
    /**
     addQueryParameter( MESSAGE_ID, id );
     addQueryParameter( MSG_SENDER, sender );
     addQueryParameter( TOPIC_NAME, topic );
     addQueryParameter( MSG_CONTENT, content );
     addQueryParameter( MSG_TIME, time );
     **/
    String msgJson = JsonAgent.toJson( msg ).toString();
    return post( msgJson ).getText();
  }
}
