package se.umu.cs.ht15.ens15bsf.rest.resources;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import se.umu.cs.ht15.ens15bsf.Storage;
import se.umu.cs.ht15.ens15bsf.rest.JsonAgent;

/**
 * Created by ens15bsf on 2015-11-24.
 */
public class ResourceTopics extends ServerResource
{

  @Get
  public String read ()
  {
    return JsonAgent.toJson( Storage.getInstance().listTopics() ).toString();
  }
}
