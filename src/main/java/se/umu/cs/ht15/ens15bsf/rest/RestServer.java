package se.umu.cs.ht15.ens15bsf.rest;

import org.restlet.Component;
import org.restlet.data.Protocol;
import se.umu.cs.ht15.ens15bsf.rest.resources.*;


/**
 * Created by ens15bsf on 2015-11-10.
 */
public class RestServer extends Component
{
  public static final int PORT = 4040;

  public RestServer ()
  {
    this( PORT );
  }

  public RestServer ( int port )
  {
    getServers().add( Protocol.HTTP, port );
    getDefaultHost().attach( "/" + ServerKeywords.URI.MESSAGE + "/", ResourceMessage.class );
    getDefaultHost().attach( "/" + ServerKeywords.URI.MESSAGES + "/", ResourceMessages.class );
    getDefaultHost().attach( "/" + ServerKeywords.URI.TOPICS + "/", ResourceTopics.class );
  }
}
