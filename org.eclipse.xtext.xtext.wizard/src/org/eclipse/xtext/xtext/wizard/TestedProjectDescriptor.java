/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;

public abstract class TestedProjectDescriptor extends ProjectDescriptor {
	public abstract TestProjectDescriptor getTestProject();

	public TestedProjectDescriptor(final WizardConfiguration config) {
		super(config);
	}

	@Override
	public Set<ExternalDependency> getExternalDependencies() {
		Set<ExternalDependency> deps = new LinkedHashSet<>();
		Iterables.addAll(deps, super.getExternalDependencies());
		if (getTestProject().isInlined()) {
			Iterables.addAll(deps, getTestProject().getExternalDependencies());
		}
		return deps;
	}

	@Override
	public Set<SourceFolderDescriptor> getSourceFolders() {
		Set<SourceFolderDescriptor> sourceFolders = new LinkedHashSet<>();
		Iterables.addAll(sourceFolders, super.getSourceFolders());
		if (getTestProject().isInlined()) {
			Iterables.addAll(sourceFolders, getTestProject().getSourceFolders());
		}
		return sourceFolders;
	}

	@Override
	public Iterable<? extends AbstractFile> getFiles() {
		List<AbstractFile> files = new ArrayList<>();
		Iterables.addAll(files, super.getFiles());
		if (getTestProject().isInlined()) {
			Iterable<? extends AbstractFile> filtered = IterableExtensions.filter(getTestProject().getFiles(),
					(AbstractFile fileFromTestProject) -> files.stream()
							.noneMatch(f -> Objects.equal(f.getRelativePath(), fileFromTestProject.getRelativePath())));
			Iterables.addAll(files, filtered);
		}
		return files;
	}

}
