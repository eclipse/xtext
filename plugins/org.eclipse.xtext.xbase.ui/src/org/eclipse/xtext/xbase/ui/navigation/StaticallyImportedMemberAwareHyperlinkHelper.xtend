/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.navigation

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.text.Region
import org.eclipse.xtext.common.types.xtext.ui.TypeAwareHyperlinkHelper
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor
import org.eclipse.xtext.xbase.imports.StaticallyImportedMemberProvider
import org.eclipse.xtext.xtype.XImportDeclaration

import static org.eclipse.xtext.xtype.XtypePackage.Literals.*

import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.*

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class StaticallyImportedMemberAwareHyperlinkHelper extends TypeAwareHyperlinkHelper {
	
	@Inject
	extension ILocationInFileProvider

	@Inject
	extension StaticallyImportedMemberProvider

	override createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		switch element : EObjectAtOffsetHelper.resolveElementAt(resource, offset) {
			XImportDeclaration case element.static && !element.wildcard: {
				val textRegion = element.getTextRegion(offset)
				if (textRegion != null) {
					val region = new Region(textRegion.offset, textRegion.length)
					for (feature : element.allFeatures) {
						createHyperlinksTo(resource, region, feature, acceptor)
					}
				}
			}
		}
		super.createHyperlinksByOffset(resource, offset, acceptor)
	}

	def getTextRegion(XImportDeclaration it, int offset) {
		val nodes = findNodesForFeature(XIMPORT_DECLARATION__MEMBER_NAME)
		for (node : nodes) {
			val textRegion = node.textRegion
			if (textRegion.contains(offset)) {
				return textRegion
			}
		}
		return null
	}
	
	override protected createHyperlinksTo(XtextResource resource, INode node, EObject target, IHyperlinkAcceptor acceptor) {
		switch element : node.findActualSemanticObjectFor {
			XImportDeclaration case element.static: {
				val textRegion = element.getSignificantTextRegion(XIMPORT_DECLARATION__IMPORTED_TYPE, 0)
				val region = new Region(textRegion.offset, textRegion.length)
				createHyperlinksTo(resource, region, target, acceptor)
			}	
			default: 
				super.createHyperlinksTo(resource, node, target, acceptor)
		}
	}

}
