package org.eclipse.xtext.psi.impl

import com.google.common.base.Preconditions
import com.google.inject.Inject
import com.intellij.lang.ASTNode
import com.intellij.psi.stubs.IStubElementType
import com.intellij.util.IncorrectOperationException
import org.eclipse.xtext.psi.PsiEObjectFactory
import org.eclipse.xtext.psi.PsiNamedEObject
import org.eclipse.xtext.psi.stubs.PsiNamedEObjectStub
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType
import org.eclipse.xtext.resource.ILocationInFileProvider

import static extension org.eclipse.xtext.GrammarUtil.*

class PsiNamedEObjectImpl<T extends PsiNamedEObjectStub<?>> extends PsiEObjectImpl<T> implements PsiNamedEObject {

	@Inject
	extension PsiEObjectFactory psiEObjectFactory

	@Inject
	extension ILocationInFileProvider locationInFileProvider

	val IGrammarAwareElementType nameType

	new(T stub, IStubElementType<?, ?> nodeType, IGrammarAwareElementType nameType) {
		super(stub, nodeType)
		Preconditions.checkNotNull(nameType)
		this.nameType = nameType
	}

	new(ASTNode node, IGrammarAwareElementType ... nameTypes) {
		super(node)
		Preconditions.checkArgument(!nameTypes.empty)
		this.nameType = nameTypes.findFirst [ nameType |
			node.findChildByType(nameType) != null
		]
	}

	override getNameIdentifier() {
		val nameNode = findNameNode
		if (nameNode == null) {
			return null
		}
		new PsiEObjectIdentifierImpl(nameNode.psi)
	}

	override getName() {
		val stub = stub
		if (stub != null) {
			return stub.name
		}

		val significantTextRegion = significantTextRegion
		val startIndex = significantTextRegion.offset
		val endIndex = startIndex + significantTextRegion.length
		containingFile.text.substring(startIndex, endIndex)
	}

	override getTextOffset() {
		significantTextRegion.offset
	}

	override PsiNamedEObject setName(String name) throws IncorrectOperationException {
		val nameNode = findNameNode
		if (nameType.grammarElement.terminalRuleCall) {
			val newNameNode = name.createLeafIdentifier(nameNode)
			nameNode.treeParent.replaceChild(nameNode, newNameNode)
		} else {
			val newNameNode = name.createCompositeIdentifier(this.name, nameNode).firstChildNode
			nameNode.replaceAllChildrenToChildrenOf(newNameNode)
		}
		this
	}

	/** 
	 * @return
	 */
	def protected findNameNode() {
		node.findChildByType(nameType)
	}

	/** 
	 * @return
	 */
	def protected getSignificantTextRegion() {
		EObject.significantTextRegion
	}

}
