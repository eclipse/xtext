/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.persistence;

import com.google.inject.Singleton;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.ISessionStore;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.model.DocumentStateResult;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;
import org.eclipse.xtext.web.server.persistence.ResourceContentResult;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Pair;

@Singleton
@SuppressWarnings("all")
public class ResourcePersistenceService {
  private final Logger LOG = Logger.getLogger(this.getClass());
  
  public ResourceContentResult load(final String resourceId, final IServerResourceHandler resourceHandler, final ISessionStore sessionStore) throws InvalidRequestException {
    ResourceContentResult _xblockexpression = null;
    {
      this.LOG.trace("Xtext Service: load");
      Pair<Class<XtextWebDocument>, String> _mappedTo = Pair.<Class<XtextWebDocument>, String>of(XtextWebDocument.class, resourceId);
      final Function0<XtextWebDocument> _function = new Function0<XtextWebDocument>() {
        @Override
        public XtextWebDocument apply() {
          try {
            XtextWebDocument _xtrycatchfinallyexpression = null;
            try {
              _xtrycatchfinallyexpression = resourceHandler.get(resourceId);
            } catch (final Throwable _t) {
              if (_t instanceof IOException) {
                final IOException ioe = (IOException)_t;
                throw new InvalidRequestException(InvalidRequestException.Type.RESOURCE_NOT_FOUND, "The requested resource was not found.");
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
            return _xtrycatchfinallyexpression;
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      final XtextWebDocument document = sessionStore.<XtextWebDocument>get(_mappedTo, _function);
      XtextWebDocumentAccess _xtextWebDocumentAccess = new XtextWebDocumentAccess(document);
      final CancelableUnitOfWork<ResourceContentResult, IXtextWebDocument> _function_1 = new CancelableUnitOfWork<ResourceContentResult, IXtextWebDocument>() {
        @Override
        public ResourceContentResult exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
          String _text = it.getText();
          final ResourceContentResult result = new ResourceContentResult(_text);
          boolean _isDirty = it.isDirty();
          result.setDirty(_isDirty);
          String _stateId = it.getStateId();
          result.setStateId(_stateId);
          return result;
        }
      };
      _xblockexpression = _xtextWebDocumentAccess.<ResourceContentResult>readOnly(_function_1);
    }
    return _xblockexpression;
  }
  
  public ResourceContentResult revert(final String resourceId, final IServerResourceHandler resourceHandler, final ISessionStore sessionStore) throws InvalidRequestException {
    this.LOG.trace("Xtext Service: revert");
    try {
      final XtextWebDocument document = resourceHandler.get(resourceId);
      String _text = document.getText();
      final ResourceContentResult result = new ResourceContentResult(_text);
      String _stateId = document.getStateId();
      result.setStateId(_stateId);
      Pair<Class<XtextWebDocument>, String> _mappedTo = Pair.<Class<XtextWebDocument>, String>of(XtextWebDocument.class, resourceId);
      sessionStore.put(_mappedTo, document);
      return result;
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException ioe = (IOException)_t;
        throw new InvalidRequestException(InvalidRequestException.Type.RESOURCE_NOT_FOUND, "The requested resource was not found.");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public DocumentStateResult save(final XtextWebDocumentAccess document, final IServerResourceHandler resourceHandler) throws InvalidRequestException {
    DocumentStateResult _xblockexpression = null;
    {
      this.LOG.trace("Xtext Service: save");
      final CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument> _function = new CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument>() {
        @Override
        public DocumentStateResult exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
          try {
            resourceHandler.put(it);
            it.setDirty(false);
          } catch (final Throwable _t) {
            if (_t instanceof IOException) {
              final IOException ioe = (IOException)_t;
              String _message = ioe.getMessage();
              throw new InvalidRequestException(InvalidRequestException.Type.RESOURCE_NOT_FOUND, _message);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          String _stateId = it.getStateId();
          return new DocumentStateResult(_stateId);
        }
      };
      _xblockexpression = document.<DocumentStateResult>readOnly(_function);
    }
    return _xblockexpression;
  }
}
