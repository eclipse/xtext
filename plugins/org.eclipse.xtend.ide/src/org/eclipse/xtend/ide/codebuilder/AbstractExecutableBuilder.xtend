package org.eclipse.xtend.ide.codebuilder

import com.google.common.collect.Lists
import com.google.inject.Inject
import java.util.Collections
import java.util.List
import java.util.Set
import org.eclipse.jface.viewers.StyledString
import org.eclipse.swt.graphics.Image
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions
import org.eclipse.xtext.xbase.compiler.IAppendable
import static org.eclipse.xtext.common.types.JvmVisibility.*
import org.eclipse.xtext.common.types.JvmTypeParameter

/**
 * @author Jan Koehnlein
 */
abstract class AbstractExecutableBuilder extends AbstractCodeBuilder {

	@Inject extension JdtVariableCompletions

	@Property List<String> parameterNames = emptyList
	@Property List<JvmTypeReference> parameterTypes = emptyList
	@Property List<JvmTypeReference> exceptions = emptyList
	@Property List<JvmTypeParameter> typeParameters = emptyList
	@Property String body

	def appendBody(IAppendable appendable, String statementSeparator) {
		appendable.append(' {').increaseIndentation.newLine.append(body ?: defaultBody).append(statementSeparator).
			decreaseIndentation.newLine.append('}')
	}

	def protected String defaultBody() {
		'throw new UnsupportedOperationException("TODO: auto-generated method stub")'
	}

	def protected appendParameters(IAppendable appendable) {
		if (!parameterNames.empty && parameterNames.size != parameterTypes.size)
			throw new IllegalStateException("Number of parameter names and types must match")
		appendable.append("(")
		val notAllowed = <String>newHashSet()

		for (i : 0 ..< parameterTypes.size) {
			val typeRef = parameterTypes.get(i)
			if (typeRef != null) {
				appendable.appendType(typeRef, "Object")
				appendable.append(" ")
				if (parameterNames.empty) {
					val acceptor = new VariableNameAcceptor(notAllowed)
					getVariableProposals(typeRef.identifierOrObject, context,
						JdtVariableCompletions.VariableType.PARAMETER, notAllowed, acceptor)
					appendable.append(acceptor.getVariableName())
				} else {
					appendable.append(parameterNames.get(i))
				}
			}
			if (i != parameterTypes.size - 1)
				appendable.append(", ")
		}
		appendable.append(")")
	}

	def protected appendThrowsClause(IAppendable appendable) {
		val iterator = exceptions.iterator
		if (iterator.hasNext()) {
			appendable.append(" throws ")
			do {
				val typeRef = iterator.next()
				if (typeRef != null) {
					appendable.appendType(typeRef, "Exception")
				}
				if (iterator.hasNext())
					appendable.append(", ")
			} while (iterator.hasNext())
		}
		appendable
	}

	override getImage() {
		switch visibility {
			case PRIVATE: 'methpri_obj.gif'
			case PROTECTED: 'methpro_obj.gif'
			case PUBLIC: 'methpub_obj.gif'
			default: 'methdef_obj.gif'
		}
	}

}

class VariableNameAcceptor implements JdtVariableCompletions.CompletionDataAcceptor {

	val Set<String> notallowed
	val Set<String> variableNames = newHashSet()

	new(Set<String> notallowed) {
		this.notallowed = notallowed;
	}

	override accept(String replaceText, StyledString label, Image img) {
		variableNames.add(replaceText);
		notallowed.add(replaceText);
	}

	def getVariableName() {
		val candidates = Lists.newArrayList(variableNames);
		Collections.sort(candidates, [left, right|left.length() - right.length()])
		if (candidates.size > 0)
			return candidates.get(0)
		return ""
	}
}
