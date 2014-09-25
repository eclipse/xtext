/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.conversion;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.xtend.core.conversion.XtendASTFlattener;

/**
 * @author Dennis Hübner - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaConverter {
  public String toXtend(final String javaSrc, final IProgressMonitor progressMonitor) {
    final ASTParser parser = ASTParser.newParser(AST.JLS3);
    char[] _charArray = javaSrc.toCharArray();
    parser.setSource(_charArray);
    ASTNode _createAST = parser.createAST(progressMonitor);
    return this.doConvert(_createAST);
  }
  
  protected String doConvert(final ASTNode ast) {
    final XtendASTFlattener flattener = new XtendASTFlattener();
    ast.accept(flattener);
    return flattener.getResult();
  }
}
