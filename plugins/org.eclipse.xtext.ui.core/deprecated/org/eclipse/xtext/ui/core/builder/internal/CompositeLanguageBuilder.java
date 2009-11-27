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
import org.eclipse.xtext.ui.core.builder.impl.ISharedState;

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

	public IProject[] build(ISharedState sharedState, int kind, IProgressMonitor monitor) throws CoreException {
		Set<IProject> all = new HashSet<IProject>();

		for (ILanguageBuilder lb : getLanguageBuilders()) {
			try {
				IProject[] projects = lb.build(sharedState, kind, monitor);
				all.addAll(Arrays.asList(projects));
			} catch (Exception e) {
				log.error("Error invoking 'build' on language builder '" + lb + "' " + e.getMessage(), e);
			}
		}
		return all.toArray(new IProject[all.size()]);
	}

	public void clean(IProgressMonitor monitor) throws CoreException {
		for (ILanguageBuilder lb : getLanguageBuilders()) {
			try {
				lb.clean(monitor);
			} catch (Exception e) {
				log.error("Error invoking 'clean' on language builder '" + lb + "' " + e.getMessage(), e);
			}
		}
	}

	public void postBuild(ISharedState sharedState, int kind, IProgressMonitor monitor) throws CoreException {
		for (ILanguageBuilder lb : getLanguageBuilders()) {
			try {
				lb.postBuild(sharedState, kind, monitor);
			} catch (Exception e) {
				log.error("Error invoking 'postBuild' on language builder '" + lb + "' " + e.getMessage(), e);
			}
		}
	}

	public void initialize(IBuilderAccess builderAccess) {
		for (ILanguageBuilder lb : getLanguageBuilders()) {
			try {
				lb.initialize(builderAccess);
			} catch (Exception e) {
				log.error("Error invoking 'initialize' on language builder '" + lb + "' " + e.getMessage(), e);
			}
		}
	}

}
