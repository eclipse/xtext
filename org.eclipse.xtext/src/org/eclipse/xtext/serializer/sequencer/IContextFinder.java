/*******************************************************************************
 * Copyright (c) 2011, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.ISerializationContext;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(ContextFinder.class)
public interface IContextFinder {
	Set<ISerializationContext> findByContents(EObject semanticObject, Iterable<ISerializationContext> contextCandidates);

	Set<ISerializationContext> findByContentsAndContainer(EObject semanticObject, Iterable<ISerializationContext> contextCandidates);

	/**
	 * @deprecated use {@link #findByContents(EObject, Iterable)}.
	 */
	@Deprecated
	Iterable<EObject> findContextsByContents(EObject semanticObject, Iterable<EObject> contextCandidates);

	/**
	 * @deprecated use {@link #findByContentsAndContainer(EObject, Iterable)}
	 */
	@Deprecated
	Iterable<EObject> findContextsByContentsAndContainer(EObject semanticObject, Iterable<EObject> contextCandidates);
}
