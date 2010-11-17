package org.eclipse.xtext.nodemodel.impl;

import org.eclipse.xtext.parser.antlr.SyntaxErrorMessage;

public class LeafNodeWithSyntaxError extends LeafNode {

	private SyntaxErrorMessage syntaxErrorMessage;
	
	@Override
	public int getNodeType() {
		return super.getNodeType() | SYNTAX_ERROR;
	}
	
	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage() {
		return syntaxErrorMessage;
	}

	public void setSyntaxErrorMessage(SyntaxErrorMessage syntaxErrorMessage) {
		this.syntaxErrorMessage = syntaxErrorMessage;
	}
	
}
