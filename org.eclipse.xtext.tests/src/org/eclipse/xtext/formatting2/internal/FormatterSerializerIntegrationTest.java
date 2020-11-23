/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.internal;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.FormattertestlanguageFactory;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList;
import org.eclipse.xtext.formatting2.internal.tests.FormatterTestLanguageInjectorProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(FormatterSerializerIntegrationTest.InjectorProvider.class)
public class FormatterSerializerIntegrationTest {
	public static class InjectorProvider extends FormatterTestLanguageInjectorProvider {
		@Override
		protected Injector internalCreateInjector() {
			return new Setup().createInjectorAndDoEMFRegistration();
		}
	}

	public static class Setup extends FormatterTestLanguageStandaloneSetup {
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new Module());
		}
	}

	public static class Module extends FormatterTestLanguageRuntimeModule {
		public Class<? extends IFormatter2> bindIFormatter2() {
			return Formatter.class;
		}
	}

	public static class Formatter extends AbstractJavaFormatter {
		protected void format(IDList model, IFormattableDocument document) {
			document.append(regionFor(model).keyword("idlist"), it -> it.setSpace("  "));
		}
	}

	@Inject
	private IResourceFactory factory;

	@Test
	public void testFormatterIntegrationWithSerializer() throws IOException {
		Resource resource = factory.createResource(URI.createURI("dummy.ext"));
		new ResourceSetImpl().getResources().add(resource);
		IDList model = FormattertestlanguageFactory.eINSTANCE.createIDList();
		model.getIds().add("foo");
		resource.getContents().add(model);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		resource.save(new BufferedOutputStream(out), Collections.emptyMap());
		Assert.assertEquals("idlist  foo", out.toString());
	}
}
