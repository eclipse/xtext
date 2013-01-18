/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions
import org.eclipse.xtext.xbase.compiler.IAppendable
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer

/** 
 * @author Jan Koehnlein
 */
abstract class AbstractCodeBuilder implements ICodeBuilder {

	@Property Object ownerSource
	@Property JvmDeclaredType owner
	@Property JvmVisibility visibility
	@Property EObject context
	
	@Inject extension JdtVariableCompletions
	
	override preview() {
		val appendable = new StringBuilderBasedAppendable
		appendable.append('...').newLine.build.newLine.append('...')
		appendable.toString
	}
	
	def protected appendVisibility(IAppendable appendable, JvmVisibility visibility, JvmVisibility defaultVisibility) {
		appendable.append(
			switch visibility {
				case defaultVisibility: ''
				case JvmVisibility::PRIVATE: 'private '
				case JvmVisibility::PROTECTED: 'protected '
				case JvmVisibility::PUBLIC: 'public '
				default: ''
			})
	}

	def protected appendType(IAppendable appendable, JvmTypeReference typeRef, String surrogate) {
		if (typeRef == null) {
			appendable.append(surrogate)
		} else {
			typeReferenceSerializer.serialize(typeRef, context, appendable)
		}
		appendable
	}
	
	def protected TypeReferenceSerializer getTypeReferenceSerializer()
	
	def protected appendParameters(IAppendable appendable, List<JvmTypeReference> parameterTypes) {
		val iterator = parameterTypes.iterator
		appendable.append("(")
		val notAllowed = <String>newHashSet()

		while (iterator.hasNext()) {
			val typeRef = iterator.next()
			if (typeRef != null) {
				appendable.appendType(typeRef, "Object")
				appendable.append(" ")
				val acceptor = new VariableNameAcceptor(notAllowed)
				getVariableProposals(typeRef.getIdentifier(), context, 
					JdtVariableCompletions$VariableType::PARAMETER, notAllowed, acceptor)
				appendable.append(acceptor.getVariableName())
			}
			if (iterator.hasNext())
				appendable.append(", ")
		}
		appendable.append(")")
	}

	def protected isInterface(JvmType t) {
		switch t {
			JvmGenericType: t.interface
			default: false
		}
	}
}

class VariableNameAcceptor implements JdtVariableCompletions$CompletionDataAcceptor {

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
		val candidates = Lists::newArrayList(variableNames);
		Collections::sort(candidates,
			[ left, right | left.length() - right.length() ])
		if (candidates.size > 0)
			return candidates.get(0)
		return ""
	}
}

