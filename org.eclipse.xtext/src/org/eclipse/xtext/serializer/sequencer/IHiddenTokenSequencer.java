package org.eclipse.xtext.serializer.sequencer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(HiddenTokenSequencer.class)
public interface IHiddenTokenSequencer {

	public interface IHiddenTokenSequencerOwner {
		void setHiddenTokenSequencer(IHiddenTokenSequencer sequencer);
	}

	/**
	 * @deprecated use {@link #init(ISerializationContext, EObject, ISequenceAcceptor, ISerializationDiagnostic.Acceptor)}
	 */
	@Deprecated
	void init(EObject context, EObject semanticObject, ISequenceAcceptor sequenceAcceptor,
			ISerializationDiagnostic.Acceptor errorAcceptor);

	void init(ISerializationContext context, EObject semanticObject, ISequenceAcceptor sequenceAcceptor,
			ISerializationDiagnostic.Acceptor errorAcceptor);
}