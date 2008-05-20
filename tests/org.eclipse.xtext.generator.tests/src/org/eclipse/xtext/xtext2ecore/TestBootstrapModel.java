/*******************************************************************************
 * Copyright (c) 2008 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.xtext2ecore;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2t.type.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextLanguageFacade;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.parser.XtextASTFactory;
import org.eclipse.xtext.parser.XtextParser;
import org.eclipse.xtext.xtextutil.XtextutilPackage;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.xtend.XtendFacade;

/**
 * @author Jan Köhnlein
 * 
 */
public class TestBootstrapModel extends TestCase {

	@SuppressWarnings("unchecked")
	public void testParseXtextGrammarTransformXtend() throws IOException, RecognitionException, InterruptedException {
		XtextStandaloneSetup.doSetup();
		
		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(
				"org/eclipse/xtext/XTextGrammarTest.xtext");

		// TODO make Xtext2Factory manual so one can overwrite' getEPackages' in
		// order to support generated epackages
		EPackage.Registry.INSTANCE.put(XtextLanguageFacade.XTEXT_NS_URI, XtextPackage.eINSTANCE);
		XtextParser xtext2Parser = new XtextParser();
		Grammar grammarModel = (Grammar) xtext2Parser.parse(resourceAsStream, new XtextASTFactory());

		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource grammarResource = resourceSet.createResource(URI.createFileURI("xtext.xmi"));
		grammarResource.getContents().add(grammarModel);
		// grammarResource.save(null);

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());

		EmfRegistryMetaModel emfRegistryMetaModel = new EmfRegistryMetaModel() {
			EPackage[] packages = new EPackage[] { XtextPackage.eINSTANCE, XtextutilPackage.eINSTANCE,
					EcorePackage.eINSTANCE };

			@Override
			protected EPackage[] allPackages() {
				return packages;
			}
		};

		ExecutionContextImpl executionContext = new ExecutionContextImpl();
		executionContext.registerMetaModel(emfRegistryMetaModel);
		XtendFacade facade = XtendFacade.create(executionContext, "org::eclipse::xtext::xtext2ecore::Xtext2Ecore");
		List<EPackage> result = (List<EPackage>) facade.call("transform", grammarModel);

		Resource generatedGrammarMetaModelResource = resourceSet.createResource(URI
				.createFileURI("xtext_generated.ecore"));
		generatedGrammarMetaModelResource.getContents().addAll(result);
		// generatedGrammarMetaModelResource.save(null);

		Resource originalGrammarMetaModelResource;
		if (XtextPackage.eINSTANCE.eResource() == null) {
			originalGrammarMetaModelResource = resourceSet.createResource(URI.createURI(XtextPackage.eINSTANCE
					.getNsURI()));
		} else {
			originalGrammarMetaModelResource = XtextPackage.eINSTANCE.eResource();
		}

		EcoreModelComparator ecoreModelComparator = new EcoreModelComparator();
		ecoreModelComparator.addIgnoredFeature(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME);
		ecoreModelComparator.addIgnoredFeature(EcorePackage.Literals.ECLASSIFIER__INSTANCE_TYPE_NAME);
		ecoreModelComparator.addIgnoredFeature(EcorePackage.Literals.EPACKAGE__NS_URI);
		ecoreModelComparator.addIgnoredFeature(EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		ecoreModelComparator.addIgnoredFeature(EcorePackage.Literals.EPACKAGE__NS_PREFIX);
		assertFalse(ecoreModelComparator.modelsDiffer(originalGrammarMetaModelResource,
				generatedGrammarMetaModelResource));
	}
}
