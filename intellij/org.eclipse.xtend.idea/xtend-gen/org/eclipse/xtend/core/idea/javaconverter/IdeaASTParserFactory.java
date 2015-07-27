/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.javaconverter;

import com.intellij.execution.configurations.JavaParameters;
import com.intellij.execution.util.JavaParametersUtil;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.util.PathsList;
import java.io.File;
import java.util.List;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.xtend.core.javaconverter.ASTParserFactory;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaASTParserFactory extends ASTParserFactory {
  @Override
  public ASTParser createJavaParser(final String compilerCompliance, final Object context) {
    if ((!(context instanceof Module))) {
      return super.createJavaParser(compilerCompliance, context);
    }
    final ASTParser parser = this.createDefaultJavaParser(compilerCompliance);
    final JavaParameters params = new JavaParameters();
    Application _application = ApplicationManager.getApplication();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        try {
          JavaParametersUtil.configureModule(((Module) context), params, JavaParameters.JDK_AND_CLASSES_AND_TESTS, 
            null);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    _application.runReadAction(_function);
    PathsList _classPath = params.getClassPath();
    List<String> _pathList = _classPath.getPathList();
    final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        File _file = new File(it);
        return Boolean.valueOf(_file.exists());
      }
    };
    final Iterable<String> cpEntries = IterableExtensions.<String>filter(_pathList, _function_1);
    parser.setEnvironment(((String[])Conversions.unwrapArray(cpEntries, String.class)), null, null, true);
    return parser;
  }
}
