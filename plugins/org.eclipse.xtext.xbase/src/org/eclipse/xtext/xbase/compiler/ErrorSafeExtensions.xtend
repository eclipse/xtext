/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
 package org.eclipse.xtext.xbase.compiler

import javax.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmCompoundTypeReference
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.util.AbstractTypeReferenceVisitor
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.util.OnChangeEvictingCache
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.compiler.output.ErrorTreeAppendable

/** 
 * @author Jan Koehnlein
 */
class ErrorSafeExtensions {
	
	@Inject extension TypeReferenceSerializer 

	@Inject OnChangeEvictingCache cache

	def Iterable<Issue> getErrors(EObject element, boolean includeContents) {
		val IElementIssueProvider issueProvider = cache.get(typeof(IElementIssueProvider).name, element.eResource, [|null])
		if(issueProvider==null)
			<Issue>emptyList
		else 
			issueProvider.getIssues(element, includeContents).filter[it.severity == Severity::ERROR]
	}
	
	def appendSafely(ITreeAppendable appendable, EObject element, (ITreeAppendable)=>void generator) {
		appendSafely(appendable, element, null, generator)
	}
	
	def appendSafely(ITreeAppendable appendable, EObject element, String surrogateCode, (ITreeAppendable)=>void generator) {
		val issues = element.getErrors(true)
		if(issues.empty) {
			appendable => generator
		} else {
			val errorChild = appendable.errorChild(element)
			try {
				errorChild => generator
			} catch (Exception ignoreMe) {}
			if(surrogateCode != null)
				appendable.append(surrogateCode);
		}
	}
	
	def <T extends EObject> void forEachSafely(ITreeAppendable appendable, Iterable<T> elements, 
			(LoopParams)=>void loopInitializer, 
			(T, ITreeAppendable)=>void generator) {
		if(elements.empty)
			return
		val loopParams = new LoopParams => loopInitializer
		val allElementsBroken = elements.filter[!it.getErrors(true).empty].size == elements.size
		var currentAppendable = if(allElementsBroken) 
				appendable.errorChild(elements.head)
			else 
				appendable
		loopParams.appendPrefix(currentAppendable)
		var isFirst = true
		var isFirstBroken = true
		for(element: elements) {
			val errors = element.getErrors(true)
			if(errors.empty) {
				if(!isFirst)
					loopParams.appendSeparator(appendable)
				isFirst = false
				generator.apply(element, appendable)
			} else {
				currentAppendable = appendable.errorChild(element)
				if(!isFirst || !isFirstBroken)
					loopParams.appendSeparator(currentAppendable)
				isFirstBroken = false
				try {
					generator.apply(element, currentAppendable)
				} catch(Exception ignoreMe) {} 
			}
		}
		currentAppendable = if(allElementsBroken) 
				appendable.errorChild(elements.head)
			else 
				appendable
		loopParams.appendSuffix(currentAppendable)
	}	
	
	def void serializeSafely(JvmTypeReference typeRef, ITreeAppendable appendable) {
		serializeSafely(typeRef, null, appendable)
	}
	
	def void serializeSafely(JvmTypeReference typeRef, String surrogateType, ITreeAppendable appendable) {
		if(typeRef == null) {
			val errorChild = appendable.asErrorAppendable(typeRef.eContainer)
			errorChild.append("type reference is 'null'")
		} else {
			if(typeRef.accept(new TypeRefProxyDetector)) {
				val errorChild = appendable.asErrorAppendable(typeRef.eContainer)
				try {
					serialize(typeRef, typeRef.eContainer, errorChild)
				} catch(Exception ignoreMe) {}
				if(surrogateType != null) 
					appendable.append(surrogateType)
			} else {
				serialize(typeRef, typeRef.eContainer, appendable)
			}
		}
	}

	def protected asErrorAppendable(ITreeAppendable appendable, EObject context) {
		switch appendable {
			ErrorTreeAppendable: appendable
			default: appendable.errorChild(context)
		}
	}
}

class TypeRefProxyDetector extends AbstractTypeReferenceVisitor$InheritanceAware<Boolean> {
	
	override doVisitTypeReference(JvmTypeReference it) {
		type.eIsProxy
	}

	override doVisitCompoundTypeReference(JvmCompoundTypeReference it) {
		doVisitTypeReference || references.exists[visit]
	}
	
	override doVisitParameterizedTypeReference(JvmParameterizedTypeReference it) {
		doVisitTypeReference || arguments.exists[visit]
	}
}