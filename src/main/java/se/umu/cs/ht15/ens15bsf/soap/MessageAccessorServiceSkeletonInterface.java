/**
 * MessageAccessorServiceSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package se.umu.cs.ht15.ens15bsf.soap;

/**
 * MessageAccessorServiceSkeletonInterface java skeleton interface for the axisService
 */
public interface MessageAccessorServiceSkeletonInterface
{
  /**
   * Auto generated method signature
   *
   * @param stringInput
   */
  public se.umu.cs.edu.soa.hws.stubs.types.MessageObjectDocument retrieveMessage (
          se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument stringInput );

  /**
   * Auto generated method signature
   *
   * @param messageObject0
   */
  public void postMessage (
          se.umu.cs.edu.soa.hws.stubs.types.MessageObjectDocument messageObject0 );

  /**
   * Auto generated method signature
   */
  public se.umu.cs.edu.soa.hws.stubs.types.ListOfStringDocument listTopics ();

  /**
   * Auto generated method signature
   *
   * @param stringInput3
   */
  public se.umu.cs.edu.soa.hws.stubs.types.MapDocument listMessagesWithTimestamps (
          se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument stringInput3 );

  /**
   * Auto generated method signature
   *
   * @param stringInput4
   */
  public se.umu.cs.edu.soa.hws.stubs.types.ListOfStringDocument listMessages (
          se.umu.cs.edu.soa.hws.stubs.types.StringInputDocument stringInput4 );
}
