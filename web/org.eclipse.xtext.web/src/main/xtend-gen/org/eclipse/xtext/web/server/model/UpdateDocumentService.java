/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.model;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.model.DocumentStateResult;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.web.server.model.XtextWorkerThread;

@Singleton
@SuppressWarnings("all")
public class UpdateDocumentService {
  @Inject
  private IResourceValidator resourceValidator;
  
  public DocumentStateResult updateFullText(final XtextWebDocumentAccess document, final String fullText) throws InvalidRequestException {
    final CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument> _function = new CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument>() {
      @Override
      public DocumentStateResult exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        it.setDirty(true);
        it.setProcessingCompleted(false);
        it.createNewStateId();
        String _stateId = it.getStateId();
        return new DocumentStateResult(_stateId);
      }
    };
    final CancelableUnitOfWork<Object, IXtextWebDocument> _function_1 = new CancelableUnitOfWork<Object, IXtextWebDocument>() {
      @Override
      public Object exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        it.setText(fullText);
        UpdateDocumentService.this.processUpdatedDocument(it, cancelIndicator);
        return null;
      }
    };
    XtextWorkerThread _xtextWorkerThread = new XtextWorkerThread(_function_1);
    return document.<DocumentStateResult>modify(_function, _xtextWorkerThread);
  }
  
  public DocumentStateResult updateDeltaText(final XtextWebDocumentAccess document, final String deltaText, final int offset, final int replaceLength) throws InvalidRequestException {
    final CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument> _function = new CancelableUnitOfWork<DocumentStateResult, IXtextWebDocument>() {
      @Override
      public DocumentStateResult exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        it.setDirty(true);
        it.setProcessingCompleted(false);
        it.createNewStateId();
        String _stateId = it.getStateId();
        return new DocumentStateResult(_stateId);
      }
    };
    final CancelableUnitOfWork<Object, IXtextWebDocument> _function_1 = new CancelableUnitOfWork<Object, IXtextWebDocument>() {
      @Override
      public Object exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        it.updateText(deltaText, offset, replaceLength);
        UpdateDocumentService.this.processUpdatedDocument(it, cancelIndicator);
        return null;
      }
    };
    XtextWorkerThread _xtextWorkerThread = new XtextWorkerThread(_function_1);
    return document.<DocumentStateResult>modify(_function, _xtextWorkerThread);
  }
  
  public void processUpdatedDocument(final IXtextWebDocument it, final CancelIndicator cancelIndicator) {
    boolean _isProcessingCompleted = it.isProcessingCompleted();
    boolean _not = (!_isProcessingCompleted);
    if (_not) {
      Collection<Issue> _issues = it.getIssues();
      XtextResource _resource = it.getResource();
      List<Issue> _validate = this.resourceValidator.validate(_resource, CheckMode.ALL, cancelIndicator);
      _issues.addAll(_validate);
      it.setProcessingCompleted(true);
    }
  }
}
