/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.persistence;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
public class StorageAwareResourceDescriptionManager extends DefaultResourceDescriptionManager {
	@Override
	public IResourceDescription getResourceDescription(Resource resource) {
		if (resource instanceof StorageAwareResource) {
			IResourceDescription result = ((StorageAwareResource) resource).getResourceDescription();
			if (result != null) {
				return result;
			}
		}
		return super.getResourceDescription(resource);
	}
}
