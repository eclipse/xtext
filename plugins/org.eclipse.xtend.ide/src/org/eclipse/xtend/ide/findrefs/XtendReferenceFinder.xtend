package org.eclipse.xtend.ide.findrefs

import com.google.inject.Inject
import java.util.Set
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.IReferenceDescription
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.IResourceServiceProvider$Registry
import org.eclipse.xtext.ui.editor.findrefs.DefaultReferenceFinder
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder$ILocalResourceAccess
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.common.types.JvmType

class XtendReferenceFinder extends DefaultReferenceFinder implements IReferenceFinder {
	IQualifiedNameConverter nameConverter

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
				val obj = EcoreUtil2::getContainerOfType(it.getEObject(uri, true), typeof(JvmType))
				if (obj!=null) {
					names += nameConverter.toQualifiedName(obj.identifier.toLowerCase)
				}
			]
		}
		val importedNames = resourceDescription.importedNames.map[toLowerCase].toSet
		if (names.exists[
			importedNames.contains(it)
		]) {
			localResourceAccess.readOnly(resourceDescription.URI) [
				findLocalReferencesInResource(targetURIs, it.getResource(resourceDescription.URI, true), [
					acceptor.accept(it)
				])
				return null
			]
		} 
	}

}
