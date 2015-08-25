/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.splitting;

public class BacktrackingGuardRemover {

	private final String content;
	private int lookaheadTreshold;

	public BacktrackingGuardRemover(String content, int lookaheadTreshold) {
		this.content = content;
		this.lookaheadTreshold = lookaheadTreshold;
	}

	public String transform() {
		String result = content.replace(
				"extends AbstractInternalContentAssistParser {", 
				"extends AbstractInternalContentAssistParser {\n"
				+ "    @Override protected boolean isBacktracking() { return false; }\n"
				+ "    @Override public void announceMark(int marker) { /* do nothing */ }\n"
				// since we get much more information now, we can set a treshold, for which follow elements we are interested.
				// This might have to be fine tuned, depending on the grammar
				+ "    @Override protected int getLookaheadThreshold() { return "+lookaheadTreshold+"; }"
				);
		return result.replace("if ( state.backtracking==0 ) {", "if (! isBacktracking() ) {");
	}

}

