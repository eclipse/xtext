/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.serializer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.DefaultFragmentProvider;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.syntacticsequencertest.Model;
import org.eclipse.xtext.serializer.syntacticsequencertest.SingleCrossReference;
import org.eclipse.xtext.serializer.syntacticsequencertest.SyntacticsequencertestFactory;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.Provider;

@RunWith(XtextRunner.class)
@InjectWith(SyntacticSequencerTestLanguageInjectorProvider.class)
public class TokenSerializerTest {
	@Inject
	private ISerializer serializer;

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	private SyntacticsequencertestFactory factory = SyntacticsequencertestFactory.eINSTANCE;

	private void assertSerializesTo(Model model, CharSequence expectation) {
		Assert.assertEquals(expectation.toString().trim(), serializer.serialize(model).trim());
	}

	private URI getFileURI(String name) {
		return URI.createFileURI(name + "." + fileExtensionProvider.getPrimaryFileExtension());
	}

	@Test
	public void testConstructedCrossReferenceWithProxy() {
		XtextResourceSet resourceSet = resourceSetProvider.get();
		XtextResource resource = (XtextResource) resourceSet.createResource(getFileURI("dummy"));
		Model model = factory.createModel();
		SingleCrossReference myRef = factory.createSingleCrossReference();
		myRef.setName("myref");
		model.setX5(myRef);
		resource.getContents().add(model);
		SingleCrossReference singleRef = model.getX5();
		SingleCrossReference fooProxyRef = factory.createSingleCrossReference();
		((InternalEObject) fooProxyRef).eSetProxyURI(resource.getURI().appendFragment("foo"));
		singleRef.setRef3(fooProxyRef);
		resource.setFragmentProvider(new DefaultFragmentProvider() {
			@Override
			public EObject getEObject(Resource resource, String fragment, IFragmentProvider.Fallback fallback) {
				if ("foo".equals(fragment)) {
					return model.getX5();
				} else {
					return super.getEObject(resource, fragment, fallback);
				}
			}
		});
		assertSerializesTo(model, "#5 myref kw3 myref");
	}
}
