/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvm;

import com.intellij.psi.impl.source.tree.java.JavaFileElement;
import com.intellij.psi.tree.IElementType;

@SuppressWarnings("all")
public class JvmFileElement extends JavaFileElement {
  private final IElementType elementType;
  
  public JvmFileElement(final CharSequence text, final IElementType elementType) {
    super(text);
    this.elementType = elementType;
  }
  
  @Override
  public IElementType getElementType() {
    return this.elementType;
  }
}
