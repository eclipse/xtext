/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import com.google.common.base.Objects;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class CompilationContextImpl implements CompilationStrategy.CompilationContext {
  @Extension
  private ReflectExtensions reflectExtensions = new Function0<ReflectExtensions>() {
    public ReflectExtensions apply() {
      ReflectExtensions _reflectExtensions = new ReflectExtensions();
      return _reflectExtensions;
    }
  }.apply();
  
  private ITreeAppendable appendable;
  
  private ImportManager importManager;
  
  private CompilationUnitImpl compilationUnit;
  
  public CompilationContextImpl(final ITreeAppendable appendable, final CompilationUnitImpl compilationUnit) {
    this.appendable = appendable;
    ImportManager _importManager = this.getImportManager(appendable);
    this.importManager = _importManager;
    this.compilationUnit = compilationUnit;
  }
  
  public ImportManager getImportManager(final ITreeAppendable appendable) {
    try {
      ImportManager _get = null;
      Object _get_1 = this.reflectExtensions.<Object>get(appendable, "state");
      if (_get_1!=null) {
        _get=this.reflectExtensions.<ImportManager>get(_get_1, "importManager");
      }
      return _get;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String toJavaCode(final TypeReference typeref) {
    StringBuilderBasedAppendable _xifexpression = null;
    boolean _notEquals = (!Objects.equal(this.importManager, null));
    if (_notEquals) {
      StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable(this.importManager);
      _xifexpression = _stringBuilderBasedAppendable;
    } else {
      StringBuilderBasedAppendable _stringBuilderBasedAppendable_1 = new StringBuilderBasedAppendable();
      _xifexpression = _stringBuilderBasedAppendable_1;
    }
    final StringBuilderBasedAppendable appendable = _xifexpression;
    final LightweightTypeReference typeRef = this.compilationUnit.toLightweightTypeReference(typeref);
    appendable.append(typeRef);
    return appendable.toString();
  }
}
