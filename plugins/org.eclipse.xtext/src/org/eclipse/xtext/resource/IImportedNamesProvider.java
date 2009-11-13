/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IImportedNamesProvider {
	
	/**
	 * returns the list of names this {@link IImportedNamesProvider}
	 * depends on. 
	 */
	Iterable<String> getImportedNames(Resource resource);
}
