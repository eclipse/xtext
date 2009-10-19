/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ui.core.builder.IBuilderAccess;
import org.eclipse.xtext.ui.core.builder.ILanguageBuilder;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompositeLanguageBuilder implements ILanguageBuilder {

	private static Logger log = Logger.getLogger(CompositeLanguageBuilder.class);

	protected List<ILanguageBuilder> languageBuilders = null;

	protected synchronized List<ILanguageBuilder> getLanguageBuilders() {
		if (languageBuilders == null) {
			languageBuilders = new ArrayList<ILanguageBuilder>();
			IConfigurationElement[] configurationElements = Platform.getExtensionRegistry()
					.getConfigurationElementsFor("org.eclipse.xtext.ui.core.languageBuilder");
			for (IConfigurationElement element : configurationElements) {
				try {
					ILanguageBuilder builder = (ILanguageBuilder) element.createExecutableExtension("class");
					languageBuilders.add(builder);
				} catch (CoreException e) {
					log.error("Error loading extension " + element, e);
				}
			}
		}
		return languageBuilders;
	}

	public IProject[] build(int kind, IProgressMonitor monitor) throws CoreException {
		Set<IProject> all = new HashSet<IProject>();
		for (ILanguageBuilder lb : getLanguageBuilders()) {
			IProject[] projects = lb.build(kind, monitor);
			all.addAll(Arrays.asList(projects));
		}
		return all.toArray(new IProject[all.size()]);
	}

	public void clean(IProgressMonitor monitor) throws CoreException {
		for (ILanguageBuilder lb : getLanguageBuilders()) {
			lb.clean(monitor);
		}
	}

	public void postBuild(int kind, IProgressMonitor monitor) throws CoreException {
		for (ILanguageBuilder lb : getLanguageBuilders()) {
			lb.postBuild(kind, monitor);
		}
	}

	public void initialize(IBuilderAccess builderAccess) {
		for (ILanguageBuilder lb : getLanguageBuilders()) {
			lb.initialize(builderAccess);
		}
	}

}
