/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.test

import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.web.server.IRequestData

@FinalFieldsConstructor
class MockRequestData implements IRequestData {
	
	val String requestType
	
	@Accessors
	val Map<String, String> parameters
	
	override getMetadata(String key) {
		switch key {
			case 'requestType': requestType
		}
	}
	
}