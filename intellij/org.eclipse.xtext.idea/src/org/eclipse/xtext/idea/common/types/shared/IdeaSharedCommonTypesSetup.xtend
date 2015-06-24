/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.common.types.shared

import com.google.inject.Guice
import org.eclipse.xtext.ISetup
import org.eclipse.xtext.idea.extensions.EcoreGlobalRegistries

/**
 * @author kosyakov - Initial contribution and API
 */
class IdeaSharedCommonTypesSetup implements ISetup {
	
	override createInjectorAndDoEMFRegistration() {
		EcoreGlobalRegistries.ensureInitialized();
		Guice.createInjector(new IdeaSharedCommonTypesModule)
	}
	
}