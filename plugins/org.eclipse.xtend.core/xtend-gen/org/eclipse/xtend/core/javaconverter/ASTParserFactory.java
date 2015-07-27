/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.javaconverter;

import com.google.common.base.Objects;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Hashtable;
import java.util.List;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class ASTParserFactory {
  private String complianceLevel = "1.6";
  
  protected ASTParser createDefaultJavaParser(final String compilerCompliance) {
    int _asJLS = ASTParserFactory.asJLS(compilerCompliance);
    final ASTParser parser = ASTParser.newParser(_asJLS);
    final Hashtable options = JavaCore.getOptions();
    JavaCore.setComplianceOptions(compilerCompliance, options);
    options.put(JavaCore.COMPILER_DOC_COMMENT_SUPPORT, JavaCore.ENABLED);
    parser.setCompilerOptions(options);
    return parser;
  }
  
  public static int asJLS(final String compilerCompliance) {
    int _switchResult = (int) 0;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(compilerCompliance, "1.7")) {
        _matched=true;
        _switchResult = 4;
      }
    }
    if (!_matched) {
      if (Objects.equal(compilerCompliance, "1.8")) {
        _matched=true;
        _switchResult = 8;
      }
    }
    if (!_matched) {
      _switchResult = AST.JLS3;
    }
    return _switchResult;
  }
  
  public String defaultCompliancelevel() {
    return this.complianceLevel;
  }
  
  /**
   * @param compilerCompliance compliance level when differs from the {@link #defaultCompliancelevel()}
   * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject)
   */
  public ASTParser createJavaParser(final String compilerCompliance, final Object context) {
    final ASTParser parser = this.createDefaultJavaParser(compilerCompliance);
    this.provideCustomEnvironment(parser);
    return parser;
  }
  
  /**
   * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject)
   */
  public ASTParser createJavaParser(final Object classPathContext) {
    String _defaultCompliancelevel = this.defaultCompliancelevel();
    return this.createJavaParser(_defaultCompliancelevel, classPathContext);
  }
  
  public ASTParser createJavaParser() {
    String _defaultCompliancelevel = this.defaultCompliancelevel();
    return this.createJavaParser(_defaultCompliancelevel, null);
  }
  
  /**
   * Will be called when the environment can not be derived from a context in {@link #createJavaParser(String, Object)}
   * {@link ASTParser#setEnvironment(String[], String[], String[], boolean)}
   */
  protected void provideCustomEnvironment(final ASTParser parser) {
    final ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
    URL[] _uRLs = ((URLClassLoader) sysClassLoader).getURLs();
    final Function1<URL, String> _function = new Function1<URL, String>() {
      @Override
      public String apply(final URL it) {
        return it.getFile();
      }
    };
    List<String> _map = ListExtensions.<URL, String>map(((List<URL>)Conversions.doWrapArray(_uRLs)), _function);
    final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String it) {
        File _file = new File(it);
        return Boolean.valueOf(_file.exists());
      }
    };
    final Iterable<String> cpEntries = IterableExtensions.<String>filter(_map, _function_1);
    parser.setEnvironment(((String[])Conversions.unwrapArray(cpEntries, String.class)), null, null, true);
  }
}
