/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.node

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Accessors
@EqualsHashCode
class IndentNode extends CompositeGeneratorNode {
	
	String indentationString
	
	new(String indentationString) {
		this.indentationString = indentationString
	}
	
}