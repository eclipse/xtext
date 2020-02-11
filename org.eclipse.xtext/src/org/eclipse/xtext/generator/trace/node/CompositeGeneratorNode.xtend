/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.node

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * A composite node does not contribute any output directly, but only through its children.
 * Thus it is an <em>inner</em> node of the code generator tree.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Accessors
class CompositeGeneratorNode implements IGeneratorNode {
	
	val List<IGeneratorNode> children = newArrayList
	
	override toString() '''
		«class.simpleName» {
			«FOR c: children»
				«c.toString»
			«ENDFOR»
		}
	'''
	
}