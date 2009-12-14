/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NamesAreUniqueValidatorTest extends AbstractXtextTests implements INamesAreUniqueValidationHelper, IResourceServiceProvider.Registry {

	private NamesAreUniqueValidator validator;
	private IResourceDescription.Manager resourceDescriptionManager;
	private int callCount;
	private Map<Object, Object> context;
	private Resource resource;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		context = Maps.newHashMap();
		validator = new NamesAreUniqueValidator() {
			@Override
			protected Map<Object, Object> getContext() {
				return context;
			}
		};
		validator.setResourceServiceProviderRegistry(this);
		validator.setHelper(this);
		resourceDescriptionManager = new DefaultResourceDescriptionManager() {
			@Override
			public IResourceDescription getResourceDescription(Resource resource) {
				DefaultResourceDescription resourceDescription = new DefaultResourceDescription(resource, new IQualifiedNameProvider.AbstractImpl() {
					public String getQualifiedName(EObject obj) {
						return SimpleAttributeResolver.NAME_RESOLVER.getValue(obj);
					}
				});
				return resourceDescription;
			}
		};
		callCount = 0;
		resource = new ResourceImpl();
		resource.getContents().add(EcoreFactory.eINSTANCE.createEClass());
		resource.getContents().add(EcoreFactory.eINSTANCE.createEClass());
		resource.getContents().add(EcoreFactory.eINSTANCE.createEClass());
		for (int i = 0; i < resource.getContents().size(); i++) {
			EClass clazz = (EClass) resource.getContents().get(i);
			clazz.setName(String.valueOf(i));
		}
	}
	
	public void testOnlyOnesPerResource() {
		validator.checkUniqueNamesInResourceOf(resource.getContents().get(0));
		validator.checkUniqueNamesInResourceOf(resource.getContents().get(1));
		assertEquals(1, callCount);
	}

	public void checkUniqueNames(Iterable<IEObjectDescription> descriptions, ValidationMessageAcceptor acceptor) {
		fail("Unexpected call");
	}

	public void checkUniqueNames(Iterable<IEObjectDescription> descriptions, CancelIndicator cancelIndicator,
			ValidationMessageAcceptor acceptor) {
		callCount++;
		assertEquals(resource.getContents().size(), Iterables.size(descriptions));
		assertNull(cancelIndicator);
		assertSame(validator, acceptor);
	}

	public IResourceServiceProvider getResourceServiceProvider(URI uri, String contentType) {
		return new DefaultResourceServiceProvider() {
			@Override
			public Manager getResourceDescriptionManager() {
				return resourceDescriptionManager;
			}
		}; 
	}

	public Map<String, Object> getContentTypeToFactoryMap() {
		return null;
	}

	public Map<String, Object> getExtensionToFactoryMap() {
		return null;
	}

	public Map<String, Object> getProtocolToFactoryMap() {
		return null;
	}

}
