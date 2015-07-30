/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.javaconverter;

import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.xtend.core.javaconverter.ASTParserFactory;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaCodeAnalyzer {
  @Accessors(AccessorType.PUBLIC_GETTER)
  public static final class JavaParseResult<T extends ASTNode> {
    private String javaCode;
    
    private List<T> nodes;
    
    private int type;
    
    public JavaParseResult(final String javaCode, final int type, final List<T> nodes) {
      this.javaCode = javaCode;
      this.type = type;
      this.nodes = nodes;
    }
    
    @Pure
    public String getJavaCode() {
      return this.javaCode;
    }
    
    @Pure
    public List<T> getNodes() {
      return this.nodes;
    }
    
    @Pure
    public int getType() {
      return this.type;
    }
  }
  
  @Inject
  private ASTParserFactory parserFactory;
  
  public JavaCodeAnalyzer.JavaParseResult<? extends ASTNode> determinateJavaType(final String javaCode) {
    ASTParser parser = this.parserFactory.createDefaultJavaParser(this.parserFactory.minParserApiLevel);
    char[] _charArray = javaCode.toCharArray();
    parser.setSource(_charArray);
    parser.setStatementsRecovery(true);
    ASTNode _createAST = parser.createAST(null);
    CompilationUnit unit = ((CompilationUnit) _createAST);
    List _types = unit.types();
    int _size = _types.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      List<CompilationUnit> _singletonList = Collections.<CompilationUnit>singletonList(unit);
      return new JavaCodeAnalyzer.JavaParseResult<CompilationUnit>(javaCode, ASTParser.K_COMPILATION_UNIT, _singletonList);
    }
    char[] _charArray_1 = javaCode.toCharArray();
    parser.setSource(_charArray_1);
    parser.setStatementsRecovery(false);
    parser.setKind(ASTParser.K_CLASS_BODY_DECLARATIONS);
    ASTNode root = parser.createAST(null);
    if ((root instanceof TypeDeclaration)) {
      List<BodyDeclaration> bodyDeclarations = ((TypeDeclaration)root).bodyDeclarations();
      int _size_1 = bodyDeclarations.size();
      boolean _greaterThan_1 = (_size_1 > 0);
      if (_greaterThan_1) {
        return new JavaCodeAnalyzer.JavaParseResult<BodyDeclaration>(javaCode, ASTParser.K_CLASS_BODY_DECLARATIONS, bodyDeclarations);
      }
    }
    char[] _charArray_2 = javaCode.toCharArray();
    parser.setSource(_charArray_2);
    parser.setStatementsRecovery(false);
    parser.setKind(ASTParser.K_STATEMENTS);
    ASTNode _createAST_1 = parser.createAST(null);
    root = _createAST_1;
    if ((root instanceof Block)) {
      List<Statement> statements = ((Block)root).statements();
      int _size_2 = statements.size();
      boolean _greaterThan_2 = (_size_2 > 0);
      if (_greaterThan_2) {
        return new JavaCodeAnalyzer.JavaParseResult<Statement>(javaCode, ASTParser.K_STATEMENTS, statements);
      }
    }
    char[] _charArray_3 = javaCode.toCharArray();
    parser.setSource(_charArray_3);
    parser.setStatementsRecovery(false);
    parser.setKind(ASTParser.K_EXPRESSION);
    ASTNode _createAST_2 = parser.createAST(null);
    root = _createAST_2;
    if ((root instanceof Expression)) {
      List<Expression> _singletonList_1 = Collections.<Expression>singletonList(((Expression)root));
      return new JavaCodeAnalyzer.JavaParseResult<Expression>(javaCode, ASTParser.K_EXPRESSION, _singletonList_1);
    }
    return null;
  }
}
