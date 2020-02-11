/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.DefaultFragmentProvider
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.serializer.syntacticsequencertest.Model
import org.eclipse.xtext.serializer.syntacticsequencertest.SyntacticsequencertestFactory
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(SyntacticSequencerTestLanguageInjectorProvider)
class TokenSerializerTest {
	
	@Inject extension ISerializer
	
	@Inject FileExtensionProvider fileExtensionProvider
	
	@Inject Provider<XtextResourceSet> resourceSetProvider
	
	val factory = SyntacticsequencertestFactory.eINSTANCE
	
	private def assertSerializesTo(Model model, CharSequence expectation) {
		assertEquals(expectation.toString.trim, model.serialize.trim)
	}
	
	private def getFileURI(String name) {
		URI.createFileURI(name + '.' + fileExtensionProvider.primaryFileExtension)
	}
	
	@Test
	def void testConstructedCrossReferenceWithProxy() {
		val resourceSet = resourceSetProvider.get
		val resource = resourceSet.createResource('dummy'.fileURI) as XtextResource
		val model = factory.createModel => [
			x5 = factory.createSingleCrossReference => [
				name = 'myref'
			]
		]
		resource.contents += model
		model.x5.ref3 = factory.createSingleCrossReference => [
			(it as InternalEObject).eSetProxyURI(resource.URI.appendFragment('foo'))
		]
		resource.fragmentProvider = new DefaultFragmentProvider {
			override getEObject(Resource resource, String fragment, Fallback fallback) {
				if (fragment == 'foo')
					model.x5
				else
					super.getEObject(resource, fragment, fallback)
			}
		}
		model.assertSerializesTo('''
			#5 myref kw3 myref
		''')
	}
	
}