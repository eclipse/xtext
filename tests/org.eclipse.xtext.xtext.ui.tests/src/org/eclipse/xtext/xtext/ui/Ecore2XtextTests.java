package org.eclipse.xtext.xtext.ui;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectInfo;

public class Ecore2XtextTests extends AbstractXtextTests {

	private static final List<String> MINIMUM_PACKAGE_NS_URIS = Arrays
			.asList(new String[] { "http://www.eclipse.org/emf/2002/Ecore",
					"http://www.eclipse.org/2008/Xtext",
					"http://simple/formattertestlanguage" });

	private static final List<String> BROKEN_PACKAGE_NS_URIS = Arrays
			.asList(new String[] { "http://www.eclipse.org/ocl/1.1.0/Ecore" });

	private static final List<String> WARNING_PACKAGE_NS_URIS = Arrays
			.asList(new String[] { "http://www.eclipse.org/OCL2/1.0.0/ocl/uml" });

	public void testCreateErrorFreeGrammar() throws IOException {
		XtextStandaloneSetup.doSetup();
		Collection<String> keySet =
		// new HashSet<String>(EPackage.Registry.INSTANCE.keySet())
		MINIMUM_PACKAGE_NS_URIS;
		for (String nsURI : keySet) {
			EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsURI);
			XtextProjectInfo xtextProjectInfo = new XtextProjectInfo();
			Set<EPackage> ePackages = new HashSet<EPackage>();
			if (addImportedEPackages(ePackage, ePackages)) {
				System.out.print(nsURI);
				OutputStringImpl output = new OutputStringImpl();
				xtextProjectInfo.setEPackagesForRules(ePackages);
				String languageName = "org.eclipse.xtext.xtext.ui.tests."
						+ ePackage.getName();
				xtextProjectInfo.setLanguageName(languageName);
				XpandExecutionContextImpl executionContext = new XpandExecutionContextImpl(
						output, null);
				executionContext.registerMetaModel(new JavaBeansMetaModel());
				XpandFacade xpandFacade = XpandFacade.create(executionContext);
				xpandFacade
						.evaluate2(
								"org::eclipse::xtext::xtext::ui::wizard::project::XtextFromEcore::grammar",
								xtextProjectInfo, null);
				String grammarFileName = languageName.replaceAll("\\.", "/")
						+ ".xtext";
				String xtextGrammar = output.getContent(grammarFileName);
				ResourceSet resourceSet = new XtextResourceSet();
				Resource xtextResource = resourceSet.createResource(URI
						.createFileURI(grammarFileName));
				xtextResource.load(new StringInputStream(xtextGrammar), null);
				assertTrue("Errors in grammar for " + ePackage.getNsURI(),
						xtextResource.getErrors().isEmpty());
				if (!WARNING_PACKAGE_NS_URIS.contains(ePackage.getNsURI())) {
					assertTrue(
							"Warnings in grammar for " + ePackage.getNsURI(),
							xtextResource.getWarnings().isEmpty());
				}
				System.out.println(" ...OK");
			}
		}
	}

	private boolean addImportedEPackages(EPackage ePackage,
			Set<EPackage> importedEPackages) {
		if (BROKEN_PACKAGE_NS_URIS.contains(ePackage.getNsURI())) {
			return false;
		}
		if (importedEPackages.add(ePackage)) {
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					for (EStructuralFeature feature : ((EClass) eClassifier)
							.getEAllStructuralFeatures()) {
						if (!feature.isTransient() && !feature.isDerived()) {
							EPackage referencedEPackage = feature.getEType()
									.getEPackage();
							if (referencedEPackage == null) {
								return false;
							}
							if (feature instanceof EAttribute) {
								if (((EAttribute) feature).getEAttributeType()
										.isSerializable()) {
									if (!addImportedEPackages(
											referencedEPackage,
											importedEPackages)) {
										return false;
									}
								}
							}
							if (feature instanceof EReference) {
								if (((EReference) feature).isContainment()) {
									if (!addImportedEPackages(
											referencedEPackage,
											importedEPackages)) {
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
