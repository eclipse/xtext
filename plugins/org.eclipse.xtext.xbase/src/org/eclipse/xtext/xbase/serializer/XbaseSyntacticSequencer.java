package org.eclipse.xtext.xbase.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIfExpression;

@SuppressWarnings("restriction")
public class XbaseSyntacticSequencer extends AbstractXbaseSyntacticSequencer {

	/**
	 * Syntax: '('*
	 */
	@Override
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject,
			ISynTransition transition, INode fromNode, INode toNode) {

		Keyword kw = grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0();

		if (fromNode == null) {
			if (semanticObject instanceof XIfExpression) {
				EObject cnt = semanticObject.eContainer();
				if (cnt instanceof XExpression && !(cnt instanceof XBlockExpression))
					acceptUnassignedKeyword(kw, null);
			}
		}

		acceptNodes(transition, fromNode, toNode);
	}
}
