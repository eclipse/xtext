package org.eclipse.xtext.serializer.sequencer;

import org.eclipse.emf.ecore.EObject;
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

	void init(EObject context, EObject semanticObject, ISyntacticSequenceAcceptor sequenceAcceptor,
			ISerializationDiagnostic.Acceptor errorAcceptor);
}