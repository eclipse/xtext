/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.resource

import com.google.inject.Inject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.service.LanguageSpecific

/**
 * @author kosyakov - Initial contribution and API
 */
class DefaultResourceIdeaServiceProvider implements IResourceIdeaServiceProvider {

	@Inject
	@Delegate
	IResourceServiceProvider delegate

	@Inject
	@LanguageSpecific
	@Accessors(PUBLIC_GETTER)
	IPsiModelAssociations psiModelAssociations

}