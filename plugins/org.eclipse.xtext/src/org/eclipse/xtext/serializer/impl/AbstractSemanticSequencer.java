/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.ISemanticNodeProvider;
import org.eclipse.xtext.serializer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.ISemanticSequencer;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractSemanticSequencer implements ISemanticSequencer {

	protected ISerializationDiagnostic.Acceptor errorAcceptor;

	protected ISemanticSequencer masterSequencer;

	@Inject
	protected ISemanticNodeProvider nodeProvider;

	protected ISemanticSequenceAcceptor sequenceAcceptor;

	@Inject
	protected SequenceFeeder.Provider sequenceFeederProvider;

	protected INodesForEObjectProvider createNodeProvider(EObject semanticObject) {
		return nodeProvider.getNodesForSemanticObject(semanticObject, null);
	}

	protected SequenceFeeder createSequencerFeeder(EObject semanticObject) {
		INodesForEObjectProvider nodeProvider = createNodeProvider(semanticObject);
		return sequenceFeederProvider.create(semanticObject, nodeProvider, masterSequencer, sequenceAcceptor,
				errorAcceptor);
	}

	protected SequenceFeeder createSequencerFeeder(EObject semanticObject, INodesForEObjectProvider nodeProvider) {
		return sequenceFeederProvider.create(semanticObject, nodeProvider, masterSequencer, sequenceAcceptor,
				errorAcceptor);
	}

	public void init(ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		init(this, sequenceAcceptor, errorAcceptor);
	}

	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor,
			ISerializationDiagnostic.Acceptor errorAcceptor) {
		this.masterSequencer = sequencer;
		this.sequenceAcceptor = sequenceAcceptor;
		this.errorAcceptor = errorAcceptor;
	}

	public void setMasterSequencer(ISemanticSequencer sequencer) {
		this.masterSequencer = sequencer;
	}

}
