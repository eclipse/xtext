/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.model;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class XtextWorkerThread extends Thread {
  private final CancelableUnitOfWork<?, IXtextWebDocument> work;
  
  @Accessors
  private IXtextWebDocument document;
  
  @Accessors
  private CancelIndicator cancelIndicator;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private Procedure0 whenFinished;
  
  public XtextWorkerThread(final CancelableUnitOfWork<?, IXtextWebDocument> work) {
    super("Xtext Worker Thread");
    this.work = work;
  }
  
  @Override
  public void run() {
    try {
      try {
        this.work.exec(this.document, this.cancelIndicator);
      } finally {
        boolean _notEquals = (!Objects.equal(this.whenFinished, null));
        if (_notEquals) {
          this.whenFinished.apply();
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Pure
  public IXtextWebDocument getDocument() {
    return this.document;
  }
  
  public void setDocument(final IXtextWebDocument document) {
    this.document = document;
  }
  
  @Pure
  public CancelIndicator getCancelIndicator() {
    return this.cancelIndicator;
  }
  
  public void setCancelIndicator(final CancelIndicator cancelIndicator) {
    this.cancelIndicator = cancelIndicator;
  }
  
  public void setWhenFinished(final Procedure0 whenFinished) {
    this.whenFinished = whenFinished;
  }
}
