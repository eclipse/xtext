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
import org.eclipse.xtext.common.types.JvmWildcardTypeReference
import org.eclipse.xtext.common.types.util.AbstractTypeReferenceVisitor
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.util.OnChangeEvictingCache
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.xbase.compiler.output.ErrorTreeAppendable
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable

import static java.util.Collections.*

/** 
 * @author Jan Koehnlein
 */
class ErrorSafeExtensions {
	
	@Inject extension TypeReferenceSerializer 

	@Inject OnChangeEvictingCache cache

	def Iterable<Issue> getErrors(EObject element, boolean includeContents) {
		val IElementIssueProvider issueProvider = cache.get(typeof(IElementIssueProvider).name, element.eResource, [|null])
		if(issueProvider==null)
			return emptyList
		else 
			issueProvider.getIssues(element, includeContents).filter[severity == Severity::ERROR]
	}

	def boolean hasErrors(EObject element, boolean includeContents) {
		val IElementIssueProvider issueProvider = cache.get(typeof(IElementIssueProvider).name, element.eResource, [|null])
		if(issueProvider==null)
			return false
		else 
			issueProvider.getIssues(element, includeContents).exists[it.severity == Severity::ERROR]
	}
	
	def <T extends EObject> void forEachSafely(ITreeAppendable appendable, Iterable<T> elements, 
			(LoopParams)=>void loopInitializer, 
			(T, ITreeAppendable)=>void body) {
		if(elements.empty)
			return
		val loopParams = new LoopParams => loopInitializer
		val allElementsBroken = elements.filter[it.hasErrors(true)].size == elements.size
		var currentAppendable = if(allElementsBroken) 
				appendable.openErrorAppendable(null, elements.head)
			else 
				appendable
		loopParams.appendPrefix(currentAppendable)
		var isFirst = true
		var isFirstBroken = true
		for(element: elements) {
			if(!element.hasErrors(true)) {
				currentAppendable = appendable.closeErrorAppendable(currentAppendable)
				if(!isFirst)
					loopParams.appendSeparator(appendable)
				isFirst = false
				body.apply(element, appendable)
			} else {
				if(!allElementsBroken)
					currentAppendable = openErrorAppendable(appendable, currentAppendable, element)
				if(!isFirst || !isFirstBroken)
					loopParams.appendSeparator(currentAppendable)
				isFirstBroken = false
				try {
					body.apply(element, currentAppendable)
				} catch(Exception ignoreMe) {} 
			}
		}
		currentAppendable = if(allElementsBroken) 
				currentAppendable
			else 
				appendable.closeErrorAppendable(currentAppendable)
		loopParams.appendSuffix(currentAppendable)
		appendable.closeErrorAppendable(currentAppendable)
	}	
	
	def protected openErrorAppendable(ITreeAppendable parent, ITreeAppendable child, EObject context) {
		if(!(child instanceof ErrorTreeAppendable))
			parent.errorChild(context).append("/* ")
		else 
			child
	}

	def protected closeErrorAppendable(ITreeAppendable parent, ITreeAppendable child) {
		if(child instanceof ErrorTreeAppendable && child != parent)
			child.append(" */")
		parent
	}

	def void serializeSafely(JvmTypeReference typeRef, ITreeAppendable appendable) {
		serializeSafely(typeRef, null, appendable)
	}
	
	def void serializeSafely(JvmTypeReference typeRef, String surrogateType, ITreeAppendable appendable) {
		if(typeRef == null || typeRef.type == null) {
			val errorChild = appendable.openErrorAppendable(appendable, typeRef)
			errorChild.append("type is 'null'")
			appendable.closeErrorAppendable(errorChild)
		} else {
			if(typeRef.accept(new BrokenTypeRefDetector)) {
				val errorChild = appendable.openErrorAppendable(appendable, typeRef.eContainer)
				try {
					serialize(typeRef, typeRef.eContainer, errorChild)
				} catch(Exception ignoreMe) {}
				appendable.closeErrorAppendable(errorChild)
				if(surrogateType != null) 
					appendable.append(surrogateType)
			} else {
				serialize(typeRef, typeRef.eContainer, appendable)
			}
		}
	}
}

class BrokenTypeRefDetector extends AbstractTypeReferenceVisitor$InheritanceAware<Boolean> {
	
	override doVisitTypeReference(JvmTypeReference it) {
		type==null || type.eIsProxy
	}
	
	override doVisitCompoundTypeReference(JvmCompoundTypeReference it) {
		doVisitTypeReference || references.exists[visit]
	}
	
	override doVisitParameterizedTypeReference(JvmParameterizedTypeReference it) {
		doVisitTypeReference || arguments.exists[visit]
	}
	
	override doVisitWildcardTypeReference(JvmWildcardTypeReference it) {
		constraints.exists[typeReference.visit]
	}
	
}