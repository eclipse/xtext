/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.linking.impl.SimpleAttributeResolver;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceBasedResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionProvider;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NamesAreUniqueValidatorTest extends AbstractXtextTests implements INamesAreUniqueValidationHelper, IResourceDescription.Provider.Registry {

	private NamesAreUniqueValidator validator;
	private DefaultResourceDescriptionProvider resourceDescriptionProvider;
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
		validator.setResourceDescriptionProviderRegistry(this);
		validator.setHelper(this);
		resourceDescriptionProvider = new DefaultResourceDescriptionProvider();
		resourceDescriptionProvider.setDescriptionProvider(new Provider<AbstractResourceBasedResourceDescription>() {
			public AbstractResourceBasedResourceDescription get() {
				DefaultResourceDescription resourceDescription = new DefaultResourceDescription();
				resourceDescription.setResource(resource);
				resourceDescription.setQualifiedNameProviderRegistry(new IQualifiedNameProvider.Registry() {
					public IQualifiedNameProvider getQualifiedNameProvider(Resource resource) {
						return new IQualifiedNameProvider.AbstractImpl() {
							public String getQualifiedName(EObject obj) {
								return SimpleAttributeResolver.NAME_RESOLVER.getValue(obj);
							}
						};
					}
				});
				return resourceDescription;
			}
			
		});
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

	public IResourceDescription.Provider getResourceDescriptionProvider(Resource resource) {
		return resourceDescriptionProvider;
	}

}
