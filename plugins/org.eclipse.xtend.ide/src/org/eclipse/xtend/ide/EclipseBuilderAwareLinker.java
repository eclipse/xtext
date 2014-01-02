/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide;

import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.linking.Linker;
import org.eclipse.xtend.core.linking.LinkingProxyAwareResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EclipseBuilderAwareLinker extends Linker {

	@Override
	protected boolean isClearReferencesRequired(LinkingProxyAwareResource resource) {
		ResourceSet resourceSet = resource.getResourceSet();
		Map<Object, Object> loadOptions = resourceSet.getLoadOptions();
		boolean notEditor = loadOptions.containsKey(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE)
				|| loadOptions.containsKey(ResourceDescriptionsProvider.LIVE_SCOPE);
		return !notEditor;
	}
	
}
