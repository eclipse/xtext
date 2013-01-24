package org.eclipse.xtext.xbase.jvmmodel

import com.google.common.annotations.Beta
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader

@Beta
class JvmElementsProxifyingUnloader implements IReferableElementsUnloader {
	
	override unloadRoot(EObject root) {
		switch root {
			JvmMember : unloadRecursively(root)	
		}
	}
	
	def protected unloadRecursively(JvmMember element) {
//		Adapters would have to be removed first, because you end up with a StackOverflow if a content adapted is unloaded
//		However, this is disabled, as we are very selectively proxifying elements here, and it isn't sound to remove only half of the adapters.
//		element.eAdapters.clear;
		for (child : element.eContents) {
			switch child {
				JvmMember : {
					unloadRecursively(child)
				}
			}
		}
		(element as InternalEObject).eSetProxyURI(EcoreUtil::getURI(element))
	}
	
}