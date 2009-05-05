/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.Stable;
import org.eclipse.xtext.linking.impl.AbstractLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@Stable(since = "0.7.0", subClass = AbstractLinkingService.class)
public interface ILinkingService {

	/**
	 * Returns all {@link EObject}s referenced by the given link text in the
	 * given context. But does not set the references or modifies the passed
	 * information somehow
	 */
	List<EObject> getLinkedObjects(EObject context, EReference reference, AbstractNode node)
			throws IllegalNodeException;

	/**
	 * Returns the textual representation of a given object as it would be
	 * serialized in the given context.
	 * 
	 * @param object
	 * @param reference
	 * @param context
	 * @return the text representation.
	 */
	String getLinkText(EObject object, EReference reference, EObject context);
}
