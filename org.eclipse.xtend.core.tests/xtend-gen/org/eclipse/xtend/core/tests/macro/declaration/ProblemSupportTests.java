/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro.declaration;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ProblemSupportTests extends AbstractXtendTestCase {
  @Inject
  private Provider<CompilationUnitImpl> compilationUnitProvider;

  @Test
  public void testErrorOnSource() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String foo = \'foo\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      it.getProblemSupport().addError(IterableExtensions.head(it.getSourceTypeDeclarations()), "error on source");
      Assert.assertEquals("error on source", IterableExtensions.<Resource.Diagnostic>head(it.getXtendFile().eResource().getErrors()).getMessage());
      Resource.Diagnostic _head = IterableExtensions.<Resource.Diagnostic>head(it.getXtendFile().eResource().getErrors());
      Assert.assertEquals(IterableExtensions.<XtendTypeDeclaration>head(it.getXtendFile().getXtendTypes()), ((EObjectDiagnosticImpl) _head).getProblematicObject());
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  @Test
  public void testErrorOnDerivedElement() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyClass {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String foo = \'foo\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<CompilationUnitImpl> _function = (CompilationUnitImpl it) -> {
      final MutableClassDeclaration derived = it.getTypeLookup().findClass("MyClass");
      it.getProblemSupport().addError(derived, "error on derived element");
      Assert.assertEquals("error on derived element", IterableExtensions.<Resource.Diagnostic>head(it.getXtendFile().eResource().getErrors()).getMessage());
      Resource.Diagnostic _head = IterableExtensions.<Resource.Diagnostic>head(it.getXtendFile().eResource().getErrors());
      Assert.assertEquals(IterableExtensions.<XtendTypeDeclaration>head(it.getXtendFile().getXtendTypes()), ((EObjectDiagnosticImpl) _head).getProblematicObject());
    };
    this.asCompilationUnit(this.validFile(_builder), _function);
  }

  public XtendFile validFile(final CharSequence code) {
    try {
      return this.file(code.toString(), true);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  public void asCompilationUnit(final XtendFile file, final Procedure1<? super CompilationUnitImpl> block) {
    final CompilationUnitImpl compilationUnit = this.compilationUnitProvider.get();
    compilationUnit.setXtendFile(file);
    compilationUnit.before(ActiveAnnotationContexts.AnnotationCallback.INFERENCE);
    block.apply(compilationUnit);
  }
}
