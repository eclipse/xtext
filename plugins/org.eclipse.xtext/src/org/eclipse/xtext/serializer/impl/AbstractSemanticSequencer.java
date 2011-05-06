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
import org.eclipse.xtext.serializer.acceptor.SequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractSemanticSequencer implements ISemanticSequencer {

	protected ISerializationDiagnostic.Acceptor errorAcceptor;

	@Inject
	protected ISemanticNodeProvider nodeProvider;

	protected ISemanticSequenceAcceptor sequenceAcceptor;

	@Inject
	protected SequenceAcceptor.Provider sequenceAcceptorProvider;

	protected INodesForEObjectProvider createNodeProvider(EObject semanticObject) {
		return nodeProvider.getNodesForSemanticObject(semanticObject, null);
	}

	protected SequenceAcceptor createSequencerAcceptor(EObject semanticObject) {
		INodesForEObjectProvider nodeProvider = createNodeProvider(semanticObject);
		return sequenceAcceptorProvider.create(semanticObject, nodeProvider, sequenceAcceptor, errorAcceptor);
	}

	protected SequenceAcceptor createSequencerAcceptor(EObject semanticObject, INodesForEObjectProvider nodeProvider) {
		return sequenceAcceptorProvider.create(semanticObject, nodeProvider, sequenceAcceptor, errorAcceptor);
	}

	public void init(ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		this.sequenceAcceptor = sequenceAcceptor;
		this.errorAcceptor = errorAcceptor;
	}

}
