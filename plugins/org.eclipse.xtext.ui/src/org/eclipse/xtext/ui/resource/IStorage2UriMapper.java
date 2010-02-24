/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IStorage2UriMapper {

	/**
	 * @return IStorages corresponding to the given URI. It will typically be only on {@link IStorage} but in the case
	 *         that the same external class folder or jar is referenced in multiple projects multiple {@link IStorage}s
	 *         are returned.
	 */
	Iterable<IStorage> getStorages(URI uri);

	/**
	 * @return returns the URI for the given {@link IStorage}. 
	 */
	URI getUri(IStorage storage);

}
