/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtend.ide.codebuilder.AbstractClassBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaClassBuilder extends AbstractClassBuilder implements ICodeBuilder.Java {
  public boolean isValid() {
    boolean _and = false;
    boolean _isValid = super.isValid();
    if (!_isValid) {
      _and = false;
    } else {
      String _className = this.getClassName();
      boolean _notEquals = (!Objects.equal(_className, null));
      _and = _notEquals;
    }
    return _and;
  }
  
  public ISourceAppender build(final ISourceAppender appendable) {
    JvmVisibility _visibility = this.getVisibility();
    ISourceAppender _appendVisibility = this.appendVisibility(appendable, _visibility, JvmVisibility.DEFAULT);
    ISourceAppender _append = _appendVisibility.append("class ");
    String _className = this.getClassName();
    ISourceAppender _append_1 = _append.append(_className);
    ISourceAppender _append_2 = _append_1.append(" {");
    ISourceAppender _newLine = _append_2.newLine();
    return _newLine.append("}");
  }
  
  public IType getIType() {
    Object _ownerSource = this.getOwnerSource();
    return ((IType) _ownerSource);
  }
}
