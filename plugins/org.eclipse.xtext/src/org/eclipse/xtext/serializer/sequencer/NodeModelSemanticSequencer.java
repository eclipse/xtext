package org.eclipse.xtext.serializer.sequencer;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.RuleNames;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.serializer.impl.FeatureFinderUtil;
import org.eclipse.xtext.util.Triple;

import com.google.inject.Inject;

public class NodeModelSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected IValueConverterService valueConverter;
	
	@Inject
	protected RuleNames ruleNames;

	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		SemanticNodeIterator ni = new SemanticNodeIterator(semanticObject);
		while (ni.hasNext()) {
			Triple<INode, AbstractElement, EObject> node = ni.next();
			if (node.getSecond() instanceof RuleCall) {
				RuleCall rc = (RuleCall) node.getSecond();
				if (rc.getRule().getType().getClassifier() instanceof EClass)
					acceptSemantic(semanticObject, rc, node.getThird(), node.getFirst());
				else if (GrammarUtil.containingCrossReference(node.getSecond()) != null) {
					EStructuralFeature feature = FeatureFinderUtil
							.getFeature(node.getSecond(), semanticObject.eClass());
					acceptSemantic(semanticObject, rc, semanticObject.eGet(feature), node.getFirst());
				} else {
					String strVal = NodeModelUtils.getTokenText(node.getFirst());
					Object val = valueConverter.toValue(strVal, ruleNames.getQualifiedName(rc.getRule()), node.getFirst());
					acceptSemantic(semanticObject, rc, val, node.getFirst());
				}
			} else if (node.getSecond() instanceof Keyword)
				acceptSemantic(semanticObject, node.getSecond(), node.getFirst().getText(), node.getFirst());
			else if (node.getSecond() instanceof Action) {
				acceptSemantic(semanticObject, node.getSecond(), semanticObject, node.getFirst());
			}
		}
	}

	protected boolean acceptSemantic(EObject semanticObject, AbstractElement ele, Object value, INode node) {
		Assignment ass = GrammarUtil.containingAssignment(ele);
		int index = -2;
		if (ass != null) {
			EStructuralFeature feat = semanticObject.eClass().getEStructuralFeature(ass.getFeature());
			if (feat != null) {
				if (feat.isMany())
					index = ((List<?>) semanticObject.eGet(feat)).indexOf(value);
				else
					index = -1;
			}
		}
		String token = node.getText().trim();
		if (ele instanceof Action) {
			if (((Action) ele).getFeature() != null) {
				if (sequenceAcceptor.enterAssignedAction((Action) ele, (EObject) value, (ICompositeNode) node)) {
					createSequence(ele, (EObject) value);
					sequenceAcceptor.leaveAssignedAction((Action) ele, (EObject) value);
				}
				return true;
			}
		} else if (GrammarUtil.containingCrossReference(ele) != null) {
			if (ele instanceof RuleCall) {
				RuleCall rc = (RuleCall) ele;
				if (rc.getRule() instanceof ParserRule) {
					sequenceAcceptor.acceptAssignedCrossRefDatatype(rc, token, (EObject) value, index,
							(ICompositeNode) node);
					return true;
				}
				if (rc.getRule() instanceof TerminalRule) {
					sequenceAcceptor
							.acceptAssignedCrossRefTerminal(rc, token, (EObject) value, index, (ILeafNode) node);
					return true;
				}
				if (rc.getRule() instanceof EnumRule) {
					sequenceAcceptor.acceptAssignedCrossRefEnum(rc, token, (EObject) value, index,
							(ICompositeNode) node);
					return true;
				}
				//			} else if (ele instanceof Keyword) {
				//				acceptor.acceptAssignedCrossRefKeyword((Keyword) ele, token, (EObject) value, index,(ILeafNode) node);
				//				return true;
			}
		} else if (ass != null) {
			if (ele instanceof RuleCall) {
				RuleCall rc = (RuleCall) ele;
				if (rc.getRule() instanceof ParserRule) {
					if (rc.getRule().getType().getClassifier() instanceof EClass) {
						if (sequenceAcceptor.enterAssignedParserRuleCall(rc, (EObject) value, (ICompositeNode) node)) {
							createSequence(rc.getRule(), (EObject) value);
							sequenceAcceptor.leaveAssignedParserRuleCall(rc, (EObject) value);
						}
					} else
						sequenceAcceptor.acceptAssignedDatatype(rc, token, value, index, (ICompositeNode) node);
					return true;
				}
				if (rc.getRule() instanceof TerminalRule) {
					sequenceAcceptor.acceptAssignedTerminal(rc, token, value, index, (ILeafNode) node);
					return true;
				}
				if (rc.getRule() instanceof EnumRule) {
					sequenceAcceptor.acceptAssignedEnum(rc, token, value, index, (ICompositeNode) node);
					return true;
				}
			} else if (ele instanceof Keyword) {
				if (GrammarUtil.isBooleanAssignment(ass))
					sequenceAcceptor.acceptAssignedKeyword((Keyword) ele, token, true, index, (ILeafNode) node);
				else
					sequenceAcceptor.acceptAssignedKeyword((Keyword) ele, token, (String) value, index,
							(ILeafNode) node);
				return true;
			}
		}
		return false;
	}

	private INode findContextNode(EObject semanticObject) {
		INode node = NodeModelUtils.findActualNodeFor(semanticObject);
		if (node != null) {
			BidiIterator<INode> nodes = node.getAsTreeIterable().iterator();
			while (nodes.hasNext()) {
				INode next = nodes.next();
				if (next.getGrammarElement() instanceof RuleCall)
					return next;
				if (next.getGrammarElement() instanceof ParserRule
						&& ((ParserRule) next.getGrammarElement()).getType().getClassifier() instanceof EClass)
					return next;
			}
		}
		throw new RuntimeException("no context found");
	}

	public Iterable<EObject> findContexts(EObject semanticObject, boolean consultContainer,
			Iterable<EObject> contextCandidates) {
		EObject ctx = findContextNode(semanticObject).getGrammarElement();
		if (ctx instanceof RuleCall)
			return Collections.singletonList((EObject) (((RuleCall) ctx).getRule()));
		return Collections.singletonList(ctx);
	}
}
