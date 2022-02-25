/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.tokens;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;

import com.google.inject.ImplementedBy;

/**
 * In the process of serializing a model to a DSL, references to model elements need to be turned into string
 * representations which identify the targeted model element. Implementations of this interface compute this string
 * representation.
 * 
 * Implementations must be synchronous with the DSL's parser implementation.
 * 
 * Implementations might introduce some kind of scoping.
 */
@ImplementedBy(CrossReferenceSerializer.class)
public interface ICrossReferenceSerializer {

	boolean isValid(EObject context, CrossReference crossref, EObject target, INode node,
			ISerializationDiagnostic.Acceptor errorAcceptor);

	String serializeCrossRef(EObject context, CrossReference crossref, EObject target, INode node,
			ISerializationDiagnostic.Acceptor errorAcceptor);
}