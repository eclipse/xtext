/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.macro;

import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.CodeGenerationContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;

@SuppressWarnings("all")
public class __GeneratedSourceModifingAnnotationProcessor extends AbstractClassProcessor {
  @Override
  public void doGenerateCode(final ClassDeclaration annotatedClass, @Extension final CodeGenerationContext context) {
    CompilationUnit _compilationUnit = annotatedClass.getCompilationUnit();
    Path _filePath = _compilationUnit.getFilePath();
    Path _targetFolder = context.getTargetFolder(_filePath);
    String _qualifiedName = annotatedClass.getQualifiedName();
    String _replace = _qualifiedName.replace(".", "/");
    String _plus = (_replace + ".java");
    final Path targetFile = _targetFolder.append(_plus);
    boolean _exists = context.exists(targetFile);
    Assert.assertTrue(_exists);
  }
}
