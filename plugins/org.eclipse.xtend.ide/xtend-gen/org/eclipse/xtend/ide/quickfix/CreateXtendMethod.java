/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.quickfix;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.ide.quickfix.XtendMethodBuilder;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.eclipse.xtext.xbase.ui.contentassist.ReplacingAppendable;
import org.eclipse.xtext.xbase.ui.contentassist.ReplacingAppendable.Factory;

@Data
@SuppressWarnings("all")
public class CreateXtendMethod implements IModification {
  private final XtendMethodBuilder _methodBuilder;
  
  public XtendMethodBuilder getMethodBuilder() {
    return this._methodBuilder;
  }
  
  private final XtendClass _xtendClass;
  
  public XtendClass getXtendClass() {
    return this._xtendClass;
  }
  
  private final IURIEditorOpener _editorOpener;
  
  public IURIEditorOpener getEditorOpener() {
    return this._editorOpener;
  }
  
  private final Factory _appendableFactory;
  
  public Factory getAppendableFactory() {
    return this._appendableFactory;
  }
  
  public void apply(final IModificationContext context) throws Exception {
    IURIEditorOpener _editorOpener = this.getEditorOpener();
    XtendClass _xtendClass = this.getXtendClass();
    URI _uRI = EcoreUtil.getURI(_xtendClass);
    final IEditorPart editor = _editorOpener.open(_uRI, false);
    boolean _not = (!(editor instanceof XtextEditor));
    if (_not) {
      return;
    }
    final XtextEditor xtextEditor = ((XtextEditor) editor);
    final IXtextDocument document = xtextEditor.getDocument();
    XtendClass _xtendClass_1 = this.getXtendClass();
    int offset = this.getFunctionInsertOffset(_xtendClass_1);
    Factory _appendableFactory = this.getAppendableFactory();
    XtendClass _xtendClass_2 = this.getXtendClass();
    int _minus = (offset - 1);
    final ReplacingAppendable appendable = _appendableFactory.get(document, _xtendClass_2, _minus, 0, 1, false);
    appendable.newLine();
    XtendMethodBuilder _methodBuilder = this.getMethodBuilder();
    _methodBuilder.build(appendable);
    IAppendable _decreaseIndentation = appendable.decreaseIndentation();
    _decreaseIndentation.newLine();
    appendable.commitChanges();
    int _plus = (offset + 1);
    int _length = appendable.length();
    xtextEditor.setHighlightRange(_plus, _length, true);
  }
  
  public int getFunctionInsertOffset(final XtendClass clazz) {
    int _xblockexpression = (int) 0;
    {
      final ICompositeNode clazzNode = NodeModelUtils.findActualNodeFor(clazz);
      boolean _equals = ObjectExtensions.operator_equals(clazzNode, null);
      if (_equals) {
        String _name = clazz.getName();
        String _plus = ("Cannot determine node for clazz " + _name);
        IllegalStateException _illegalStateException = new IllegalStateException(_plus);
        throw _illegalStateException;
      }
      int lastClosingBraceOffset = (-1);
      Iterable<ILeafNode> _leafNodes = clazzNode.getLeafNodes();
      for (final ILeafNode leafNode : _leafNodes) {
        boolean _and = false;
        EObject _grammarElement = leafNode.getGrammarElement();
        if (!(_grammarElement instanceof Keyword)) {
          _and = false;
        } else {
          EObject _grammarElement_1 = leafNode.getGrammarElement();
          String _value = ((Keyword) _grammarElement_1).getValue();
          boolean _equals_1 = ObjectExtensions.operator_equals(
            "}", _value);
          _and = ((_grammarElement instanceof Keyword) && _equals_1);
        }
        if (_and) {
          int _offset = leafNode.getOffset();
          lastClosingBraceOffset = _offset;
        }
      }
      int _xifexpression = (int) 0;
      int _minus = (-1);
      boolean _equals_2 = (lastClosingBraceOffset == _minus);
      if (_equals_2) {
        int _totalEndOffset = clazzNode.getTotalEndOffset();
        _xifexpression = _totalEndOffset;
      } else {
        _xifexpression = lastClosingBraceOffset;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public CreateXtendMethod(final XtendMethodBuilder methodBuilder, final XtendClass xtendClass, final IURIEditorOpener editorOpener, final Factory appendableFactory) {
    super();
    this._methodBuilder = methodBuilder;
    this._xtendClass = xtendClass;
    this._editorOpener = editorOpener;
    this._appendableFactory = appendableFactory;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_methodBuilder== null) ? 0 : _methodBuilder.hashCode());
    result = prime * result + ((_xtendClass== null) ? 0 : _xtendClass.hashCode());
    result = prime * result + ((_editorOpener== null) ? 0 : _editorOpener.hashCode());
    result = prime * result + ((_appendableFactory== null) ? 0 : _appendableFactory.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CreateXtendMethod other = (CreateXtendMethod) obj;
    if (_methodBuilder == null) {
      if (other._methodBuilder != null)
        return false;
    } else if (!_methodBuilder.equals(other._methodBuilder))
      return false;
    if (_xtendClass == null) {
      if (other._xtendClass != null)
        return false;
    } else if (!_xtendClass.equals(other._xtendClass))
      return false;
    if (_editorOpener == null) {
      if (other._editorOpener != null)
        return false;
    } else if (!_editorOpener.equals(other._editorOpener))
      return false;
    if (_appendableFactory == null) {
      if (other._appendableFactory != null)
        return false;
    } else if (!_appendableFactory.equals(other._appendableFactory))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
