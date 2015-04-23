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
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.web.server.ISessionStore;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.model.DocumentStateResult;
import org.eclipse.xtext.web.server.model.XtextWebDocument;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;
import org.eclipse.xtext.web.server.persistence.ResourceContentResult;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Pair;

@Singleton
@SuppressWarnings("all")
public class ResourcePersistenceService {
  public ResourceContentResult load(final String resourceId, final IServerResourceHandler resourceHandler, final ISessionStore sessionStore) throws InvalidRequestException {
    ResourceContentResult _xblockexpression = null;
    {
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
      final XtextWebDocument document = ISessionStore.Extensions.<XtextWebDocument>get(sessionStore, _mappedTo, _function);
      final IUnitOfWork<ResourceContentResult, XtextWebDocument.ReadAccess> _function_1 = new IUnitOfWork<ResourceContentResult, XtextWebDocument.ReadAccess>() {
        @Override
        public ResourceContentResult exec(final XtextWebDocument.ReadAccess access) throws Exception {
          String _text = access.getText();
          final ResourceContentResult result = new ResourceContentResult(_text);
          boolean _isDirty = access.isDirty();
          result.setDirty(_isDirty);
          String _stateId = access.getStateId();
          result.setStateId(_stateId);
          return result;
        }
      };
      _xblockexpression = document.<ResourceContentResult>readOnly(_function_1);
    }
    return _xblockexpression;
  }
  
  public ResourceContentResult revert(final String resourceId, final String newStateId, final IServerResourceHandler resourceHandler, final ISessionStore sessionStore) throws InvalidRequestException {
    ResourceContentResult _xtrycatchfinallyexpression = null;
    try {
      ResourceContentResult _xblockexpression = null;
      {
        final XtextWebDocument document = resourceHandler.get(resourceId);
        final IUnitOfWork<ResourceContentResult, XtextWebDocument.ModifyAccess> _function = new IUnitOfWork<ResourceContentResult, XtextWebDocument.ModifyAccess>() {
          @Override
          public ResourceContentResult exec(final XtextWebDocument.ModifyAccess access) throws Exception {
            Pair<Class<XtextWebDocument>, String> _mappedTo = Pair.<Class<XtextWebDocument>, String>of(XtextWebDocument.class, resourceId);
            sessionStore.put(_mappedTo, document);
            access.setStateId(newStateId);
            access.setDirty(false);
            String _text = access.getText();
            final ResourceContentResult result = new ResourceContentResult(_text);
            result.setStateId(newStateId);
            return result;
          }
        };
        _xblockexpression = document.<ResourceContentResult>modify(_function);
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException ioe = (IOException)_t;
        throw new InvalidRequestException(InvalidRequestException.Type.RESOURCE_NOT_FOUND, "The requested resource was not found.");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  public DocumentStateResult save(final XtextWebDocument document, final IServerResourceHandler resourceHandler, final String requiredStateId) throws InvalidRequestException {
    final IUnitOfWork<DocumentStateResult, XtextWebDocument.ModifyAccess> _function = new IUnitOfWork<DocumentStateResult, XtextWebDocument.ModifyAccess>() {
      @Override
      public DocumentStateResult exec(final XtextWebDocument.ModifyAccess access) throws Exception {
        access.checkStateId(requiredStateId);
        try {
          resourceHandler.put(access);
          access.setDirty(false);
        } catch (final Throwable _t) {
          if (_t instanceof IOException) {
            final IOException ioe = (IOException)_t;
            String _message = ioe.getMessage();
            throw new InvalidRequestException(InvalidRequestException.Type.RESOURCE_NOT_FOUND, _message);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        String _stateId = access.getStateId();
        return new DocumentStateResult(_stateId);
      }
    };
    return document.<DocumentStateResult>modify(_function);
  }
}
