package org.eclipse.xtext.serializer.sequencer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;

import com.google.inject.ImplementedBy;

@ImplementedBy(GenericSemanticSequencer.class)
public interface ISemanticSequencer {

	void init(ISemanticSequenceAcceptor sequenceAcceptor, ISerializationDiagnostic.Acceptor errorAcceptor);

	void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor,
			ISerializationDiagnostic.Acceptor errorAcceptor);

	void createSequence(EObject context, EObject semanticObject);
}
