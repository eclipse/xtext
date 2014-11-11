/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.conversion;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Hashtable;
import java.util.List;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.xtend.core.conversion.JavaASTFlattener;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Converts Java code or an ICompilationUnit to Xtend code<br>
 * 
 *  @author Dennis Hübner - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaConverter {
  public static class ConversionResult {
    private String xtendCode;
    
    private Iterable<String> problems = CollectionLiterals.<String>newArrayList();
    
    public String getXtendCode() {
      return this.xtendCode;
    }
    
    public Iterable<String> getProblems() {
      return this.problems;
    }
    
    public static JavaConverter.ConversionResult create(final JavaASTFlattener flattener) {
      final JavaConverter.ConversionResult result = new JavaConverter.ConversionResult();
      String _result = flattener.getResult();
      result.xtendCode = _result;
      List<String> _problems = flattener.getProblems();
      boolean _notEquals = (!Objects.equal(_problems, null));
      if (_notEquals) {
        List<String> _problems_1 = flattener.getProblems();
        result.problems = _problems_1;
      }
      return result;
    }
  }
  
  private final static int JLS = JavaASTFlattener.JLS;
  
  /**
   * TODO Refactor this class. Remove state, extract common logic.
   */
  @Inject
  private JavaASTFlattener astFlattener;
  
  private String complianceLevel = "1.5";
  
  private boolean fallbackConversionStartegy = false;
  
  public JavaConverter.ConversionResult toXtend(final ICompilationUnit cu) {
    try {
      final ASTParser parser = ASTParser.newParser(JavaConverter.JLS);
      final Hashtable options = JavaCore.getOptions();
      JavaCore.setComplianceOptions(this.complianceLevel, options);
      parser.setCompilerOptions(options);
      parser.setStatementsRecovery(true);
      parser.setResolveBindings(true);
      parser.setBindingsRecovery(true);
      parser.setSource(cu);
      this.astFlattener.reset();
      this.astFlattener.useFallBackStrategy(this.fallbackConversionStartegy);
      String _source = cu.getSource();
      this.astFlattener.setJavaSources(_source);
      ASTNode _createAST = parser.createAST(null);
      _createAST.accept(this.astFlattener);
      final JavaConverter.ConversionResult result = JavaConverter.ConversionResult.create(this.astFlattener);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * @param unitName some CU name e.g. Clazz. UnitName may not be <code>null</code>.<br>
   * 			See org.eclipse.jdt.core.dom.ASTParser.setUnitName(String)
   * @param javaSrc Java source code as String
   * @throws IllegalArgumentException if unitName is <code>null</code>
   */
  public JavaConverter.ConversionResult toXtend(final String unitName, final String javaSrc) {
    JavaConverter.ConversionResult _xblockexpression = null;
    {
      boolean _equals = Objects.equal(unitName, null);
      if (_equals) {
        throw new IllegalArgumentException();
      }
      _xblockexpression = this.internalToXtend(unitName, javaSrc, null);
    }
    return _xblockexpression;
  }
  
  /**
   * @param javaSrc Java class source code as String
   * @param project JavaProject where the java source code comes from. If project is <code>null</code>, the parser will be<br>
   * 			 configured with the system class loader to resolve bindings.
   */
  public JavaConverter.ConversionResult bodyDeclarationToXtend(final String javaSrc, final IJavaProject project) {
    return this.internalToXtend(null, javaSrc, null);
  }
  
  /**
   * @param unitName some CU name e.g. Clazz. If unitName is null, a body declaration content is considered.<br>
   * 			See org.eclipse.jdt.core.dom.ASTParser.setUnitName(String)
   * @param javaSrc Java source code as String
   * @param proj JavaProject where the java source code comes from
   */
  private JavaConverter.ConversionResult internalToXtend(final String unitName, final String javaSrc, final IJavaProject proj) {
    final ASTParser parser = ASTParser.newParser(JavaConverter.JLS);
    final Hashtable options = JavaCore.getOptions();
    JavaCore.setComplianceOptions(this.complianceLevel, options);
    parser.setCompilerOptions(options);
    parser.setStatementsRecovery(true);
    parser.setResolveBindings(true);
    parser.setBindingsRecovery(true);
    boolean _notEquals = (!Objects.equal(proj, null));
    if (_notEquals) {
      parser.setProject(proj);
    } else {
      final ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
      URL[] _uRLs = ((URLClassLoader) sysClassLoader).getURLs();
      final Function1<URL, String> _function = new Function1<URL, String>() {
        public String apply(final URL it) {
          return it.getFile();
        }
      };
      final List<String> cpEntries = ListExtensions.<URL, String>map(((List<URL>)Conversions.doWrapArray(_uRLs)), _function);
      parser.setEnvironment(((String[])Conversions.unwrapArray(cpEntries, String.class)), null, null, true);
    }
    parser.setKind(ASTParser.K_COMPILATION_UNIT);
    String preparedJavaSource = javaSrc;
    boolean _equals = Objects.equal(unitName, null);
    if (_equals) {
      parser.setUnitName("MISSING");
      preparedJavaSource = (("class MISSING {" + javaSrc) + "}");
    } else {
      parser.setUnitName(unitName);
    }
    char[] _charArray = preparedJavaSource.toCharArray();
    parser.setSource(_charArray);
    this.astFlattener.reset();
    this.astFlattener.useFallBackStrategy(this.fallbackConversionStartegy);
    this.astFlattener.setJavaSources(preparedJavaSource);
    ASTNode _createAST = parser.createAST(null);
    _createAST.accept(this.astFlattener);
    return JavaConverter.ConversionResult.create(this.astFlattener);
  }
  
  public JavaConverter useRobustSyntax() {
    this.fallbackConversionStartegy = true;
    return this;
  }
}
