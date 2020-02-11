/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.adapter

import org.eclipse.xpand2.output.OutputImpl
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend2.lib.StringConcatenation

/**
 * @since 2.9
 */
@Deprecated
class StringConcatOutputImpl extends OutputImpl {
	
	public static val STRING_OUTLET = 'StringConcatOutputImpl.StringOutlet'
	
	@Accessors(PUBLIC_GETTER)
	StringConcatenation stringOutlet
	
	override openFile(String path, String outletName) {
		if (outletName == STRING_OUTLET)
			stringOutlet = new StringConcatenation
		else
			super.openFile(path, outletName)
	}
	
	override closeFile() {
		if (stringOutlet !== null)
			stringOutlet = null
		else
			super.closeFile()
	}
	
	override write(String bytes) {
		if (stringOutlet !== null)
			stringOutlet.append(bytes)
		else
			super.write(bytes)
	}
	
}