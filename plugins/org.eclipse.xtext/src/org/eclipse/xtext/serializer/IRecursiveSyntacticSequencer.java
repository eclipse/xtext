/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.IRecursiveSyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.impl.RecursiveSyntacticSequencer;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(RecursiveSyntacticSequencer.class)
public interface IRecursiveSyntacticSequencer {
	void createSequence(ISyntacticSequencer syndelegate, ISemanticSequencer semdelegate, EObject context,
			EObject semanticObject, IRecursiveSyntacticSequenceAcceptor sequenceAcceptor,
			ISerializationDiagnostic.Acceptor errorAcceptor);
}
