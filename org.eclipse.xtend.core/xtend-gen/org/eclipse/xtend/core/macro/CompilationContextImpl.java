/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro;

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class CompilationContextImpl implements CompilationStrategy.CompilationContext {
  @Extension
  private ReflectExtensions reflectExtensions = new ReflectExtensions();

  private ImportManager importManager;

  private CompilationUnitImpl compilationUnit;

  public CompilationContextImpl(final ITreeAppendable appendable, final CompilationUnitImpl compilationUnit) {
    this.importManager = this.getImportManager(appendable);
    this.compilationUnit = compilationUnit;
  }

  public ImportManager getImportManager(final ITreeAppendable appendable) {
    try {
      Object _get = this.reflectExtensions.<Object>get(appendable, "state");
      ImportManager _get_1 = null;
      if (_get!=null) {
        _get_1=this.reflectExtensions.<ImportManager>get(_get, "importManager");
      }
      return _get_1;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Override
  public String toJavaCode(final TypeReference typeref) {
    StringBuilderBasedAppendable _xifexpression = null;
    if ((this.importManager != null)) {
      _xifexpression = new StringBuilderBasedAppendable(this.importManager);
    } else {
      _xifexpression = new StringBuilderBasedAppendable();
    }
    final StringBuilderBasedAppendable appendable = _xifexpression;
    final LightweightTypeReference typeRef = this.compilationUnit.toLightweightTypeReference(typeref);
    appendable.append(typeRef);
    return appendable.toString();
  }
}
