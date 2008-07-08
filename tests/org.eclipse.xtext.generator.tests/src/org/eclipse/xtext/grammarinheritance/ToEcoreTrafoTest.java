package org.eclipse.xtext.grammarinheritance;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.parsetree.SyntaxError;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.xtextutil.AbstractType;
import org.eclipse.xtext.xtextutil.ComplexType;
import org.eclipse.xtext.xtextutil.Feature;
import org.eclipse.xtext.xtextutil.MetaModel;
import org.eclipse.xtext.xtextutil.XtextutilPackage;

public class ToEcoreTrafoTest extends AbstractGeneratorTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		XtextutilPackage.eINSTANCE.getAbstractType();
	}
	
	@SuppressWarnings("unchecked")
	public void testAbstractLanguageToMetamodel() throws Exception {
		XtextResource r = getResource("classpath:/"+AbstractTestLanguage.class.getName().replace('.', '/')+".xtext");
		Grammar element = (Grammar) r.getParseResult().getRootASTElement();
		if (!r.getParseResult().getParseErrors().isEmpty()) {
			List<SyntaxError> errors = r.getParseResult().getParseErrors();
			for (SyntaxError syntaxError : errors) {
				System.out.println(syntaxError.getMessage()+" - "+syntaxError.getNode().getLine());
			}
			fail();
		}
		List<LexerRule> lexerRules = GrammarUtil.allLexerRules(element);
		assertEquals(9, lexerRules.size());
		for (LexerRule lexerRule : lexerRules) {
			System.out.println(lexerRule.getName());
		}
		List<MetaModel> mms = (List<MetaModel>) invokeWithXtend("getAllMetaModels(this)", element);
		assertNotNull(mms);
		assertEquals(2,mms.size());
		for (MetaModel metaModel : mms) {
			assertNotNull(metaModel.getDeclaration());
			assertNotNull(((ReferencedMetamodel)metaModel.getDeclaration()).getUri());
		}
	}
	
	@SuppressWarnings("unchecked")
	public void testConcreteLanguageToMetamodel() throws Exception {
		XtextResource r = getResource("classpath:/"+ConcreteTestLanguage.class.getName().replace('.', '/')+".xtext");
		Grammar element = (Grammar) r.getParseResult().getRootASTElement();
		List<LexerRule> lexerRules = GrammarUtil.allLexerRules(element);
		assertEquals(9, lexerRules.size());
		for (LexerRule lexerRule : lexerRules) {
			System.out.println(lexerRule.getName());
		}
		GrammarUtil.getReturnTypeName(GrammarUtil.findRuleForName(element, "REAL"));
		List<MetaModel> mms = (List<MetaModel>) invokeWithXtend("getAllMetaModels(this)", element);
		assertNotNull(mms);
		assertEquals(3,mms.size());
		for (MetaModel metaModel : mms) {
			assertNotNull(metaModel.getDeclaration());
			EList<AbstractType> types = metaModel.getTypes();
			for (AbstractType abstractType : types) {
				assertNotNull(abstractType);
				if (abstractType instanceof ComplexType) {
					ComplexType ct = (ComplexType) abstractType;
					EList<Feature> features = ct.getFeatures();
					for (Feature feature : features) {
						assertNotNull(feature);
						assertNotNull(feature.getName(), feature.getType());
					}
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void testConcreteLanguageToMetamodel1() throws Exception {
		try {
			XtextResource r = getResource("classpath:/"+ConcreteTestLanguage.class.getName().replace('.', '/')+".xtext");
			EObject element = r.getParseResult().getRootASTElement();
			List<EPackage> mms = (List<EPackage>) invokeWithXtend("getGeneratedEPackages(this)", element);
			assertNotNull(mms);
			assertEquals(1,mms.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private XtextResource getResource(String uri) {
		XtextResourceSet set = new XtextResourceSet();
		XtextResource r = (XtextResource) set.getResource(URI.createURI(uri),true);
		return r;
	}
	
	@Override
	protected String[] importedExtensions() {
		return new String[]{
				"org::eclipse::xtext::XtextUtil",
				"org::eclipse::xtext::xtext2ecore::Xtext2Ecore"
		};
	}
}
