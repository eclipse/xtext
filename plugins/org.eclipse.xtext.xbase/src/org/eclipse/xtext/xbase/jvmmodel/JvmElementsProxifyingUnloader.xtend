package org.eclipse.xtext.xbase.jvmmodel

import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader
import com.google.common.annotations.Beta

@Beta
class JvmElementsProxifyingUnloader implements IReferableElementsUnloader {
	
	override unloadRoot(EObject root) {
		val List<JvmMember> toBeProxified = newLinkedList()
		switch root {
			JvmMember : unloadRecursively(root, toBeProxified)	
		}
		for (toProxify : toBeProxified) {
			(toProxify as InternalEObject).eSetProxyURI(EcoreUtil::getURI(toProxify))			
		}
	}
	
	def protected unloadRecursively(JvmMember element, List<JvmMember> toBeProxified) {
		toBeProxified.add(element)
		for (child : element.eContents) {
			switch child {
				JvmMember : {
					unloadRecursively(child, toBeProxified)
				}
			}
		}
	}
	
}