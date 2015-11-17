package se.umu.cs.ht15.ens15bsf.soap;

import se.umu.cs._5dv153.interfaces.Message;
import se.umu.cs.ht15.ens15bsf.Storage;
import se.umu.cs.ht15.ens15bsf.soap.types.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ens15bsf on 2015-11-13.
 */
public class MessageAccessorServiceSkeletonImplementation extends MessageAccessorServiceSkeleton implements MessageAccessorServiceSkeletonInterface
{
  /**
   * Auto generated method signature
   *
   * @param messageID
   */
  @Override
  public MessageObjectDocument retrieveMessage ( StringInputDocument messageID )
  {
    Message msg = Storage.getInstance().retrieveMessage( messageID.getStringInput() );
    MessageObjectDocument response = MessageObjectDocument.Factory.newInstance();
    MessageObjectDocument.MessageObject msgDoc = MessageObjectDocument.MessageObject.Factory.newInstance();
    msgDoc.setMessageID( msg.getId() );
    msgDoc.setMessageSender( msg.getSender() );
    msgDoc.setMessageContent( msg.getContent() );
    msgDoc.setMessageContent( msg.getContent() );
    msgDoc.setMessageTimestamp( msg.getTimestamp() );
    msgDoc.setMessageTopic( msg.getTopic() );
    Byte[] attachmentsByte = msg.getAttachments();
    byte[] attachments = new byte[ attachmentsByte.length ];
    for ( int i = 0 ; i < attachmentsByte.length ; i++ )
      attachments[i] = attachmentsByte[i];
    msgDoc.setMessageAttachements( attachments );
    response.setMessageObject( msgDoc );
    return response;
  }

  /**
   * Auto generated method signature
   */
  @Override
  public ListOfStringDocument listTopics ()
  {
    ListOfStringDocument response = ListOfStringDocument.Factory.newInstance();
    List<String> topics = Storage.getInstance().listTopics();
    for ( String topic : topics )
      response.getListOfString().add( topic );
    //System.out.println(response.toString());
    return response;
  }

  /**
   * Auto generated method signature
   *
   * @param topicName
   */
  @Override
  public MapDocument listMessagesWithTimestamps ( StringInputDocument topicName )
  {
    MapDocument mapResponse = MapDocument.Factory.newInstance();
    HashMap<String, Long> idsTimed = Storage.getInstance().listMessagesWithTimestamps( topicName.getStringInput() );
    String[] keys = (String[])idsTimed.keySet().toArray();
    Long[] values = (Long[])idsTimed.values().toArray();
    for ( int i = 0 ; i < idsTimed.keySet().size() ; i++ )
    {
      MapItem itemI = MapItem.Factory.newInstance();
      itemI.setKey( keys[i] );
      itemI.setValue( values[i] );
      /// DEBUG MESSAGES
      System.out.println(keys[i] + " : " + values[i]);
      System.out.println(keys[i] + " : " + idsTimed.get( keys[i] ));
      mapResponse.getMap().setItemArray( i,  itemI );
    }
    return mapResponse;
}

  /**
   * Auto generated method signature
   */
  @Override
  public void postMessage ( MessageObjectDocument message )
  {
    MessageObjectDocument.MessageObject msgObject = message.getMessageObject();
    byte[] attchb = msgObject.getMessageAttachements();
    Byte[] attchByte = new Byte[attchb.length];
    for ( int i = 0 ; i < attchByte.length ; i++ )
      attchByte[i] = attchb[i];
    //	public Message(String id, String sender, String topic, Long timestamp, String content) {
    Message newMessage = new Message(
            msgObject.getMessageID(),
            msgObject.getMessageSender(),
            msgObject.getMessageTopic(),
            msgObject.getMessageTimestamp(),
            msgObject.getMessageContent(),
            attchByte
    );
    Storage.getInstance().postMessage( newMessage );
  }

  /**
   * Auto generated method signature
   *
   * @param topicName
   */
  @Override
  public ListOfStringDocument listMessages ( StringInputDocument topicName )
  {
    ListOfStringDocument response = ListOfStringDocument.Factory.newInstance();
    List<String> listMsg = Storage.getInstance().listMessages( topicName.getStringInput() );
    for ( String id : listMsg )
      response.getListOfString().add( id );
    return response;
  }
}
