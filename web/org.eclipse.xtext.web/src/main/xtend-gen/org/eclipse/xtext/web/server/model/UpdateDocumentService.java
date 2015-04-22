/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.model;

import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.data.UpdateDocumentResult;
import org.eclipse.xtext.web.server.model.XtextDocument;

@SuppressWarnings("all")
public class UpdateDocumentService {
  public UpdateDocumentResult updateFullText(final XtextDocument document, final String fullText, final String requiredStateId, final String newStateId) throws InvalidRequestException {
    final IUnitOfWork<UpdateDocumentResult, XtextDocument.ModifyAccess> _function = new IUnitOfWork<UpdateDocumentResult, XtextDocument.ModifyAccess>() {
      @Override
      public UpdateDocumentResult exec(final XtextDocument.ModifyAccess access) throws Exception {
        access.checkStateId(requiredStateId);
        access.setText(fullText);
        if ((newStateId != null)) {
          access.setStateId(newStateId);
        }
        final UpdateDocumentResult result = new UpdateDocumentResult();
        String _stateId = access.getStateId();
        result.setStateId(_stateId);
        return result;
      }
    };
    return document.<UpdateDocumentResult>modify(_function);
  }
  
  public UpdateDocumentResult updateDeltaText(final XtextDocument document, final String deltaText, final int offset, final int replaceLength, final String requiredStateId, final String newStateId) throws InvalidRequestException {
    final IUnitOfWork<UpdateDocumentResult, XtextDocument.ModifyAccess> _function = new IUnitOfWork<UpdateDocumentResult, XtextDocument.ModifyAccess>() {
      @Override
      public UpdateDocumentResult exec(final XtextDocument.ModifyAccess access) throws Exception {
        access.checkStateId(requiredStateId);
        UpdateDocumentService.this.applyDelta(access, deltaText, offset, replaceLength);
        if ((newStateId != null)) {
          access.setStateId(newStateId);
        }
        final UpdateDocumentResult result = new UpdateDocumentResult();
        String _stateId = access.getStateId();
        result.setStateId(_stateId);
        return result;
      }
    };
    return document.<UpdateDocumentResult>modify(_function);
  }
  
  protected String applyDelta(final XtextDocument.ModifyAccess access, final String deltaText, final int deltaOffset, final int deltaReplaceLength) {
    String _xblockexpression = null;
    {
      final String currentText = access.getText();
      String newText = null;
      boolean _and = false;
      if (!(deltaOffset == 0)) {
        _and = false;
      } else {
        int _length = currentText.length();
        boolean _greaterEqualsThan = (deltaReplaceLength >= _length);
        _and = _greaterEqualsThan;
      }
      if (_and) {
        newText = deltaText;
      } else {
        if ((deltaOffset == 0)) {
          String _substring = currentText.substring(deltaReplaceLength);
          String _plus = (deltaText + _substring);
          newText = _plus;
        } else {
          int _length_1 = currentText.length();
          boolean _greaterEqualsThan_1 = ((deltaOffset + deltaReplaceLength) >= _length_1);
          if (_greaterEqualsThan_1) {
            String _substring_1 = currentText.substring(0, deltaOffset);
            String _plus_1 = (_substring_1 + deltaText);
            newText = _plus_1;
          } else {
            String _substring_2 = currentText.substring(0, deltaOffset);
            String _plus_2 = (_substring_2 + deltaText);
            String _substring_3 = currentText.substring((deltaOffset + deltaReplaceLength));
            String _plus_3 = (_plus_2 + _substring_3);
            newText = _plus_3;
          }
        }
      }
      _xblockexpression = access.setText(newText);
    }
    return _xblockexpression;
  }
}
