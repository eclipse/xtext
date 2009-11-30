/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(DefaultUriUtil.class)
public interface IUriUtil {
	
	/**
	 * computes an EMF URI for the given IStorage.
	 * @return the uri, or null if the given {@link IStorage} is not an EMF resource.
	 */
	URI getUri(IStorage storage);
	
}
