package org.eclipse.xtend.macro.lang.resource

import org.eclipse.xtend.core.resource.XtendResourceDescriptionStrategy
import com.google.common.collect.ImmutableMap$Builder
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.macro.lang.macro.MacroAnnotation
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

class MacroResourceDescriptionStrategy extends XtendResourceDescriptionStrategy {
	
	override protected createUserData(EObject eObject, Builder<String,String> userData) {
		switch eObject {
			MacroAnnotation : {
				userData.put('hash', 'hash_' + NodeModelUtils::getNode(eObject)?.text?.hashCode)
			}
		}
		super.createUserData(eObject, userData)
	}
	
}