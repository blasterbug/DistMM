package se.umu.cs.ht15.ens15bsf.rest;

import org.restlet.Server;
import org.restlet.data.Protocol;

/**
 * Created by ens15bsf on 2015-11-10.
 */
public class RestServer extends Server
{
  public static final int PORT = 4040;

  public RestServer()
  {
    super( Protocol.HTTP, PORT, RessourceMessageAccessor.class );
  }

  public RestServer( int port )
  {
    super( Protocol.HTTP, port, RessourceMessageAccessor.class );
  }
}
