/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.common.outline

import org.eclipse.xtext.common.types.JvmMember

/**
 * @author kosyakov - Initial contribution and API
 */
interface IXtendOutlineContext {
	
	def IXtendOutlineContext newContext()
	
	def boolean isShowInherited()
	def IXtendOutlineContext showInherited()
	def IXtendOutlineContext hideInherited()
	
	def int getInheritanceDepth()
	def IXtendOutlineContext increaseInheritanceDepth()
	def IXtendOutlineContext decreaseInheritanceDepth()
	
	def boolean isProcessed(JvmMember member)
	def IXtendOutlineContext markAsProcessed(JvmMember member)
	
}