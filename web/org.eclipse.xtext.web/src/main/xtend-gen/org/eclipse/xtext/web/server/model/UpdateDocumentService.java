/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.model;

import com.google.inject.Singleton;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.model.DocumentStateResult;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;

/**
 * Service class for document updates. This service only makes sense with a stateful server,
 * where the server-side document representation is updated after each modification. This
 * can greatly improve response times compared to the stateless alternative, where the full
 * text content is sent with each service request.
 */
@Singleton
@SuppressWarnings("all")
public class UpdateDocumentService {
  /**
   * Update the state identifier and return it. A background process is started where the given text
   * is assigned to the document and the services registered in {@link PrecomputedServiceRegistry}
   * are invoked.
   */
  public DocumentStateResult updateFullText(final XtextWebDocumentAccess document, final String fullText) throws InvalidRequestException {
    final CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument> _function = new CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument>() {
      @Override
      public DocumentStateResult exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        it.setDirty(true);
        it.createNewStateId();
        String _stateId = it.getStateId();
        return new DocumentStateResult(_stateId);
      }
    };
    final CancelableUnitOfWork<Object, IXtextWebDocument> _function_1 = new CancelableUnitOfWork<Object, IXtextWebDocument>() {
      @Override
      public Object exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        it.setText(fullText);
        return null;
      }
    };
    return document.<DocumentStateResult>modify(_function, _function_1);
  }
  
  /**
   * Update the state identifier and return it. A background process is started where the given text change
   * is applied to the document and the services registered in {@link PrecomputedServiceRegistry}
   * are invoked.
   */
  public DocumentStateResult updateDeltaText(final XtextWebDocumentAccess document, final String deltaText, final int offset, final int replaceLength) throws InvalidRequestException {
    final CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument> _function = new CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument>() {
      @Override
      public DocumentStateResult exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        it.setDirty(true);
        it.createNewStateId();
        String _stateId = it.getStateId();
        return new DocumentStateResult(_stateId);
      }
    };
    final CancelableUnitOfWork<Object, IXtextWebDocument> _function_1 = new CancelableUnitOfWork<Object, IXtextWebDocument>() {
      @Override
      public Object exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        String _text = it.getText();
        int _length = _text.length();
        boolean _lessEqualsThan = (offset <= _length);
        if (_lessEqualsThan) {
          it.updateText(deltaText, offset, replaceLength);
        }
        return null;
      }
    };
    return document.<DocumentStateResult>modify(_function, _function_1);
  }
  
  /**
   * Return the current state identifier. If the services registered in {@link PrecomputedServiceRegistry}
   * are not cached yet, they are invoked in a background process.
   */
  public DocumentStateResult getStateId(final XtextWebDocumentAccess document) throws InvalidRequestException {
    final CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument> _function = new CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument>() {
      @Override
      public DocumentStateResult exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        String _stateId = it.getStateId();
        return new DocumentStateResult(_stateId);
      }
    };
    return document.<DocumentStateResult>modify(_function);
  }
}
