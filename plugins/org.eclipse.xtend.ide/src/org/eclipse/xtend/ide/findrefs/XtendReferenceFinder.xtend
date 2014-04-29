package org.eclipse.xtend.ide.findrefs

import com.google.inject.Inject
import java.util.Map
import java.util.Set
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.core.jvmmodel.AnonymousClassUtil
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.IReferenceDescription
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.IResourceServiceProvider.Registry
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription
import org.eclipse.xtext.ui.editor.findrefs.DefaultReferenceFinder
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder.ILocalResourceAccess
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.imports.StaticallyImportedMemberProvider
import org.eclipse.xtext.xtype.XImportDeclaration

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*
import static org.eclipse.xtext.xtype.XtypePackage.Literals.*
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtend.core.xtend.AnonymousClass

class XtendReferenceFinder extends DefaultReferenceFinder implements IReferenceFinder {
	
	IQualifiedNameConverter nameConverter
	
	@Inject
	extension StaticallyImportedMemberProvider
	
	@Inject 
	extension AnonymousClassUtil

	@Inject new(IResourceDescriptions indexData, Registry serviceProviderRegistry, IQualifiedNameConverter nameConverter) {
		super(indexData, serviceProviderRegistry)
		this.nameConverter = nameConverter
	}
	
	override findReferences(Set<URI> targetURIs, IResourceDescription resourceDescription, IAcceptor<IReferenceDescription> acceptor, IProgressMonitor monitor, ILocalResourceAccess localResourceAccess) {
		// don't check local resources
		if (targetURIs.map[trimFragment].exists[it == resourceDescription.URI])
			return;
			
		val names = newHashSet()
		for (uri : targetURIs) {
			localResourceAccess.readOnly(uri) [
				val obj = EcoreUtil2.getContainerOfType(it.getEObject(uri, true), JvmType)
				if (obj != null) {
					names += nameConverter.toQualifiedName(obj.identifier).toLowerCase
					names += nameConverter.toQualifiedName(obj.getQualifiedName('.')).toLowerCase
				}
				null
			]
		}
		val importedNames = resourceDescription.importedNames.toSet
		if (names.exists[ importedNames.contains(it) ]) {
			localResourceAccess.readOnly(resourceDescription.URI) [ resourceSet |
				findLocalReferencesInResource(targetURIs, resourceSet.getResource(resourceDescription.URI, true), [
					acceptor.accept(it)
				])
				return null
			]
		} 
	}
	
	override protected findLocalReferencesFromElement(Set<URI> targetURISet, EObject sourceCandidate, Resource localResource, IAcceptor<IReferenceDescription> acceptor, URI currentExportedContainerURI, Map<EObject,URI> exportedElementsMap) {
		switch sourceCandidate {
			// ignore type references in package fragments
			XAbstractFeatureCall case sourceCandidate.packageFragment: return
			default: super.findLocalReferencesFromElement(targetURISet, sourceCandidate, localResource, acceptor, currentExportedContainerURI, exportedElementsMap)
		}
		switch sourceCandidate {
			XImportDeclaration case sourceCandidate.static && !sourceCandidate.wildcard: {
				addReferenceToFeatureFromStaticImport(sourceCandidate, targetURISet, acceptor, currentExportedContainerURI)
			} 
			XFeatureCall case sourceCandidate.actualReceiver == null && sourceCandidate.static: {
				addReferenceToTypeFromStaticImport(sourceCandidate, targetURISet, acceptor, currentExportedContainerURI)
			}
			XMemberFeatureCall: { 
				if(sourceCandidate.static && !sourceCandidate.staticWithDeclaringType) 
					addReferenceToTypeFromStaticImport(sourceCandidate, targetURISet, acceptor, currentExportedContainerURI)
			}
			AnonymousClass: {
				addReferencesToSuper(sourceCandidate, targetURISet, acceptor, currentExportedContainerURI)
			}
		}
	}
	
	protected def addReferencesToSuper(AnonymousClass anonymousClass, Set<URI> targetURISet, IAcceptor<IReferenceDescription> acceptor, URI currentExportedContainerURI) {
		val constructorCall = anonymousClass.constructorCall
		val superType = anonymousClass.superType
		superType?.addReferenceIfTarget(targetURISet, constructorCall, XCONSTRUCTOR_CALL__CONSTRUCTOR, acceptor, currentExportedContainerURI)
		val superConstructor = anonymousClass.superTypeConstructor
		superConstructor?.addReferenceIfTarget(targetURISet, constructorCall, XCONSTRUCTOR_CALL__CONSTRUCTOR, acceptor, currentExportedContainerURI)
	}
	
	protected def addReferenceToFeatureFromStaticImport(XImportDeclaration importDeclaration, Set<URI> targetURISet, IAcceptor<IReferenceDescription> acceptor, URI currentExportedContainerURI) {
		importDeclaration.allFeatures.forEach [
			addReferenceIfTarget(targetURISet, importDeclaration, XIMPORT_DECLARATION__IMPORTED_TYPE, acceptor, currentExportedContainerURI)
		] 
	}
	
	protected def addReferenceToTypeFromStaticImport(XAbstractFeatureCall sourceCandidate, Set<URI> targetURISet, IAcceptor<IReferenceDescription> acceptor, URI currentExportedContainerURI) {
		val feature = sourceCandidate.feature
		if(feature instanceof JvmMember) {
			val type = feature.declaringType
			type.addReferenceIfTarget(targetURISet, sourceCandidate, XABSTRACT_FEATURE_CALL__FEATURE, acceptor, currentExportedContainerURI)
		}
	}

	protected def addReferenceIfTarget(EObject candidate, Set<URI> targetURISet, EObject sourceElement, EReference reference, IAcceptor<IReferenceDescription> acceptor, URI currentExportedContainerURI) {
		val candidateURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(candidate)
		if (targetURISet.contains(candidateURI)) {
			val sourceURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(sourceElement)
			acceptor.accept(new DefaultReferenceDescription(sourceURI, candidateURI, reference, -1, currentExportedContainerURI))
		}
	}
}
