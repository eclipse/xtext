package org.eclipse.xtext.serializer.impl;

import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.serializer.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.ISerializationDiagnostic.Acceptor;

public class NodeModelSyntacticSequencer extends AbstractNodeModelSequencer {

	public void createSequence(EObject context, EObject semanticObject, ISemanticSequenceAcceptor acceptor,
			Acceptor errorAcceptor) {
		BidiTreeIterator<INode> ti = NodeModelUtils.findActualNodeFor(semanticObject).getAsTreeIterable().iterator();
		while (ti.hasNext()) {
			INode node = ti.next();
			if (node instanceof ILeafNode && ((ILeafNode) node).isHidden())
				continue;
			EObject ge = node.getGrammarElement();
			if (ge instanceof RuleCall) {
				RuleCall rc = (RuleCall) ge;
				if (rc.getRule() == context)
					continue;
				if (rc.getRule().getType().getClassifier() instanceof EClass)
					acceptSemantic(acceptor, rc, node.getSemanticElement(), node);
				else
					acceptSemantic(acceptor, rc, NodeModelUtils.getTextWithoutHidden(node), node);
				//				if (node.getSemanticElement() != semanticObject) {
				//					ti.prune();
				//					continue;
				//				}
			} else if (ge instanceof Keyword) {
				Keyword kw = (Keyword) ge;
				//				if (GrammarUtil.containingAssignment(kw) != null)
				acceptSemantic(acceptor, kw, node.getText(), node);
			} else if (ge instanceof Action) {
				Action a = (Action) ge;
				//				if (a.getFeature() != null)
				acceptSemantic(acceptor, a, node.getSemanticElement(), node);
				//				if (node.getSemanticElement() != semanticObject) {
				//					ti.prune();
				//					continue;
				//				}
			} else if (ge instanceof CrossReference) {
				CrossReference cr = (CrossReference) ge;
				RuleCall rc = (RuleCall) cr.getTerminal();
				EReference ref = GrammarUtil.getReference(cr);
				acceptSemantic(acceptor, rc, node.getSemanticElement().eGet(ref), node);
			}
		}
	}

	private INode findContextNode(EObject semanticObject) {
		INode node = NodeModelUtils.findActualNodeFor(semanticObject);
		BidiIterator<INode> nodes = node.getAsTreeIterable().iterator();
		while (nodes.hasNext()) {
			INode next = nodes.next();
			if (next.getGrammarElement() instanceof RuleCall)
				return next;
			if (next.getGrammarElement() instanceof ParserRule
					&& ((ParserRule) next.getGrammarElement()).getType().getClassifier() instanceof EClass)
				return next;
		}
		throw new RuntimeException("no context found");
	}

	public Iterable<EObject> findContexts(EObject semanitcObject, Iterable<EObject> contextCandidates) {
		EObject ctx = findContextNode(semanitcObject).getGrammarElement();
		if (ctx instanceof RuleCall)
			return Collections.singletonList((EObject) (((RuleCall) ctx).getRule()));
		return Collections.singletonList(ctx);
	}
}