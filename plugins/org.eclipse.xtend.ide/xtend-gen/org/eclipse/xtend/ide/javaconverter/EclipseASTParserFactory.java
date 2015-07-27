/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.javaconverter;

import com.google.common.base.Objects;
import java.util.Map;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.xtend.core.javaconverter.ASTParserFactory;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class EclipseASTParserFactory extends ASTParserFactory {
  @Override
  public ASTParser createJavaParser(final String compilerCompliance, final Object context) {
    if ((context instanceof IJavaProject)) {
      final ASTParser parser = this.createDefaultJavaParser(compilerCompliance);
      final IJavaProject project = ((IJavaProject)context);
      parser.setProject(project);
      this.tweakOptions(parser, project);
      return parser;
    } else {
      if ((context instanceof ICompilationUnit)) {
        final ASTParser parser_1 = this.createDefaultJavaParser(compilerCompliance);
        parser_1.setStatementsRecovery(true);
        parser_1.setResolveBindings(true);
        parser_1.setBindingsRecovery(true);
        parser_1.setSource(((ICompilationUnit)context));
        IJavaProject _javaProject = ((ICompilationUnit)context).getJavaProject();
        this.tweakOptions(parser_1, _javaProject);
        return parser_1;
      }
    }
    return super.createJavaParser(compilerCompliance, context);
  }
  
  public void tweakOptions(final ASTParser parser, final IJavaProject project) {
    boolean _notEquals = (!Objects.equal(project, null));
    if (_notEquals) {
      final Map options = project.getOptions(true);
      options.remove(JavaCore.COMPILER_TASK_TAGS);
      options.put(JavaCore.COMPILER_DOC_COMMENT_SUPPORT, JavaCore.ENABLED);
      parser.setCompilerOptions(options);
    }
  }
}
