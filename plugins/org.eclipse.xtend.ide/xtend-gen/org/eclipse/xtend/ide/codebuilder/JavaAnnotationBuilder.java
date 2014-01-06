package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtend.ide.codebuilder.AbstractAnnotationBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;

@SuppressWarnings("all")
public class JavaAnnotationBuilder extends AbstractAnnotationBuilder implements ICodeBuilder.Java {
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
  
  public ISourceAppender build(final ISourceAppender appendable) {
    JvmVisibility _visibility = this.getVisibility();
    ISourceAppender _appendVisibility = this.appendVisibility(appendable, _visibility, JvmVisibility.DEFAULT);
    ISourceAppender _append = _appendVisibility.append("@interface ");
    String _annotationName = this.getAnnotationName();
    ISourceAppender _append_1 = _append.append(_annotationName);
    ISourceAppender _append_2 = _append_1.append(" {");
    ISourceAppender _newLine = _append_2.newLine();
    return _newLine.append("}");
  }
  
  public IType getIType() {
    Object _ownerSource = this.getOwnerSource();
    return ((IType) _ownerSource);
  }
}
