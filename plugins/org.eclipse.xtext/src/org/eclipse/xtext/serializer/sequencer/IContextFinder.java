/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(ContextFinder.class)
public interface IContextFinder {
	Iterable<EObject> findContextsByContents(EObject semanticObject, Iterable<EObject> contextCandidates);

	Iterable<EObject> findContextsByContentsAndContainer(EObject semanticObject, Iterable<EObject> contextCandidates);
}
