package org.eclipse.xtext.psi;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.idea.resource.ProjectAdapter;
import org.eclipse.xtext.linking.lazy.ICrossReferenceDescription;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.service.OperationCanceledError;

import com.google.inject.Singleton;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.source.tree.CompositeElement;

@Singleton
public class PsiModelAssociations implements IPsiModelAssociations, IPsiModelAssociator {
	
	public static class PsiAdapter extends AdapterImpl {
		
		private PsiElement psiElement;
		
		private final CompositeElement composite;

		private final PsiElementProvider psiElementProvider;

		public PsiAdapter(final PsiElement psiElement) {
			this(new PsiElementProvider() {
				
				@Override
				public PsiElement get() {
					return psiElement;
				}
				
			});
		}

		public PsiAdapter(PsiElementProvider psiElementProvider) {
			this.composite = null;
			this.psiElementProvider = psiElementProvider;
		}

		public PsiAdapter(CompositeElement composite) {
			this.composite = composite;
			this.psiElementProvider = null;
		}
		
		public CompositeElement getComposite() {
			return composite;
		}
		
		public PsiElement getPsi() {
			if (composite != null) {
				return composite.getPsi();
			}
			if (psiElement == null && psiElementProvider != null) {
				psiElement = psiElementProvider.get();
			}
			return psiElement;
		}
		
		public static CompositeElement getComposite(EObject object) {
			PsiAdapter psiAdapter = get(object);
			if (psiAdapter != null) {
				return psiAdapter.getComposite();
			}
			return null;
		}
		
		public static PsiElement getPsi(EObject object) {
			PsiAdapter psiAdapter = get(object);
			if (psiAdapter != null) {
				return psiAdapter.getPsi();
			}
			return null;
		}
		
		public static PsiAdapter get(EObject object) {
			if (object == null) {
				return null;
			}
			Iterator<Adapter> adapters = object.eAdapters().iterator();
			while (adapters.hasNext()) {
				Adapter adapter = adapters.next();
				if (adapter instanceof PsiAdapter) {
					return ((PsiAdapter) adapter);
				}
			}
			return null;
		}
		
	}
	
    public EObject getEObject(PsiEObject element) {
    	if (element == null) {
            return null;
        }
    	return element.getEObject();
    }

    public PsiElement getPsiElement(EObject object) {
    	try {
	    	if (object == null || object.eIsProxy()) {
	    		return null;
	    	}
	    	PsiElement psi = PsiAdapter.getPsi(object);
	    	if (psi != null) {
	    		return psi;
	    	}
	    	
	    	URI uri = EcoreUtil.getURI(object);
	    	Resource eResource = object.eResource();
	    	if (eResource == null) {
	    		return null;
	    	}
			BaseXtextFile xtextFile = getBaseXtextFile(eResource.getResourceSet(), uri);
	    	if (xtextFile == null) {
	    		return null;
	    	}
	    	EObject resolvedObject = xtextFile.getEObject(uri);
			return PsiAdapter.getPsi(resolvedObject);
    	} catch (OperationCanceledError e) {
    		throw e.getWrapped();
    	}
    }

	protected BaseXtextFile getBaseXtextFile(ResourceSet resourceSet, URI uri) {
    	Project project = ProjectAdapter.getProject(resourceSet);
    	if (project == null) {
    		return null;
    	}
		VirtualFile file = VirtualFileManager.getInstance().findFileByUrl(uri.trimFragment().toString());
    	if (file == null) {
    		return null;
    	}
    	PsiFile psiFile = PsiManager.getInstance(project).findFile(file);
    	if (psiFile == null || !(psiFile instanceof BaseXtextFile)) {
    		return null;
    	}
    	return (BaseXtextFile) psiFile;
	}
    
	public PsiElement getPsiElement(IEObjectDescription objectDescription, EObject context) {
		if (objectDescription == null) {
			return null;
		}
		EObject object = context.eResource().getResourceSet().getEObject(objectDescription.getEObjectURI(), true);
		return getPsiElement(object);
	}

    public ICrossReferenceDescription getCrossReferenceDescription(PsiReferenceEObject element) {
    	if (element == null) {
    		return null;
    	}
    	return element.getCrossReferenceDescription();
    }

	@Override
	public boolean associate(EObject eObject, PsiElementProvider psiElementProvider) {
		if (eObject == null || psiElementProvider == null) {
			return false;
		}
		if (PsiAdapter.get(eObject) != null) {
			return false;
		}
		return eObject.eAdapters().add(new PsiAdapter(psiElementProvider));
	}

	@Override
	public boolean associatePrimary(EObject eObject, PsiElementProvider psiElementProvider) {
		if (eObject == null || psiElementProvider == null) {
			return false;
		}
		PsiAdapter psiAdapter = PsiAdapter.get(eObject);
		if (psiAdapter != null) {
			eObject.eAdapters().remove(psiAdapter);
		}
		return eObject.eAdapters().add(new PsiAdapter(psiElementProvider));
	}

}
