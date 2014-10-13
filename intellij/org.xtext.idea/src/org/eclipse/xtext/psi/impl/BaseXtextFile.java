package org.eclipse.xtext.psi.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.resource.IResourceSetProvider;
import org.eclipse.xtext.idea.resource.ResourceDescriptionAdapter;
import org.eclipse.xtext.idea.resource.ResourceInitializationService;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.PsiEObject;
import org.eclipse.xtext.psi.stubs.ExportedObject;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.jetbrains.annotations.NotNull;

import com.google.inject.Inject;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.stubs.StubElement;
import com.intellij.util.indexing.IndexingDataKeys;

public abstract class BaseXtextFile extends PsiFileBase {

    @Inject
    private IResourceSetProvider resourceSetProvider;
    
	protected BaseXtextFile(@NotNull FileViewProvider viewProvider, @NotNull Language language) {
        super(viewProvider, language);
        if (language instanceof IXtextLanguage) {
        	((IXtextLanguage) language).injectMembers(this);
        } else {
        	throw new IllegalArgumentException("Expected an Xtext language but got " + language.getDisplayName());
        }
    }
	
	public IXtextLanguage getXtextLanguage() {
		return (IXtextLanguage) getLanguage();
	}

	public Resource createResource() {    	
    	VirtualFile virtualFile = getViewProvider().getVirtualFile();
        if (virtualFile == null) {
            return null;
        }
        ResourceSet resourceSet = resourceSetProvider.get(this);
        Resource resource = resourceSet.createResource(getURI());
        try {
            resource.load(virtualFile.getInputStream(), null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return resource;
    }

	public EObject getEObject(URI uri) {
    	Resource resource = getResource();
    	if (resource == null) {
    		return null;
    	}
    	return resource.getEObject(uri.fragment());
	}
    
    public IResourceDescription getResourceDescription() {
    	PsiEObject root = getRoot();
    	if (root == null) {
    		return null;
    	}
    	Boolean ensureInitialized = root.getUserData(ResourceInitializationService.ENSURE_INITIALIZED);
		root.putUserData(ResourceInitializationService.ENSURE_INITIALIZED, Boolean.FALSE);
		try {
			Resource resource = root.getResource();
    		return resource != null ? ResourceDescriptionAdapter.get(resource) : null;
		} finally {
			root.putUserData(ResourceInitializationService.ENSURE_INITIALIZED, ensureInitialized);
		}
    }
    
    public Resource getResource() {
    	PsiEObject root = getRoot();
    	if (root != null) {
    		return root.getResource();
    	}
    	return null;
    }
    
    public PsiEObject getRoot() {
    	PsiElement firstChild = getFirstChild();
    	if (firstChild instanceof PsiEObject) {
    		return (PsiEObject) firstChild;
    	}
    	return null;
    }
    
    public URI getURI() {
    	StubElement<?> stub = getStub();
    	if (stub instanceof XtextFileStub<?>) {
    		XtextFileStub<?> xtextFileStub = (XtextFileStub<?>) stub;
    		return xtextFileStub.getUri();
    	}
        return getPhysicalURI();
	}
    
    public URI getPhysicalURI() {
		PsiFile originalFile = getOriginalFile();
		if (originalFile != this && originalFile instanceof BaseXtextFile) {
			BaseXtextFile originalXtextFile = (BaseXtextFile) originalFile;
			return originalXtextFile.getURI();
		}
    	VirtualFile virtualFile = getUserData(IndexingDataKeys.VIRTUAL_FILE);
		if (virtualFile == null) {
    		virtualFile = getViewProvider().getVirtualFile();
    	}
		String url = virtualFile.getUrl();
        return URI.createURI(url);
    }

	public List<IEObjectDescription> getExportedObjects() {
		StubElement<?> stub = getStub();
		if (stub instanceof XtextFileStub<?>) {
			XtextFileStub<?> xtextFileStub = (XtextFileStub<?>) stub;
			List<IEObjectDescription> exportedObjects = new ArrayList<IEObjectDescription>();
			for (ExportedObject exportedObject : xtextFileStub.getExportedObjects()) {
				exportedObjects.add(createEObjectDescription(exportedObject.getEClass(), exportedObject.getEObjectURI(), exportedObject.getQualifiedName()));
			}
			return exportedObjects;
		}
		IResourceDescription resourceDescription = getResourceDescription();
		if (resourceDescription != null) {
			List<IEObjectDescription> exportedObjects = new ArrayList<IEObjectDescription>();
			for (IEObjectDescription exportedObject : resourceDescription.getExportedObjects()) {
				exportedObjects.add(createEObjectDescription(exportedObject.getEClass(), exportedObject.getEObjectURI(), exportedObject.getQualifiedName()));
			}
			return exportedObjects;
		}
		return Collections.emptyList();
	}

	protected IEObjectDescription createEObjectDescription(EClass eClass, URI eObjectURI, QualifiedName qualifiedName) {
		EFactory factory = eClass.getEPackage().getEFactoryInstance();
		InternalEObject element = (InternalEObject) factory.create(eClass);
		element.eSetProxyURI(eObjectURI);
		return EObjectDescription.create(qualifiedName, element);
	}

	@Override
	public String toString() {
		return getClass().getName() + ":" + getName();
	}

}