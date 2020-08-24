/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.mwe.utils.DirectoryCleaner;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.model.project.ISubProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;

import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * This component cleans all directories for generated code according to the
 * project configuration (usually 'src-gen' for plain layout and
 * 'src/main/xtext-gen' for Maven/Gradle layout).
 * 
 * @noextend This class should not be extended by clients.
 */
public class XtextDirectoryCleaner implements IGuiceAwareGeneratorComponent {
	@Inject
	private IXtextProjectConfig config;

	private boolean enabled = true;

	private boolean useDefaultExcludes = true;

	private List<String> excludes = new ArrayList<>();

	private List<String> extraDirectories = new ArrayList<>();

	public void addExtraDirectory(String directory) {
		extraDirectories.add(directory);
	}

	public void addExclude(String exclude) {
		excludes.add(exclude);
	}

	public void clean() {
		if (!enabled) {
			return;
		}
		ArrayList<String> directories = new ArrayList<>();
		Iterable<IXtextGeneratorFileSystemAccess> fsas = Iterables.concat(
				Lists.transform(config.getEnabledProjects(), ISubProjectConfig::getSrcGen),
				Lists.newArrayList(config.getRuntime().getEcoreModel()));
		Iterables.addAll(directories, FluentIterable.from(fsas).filter(Predicates.notNull())
				.transform(IXtextGeneratorFileSystemAccess::getPath).filter(it -> new File(it).isDirectory()));
		Iterables.addAll(directories, extraDirectories);
		DirectoryCleaner delegate = new DirectoryCleaner();
		delegate.setUseDefaultExcludes(useDefaultExcludes);
		excludes.forEach(it -> delegate.addExclude(it));
		for (String it : directories) {
			try {
				delegate.cleanFolder(it);
			} catch (FileNotFoundException e) {
				throw Exceptions.sneakyThrow(e);
			}
		}
	}

	@Override
	public void initialize(Injector injector) {
		injector.injectMembers(this);
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setUseDefaultExcludes(boolean useDefaultExcludes) {
		this.useDefaultExcludes = useDefaultExcludes;
	}
}
