/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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