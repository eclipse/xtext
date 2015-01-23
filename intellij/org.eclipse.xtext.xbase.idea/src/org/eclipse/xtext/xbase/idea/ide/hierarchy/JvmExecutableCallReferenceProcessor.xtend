/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.ide.hierarchy

import com.google.inject.Inject
import com.intellij.ide.hierarchy.call.CallHierarchyNodeDescriptor
import com.intellij.ide.hierarchy.call.CallReferenceProcessor
import com.intellij.ide.hierarchy.call.JavaCallHierarchyData
import com.intellij.psi.PsiReference
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.psi.XtextPsiReference
import org.eclipse.xtext.xbase.idea.jvmmodel.IPsiLogicalContainerProvider

class JvmExecutableCallReferenceProcessor implements CallReferenceProcessor {
	
	@Inject
	extension IPsiLogicalContainerProvider

	val IXtextLanguage language

	new(IXtextLanguage language) {
		language.injectMembers(this)
		this.language = language
	}

	override process(PsiReference reference, JavaCallHierarchyData data) {
		if (reference instanceof XtextPsiReference) {
			if (reference.element.language != language) {
				return true
			}
			val element = reference.element.nearestLogicalContainer
			val key = CallHierarchyNodeDescriptor.getEnclosingElement(element)
			if (key == null) {
				return true
			}
			val methodToDescriptorMap = data.resultMap
			synchronized (methodToDescriptorMap) {
				var callHierarchyNodeDescriptor = methodToDescriptorMap.get(key) as CallHierarchyNodeDescriptor
				if (callHierarchyNodeDescriptor == null) {
					callHierarchyNodeDescriptor = new CallHierarchyNodeDescriptor(data.project,
						data.nodeDescriptor as CallHierarchyNodeDescriptor, element, false, true)
					methodToDescriptorMap.put(key, callHierarchyNodeDescriptor)
				} else if (!callHierarchyNodeDescriptor.hasReference(reference)) {
					callHierarchyNodeDescriptor.incrementUsageCount
				}
				callHierarchyNodeDescriptor.addReference(reference)
			}
			return false
		}
		return true
	}

}