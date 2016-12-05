/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.debug

import com.google.inject.Inject
import com.intellij.debugger.SourcePosition
import com.intellij.debugger.engine.SourcePositionProvider
import com.intellij.debugger.impl.DebuggerContextImpl
import com.intellij.debugger.ui.tree.NodeDescriptor
import com.intellij.openapi.project.Project
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.psi.impl.LeafXtextPsiElement
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.xbase.XbasePackage

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XtendSourcePositionProvider extends SourcePositionProvider {
	
	@Inject IScopeProvider scopeProvider
	
	new() {
		XtendLanguage.INSTANCE.injectMembers(this)
	}
	
	override protected computeSourcePosition(NodeDescriptor descriptor, Project project, DebuggerContextImpl context, boolean nearest) {
		return getOriginalIfExists(context, descriptor.name)
	}
	
	protected def getOriginalIfExists(DebuggerContextImpl context, String name) {
		val ele = context.contextElement
		if (ele instanceof LeafXtextPsiElement) {
			val eobj = ele.INode.semanticElement
			if (eobj === null) {
				return null;
			}
			val scope = scopeProvider.getScope(eobj, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE)
			val element = scope.getSingleElement(QualifiedName.create(name))
			if (element !== null && element.EObjectOrProxy.eResource == eobj.eResource) {
				val node = NodeModelUtils.getNode(element.EObjectOrProxy)
				if (node !== null) {
					val offset = node.offset
					return SourcePosition.createFromOffset(ele.xtextFile, offset)
				}
			}
		}
		return null
	}
	
}