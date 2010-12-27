/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.generic;

import static com.google.common.collect.Lists.*;
import static java.util.Collections.*;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;

/**
 * @author koehnlein - Initial contribution and API
 */
public class EmfResourceDescription extends AbstractResourceDescription {

	private List<IEObjectDescription> eObjectDescriptions;

	private List<IReferenceDescription> referenceDescriptions;

	private URI resourceURI;

	public EmfResourceDescription(Resource resource, IQualifiedNameProvider qualifiedNameProvider) {
		eObjectDescriptions = newArrayList();
		referenceDescriptions = newArrayList();
		this.resourceURI = getNormalizedURI(resource);
		EList<EObject> elements = resource.getContents();
		processElements(elements, null, qualifiedNameProvider);
	}

	protected void processElements(EList<EObject> elements, URI exportedContainerURI, IQualifiedNameProvider qualifiedNameProvider) {
		for (EObject element: elements) {
			URI lastExportedContainerURI = exportedContainerURI; 
			IEObjectDescription eObjectDescription = createEObjectDescription(qualifiedNameProvider, element);
			if (eObjectDescription != null) {
				eObjectDescriptions.add(eObjectDescription);
				lastExportedContainerURI = eObjectDescription.getEObjectURI();
			}
			EList<EReference> eReferences = element.eClass().getEReferences();
			for (EReference eReference : eReferences) {
				if (!eReference.isContainment() && !eReference.isDerived() && !eReference.isVolatile() && !eReference.isTransient() && element.eIsSet(eReference)) {
					if (eReference.isMany()) {
						InternalEList<?> crossRef = (InternalEList<?>) element.eGet(eReference, false);
						for (int index = 0; index < crossRef.size(); ++index) {
							IReferenceDescription referenceDescription = createReferenceDescription(element,
									eReference, crossRef.basicGet(index), index, lastExportedContainerURI);
							if (referenceDescription != null)
								referenceDescriptions.add(referenceDescription);
						}
					} else {
						Object crossRef = element.eGet(eReference);
						IReferenceDescription referenceDescription = createReferenceDescription(element, eReference,
								crossRef, 0, lastExportedContainerURI);
						if (referenceDescription != null)
							referenceDescriptions.add(referenceDescription);
					}
				}
			}
			processElements(element.eContents(), lastExportedContainerURI, qualifiedNameProvider);
		}
	}

	protected IEObjectDescription createEObjectDescription(IQualifiedNameProvider qualifiedNameProvider, EObject element) {
		QualifiedName qualifiedName = qualifiedNameProvider.getFullyQualifiedName(element);
		if (qualifiedName != null) {
			return EObjectDescription.create(qualifiedName, element);
		}
		return null;
	}

	protected IReferenceDescription createReferenceDescription(EObject element, EReference eReference, Object crossRef,
			int index, URI exportedContainerURI) {
		if (crossRef instanceof EObject) {
			URI uri = EcoreUtil.getURI((EObject) crossRef);
			if (!resourceURI.equals(uri.trimFragment())) {
				return new DefaultReferenceDescription(element, (EObject) crossRef, eReference, index,
						exportedContainerURI);
			}
		}
		return null;
	}

	public Iterable<QualifiedName> getImportedNames() {
		return emptyList();
	}

	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return referenceDescriptions;
	}

	public URI getURI() {
		return resourceURI;
	}

	@Override
	protected List<IEObjectDescription> computeExportedObjects() {
		return eObjectDescriptions;
	}

}
