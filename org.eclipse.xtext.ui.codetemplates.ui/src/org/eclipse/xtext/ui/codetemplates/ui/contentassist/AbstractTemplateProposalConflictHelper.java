/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.contentassist;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.codetemplates.templates.TemplateBody;
import org.eclipse.xtext.ui.codetemplates.templates.Variable;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper;

/**
 * Base class for the conflict helpers of code template languages.
 * It's purpose is to initialize the lexer according to the cursor position
 * when content assist was invoked.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTemplateProposalConflictHelper extends AntlrProposalConflictHelper {

	@Override
	protected void initTokenSource(String text, TokenSource tokenSource, ContentAssistContext context) {
		EObject currentModel = context.getLastCompleteNode().getSemanticElement();
		Variable variable = currentModel != null ? EcoreUtil2.getContainerOfType(currentModel, Variable.class) : null;
		TemplateBody body = currentModel != null ? EcoreUtil2.getContainerOfType(currentModel, TemplateBody.class) : null;
		Lexer lexer = (Lexer) tokenSource;
		CharStream stream = new ANTLRStringStream(text);
		lexer.setCharStream(stream);
		initLexer(lexer, body != null, variable != null);
	}
	
	protected abstract void initLexer(Lexer lexer, boolean literal, boolean variable);

}