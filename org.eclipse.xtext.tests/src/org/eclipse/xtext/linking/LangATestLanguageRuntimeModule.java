/*
Generated with Xtext
*/
package org.eclipse.xtext.linking;

import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;

import com.google.inject.Binder;

/**
 * used to register components to be used within the IDE.
 */
public class LangATestLanguageRuntimeModule extends AbstractLangATestLanguageRuntimeModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		
		// extend configuration here
	}

	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return StorageAwareResource.class;
	}
	
	public Class<? extends IResourceStorageFacade> bindIResourceStorageFacade() {
		return ResourceStorageFacade.class;
	}
	
	public Class<? extends AbstractFileSystemAccess2> bindAbstractFileSystemAccess2() {
		return JavaIoFileSystemAccess.class;
	}
}
