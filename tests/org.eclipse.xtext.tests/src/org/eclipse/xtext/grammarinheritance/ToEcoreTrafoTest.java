package org.eclipse.xtext.grammarinheritance;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.xtext.ecoreInference.Xtext2EcoreTransformer;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class ToEcoreTrafoTest extends AbstractGeneratorTest {
	private static final Logger logger = Logger.getLogger(ToEcoreTrafoTest.class);

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new XtextStandaloneSetup());
	}

	public void testAbstractLanguageToMetamodel() throws Exception {
		XtextResource r = getResource("classpath:/" + AbstractTestLanguage.class.getName().replace('.', '/') + ".xtext");
		Grammar element = (Grammar) r.getParseResult().getRootASTElement();
		if (!r.getErrors().isEmpty()) {
			EList<Diagnostic> errors = r.getErrors();
			for (Diagnostic syntaxError : errors) {
				logger.debug(syntaxError.getMessage() + " - " + syntaxError.getLine());
			}
			fail();
		}
		List<TerminalRule> lexerRules = GrammarUtil.allTerminalRules(element);
		assertEquals(8, lexerRules.size());

		List<EPackage> list = Xtext2EcoreTransformer.doGetGeneratedPackages(element);
		assertNotNull(list);
		assertEquals(0, list.size());
	}

	public void testConcreteLanguageToMetamodel() throws Exception {
		XtextResource r = getResource("classpath:/" + ConcreteTestLanguage.class.getName().replace('.', '/') + ".xtext");
		Grammar element = (Grammar) r.getParseResult().getRootASTElement();
		List<TerminalRule> lexerRules = GrammarUtil.allTerminalRules(element);
		assertEquals(8, lexerRules.size());
		List<EPackage> list = Xtext2EcoreTransformer.doGetGeneratedPackages(element);
		EPackage metaModel = list.get(0);
		assertNotNull(metaModel);
		assertNotNull(metaModel.getNsPrefix());
		assertNotNull(metaModel.getNsURI());
		assertNotNull(metaModel.getName());
		EList<EClassifier> types = metaModel.getEClassifiers();
		EClass type = (EClass) types.get(1);
		EStructuralFeature feature = type.getEStructuralFeature("elements");
		assertNotNull(feature.getEType());
	}

	public void testConcreteLanguageToMetamodel1() throws Exception {
		XtextResource r = getResource("classpath:/" + ConcreteTestLanguage.class.getName().replace('.', '/') + ".xtext");
		EObject element = r.getParseResult().getRootASTElement();
		Grammar g = (Grammar) element;
		List<AbstractMetamodelDeclaration> mms = Lists.<AbstractMetamodelDeclaration>newArrayList(
				Iterables.filter(g.getMetamodelDeclarations(), GeneratedMetamodel.class));
		assertNotNull(mms);
		assertEquals(1, mms.size());
	}

	private XtextResource getResource(String uri) {
		XtextResourceSet set = get(XtextResourceSet.class);
		set.setClasspathURIContext(getClass().getClassLoader());
		// if(AllTests.isPluginContext) {
		// set.setClasspathUriResolver(new BundleClasspathUriResolver());
		// set.setClasspathURIContext(Activator.getDefault());
		// }
		XtextResource r = (XtextResource) set.getResource(URI.createURI(uri), true);
		return r;
	}

	@Override
	protected String[] importedExtensions() {
		return new String[] { "org::eclipse::xtext::ecore::Xtext2Ecore" };
	}
}
