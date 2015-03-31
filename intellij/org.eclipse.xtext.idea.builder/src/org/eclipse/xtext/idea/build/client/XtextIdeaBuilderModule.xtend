/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.client

import com.google.inject.AbstractModule
import com.google.inject.Scopes
import org.jetbrains.jps.incremental.ModuleLevelBuilder

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtextIdeaBuilderModule extends AbstractModule {

	override protected configure() {
		bind(ModuleLevelBuilder).to(XtextIdeaBuilder).in(Scopes.SINGLETON);
	}
}