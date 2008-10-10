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
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.parsetree.SyntaxError;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.metamodel.Xtext2EcoreTransformer;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class ToEcoreTrafoTest extends AbstractGeneratorTest {
	private static final Logger logger = Logger.getLogger(ToEcoreTrafoTest.class);
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	public void testAbstractLanguageToMetamodel() throws Exception {
		XtextResource r = getResource("classpath:/" + AbstractTestLanguage.class.getName().replace('.', '/') + ".xtext");
		Grammar element = (Grammar) r.getParseResult().getRootASTElement();
		if (!r.getParseResult().getParseErrors().isEmpty()) {
			List<SyntaxError> errors = r.getParseResult().getParseErrors();
			for (SyntaxError syntaxError : errors) {
				logger.debug(syntaxError.getMessage() + " - " + syntaxError.getNode().getLine());
			}
			fail();
		}
		List<LexerRule> lexerRules = GrammarUtil.allLexerRules(element);
		assertEquals(8, lexerRules.size());
		for (LexerRule lexerRule : lexerRules) {
			logger.debug(lexerRule.getName());
		}

		Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer();
		List<EPackage> list = transformer.transform(element);
		assertNotNull(list);
		assertEquals(0, list.size());
	}

	public void testConcreteLanguageToMetamodel() throws Exception {
		XtextResource r = getResource("classpath:/" + ConcreteTestLanguage.class.getName().replace('.', '/') + ".xtext");
		Grammar element = (Grammar) r.getParseResult().getRootASTElement();
		List<LexerRule> lexerRules = GrammarUtil.allLexerRules(element);
		assertEquals(8, lexerRules.size());
		for (LexerRule lexerRule : lexerRules) {
			logger.debug(lexerRule.getName());
		}
		Xtext2EcoreTransformer transformer = new Xtext2EcoreTransformer();
		List<EPackage> list = transformer.transform(element);
		EPackage metaModel = list.get(0);
		assertNotNull(metaModel);
		assertNotNull(metaModel.getNsPrefix());
		assertNotNull(metaModel.getNsURI());
		assertNotNull(metaModel.getName());
		EList<EClassifier> types = metaModel.getEClassifiers();
		EClass type = (EClass) types.get(0);
		EStructuralFeature feature = type.getEStructuralFeature("elements");
		assertNotNull(feature.getEType());
	}

	@SuppressWarnings("unchecked")
	public void testConcreteLanguageToMetamodel1() throws Exception {
		XtextResource r = getResource("classpath:/" + ConcreteTestLanguage.class.getName().replace('.', '/') + ".xtext");
		EObject element = r.getParseResult().getRootASTElement();
		List<EPackage> mms = (List<EPackage>) invokeWithXtend("getGeneratedEPackages(this)", element);
		assertNotNull(mms);
		assertEquals(1, mms.size());
	}

	private XtextResource getResource(String uri) {
		XtextResourceSet set = new XtextResourceSet();
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
		return new String[] { "org::eclipse::xtext::xtext2ecore::Xtext2Ecore" };
	}
}
