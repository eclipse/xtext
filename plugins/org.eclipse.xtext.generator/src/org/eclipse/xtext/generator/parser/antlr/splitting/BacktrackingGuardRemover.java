/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.splitting;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
public class BacktrackingGuardRemover {

	private final String content;

	public BacktrackingGuardRemover(String content) {
		this.content = content;
	}

	public String transform() {
		String result = content.replace("extends AbstractInternalContentAssistParser {", "extends AbstractInternalContentAssistParser {\n"
				+ "    protected boolean isBacktracking() { return false; }");
		return result.replace("if ( state.backtracking==0 ) {", "if (! isBacktracking() ) {");
	}

}

