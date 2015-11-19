package se.umu.cs.ht15.ens15bsf;


import se.umu.cs.ht15.ens15bsf.soap.MessageAccessorServiceStub;

import java.rmi.RemoteException;

/**
 * Created by ens15bsf on 2015-11-17.
 */
public class TestClientSOAP
{
  public static void main( String[] args ) throws RemoteException
  {
    MessageAccessorServiceStub client = new MessageAccessorServiceStub(  );
    MessageAccessorServiceStub.ListOfString topicsString = client.listTopics();
    System.out.println(topicsString.toString());
  }
}
