/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.documentation

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension
import org.eclipse.xtext.documentation.impl.MultiLineFileHeaderProvider
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.resource.XtextResource

import static java.util.Collections.*

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
class XtendFileHeaderProvider extends MultiLineFileHeaderProvider {
	
	@Inject
	IEObjectDocumentationProvider documentationProvider

	override getFileHeaderNodes(Resource resource) {
		if (resource instanceof XtextResource) {
			val parseResult = resource.parseResult
			if (parseResult !== null) {
				for (leafNode: parseResult.rootNode.leafNodes) {
					var break = true
					val grammarElement = leafNode.grammarElement
					if (grammarElement instanceof TerminalRule) {
						val terminalRuleName = grammarElement.name
						if (ruleName.equalsIgnoreCase(terminalRuleName)) {
							// Don't use the comment as file header if it's already assigned to a type
							if (!leafNode.isTypeComment(resource))
								return singletonList(leafNode as INode)
						} else if (wsRuleName.equals(terminalRuleName)) {
							break = false
						}
					}
					if (break) return emptyList
				}
			}
		}
		return emptyList
	}
	
	private def isTypeComment(ILeafNode leafNode, Resource resource) {
		val content = resource.contents.head
		if (content instanceof XtendFile) {
			val type = content.xtendTypes.head
			if (type !== null) {
				if (documentationProvider instanceof IEObjectDocumentationProviderExtension) {
					return leafNode == documentationProvider.getDocumentationNodes(type).head
				}
			}
		}
		return false
	}
	
}