/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.documentation

import com.google.inject.Inject
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.idea.filesystem.IdeaWorkspaceConfigProvider
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.psi.PsiEObject

import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class IdeaDeclarationDocumentationProvider {

	@Inject IdeaWorkspaceConfigProvider workspaceCfgProvider
	@Inject IQualifiedNameProvider qNameProvider
	@Inject IEObjectDocumentationProvider eObjectDocProvider

	def protected getElementInfo(PsiEObject element) {
		val obj = element.EObject
		val name = qNameProvider.getFullyQualifiedName(obj)
		if (name !== null) {
			return '''<b>«obj.eClass.name» '«name»'</b>'''
		} else {
			val container = obj.allContainers.map[qNameProvider.getFullyQualifiedName(it)].findFirst[it !== null]
			return '''<b>«obj.eClass.name» in '«container»'</b>'''
		}
	}

	def protected getFileInfo(PsiEObject element) {
		val resource = element.EObject.eResource
		val module = workspaceCfgProvider.getWorkspaceConfig(resource.resourceSet).findProjectContaining(resource.URI)
		val uri = resource.URI.deresolve(module.path)
		return '''[«module.name»] «uri»'''
	}

	def String getQuickNavigateInfo(PsiEObject element) '''
		«element.elementInfo»
		«element.fileInfo»
	'''

	def String generateDoc(PsiEObject element) '''
		<p>
			«element.elementInfo»
		</p>
		<br/>
		<p>
			«element.fileInfo»
		</p>
		<br/>
		<p>
			«eObjectDocProvider.getDocumentation(element.EObject)»
		</p>
	'''

}