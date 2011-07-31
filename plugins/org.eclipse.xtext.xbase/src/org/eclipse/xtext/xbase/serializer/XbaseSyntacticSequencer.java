package org.eclipse.xtext.xbase.serializer;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;

@SuppressWarnings("restriction")
public class XbaseSyntacticSequencer extends AbstractXbaseSyntacticSequencer {

	/**
	 * Syntax: '('*
	 */
	@Override
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject,
			ISynNavigable transition, List<INode> nodes) {

		Keyword kw = grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0();

		if (nodes == null) {
			if (semanticObject instanceof XIfExpression) {
				EObject cnt = semanticObject.eContainer();
				if (cnt instanceof XExpression && !(cnt instanceof XBlockExpression)
						&& !(cnt instanceof XForLoopExpression))
					acceptUnassignedKeyword(kw, kw.getValue(), null);
			}
		}

		acceptNodes(transition, nodes);
	}
}
