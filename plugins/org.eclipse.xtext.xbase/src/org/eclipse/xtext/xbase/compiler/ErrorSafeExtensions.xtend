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
import org.eclipse.xtext.xbase.compiler.output.ErrorTreeAppendable
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable

/** 
 * @author Jan Koehnlein
 */
class ErrorSafeExtensions {
	
	@Inject extension TypeReferenceSerializer 

	@Inject OnChangeEvictingCache cache

	def boolean hasErrors(EObject element, boolean includeContents) {
		val IElementIssueProvider issueProvider = cache.get(typeof(IElementIssueProvider).name, element.eResource, [|null])
		if(issueProvider==null)
			return false
		else 
			issueProvider.getIssues(element, includeContents).exists[it.severity == Severity::ERROR]
	}
	
	def appendSafely(ITreeAppendable appendable, EObject element, (ITreeAppendable)=>void procedure) {
		appendSafely(appendable, element, null, procedure)
	}
	
	def appendSafely(ITreeAppendable appendable, EObject element, String surrogateCode, (ITreeAppendable)=>void procedure) {
		if(!element.hasErrors(true)) {
			appendable => procedure
		} else {
			val errorChild = appendable.errorChild(element)
			try {
				errorChild => procedure
			} catch (Exception ignoreMe) {}
			if(surrogateCode != null)
				appendable.append(surrogateCode);
		}
	}
	
	def <T extends EObject> void forEachSafely(ITreeAppendable appendable, Iterable<T> elements, 
			(LoopParams)=>void loopInitializer, 
			(T, ITreeAppendable)=>void body) {
		if(elements.empty)
			return
		val loopParams = new LoopParams => loopInitializer
		val allElementsBroken = elements.filter[it.hasErrors(true)].size == elements.size
		var currentAppendable = if(allElementsBroken) 
				appendable.errorChild(elements.head)
			else 
				appendable
		loopParams.appendPrefix(currentAppendable)
		var isFirst = true
		var isFirstBroken = true
		for(element: elements) {
			if(!element.hasErrors(true)) {
				if(!isFirst)
					loopParams.appendSeparator(appendable)
				isFirst = false
				body.apply(element, appendable)
			} else {
				if(!allElementsBroken)
					currentAppendable = appendable.errorChild(element)
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
			if(typeRef.accept(new BrokenTypeRefDetector)) {
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