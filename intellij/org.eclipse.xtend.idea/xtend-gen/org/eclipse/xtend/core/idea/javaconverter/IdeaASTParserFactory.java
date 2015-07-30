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
import com.intellij.openapi.roots.LanguageLevelModuleExtension;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.pom.java.LanguageLevel;
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
  public ASTParserFactory.ASTParserWrapper createJavaParser(final Object context) {
    if ((!(context instanceof Module))) {
      return super.createJavaParser(context);
    }
    final JavaParameters params = new JavaParameters();
    final Module module = ((Module) context);
    Application _application = ApplicationManager.getApplication();
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        try {
          JavaParametersUtil.configureModule(module, params, JavaParameters.JDK_AND_CLASSES_AND_TESTS, null);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    _application.runReadAction(_function);
    ModuleRootManager _instance = ModuleRootManager.getInstance(module);
    LanguageLevelModuleExtension _moduleExtension = _instance.<LanguageLevelModuleExtension>getModuleExtension(LanguageLevelModuleExtension.class);
    LanguageLevel _languageLevel = null;
    if (_moduleExtension!=null) {
      _languageLevel=_moduleExtension.getLanguageLevel();
    }
    final LanguageLevel moduleLL = _languageLevel;
    String _switchResult = null;
    if (moduleLL != null) {
      switch (moduleLL) {
        case JDK_1_7:
          _switchResult = "1.7";
          break;
        case JDK_1_8:
          _switchResult = "1.8";
          break;
        default:
          _switchResult = this.minParserApiLevel;
          break;
      }
    } else {
      _switchResult = this.minParserApiLevel;
    }
    String targetLevel = _switchResult;
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
    final ASTParser parser = this.createDefaultJavaParser(targetLevel);
    parser.setEnvironment(((String[])Conversions.unwrapArray(cpEntries, String.class)), null, null, true);
    return new ASTParserFactory.ASTParserWrapper(targetLevel, parser);
  }
}
