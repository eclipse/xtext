package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractParameterBuilder;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;

@SuppressWarnings("all")
public class XtendParameterBuilder extends AbstractParameterBuilder {
  protected ISourceAppender appendModifiers(final ISourceAppender appendable) {
    ISourceAppender _xblockexpression = null;
    {
      boolean _isExtensionFlag = this.isExtensionFlag();
      if (_isExtensionFlag) {
        appendable.append("extension ");
      }
      _xblockexpression = appendable;
    }
    return _xblockexpression;
  }
}
