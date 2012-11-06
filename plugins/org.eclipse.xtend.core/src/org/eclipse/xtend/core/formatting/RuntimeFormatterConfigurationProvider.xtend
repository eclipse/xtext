/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.formatting

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider

/**
 * @author Dennis Huebner - Initial contribution and API
 * @author Moritz Eysholdt
 */
class RuntimeFormatterConfigurationProvider implements IFormatterConfigurationProvider {

	@Inject XtendFormatterConfigKeys keys;
	@Inject IWhitespaceInformationProvider whitespaceInfo

	override IConfigurationValues getFormatterConfiguration(Resource resource) {
		val cfg = new MapBasedConfigurationValues(keys)
		val indentationInfo = whitespaceInfo.getIndentationInformation(resource.URI)
		val lineSeparatorInfo = whitespaceInfo.getLineSeparatorInformation(resource.URI)
		cfg.put(keys.lineSeparator, lineSeparatorInfo.lineSeparator)
		cfg.put(keys.indentation, indentationInfo.indentString)
		cfg.put(keys.indentationLength, 4) // TODO: read from preferences
		cfg
	}

}
