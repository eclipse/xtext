/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.analysis.SerializationContext;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractSemanticSequencer implements ISemanticSequencer {

	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;

	protected ISerializationDiagnostic.Acceptor errorAcceptor;

	@Inject
	protected SequenceFeeder.Provider feederProvider;

	protected ISemanticSequencer masterSequencer;

	@Inject
	protected ISemanticNodeProvider nodeProvider;

	protected ISemanticSequenceAcceptor sequenceAcceptor;

	@Inject
	protected ITransientValueService transientValues;

	private final boolean USES_EOBJECT_AS_CONTEXT = usesEObjectAsContext();

	// TODO: deprecate this method
	protected ISerializationContext createContext(EObject deprecatedContext, EObject semanticObject) {
		return SerializationContext.fromEObject(deprecatedContext, semanticObject);
	}

	protected INodesForEObjectProvider createNodeProvider(EObject semanticObject) {
		return nodeProvider.getNodesForSemanticObject(semanticObject, null);
	}

	@Override
	@Deprecated
	public void createSequence(EObject context, EObject semanticObject) {
		throw new UnsupportedOperationException("Either overwrite, or, better, don't call this method.");
	}

	@Override
	public void createSequence(ISerializationContext context, EObject semanticObject) {
		if (USES_EOBJECT_AS_CONTEXT) {
			createSequence(((SerializationContext) context).getActionOrRule(), semanticObject);
		} else {
			sequence(context, semanticObject);
		}
	}

	// TODO: deprecate this method
	@SuppressWarnings("deprecation")
	protected SequenceFeeder createSequencerFeeder(EObject semanticObject) {
		INodesForEObjectProvider nodeProvider = createNodeProvider(semanticObject);
		return feederProvider.create(semanticObject, nodeProvider, masterSequencer, sequenceAcceptor, errorAcceptor);
	}

	// TODO: deprecate this method
	@SuppressWarnings("deprecation")
	protected SequenceFeeder createSequencerFeeder(EObject semanticObject, INodesForEObjectProvider nodeProvider) {
		return feederProvider.create(semanticObject, nodeProvider, masterSequencer, sequenceAcceptor, errorAcceptor);
	}

	protected SequenceFeeder createSequencerFeeder(ISerializationContext context, EObject semanticObject) {
		INodesForEObjectProvider nodeProvider = createNodeProvider(semanticObject);
		return feederProvider.create(context, semanticObject, nodeProvider, masterSequencer, sequenceAcceptor, errorAcceptor);
	}

	protected SequenceFeeder createSequencerFeeder(ISerializationContext context, EObject semanticObject,
			INodesForEObjectProvider nodeProvider) {
		return feederProvider.create(context, semanticObject, nodeProvider, masterSequencer, sequenceAcceptor, errorAcceptor);
	}

	@Override
	public void init(ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		init(this, sequenceAcceptor, errorAcceptor);
	}

	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor,
			ISerializationDiagnostic.Acceptor errorAcceptor) {
		this.masterSequencer = sequencer;
		this.sequenceAcceptor = sequenceAcceptor;
		this.errorAcceptor = errorAcceptor;
	}

	public void sequence(ISerializationContext context, EObject semanticObject) {
	}

	public void setMasterSequencer(ISemanticSequencer sequencer) {
		this.masterSequencer = sequencer;
	}

	private boolean usesEObjectAsContext() {
		Class<?> eObj = null;
		try {
			eObj = getClass().getMethod("createSequence", EObject.class, EObject.class).getDeclaringClass();
		} catch (NoSuchMethodException e) {
			return false;
		} catch (SecurityException e) {
			return false;
		}
		Class<?> iContext = null;
		try {
			iContext = getClass().getMethod("sequence", ISerializationContext.class, EObject.class).getDeclaringClass();
		} catch (NoSuchMethodException e) {
			return true;
		} catch (SecurityException e) {
			return true;
		}
		return iContext.isAssignableFrom(eObj);
	}

}
