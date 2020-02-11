/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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