package org.eclipse.xtend.ide.codebuilder;

import javax.inject.Inject;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtend.ide.codebuilder.AbstractFieldBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder.Java;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;

@SuppressWarnings("all")
public class JavaFieldBuilder extends AbstractFieldBuilder implements Java {
  @Inject
  private TypeReferenceSerializer typeRefSerializer;
  
  protected TypeReferenceSerializer getTypeReferenceSerializer() {
    return this.typeRefSerializer;
  }
  
  public IAppendable build(final IAppendable appendable) {
    JvmVisibility _visibility = this.getVisibility();
    IAppendable _appendVisibility = this.appendVisibility(appendable, _visibility, JvmVisibility.DEFAULT);
    JvmTypeReference _fieldType = this.getFieldType();
    IAppendable _appendType = this.appendType(_appendVisibility, _fieldType, "Object");
    IAppendable _append = _appendType.append(" ");
    String _fieldName = this.getFieldName();
    IAppendable _append_1 = _append.append(_fieldName);
    IAppendable _append_2 = _append_1.append(";");
    return _append_2;
  }
  
  public IType getIType() {
    Object _ownerSource = this.getOwnerSource();
    return ((IType) _ownerSource);
  }
}
