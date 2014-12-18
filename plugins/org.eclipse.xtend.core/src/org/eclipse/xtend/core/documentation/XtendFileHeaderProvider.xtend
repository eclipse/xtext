/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.documentation

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.documentation.impl.MultiLineFileHeaderProvider
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.resource.XtextResource

import static java.util.Collections.*

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
class XtendFileHeaderProvider extends MultiLineFileHeaderProvider {

	override getFileHeaderNodes(Resource resource) {
		if (resource instanceof XtextResource) {
			val parseResult = resource.parseResult
			if (parseResult != null) {
				for (leafNode: parseResult.rootNode.leafNodes) {
					var break = true
					val grammarElement = leafNode.grammarElement
					if (grammarElement instanceof TerminalRule) {
						val terminalRuleName = grammarElement.name
						if (ruleName.equalsIgnoreCase(terminalRuleName)) {
							// Don't use the comment as file header if it's already assigned to a type
							if (!leafNode.isTypeComment)
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
	
	private def isTypeComment(ILeafNode leafNode) {
		var INode node = leafNode
		var EObject grammarElement
		do {
			node = node.nextSibling
			grammarElement = node?.grammarElement
		} while (grammarElement instanceof TerminalRule && wsRuleName.equals((grammarElement as TerminalRule).name))
		return node?.parent?.semanticElement instanceof XtendTypeDeclaration
	}
	
}