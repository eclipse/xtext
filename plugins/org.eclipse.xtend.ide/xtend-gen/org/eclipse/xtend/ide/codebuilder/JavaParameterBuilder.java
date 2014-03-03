package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractParameterBuilder;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;

@SuppressWarnings("all")
public class JavaParameterBuilder extends AbstractParameterBuilder {
  protected ISourceAppender appendModifiers(final ISourceAppender appendable) {
    ISourceAppender _xblockexpression = null;
    {
      boolean _isFinalFlag = this.isFinalFlag();
      if (_isFinalFlag) {
        appendable.append("final ");
      }
      _xblockexpression = (appendable);
    }
    return _xblockexpression;
  }
  
  public boolean isValid() {
    boolean _and = false;
    boolean _isExtensionFlag = this.isExtensionFlag();
    boolean _not = (!_isExtensionFlag);
    if (!_not) {
      _and = false;
    } else {
      boolean _isValid = super.isValid();
      _and = _isValid;
    }
    return _and;
  }
}
