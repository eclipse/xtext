package org.eclipse.xtext.testlanguages.noJdt.writeStorageResources;

import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class NoJdtTestLanguageWriteStorageResourcesRuntimeModule
		extends org.eclipse.xtext.testlanguages.noJdt.AbstractNoJdtTestLanguageRuntimeModule {

	public Class<? extends IResourceStorageFacade> bindIResourceStorageFacade() {
		return ResourceStorageFacade.class;
	}
	
	public Class<? extends AbstractFileSystemAccess2> bindAbstractFileSystemAccess2() {
		return JavaIoFileSystemAccess.class;
	}
	
	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return StorageAwareResource.class;
	}
}
