/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.collect.Lists;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.11
 */
public class TopologicalSorter {
	protected static class Entry {
		private final ProjectDescription description;

		private boolean marked;

		private boolean cyclic;

		@Override
		public String toString() {
			return description.getName();
		}

		public Entry(ProjectDescription description) {
			this.description = description;
		}
	}

	private LinkedHashSet<ProjectDescription> result;

	private Map<String, TopologicalSorter.Entry> name2entry;

	private IAcceptor<ProjectDescription> cyclicAcceptor;

	public List<ProjectDescription> sortByDependencies(Iterable<ProjectDescription> descriptions,
			Procedure1<? super ProjectDescription> cyclicAcceptor) {
		this.cyclicAcceptor = cyclicAcceptor::apply;
		name2entry = new LinkedHashMap<>();
		for (ProjectDescription project : descriptions) {
			Entry entry = new TopologicalSorter.Entry(project);
			name2entry.put(entry.description.getName(), entry);
		}
		result = new LinkedHashSet<>();
		name2entry.values().forEach(it -> visit(it));
		return Lists.newArrayList(result);
	}

	protected boolean visit(TopologicalSorter.Entry current) {
		if (!result.contains(current.description) && !current.cyclic) {
			if (current.marked) {
				markCyclic(current);
				return false;
			}
			current.marked = true;
			for (String it : current.description.getDependencies()) {
				TopologicalSorter.Entry depEntry = name2entry.get(it);
				if (depEntry != null && !visit(depEntry)) {
					markCyclic(current);
					return false;
				}
			}
			current.marked = false;
			result.add(current.description);
		}
		return true;
	}

	protected void markCyclic(TopologicalSorter.Entry it) {
		if (!it.cyclic) {
			it.cyclic = true;
			cyclicAcceptor.accept(it.description);
		}
	}
}
