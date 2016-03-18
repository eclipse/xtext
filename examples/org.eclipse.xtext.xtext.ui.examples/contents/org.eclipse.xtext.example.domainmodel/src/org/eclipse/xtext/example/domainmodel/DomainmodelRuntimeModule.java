/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel;

import org.eclipse.xtext.findReferences.TargetURICollector;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelTargetURICollector;
import org.eclipse.xtext.xbase.resource.BatchLinkableResourceStorageFacade;


/**
 * used to register components to be used within the IDE.
 */
public class DomainmodelRuntimeModule extends AbstractDomainmodelRuntimeModule {
	
	public Class<? extends IResourceStorageFacade> bindResourceStorageFacade() {
		return BatchLinkableResourceStorageFacade.class;
	}

	public Class<? extends TargetURICollector> bindTargetURICollector() {
		return JvmModelTargetURICollector.class;
	}

}
