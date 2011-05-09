package org.eclipse.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.impl.HiddenTokenSequencer;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(HiddenTokenSequencer.class)
public interface IHiddenTokenSequencer {

	public interface IHiddenTokenSequencerOwner {
		void setHiddenTokenSequencer(IHiddenTokenSequencer sequencer);
	}

	//	public class PassThroughHiddenTokenSequencer implements IHiddenTokenSequencer, ISyntacticSequencerOwner {
	//
	//		protected ISyntacticSequencer sequencer;
	//
	//		public void createSequence(EObject context, EObject semanticObject, INode previousNode,
	//				IEObjectSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
	//			sequencer.createSequence(context, semanticObject, previousNode, sequenceAcceptor, errorAcceptor);
	//		}
	//
	//		@Inject
	//		public void setSyntacticSequencer(ISyntacticSequencer sequencer) {
	//			this.sequencer = sequencer;
	//		}
	//	}

	void init(EObject context, EObject semanticObject, ISequenceAcceptor sequenceAcceptor,
			ISerializationDiagnostic.Acceptor errorAcceptor);
}