/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.codebuilder;

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
