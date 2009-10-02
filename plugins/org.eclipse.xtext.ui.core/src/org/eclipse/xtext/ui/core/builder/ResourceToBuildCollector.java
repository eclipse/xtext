/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceToBuildCollector implements IResourceDeltaVisitor, IResourceVisitor {

	private Logger log = Logger.getLogger(ResourceToBuildCollector.class);

	private List<ResourceToBuild> resourcesToBuild = new ArrayList<ResourceToBuild>();

	private ResourceSet resourceSet = null;

	public ResourceToBuildCollector(ResourceSet resourceSet) {
		super();
		this.resourceSet = resourceSet;
	}

	public List<ResourceToBuild> getResourcesToBuild() {
		return resourcesToBuild;
	}

	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();
		ILanguageBuilder builder = getLanguageBuilder(resource);
		if (builder == null) {
			return true;
		}
		ResourceToBuild resourceToBuild = new ResourceToBuild(resourceSet, getURI(resource), resource, builder, delta
				.getKind() == IResourceDelta.REMOVED);
		resourcesToBuild.add(resourceToBuild);
		//return true to continue visiting children.
		return true;
	}

	public boolean visit(IResource resource) throws CoreException {
		ILanguageBuilder builder = getLanguageBuilder(resource);
		if (builder != null) {
			ResourceToBuild resourceToBuild = new ResourceToBuild(resourceSet, getURI(resource), resource, builder,
					false);
			resourcesToBuild.add(resourceToBuild);
		}
		return true;
	}

	protected URI getURI(IResource resource) {
		return URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
	}

	protected ILanguageBuilder getLanguageBuilder(IResource resource) {
		if (!(resource instanceof IFile))
			return null;
		String fileExtension = resource.getLocation().getFileExtension();
		if (fileExtension == null)
			return null;
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(
				"org.eclipse.xtext.ui.core.languageBuilder");
		for (IConfigurationElement element : configurationElements) {
			String attribute = element.getAttribute("fileExtensions");
			String[] string = attribute.split(",");
			for (String string2 : string) {
				if (fileExtension.equals(string2.trim()))
					try {
						return (ILanguageBuilder) element.createExecutableExtension("class");
					}
					catch (CoreException e) {
						log.error("Couldn't instantiate ILanguageBuilder for extension " + element.getName(), e);
					}
			}
		}
		return null;
	}

}
