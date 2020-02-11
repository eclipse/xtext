/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.linking;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class RuntimeLinker extends Linker {

	@Override
	protected boolean isClearAllReferencesRequired(Resource resource) {
		// shaves off a couple of CPU cycles in runtime env.
		return false;
	}
	
}
