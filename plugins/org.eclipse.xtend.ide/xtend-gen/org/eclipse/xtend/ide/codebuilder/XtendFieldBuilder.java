package org.eclipse.xtend.ide.codebuilder;

import javax.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.ide.codebuilder.AbstractFieldBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder.Xtend;
import org.eclipse.xtend.ide.codebuilder.InsertionOffsets;
import org.eclipse.xtend.ide.codebuilder.XtendTypeReferenceSerializer;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;

@SuppressWarnings("all")
public class XtendFieldBuilder extends AbstractFieldBuilder implements Xtend {
  @Inject
  private XtendTypeReferenceSerializer typeRefSerializer;
  
  @Inject
  private InsertionOffsets _insertionOffsets;
  
  protected TypeReferenceSerializer getTypeReferenceSerializer() {
    return this.typeRefSerializer;
  }
  
  public IAppendable build(final IAppendable appendable) {
    JvmVisibility _visibility = this.getVisibility();
    IAppendable _appendVisibility = this.appendVisibility(appendable, _visibility, JvmVisibility.PRIVATE);
    JvmTypeReference _fieldType = this.getFieldType();
    IAppendable _appendType = this.appendType(_appendVisibility, _fieldType, "Object");
    IAppendable _append = _appendType.append(" ");
    String _fieldName = this.getFieldName();
    IAppendable _append_1 = _append.append(_fieldName);
    return _append_1;
  }
  
  public int getInsertOffset() {
    EObject _context = this.getContext();
    XtendClass _xtendClass = this.getXtendClass();
    int _newFieldInsertOffset = this._insertionOffsets.getNewFieldInsertOffset(_context, _xtendClass);
    return _newFieldInsertOffset;
  }
  
  public XtendClass getXtendClass() {
    Object _ownerSource = this.getOwnerSource();
    return ((XtendClass) _ownerSource);
  }
}
