package org.eclipse.xtext.ui.core;

import org.eclipse.xtext.BuiltinRules;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.LeafNode;

public class BuildInTokenTypeDef {

	@TokenType(name = "Keyword")
	public boolean keyword(LeafNode node) {
		return node.getGrammarElement() instanceof Keyword && node.getText().length() > 1;
	}

	@TokenType(name = "Singleline Comment")
	public boolean slComment(LeafNode node) {
		return ((RuleCall) node.getGrammarElement()).getName().equals(BuiltinRules.BUILTIN_SL_COMMENT.getName());
	}

	@TokenType(name = "Multiline Comment")
	public boolean mlComment(LeafNode node) {
		return ((RuleCall) node.getGrammarElement()).getName().equals(BuiltinRules.BUILTIN_ML_COMMENT.getName());
	}

	@TokenType(name = "Plus Sign")
	public boolean plus_sign(LeafNode node) {
		return node.getText().length() == 1 && node.getText().startsWith("+");
	}
}
