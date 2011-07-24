/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;

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
	protected SequenceFeeder.Provider feederProvider;

	protected INodesForEObjectProvider createNodeProvider(EObject semanticObject) {
		return nodeProvider.getNodesForSemanticObject(semanticObject, null);
	}

	protected SequenceFeeder createSequencerFeeder(EObject semanticObject) {
		INodesForEObjectProvider nodeProvider = createNodeProvider(semanticObject);
		return feederProvider.create(semanticObject, nodeProvider, masterSequencer, sequenceAcceptor,
				errorAcceptor);
	}

	protected SequenceFeeder createSequencerFeeder(EObject semanticObject, INodesForEObjectProvider nodeProvider) {
		return feederProvider.create(semanticObject, nodeProvider, masterSequencer, sequenceAcceptor,
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
