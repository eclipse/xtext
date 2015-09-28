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

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @deprecated see {@link IContextProvider} for documentation about this classes' replacements.
 */
@Singleton
@Deprecated
public class ContextProvider implements IContextProvider {

	@Inject
	private IContextPDAProvider pdaProvider;

	@Inject
	IContextTypePDAProvider typeProvider;

	@Override
	public List<EObject> getAllContexts(Grammar grammar) {
		return Lists.newArrayList(pdaProvider.getAllContexts(grammar));
	}

	@Override
	public Set<EClass> getTypesForContext(Grammar grammar, EObject context) {
		return typeProvider.getTypesForContext(grammar, context);
	}
}
