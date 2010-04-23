/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import java.nio.charset.Charset;
import java.util.Collections;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.reconciler.XtextDocumentReconcileStrategy;
import org.eclipse.xtext.ui.junit.editor.contentassist.AbstractContentAssistProcessorTest;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.testlanguages.ContentAssistTestLanguageRuntimeModule;
import org.eclipse.xtext.ui.tests.testlanguages.ContentAssistTestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.tests.testlanguages.services.ContentAssistTestLanguageGrammarAccess;
import org.eclipse.xtext.ui.tests.testlanguages.ui.ContentAssistTestLanguageUiModule;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug297909Test extends AbstractContentAssistProcessorTest {
	
	public ISetup getSetup() {
		return new ContentAssistTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(Modules2.mixin(new ContentAssistTestLanguageRuntimeModule(), new ContentAssistTestLanguageUiModule(Activator
						.getInstance()), new SharedStateModule()));
			}
			
			@Override
			public void register(Injector injector) {
				super.register(injector);
				// simulate a EPackage that was not registered
				EPackage.Registry.INSTANCE.remove("http://www.eclipse.org/2008/xtext/ui/common/tests/ContentAssist");
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().remove("contentassisttestlanguage");
			}
		};
	}
	
	public void testGrammarAccessCannotResolveEClasses() {
		Injector injector = getSetup().createInjectorAndDoEMFRegistration();
		ContentAssistTestLanguageGrammarAccess grammarAccess = injector.getInstance(ContentAssistTestLanguageGrammarAccess.class);
		AbstractRule firstRule = grammarAccess.getGrammar().getRules().get(0);
		EClassifier classifier = firstRule.getType().getClassifier();
		assertTrue(classifier.eIsProxy());
	}

	public void testExceptionOnContentAssist() throws Exception {
		try {
			newBuilder(getSetup()).append("abstract rules firstRule ").assertCount(0);
			fail("Expected ParseException");
		} catch(ParseException expected) {
			assertTrue(expected.getMessage().contains("Make sure the EPackage has been registered"));
		}
	}
	
	public void testReconcileDocument() throws Exception {
		Injector injector = getSetup().createInjectorAndDoEMFRegistration();
		XtextDocument document = injector.getInstance(XtextDocument.class);
		document.setValidationJob(new Job("Job") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				return Status.OK_STATUS;
			}
		});
		XtextResource resource = injector.getInstance(XtextResource.class);
		resource.load(new StringInputStream(""), Collections.singletonMap(XtextResource.OPTION_ENCODING, Charset.defaultCharset().name()));
		document.setInput(resource);
		document.set("abstract rules firstRule");
		XtextDocumentReconcileStrategy strategy = injector.getInstance(XtextDocumentReconcileStrategy.class);
		strategy.setDocument(document);
		try {
			strategy.reconcile(new Region(0, document.getLength()));
			fail("Expected ParseException");
		} catch(ParseException expected) {
			assertTrue(expected.getMessage().contains("Make sure the EPackage has been registered"));
		}
	}
}
