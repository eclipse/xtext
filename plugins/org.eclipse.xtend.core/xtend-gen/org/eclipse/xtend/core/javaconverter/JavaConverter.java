/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.javaconverter;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.xtend.core.javaconverter.JavaASTFlattener;
import org.eclipse.xtend.core.javaconverter.JavaCodeAnalyzer;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.util.ClipboardUtil;
import org.eclipse.xtext.xbase.conversion.IJavaCodeConverter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Converts Java code or an ICompilationUnit to Xtend code<br>
 * 
 *  @author Dennis Hübner - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaConverter implements IJavaCodeConverter {
  @Accessors(AccessorType.PUBLIC_GETTER)
  public static class ConversionResult {
    private String xtendCode;
    
    private Iterable<String> problems = CollectionLiterals.<String>newArrayList();
    
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
    
    @Pure
    public String getXtendCode() {
      return this.xtendCode;
    }
    
    @Pure
    public Iterable<String> getProblems() {
      return this.problems;
    }
  }
  
  @Inject
  private JavaCodeAnalyzer javaAnalyzer;
  
  @Inject
  private Provider<JavaASTFlattener> astFlattenerProvider;
  
  private boolean fallbackConversionStartegy = false;
  
  public JavaConverter.ConversionResult toXtend(final ICompilationUnit cu) {
    try {
      final ASTParser parser = this.javaAnalyzer.createDefaultJavaParser();
      parser.setStatementsRecovery(true);
      parser.setResolveBindings(true);
      parser.setBindingsRecovery(true);
      parser.setSource(cu);
      final ASTNode root = parser.createAST(null);
      String _source = cu.getSource();
      Set<ASTNode> _singleton = Collections.<ASTNode>singleton(root);
      return this.executeAstFlattener(_source, _singleton);
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
      _xblockexpression = this.internalToXtend(unitName, javaSrc, null, null);
    }
    return _xblockexpression;
  }
  
  /**
   * @param javaSrc Java class source code as String
   * @param project JavaProject where the java source code comes from. If project is <code>null</code>, the parser will be<br>
   * 			 configured with the system class loader to resolve bindings.
   */
  public JavaConverter.ConversionResult bodyDeclarationToXtend(final String javaSrc, final ClipboardUtil.JavaImportData additionalImports, final IJavaProject project) {
    return this.internalToXtend(null, javaSrc, additionalImports, project);
  }
  
  /**
   * @param javaSrc Java class source code as String
   */
  public JavaConverter.ConversionResult statementToXtend(final String javaSrc) {
    final ASTParser parser = this.javaAnalyzer.createDefaultJavaParser();
    char[] _charArray = javaSrc.toCharArray();
    parser.setSource(_charArray);
    parser.setKind(ASTParser.K_STATEMENTS);
    final ASTNode root = parser.createAST(null);
    if ((root instanceof Block)) {
      List<Statement> statements = ((Block)root).statements();
      return this.executeAstFlattener(javaSrc, statements);
    }
    Set<ASTNode> _singleton = Collections.<ASTNode>singleton(root);
    return this.executeAstFlattener(javaSrc, _singleton);
  }
  
  /**
   * @param unitName some CU name e.g. Clazz. If unitName is null, a body declaration content is considered.<br>
   * 			See org.eclipse.jdt.core.dom.ASTParser.setUnitName(String)
   * @param javaSrc Java source code as String
   * @param proj JavaProject where the java source code comes from
   */
  private JavaConverter.ConversionResult internalToXtend(final String unitName, final String javaSrc, final ClipboardUtil.JavaImportData additionalImports, final IJavaProject proj) {
    final ASTParser parser = this.javaAnalyzer.createDefaultJavaParser();
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
    final StringBuilder javaSrcBuilder = new StringBuilder();
    boolean _notEquals_1 = (!Objects.equal(additionalImports, null));
    if (_notEquals_1) {
      String[] _imports = additionalImports.getImports();
      final Procedure1<String> _function_1 = new Procedure1<String>() {
        public void apply(final String it) {
          javaSrcBuilder.append((("import " + it) + ";"));
        }
      };
      IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(_imports)), _function_1);
    }
    boolean _equals = Objects.equal(unitName, null);
    if (_equals) {
      parser.setUnitName("MISSING");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class MISSING { ");
      _builder.append(javaSrc, "");
      _builder.append("}");
      javaSrcBuilder.append(_builder);
    } else {
      parser.setUnitName(unitName);
      javaSrcBuilder.append(javaSrc);
    }
    parser.setKind(ASTParser.K_COMPILATION_UNIT);
    final String preparedJavaSrc = javaSrcBuilder.toString();
    char[] _charArray = preparedJavaSrc.toCharArray();
    parser.setSource(_charArray);
    final ASTNode result = parser.createAST(null);
    Set<ASTNode> _singleton = Collections.<ASTNode>singleton(result);
    return this.executeAstFlattener(preparedJavaSrc, _singleton);
  }
  
  /**
   * @param  preparedJavaSource used to collect javadoc and comments
   */
  private JavaConverter.ConversionResult executeAstFlattener(final String preparedJavaSource, final Collection<? extends ASTNode> parseResult) {
    final JavaASTFlattener astFlattener = this.astFlattenerProvider.get();
    astFlattener.useFallBackStrategy(this.fallbackConversionStartegy);
    astFlattener.setJavaSources(preparedJavaSource);
    for (final ASTNode node : parseResult) {
      node.accept(astFlattener);
    }
    return JavaConverter.ConversionResult.create(astFlattener);
  }
  
  public JavaConverter useRobustSyntax() {
    this.fallbackConversionStartegy = true;
    return this;
  }
  
  public boolean isCompatibleTargetObject(final String javaToConvert, final EObject targetElement) {
    return false;
  }
}
