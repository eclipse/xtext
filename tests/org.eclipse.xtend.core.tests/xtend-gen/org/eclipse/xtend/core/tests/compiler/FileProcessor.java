/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.CodeGenerationContext;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;

@SuppressWarnings("all")
public class FileProcessor extends AbstractClassProcessor {
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    CompilationUnit _compilationUnit = annotatedClass.getCompilationUnit();
    final Path path = _compilationUnit.getFilePath();
    Path _projectFolder = context.getProjectFolder(path);
    Path _append = _projectFolder.append("res/template.txt");
    CharSequence _contents = context.getContents(_append);
    final String contents = _contents.toString();
    String _trim = contents.trim();
    final String[] segments = _trim.split(",");
    for (final String segment : segments) {
      final Procedure1<MutableFieldDeclaration> _function = new Procedure1<MutableFieldDeclaration>() {
        public void apply(final MutableFieldDeclaration it) {
          TypeReference _string = context.getString();
          it.setType(_string);
        }
      };
      annotatedClass.addField(segment, _function);
    }
  }
  
  public void doGenerateCode(final ClassDeclaration annotatedClass, @Extension final CodeGenerationContext context) {
    CompilationUnit _compilationUnit = annotatedClass.getCompilationUnit();
    final Path path = _compilationUnit.getFilePath();
    Path _targetFolder = context.getTargetFolder(path);
    final Path result = _targetFolder.append("out.txt");
    Path _projectFolder = context.getProjectFolder(path);
    Path _append = _projectFolder.append("res/template.txt");
    CharSequence _contents = context.getContents(_append);
    String _string = _contents.toString();
    String _trim = _string.trim();
    final String[] segments = _trim.split(",");
    final Procedure1<String> _function = new Procedure1<String>() {
      public void apply(final String segment) {
        FieldDeclaration _findDeclaredField = annotatedClass.findDeclaredField(segment);
        Assert.assertNotNull(_findDeclaredField);
      }
    };
    IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(segments)), _function);
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final String seg : segments) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("|", "");
        }
        _builder.append(seg, "");
      }
    }
    context.setContents(result, _builder);
  }
}
