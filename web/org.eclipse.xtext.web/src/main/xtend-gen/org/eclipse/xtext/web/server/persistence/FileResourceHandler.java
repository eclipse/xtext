/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.persistence;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.web.server.model.XtextDocument;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class FileResourceHandler implements IServerResourceHandler {
  @Inject
  private IResourceBaseProvider resourceBaseProvider;
  
  @Override
  public XtextDocument get(final String resourceId, final XtextResourceSet resourceSet) throws IOException {
    try {
      try {
        final URI uri = this.resourceBaseProvider.getFileURI(resourceId);
        Resource _resource = resourceSet.getResource(uri, true);
        final XtextResource resource = ((XtextResource) _resource);
        return new XtextDocument(resource, resourceId);
      } catch (final Throwable _t) {
        if (_t instanceof WrappedException) {
          final WrappedException exception = (WrappedException)_t;
          throw exception.getCause();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void put(final XtextDocument.ReadAccess documentAccess, final IEncodingProvider encodingProvider) throws IOException {
    try {
      try {
        XtextDocument _document = documentAccess.getDocument();
        String _resourceId = _document.getResourceId();
        final URI uri = this.resourceBaseProvider.getFileURI(_resourceId);
        XtextResource _resource = documentAccess.getResource();
        ResourceSet _resourceSet = _resource.getResourceSet();
        URIConverter _uRIConverter = _resourceSet.getURIConverter();
        final OutputStream outputStream = _uRIConverter.createOutputStream(uri);
        String _encoding = encodingProvider.getEncoding(uri);
        final OutputStreamWriter writer = new OutputStreamWriter(outputStream, _encoding);
        String _text = documentAccess.getText();
        writer.write(_text);
        writer.close();
      } catch (final Throwable _t) {
        if (_t instanceof WrappedException) {
          final WrappedException exception = (WrappedException)_t;
          throw exception.getCause();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
