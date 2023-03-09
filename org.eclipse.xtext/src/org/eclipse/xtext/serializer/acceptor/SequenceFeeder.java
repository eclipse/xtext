/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.acceptor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.analysis.SerializationContext;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer;
import org.eclipse.xtext.serializer.tokens.IEnumLiteralSerializer;
import org.eclipse.xtext.serializer.tokens.IKeywordSerializer;
import org.eclipse.xtext.serializer.tokens.IValueSerializer;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SequenceFeeder {

	public static class Provider {
		@Inject
		protected ICrossReferenceSerializer crossRefSerializer;

		@Inject
		protected IEnumLiteralSerializer enumLiteralSerializer;

		@Inject
		protected IKeywordSerializer keywordSerializer;

		@Inject
		protected IValueSerializer valueSerializer;

		/**
		 * @deprecated {@link #create(ISerializationContext, EObject, ISemanticNodeProvider.INodesForEObjectProvider, ISemanticSequencer, ISemanticSequenceAcceptor, ISerializationDiagnostic.Acceptor)}
		 */
		@Deprecated
		public SequenceFeeder create(EObject semanticObject, INodesForEObjectProvider nodes, ISemanticSequencer masterSequencer,
				ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
			return new SequenceFeeder(this, semanticObject, nodes, masterSequencer, sequenceAcceptor, errorAcceptor);
		}

		public SequenceFeeder create(ISerializationContext context, EObject semanticObject, INodesForEObjectProvider nodes,
				ISemanticSequencer masterSequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
			return new SequenceFeeder(this, context, semanticObject, nodes, masterSequencer, sequenceAcceptor, errorAcceptor);
		}
	}

	protected final ISerializationDiagnostic.Acceptor errorAcceptor;

	protected final ISemanticSequencer masterSequencer;

	protected final INodesForEObjectProvider nodes;

	protected final Provider provider;

	protected final EObject semanticObject;

	protected final ISemanticSequenceAcceptor sequenceAcceptor;
	
	protected final ISerializationContext context;
	
	/**
	 * @deprecated {@link #SequenceFeeder(SequenceFeeder.Provider, ISerializationContext, EObject, ISemanticNodeProvider.INodesForEObjectProvider, ISemanticSequencer, ISemanticSequenceAcceptor, ISerializationDiagnostic.Acceptor)}
	 */
	@Deprecated
	protected SequenceFeeder(Provider provider, EObject semanticObject, INodesForEObjectProvider nodes, ISemanticSequencer masterSequencer,
			ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		this(provider, null, semanticObject, nodes, masterSequencer, sequenceAcceptor, errorAcceptor);
	}

	protected SequenceFeeder(Provider provider, ISerializationContext context, EObject semanticObject, INodesForEObjectProvider nodes,
			ISemanticSequencer masterSequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super();
		if (semanticObject == null || nodes == null || sequenceAcceptor == null)
			throw new NullPointerException();
		this.context = context;
		this.provider = provider;
		this.semanticObject = semanticObject;
		this.nodes = nodes;
		this.masterSequencer = masterSequencer;
		this.sequenceAcceptor = sequenceAcceptor;
		this.errorAcceptor = errorAcceptor;
	}

	public void accept(Action action, EObject child) {
		assertAction(action);
		EStructuralFeature ref = getFeature(action.getFeature());
		ICompositeNode node = ref.isMany() ? getCompositeNode(ref, 0, 0, child) : getCompositeNode(ref, child);
		acceptAction(action, child, node);
	}

	public void accept(Action action, EObject semanticChild, ICompositeNode node) {
		assertAction(action);
		acceptAction(action, semanticChild, node);
	}

	public void accept(Action action, EObject child, int indexInNonTransient) {
		assertAction(action);
		EStructuralFeature ref = getFeature(action.getFeature());
		assertIndex(ref, indexInNonTransient);
		ICompositeNode node = getCompositeNode(ref, 0, indexInNonTransient, child);
		acceptAction(action, child, node);
	}

	public void accept(Keyword keyword) {
		Assignment ass = getAssignment(keyword);
		Object value = GrammarUtil.isBooleanAssignment(ass) ? Boolean.TRUE : keyword.getValue();
		EStructuralFeature feature = getFeature(ass.getFeature());
		ILeafNode node = getLeafNode(feature, value);
		String token = getToken(keyword, value, node);
		assertIndex(feature);
		acceptKeyword(ass, keyword, value, token, ISemanticSequenceAcceptor.NO_INDEX, node);
	}

	public void accept(Keyword keyword, Object value) {
		Assignment ass = getAssignment(keyword);
		EStructuralFeature feature = getFeature(ass.getFeature());
		assertIndex(feature);
		assertValue(feature, value);
		ILeafNode node = getLeafNode(feature, value);
		String token = getToken(keyword, value, node);
		acceptKeyword(ass, keyword, value, token, ISemanticSequenceAcceptor.NO_INDEX, node);
	}

	public void accept(Keyword keyword, Object value, ILeafNode node) {
		Assignment ass = getAssignment(keyword);
		EStructuralFeature feature = getFeature(ass.getFeature());
		assertIndex(feature);
		assertValue(feature, value);
		String token = getToken(keyword, value, node);
		acceptKeyword(ass, keyword, value, token, ISemanticSequenceAcceptor.NO_INDEX, node);
	}

	public void accept(Keyword keyword, Object value, int index) {
		Assignment ass = getAssignment(keyword);
		EStructuralFeature feature = getFeature(ass.getFeature());
		assertIndex(feature, index);
		assertValue(feature, value);
		ILeafNode node = getLeafNode(feature, index, index, value);
		String token = getToken(keyword, value, node);
		acceptKeyword(ass, keyword, value, token, index, node);
	}

	public void accept(Keyword keyword, Object value, int index, ILeafNode node) {
		Assignment ass = getAssignment(keyword);
		EStructuralFeature feature = getFeature(ass.getFeature());
		assertIndex(feature, index);
		assertValue(feature, value);
		String token = getToken(keyword, value, node);
		acceptKeyword(ass, keyword, value, token, index, node);
	}

	public void accept(Keyword keyword, Object value, int indexInFeature, int indexInNonTransient) {
		Assignment ass = getAssignment(keyword);
		EStructuralFeature feature = getFeature(ass.getFeature());
		assertIndex(feature, indexInFeature);
		assertIndex(feature, indexInNonTransient);
		assertValue(feature, value);
		ILeafNode node = getLeafNode(feature, indexInFeature, indexInNonTransient, value);
		String token = getToken(keyword, value, node);
		acceptKeyword(ass, keyword, value, token, indexInFeature, node);
	}

	public void accept(Keyword keyword, Object value, String token) {
		Assignment ass = getAssignment(keyword);
		EStructuralFeature feature = getFeature(ass.getFeature());
		assertIndex(feature);
		assertValue(feature, value);
		ILeafNode node = getLeafNode(feature, value);
		acceptKeyword(ass, keyword, value, token, ISemanticSequenceAcceptor.NO_INDEX, node);
	}

	public void accept(Keyword keyword, Object value, String token, ILeafNode node) {
		Assignment ass = getAssignment(keyword);
		EStructuralFeature feature = getFeature(ass.getFeature());
		assertIndex(feature);
		assertValue(feature, value);
		acceptKeyword(ass, keyword, value, token, ISemanticSequenceAcceptor.NO_INDEX, node);
	}

	public void accept(Keyword keyword, Object value, String token, int index) {
		Assignment ass = getAssignment(keyword);
		EStructuralFeature feature = getFeature(ass.getFeature());
		assertIndex(feature, index);
		assertValue(feature, value);
		ILeafNode node = getLeafNode(feature, index, index, value);
		acceptKeyword(ass, keyword, value, token, index, node);
	}

	public void accept(Keyword keyword, Object value, String token, int index, ILeafNode node) {
		Assignment ass = getAssignment(keyword);
		EStructuralFeature feature = getFeature(ass.getFeature());
		assertIndex(feature, index);
		assertValue(feature, value);
		acceptKeyword(ass, keyword, value, token, index, node);
	}

	public void accept(Keyword keyword, Object value, String token, int indexInFeature, int indexInNonTransient) {
		Assignment ass = getAssignment(keyword);
		EStructuralFeature feature = getFeature(ass.getFeature());
		assertIndex(feature, indexInFeature);
		assertIndex(feature, indexInNonTransient);
		assertValue(feature, value);
		ILeafNode node = getLeafNode(feature, indexInFeature, indexInNonTransient, value);
		acceptKeyword(ass, keyword, value, token, indexInFeature, node);
	}

	public void accept(RuleCall rc, Object value) {
		EStructuralFeature feature = getFeature(rc);
		assertIndex(feature);
		assertValue(feature, value);
		INode node = getNode(feature, value);
		String token = getToken(rc, value, node);
		acceptRuleCall(rc, value, token, ISemanticSequenceAcceptor.NO_INDEX, node);
	}

	public void accept(RuleCall rc, Object value, INode node) {
		EStructuralFeature feature = getFeature(rc);
		String token = getToken(rc, value, node);
		assertIndex(feature);
		acceptRuleCall(rc, value, token, ISemanticSequenceAcceptor.NO_INDEX, node);
	}

	public void accept(RuleCall rc, Object value, int index) {
		EStructuralFeature feature = getFeature(rc);
		assertIndex(feature, index);
		assertValue(feature, value);
		INode node = getNode(feature, index, index, value);
		String token = getToken(rc, value, node);
		acceptRuleCall(rc, value, token, index, node);
	}

	public void accept(RuleCall rc, Object value, int index, INode node) {
		EStructuralFeature feature = getFeature(rc);
		assertIndex(feature, index);
		assertValue(feature, value);
		String token = getToken(rc, value, node);
		acceptRuleCall(rc, value, token, index, node);
	}

	public void accept(RuleCall rc, Object value, int indexInFeature, int indexInNonTransient) {
		EStructuralFeature feature = getFeature(rc);
		assertIndex(feature, indexInFeature);
		assertIndex(feature, indexInNonTransient);
		assertValue(feature, value);
		INode node = getNode(feature, indexInFeature, indexInNonTransient, value);
		String token = getToken(rc, value, node);
		acceptRuleCall(rc, value, token, indexInFeature, node);
	}

	public void accept(RuleCall rc, Object value, String token) {
		EStructuralFeature feature = getFeature(rc);
		assertIndex(feature);
		assertValue(feature, value);
		INode node = getNode(feature, value);
		acceptRuleCall(rc, value, token, ISemanticSequenceAcceptor.NO_INDEX, node);
	}

	public void accept(RuleCall rc, Object value, String token, INode node) {
		EStructuralFeature feature = getFeature(rc);
		assertIndex(feature);
		assertValue(feature, value);
		acceptRuleCall(rc, value, token, ISemanticSequenceAcceptor.NO_INDEX, node);
	}

	public void accept(RuleCall rc, Object value, String token, int index) {
		EStructuralFeature feature = getFeature(rc);
		assertIndex(feature, index);
		assertValue(feature, value);
		INode node = getNode(feature, index, index, value);
		acceptRuleCall(rc, value, token, index, node);
	}

	public void accept(RuleCall rc, Object value, String token, int index, INode node) {
		EStructuralFeature feature = getFeature(rc);
		assertIndex(feature, index);
		assertValue(feature, value);
		acceptRuleCall(rc, value, token, index, node);
	}

	public void accept(RuleCall rc, Object value, String token, int indexInFeature, int indexInNonTransient) {
		EStructuralFeature feature = getFeature(rc);
		assertIndex(feature, indexInFeature);
		assertValue(feature, value);
		INode node = getNode(feature, indexInFeature, indexInNonTransient, value);
		acceptRuleCall(rc, value, token, indexInFeature, node);
	}

	protected void acceptAction(Action action, EObject semanticChild, ICompositeNode node) {
		if (sequenceAcceptor.enterAssignedAction(action, semanticChild, node)) {
			ISerializationContext child = SerializationContext.forChild(context, action, semanticChild);
			masterSequencer.createSequence(child, semanticChild);
			sequenceAcceptor.leaveAssignedAction(action, semanticChild);
		}
	}

	protected void acceptEObjectRuleCall(RuleCall ruleCall, EObject semanticChild, ICompositeNode node) {
		if (sequenceAcceptor.enterAssignedParserRuleCall(ruleCall, semanticChild, node)) {
			ISerializationContext child = SerializationContext.forChild(context, ruleCall, semanticChild);
			masterSequencer.createSequence(child, semanticChild);
			sequenceAcceptor.leaveAssignedParserRuleCall(ruleCall, semanticChild);
		}
	}

	protected void acceptKeyword(Assignment ass, Keyword keyword, Object value, String token, int index, ILeafNode node) {
		CrossReference crossRef = GrammarUtil.containingCrossReference(keyword);
		if (crossRef != null)
			sequenceAcceptor.acceptAssignedCrossRefKeyword(keyword, token, (EObject) value, index, node);
		else
			sequenceAcceptor.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	protected void acceptRuleCall(RuleCall rc, Object value, String token, int index, INode node) {
		CrossReference crossRef = GrammarUtil.containingCrossReference(rc);
		if (crossRef != null) {
			if (rc.getRule() instanceof ParserRule)
				sequenceAcceptor.acceptAssignedCrossRefDatatype(rc, token, (EObject) value, index,
						getCompositeNode(node));
			else if (rc.getRule() instanceof TerminalRule)
				sequenceAcceptor.acceptAssignedCrossRefTerminal(rc, token, (EObject) value, index, getLeafNode(node));
			else if (rc.getRule() instanceof EnumRule)
				sequenceAcceptor.acceptAssignedCrossRefEnum(rc, token, (EObject) value, index, getCompositeNode(node));
		} else {
			if (rc.getRule() instanceof ParserRule) {
				AbstractRule rule = rc.getRule();
				if (rule.getType() != null && rule.getType().getClassifier() instanceof EClass)
					acceptEObjectRuleCall(rc, (EObject) value, getCompositeNode(node));
				else
					sequenceAcceptor.acceptAssignedDatatype(rc, token, value, index, getCompositeNode(node));
			} else if (rc.getRule() instanceof TerminalRule)
				sequenceAcceptor.acceptAssignedTerminal(rc, token, value, index, getLeafNode(node));
			else if (rc.getRule() instanceof EnumRule)
				sequenceAcceptor.acceptAssignedEnum(rc, token, value, index, getCompositeNode(node));
		}
	}

	protected void assertAction(Action action) {
		if (action.getFeature() == null)
			throw new RuntimeException("Only assigned actions are allowed.");
	}

	protected void assertIndex(EStructuralFeature feature) {
		if (feature.isMany())
			throw new RuntimeException(feature.eClass().getName() + "." + feature.getName()
					+ " is a multi-value-feature, therefore it needs an index.");
	}

	protected void assertIndex(EStructuralFeature feature, int index) {
		if (feature.isMany()) {
			if (index < 0)
				throw new RuntimeException(feature.eClass().getName() + "." + feature.getName()
						+ " is a multi-value-feature, therefore the index should be larger than 0. index: " + index);
		} else {
			if (index > 0)
				throw new RuntimeException(feature.eClass().getName() + "." + feature.getName()
						+ " is a single-value-feature, therefore it can not have an index larger than 0. index: "
						+ index);
		}
	}

	protected void assertValue(EStructuralFeature feature, Object value) {
		if (value != null && !feature.getEType().isInstance(value)) {
			String valueType = value.getClass().getSimpleName();
			String featureName = feature.eClass().getName() + "." + feature.getName();
			String msg = "The value of type '" + valueType + "' can not be assigned to feature " + featureName
					+ " of type  '" + feature.getEType().getName() + "'.";
			throw new RuntimeException(msg);
		}
	}

	public void finish() {
		sequenceAcceptor.finish();
	}

	protected Assignment getAssignment(AbstractElement ele) {
		Assignment ass = GrammarUtil.containingAssignment(ele);
		if (ass == null)
			throw new RuntimeException("Only Assigned " + ele.eClass().getName() + "s are allowed");
		return ass;
	}

	protected ICompositeNode getCompositeNode(EStructuralFeature feature, int indexInFeature, int indexInNonTransient,
			Object child) {
		INode node = nodes.getNodeForMultiValue(feature, indexInFeature, indexInNonTransient, child);
		if (node instanceof ICompositeNode)
			return (ICompositeNode) node;
		return null;
	}

	protected ICompositeNode getCompositeNode(EStructuralFeature feature, Object child) {
		INode node = nodes.getNodeForSingelValue(feature, child);
		if (node instanceof ICompositeNode)
			return (ICompositeNode) node;
		return null;
	}

	protected ICompositeNode getCompositeNode(INode node) {
		if (node instanceof ICompositeNode)
			return (ICompositeNode) node;
		return null;
	}

	protected EStructuralFeature getFeature(RuleCall rc) {
		return getFeature(getAssignment(rc).getFeature());
	}

	protected EStructuralFeature getFeature(String name) {
		EStructuralFeature feature = semanticObject.eClass().getEStructuralFeature(name);
		if (feature == null)
			throw new RuntimeException("Feature '" + name + "' not found in EClass '"
					+ semanticObject.eClass().getName() + "'");
		return feature;
	}

	protected ILeafNode getLeafNode(EStructuralFeature feature, int indexInFeature, int indexInNonTransient,
			Object child) {
		INode node = nodes.getNodeForMultiValue(feature, indexInFeature, indexInNonTransient, child);
		if (node instanceof ILeafNode)
			return (ILeafNode) node;
		return null;
	}

	protected ILeafNode getLeafNode(EStructuralFeature feature, Object child) {
		INode node = nodes.getNodeForSingelValue(feature, child);
		if (node instanceof ILeafNode)
			return (ILeafNode) node;
		return null;
	}

	protected ILeafNode getLeafNode(INode node) {
		if (node instanceof ILeafNode)
			return (ILeafNode) node;
		return null;
	}

	protected INode getNode(EStructuralFeature feature, int indexInFeature, int indexInNonTransient, Object child) {
		return nodes.getNodeForMultiValue(feature, indexInFeature, indexInNonTransient, child);
	}

	protected INode getNode(EStructuralFeature feature, Object child) {
		return nodes.getNodeForSingelValue(feature, child);
	}

	protected String getToken(Keyword keyword, Object value, ILeafNode node) {
		CrossReference crossRef = GrammarUtil.containingCrossReference(keyword);
		if (crossRef != null)
			return provider.crossRefSerializer.serializeCrossRef(semanticObject, crossRef, (EObject) value, node,
					errorAcceptor);
		return provider.keywordSerializer.serializeAssignedKeyword(semanticObject, keyword, value, node, errorAcceptor);
	}

	protected String getToken(RuleCall rc, Object value, INode node) {
		CrossReference crossRef = GrammarUtil.containingCrossReference(rc);
		Assignment assignment = GrammarUtil.containingAssignment(rc);
		if (crossRef != null)
			return provider.crossRefSerializer.serializeCrossRef(semanticObject, crossRef, (EObject) value, node,
					errorAcceptor);
		else if (GrammarUtil.isEObjectRuleCall(rc) || GrammarUtil.isBooleanAssignment(assignment))
			return null;
		else if (GrammarUtil.isEnumRuleCall(rc))
			return provider.enumLiteralSerializer.serializeAssignedEnumLiteral(semanticObject, rc, value, node,
					errorAcceptor);
		else
			return provider.valueSerializer.serializeAssignedValue(semanticObject, rc, value, node, errorAcceptor);
	}
}
