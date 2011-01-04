/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ecore;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.SimpleAttributeResolver;

/**
 * @author koehnlein - Initial contribution and API
 */
public class EmfResourceDescriptionTest extends AbstractXtextTests {

	public void testClasspathURIIsNormalized() {
		XtextResourceSet xtextResourceSet = new XtextResourceSet();
		xtextResourceSet.setClasspathURIContext(this);
		URI classpathURI = URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.ecore");
		Resource resource = xtextResourceSet.getResource(classpathURI, true);
		IResourceDescription ecoreResourceDescription = createResourceDescription(resource);
		assertNotSame(classpathURI, ecoreResourceDescription.getURI());
		assertEquals(xtextResourceSet.getURIConverter().normalize(classpathURI), ecoreResourceDescription.getURI());
	}

	protected IResourceDescription createResourceDescription(Resource testResource) {
		DefaultResourceDescriptionStrategy strategy = new DefaultResourceDescriptionStrategy();
		strategy.setQualifiedNameProvider(new IQualifiedNameProvider.AbstractImpl() {
			public QualifiedName getFullyQualifiedName(EObject obj) {
				String name = SimpleAttributeResolver.NAME_RESOLVER.apply(obj);
				return (name != null) ? QualifiedName.create(name) : null;
			}
		});
		IResourceDescription resourceDescription = new DefaultResourceDescription(testResource, strategy);
		return resourceDescription;
	}
}
