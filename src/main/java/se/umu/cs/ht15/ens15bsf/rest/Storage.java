package se.umu.cs.ht15.ens15bsf.rest;

import se.umu.cs._5dv153.interfaces.Message;
import se.umu.cs._5dv153.interfaces.MessageAccessor;

import java.util.*;

/**
 * Created by ens15bsf on 2015-11-09.
 */
public class Storage implements MessageAccessor
{
  private HashMap<String, Message> messages;
  private HashSet<String> topics;

  public Storage ()
  {
    messages = new HashMap<>();
    topics = new HashSet<>();
  }

  /**
   * Lists all topics present in the stored messages.
   *
   * @return List of unique topics
   */
  @Override
  public List<String> listTopics ()
  {
    return new LinkedList<>( topics );
  }

  /**
   * Stores the message on the server.
   *
   * @param message Message to be stored
   */
  @Override
  public void postMessage ( Message message )
  {
    messages.put( message.getId(), message );
  }

  /**
   * Lists identifiers of all messages stored on the server on specified
   * topic.
   *
   * @param topic Topic of the messages
   * @return List of messages' identifiers
   */
  @Override
  public List<String> listMessages ( String topic )
  {
    LinkedList<String> identifiers = new LinkedList<>();
    for( Message msg : messages.values())
    {
      if ( msg.getTopic().equals( topic ) )
        identifiers.add( msg.getId() );
    }
    return identifiers;
  }

  /**
   * Lists identifiers and timestamps of all messages stored on the server on
   * specified topic.
   *
   * @param topic Topic of the messages
   * @return Map of messages' identifiers and timestamps, null if there are no
   */
  @Override
  public Map<String, Long> listMessagesWithTimestamps ( String topic )
  {
    HashMap<String, Long> identifiers = new HashMap<>();
    for( Message msg : messages.values())
    {
      if ( msg.getTopic().equals( topic ) )
        identifiers.put( msg.getId(), msg.getTimestamp() );
    }
    return identifiers;
  }

  /**
   * Retrieves a message with specified identifier.
   *
   * @param id Message identifier
   * @return Message
   */
  @Override
  public Message retrieveMessage ( String id )
  {
    return messages.get( id );
  }
}
