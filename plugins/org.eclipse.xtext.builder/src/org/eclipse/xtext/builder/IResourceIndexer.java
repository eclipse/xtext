/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import java.util.Set;

import org.eclipse.core.resources.IStorage;


/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IResourceIndexer {

	/**
	 * @param storage
	 * @return the name changes
	 */
	public Set<String> addOrUpdate(IStorage storage);
	
	/**
	 * @param storage
	 * @return the name changes
	 */
	public Set<String> delete(IStorage storage);
}
