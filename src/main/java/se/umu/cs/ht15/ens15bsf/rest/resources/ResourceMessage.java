package se.umu.cs.ht15.ens15bsf.rest.resources;

import org.restlet.resource.*;
import se.umu.cs._5dv153.interfaces.Message;
import se.umu.cs.ht15.ens15bsf.Storage;
import se.umu.cs.ht15.ens15bsf.rest.JsonAgent;

import static se.umu.cs.ht15.ens15bsf.rest.ServerKeywords.*;

/**
 * Created by ens15bsf on 2015-11-09.
 */
public class ResourceMessage extends ServerResource
{
  @Get
  public String read ()
  {
    String reply = "";
    String argData = getQueryValue( MESSAGE_ID );
    Storage storage = Storage.getInstance();
    // if the request contains an ID
    if ( null != argData )
    {
      try
      {
        return JsonAgent.toJson( storage.retrieveMessage( argData ) ).toString();
      }
      catch ( NullPointerException e )
      {
        return "Wrong message ID";
      }
    }
    else
      return "Unkown request";
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
