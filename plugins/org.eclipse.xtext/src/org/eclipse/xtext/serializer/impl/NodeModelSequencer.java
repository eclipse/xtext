package org.eclipse.xtext.serializer.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.serializer.ISerializationDiagnostic.Acceptor;

import com.google.common.collect.Lists;

public class NodeModelSequencer extends AbstractSequencer {

	public Iterable<IGrammarValuePair> createSequence(EObject context, EObject semanticObject, Acceptor errorAcceptor) {
		List<IGrammarValuePair> result = Lists.newArrayList();
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
					result.add(newPair(rc, node.getSemanticElement()));
				else
					result.add(newPair(rc, NodeModelUtils.getTextWithoutHidden(node)));
				if (node.getSemanticElement() != semanticObject) {
					ti.prune();
					continue;
				}
			} else if (ge instanceof Keyword) {
				Keyword kw = (Keyword) ge;
				if (GrammarUtil.containingAssignment(kw) != null)
					result.add(newPair(kw, node.getText()));
			} else if (ge instanceof Action) {
				Action a = (Action) ge;
				if (a.getFeature() != null)
					result.add(newPair(a, node.getSemanticElement()));
				if (node.getSemanticElement() != semanticObject) {
					ti.prune();
					continue;
				}
			} else if (ge instanceof CrossReference) {
				CrossReference cr = (CrossReference) ge;
				RuleCall rc = (RuleCall) cr.getTerminal();
				EReference ref = GrammarUtil.getReference(cr);
				result.add(newPair(rc, (EObject) node.getSemanticElement().eGet(ref)));
			}
		}
		return result;
	}

	private INode findContextNode(EObject semanticObject) {
		INode node = NodeModelUtils.findActualNodeFor(semanticObject);
		BidiIterator<INode> nodes = node.getAsTreeIterable().iterator();
		while (nodes.hasNext()) {
			INode next = nodes.next();
			if (next.getGrammarElement() instanceof RuleCall)
				return next;
		}
		throw new RuntimeException("no context found");
	}

	public Iterable<EObject> findContexts(EObject semanitcObject, Iterable<EObject> contextCandidates) {
		return Collections.singletonList((EObject) (((RuleCall) findContextNode(semanitcObject).getGrammarElement())
				.getRule()));
	}
}