/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.IAcceptor;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.7
 */
public interface IDefaultResourceDescriptionStrategyExtension {

	/**
	 * Calculates the {@link IEObjectDescription}s for <code>eObject</code> and passes them to the acceptor.
	 * 
	 * These EObjectdescriptions are only used for global scoping. Not for affection detection.
	 * I.e. it is not necessary to put in any user data to tell that the description has changed. 
	 * 
	 * @return true if the children of <code>eObject</code> should be traversed.
	 */
	boolean createIndexingEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor);
}
