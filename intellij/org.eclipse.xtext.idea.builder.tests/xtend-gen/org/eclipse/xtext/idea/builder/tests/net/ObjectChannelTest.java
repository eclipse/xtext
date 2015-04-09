/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.builder.tests.net;

import java.io.Serializable;
import java.nio.channels.Pipe;
import java.util.List;
import org.eclipse.xtext.idea.build.net.ObjectChannel;
import org.eclipse.xtext.idea.build.net.Protocol;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.jetbrains.jps.incremental.messages.BuildMessage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public class ObjectChannelTest {
  private ObjectChannel alice;
  
  private ObjectChannel bob;
  
  @Before
  public void setUp() {
    try {
      final Pipe alice2Bob = Pipe.open();
      final Pipe bob2Alice = Pipe.open();
      Pipe.SourceChannel _source = bob2Alice.source();
      Pipe.SinkChannel _sink = alice2Bob.sink();
      ObjectChannel _objectChannel = new ObjectChannel(_source, _sink);
      this.alice = _objectChannel;
      Pipe.SourceChannel _source_1 = alice2Bob.source();
      Pipe.SinkChannel _sink_1 = bob2Alice.sink();
      ObjectChannel _objectChannel_1 = new ObjectChannel(_source_1, _sink_1);
      this.bob = _objectChannel_1;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @After
  public void tearDown() {
    if (this.alice!=null) {
      this.alice.close();
    }
    if (this.bob!=null) {
      this.bob.close();
    }
  }
  
  @Test
  public void testReadWriteString() {
    this.alice.writeObject("Hi Bob");
    final Serializable messageFromAlice = this.bob.readObject();
    Assert.assertTrue((messageFromAlice instanceof String));
    Assert.assertEquals("Hi Bob", messageFromAlice);
    this.bob.writeObject("Hi Alice");
    final Serializable messageFromBob = this.alice.readObject();
    Assert.assertTrue((messageFromBob instanceof String));
    Assert.assertEquals("Hi Alice", messageFromBob);
  }
  
  @Test
  public void testReadWriteTooBig() {
    String message = "x";
    while ((message.length() < ObjectChannel.BUFFER_SIZE)) {
      message = (message + message);
    }
    final String messageWritten = message;
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        ObjectChannelTest.this.alice.writeObject(messageWritten);
      }
    };
    Thread _thread = new Thread(_function);
    _thread.start();
    final Serializable messageRead = this.bob.readObject();
    Assert.assertEquals(messageWritten, messageRead);
  }
  
  @Test
  public void testProtocol() {
    Protocol.BuildRequestMessage _buildRequestMessage = new Protocol.BuildRequestMessage();
    final Procedure1<Protocol.BuildRequestMessage> _function = new Procedure1<Protocol.BuildRequestMessage>() {
      @Override
      public void apply(final Protocol.BuildRequestMessage it) {
        List<String> _dirtyFiles = it.getDirtyFiles();
        _dirtyFiles.add("dirty.txt");
        List<String> _deletedFiles = it.getDeletedFiles();
        _deletedFiles.add("deleted.txt");
        List<String> _classpath = it.getClasspath();
        _classpath.add("foo.jar");
        List<String> _sourceRoots = it.getSourceRoots();
        _sourceRoots.add("src");
        it.setBaseDir("bar");
        it.setEncoding("UTF-8");
      }
    };
    final Protocol.BuildRequestMessage request = ObjectExtensions.<Protocol.BuildRequestMessage>operator_doubleArrow(_buildRequestMessage, _function);
    this.alice.writeObject(request);
    Serializable _readObject = this.bob.readObject();
    Assert.assertEquals(request, _readObject);
    Protocol.BuildIssueMessage _buildIssueMessage = new Protocol.BuildIssueMessage();
    final Procedure1<Protocol.BuildIssueMessage> _function_1 = new Procedure1<Protocol.BuildIssueMessage>() {
      @Override
      public void apply(final Protocol.BuildIssueMessage it) {
        it.setKind(BuildMessage.Kind.ERROR);
        it.setMessage("So ja nu nich!");
        it.setPath("foo");
        it.setStartOffset(42);
        it.setEndOffset(43);
        it.setLocationOffset(42);
        it.setLine(2);
        it.setColumn(21);
      }
    };
    final Protocol.BuildIssueMessage issue = ObjectExtensions.<Protocol.BuildIssueMessage>operator_doubleArrow(_buildIssueMessage, _function_1);
    this.bob.writeObject(issue);
    Serializable _readObject_1 = this.alice.readObject();
    Assert.assertEquals(issue, _readObject_1);
    Protocol.BuildResultMessage _buildResultMessage = new Protocol.BuildResultMessage();
    final Procedure1<Protocol.BuildResultMessage> _function_2 = new Procedure1<Protocol.BuildResultMessage>() {
      @Override
      public void apply(final Protocol.BuildResultMessage it) {
        List<String> _dirtyFiles = it.getDirtyFiles();
        _dirtyFiles.add("foo.txt");
        List<String> _deletedFiles = it.getDeletedFiles();
        _deletedFiles.add("deleted.txt");
        List<String> _outputDirs = it.getOutputDirs();
        _outputDirs.add("bin");
      }
    };
    final Protocol.BuildResultMessage result = ObjectExtensions.<Protocol.BuildResultMessage>operator_doubleArrow(_buildResultMessage, _function_2);
    this.bob.writeObject(result);
    Serializable _readObject_2 = this.alice.readObject();
    Assert.assertEquals(result, _readObject_2);
  }
}
