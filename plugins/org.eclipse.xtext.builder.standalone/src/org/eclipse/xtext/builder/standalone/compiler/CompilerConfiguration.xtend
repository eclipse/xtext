/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.compiler

import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@Accessors
class CompilerConfiguration {
	String sourceLevel = "1.5"
	String targetLevel = "1.5"
	boolean verbose
}
