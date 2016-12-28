/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.javaconverter;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.xtend.core.javaconverter.ASTParserFactory;
import org.eclipse.xtend.core.javaconverter.JavaASTFlattener;
import org.eclipse.xtend.core.javaconverter.JavaCodeAnalyzer;
import org.eclipse.xtend.core.xtend.XtendExecutable;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Converts Java code or an ICompilationUnit to Xtend code<br>
 * 
 *  @author Dennis Hübner - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaConverter {
  @Accessors
  public static class ConversionResult {
    private String xtendCode;
    
    private Iterable<String> problems = CollectionLiterals.<String>newArrayList();
    
    public static JavaConverter.ConversionResult create(final JavaASTFlattener flattener) {
      final JavaConverter.ConversionResult result = new JavaConverter.ConversionResult();
      result.xtendCode = flattener.getResult();
      List<String> _problems = flattener.getProblems();
      boolean _tripleNotEquals = (_problems != null);
      if (_tripleNotEquals) {
        result.problems = flattener.getProblems();
      }
      return result;
    }
    
    @Pure
    public String getXtendCode() {
      return this.xtendCode;
    }
    
    public void setXtendCode(final String xtendCode) {
      this.xtendCode = xtendCode;
    }
    
    @Pure
    public Iterable<String> getProblems() {
      return this.problems;
    }
    
    public void setProblems(final Iterable<String> problems) {
      this.problems = problems;
    }
  }
  
  @Inject
  private JavaCodeAnalyzer codeAnalyzer;
  
  @Inject
  private ASTParserFactory astParserFactory;
  
  @Inject
  private Provider<JavaASTFlattener> astFlattenerProvider;
  
  private boolean fallbackConversionStartegy = false;
  
  public JavaConverter.ConversionResult toXtend(final ICompilationUnit cu) {
    try {
      final ASTParserFactory.ASTParserWrapper parser = this.astParserFactory.createJavaParser(cu);
      final ASTNode root = parser.createAST();
      return this.executeAstFlattener(cu.getSource(), root, parser.getTargetLevel(), false);
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
      if ((unitName == null)) {
        throw new IllegalArgumentException();
      }
      _xblockexpression = this.internalToXtend(unitName, javaSrc, null, this.astParserFactory.createJavaParser(null));
    }
    return _xblockexpression;
  }
  
  /**
   * @param unitName some CU name e.g. Clazz. UnitName may not be <code>null</code>.<br>
   * 			See org.eclipse.jdt.core.dom.ASTParser.setUnitName(String)
   * @param javaSrc Java source code as String
   * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject)
   * @throws IllegalArgumentException if unitName is <code>null</code>
   */
  public JavaConverter.ConversionResult toXtend(final String unitName, final String javaSrc, final Object classPathContext) {
    JavaConverter.ConversionResult _xblockexpression = null;
    {
      if ((unitName == null)) {
        throw new IllegalArgumentException();
      }
      _xblockexpression = this.internalToXtend(unitName, javaSrc, null, this.astParserFactory.createJavaParser(classPathContext));
    }
    return _xblockexpression;
  }
  
  /**
   * @param javaSrc Java class source code as String
   * @param javaImports imports to use
   * @param targetElement Used to determinate javaCode conversion type
   * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject in eclipse Module in idea)
   */
  public String toXtend(final String javaSrc, final String[] javaImports, final EObject targetElement, final Object classPathContext) {
    boolean forceStatement = this.shouldForceStatementMode(targetElement);
    JavaCodeAnalyzer.JavaParseResult<? extends ASTNode> parseResult = this.codeAnalyzer.determinateJavaType(javaSrc);
    if ((parseResult == null)) {
      return javaSrc;
    }
    JavaConverter.ConversionResult conversionResult = null;
    if ((forceStatement || (parseResult.getType() < ASTParser.K_CLASS_BODY_DECLARATIONS))) {
      int _type = parseResult.getType();
      boolean _tripleEquals = (_type == ASTParser.K_EXPRESSION);
      if (_tripleEquals) {
        conversionResult = this.expressionToXtend(javaSrc, classPathContext);
      } else {
        conversionResult = this.statementToXtend(javaSrc, classPathContext);
      }
    } else {
      String[] _xifexpression = null;
      if ((javaImports != null)) {
        _xifexpression = javaImports;
      } else {
        _xifexpression = null;
      }
      conversionResult = this.bodyDeclarationToXtend(javaSrc, _xifexpression, classPathContext);
    }
    return conversionResult.getXtendCode();
  }
  
  /**
   * @param javaSrc Java class source code as String
   * @param imports imports to use
   * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject in eclipse Module in idea)
   */
  public JavaConverter.ConversionResult bodyDeclarationToXtend(final String javaSrc, final String[] imports, final Object classPathContext) {
    return this.internalToXtend(null, javaSrc, imports, this.astParserFactory.createJavaParser(classPathContext));
  }
  
  /**
   * @param javaSrc Java class source code as String
   * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject in eclipse Module in idea)
   */
  public JavaConverter.ConversionResult statementToXtend(final String javaSrc, final Object classPathContext) {
    final ASTParserFactory.ASTParserWrapper parser = this.astParserFactory.createJavaParser(classPathContext);
    parser.setSource(javaSrc.toCharArray());
    parser.setKind(ASTParser.K_STATEMENTS);
    final ASTNode root = parser.createAST();
    if ((root instanceof Block)) {
      return this.executeAstFlattener(javaSrc, root, parser.getTargetLevel(), true);
    }
    return this.executeAstFlattener(javaSrc, root, parser.getTargetLevel(), false);
  }
  
  /**
   * @param javaSrc Java class source code as String
   * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject in eclipse Module in idea)
   */
  public JavaConverter.ConversionResult expressionToXtend(final String javaSrc, final Object classPathContext) {
    final ASTParserFactory.ASTParserWrapper parser = this.astParserFactory.createJavaParser(classPathContext);
    parser.setSource(javaSrc.toCharArray());
    parser.setKind(ASTParser.K_EXPRESSION);
    final ASTNode root = parser.createAST();
    return this.executeAstFlattener(javaSrc, root, parser.getTargetLevel(), false);
  }
  
  /**
   * @param unitName some CU name e.g. Clazz. If unitName is null, a body declaration content is considered.<br>
   * 			See org.eclipse.jdt.core.dom.ASTParser.setUnitName(String)
   * @param javaSrc Java source code as String
   * @param imports Additional imports to add
   * @param parser ASTParser to use
   */
  private JavaConverter.ConversionResult internalToXtend(final String unitName, final String javaSrc, final String[] imports, final ASTParserFactory.ASTParserWrapper parser) {
    final StringBuilder javaSrcBuilder = new StringBuilder();
    if ((imports != null)) {
      final Consumer<String> _function = (String it) -> {
        javaSrcBuilder.append((("import " + it) + ";"));
      };
      ((List<String>)Conversions.doWrapArray(imports)).forEach(_function);
    }
    if ((unitName == null)) {
      parser.setUnitName("MISSING");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class MISSING { ");
      _builder.append(javaSrc);
      _builder.append(" }");
      javaSrcBuilder.append(_builder);
    } else {
      parser.setUnitName(unitName);
      javaSrcBuilder.append(javaSrc);
    }
    parser.setKind(ASTParser.K_COMPILATION_UNIT);
    final String preparedJavaSrc = javaSrcBuilder.toString();
    parser.setSource(preparedJavaSrc.toCharArray());
    final ASTNode result = parser.createAST();
    return this.executeAstFlattener(preparedJavaSrc, result, parser.getTargetLevel(), false);
  }
  
  /**
   * @param  preparedJavaSource used to collect javadoc and comments
   */
  private JavaConverter.ConversionResult executeAstFlattener(final String preparedJavaSource, final ASTNode parseResult, final String targetLevel, final boolean synteticBlock) {
    final JavaASTFlattener astFlattener = this.astFlattenerProvider.get();
    astFlattener.setTargetlevel(targetLevel);
    astFlattener.useFallBackStrategy(this.fallbackConversionStartegy);
    astFlattener.setJavaSources(preparedJavaSource);
    if ((synteticBlock && (parseResult instanceof Block))) {
      astFlattener.acceptSyntaticBlock(((Block) parseResult));
    } else {
      parseResult.accept(astFlattener);
    }
    return JavaConverter.ConversionResult.create(astFlattener);
  }
  
  public JavaConverter useRobustSyntax() {
    this.fallbackConversionStartegy = true;
    return this;
  }
  
  public boolean shouldForceStatementMode(final EObject targetElement) {
    return (((targetElement != null) && 
      (!((targetElement instanceof XAnnotation) || (targetElement instanceof XtendExecutable)))) && 
      (EcoreUtil2.<XtendExecutable>getContainerOfType(targetElement, XtendExecutable.class) != null));
  }
}
