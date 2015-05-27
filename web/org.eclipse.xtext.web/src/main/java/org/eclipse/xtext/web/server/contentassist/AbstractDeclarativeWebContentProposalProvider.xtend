/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.contentassist

import com.google.inject.Inject
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.IGrammarAccess
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.util.IAcceptor

abstract class AbstractDeclarativeWebContentProposalProvider extends WebContentProposalProvider {
	
	@Inject IGrammarAccess grammarAccess
	
	boolean initialized
	Map<String, (AbstractElement, ContentAssistContext, IAcceptor<ContentAssistResult.Entry>)=>void> ruleCallProposalComputers
	Map<Pair<String, String>, (AbstractElement, ContentAssistContext, IAcceptor<ContentAssistResult.Entry>)=>void> assignmentProposalComputers
	
	override dispatch createProposals(RuleCall ruleCall, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		initialize()
		val proposalComputer = ruleCallProposalComputers.get(ruleCall.rule.name)
		if (proposalComputer !== null)
			proposalComputer.apply(ruleCall, context, acceptor)
		else
			super._createProposals(ruleCall, context, acceptor)
	}
	
	override dispatch createProposals(Assignment assignment, ContentAssistContext context,
			IAcceptor<ContentAssistResult.Entry> acceptor) {
		initialize()
		val rule = GrammarUtil.containingRule(assignment)
		val proposalComputer = assignmentProposalComputers.get(rule.name -> assignment.feature)
		if (proposalComputer !== null)
			proposalComputer.apply(assignment, context, acceptor)
		else
			super._createProposals(assignment, context, acceptor)
	}
	
	protected final synchronized def initialize() {
		if (!initialized) {
			ruleCallProposalComputers = newHashMap
			assignmentProposalComputers = newHashMap
			for (method : class.methods) {
				val annot = method.getAnnotation(Proposals)
				if (annot !== null) {
					val rule = GrammarUtil.findRuleForName(grammarAccess.grammar, annot.rule)
					if (rule === null)
						throw new RuntimeException("The grammar rule '" + annot.rule + "' does not exist.")
					if (method.returnType !== Void.TYPE)
						throw new RuntimeException("The method '" + method.name + "' annotated with '" + Proposals.simpleName + "' must have void return type.")
					if (annot.feature.nullOrEmpty) {
						if (ruleCallProposalComputers.containsKey(rule.name))
							throw new RuntimeException("Multiple methods with '" + Proposals.simpleName + "' annotation for the same rule '" + annot.rule + "'")
						val computer = createMethodInvocation(method, RuleCall)
						method.accessible = true
						ruleCallProposalComputers.put(rule.name, computer)
					} else {
						if (!GrammarUtil.containedAssignments(rule).exists[feature == annot.feature]) {
							throw new RuntimeException("The feature '" + annot.feature + "' is not assigned in the grammar rule '" + annot.rule + "'.")
						}
						val key = rule.name -> annot.feature
						if (assignmentProposalComputers.containsKey(key))
							throw new RuntimeException("Multiple methods with '" + Proposals.simpleName + "' annotation for the same feature '" + annot.rule + "." + annot.feature + "'")
						val computer = createMethodInvocation(method, Assignment)
						method.accessible = true
						assignmentProposalComputers.put(key, computer)
					}
				}
			}
			initialized = true
		}
	}
	
	private def createMethodInvocation(Method method, Type elementType) {
		var elementIndex = -1
		var contextIndex = -1
		var acceptorIndex = -1
		var eobjectIndex = -1
		val argumentsLength = method.genericParameterTypes.length
		for (var i = 0; i < argumentsLength; i++) {
			val type = method.genericParameterTypes.get(i)
			if (type instanceof ParameterizedType) {
				if (type.rawType == IAcceptor && type.actualTypeArguments.length == 1
						&& type.actualTypeArguments.get(0) == ContentAssistResult.Entry)
					acceptorIndex = i
				else
					throw new RuntimeException("Unrecognized argument type for method '" + method.name + "' annotated with '" + Proposals.simpleName + "' (index " + i + ")")
			} else if (type == ContentAssistContext)
				contextIndex = i
			else if (type == elementType)
				elementIndex = i
			else if (EObject.isAssignableFrom(type as Class<?>))
				eobjectIndex = i
			else
				throw new RuntimeException("Unrecognized argument type for method '" + method.name + "' annotated with '" + Proposals.simpleName + "' (index " + i + ")")
		}
		createMethodInvocation(method, elementIndex, contextIndex, acceptorIndex, eobjectIndex)
	}
	
	private def (AbstractElement, ContentAssistContext, IAcceptor<ContentAssistResult.Entry>)=>void
			createMethodInvocation(Method method, int elementIndex, int contextIndex, int acceptorIndex, int eobjectIndex) {
		[ element, context, acceptor |
			val Object[] arguments = ArrayLiterals.newArrayOfSize(method.genericParameterTypes.length)
			if (elementIndex >= 0)
				arguments.set(elementIndex, element)
			if (contextIndex >= 0)
				arguments.set(contextIndex, context)
			if (acceptorIndex >= 0)
				arguments.set(acceptorIndex, acceptor)
			if (eobjectIndex >= 0)
				arguments.set(eobjectIndex, context.currentModel)
			method.invoke(this, arguments)
		]
	}
	
}