/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.codebuilder.AbstractConstructorBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder.Xtend;
import org.eclipse.xtend.ide.codebuilder.InsertionOffsets;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.output.XtypeTypeReferenceSerializer;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class XtendConstructorBuilder extends AbstractConstructorBuilder implements Xtend {
  @Inject
  private XtypeTypeReferenceSerializer typeRefSerializer;
  
  @Inject
  @Extension
  private InsertionOffsets _insertionOffsets;
  
  protected TypeReferenceSerializer getTypeReferenceSerializer() {
    return this.typeRefSerializer;
  }
  
  public IAppendable build(final IAppendable appendable) {
    JvmVisibility _visibility = this.getVisibility();
    IAppendable _appendVisibility = this.appendVisibility(appendable, _visibility, JvmVisibility.PUBLIC);
    IAppendable _append = _appendVisibility.append("new");
    List<JvmTypeReference> _parameterTypes = this.getParameterTypes();
    IAppendable _appendParameters = this.appendParameters(_append, _parameterTypes);
    IAppendable _append_1 = _appendParameters.append(" {");
    IAppendable _increaseIndentation = _append_1.increaseIndentation();
    IAppendable _newLine = _increaseIndentation.newLine();
    IAppendable _appendDefaultBody = this.appendDefaultBody(_newLine, "");
    IAppendable _decreaseIndentation = _appendDefaultBody.decreaseIndentation();
    IAppendable _newLine_1 = _decreaseIndentation.newLine();
    IAppendable _append_2 = _newLine_1.append("}");
    return _append_2;
  }
  
  public int getInsertOffset() {
    EObject _context = this.getContext();
    XtendTypeDeclaration _xtendType = this.getXtendType();
    int _newConstructorInsertOffset = this._insertionOffsets.getNewConstructorInsertOffset(_context, _xtendType);
    return _newConstructorInsertOffset;
  }
  
  public int getIndentationLevel() {
    return 1;
  }
  
  public XtendTypeDeclaration getXtendType() {
    Object _ownerSource = this.getOwnerSource();
    return ((XtendClass) _ownerSource);
  }
}
