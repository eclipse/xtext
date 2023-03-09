/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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