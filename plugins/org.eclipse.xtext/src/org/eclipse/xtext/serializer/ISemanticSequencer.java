package org.eclipse.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.impl.GenericSemanticSequencer;

import com.google.inject.ImplementedBy;

@ImplementedBy(GenericSemanticSequencer.class)
public interface ISemanticSequencer {

	public interface ISemanticSequencerOwner {
		public void setSemanticSequencer(ISemanticSequencer sequencer);
	}

	void init(ISemanticSequenceAcceptor sequenceAcceptor, ISerializationDiagnostic.Acceptor errorAcceptor);

	/**
	 * An implementation of this interface converts all direct children of a semantic object into a sequence of
	 * (grammarElement, Value)-pairs. Direct children are all values from the EObject's EStructuralFeatures that are not
	 * transient. The sequence of pairs must comply with the order of grammar element as it is defined by the grammar.
	 * The sequence of pairs must be complete in the sense that all rule calls (assigned and unassigned) and all
	 * assigned keywords must appear. The appearance of unassigned keywords is optional.
	 * 
	 * @see ITransientValueService: Is called by the ISequencer to determine values that must not (transient) or should
	 *      not (optional) appear in the output sequence.
	 * 
	 * @param context
	 *            can be an ParserRule or an assigned Action
	 * @param semanticObject
	 *            the EObject from the semantic model that is supposed to be sequenced
	 * @return The following pairs are allowed:
	 * 
	 *         (ParserRuleCall, EObject) for assigned parser rule calls. Unassigned parser rule calls are inlined. The
	 *         ParserRuleCall does not need to be the RuleCall that is contained by the assignment. There area also rule
	 *         calls allowed that this rule call directly delegates to.
	 * 
	 *         (AssignedAction, EObject) for EObjects that have been created by AssignedActions.
	 * 
	 *         (TerminalRuleCall, Value) for assigned and unassigned terminal rule calls.
	 * 
	 *         (DatatypeRuleCall, Value)for assigned and unassigned value rule calls.
	 * 
	 *         (EnumRuleCall, EnumLiteral) for for assigned and unassigned enum rule calls.
	 * 
	 *         (GrammarKeyword, KeywordString) for assigned keywords. Optionally, this is also allowed for unassigned
	 *         keywords.
	 * 
	 *         (TerminalRuleCall, ReferencedEObject) for assigned cross references. Unassigned cross references are not
	 *         allowed by Xtext at all.
	 * 
	 *         (DatatypeRuleCall, ReferencedEObject) for assigned cross references.
	 */
	void createSequence(EObject context, EObject semanticObject);

	Iterable<EObject> findContexts(EObject semanitcObject, boolean consultContainer, Iterable<EObject> contextCandidates);

}
