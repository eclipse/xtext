/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.model;

import com.google.inject.Singleton;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.model.DocumentStateResult;
import org.eclipse.xtext.web.server.model.XtextWebDocument;

@Singleton
@SuppressWarnings("all")
public class UpdateDocumentService {
  public DocumentStateResult updateFullText(final XtextWebDocument document, final String fullText, final String requiredStateId, final String newStateId) throws InvalidRequestException {
    final IUnitOfWork<DocumentStateResult, XtextWebDocument.ModifyAccess> _function = new IUnitOfWork<DocumentStateResult, XtextWebDocument.ModifyAccess>() {
      @Override
      public DocumentStateResult exec(final XtextWebDocument.ModifyAccess access) throws Exception {
        access.checkStateId(requiredStateId);
        access.setText(fullText);
        if ((newStateId != null)) {
          access.setStateId(newStateId);
        }
        String _stateId = access.getStateId();
        return new DocumentStateResult(_stateId);
      }
    };
    return document.<DocumentStateResult>modify(_function);
  }
  
  public DocumentStateResult updateDeltaText(final XtextWebDocument document, final String deltaText, final int offset, final int replaceLength, final String requiredStateId, final String newStateId) throws InvalidRequestException {
    final IUnitOfWork<DocumentStateResult, XtextWebDocument.ModifyAccess> _function = new IUnitOfWork<DocumentStateResult, XtextWebDocument.ModifyAccess>() {
      @Override
      public DocumentStateResult exec(final XtextWebDocument.ModifyAccess access) throws Exception {
        access.checkStateId(requiredStateId);
        access.updateText(deltaText, offset, replaceLength);
        if ((newStateId != null)) {
          access.setStateId(newStateId);
        }
        String _stateId = access.getStateId();
        return new DocumentStateResult(_stateId);
      }
    };
    return document.<DocumentStateResult>modify(_function);
  }
}
