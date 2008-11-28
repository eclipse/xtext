/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossrefs;

import java.util.Set;

/**
 * used to register components to be used at runtime.
 */
public class ImportUriTestLanguageRuntimeConfig extends AbstractImportUriTestLanguageRuntimeConfig {

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> generated = super.registrations();
		return generated;
	}

}
			
