package org.eclipse.xtext.ui.core;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.LeafNode;

public class BuildInTokenTypeDef {

	@TokenType(name = "Keyword")
	public static boolean keyword(LeafNode node) {
		return node.getGrammarElement() instanceof Keyword && node.getText().length() > 1;
	}

	@TokenType(name = "Singleline Comment")
	public static boolean slComment(LeafNode node) {
		return ((RuleCall) node.getGrammarElement()).getName().equals("SL_COMMENT");
	}

	@TokenType(name = "Multiline Comment")
	public static boolean mlComment(LeafNode node) {
		return ((RuleCall) node.getGrammarElement()).getName().equals("ML_COMMENT");
	}

	@TokenType(name = "Plus Sign")
	public static boolean plus_sign(LeafNode node) {
		return node.getText().length() == 1 && node.getText().startsWith("+");
	}
}
