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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.common.collect.Lists;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class UriBasedReader extends AbstractReader {

	private List<String> uris = Lists.newArrayList();
	private List<URI> uris2 = Lists.newArrayList();

	public void addUri(String uri) {
		this.uris.add(uri);
	}

	@Override
	protected void checkConfigurationInternal(Issues issues) {
		super.checkConfigurationInternal(issues);
		if (uris.isEmpty())
			issues.addError(this, "No resource uri configured (property 'uri')");
		for (String uri : uris) {
			try {
				uris2.add(URI.createURI(uri));
			} catch (Exception e) {
				issues.addError(this, "Invalid URI '" + uri + "' (" + e.getMessage() + ")");
			}
		}
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		ResourceSet resourceSet = getResourceSet();
		for (URI uri : uris2) {
			Resource resource = resourceSet.getResource(uri, true);
			int numberResources;
			do {
				numberResources = resourceSet.getResources().size();
				EcoreUtil.resolveAll(resource);
			} while (numberResources!=resourceSet.getResources().size());
		}
		getValidator().validate(resourceSet, getRegistry(), issues);
		addModelElementsToContext(ctx, resourceSet);
	}

	public void setClasspathURIContext(Object class1) {
		final XtextResourceSet resourceSet = new XtextResourceSet();
		resourceSet.setClasspathURIContext(class1);
		setResourceSetProvider(new Provider<ResourceSet>() {
			
			@Override
			public ResourceSet get() {
				return resourceSet;
			}
		});
	}

}
