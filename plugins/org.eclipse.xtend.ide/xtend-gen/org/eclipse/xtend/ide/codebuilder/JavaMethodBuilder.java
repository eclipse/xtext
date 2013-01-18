package org.eclipse.xtend.ide.codebuilder;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtend.ide.codebuilder.AbstractMethodBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder.Java;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;

@SuppressWarnings("all")
public class JavaMethodBuilder extends AbstractMethodBuilder implements Java {
  @Inject
  private TypeReferenceSerializer typeRefSerializer;
  
  protected TypeReferenceSerializer getTypeReferenceSerializer() {
    return this.typeRefSerializer;
  }
  
  public IAppendable build(final IAppendable appendable) {
    JvmVisibility _visibility = this.getVisibility();
    IAppendable _appendVisibility = this.appendVisibility(appendable, _visibility, JvmVisibility.PRIVATE);
    JvmTypeReference _returnType = this.getReturnType();
    IAppendable _appendType = this.appendType(_appendVisibility, _returnType, "void");
    IAppendable _append = _appendType.append(" ");
    String _methodName = this.getMethodName();
    IAppendable _append_1 = _append.append(_methodName);
    List<JvmTypeReference> _parameterTypes = this.getParameterTypes();
    IAppendable _appendParameters = this.appendParameters(_append_1, _parameterTypes);
    IAppendable _append_2 = _appendParameters.append(" {");
    IAppendable _increaseIndentation = _append_2.increaseIndentation();
    IAppendable _newLine = _increaseIndentation.newLine();
    IAppendable _appendDefaultBody = this.appendDefaultBody(_newLine, ";");
    IAppendable _decreaseIndentation = _appendDefaultBody.decreaseIndentation();
    IAppendable _newLine_1 = _decreaseIndentation.newLine();
    IAppendable _append_3 = _newLine_1.append("}");
    return _append_3;
  }
  
  public IType getIType() {
    Object _ownerSource = this.getOwnerSource();
    return ((IType) _ownerSource);
  }
}
