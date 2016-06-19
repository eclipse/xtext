/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractParameterBuilder;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaParameterBuilder extends AbstractParameterBuilder {
  @Override
  protected ISourceAppender appendModifiers(final ISourceAppender appendable) {
    ISourceAppender _xblockexpression = null;
    {
      boolean _isFinalFlag = this.isFinalFlag();
      if (_isFinalFlag) {
        appendable.append("final ");
      }
      _xblockexpression = appendable;
    }
    return _xblockexpression;
  }
  
  @Override
  public boolean isValid() {
    return ((!this.isExtensionFlag()) && super.isValid());
  }
}
