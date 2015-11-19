/**
 * MessageAccessorServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package se.umu.cs.ht15.ens15bsf.soap;


/**
 * MessageAccessorServiceMessageReceiverInOut message receiver
 */
public class MessageAccessorServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver
{
  public void invokeBusinessLogic (
          org.apache.axis2.context.MessageContext msgContext,
          org.apache.axis2.context.MessageContext newMsgContext )
          throws org.apache.axis2.AxisFault
  {
    try
    {
      // get the implementation class for the Web Service
      Object obj = getTheImplementationObject( msgContext );

      MessageAccessorServiceSkeletonInterface skel = (MessageAccessorServiceSkeletonInterface) obj;

      //Out Envelop
      org.apache.axiom.soap.SOAPEnvelope envelope = null;

      //Find the axisOperation that has been set by the Dispatch phase.
      org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext()
              .getAxisOperation();

      if ( op == null )
      {
        throw new org.apache.axis2.AxisFault(
                "Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider" );
      }

      java.lang.String methodName;

      if ( ( op.getName() != null ) &&
              ( ( methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(
                      op.getName().getLocalPart() ) ) != null ) )
      {
        if ( "retrieveMessage".equals( methodName ) )
        {
          se.umu.cs.edu.soa.hws.stubs.types.MessageObjectDocument messageObject17 =
                  null;
          se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument wrappedParam =
                  (se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument) fromOM( msgContext.getEnvelope()
                                  .getBody()
                                  .getFirstElement(),
                          se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument.class,
                          getEnvelopeNamespaces( msgContext.getEnvelope() ) );

          messageObject17 = skel.retrieveMessage( wrappedParam );

          envelope = toEnvelope( getSOAPFactory( msgContext ),
                  messageObject17, false,
                  new javax.xml.namespace.QName(
                          "http://cs.umu.se/edu/soa/hws/stubs/",
                          "retrieveMessage" ) );
        }
        else if ( "postMessage".equals( methodName ) )
        {
          se.umu.cs.edu.soa.hws.stubs.types.MessageObjectDocument wrappedParam =
                  (se.umu.cs.edu.soa.hws.stubs.types.MessageObjectDocument) fromOM( msgContext.getEnvelope()
                                  .getBody()
                                  .getFirstElement(),
                          se.umu.cs.edu.soa.hws.stubs.types.MessageObjectDocument.class,
                          getEnvelopeNamespaces( msgContext.getEnvelope() ) );

          skel.postMessage( wrappedParam );

          envelope = getSOAPFactory( msgContext ).getDefaultEnvelope();
        }
        else if ( "listTopics".equals( methodName ) )
        {
          se.umu.cs.edu.soa.hws.stubs.types.ListOfStringDocument listOfString21 =
                  null;
          listOfString21 = skel.listTopics();

          envelope = toEnvelope( getSOAPFactory( msgContext ),
                  listOfString21, false,
                  new javax.xml.namespace.QName(
                          "http://cs.umu.se/edu/soa/hws/stubs/",
                          "listTopics" ) );
        }
        else if ( "listMessagesWithTimestamps".equals( methodName ) )
        {
          se.umu.cs.edu.soa.hws.stubs.types.MapDocument map23 = null;
          se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument wrappedParam =
                  (se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument) fromOM( msgContext.getEnvelope()
                                  .getBody()
                                  .getFirstElement(),
                          se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument.class,
                          getEnvelopeNamespaces( msgContext.getEnvelope() ) );

          map23 = skel.listMessagesWithTimestamps( wrappedParam );

          envelope = toEnvelope( getSOAPFactory( msgContext ), map23,
                  false,
                  new javax.xml.namespace.QName(
                          "http://cs.umu.se/edu/soa/hws/stubs/",
                          "listMessagesWithTimestamps" ) );
        }
        else if ( "listMessages".equals( methodName ) )
        {
          se.umu.cs.edu.soa.hws.stubs.types.ListOfStringDocument listOfString25 =
                  null;
          se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument wrappedParam =
                  (se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument) fromOM( msgContext.getEnvelope()
                                  .getBody()
                                  .getFirstElement(),
                          se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument.class,
                          getEnvelopeNamespaces( msgContext.getEnvelope() ) );

          listOfString25 = skel.listMessages( wrappedParam );

          envelope = toEnvelope( getSOAPFactory( msgContext ),
                  listOfString25, false,
                  new javax.xml.namespace.QName(
                          "http://cs.umu.se/edu/soa/hws/stubs/",
                          "listMessages" ) );
        }
        else
        {
          throw new java.lang.RuntimeException( "method not found" );
        }

        newMsgContext.setEnvelope( envelope );
      }
    }
    catch ( java.lang.Exception e )
    {
      throw org.apache.axis2.AxisFault.makeFault( e );
    }
  }

  //
  private org.apache.axiom.om.OMElement toOM (
          se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument param,
          boolean optimizeContent ) throws org.apache.axis2.AxisFault
  {
    return toOM( param );
  }

  private org.apache.axiom.om.OMElement toOM (
          final se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument param )
          throws org.apache.axis2.AxisFault
  {
    org.apache.xmlbeans.XmlOptions xmlOptions = new org.apache.xmlbeans.XmlOptions();
    xmlOptions.setSaveNoXmlDecl();
    xmlOptions.setSaveAggressiveNamespaces();
    xmlOptions.setSaveNamespacesFirst();

    org.apache.axiom.om.OMXMLParserWrapper builder = org.apache.axiom.om.OMXMLBuilderFactory.createOMBuilder( new javax.xml.transform.sax.SAXSource(
            new org.apache.axis2.xmlbeans.XmlBeansXMLReader( param,
                    xmlOptions ), new org.xml.sax.InputSource() ) );

    try
    {
      return builder.getDocumentElement( true );
    }
    catch ( java.lang.Exception e )
    {
      throw org.apache.axis2.AxisFault.makeFault( e );
    }
  }

  private org.apache.axiom.om.OMElement toOM (
          se.umu.cs.edu.soa.hws.stubs.types.MessageObjectDocument param,
          boolean optimizeContent ) throws org.apache.axis2.AxisFault
  {
    return toOM( param );
  }

  private org.apache.axiom.om.OMElement toOM (
          final se.umu.cs.edu.soa.hws.stubs.types.MessageObjectDocument param )
          throws org.apache.axis2.AxisFault
  {
    org.apache.xmlbeans.XmlOptions xmlOptions = new org.apache.xmlbeans.XmlOptions();
    xmlOptions.setSaveNoXmlDecl();
    xmlOptions.setSaveAggressiveNamespaces();
    xmlOptions.setSaveNamespacesFirst();

    org.apache.axiom.om.OMXMLParserWrapper builder = org.apache.axiom.om.OMXMLBuilderFactory.createOMBuilder( new javax.xml.transform.sax.SAXSource(
            new org.apache.axis2.xmlbeans.XmlBeansXMLReader( param,
                    xmlOptions ), new org.xml.sax.InputSource() ) );

    try
    {
      return builder.getDocumentElement( true );
    }
    catch ( java.lang.Exception e )
    {
      throw org.apache.axis2.AxisFault.makeFault( e );
    }
  }

  private org.apache.axiom.om.OMElement toOM (
          se.umu.cs.edu.soa.hws.stubs.types.ListOfStringDocument param,
          boolean optimizeContent ) throws org.apache.axis2.AxisFault
  {
    return toOM( param );
  }

  private org.apache.axiom.om.OMElement toOM (
          final se.umu.cs.edu.soa.hws.stubs.types.ListOfStringDocument param )
          throws org.apache.axis2.AxisFault
  {
    org.apache.xmlbeans.XmlOptions xmlOptions = new org.apache.xmlbeans.XmlOptions();
    xmlOptions.setSaveNoXmlDecl();
    xmlOptions.setSaveAggressiveNamespaces();
    xmlOptions.setSaveNamespacesFirst();

    org.apache.axiom.om.OMXMLParserWrapper builder = org.apache.axiom.om.OMXMLBuilderFactory.createOMBuilder( new javax.xml.transform.sax.SAXSource(
            new org.apache.axis2.xmlbeans.XmlBeansXMLReader( param,
                    xmlOptions ), new org.xml.sax.InputSource() ) );

    try
    {
      return builder.getDocumentElement( true );
    }
    catch ( java.lang.Exception e )
    {
      throw org.apache.axis2.AxisFault.makeFault( e );
    }
  }

  private org.apache.axiom.om.OMElement toOM (
          se.umu.cs.edu.soa.hws.stubs.types.MapDocument param,
          boolean optimizeContent ) throws org.apache.axis2.AxisFault
  {
    return toOM( param );
  }

  private org.apache.axiom.om.OMElement toOM (
          final se.umu.cs.edu.soa.hws.stubs.types.MapDocument param )
          throws org.apache.axis2.AxisFault
  {
    org.apache.xmlbeans.XmlOptions xmlOptions = new org.apache.xmlbeans.XmlOptions();
    xmlOptions.setSaveNoXmlDecl();
    xmlOptions.setSaveAggressiveNamespaces();
    xmlOptions.setSaveNamespacesFirst();

    org.apache.axiom.om.OMXMLParserWrapper builder = org.apache.axiom.om.OMXMLBuilderFactory.createOMBuilder( new javax.xml.transform.sax.SAXSource(
            new org.apache.axis2.xmlbeans.XmlBeansXMLReader( param,
                    xmlOptions ), new org.xml.sax.InputSource() ) );

    try
    {
      return builder.getDocumentElement( true );
    }
    catch ( java.lang.Exception e )
    {
      throw org.apache.axis2.AxisFault.makeFault( e );
    }
  }

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope (
          org.apache.axiom.soap.SOAPFactory factory,
          se.umu.cs.edu.soa.hws.stubs.types.MessageObjectDocument param,
          boolean optimizeContent, javax.xml.namespace.QName methodQName )
          throws org.apache.axis2.AxisFault
  {
    org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();

    if ( param != null )
    {
      envelope.getBody().addChild( toOM( param, optimizeContent ) );
    }

    return envelope;
  }

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope (
          org.apache.axiom.soap.SOAPFactory factory,
          se.umu.cs.edu.soa.hws.stubs.types.ListOfStringDocument param,
          boolean optimizeContent, javax.xml.namespace.QName methodQName )
          throws org.apache.axis2.AxisFault
  {
    org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();

    if ( param != null )
    {
      envelope.getBody().addChild( toOM( param, optimizeContent ) );
    }

    return envelope;
  }

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope (
          org.apache.axiom.soap.SOAPFactory factory,
          se.umu.cs.edu.soa.hws.stubs.types.MapDocument param,
          boolean optimizeContent, javax.xml.namespace.QName methodQName )
          throws org.apache.axis2.AxisFault
  {
    org.apache.axiom.soap.SOAPEnvelope envelope = factory.getDefaultEnvelope();

    if ( param != null )
    {
      envelope.getBody().addChild( toOM( param, optimizeContent ) );
    }

    return envelope;
  }

  /**
   * get the default envelope
   */
  private org.apache.axiom.soap.SOAPEnvelope toEnvelope (
          org.apache.axiom.soap.SOAPFactory factory )
  {
    return factory.getDefaultEnvelope();
  }

  public org.apache.xmlbeans.XmlObject fromOM (
          org.apache.axiom.om.OMElement param, java.lang.Class type,
          java.util.Map extraNamespaces ) throws org.apache.axis2.AxisFault
  {
    try
    {
      if ( se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument.class.equals(
              type ) )
      {
        if ( extraNamespaces != null )
        {
          return se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument.Factory.parse( param.getXMLStreamReaderWithoutCaching(),
                  new org.apache.xmlbeans.XmlOptions().setLoadAdditionalNamespaces(
                          extraNamespaces ) );
        }
        else
        {
          return se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument.Factory.parse( param.getXMLStreamReaderWithoutCaching() );
        }
      }

      if ( se.umu.cs.edu.soa.hws.stubs.types.MessageObjectDocument.class.equals(
              type ) )
      {
        if ( extraNamespaces != null )
        {
          return se.umu.cs.edu.soa.hws.stubs.types.MessageObjectDocument.Factory.parse( param.getXMLStreamReaderWithoutCaching(),
                  new org.apache.xmlbeans.XmlOptions().setLoadAdditionalNamespaces(
                          extraNamespaces ) );
        }
        else
        {
          return se.umu.cs.edu.soa.hws.stubs.types.MessageObjectDocument.Factory.parse( param.getXMLStreamReaderWithoutCaching() );
        }
      }

      if ( se.umu.cs.edu.soa.hws.stubs.types.MessageObjectDocument.class.equals(
              type ) )
      {
        if ( extraNamespaces != null )
        {
          return se.umu.cs.edu.soa.hws.stubs.types.MessageObjectDocument.Factory.parse( param.getXMLStreamReaderWithoutCaching(),
                  new org.apache.xmlbeans.XmlOptions().setLoadAdditionalNamespaces(
                          extraNamespaces ) );
        }
        else
        {
          return se.umu.cs.edu.soa.hws.stubs.types.MessageObjectDocument.Factory.parse( param.getXMLStreamReaderWithoutCaching() );
        }
      }

      if ( se.umu.cs.edu.soa.hws.stubs.types.ListOfStringDocument.class.equals(
              type ) )
      {
        if ( extraNamespaces != null )
        {
          return se.umu.cs.edu.soa.hws.stubs.types.ListOfStringDocument.Factory.parse( param.getXMLStreamReaderWithoutCaching(),
                  new org.apache.xmlbeans.XmlOptions().setLoadAdditionalNamespaces(
                          extraNamespaces ) );
        }
        else
        {
          return se.umu.cs.edu.soa.hws.stubs.types.ListOfStringDocument.Factory.parse( param.getXMLStreamReaderWithoutCaching() );
        }
      }

      if ( se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument.class.equals(
              type ) )
      {
        if ( extraNamespaces != null )
        {
          return se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument.Factory.parse( param.getXMLStreamReaderWithoutCaching(),
                  new org.apache.xmlbeans.XmlOptions().setLoadAdditionalNamespaces(
                          extraNamespaces ) );
        }
        else
        {
          return se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument.Factory.parse( param.getXMLStreamReaderWithoutCaching() );
        }
      }

      if ( se.umu.cs.edu.soa.hws.stubs.types.MapDocument.class.equals( type ) )
      {
        if ( extraNamespaces != null )
        {
          return se.umu.cs.edu.soa.hws.stubs.types.MapDocument.Factory.parse( param.getXMLStreamReaderWithoutCaching(),
                  new org.apache.xmlbeans.XmlOptions().setLoadAdditionalNamespaces(
                          extraNamespaces ) );
        }
        else
        {
          return se.umu.cs.edu.soa.hws.stubs.types.MapDocument.Factory.parse( param.getXMLStreamReaderWithoutCaching() );
        }
      }

      if ( se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument.class.equals(
              type ) )
      {
        if ( extraNamespaces != null )
        {
          return se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument.Factory.parse( param.getXMLStreamReaderWithoutCaching(),
                  new org.apache.xmlbeans.XmlOptions().setLoadAdditionalNamespaces(
                          extraNamespaces ) );
        }
        else
        {
          return se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument.Factory.parse( param.getXMLStreamReaderWithoutCaching() );
        }
      }

      if ( se.umu.cs.edu.soa.hws.stubs.types.ListOfStringDocument.class.equals(
              type ) )
      {
        if ( extraNamespaces != null )
        {
          return se.umu.cs.edu.soa.hws.stubs.types.ListOfStringDocument.Factory.parse( param.getXMLStreamReaderWithoutCaching(),
                  new org.apache.xmlbeans.XmlOptions().setLoadAdditionalNamespaces(
                          extraNamespaces ) );
        }
        else
        {
          return se.umu.cs.edu.soa.hws.stubs.types.ListOfStringDocument.Factory.parse( param.getXMLStreamReaderWithoutCaching() );
        }
      }
    }
    catch ( java.lang.Exception e )
    {
      throw org.apache.axis2.AxisFault.makeFault( e );
    }

    return null;
  }

  /**
   * A utility method that copies the namepaces from the SOAPEnvelope
   */
  private java.util.Map getEnvelopeNamespaces (
          org.apache.axiom.soap.SOAPEnvelope env )
  {
    java.util.Map returnMap = new java.util.HashMap();
    java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();

    while ( namespaceIterator.hasNext() )
    {
      org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
      returnMap.put( ns.getPrefix(), ns.getNamespaceURI() );
    }

    return returnMap;
  }

  private org.apache.axis2.AxisFault createAxisFault ( java.lang.Exception e )
  {
    org.apache.axis2.AxisFault f;
    Throwable cause = e.getCause();

    if ( cause != null )
    {
      f = new org.apache.axis2.AxisFault( e.getMessage(), cause );
    }
    else
    {
      f = new org.apache.axis2.AxisFault( e.getMessage() );
    }

    return f;
  }
} //end of class
