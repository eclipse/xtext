package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtend.ide.codebuilder.AbstractAnnotationBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder.Java;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;

@SuppressWarnings("all")
public class JavaAnnotationBuilder extends AbstractAnnotationBuilder implements Java {
  @Inject
  private TypeReferenceSerializer typeRefSerializer;
  
  public boolean isValid() {
    boolean _and = false;
    boolean _isValid = super.isValid();
    if (!_isValid) {
      _and = false;
    } else {
      String _annotationName = this.getAnnotationName();
      boolean _notEquals = (!Objects.equal(_annotationName, null));
      _and = (_isValid && _notEquals);
    }
    return _and;
  }
  
  protected TypeReferenceSerializer getTypeReferenceSerializer() {
    return this.typeRefSerializer;
  }
  
  public IAppendable build(final IAppendable appendable) {
    JvmVisibility _visibility = this.getVisibility();
    IAppendable _appendVisibility = this.appendVisibility(appendable, _visibility, JvmVisibility.DEFAULT);
    IAppendable _append = _appendVisibility.append("@interface ");
    String _annotationName = this.getAnnotationName();
    IAppendable _append_1 = _append.append(_annotationName);
    IAppendable _append_2 = _append_1.append(" {");
    IAppendable _newLine = _append_2.newLine();
    IAppendable _append_3 = _newLine.append("}");
    return _append_3;
  }
  
  public IType getIType() {
    Object _ownerSource = this.getOwnerSource();
    return ((IType) _ownerSource);
  }
}
