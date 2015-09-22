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
import java.util.List;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.xtend.core.javaconverter.ASTParserFactory;
import org.eclipse.xtend.core.javaconverter.JavaASTFlattener;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
  private ASTParserFactory astParserFactory;
  
  @Inject
  private Provider<JavaASTFlattener> astFlattenerProvider;
  
  private boolean fallbackConversionStartegy = false;
  
  public JavaConverter.ConversionResult toXtend(final ICompilationUnit cu) {
    try {
      final ASTParserFactory.ASTParserWrapper parser = this.astParserFactory.createJavaParser(cu);
      final ASTNode root = parser.createAST();
      String _source = cu.getSource();
      String _targetLevel = parser.getTargetLevel();
      return this.executeAstFlattener(_source, root, _targetLevel, false);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * @param unitName some CU name e.g. Clazz. UnitName may not be <code>null</code>.<br>
   * 			See org.eclipse.jdt.core.dom.ASTParser.setUnitName(String)
   * @param javaSrc Java source code as String
   * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject)
   * @throws IllegalArgumentException if unitName is <code>null</code>
   */
  public JavaConverter.ConversionResult toXtend(final String unitName, final String javaSrc) {
    JavaConverter.ConversionResult _xblockexpression = null;
    {
      boolean _equals = Objects.equal(unitName, null);
      if (_equals) {
        throw new IllegalArgumentException();
      }
      ASTParserFactory.ASTParserWrapper _createJavaParser = this.astParserFactory.createJavaParser(null);
      _xblockexpression = this.internalToXtend(unitName, javaSrc, null, _createJavaParser);
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
      boolean _equals = Objects.equal(unitName, null);
      if (_equals) {
        throw new IllegalArgumentException();
      }
      ASTParserFactory.ASTParserWrapper _createJavaParser = this.astParserFactory.createJavaParser(classPathContext);
      _xblockexpression = this.internalToXtend(unitName, javaSrc, null, _createJavaParser);
    }
    return _xblockexpression;
  }
  
  /**
   * @param javaSrc Java class source code as String
   * @param project JavaProject where the java source code comes from. If project is <code>null</code>, the parser will be<br>
   * 			 configured with the system class loader to resolve bindings.
   * @param imports imports to use
   * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject in eclipse Module in idea)
   */
  public JavaConverter.ConversionResult bodyDeclarationToXtend(final String javaSrc, final String[] imports, final Object classPathContext) {
    ASTParserFactory.ASTParserWrapper _createJavaParser = this.astParserFactory.createJavaParser(classPathContext);
    return this.internalToXtend(null, javaSrc, imports, _createJavaParser);
  }
  
  /**
   * @param javaSrc Java class source code as String
   * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject in eclipse Module in idea)
   */
  public JavaConverter.ConversionResult statementToXtend(final String javaSrc, final Object classPathContext) {
    final ASTParserFactory.ASTParserWrapper parser = this.astParserFactory.createJavaParser(classPathContext);
    char[] _charArray = javaSrc.toCharArray();
    parser.setSource(_charArray);
    parser.setKind(ASTParser.K_STATEMENTS);
    final ASTNode root = parser.createAST();
    if ((root instanceof Block)) {
      String _targetLevel = parser.getTargetLevel();
      return this.executeAstFlattener(javaSrc, root, _targetLevel, true);
    }
    String _targetLevel_1 = parser.getTargetLevel();
    return this.executeAstFlattener(javaSrc, root, _targetLevel_1, false);
  }
  
  /**
   * @param javaSrc Java class source code as String
   * @param classPathContext Contextual object from where to get the classpath entries (e.g. IProject in eclipse Module in idea)
   */
  public JavaConverter.ConversionResult expressionToXtend(final String javaSrc, final Object classPathContext) {
    final ASTParserFactory.ASTParserWrapper parser = this.astParserFactory.createJavaParser(classPathContext);
    char[] _charArray = javaSrc.toCharArray();
    parser.setSource(_charArray);
    parser.setKind(ASTParser.K_EXPRESSION);
    final ASTNode root = parser.createAST();
    String _targetLevel = parser.getTargetLevel();
    return this.executeAstFlattener(javaSrc, root, _targetLevel, false);
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
    boolean _notEquals = (!Objects.equal(imports, null));
    if (_notEquals) {
      final Procedure1<String> _function = new Procedure1<String>() {
        @Override
        public void apply(final String it) {
          javaSrcBuilder.append((("import " + it) + ";"));
        }
      };
      IterableExtensions.<String>forEach(((Iterable<String>)Conversions.doWrapArray(imports)), _function);
    }
    boolean _equals = Objects.equal(unitName, null);
    if (_equals) {
      parser.setUnitName("MISSING");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class MISSING { ");
      _builder.append(javaSrc, "");
      _builder.append(" }");
      javaSrcBuilder.append(_builder);
    } else {
      parser.setUnitName(unitName);
      javaSrcBuilder.append(javaSrc);
    }
    parser.setKind(ASTParser.K_COMPILATION_UNIT);
    final String preparedJavaSrc = javaSrcBuilder.toString();
    char[] _charArray = preparedJavaSrc.toCharArray();
    parser.setSource(_charArray);
    final ASTNode result = parser.createAST();
    String _targetLevel = parser.getTargetLevel();
    return this.executeAstFlattener(preparedJavaSrc, result, _targetLevel, false);
  }
  
  /**
   * @param  preparedJavaSource used to collect javadoc and comments
   */
  private JavaConverter.ConversionResult executeAstFlattener(final String preparedJavaSource, final ASTNode parseResult, final String targetLevel, final boolean synteticBlock) {
    final JavaASTFlattener astFlattener = this.astFlattenerProvider.get();
    astFlattener.setTargetlevel(targetLevel);
    astFlattener.useFallBackStrategy(this.fallbackConversionStartegy);
    astFlattener.setJavaSources(preparedJavaSource);
    boolean _and = false;
    if (!synteticBlock) {
      _and = false;
    } else {
      _and = (parseResult instanceof Block);
    }
    if (_and) {
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
}
