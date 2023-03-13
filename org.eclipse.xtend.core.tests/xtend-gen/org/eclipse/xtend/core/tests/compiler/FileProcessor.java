/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.CodeGenerationContext;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class FileProcessor extends AbstractClassProcessor {
  @Override
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    final Path path = annotatedClass.getCompilationUnit().getFilePath();
    final String contents = context.getContents(context.getProjectFolder(path).append("res/template.txt")).toString();
    final String[] segments = contents.trim().split(",");
    for (final String segment : segments) {
      final Procedure1<MutableFieldDeclaration> _function = (MutableFieldDeclaration it) -> {
        it.setType(context.getString());
      };
      annotatedClass.addField(segment, _function);
    }
  }

  @Override
  public void doGenerateCode(final ClassDeclaration annotatedClass, @Extension final CodeGenerationContext context) {
    final Path path = annotatedClass.getCompilationUnit().getFilePath();
    final Path result = context.getTargetFolder(path).append("out.txt");
    final String[] segments = context.getContents(context.getProjectFolder(path).append("res/template.txt")).toString().split(",");
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final String seg : segments) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("|", "");
        }
        _builder.append(seg);
      }
    }
    context.setContents(result, _builder);
  }
}
