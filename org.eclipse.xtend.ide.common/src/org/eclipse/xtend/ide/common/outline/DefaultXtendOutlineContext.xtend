/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.common.outline

import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmMember

/**
 * @author kosyakov - Initial contribution and API
 */
@Accessors
class DefaultXtendOutlineContext implements IXtendOutlineContext {

	int inheritanceDepth
	boolean showInherited
	Set<JvmMember> processedMembers

	new() {
		inheritanceDepth = 0
		showInherited = false
		processedMembers = newHashSet
	}

	override newContext() {
		cloneContext => [
			processedMembers = newHashSet
		]
	}

	override showInherited() {
		if (showInherited)
			this
		else
			cloneContext => [
				showInherited = true
			]
	}

	override hideInherited() {
		if (!showInherited)
			this
		else
			cloneContext => [
				showInherited = false
			]
	}

	override increaseInheritanceDepth() {
		cloneContext => [
			inheritanceDepth++
		]
	}

	override decreaseInheritanceDepth() {
		if (inheritanceDepth == 0) {
			this
		} else {
			cloneContext => [
				inheritanceDepth--
			]
		}
	}

	override isProcessed(JvmMember member) {
		processedMembers.contains(member)
	}

	override markAsProcessed(JvmMember member) {
		processedMembers += member
		this
	}

	protected def cloneContext() {
		cloneContext(new DefaultXtendOutlineContext)
	}

	protected def cloneContext(DefaultXtendOutlineContext clonedContext) {
		clonedContext.inheritanceDepth = inheritanceDepth
		clonedContext.showInherited = showInherited
		clonedContext.processedMembers = processedMembers
		clonedContext
	}

}