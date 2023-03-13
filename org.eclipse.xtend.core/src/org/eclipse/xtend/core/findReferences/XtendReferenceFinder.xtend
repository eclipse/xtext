/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.findReferences

import com.google.common.base.Predicate
import com.google.inject.Inject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.jvmmodel.AnonymousClassUtil
import org.eclipse.xtend.core.xtend.AnonymousClass
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.findReferences.ReferenceFinder
import org.eclipse.xtext.findReferences.TargetURIs
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.imports.StaticallyImportedMemberProvider
import org.eclipse.xtext.xtype.XImportDeclaration

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*
import static org.eclipse.xtext.xtype.XtypePackage.Literals.*

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class XtendReferenceFinder extends ReferenceFinder {
	
	@Inject
	extension StaticallyImportedMemberProvider
	
	@Inject 
	extension AnonymousClassUtil
	
	@Inject
	Declarators declarators
	
	override findReferencesInDescription(TargetURIs targetURIs, IResourceDescription resourceDescription, IResourceAccess resourceAccess, Acceptor acceptor, IProgressMonitor monitor) {
		if (resourceAccess === null) {
			// Xtend doesn't use indexed reference descriptions thus cannot return anything without resource access
			return;
		}
		val names = declarators.getDeclaratorData(targetURIs, resourceAccess).declaratorNames
		if (monitor.canceled)
			throw new OperationCanceledException
		val importedNames = resourceDescription.importedNames.toSet
		if (names.exists[ importedNames.contains(it) ]) {
			resourceAccess.readOnly(resourceDescription.URI) [
				findReferences(targetURIs, getResource(resourceDescription.URI, true), acceptor, monitor)
				return null
			]
		}
	}
	
	override protected findLocalReferencesFromElement(Predicate<URI> targetURIs, EObject sourceCandidate, Resource localResource, Acceptor acceptor) {
		switch sourceCandidate {
			// ignore type references in package fragments
			XAbstractFeatureCall case sourceCandidate.packageFragment: return
			default: super.findLocalReferencesFromElement(targetURIs, sourceCandidate, localResource, acceptor)
		}
		switch sourceCandidate {
			XImportDeclaration case sourceCandidate.static && !sourceCandidate.wildcard: {
				addReferenceToFeatureFromStaticImport(sourceCandidate, targetURIs, acceptor)
			} 
			XFeatureCall case sourceCandidate.actualReceiver === null && sourceCandidate.static: {
				addReferenceToTypeFromStaticImport(sourceCandidate, targetURIs, acceptor)
			}
			XMemberFeatureCall: { 
				if(sourceCandidate.static && !sourceCandidate.staticWithDeclaringType) 
					addReferenceToTypeFromStaticImport(sourceCandidate, targetURIs, acceptor)
			}
			AnonymousClass: {
				addReferencesToSuper(sourceCandidate, targetURIs, acceptor)
			}
		}
	}
	
	protected def addReferencesToSuper(AnonymousClass anonymousClass, Predicate<URI> targetURISet, Acceptor acceptor) {
		val constructorCall = anonymousClass.constructorCall
		val superType = anonymousClass.superType
		superType?.addReferenceIfTarget(targetURISet, constructorCall, XCONSTRUCTOR_CALL__CONSTRUCTOR, acceptor)
		val superConstructor = anonymousClass.superTypeConstructor
		superConstructor?.addReferenceIfTarget(targetURISet, constructorCall, XCONSTRUCTOR_CALL__CONSTRUCTOR, acceptor)
	}
	
	protected def addReferenceToFeatureFromStaticImport(XImportDeclaration importDeclaration, Predicate<URI> targetURISet, Acceptor acceptor) {
		importDeclaration.allFeatures.forEach [
			addReferenceIfTarget(targetURISet, importDeclaration, XIMPORT_DECLARATION__IMPORTED_TYPE, acceptor)
		] 
	}
	
	protected def addReferenceToTypeFromStaticImport(XAbstractFeatureCall sourceCandidate, Predicate<URI> targetURISet, Acceptor acceptor) {
		val feature = sourceCandidate.feature
		if(feature instanceof JvmMember) {
			val type = feature.declaringType
			type.addReferenceIfTarget(targetURISet, sourceCandidate, XABSTRACT_FEATURE_CALL__FEATURE, acceptor)
		}
	}

	protected def addReferenceIfTarget(EObject candidate, Predicate<URI> targetURISet, EObject sourceElement, EReference reference, Acceptor acceptor) {
		val candidateURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(candidate)
		if (targetURISet.apply(candidateURI)) {
			val sourceURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(sourceElement)
			acceptor.accept(sourceElement, sourceURI, reference, -1, candidate, candidateURI)
		}
	}
	
}