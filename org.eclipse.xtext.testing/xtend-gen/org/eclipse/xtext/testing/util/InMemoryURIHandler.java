/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.testing.util;

import com.google.common.base.Objects;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @since 2.9
 * 
 * @noimplement
 * @noreference
 */
@SuppressWarnings("all")
public class InMemoryURIHandler implements URIHandler {
  @Accessors
  @FinalFieldsConstructor
  public static class InMemFile {
    private final URI uri;
    
    private byte[] contents;
    
    private boolean exists;
    
    public OutputStream createOutputstream() {
      return new ByteArrayOutputStream() {
        @Override
        public void close() throws IOException {
          byte[] _byteArray = this.toByteArray();
          InMemFile.this.contents = _byteArray;
          InMemFile.this.exists = true;
        }
      };
    }
    
    public InputStream createInputStream() {
      try {
        if ((Objects.equal(this.contents, null) || (!this.exists))) {
          throw new IOException((("File " + this.uri) + " does not exist."));
        }
        return new ByteArrayInputStream(this.contents);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    public InMemFile(final URI uri) {
      super();
      this.uri = uri;
    }
    
    @Pure
    public URI getUri() {
      return this.uri;
    }
    
    @Pure
    public byte[] getContents() {
      return this.contents;
    }
    
    public void setContents(final byte[] contents) {
      this.contents = contents;
    }
    
    @Pure
    public boolean isExists() {
      return this.exists;
    }
    
    public void setExists(final boolean exists) {
      this.exists = exists;
    }
  }
  
  public final static String SCHEME = "inmemory";
  
  private Map<URI, InMemoryURIHandler.InMemFile> files = CollectionLiterals.<URI, InMemoryURIHandler.InMemFile>newHashMap();
  
  @Override
  public boolean canHandle(final URI uri) {
    String _scheme = uri.scheme();
    return Objects.equal(_scheme, InMemoryURIHandler.SCHEME);
  }
  
  @Override
  public Map<String, ?> contentDescription(final URI uri, final Map<?, ?> options) throws IOException {
    return CollectionLiterals.<String, Object>emptyMap();
  }
  
  @Override
  public InputStream createInputStream(final URI uri, final Map<?, ?> options) throws IOException {
    InMemoryURIHandler.InMemFile _inMemoryFile = this.getInMemoryFile(uri);
    return _inMemoryFile.createInputStream();
  }
  
  @Override
  public OutputStream createOutputStream(final URI uri, final Map<?, ?> options) throws IOException {
    InMemoryURIHandler.InMemFile _inMemoryFile = this.getInMemoryFile(uri);
    return _inMemoryFile.createOutputstream();
  }
  
  @Override
  public void delete(final URI uri, final Map<?, ?> options) throws IOException {
    InMemoryURIHandler.InMemFile _inMemoryFile = this.getInMemoryFile(uri);
    _inMemoryFile.exists = false;
  }
  
  @Override
  public boolean exists(final URI uri, final Map<?, ?> options) {
    InMemoryURIHandler.InMemFile _inMemoryFile = this.getInMemoryFile(uri);
    return _inMemoryFile.exists;
  }
  
  @Override
  public Map<String, ?> getAttributes(final URI uri, final Map<?, ?> options) {
    return CollectionLiterals.<String, Object>emptyMap();
  }
  
  @Override
  public void setAttributes(final URI uri, final Map<String, ?> attributes, final Map<?, ?> options) throws IOException {
  }
  
  protected InMemoryURIHandler.InMemFile getInMemoryFile(final URI uri) {
    InMemoryURIHandler.InMemFile result = this.files.get(uri);
    boolean _equals = Objects.equal(result, null);
    if (_equals) {
      InMemoryURIHandler.InMemFile _inMemFile = new InMemoryURIHandler.InMemFile(uri);
      result = _inMemFile;
      this.files.put(uri, result);
    }
    return result;
  }
}
