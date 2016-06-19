/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal

import com.google.inject.Guice
import com.google.inject.Inject
import java.io.BufferedOutputStream
import java.io.ByteArrayOutputStream
import java.util.Collections
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.IFormatter2
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.FormattertestlanguageFactory
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList
import org.eclipse.xtext.resource.IResourceFactory
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(InjectorProvider)
class FormatterSerializerIntegrationTest {
	static class InjectorProvider extends FormatterTestLanguageInjectorProvider {
		override protected internalCreateInjector() {
			new Setup().createInjectorAndDoEMFRegistration()
		}
	}

	static class Setup extends FormatterTestLanguageStandaloneSetup {
		override createInjector() {
			return Guice.createInjector(new Module());
		}
	}

	static class Module extends FormatterTestLanguageRuntimeModule {
		def Class<? extends IFormatter2> bindIFormatter2() {
			return Formatter;
		}
	}

	static class Formatter extends AbstractFormatter2 {
		def dispatch format(IDList model, extension IFormattableDocument document) {
			model.regionFor.keyword("idlist").append[space = "  "]
		}
	}

	@Inject IResourceFactory factory;

	@Test def void testFormatterIntegrationWithSerializer() {
		val resource = factory.createResource(URI.createURI("dummy.ext"))
		new ResourceSetImpl().resources.add(resource)
		val model = FormattertestlanguageFactory.eINSTANCE.createIDList
		model.ids += "foo"
		resource.contents += model
		val out = new ByteArrayOutputStream
		resource.save(new BufferedOutputStream(out), Collections.emptyMap)
		Assert.assertEquals('idlist  foo', out.toString)
	}
}

