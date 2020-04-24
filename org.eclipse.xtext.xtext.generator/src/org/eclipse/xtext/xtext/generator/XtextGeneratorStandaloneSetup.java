/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.mwe.utils.ProjectMapping;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xtext.generator.model.project.ISubProjectConfig;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Standalone setup for resolving EMF URIs in the context of the
 * {@link XtextGenerator}. The actual setup is done by {@link StandaloneSetup}.
 */
public class XtextGeneratorStandaloneSetup implements IGuiceAwareGeneratorComponent {
	@Inject
	private IXtextProjectConfig projectConfig;

	private boolean scanClasspath = true;

	@Override
	public void initialize(Injector injector) {
		injector.injectMembers(this);
		setup();
	}

	private void setup() {
		StandaloneSetup delegate = new StandaloneSetup();
		delegate.setScanClassPath(scanClasspath);
		for (Pair<String, String> mapping : getProjectMappings()) {
			ProjectMapping projectMapping = new ProjectMapping();
			projectMapping.setProjectName(mapping.getKey());
			projectMapping.setPath(mapping.getValue());
			delegate.addProjectMapping(projectMapping);
		}
	}

	private Iterable<Pair<String, String>> getProjectMappings() {
		List<Pair<String, String>> result = new ArrayList<>();
		for (ISubProjectConfig cfg : projectConfig.getEnabledProjects()) {
			if (cfg.getName() != null && cfg.getRoot() != null) {
				result.add(Pair.of(cfg.getName(), cfg.getRoot().getPath()));
			}
		}
		return result;
	}

	public boolean isScanClasspath() {
		return scanClasspath;
	}

	public void setScanClasspath(boolean scanClasspath) {
		this.scanClasspath = scanClasspath;
	}
}
