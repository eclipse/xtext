/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

/**
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class ActiveAnnotationContext {
  private final List<XtendAnnotationTarget> _annotatedSourceElements = new Function0<List<XtendAnnotationTarget>>() {
    public List<XtendAnnotationTarget> apply() {
      ArrayList<XtendAnnotationTarget> _newArrayList = CollectionLiterals.<XtendAnnotationTarget>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public List<XtendAnnotationTarget> getAnnotatedSourceElements() {
    return this._annotatedSourceElements;
  }
  
  private Object _processorInstance;
  
  public Object getProcessorInstance() {
    return this._processorInstance;
  }
  
  public void setProcessorInstance(final Object processorInstance) {
    this._processorInstance = processorInstance;
  }
  
  private CompilationUnitImpl _compilationUnit;
  
  public CompilationUnitImpl getCompilationUnit() {
    return this._compilationUnit;
  }
  
  public void setCompilationUnit(final CompilationUnitImpl compilationUnit) {
    this._compilationUnit = compilationUnit;
  }
}
