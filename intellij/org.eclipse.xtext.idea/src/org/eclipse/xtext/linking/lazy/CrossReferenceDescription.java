package org.eclipse.xtext.linking.lazy;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.service.OperationCanceledError;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class CrossReferenceDescription implements ICrossReferenceDescription {
	
	@Inject
	private IScopeProvider scopeProvider;
	
	private Integer index;
    private EObject context;
	private EReference reference;

    @SuppressWarnings("unchecked")
	public EObject resolve() {
    	try {
    		Object value = context.eGet(reference);
    		if (reference.isMany()) {
    			value = ((InternalEList<EObject>) value).get(index);
    		}
			return (EObject) value;
    	} catch (OperationCanceledError e) {
    		throw e.getWrapped();
    	}
    }

    public Iterable<IEObjectDescription> getVariants() {
    	final Iterable<IEObjectDescription> iterable = getAllElements();
		return new Iterable<IEObjectDescription>() {

			public Iterator<IEObjectDescription> iterator() {
				final Iterator<IEObjectDescription> iterator = iterable.iterator();
				return new Iterator<IEObjectDescription>() {

					public boolean hasNext() {
						try {
							return iterator.hasNext();
						} catch (OperationCanceledError e) {
				    		throw e.getWrapped();
				    	} 
					}

					public IEObjectDescription next() {
						try {
							return iterator.next();
						} catch (OperationCanceledError e) {
				    		throw e.getWrapped();
				    	}
					}

					public void remove() {
						try {
							iterator.remove();
						} catch (OperationCanceledError e) {
				    		throw e.getWrapped();
				    	}
					}
					
				};
			}
    		
    	};
    }

	protected Iterable<IEObjectDescription> getAllElements() {
		try {
			return scopeProvider.getScope(context, reference).getAllElements();
		} catch (OperationCanceledError e) {
    		throw e.getWrapped();
    	}
	}
    
    public static class CrossReferenceDescriptionProvider {
    	
    	@Inject
    	private Provider<CrossReferenceDescription> delegate;
    	
    	public ICrossReferenceDescription get(EObject context, EReference reference, Integer index) {
    		CrossReferenceDescription crossReferenceDescription = delegate.get();
    		crossReferenceDescription.index = index;
    		crossReferenceDescription.context = context;
    		crossReferenceDescription.reference = reference;
    		return crossReferenceDescription;
    	}
    	
    }

}