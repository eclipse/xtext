/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ecore;

import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class EcoreResourceDescription extends AbstractResourceDescription {
	
	/**
	 * @author Sven Efftinge - Initial contribution and API
	 * 
	 * TODO : come up with a better qualified name contract for ecore.
	 * TODO : export epackages with their nsURI as well.
	 * 
	 */
	private static final class Switch extends EcoreSwitch<IEObjectDescription> {
		@Override
		public IEObjectDescription caseENamedElement(ENamedElement object) {
			return new EObjectDescription(object.getName(), object, null);
		}
	}

	private Resource resource;
	private Set<IEObjectDescription> descriptions;

	public EcoreResourceDescription(Resource resource) {
		this.resource = resource;
		TreeIterator<EObject> contents = resource.getAllContents();
		descriptions = Sets.newHashSet();
		Switch switch1 = new Switch();
		while (contents.hasNext()) {
			EObject eObject = contents.next();
			IEObjectDescription desc = switch1.doSwitch(eObject);
			if (desc!=null)
				descriptions.add(desc);
		}
	}

	public Iterable<IEObjectDescription> getExportedObjects() {
		return descriptions;
	}

	public Iterable<String> getImportedNames() {
		return Iterables.emptyIterable();
	}

	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return Iterables.emptyIterable();
	}

	public URI getURI() {
		return resource.getURI();
	}

}
