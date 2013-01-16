/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.quickfix;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.ide.quickfix.CallsReadOnlyType;
import org.eclipse.xtend.ide.quickfix.IsUndefinedMethod;
import org.eclipse.xtend.ide.quickfix.NewMethodModificationProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage.Literals;

/**
 * @author Sebastian Benz - Initial contribution and API
 */
@SuppressWarnings("all")
public class UndefinedMethodFix {
  @Inject
  private NewMethodModificationProvider _newMethodModificationProvider;
  
  @Inject
  private IsUndefinedMethod _isUndefinedMethod;
  
  @Inject
  private CallsReadOnlyType _callsReadOnlyType;
  
  public void apply(final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor, final XMemberFeatureCall featureCall) {
    final String issueString = this.textForFeature(featureCall, Literals.XABSTRACT_FEATURE_CALL__FEATURE);
    boolean _callsUndefinedMethod = this._isUndefinedMethod.callsUndefinedMethod(featureCall);
    boolean _not = (!_callsUndefinedMethod);
    if (_not) {
      return;
    }
    boolean _receiverIsReadOnly = this._callsReadOnlyType.receiverIsReadOnly(featureCall);
    if (_receiverIsReadOnly) {
      return;
    }
    String _plus = ("Create method \'" + issueString);
    String _plus_1 = (_plus + "\'");
    IModification _createModification = this._newMethodModificationProvider.createModification(featureCall, issueString);
    issueResolutionAcceptor.accept(issue, _plus_1, 
      "", 
      "fix_public_function.png", _createModification);
  }
  
  protected String textForFeature(final EObject eObject, final EStructuralFeature feature) {
    final List<INode> nodes = NodeModelUtils.findNodesForFeature(eObject, feature);
    StringBuilder _stringBuilder = new StringBuilder();
    final StringBuilder sb = _stringBuilder;
    for (final INode node : nodes) {
      String _text = node.getText();
      sb.append(_text);
    }
    String _string = sb.toString();
    return _string.trim();
  }
}
