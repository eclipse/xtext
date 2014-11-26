package org.eclipse.xtext.idea.resource

import org.eclipse.emf.common.notify.impl.AdapterImpl
import java.util.Map
import com.intellij.lang.ASTNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.emf.ecore.resource.Resource

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*

class PsiToEcoreAdapter extends AdapterImpl {
	
	@Accessors(PUBLIC_GETTER)
	val Map<ASTNode, INode> nodesMapping
	
	new(PsiToEcoreTransformationContext context) {
		nodesMapping = context.nodesMapping
	}
	
	def install(Resource it) {
		eAdapters += this
	}
	
	override isAdapterForType(Object type) {
		class == type
	}
	
	static def get(Resource it) {
		getAdapter(eAdapters, PsiToEcoreAdapter) as PsiToEcoreAdapter
	}
	
}