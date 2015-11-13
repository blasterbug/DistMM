package se.umu.cs.ht15.ens15bsf.soap;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import se.umu.cs._5dv153.interfaces.Message;
import se.umu.cs.ht15.ens15bsf.Storage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ens15bsf on 2015-11-13.
 */
public class SoapServer
{
  private static final String SERVICE = "http://cs.umu.se/ht15/ens15bsf/soap/";

  public static OMElement listMessages(OMElement listMessagesRequest)
  {
    OMFactory factory = OMAbstractFactory.getOMFactory();
    OMNamespace namespace = factory.createOMNamespace( SERVICE, "ns1" );

    ArrayList<Message> greetingList = new ArrayList<Message>();
    Iterator<OMElement> elementIterator = listMessagesRequest.getChildElements();
    String name = elementIterator.next().getText();
    String message = elementIterator.next().getText();
    List<String> list = new LinkedList<String>( Storage.getInstance().listMessages( name ) );

    OMElement response = factory.createOMElement( "listMessages", namespace );
    OMElement nameElement = factory.createOMElement( "name", null );
    //nameElement.addChild( factory.createOMText( list.?? ) );
    response.addChild( nameElement );
    OMElement messageElement = factory.createOMElement( "message", null );
    messageElement.addChild( factory.createOMText( list.toString() ) );
    response.addChild( messageElement );
    return response;
  }
}
