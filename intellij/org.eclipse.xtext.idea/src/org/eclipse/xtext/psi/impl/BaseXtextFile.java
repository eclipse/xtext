/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi.impl;

import static java.util.Collections.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.resource.IdeaResourceSetProvider;
import org.eclipse.xtext.idea.resource.PsiToEcoreAdapter;
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformator;
import org.eclipse.xtext.idea.util.CancelProgressIndicator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.SyntheticCompositeNode;
import org.eclipse.xtext.psi.PsiEObject;
import org.eclipse.xtext.psi.XtextPsiUtils;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.jetbrains.annotations.NotNull;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.CachedValue;
import com.intellij.psi.util.CachedValueProvider;
import com.intellij.psi.util.CachedValuesManager;
import com.intellij.util.indexing.IndexingDataKeys;

public abstract class BaseXtextFile extends PsiFileBase {
	
	public static final String GLOBAL_MODIFICATION_COUNT = "org.eclipse.xtext.psi.impl.BaseXtextFile.globalModificationCounter";
	
    @Inject
    protected IdeaResourceSetProvider resourceSetProvider;
    
    @Inject
    protected IResourceFactory resourceFactory;
    
    @Inject
    protected Provider<PsiToEcoreTransformator> psiToEcoreTransformatorProvider;
    
    @Inject
    protected OperationCanceledManager operationCanceledManager;
    
    protected final Object resourceCacheLock;
    
    protected final CachedValue<XtextResource> resourceCache;
    
    @SuppressWarnings("rawtypes")
	@Inject
    @Named(GLOBAL_MODIFICATION_COUNT)
    protected Key globalModificationCount;
    
	protected BaseXtextFile(@NotNull FileViewProvider viewProvider, @NotNull Language language) {
        super(viewProvider, language);
        if (language instanceof IXtextLanguage) {
        	((IXtextLanguage) language).injectMembers(this);
        } else {
        	throw new IllegalArgumentException("Expected an Xtext language but got " + language.getDisplayName());
        }
        resourceCacheLock = new Object();
        resourceCache = CachedValuesManager.getManager(getProject()).createCachedValue(new CachedValueProvider<XtextResource>() {

			@Override
			public Result<XtextResource> compute() {
				try {
					XtextResource resource = createResource();
					return Result.create(resource, new Object[] {
							globalModificationCount, 
							BaseXtextFile.this
					});
				} catch (OperationCanceledError e) {
					throw e.getWrapped();
				}
			}
        	
        }, false);
    }
	
	public IXtextLanguage getXtextLanguage() {
		return (IXtextLanguage) getLanguage();
	}
	
	public XtextResource getResource() {
    	synchronized(resourceCacheLock) {
    		return resourceCache.getValue();
    	}
	}
	
	public INode getINode(ASTNode node) {
		return PsiToEcoreAdapter.get(getResource()).getNodesMapping().get(node);
	}
	
	public List<ASTNode> getASTNodes(INode node) {
		INode originalNode = findOriginalNode(node);
		List<ASTNode> astNodes = PsiToEcoreAdapter.get(getResource()).getReverseNodesMapping().get(originalNode);
		return filterASTNodes(node, astNodes);
	}

	protected INode findOriginalNode(INode node) {
		// TODO get rid of this dependency on synth nodes
		if (node instanceof SyntheticCompositeNode) {
			return findOriginalNode(node.getParent());
		}
		return node;
	}

	protected List<ASTNode> filterASTNodes(INode node, List<ASTNode> astNodes) {
		if (astNodes == null) {
			return emptyList();
		}
		// TODO get rid of this dependency on synth nodes
		if (node instanceof SyntheticCompositeNode) {
			List<ASTNode> result = new ArrayList<ASTNode>();
			for (ASTNode astNode : astNodes) {
				IElementType elementType = astNode.getElementType();
				if (elementType instanceof IGrammarAwareElementType) {
					IGrammarAwareElementType grammarAwareElementType = (IGrammarAwareElementType) elementType;
					if (grammarAwareElementType.getGrammarElement() == node.getGrammarElement()) {
						result.add(astNode);
					}
				}
			}
			return result;
		}
		return astNodes;
	}

	protected XtextResource createResource() {    	
		ProgressIndicatorProvider.checkCanceled();
    	VirtualFile virtualFile = getViewProvider().getVirtualFile();
        if (virtualFile == null) {
            return null;
        }
        
        PsiToEcoreTransformator psiToEcoreTransformator = psiToEcoreTransformatorProvider.get();
        psiToEcoreTransformator.setXtextFile(this);
        Module module = ProjectFileIndex.SERVICE.getInstance(getProject()).getModuleForFile(findVirtualFile(this), false);
        if (module == null) {
        	module = ModuleUtilCore.findModuleForPsiElement(this);
        	if (module == null)
        		throw new IllegalStateException("Couldn't find module for "+this);
        }
        ResourceSet resourceSet = resourceSetProvider.get(module);
        XtextResource resource = (XtextResource) resourceFactory.createResource(getURI());
        resourceSet.getResources().add(resource);
        resource.setParser(psiToEcoreTransformator);
        try {
            resource.load(new ByteArrayInputStream(new byte[0]), null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        psiToEcoreTransformator.getAdapter().install(resource);
        
        ProgressIndicatorProvider.checkCanceled();
		installDerivedState(resource);
		
		ProgressIndicatorProvider.checkCanceled();
		EcoreUtil2.resolveLazyCrossReferences(resource, new CancelProgressIndicator());
        
		return resource;
    }

	protected void installDerivedState(Resource resource) {
		ProgressIndicatorProvider.checkCanceled();
		if (resource instanceof DerivedStateAwareResource) {
			final DerivedStateAwareResource derivedStateAwareResource = (DerivedStateAwareResource) resource;
			boolean deliver = derivedStateAwareResource.eDeliver();
			try {
				derivedStateAwareResource.eSetDeliver(false);
				derivedStateAwareResource.installDerivedState(false);
			} finally {
				derivedStateAwareResource.eSetDeliver(deliver);
			}
		}
	}
	 
	protected VirtualFile findVirtualFile(final PsiFile psiFile) {
		return XtextPsiUtils.findVirtualFile(psiFile);
	}

	public EObject getEObject(URI uri) {
    	Resource resource = getResource();
    	if (resource == null) {
    		return null;
    	}
    	return resource.getEObject(uri.fragment());
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

	@Override
	public String toString() {
		return getClass().getName() + ":" + getName();
	}

}