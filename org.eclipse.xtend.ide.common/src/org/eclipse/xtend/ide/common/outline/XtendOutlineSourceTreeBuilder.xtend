/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.common.outline

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.jvmmodel.DispatchHelper
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmFeature
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendOutlineSourceTreeBuilder extends AbstractXtendOutlineTreeBuilder implements IXtendOutlineTreeBuilder {

	@Inject
	extension DispatchHelper dispatchHelper

	def dispatch void build(XtendFile xtendFile, IXtendOutlineContext context) {
		xtendFile.buildPackageAndImportSection(context)
		xtendFile.xtendTypes.forEach[buildXtendType(context)]
	}

	def dispatch void build(XtendTypeDeclaration xtendType, IXtendOutlineContext context) {
		xtendType.buildMembers(xtendType.inferredType, context)
	}

	protected def void buildXtendType(XtendTypeDeclaration xtendType, IXtendOutlineContext context) {
		val inferredType = xtendType.inferredType
		val xtendTypeContext = xtendType.buildXtendNode(context).markAsProcessed(inferredType)
		xtendType.buildMembers(inferredType, xtendTypeContext)
	}

	protected def void buildMembers(
		XtendTypeDeclaration xtendType,
		JvmDeclaredType inferredType,
		IXtendOutlineContext context
	) {
		if (inferredType !== null) {
			val membersContext = context.newContext
			xtendType.buildMembers(inferredType, inferredType, membersContext)
		} else {
			xtendType.members.forEach[buildEObjectNode(context)]
		}
	}

	protected def void buildMembers(
		XtendTypeDeclaration xtendType,
		JvmDeclaredType inferredType,
		JvmDeclaredType baseType,
		extension IXtendOutlineContext context
	) {
		if (xtendType !== null) {
			for (member : xtendType.members) {
				val jvmElement = member.getPrimaryJvmElement
				if (jvmElement instanceof JvmMember) {
					if (!jvmElement.processed) {
						if (member instanceof XtendTypeDeclaration) {
							member.buildXtendType(
								if (isShowInherited)
									context.newContext
								else
									context
							)
						} else if (jvmElement instanceof JvmFeature) {
							if (!jvmElement.skipFeature) {
								if (jvmElement.dispatchRelated) {
									inferredType.buildDispatchers(baseType, context)
								} else {
									val featureContext = inferredType.buildFeature(
										jvmElement,
										member,
										context
									)
									jvmElement.buildLocalClasses(featureContext)
								}
							}
						}
						jvmElement.markAsProcessed
					}
				}
			}
		}
		if (isShowInherited) {
			inferredType.buildInheritedMembers(context)
		}
	}

	protected def void buildLocalClasses(JvmFeature jvmFeature, IXtendOutlineContext context) {
		if (!jvmFeature.localClasses.empty) {
			for (jvmGenericType : jvmFeature.localClasses) {
				val typeContext = context.newContext
				for (sourceElement : jvmGenericType.sourceElements) {
					sourceElement.buildType(typeContext)
				}
			}
		}
	}

	protected def void buildDispatchers(
		JvmDeclaredType inferredType,
		JvmDeclaredType baseType,
		IXtendOutlineContext context
	) {
		for (dispatcher : inferredType.declaredOperations.filter[dispatcherFunction]) {
			val dispatchCases = dispatcher.getDispatchCases(baseType, context)
			val dispatcherContext = baseType.buildDispatcherNode(
				dispatcher,
				dispatchCases,
				context
			).markAsProcessed(dispatcher)

			for (dispatchCase : dispatchCases) {
				baseType.buildFeature(
					dispatchCase,
					dispatchCase.xtendFunction ?: dispatchCase,
					dispatcherContext
				).markAsProcessed(dispatchCase)
			}
		}
	}

	protected def getDispatchCases(
		JvmOperation dispatcher,
		JvmDeclaredType baseType,
		IXtendOutlineContext context
	) {
		if (context.isShowInherited)
			dispatcher.allDispatchCases
		else
			dispatcher.localDispatchCases.sortWith [ o1, o2 |
				baseType.members.indexOf(o1) - baseType.members.indexOf(o2)
			]
	}

	protected def isDispatchRelated(JvmFeature feature) {
		if (feature instanceof JvmOperation)
			feature.dispatcherFunction || feature.dispatchFunction
	}

	protected override void buildType(EObject someType, IXtendOutlineContext context) {
		if (someType instanceof XtendTypeDeclaration)
			someType.buildXtendType(context)
	}

}