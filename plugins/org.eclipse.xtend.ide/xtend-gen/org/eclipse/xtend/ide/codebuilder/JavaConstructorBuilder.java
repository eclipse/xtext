package org.eclipse.xtend.ide.codebuilder;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtend.ide.codebuilder.AbstractConstructorBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder.Java;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;

@SuppressWarnings("all")
public class JavaConstructorBuilder extends AbstractConstructorBuilder implements Java {
  @Inject
  private TypeReferenceSerializer typeRefSerializer;
  
  protected TypeReferenceSerializer getTypeReferenceSerializer() {
    return this.typeRefSerializer;
  }
  
  public IAppendable build(final IAppendable appendable) {
    JvmVisibility _visibility = this.getVisibility();
    IAppendable _appendVisibility = this.appendVisibility(appendable, _visibility, JvmVisibility.PRIVATE);
    JvmDeclaredType _owner = this.getOwner();
    String _simpleName = _owner.getSimpleName();
    IAppendable _append = _appendVisibility.append(_simpleName);
    List<JvmTypeReference> _parameterTypes = this.getParameterTypes();
    IAppendable _appendParameters = this.appendParameters(_append, _parameterTypes);
    IAppendable _append_1 = _appendParameters.append(" {");
    IAppendable _increaseIndentation = _append_1.increaseIndentation();
    IAppendable _newLine = _increaseIndentation.newLine();
    IAppendable _appendDefaultBody = this.appendDefaultBody(_newLine, ";");
    IAppendable _decreaseIndentation = _appendDefaultBody.decreaseIndentation();
    IAppendable _newLine_1 = _decreaseIndentation.newLine();
    IAppendable _append_2 = _newLine_1.append("}");
    return _append_2;
  }
  
  public IType getIType() {
    Object _ownerSource = this.getOwnerSource();
    return ((IType) _ownerSource);
  }
}
