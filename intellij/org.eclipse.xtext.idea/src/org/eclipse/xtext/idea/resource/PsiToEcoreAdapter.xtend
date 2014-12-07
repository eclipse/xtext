package org.eclipse.xtext.idea.resource

import com.intellij.lang.ASTNode
import java.util.List
import java.util.Map
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.nodemodel.INode

import static org.eclipse.emf.ecore.util.EcoreUtil.*
import org.eclipse.xtext.psi.impl.BaseXtextFile

class PsiToEcoreAdapter extends AdapterImpl {
	
	@Accessors(PUBLIC_GETTER)
	val BaseXtextFile xtextFile
	
	@Accessors(PUBLIC_GETTER)
	val Map<ASTNode, INode> nodesMapping

	@Accessors(PUBLIC_GETTER)
	val Map<INode, List<ASTNode>> reverseNodesMapping

	new(PsiToEcoreTransformationContext context) {
		xtextFile = context.xtextFile
		nodesMapping = context.nodesMapping.unmodifiableView
		reverseNodesMapping = context.reverseNodesMapping.unmodifiableView
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