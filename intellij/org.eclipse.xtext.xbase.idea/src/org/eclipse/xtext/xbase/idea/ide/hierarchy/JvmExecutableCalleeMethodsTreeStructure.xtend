/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.ide.hierarchy

import com.google.inject.Inject
import com.intellij.ide.hierarchy.HierarchyNodeDescriptor
import com.intellij.ide.hierarchy.HierarchyTreeStructure
import com.intellij.ide.hierarchy.call.CallHierarchyNodeDescriptor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiMethod
import com.intellij.psi.search.searches.OverridingMethodsSearch
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiJvmModelAssociations

import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * @author kosyakov - Initial contribution and API
 */
class JvmExecutableCalleeMethodsTreeStructure extends HierarchyTreeStructure {

	@Inject
	extension IPsiModelAssociations

	@Inject
	extension IPsiJvmModelAssociations

	val String scopeType

	new(Project project, PsiMethod method, String scopeType) {
		super(project, new CallHierarchyNodeDescriptor(project, null, method, true, false))
		(method.language as IXtextLanguage).injectMembers(this)
		this.scopeType = scopeType
	}

	override protected buildChildren(HierarchyNodeDescriptor it) {
		calledMethods + overridingMethods
	}
	
	protected def getOverridingMethods(HierarchyNodeDescriptor descriptor) {
		OverridingMethodsSearch.search(descriptor.method, true).inScope.toDescriptors(descriptor)
	}

	protected def getCalledMethods(HierarchyNodeDescriptor descriptor) {
		val sourceElement = descriptor.method.primarySourceElement.EObject
		if (sourceElement == null) {
			return emptySet
		}
		sourceElement.eAllOfType(XAbstractFeatureCall).map [
			feature
		].filter(JvmExecutable).map [
			psiElement
		].filter(PsiMethod).inScope.toDescriptors(descriptor)
	}
	
	protected def inScope(Iterable<PsiMethod> methods) {
		val baseMethod = (baseDescriptor as CallHierarchyNodeDescriptor).targetElement as PsiMethod
		val baseClass = baseMethod.containingClass
		methods.filter [ method |
			baseClass.isInScope(method, scopeType)
		]
	}

	protected def toDescriptors(Iterable<PsiMethod> methods, HierarchyNodeDescriptor descriptor) {
		val nodeDescriptors = newLinkedHashMap

		for (calledMethod : methods) {
			val nodeDescriptor = nodeDescriptors.get(calledMethod)
			if (nodeDescriptor == null) {
				nodeDescriptors.put(
					calledMethod,
					new CallHierarchyNodeDescriptor(myProject, descriptor, calledMethod, false, false)
				)
			} else {
				nodeDescriptor.incrementUsageCount
			}
		}
		nodeDescriptors.values
	}
	
	protected def getMethod(HierarchyNodeDescriptor descriptor) {
		val method = (descriptor as CallHierarchyNodeDescriptor).enclosingElement
		if (method instanceof PsiMethod) {
			method
		}
	}
}