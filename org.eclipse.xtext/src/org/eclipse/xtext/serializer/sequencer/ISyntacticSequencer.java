/*******************************************************************************
 * Copyright (c) 2011,2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(GenericSyntacticSequencer.class)
public interface ISyntacticSequencer {

	public interface ISyntacticSequencerOwner {
		void setSyntacticSequencer(ISyntacticSequencer sequencer);
	}

	/**
	 * @deprecated use {@link #init(ISerializationContext, EObject, ISyntacticSequenceAcceptor, ISerializationDiagnostic.Acceptor)}
	 */
	@Deprecated
	void init(EObject context, EObject semanticObject, ISyntacticSequenceAcceptor sequenceAcceptor,
			ISerializationDiagnostic.Acceptor errorAcceptor);

	void init(ISerializationContext context, EObject semanticObject, ISyntacticSequenceAcceptor sequenceAcceptor,
			ISerializationDiagnostic.Acceptor errorAcceptor);
}