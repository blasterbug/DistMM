package se.umu.cs.ht15.ens15bsf.soap;

import org.apache.axis2.AxisFault;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ens15bsf on 2015-11-13.
 */
public class SoapClientExemple
{
  private MessageAccessorServiceStub serviceStub;

  public SoapClientExemple () throws AxisFault
  {
    serviceStub = new MessageAccessorServiceStub();
  }

  public List<String> listTopics () throws RemoteException
  {
    MessageAccessorServiceStub.ListOfString ids = serviceStub.listTopics();
    List<String> topics = new LinkedList<>();
    for ( String topicName: ids.getListOfString().getString() )
      topics.add( topicName );
    return topics;
  }
}
