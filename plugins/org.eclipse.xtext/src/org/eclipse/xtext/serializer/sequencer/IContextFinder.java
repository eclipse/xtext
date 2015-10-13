/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.analysis.IContext;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(ContextFinder.class)
public interface IContextFinder {
	Set<IContext> findByContents(EObject semanticObject, Iterable<IContext> contextCandidates);

	Set<IContext> findByContentsAndContainer(EObject semanticObject, Iterable<IContext> contextCandidates);

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
