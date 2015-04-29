/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.daemon

import com.google.inject.Singleton
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.build.net.ObjectChannel
import com.google.inject.ImplementedBy

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(IBuildSessionSingletons.Impl)
interface IBuildSessionSingletons {
	
	def ObjectChannel getObjectChannel()
	
	def String getModuleBaseURL()

	@Singleton
	@Accessors	
	class Impl implements IBuildSessionSingletons {
		ObjectChannel objectChannel
		String moduleBaseURL
	} 
}