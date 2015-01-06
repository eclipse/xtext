/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.common.outline

import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmFeature
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.xbase.typesystem.^override.IResolvedFeature

/**
 * @author kosyakov - Initial contribution and API
 */
interface IXtendOutlineNodeBuilder {
	
	def IXtendOutlineContext buildEObjectNode(EObject modelElement, IXtendOutlineContext context)
	def IXtendOutlineContext buildXtendNode(EObject modelElement, IXtendOutlineContext context)
	def IXtendOutlineContext buildFeatureNode(JvmDeclaredType inferredType, JvmFeature jvmFeature, EObject modelElement, IXtendOutlineContext context)
	def IXtendOutlineContext buildDispatcherNode(JvmDeclaredType baseType, JvmFeature dispatcher, List<JvmOperation> dispatchCases, IXtendOutlineContext context)
	def IXtendOutlineContext buildPackageNode(XtendFile xtendFile, IXtendOutlineContext context)
	def IXtendOutlineContext buildImportSectionNode(XtendFile xtendFile, IXtendOutlineContext context)
	def IXtendOutlineContext buildResolvedFeatureNode(JvmDeclaredType inferredType, IResolvedFeature resolvedFeature, IXtendOutlineContext context)

}