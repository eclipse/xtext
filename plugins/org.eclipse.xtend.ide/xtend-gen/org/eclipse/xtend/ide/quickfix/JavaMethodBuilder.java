package org.eclipse.xtend.ide.quickfix;

import org.eclipse.xtend.ide.quickfix.XtendMethodBuilder;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.compiler.IAppendable;

@SuppressWarnings("all")
public class JavaMethodBuilder extends XtendMethodBuilder {
  protected StringBuilder defaultReturnStatement() {
    StringBuilder _defaultReturnStatement = super.defaultReturnStatement();
    StringBuilder _append = _defaultReturnStatement.append(";");
    return _append;
  }
  
  protected IAppendable addPrefix(final IAppendable appendable) {
    IAppendable _append = appendable.append("public ");
    JvmTypeReference _returnType = this.returnType();
    IAppendable _append_1 = this.append(_append, _returnType);
    IAppendable _append_2 = _append_1.append(" ");
    return _append_2;
  }
}
