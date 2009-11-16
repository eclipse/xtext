/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.linking.impl.ImportedNamesAdapter;
import org.eclipse.xtext.resource.IImportedNamesProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public class DefaultImportedNamesProvider implements IImportedNamesProvider {

	public Iterable<String> getImportedNames(Resource resource) {
		Set<String> names = new HashSet<String>();
		ImportedNamesAdapter adapter = ImportedNamesAdapter.find(resource);
		if (adapter!=null)
			names.addAll(adapter.getImportedNames());
		return names;
	}

}
