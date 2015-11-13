package se.umu.cs.ht15.ens15bsf.rest;

import se.umu.cs._5dv153.interfaces.Message;

import javax.json.*;
import java.io.StringReader;
import java.util.Collection;
import java.util.Map;


/**
 * Created by ens15bsf on 2015-11-10.
 * Class to get Json processing easier
 */
public class JsonAgent
{

  private static final String ID = "id";
  private static final String TIMESTAMP = "timestamp";
  private static final String SENDER = "sender";
  private static final String TOPIC = "topic";
  private static final String CONTENT = "content";
  private static final String ATTACHMENTS = "attachments";

  /**
   * Transfort a collection of strings into a Json array
   *
   * @param collection list to "jsonify"
   * @return Json array containing to given collection
   */
  public static JsonArray toJson ( Collection<String> collection )
  {
    JsonArrayBuilder jsonArray = Json.createArrayBuilder();
    for ( String str : collection )
      jsonArray.add( str );
    return jsonArray.build();
  }

  /**
   * Tranfort an array of bytes to a json array
   *
   * @param array array of bytes
   * @return Json array with the byte
   */
  public static JsonArray toJson ( Byte[] array )
  {
    JsonArrayBuilder jsonArray = Json.createArrayBuilder();
    for ( Byte str : array )
      jsonArray.add( str );
    return jsonArray.build();
  }

  /**
   * Tranfort a map to a json collection
   *
   * @param map map to "jsonify"
   * @return json collection build regarding the map
   */
  public static JsonObject toJson ( Map<String, Long> map )
  {
    JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
    for ( String k : map.keySet() )
      jsonObjectBuilder.add( k, map.get( k ) );
    return jsonObjectBuilder.build();
  }

  /**
   * Tranform a message to a json object
   *
   * @param msg Message to "jsonify"
   * @return json object build from the message
   */
  public static JsonObject toJson ( Message msg )
  {
    JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
    objectBuilder.add( ID, msg.getId() );
    objectBuilder.add( SENDER, msg.getSender() );
    objectBuilder.add( TOPIC, msg.getTopic() );
    objectBuilder.add( TIMESTAMP, msg.getTimestamp() );
    objectBuilder.add( CONTENT, msg.getContent() );
    //objectBuilder.add( ATTACHMENTS, toJson( msg.getAttachments() ) );
    return objectBuilder.build();
  }

  /**
   * Parse a json message collection to create a Message
   *
   * @param arg json collection
   * @return Message
   */
  public static Message readMessage ( String arg )
  {
    JsonReader jsonReader = Json.createReader( new StringReader( arg ) );
    JsonObject msgValues = jsonReader.readObject();
    jsonReader.close();
    return
            new Message(
                    msgValues.getString( ID ),
                    msgValues.getString( SENDER ),
                    msgValues.getString( TOPIC ),
                    msgValues.getJsonNumber( TIMESTAMP ).longValue(),
                    msgValues.getString( CONTENT )
            );
  }
}

