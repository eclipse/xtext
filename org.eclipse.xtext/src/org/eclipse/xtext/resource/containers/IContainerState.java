/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;

/**
 * An {@link IContainerState} represent a set of {@link URI uris} that
 * constitute the contents of a {@link StateBasedContainer container}.
 * Instances of {@link IContainerState} are usually long living and reflect
 * the physical structure of projects and files in a workspace or another
 * file system abstraction, e.g. the class-path of a Java virtual machine.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IContainerState {

	Collection<URI> getContents();
	
	boolean contains(URI uri);

	boolean isEmpty();
	
}
