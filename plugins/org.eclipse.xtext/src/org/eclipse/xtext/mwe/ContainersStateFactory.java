/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.containers.ResourceSetBasedAllContainersState;

import com.google.common.collect.Multimap;

public class ContainersStateFactory {
	public IAllContainersState getContainersState(List<String> paths, Multimap<String, URI> uris) {
		ResourceSetBasedAllContainersState containersState = new ResourceSetBasedAllContainersState();
		containersState.configure(paths, uris);
		return containersState;
	}
}