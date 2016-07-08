/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.refactoring;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.junit4.Flaky;
import org.eclipse.xtext.junit4.ui.AbstractLinkedEditingIntegrationTest;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.TargetPlatformUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring.ui.RenameRefactoringController;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xtext.ui.Activator;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XtextGrammarRefactoringIntegrationTest extends AbstractLinkedEditingIntegrationTest {

	private static final String REFACTOREDCLASSIFIERNAME = "Greeting123";
	@Inject
	private RenameRefactoringController renameRefactoringController;

	private IProject project;
	private static final String TEST_PROJECT = "refactoring.test";
	private static final String GRAMMAR_FILE = TEST_PROJECT + "/src/org/xtext/example/mydsl/" + "MyDsl.xtext";
	private static final String ECORE_FILE = TEST_PROJECT + "/src/org/xtext/example/mydsl/" + "MyDsl.ecore";
	private static final String CLASSIFIERNAME = "Greeting";
	private String grammar;
	private IFile grammarFile;
	private URI ecoreURI;
	private URI grammarUri;
	private EPackage initialModelRoot;
	protected Change undoChange;
	private URI greetingParserRuleUri;
	private URI modelParserRuleUri;
	
	@BeforeClass
	public static void setupTargetPlatform() throws Exception {
		TargetPlatformUtil.setTargetPlatform();
	}
	
	@Rule
	public Flaky.Rule flakyRule = new Flaky.Rule();

	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	@SuppressWarnings("static-access")
	@Override
	public void setUp() throws Exception {
		super.setUp();
		EcoreRefactoringParticipant.setDisableWarning(true);
		project = createProject(TEST_PROJECT);
		IJavaProject javaProject = makeJavaProject(project);
		addNature(javaProject.getProject(), XtextProjectHelper.NATURE_ID);
		Injector injector = Activator.getInstance().getInjector(getEditorId());
		injector.injectMembers(this);
		grammar = "grammar org.xtext.example.mydsl.MyDsl\n hidden(WS) generate myDsl\n 'http://testrefactoring'\n import 'http://www.eclipse.org/emf/2002/Ecore'\n as ecore \nModel: greetings+="
				+ CLASSIFIERNAME
				+ "*; \n"
				+ CLASSIFIERNAME
				+ ": 'Hello' name=ID '!';\n terminal ID : '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;\n terminal WS: (' '|'\t'|'\r'|'\n')+;";
		grammarFile = IResourcesSetupUtil.createFile(GRAMMAR_FILE, grammar);
		grammarUri = URI.createPlatformResourceURI(GRAMMAR_FILE, true);
		EcoreFactory eInstance = EcoreFactory.eINSTANCE;
		initialModelRoot = eInstance.createEPackage();
		initialModelRoot.setName("myDsl");
		initialModelRoot.setNsPrefix("myDsl");
		initialModelRoot.setNsURI("http://testrefactoring");
		EClass modelClass = eInstance.createEClass();
		modelClass.setName("Model");
		EClass greetingClass = eInstance.createEClass();
		EAttribute nameAttribute = eInstance.createEAttribute();
		nameAttribute.setEType(EcorePackage.Literals.ESTRING);
		nameAttribute.setName("name");
		greetingClass.getEStructuralFeatures().add(nameAttribute);
		greetingClass.setName(CLASSIFIERNAME);
		EReference reference = eInstance.createEReference();
		reference.setName("greetings");
		reference.setLowerBound(0);
		reference.setUpperBound(-1);
		reference.setEType(greetingClass);
		modelClass.getEStructuralFeatures().add(reference);
		initialModelRoot.getEClassifiers().add(modelClass);
		initialModelRoot.getEClassifiers().add(greetingClass);
		ecoreURI = URI.createPlatformResourceURI(ECORE_FILE, true);
		Resource grammarResource = resourceSetProvider.get().getResource(grammarUri, true);
		ParserRule greetingsParserRule = Iterables
				.filter(EcoreUtil2.getAllContentsOfType(grammarResource.getContents().get(0), ParserRule.class),
						new Predicate<ParserRule>() {

							@Override
							public boolean apply(ParserRule input) {
								return input.getName().equals(CLASSIFIERNAME);
							}

						}).iterator().next();
		ParserRule modelParserRule = Iterables
				.filter(EcoreUtil2.getAllContentsOfType(grammarResource.getContents().get(0), ParserRule.class),
						new Predicate<ParserRule>() {

							@Override
							public boolean apply(ParserRule input) {
								return input.getName().equals("Model");
							}

						}).iterator().next();
		greetingParserRuleUri = EcoreUtil.getURI(greetingsParserRule);
		modelParserRuleUri = EcoreUtil.getURI(modelParserRule);
		grammarResource.unload();
	}

	@Test
	@Flaky
	public void testRefactorXtextGrammarWithoutGeneratedClassifier() throws Exception {
		waitForBuild();
		final XtextEditor editor = openEditor(grammarFile);
		doRefactoring(editor);
		waitForReconciler(editor);
		waitForDisplay();
		waitForBuild();
		checkConsistenceOfGrammar(editor);
	}

	@Test
	@Flaky
	public void testRefactorXtextGrammarWithGeneratedClassifier() throws Exception {
		ResourceSet rs = resourceSetProvider.get();
		Resource ecoreResource = createEcoreModel(rs, ecoreURI, initialModelRoot);
		final EClass greetingClass = getGreetingClass(ecoreResource);
		final EReference greetingRef = getReferenceoGreeting(ecoreResource, greetingClass);
		String greetingClassFragment = EcoreUtil.getURI(greetingClass).fragment();
		String greetingRefFragment = EcoreUtil.getURI(greetingRef).fragment();
		ecoreResource.unload();
		waitForBuild();
		final XtextEditor editor = openEditor(grammarFile);
		doRefactoring(editor);
		waitForBuild();
		checkConsistenceOfGrammar(editor);
		ecoreResource.load(null);
		assertEquals(REFACTOREDCLASSIFIERNAME, SimpleAttributeResolver.NAME_RESOLVER.apply(ecoreResource
				.getEObject(greetingClassFragment.replaceFirst(CLASSIFIERNAME, REFACTOREDCLASSIFIERNAME))));
		EReference greetingReference = (EReference) ecoreResource.getEObject(greetingRefFragment);
		EClassifier eType = greetingReference.getEType();
		assertFalse(eType.eIsProxy());
		assertEquals(REFACTOREDCLASSIFIERNAME, eType.getName());
	}

	@Test
	@Flaky(trials=10)
	public void testRefactorXtextGrammarWithGeneratedClassifierAndModelWithRefToClassifier() throws Exception {
		ResourceSet rs = resourceSetProvider.get();
		EcoreFactory eInstance = EcoreFactory.eINSTANCE;
		Resource ecoreModelResource = createEcoreModel(rs, ecoreURI, initialModelRoot);
		EClass greetingClass = getGreetingClass(ecoreModelResource);
		EReference greetingRefLocal = getReferenceoGreeting(ecoreModelResource, greetingClass);
		String greetingClassFragment = EcoreUtil.getURI(greetingClass).fragment();
		String greetingRefFragment = EcoreUtil.getURI(greetingRefLocal).fragment();

		EPackage refPackage = eInstance.createEPackage();
		refPackage.setName("myDsl2");
		refPackage.setNsPrefix("myDsl2");
		refPackage.setNsURI("http://testrefactoring2");
		EClass modelRefClass = eInstance.createEClass();
		refPackage.getEClassifiers().add(modelRefClass);
		modelRefClass.setName("ModelRef");
		EReference reference = eInstance.createEReference();
		reference.setName("ref");
		reference.setLowerBound(0);
		reference.setUpperBound(-1);
		reference.setEType(greetingClass);
		modelRefClass.getEStructuralFeatures().add(reference);
		Resource refToGreetingResource = createEcoreModel(rs,
				URI.createPlatformResourceURI(TEST_PROJECT + "/src/org/xtext/example/mydsl/" + "MyDsl2.ecore", true),
				refPackage);
		refToGreetingResource.unload();
		ecoreModelResource.unload();
		waitForDisplay();
		XtextEditor editor = openEditor(grammarFile);
		doRefactoring(editor);
		waitForBuild();
		checkConsistenceOfGrammar(editor);
		ecoreModelResource.load(null);
		String renamedGreetingClassFragment = greetingClassFragment.replaceFirst(CLASSIFIERNAME, REFACTOREDCLASSIFIERNAME);
		EObject renamedGreetingClass = ecoreModelResource.getEObject(renamedGreetingClassFragment);
		assertNotNull(renamedGreetingClass);
		assertEquals(REFACTOREDCLASSIFIERNAME, SimpleAttributeResolver.NAME_RESOLVER.apply(renamedGreetingClass));
		EReference greetingReference = (EReference) ecoreModelResource.getEObject(greetingRefFragment);
		EClassifier eType = greetingReference.getEType();
		assertFalse(eType.eIsProxy());
		assertEquals(REFACTOREDCLASSIFIERNAME, eType.getName());

		refToGreetingResource.load(null);
		EReference externalReferenceToGreeting = getReferenceoGreeting(refToGreetingResource, eType);
		assertFalse(externalReferenceToGreeting.getEType().eIsProxy());
		assertEquals(REFACTOREDCLASSIFIERNAME, externalReferenceToGreeting.getEType().getName());

	}

	private EReference getReferenceoGreeting(Resource ecoreResource, final EClassifier classifier) {
		final EReference greetingRef = Iterables
				.filter(EcoreUtil2.getAllContentsOfType(ecoreResource.getContents().get(0), EReference.class),
						new Predicate<EReference>() {
							@Override
							public boolean apply(EReference input) {
								return input.getEType() == classifier;
							}
						}).iterator().next();
		return greetingRef;
	}

	private EClass getGreetingClass(Resource ecoreResource) {
		final EClass greetingClass = Iterables
				.filter(EcoreUtil2.getAllContentsOfType(ecoreResource.getContents().get(0), EClass.class),
						new Predicate<EClass>() {
							@Override
							public boolean apply(EClass input) {
								return input.getName().equals(CLASSIFIERNAME);
							}
						}).iterator().next();
		return greetingClass;
	}

	private Resource createEcoreModel(ResourceSet rs, URI uri, EObject rootElement) throws IOException {
		Resource ecoreResource = rs.createResource(uri);
		ecoreResource.getContents().add(rootElement);
		ecoreResource.save(null);
		return ecoreResource;
	}

	private XtextEditor doRefactoring(XtextEditor editor) throws Exception {
		final TextSelection selection = new TextSelection(grammar.indexOf(CLASSIFIERNAME), CLASSIFIERNAME.length());
		editor.getSelectionProvider().setSelection(selection);
		waitForDisplay();
		IRenameElementContext context = new IRenameElementContext.Impl(greetingParserRuleUri,
				XtextPackage.Literals.PARSER_RULE, editor, selection, grammarUri);
		renameRefactoringController.startRefactoring(context);
		waitForDisplay();
		pressKeys(editor, REFACTOREDCLASSIFIERNAME + "\n");
		waitForDisplay();
		return editor;
	}

	private void checkConsistenceOfGrammar(XtextEditor editor) {
		waitForBuild();
		assertEquals(REFACTOREDCLASSIFIERNAME, editor.getDocument().readOnly(new IUnitOfWork<String, XtextResource>() {
			@Override
			public String exec(XtextResource state) throws Exception {
				String renamedRuleFragment = greetingParserRuleUri.fragment()
						.replaceFirst(CLASSIFIERNAME, REFACTOREDCLASSIFIERNAME);
				EObject renamedRule = state.getEObject(renamedRuleFragment);
				assertNotNull(renamedRule);
				return SimpleAttributeResolver.NAME_RESOLVER.apply(renamedRule);
			}
		}));
		editor.getDocument().readOnly(new IUnitOfWork<Boolean, XtextResource>() {
			@Override
			public Boolean exec(XtextResource state) throws Exception {
				AbstractRule rule = ((RuleCall) ((Assignment) ((ParserRule) state.getEObject(modelParserRuleUri
						.fragment())).getAlternatives()).getTerminal()).getRule();
				assertFalse(rule.eIsProxy());
				assertEquals(REFACTOREDCLASSIFIERNAME, rule.getName());
				return true;
			}
		});

	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		EcoreRefactoringParticipant.setDisableWarning(false);
	}

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.Xtext";
	}
}
