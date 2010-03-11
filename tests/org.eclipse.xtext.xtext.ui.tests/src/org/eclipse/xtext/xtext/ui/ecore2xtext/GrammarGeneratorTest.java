/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.ecore2xtext;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xtext.ui.OutputStringImpl;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.EPackageInfo;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.Ecore2XtextProjectInfo;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author koehnlein - Initial contribution and API
 */
public class GrammarGeneratorTest extends AbstractXtextTests {

	private static final List<String> EXAMPLE_EPACKAGE_NS_URIS = Arrays.asList(new String[] {
			"http://www.eclipse.org/emf/2002/Ecore", "http://www.eclipse.org/2008/Xtext",
			"http://simple/formattertestlanguage", "http://www.w3.org/XML/1998/namespace" });

	private static final List<String> BROKEN_PACKAGE_NS_URIS = Arrays
			.asList(new String[] { "http://www.eclipse.org/ocl/1.1.0/Ecore" });

	private static final List<String> WARNING_PACKAGE_NS_URIS = Arrays
			.asList(new String[] { "http://www.eclipse.org/OCL2/1.0.0/ocl/uml" });

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		XtextStandaloneSetup.doSetup();
	}

	public void testExampleEPackages() throws IOException {
		checkGeneratedGrammarIsValid(EXAMPLE_EPACKAGE_NS_URIS);
	}

	/*
	// Smoke test 
	public void testAllEPackagesFromRegistry() throws IOException {
		checkGeneratedGrammarIsValid(Lists.newArrayList(EPackage.Registry.INSTANCE.keySet()));
	}
	*/

	private void checkGeneratedGrammarIsValid(List<String> ePackageURIs) throws IOException {
		for (String nsURI : ePackageURIs) {
			System.out.print(nsURI);
			EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsURI);
			Ecore2XtextProjectInfo xtextProjectInfo = new Ecore2XtextProjectInfo();
			Set<EPackage> ePackages = new HashSet<EPackage>();
			if (!addImportedEPackages(ePackage, ePackages)) {
				System.out.println("...skipping");
			} else {
				OutputStringImpl output = new OutputStringImpl();
				Collection<EPackageInfo> ePackageInfos = Lists.newArrayList(Iterables.transform(ePackages,
						new Function<EPackage, EPackageInfo>() {
							public EPackageInfo apply(EPackage from) {
								return new EPackageInfo(from, URI.createURI(from.getNsURI()), null, null, null);
							}
						}));
				xtextProjectInfo.setEPackageInfos(ePackageInfos);
				String languageName = "org.eclipse.xtext.xtext.ui.tests." + ePackage.getName();
				xtextProjectInfo.setLanguageName(languageName);
				XpandExecutionContextImpl executionContext = new XpandExecutionContextImpl(output, null);
				executionContext.registerMetaModel(new JavaBeansMetaModel());
				XpandFacade xpandFacade = XpandFacade.create(executionContext);
				xpandFacade.evaluate2("org::eclipse::xtext::xtext::ui::wizard::ecore2xtext::Ecore2Xtext::grammar",
						xtextProjectInfo, null);
				String grammarFileName = languageName.replaceAll("\\.", "/") + ".xtext";
				String xtextGrammar = output.getContent(grammarFileName);
				ResourceSet resourceSet = new XtextResourceSet();
				Resource xtextResource = resourceSet.createResource(URI.createFileURI(grammarFileName));
				xtextResource.load(new StringInputStream(xtextGrammar), null);
				checkErrors(ePackage, xtextResource, xtextGrammar);
				if (!WARNING_PACKAGE_NS_URIS.contains(ePackage.getNsURI())) {
					assertTrue("Warnings in grammar for " + ePackage.getNsURI(), xtextResource.getWarnings().isEmpty());
				}
				System.out.println(" ...OK");
			}
		}
	}

	private void checkErrors(EPackage ePackage, Resource xtextResource, String xtextGrammar) {
		EList<Diagnostic> errors = xtextResource.getErrors();
		if (!errors.isEmpty()) {
			System.out.println(xtextGrammar);
			fail("Errors in grammar for " + ePackage.getNsURI() + ":" + errors.get(0).getMessage());
		}
	}

	private boolean addImportedEPackages(EPackage ePackage, Set<EPackage> importedEPackages) {
		if (BROKEN_PACKAGE_NS_URIS.contains(ePackage.getNsURI())) {
			return false;
		}
		if (importedEPackages.add(ePackage)) {
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					for (EStructuralFeature feature : ((EClass) eClassifier).getEAllStructuralFeatures()) {
						if (!feature.isTransient() && !feature.isDerived()) {
							EPackage referencedEPackage = feature.getEType().getEPackage();
							if (referencedEPackage == null) {
								return false;
							}
							if (feature instanceof EAttribute) {
								if (((EAttribute) feature).getEAttributeType().isSerializable()) {
									if (!addImportedEPackages(referencedEPackage, importedEPackages)) {
										return false;
									}
								}
							}
							if (feature instanceof EReference) {
								if (((EReference) feature).isContainment()) {
									if (!addImportedEPackages(referencedEPackage, importedEPackages)) {
										return false;
									}
								}
							}
						}
					}
				}
			}
		}
		return true;
	}
}
