/*******************************************************************************
 * Copyright (c) 2019 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.rename

import com.google.inject.Inject
import org.eclipse.xtext.ide.server.rename.RenameService2
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.XtextResource

class TestLanguageRenameService extends RenameService2 {

	@Inject
	extension EObjectAtOffsetHelper

	override protected getElementWithIdentifierAt(XtextResource xtextResource, int offset) {
		if (offset >= 0) {
			val rootNode = xtextResource?.parseResult?.rootNode
			if (rootNode !== null) {
				val leaf = NodeModelUtils.findLeafNodeAtOffset(rootNode, offset)
				if (leaf !== null && leaf.isIdentifier) {
					val element = xtextResource.resolveElementAt(offset)
					if (element !== null) {
						val nameProvider = xtextResource.resourceServiceProvider.get(IQualifiedNameProvider)
						val fqn = nameProvider.getFullyQualifiedName(element)
						if (fqn !== null) {
							val leafText = NodeModelUtils.getTokenText(leaf)
							if ((fqn.segmentCount === 1 && fqn.toString == leafText) || (fqn.lastSegment == leafText)) {
								return element
							}
						}
					}
				}
			}
		}
		return null
	}

}
