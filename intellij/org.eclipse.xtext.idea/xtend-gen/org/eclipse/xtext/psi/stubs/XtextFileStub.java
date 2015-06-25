/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.psi.stubs;

import com.intellij.psi.stubs.PsiFileStub;
import com.intellij.psi.stubs.PsiFileStubImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class XtextFileStub<T extends BaseXtextFile> extends PsiFileStubImpl<T> implements PsiFileStub<T> {
  @Accessors
  private URI uri;
  
  private final XtextFileElementType<?> type;
  
  public XtextFileStub(final T file, final XtextFileElementType<?> type) {
    super(file);
    this.type = type;
  }
  
  @Override
  public XtextFileElementType<?> getType() {
    return this.type;
  }
  
  @Pure
  public URI getUri() {
    return this.uri;
  }
  
  public void setUri(final URI uri) {
    this.uri = uri;
  }
}
