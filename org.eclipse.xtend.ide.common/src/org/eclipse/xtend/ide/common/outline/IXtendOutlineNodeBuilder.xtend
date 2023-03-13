/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
 * <p>
 * Builds platform specific outline nodes. 
 * </p>
 * <p>
 * An implementation should not build child nodes. {@link IXtendOutlineTreeBuilder} is responsible for building an outline tree structure. 
 * </p>
 * 
 * @author kosyakov - Initial contribution and API
 * @see IXtendOutlineTreeBuilder
 */
interface IXtendOutlineNodeBuilder {
	
	/**
	 * Builds a platform specific outline node the given model element. 
	 */
	def IXtendOutlineContext buildEObjectNode(EObject modelElement, IXtendOutlineContext context)
	
	/**
	 * Builds a platform specific outline node for the given {@link org.eclipse.xtext.common.types.JvmType jvm type} or its source element. 
	 */
	def IXtendOutlineContext buildXtendNode(EObject modelElement, IXtendOutlineContext context)
	
	/**
	 * Builds a platform specific outline node for the given {@link org.eclipse.xtext.common.types.JvmFeature jvm feature} or its source element.
	 */
	def IXtendOutlineContext buildFeatureNode(JvmDeclaredType inferredType, EObject semanticFeature, IXtendOutlineContext context)
	
	/**
	 * Builds a platform specific outline node for the given {@link org.eclipse.xtext.common.types.JvmFeature dispatcher}.
	 */
	def IXtendOutlineContext buildDispatcherNode(JvmDeclaredType baseType, JvmFeature dispatcher, List<JvmOperation> dispatchCases, IXtendOutlineContext context)
	
	/**
	 * Builds a platform specific outline node for a package of the given {@link org.eclipse.xtend.core.xtend.XtendFile Xtend file}.
	 */
	def IXtendOutlineContext buildPackageNode(XtendFile xtendFile, IXtendOutlineContext context)
	
	/**
	 * Builds a platform specific outline node for an import section of the given {@link org.eclipse.xtend.core.xtend.XtendFile Xtend file}.
	 */
	def IXtendOutlineContext buildImportSectionNode(XtendFile xtendFile, IXtendOutlineContext context)
	
	/**
	 * Builds a platform specific outline node for the given {@link org.eclipse.xtext.xbase.typesystem.override.IResolvedFeature resolved feature}.
	 */
	def IXtendOutlineContext buildResolvedFeatureNode(JvmDeclaredType inferredType, IResolvedFeature resolvedFeature, IXtendOutlineContext context)

}