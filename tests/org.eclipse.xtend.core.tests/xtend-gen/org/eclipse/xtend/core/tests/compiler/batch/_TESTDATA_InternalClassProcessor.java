/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler.batch;

import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.CodeGenerationContext;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class _TESTDATA_InternalClassProcessor extends AbstractClassProcessor {
  @Override
  public void doRegisterGlobals(final ClassDeclaration annotatedClass, @Extension final RegisterGlobalsContext context) {
    String _qualifiedName = annotatedClass.getQualifiedName();
    String _plus = (_qualifiedName + ".InternalClass");
    context.registerClass(_plus);
  }
  
  @Override
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    String _qualifiedName = annotatedClass.getQualifiedName();
    String _plus = (_qualifiedName + ".InternalClass");
    MutableClassDeclaration _findClass = context.findClass(_plus);
    final Procedure1<MutableClassDeclaration> _function = new Procedure1<MutableClassDeclaration>() {
      @Override
      public void apply(final MutableClassDeclaration it) {
        final Procedure1<MutableFieldDeclaration> _function = new Procedure1<MutableFieldDeclaration>() {
          @Override
          public void apply(final MutableFieldDeclaration it) {
            TypeReference _string = context.getString();
            it.setType(_string);
          }
        };
        it.addField("myField", _function);
      }
    };
    ObjectExtensions.<MutableClassDeclaration>operator_doubleArrow(_findClass, _function);
  }
  
  @Override
  public void doGenerateCode(final ClassDeclaration annotatedClass, @Extension final CodeGenerationContext context) {
    CompilationUnit _compilationUnit = annotatedClass.getCompilationUnit();
    Path _filePath = _compilationUnit.getFilePath();
    final Path tF = context.getTargetFolder(_filePath);
    Path _append = tF.append("/Test.txt");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Hello");
    _builder.newLine();
    context.setContents(_append, _builder);
  }
}
