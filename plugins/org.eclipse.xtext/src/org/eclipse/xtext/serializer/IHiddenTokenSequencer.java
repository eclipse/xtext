package org.eclipse.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.ISyntacticSequencer.ISyntacticSequencerOwner;
import org.eclipse.xtext.serializer.acceptor.IEObjectSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.impl.HiddenTokenSequencer;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(HiddenTokenSequencer.class)
public interface IHiddenTokenSequencer {

	public interface IHiddenTokenSequencerOwner {
		void setHiddenTokenSequencer(IHiddenTokenSequencer sequencer);
	}

	public class PassThroughHiddenTokenSequencer implements IHiddenTokenSequencer, ISyntacticSequencerOwner {

		protected ISyntacticSequencer sequencer;

		public void createSequence(EObject context, EObject semanticObject, INode previousNode,
				IEObjectSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
			sequencer.createSequence(context, semanticObject, previousNode, sequenceAcceptor, errorAcceptor);
		}

		@Inject
		public void setSyntacticSequencer(ISyntacticSequencer sequencer) {
			this.sequencer = sequencer;
		}
	}

	void createSequence(EObject context, EObject semanticObject, INode previousNode,
			IEObjectSequenceAcceptor sequenceAcceptor, ISerializationDiagnostic.Acceptor errorAcceptor);
}