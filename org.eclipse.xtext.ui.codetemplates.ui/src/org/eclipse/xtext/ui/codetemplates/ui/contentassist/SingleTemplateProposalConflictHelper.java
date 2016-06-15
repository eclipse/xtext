/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.contentassist;

import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.codetemplates.lexer.SingleCodetemplateLexer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SingleTemplateProposalConflictHelper extends AbstractTemplateProposalConflictHelper {

	@Override
	protected void initLexer(Lexer lexer, boolean literal, boolean variable) {
		((SingleCodetemplateLexer) lexer).initialize(literal, variable);
	}
}