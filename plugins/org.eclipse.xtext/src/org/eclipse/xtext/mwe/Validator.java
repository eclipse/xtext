/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowInterruptedException;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider.Registry;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Validator {
	
	private boolean validateAll = true;

	public void setValidateAll(boolean validateAll) {
		this.validateAll = validateAll;
	}

	private boolean stopOnError = true;

	public void setStopOnError(boolean stopOnError) {
		this.stopOnError = stopOnError;
	}
	
	public boolean isStopOnError() {
		return stopOnError;
	}
	
	public boolean isValidateAll() {
		return validateAll;
	}
	
	public void validate(ResourceSet resourceSet, IResourceServiceProvider.Registry registry, Issues issues) {
		List<Resource> resources = Lists.newArrayList(resourceSet.getResources());
		for (Resource resource : resources) {
			try {
				resource.load(null);
				IResourceServiceProvider provider = registry.getResourceServiceProvider(resource.getURI(), null);
				if (provider!=null) {
					List<Issue> result = provider.getResourceValidator().validate(resource, CheckMode.ALL, null);
					for (Issue issue : result) {
						switch (issue.getSeverity()) {
							case ERROR :
								issues.addError(issue.getMessage(), issue);
								break;
							case WARNING :
								issues.addWarning(issue.getMessage(), issue);
								break;
							case INFO :
								issues.addInfo(issue.getMessage(), issue);
								break;
						}
					}
				}
			} catch (IOException e) {
				throw new WorkflowInterruptedException("Couldn't load resource ("+resource.getURI()+")",e);
			}
		}
		if (isStopOnError() && issues.hasErrors()) {
			throw new WorkflowInterruptedException("Validation errors.");
		}
	}
	
	public static class Disabled extends Validator {
		@Override
		public void validate(ResourceSet resourceSet, Registry registry, Issues issues) {
			// do nothing
		}
	}
	
}
