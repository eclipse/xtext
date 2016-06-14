/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext

import org.eclipse.xtext.xtext.generator.model.project.StandardProjectConfig
import org.eclipse.xtext.xtext.generator.model.project.SubProjectConfig

/**
 * @author Christian Schneider - Initial contribution and API
 */
class TestProjectConfig extends StandardProjectConfig {
	
	/**
	 * Put the 'srcGen' classes generated for those test languages that are migrated
	 * to the new generator infrastructure into a separate source folder!
	 */
	override protected computeSrcGen(SubProjectConfig project) {
		return super.computeSrcGen(project) + "2"
	}
}