/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build.net;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class ObjectChannel {
  private final static int BUFFER_SIZE = 32768;
  
  private ByteBuffer inputBuffer = ByteBuffer.allocate(ObjectChannel.BUFFER_SIZE);
  
  private ByteBuffer outputBuffer = ByteBuffer.allocate(ObjectChannel.BUFFER_SIZE);
  
  private SocketChannel channel;
  
  public ObjectChannel(final SocketChannel channel) {
    try {
      this.channel = channel;
      channel.configureBlocking(true);
      this.inputBuffer.flip();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void writeObject(final Serializable o) {
    try {
      this.outputBuffer.clear();
      final ByteArrayOutputStream baos = new ByteArrayOutputStream();
      final ObjectOutputStream oos = new ObjectOutputStream(baos);
      try {
        oos.writeObject(o);
        final byte[] bytes = baos.toByteArray();
        int _length = bytes.length;
        this.outputBuffer.putInt(_length);
        int offset = 0;
        while (((bytes.length - offset) > 0)) {
          {
            int _remaining = this.outputBuffer.remaining();
            int _length_1 = bytes.length;
            int _minus = (_length_1 - offset);
            int numBytes = Math.min(_remaining, _minus);
            this.outputBuffer.put(bytes, offset, numBytes);
            this.outputBuffer.flip();
            this.channel.write(this.outputBuffer);
            this.outputBuffer.clear();
            int _offset = offset;
            offset = (_offset + numBytes);
          }
        }
      } finally {
        oos.close();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Serializable readObject() {
    try {
      byte[] _readByteArray = this.readByteArray(4);
      ByteBuffer _wrap = ByteBuffer.wrap(_readByteArray);
      final int length = _wrap.getInt(0);
      byte[] _readByteArray_1 = this.readByteArray(length);
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_readByteArray_1);
      final ObjectInputStream ois = new ObjectInputStream(_byteArrayInputStream);
      try {
        Object _readObject = ois.readObject();
        return ((Serializable) _readObject);
      } finally {
        ois.close();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected byte[] readByteArray(final int numBytes) {
    try {
      byte[] _xblockexpression = null;
      {
        final byte[] result = new byte[numBytes];
        int offset = 0;
        while ((offset < numBytes)) {
          int _remaining = this.inputBuffer.remaining();
          boolean _greaterThan = (_remaining > 0);
          if (_greaterThan) {
            int _remaining_1 = this.inputBuffer.remaining();
            final int availableBytes = Math.min((numBytes - offset), _remaining_1);
            this.inputBuffer.get(result, offset, availableBytes);
            int _offset = offset;
            offset = (_offset + availableBytes);
          } else {
            this.inputBuffer.clear();
            this.channel.read(this.inputBuffer);
            this.inputBuffer.flip();
          }
        }
        _xblockexpression = result;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
