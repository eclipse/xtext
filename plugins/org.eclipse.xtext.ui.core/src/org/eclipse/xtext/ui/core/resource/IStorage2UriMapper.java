/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.resource;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * TODO reuse instance created by shared infrastructure 
 */
@ImplementedBy(Storage2UriMapperJavaImpl.class)
public interface IStorage2UriMapper {
	
	Iterable<IStorage> getStorages(URI uri);
	
	URI getUri(IStorage storage);
}
