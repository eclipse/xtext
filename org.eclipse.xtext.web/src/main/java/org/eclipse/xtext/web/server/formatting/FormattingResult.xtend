/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.formatting

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.ToString
import org.eclipse.xtext.util.TextRegion
import org.eclipse.xtext.web.server.IServiceResult

/**
 * Result object returned by the formatting service.
 */
@Data
@ToString(skipNulls = true)
class FormattingResult implements IServiceResult {
	
	String stateId
	
	String formattedText
	
	TextRegion replaceRegion
	
}