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

import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2t.type.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.xtextutil.AbstractType;
import org.eclipse.xtext.xtextutil.ComplexType;
import org.eclipse.xtext.xtextutil.Feature;
import org.eclipse.xtext.xtextutil.MetaModel;
import org.eclipse.xtext.xtextutil.XtextutilPackage;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.xtend.XtendFacade;

/**
 * @author Jan Köhnlein
 * 
 */
public class TestBootstrapModel extends AbstractGeneratorTest {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		XtextutilPackage.eINSTANCE.getComplexType();
		with(XtextStandaloneSetup.class);
	}

	@SuppressWarnings("unchecked")
	public void testCreateXtextUtilModel() throws Exception {

		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(
				"org/eclipse/xtext/XTextGrammarTest.xtext");

		Grammar grammarModel = (Grammar) getModel(resourceAsStream);

		ExecutionContextImpl executionContext = new ExecutionContextImpl();
		executionContext.registerMetaModel(new EmfRegistryMetaModel());
		XtendFacade facade = XtendFacade.create(executionContext, "org::eclipse::xtext::XtextUtil");
		List<MetaModel> result = (List<MetaModel>) facade.call("getAllMetaModels", grammarModel);
		MetaModel xtext = (MetaModel) invokeWithXtend("select(e|e.alias()==null).first()", result);
		MetaModel ecore = (MetaModel) invokeWithXtend("select(e|e.alias()=='ecore').first()", result);
		assertEquals(15,xtext.getTypes().size());
		assertEquals(3,ecore.getTypes().size());
		
		for(AbstractType t : xtext.getTypes()) {
			System.out.println(t.getName()+" {");
			for (Feature f : ((ComplexType)t).getFeatures()) {
				System.out.println("\t"+f.getName()+" : "+f.getType().getQualifiedName()+" ("+f.getUpperBound()+")");
			}
			System.out.println("}");
		}
		
	}

	@SuppressWarnings("unchecked")
	public void testParseXtextGrammarTransformXtend() throws Exception {
		XtextStandaloneSetup.doSetup();

		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(
				"org/eclipse/xtext/XTextGrammarTest.xtext");

		Grammar grammarModel = (Grammar) getModel(resourceAsStream);

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
		List<EPackage> result = (List<EPackage>) facade.call("getAllEPackages", grammarModel);
		assertEquals(2,result.size());
		EPackage xtext = result.get(0);

		Resource generatedGrammarMetaModelResource = resourceSet.createResource(URI
				.createFileURI("xtext_generated.ecore"));
		generatedGrammarMetaModelResource.getContents().add(xtext);
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
