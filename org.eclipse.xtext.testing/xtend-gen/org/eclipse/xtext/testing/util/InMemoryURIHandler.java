/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
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
          InMemFile.this.contents = this.toByteArray();
          InMemFile.this.exists = true;
        }
      };
    }
    
    public InputStream createInputStream() {
      try {
        if (((this.contents == null) || (!this.exists))) {
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
  
  public static final String SCHEME = "inmemory";
  
  @Accessors(AccessorType.PUBLIC_GETTER)
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
    return this.getInMemoryFile(uri).createInputStream();
  }
  
  @Override
  public OutputStream createOutputStream(final URI uri, final Map<?, ?> options) throws IOException {
    return this.getInMemoryFile(uri).createOutputstream();
  }
  
  @Override
  public void delete(final URI uri, final Map<?, ?> options) throws IOException {
    InMemoryURIHandler.InMemFile _inMemoryFile = this.getInMemoryFile(uri);
    _inMemoryFile.exists = false;
  }
  
  @Override
  public boolean exists(final URI uri, final Map<?, ?> options) {
    return this.getInMemoryFile(uri).exists;
  }
  
  @Override
  public Map<String, ?> getAttributes(final URI uri, final Map<?, ?> options) {
    return CollectionLiterals.<String, Object>emptyMap();
  }
  
  @Override
  public void setAttributes(final URI uri, final Map<String, ?> attributes, final Map<?, ?> options) throws IOException {
  }
  
  public InMemoryURIHandler.InMemFile getInMemoryFile(final URI uri) {
    InMemoryURIHandler.InMemFile result = this.files.get(uri);
    if ((result == null)) {
      InMemoryURIHandler.InMemFile _inMemFile = new InMemoryURIHandler.InMemFile(uri);
      result = _inMemFile;
      this.files.put(uri, result);
    }
    return result;
  }
  
  @Pure
  public Map<URI, InMemoryURIHandler.InMemFile> getFiles() {
    return this.files;
  }
}
