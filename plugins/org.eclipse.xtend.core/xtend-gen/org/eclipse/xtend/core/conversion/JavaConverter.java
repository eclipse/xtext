/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.conversion;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.xtend.core.conversion.JavaASTFlattener;

/**
 * @author Dennis Hübner - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaConverter {
  @Inject
  private Provider<JavaASTFlattener> flattenerProvider;
  
  public String toXtend(final String javaSrc) {
    return this.toXtend(javaSrc, ASTParser.K_COMPILATION_UNIT);
  }
  
  public String toXtend(final String javaSrc, final int javaSourceKind) {
    final ASTParser parser = ASTParser.newParser(AST.JLS3);
    parser.setStatementsRecovery(true);
    parser.setBindingsRecovery(true);
    parser.setKind(javaSourceKind);
    char[] _charArray = javaSrc.toCharArray();
    parser.setSource(_charArray);
    ASTNode _createAST = parser.createAST(null);
    return this.doConvert(_createAST);
  }
  
  protected String doConvert(final ASTNode ast) {
    final JavaASTFlattener flattener = this.flattenerProvider.get();
    ast.accept(flattener);
    return flattener.getResult();
  }
}
