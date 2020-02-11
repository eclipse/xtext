/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.codebuilder

import com.google.common.collect.Lists
import com.google.inject.Inject
import java.util.Collections
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.viewers.StyledString
import org.eclipse.swt.graphics.Image
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions
import org.eclipse.xtext.xbase.compiler.ISourceAppender
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference

/**
 * @author Jan Koehnlein
 */
abstract class AbstractExecutableBuilder extends AbstractCodeBuilder {
	
	public static val DEFAULT_BODY = 'throw new UnsupportedOperationException("TODO: auto-generated method stub")'

	@Inject extension JdtVariableCompletions
	@Inject extension CodeBuilderFactory 

	@Accessors List<AbstractParameterBuilder> parameterBuilders = emptyList
	@Accessors List<LightweightTypeReference> exceptions = emptyList
	@Accessors List<JvmTypeParameter> typeParameters = emptyList
	@Accessors var (ISourceAppender)=>void bodyGenerator
	@Accessors boolean varArgsFlag

	def appendBody(ISourceAppender appendable, String statementSeparator) {
		appendable.append(' {').increaseIndentation.newLine
		if (bodyGenerator !== null)
			bodyGenerator.apply(appendable)
		else
			appendable.append(defaultBody)
		appendable.append(statementSeparator).decreaseIndentation.newLine.append('}')
	}

	def protected String defaultBody() {
		DEFAULT_BODY		
	}

	override setContext(EObject ctx) {
		super.setContext(ctx)
		parameterBuilders.forEach[context = ctx]
	}

	def newParameterBuilder() {
		if(parameterBuilders.empty)
			parameterBuilders = newArrayList
		val builder = createParameterBuilder(owner)
		builder.context = context
		parameterBuilders.add(builder)
		builder
	}

	def protected appendParameters(ISourceAppender appendable) {
		appendable.append("(")
		val notAllowed = newHashSet
		if(!parameterBuilders.isEmpty)
			parameterBuilders.last.varArgsFlag = varArgsFlag
		for (i : 0 ..< parameterBuilders.size) {
			val parameterBuilder = parameterBuilders.get(i)
			val acceptor = new VariableNameAcceptor(notAllowed)
			if(parameterBuilder.name === null) {
				getVariableProposals(parameterBuilder.type.identifier, context,
					JdtVariableCompletions.VariableType.PARAMETER, notAllowed, acceptor)
				parameterBuilder.name = acceptor.variableName
			}
			parameterBuilder.build(appendable)
			if (i != parameterBuilders.size - 1)
				appendable.append(", ")
		}
		appendable.append(")")
	}

	def protected appendThrowsClause(ISourceAppender appendable) {
		val iterator = exceptions.iterator
		if (iterator.hasNext()) {
			appendable.append(" throws ")
			do {
				val typeRef = iterator.next()
				if (typeRef !== null) {
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
	
	override isValid() {
		parameterBuilders.forall[isValid]
		 && !exceptions.contains(null)
		 && !typeParameters.contains(null)
		 && super.isValid
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


