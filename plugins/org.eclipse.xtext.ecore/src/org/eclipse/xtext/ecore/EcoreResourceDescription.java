/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ecore;

import java.util.Iterator;
import java.util.List;

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
import com.google.common.collect.Lists;

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

	public EcoreResourceDescription(Resource resource) {
		this.resource = resource;
	}

	@Override
	protected List<IEObjectDescription> computeExportedObjects() {
		Iterator<EObject> contents = resource.getAllContents();
		List<IEObjectDescription> result = Lists.newArrayList();
		Switch factory = new Switch();
		while (contents.hasNext()) {
			EObject eObject = contents.next();
			IEObjectDescription desc = factory.doSwitch(eObject);
			if (desc!=null)
				result.add(desc);
		}
		return result;
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
