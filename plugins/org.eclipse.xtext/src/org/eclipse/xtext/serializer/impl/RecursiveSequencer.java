/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.serializer.IHiddenTokenSequencer;
import org.eclipse.xtext.serializer.IHiddenTokenSequencer.IHiddenTokenSequencerOwner;
import org.eclipse.xtext.serializer.IRecursiveSequencer;
import org.eclipse.xtext.serializer.acceptor.IHiddenTokensAcceptor.HiddenTokensDelegator;
import org.eclipse.xtext.serializer.acceptor.IRecursiveSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RecursiveSequencer implements IRecursiveSequencer, IHiddenTokenSequencerOwner {

	protected static class SemanitcAcceptor extends HiddenTokensDelegator implements ISequenceAcceptor {

		protected IRecursiveSequenceAcceptor delegate;

		protected Acceptor errorAcceptor;

		protected IHiddenTokenSequencer syntacticSeq;

		public SemanitcAcceptor(IHiddenTokenSequencer syndelegate, INode lastNode, IRecursiveSequenceAcceptor acceptor,
				Acceptor errors) {
			this.delegate = acceptor;
			this.syntacticSeq = syndelegate;
			this.errorAcceptor = errors;
		}

		public void acceptAssignedAction(Action action, EObject eobject, ICompositeNode node) {
			delegate.enterAssignedAction(action, eobject, node);
			syntacticSeq.createSequence(action, eobject, node, this, errorAcceptor);
			delegate.leaveAssignedAction(action, eobject);
		}

		public void acceptAssignedParserRuleCall(RuleCall ruleCall, EObject semanticChild, ICompositeNode node) {
			delegate.enterAssignedParserRuleCall(ruleCall, semanticChild, node);
			syntacticSeq.createSequence(ruleCall.getRule(), semanticChild, node, this, errorAcceptor);
			delegate.leaveAssignedParserRuleCall(ruleCall);
		}

		public void enterUnassignedParserRuleCall(RuleCall rc) {
			delegate.enterUnassignedParserRuleCall(rc);
		}

		public void finish() {
		}

		public void leaveUnssignedParserRuleCall(RuleCall rc) {
			delegate.leaveUnssignedParserRuleCall(rc);
		}

		@Override
		protected IRecursiveSequenceAcceptor delegate() {
			return delegate;
		}

	}

	protected IHiddenTokenSequencer sequencer;

	public void createSequence(EObject context, EObject semanticObject, IRecursiveSequenceAcceptor sequenceAcceptor,
			Acceptor errorAcceptor) {
		INode node = NodeModelUtils.findActualNodeFor(semanticObject);
		SemanitcAcceptor acceptor = new SemanitcAcceptor(sequencer, node, sequenceAcceptor, errorAcceptor);
		sequencer.createSequence(context, semanticObject, node, acceptor, errorAcceptor);
	}

	@Inject
	public void setHiddenTokenSequencer(IHiddenTokenSequencer sequencer) {
		this.sequencer = sequencer;
	}

}
