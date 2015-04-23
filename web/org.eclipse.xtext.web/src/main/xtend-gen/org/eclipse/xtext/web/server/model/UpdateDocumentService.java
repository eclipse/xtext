/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.model;

import com.google.inject.Singleton;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.model.DocumentStateResult;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;

@Singleton
@SuppressWarnings("all")
public class UpdateDocumentService {
  public DocumentStateResult updateFullText(final XtextWebDocumentAccess document, final String fullText) throws InvalidRequestException {
    final CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument> _function = new CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument>() {
      @Override
      public DocumentStateResult exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        it.setText(fullText);
        UpdateDocumentService.this.postParse(it, cancelIndicator);
        String _stateId = it.getStateId();
        return new DocumentStateResult(_stateId);
      }
    };
    return document.<DocumentStateResult>modify(_function);
  }
  
  public DocumentStateResult updateDeltaText(final XtextWebDocumentAccess document, final String deltaText, final int offset, final int replaceLength) throws InvalidRequestException {
    final CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument> _function = new CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument>() {
      @Override
      public DocumentStateResult exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        it.updateText(deltaText, offset, replaceLength);
        UpdateDocumentService.this.postParse(it, cancelIndicator);
        String _stateId = it.getStateId();
        return new DocumentStateResult(_stateId);
      }
    };
    return document.<DocumentStateResult>modify(_function);
  }
  
  protected void postParse(final IXtextWebDocument document, final CancelIndicator cancelIndicator) {
    XtextResource _resource = document.getResource();
    EcoreUtil2.resolveLazyCrossReferences(_resource, cancelIndicator);
  }
}
