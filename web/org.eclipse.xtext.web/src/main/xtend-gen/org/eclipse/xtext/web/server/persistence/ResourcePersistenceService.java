/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.persistence;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.io.IOException;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.IServiceContext;
import org.eclipse.xtext.web.server.ISession;
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

/**
 * Service class for loading, saving, and reverting documents. The actual work is done by
 * an implementation of {@link IServerResourceHandler}, so if you want to use this service
 * you must provide such an implementation in the Guice bindings.
 */
@Singleton
@SuppressWarnings("all")
public class ResourcePersistenceService {
  @Inject
  private XtextWebDocumentAccess.Factory documentAccessFactory;
  
  /**
   * Load the content of a document.
   */
  public ResourceContentResult load(final String resourceId, final IServerResourceHandler resourceHandler, final IServiceContext serviceContext) throws InvalidRequestException {
    ResourceContentResult _xblockexpression = null;
    {
      ISession _session = serviceContext.getSession();
      Pair<Class<XtextWebDocument>, String> _mappedTo = Pair.<Class<XtextWebDocument>, String>of(XtextWebDocument.class, resourceId);
      final Function0<XtextWebDocument> _function = new Function0<XtextWebDocument>() {
        @Override
        public XtextWebDocument apply() {
          XtextWebDocument _xtrycatchfinallyexpression = null;
          try {
            _xtrycatchfinallyexpression = resourceHandler.get(resourceId, serviceContext);
          } catch (final Throwable _t) {
            if (_t instanceof IOException) {
              final IOException ioe = (IOException)_t;
              throw new InvalidRequestException.ResourceNotFoundException("The requested resource was not found.", ioe);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          return _xtrycatchfinallyexpression;
        }
      };
      final XtextWebDocument document = _session.<XtextWebDocument>get(_mappedTo, _function);
      XtextWebDocumentAccess _create = this.documentAccessFactory.create(document, false);
      final CancelableUnitOfWork<ResourceContentResult, IXtextWebDocument> _function_1 = new CancelableUnitOfWork<ResourceContentResult, IXtextWebDocument>() {
        @Override
        public ResourceContentResult exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
          String _text = it.getText();
          String _stateId = it.getStateId();
          boolean _isDirty = it.isDirty();
          return new ResourceContentResult(_text, _stateId, _isDirty);
        }
      };
      _xblockexpression = _create.<ResourceContentResult>readOnly(_function_1);
    }
    return _xblockexpression;
  }
  
  /**
   * Revert the content of a document to the last saved state.
   */
  public ResourceContentResult revert(final String resourceId, final IServerResourceHandler resourceHandler, final IServiceContext serviceContext) throws InvalidRequestException {
    try {
      final XtextWebDocument document = resourceHandler.get(resourceId, serviceContext);
      ISession _session = serviceContext.getSession();
      Pair<Class<XtextWebDocument>, String> _mappedTo = Pair.<Class<XtextWebDocument>, String>of(XtextWebDocument.class, resourceId);
      _session.put(_mappedTo, document);
      String _text = document.getText();
      String _stateId = document.getStateId();
      return new ResourceContentResult(_text, _stateId, false);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException ioe = (IOException)_t;
        throw new InvalidRequestException.ResourceNotFoundException("The requested resource was not found.", ioe);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * Save the content of a document.
   */
  public DocumentStateResult save(final XtextWebDocumentAccess document, final IServerResourceHandler resourceHandler, final IServiceContext serviceContext) throws InvalidRequestException {
    final CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument> _function = new CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument>() {
      @Override
      public DocumentStateResult exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        try {
          resourceHandler.put(it, serviceContext);
          it.setDirty(false);
        } catch (final Throwable _t) {
          if (_t instanceof IOException) {
            final IOException ioe = (IOException)_t;
            String _message = ioe.getMessage();
            throw new InvalidRequestException.ResourceNotFoundException(_message, ioe);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        String _stateId = it.getStateId();
        return new DocumentStateResult(_stateId);
      }
    };
    return document.<DocumentStateResult>readOnly(_function);
  }
}
