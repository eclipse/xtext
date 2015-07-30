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
import org.eclipse.jdt.core.IJavaElement;
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
  public ASTParserFactory.ASTParserWrapper createJavaParser(final Object context) {
    if ((context instanceof IJavaElement)) {
      final IJavaProject project = ((IJavaElement)context).getJavaProject();
      final String projlevel = project.getOption(JavaCore.COMPILER_SOURCE, true);
      final ASTParser parser = this.createDefaultJavaParser(projlevel);
      if ((context instanceof IJavaProject)) {
        parser.setProject(project);
        this.tweakOptions(parser, project);
      } else {
        if ((context instanceof ICompilationUnit)) {
          parser.setSource(((ICompilationUnit)context));
          IJavaProject _javaProject = ((ICompilationUnit)context).getJavaProject();
          this.tweakOptions(parser, _javaProject);
        }
      }
      return new ASTParserFactory.ASTParserWrapper(projlevel, parser);
    }
    return super.createJavaParser(context);
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
