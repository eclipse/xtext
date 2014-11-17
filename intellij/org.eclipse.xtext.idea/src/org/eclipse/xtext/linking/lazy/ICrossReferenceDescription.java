package org.eclipse.xtext.linking.lazy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;

public interface ICrossReferenceDescription {
    EObject resolve();

    Iterable<IEObjectDescription> getVariants();
}
