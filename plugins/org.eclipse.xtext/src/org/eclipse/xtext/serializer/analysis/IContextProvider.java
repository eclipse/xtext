/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Grammar;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @deprecated see methods of this class for documentation about their replacements
 */
@Deprecated
@ImplementedBy(ContextProvider.class)
public interface IContextProvider {

	/**
	 * @deprecated use {@link IContextPDAProvider#getAllContexts(Grammar)}
	 */
	@Deprecated
	public List<EObject> getAllContexts(Grammar grammar);

	/**
	 * @deprecated use {@link IContextTypePDAProvider#getTypesForContext(Grammar, EObject)}
	 */
	@Deprecated
	public Set<EClass> getTypesForContext(Grammar grammar, EObject context);
}
