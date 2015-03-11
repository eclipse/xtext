/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.linking;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RuntimeLinker extends Linker {

	@Override
	protected boolean isClearAllReferencesRequired(Resource resource) {
		// shaves off a couple of CPU cycles in runtime env.
		return false;
	}
	
}
