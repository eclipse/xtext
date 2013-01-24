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
		for (child : element.eContents) {
			switch child {
				JvmMember : {
					unloadRecursively(child)
				}
			}
		}
		element.eAdapters.clear;
		(element as InternalEObject).eSetProxyURI(EcoreUtil::getURI(element))
	}
	
}