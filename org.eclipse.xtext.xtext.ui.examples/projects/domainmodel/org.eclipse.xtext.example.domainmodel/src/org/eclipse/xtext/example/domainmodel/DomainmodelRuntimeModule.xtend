/** 
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel

import org.eclipse.xtext.resource.persistence.IResourceStorageFacade
import org.eclipse.xtext.xbase.resource.BatchLinkableResourceStorageFacade

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class DomainmodelRuntimeModule extends AbstractDomainmodelRuntimeModule {
	def Class<? extends IResourceStorageFacade> bindResourceStorageFacade() {
		return BatchLinkableResourceStorageFacade
	}
}
