/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import java.util.Objects;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.CodeGenerationContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;

@SuppressWarnings("all")
public class __GeneratedSourceModifingAnnotationProcessor extends AbstractClassProcessor {
  @Override
  public void doGenerateCode(final ClassDeclaration annotatedClass, @Extension final CodeGenerationContext context) {
    final Path targetFolder = context.getTargetFolder(annotatedClass.getCompilationUnit().getFilePath());
    String _lastSegment = targetFolder.getLastSegment();
    boolean _equals = Objects.equals(_lastSegment, "xtend-gen");
    Assert.assertTrue(_equals);
  }
}
