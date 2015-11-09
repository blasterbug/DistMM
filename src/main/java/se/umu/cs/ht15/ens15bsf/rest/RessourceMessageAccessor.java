package se.umu.cs.ht15.ens15bsf.rest;

import org.restlet.resource.*;

/**
 * Created by ens15bsf on 2015-11-09.
 */
public class RessourceMessageAccessor extends ServerResource
{
  @Get
  public String read ()
  {
    String argData = getQueryValue( "data" );
    return "Hello\n" + argData + "\n";
  }

  @Put
  public String Update ( String arg )
  {
    return "update!\n" + arg + "\n";
  }

  @Post
  public String Create ( String arg )
  {
    return "create!\n" + arg + "\n";
  }

  @Delete
  public String Delete ()
  {
    return "delete!\n";
  }
}
