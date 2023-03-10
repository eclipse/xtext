/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl.javasupport;

import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @since 2.19
 */
@Singleton
public class SimpleProjectDependencyGraph {

	private final Map<IProject, Set<IProject>> dependencies = Maps.newConcurrentMap();
	
	public void putDependency(IProject project, Set<IProject> dependsOn) {
		dependencies.put(project, dependsOn);
	}

	public Set<IProject> getDependentXtextProjects(IProject project) {
		Set<IProject> result = Sets.newLinkedHashSet();
		for(Map.Entry<IProject, Set<IProject>> entry: dependencies.entrySet()) {
			if (entry.getValue().contains(project)) {
				result.add(entry.getKey());
			}
		}
		return result;
	}

}
