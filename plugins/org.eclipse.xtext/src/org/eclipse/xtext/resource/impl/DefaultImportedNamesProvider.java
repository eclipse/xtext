/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collections;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IImportedNamesProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultImportedNamesProvider implements IImportedNamesProvider {

	/**
	 * TODO: Implement me!
	 */
	public Iterable<String> getImportedNames(Resource resource) {
		return Collections.emptyList();
	}

}
