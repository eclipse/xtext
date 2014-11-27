package org.eclipse.xtext.psi.impl

import com.google.inject.Inject
import com.intellij.lang.ASTFactory
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiBuilderFactory
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.TokenType
import com.intellij.psi.impl.source.DummyHolderFactory
import com.intellij.psi.impl.source.tree.RecursiveTreeElementVisitor
import com.intellij.psi.impl.source.tree.TreeElement
import com.intellij.psi.stubs.IStubElementType
import com.intellij.util.IncorrectOperationException
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.parser.antlr.ITokenDefProvider
import org.eclipse.xtext.parser.antlr.TokenSourceProvider
import org.eclipse.xtext.psi.PsiNamedEObject
import org.eclipse.xtext.psi.stubs.PsiNamedEObjectStub
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType
import org.eclipse.xtext.resource.ILocationInFileProvider

import static org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder.LOOK_AHEAD_KEY

import static extension com.intellij.psi.impl.source.codeStyle.CodeEditUtil.*
import static extension java.util.regex.Pattern.*
import static extension org.eclipse.xtext.GrammarUtil.isTerminalRuleCall
import static extension org.eclipse.xtext.parser.antlr.TokenTool.*

class PsiNamedEObjectImpl<T extends PsiNamedEObjectStub<?>> extends PsiEObjectImpl<T> implements PsiNamedEObject {

	@Inject
	extension ITokenDefProvider tokenDefProvider

	@Inject
	extension ParserDefinition parserDefinition

	@Inject
	extension TokenSourceProvider tokenSourceProvider

	@Inject
	extension ILocationInFileProvider locationInFileProvider

	val IGrammarAwareElementType nameType

	new(T stub, IStubElementType<?, ?> nodeType, IGrammarAwareElementType nameType) {
		super(stub, nodeType)
		this.nameType = nameType
	}
	
	new(ASTNode node, IGrammarAwareElementType nameType) {
		super(node)
		this.nameType = nameType
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
		if (nameType.getGrammarElement().terminalRuleCall) {
			val newNameNode = name.createLeaf
			nameNode.treeParent.replaceChild(nameNode, newNameNode)
		} else {
			val newNameNode = name.parseName.firstChildNode
			nameNode.replaceAllChildrenToChildrenOf(newNameNode)
		}
		this
	}

	protected def createLeaf(String name) {
		name.assertToken
		ASTFactory.leaf(nameType, name) => [
			nodeGenerated = true
		]
	}

	protected def parseName(String name) {
		val builder = name.createNameBuilder
		val contentElement = project.createParser.parse(nameType, builder) as TreeElement => [
			assertNode
			nodeGeneratedRecursively = true
		]
		DummyHolderFactory.createHolder(manager, contentElement, context).treeElement
	}

	protected def createNameBuilder(String name) {
		val nameNode = findNameNode
		val text = nameNode.text.replaceFirst(this.name.quote, name)
		PsiBuilderFactory.instance.createBuilder(parserDefinition, project.createLexer, text) => [
			putUserData(LOOK_AHEAD_KEY, nameNode.getUserData(LOOK_AHEAD_KEY))
		]
	}

	/** 
	 * @param treeElement
	 */
	def protected void assertNode(TreeElement treeElement) {
		treeElement.acceptTree([ TreeElement element |
			if (element.elementType == TokenType.ERROR_ELEMENT) {
				val errorElement = element as PsiErrorElement
				throw new IncorrectOperationException(errorElement.getErrorDescription());
			}
			true
		] as RecursiveTreeElementVisitor)
	}

	/** 
	 * @param name
	 */
	def protected void assertToken(String name) {
		val ruleCall = nameType.grammarElement as RuleCall
		val ruleName = ruleCall.rule.name
		val tokenSource = name.createTokenSource
		var token = tokenSource.nextToken
		if (name != token.text) {
			throw new IncorrectOperationException('''The value '«»«name»' is an invalid «ruleName»'''.toString);
		}

		val lexerRuleName = tokenDefMap.get(token.type).lexerRuleName
		if (ruleName != lexerRuleName) {
			throw new IncorrectOperationException('''The value '«»«name»' is an invalid «ruleName»'''.toString);
		}
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
