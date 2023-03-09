/*******************************************************************************
 * Copyright (c) 2010, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.ui.util.ProjectFactory;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractPluginProjectCreator extends AbstractProjectCreator {

	@Inject
	private Provider<PluginProjectFactory> projectFactoryProvider;
	
	@Override
	protected ProjectFactory configureProjectFactory(ProjectFactory factory) {
		PluginProjectFactory result = (PluginProjectFactory) super.configureProjectFactory(factory);
		
		result.addRequiredBundles(getRequiredBundles());
		result.addExportedPackages(getExportedPackages());
		result.addImportedPackages(getImportedPackages());
		result.setActivatorClassName(getActivatorClassName());
		
		return result;
	}
	
	@Override
	protected PluginProjectFactory createProjectFactory() {
		return projectFactoryProvider.get();
	}
	
	/**
     * @return the names of the exported packages. May not be <code>null</code>
     */
	protected List<String> getExportedPackages() {
        return Collections.emptyList();
    }

	/**
     * @return the names of the imported packages that a new project requires. May not be <code>null</code>
     */
    protected List<String> getImportedPackages() {
        return Lists.newArrayList(
        		"org.apache.log4j", 
        		"org.apache.commons.logging");
    }

    /**
     * @return the class-name of the bundle-activator or <code>null</code>
     */
    protected String getActivatorClassName() {
        return null;
    }
	
    /**
     * @return the names of the bundles that a new project requires. May not be <code>null</code>
     */
	protected List<String> getRequiredBundles() {
		return Lists.newArrayList(
			"org.eclipse.xtext", 
			"org.eclipse.xtext.xtext.generator",
			"de.itemis.xtext.antlr;resolution:=optional",
			"org.eclipse.emf.mwe2.launch;resolution:=optional");
	}

	@Override
	protected String[] getProjectNatures() {
		return new String[] {
			JavaCore.NATURE_ID,
			"org.eclipse.pde.PluginNature", //$NON-NLS-1$
			XtextProjectHelper.NATURE_ID
		};
	}

	@Override
	protected String[] getBuilders() {
		return new String[]{
			JavaCore.BUILDER_ID,
			"org.eclipse.pde.ManifestBuilder",  //$NON-NLS-1$
			"org.eclipse.pde.SchemaBuilder", //$NON-NLS-1$
			XtextProjectHelper.BUILDER_ID
		};
	}

}
