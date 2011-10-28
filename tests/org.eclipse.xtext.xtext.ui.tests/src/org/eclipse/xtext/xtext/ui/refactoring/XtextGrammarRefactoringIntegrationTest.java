/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.refactoring;

import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil.*;

import java.io.IOException;

import org.apache.log4j.Logger;
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
import org.eclipse.osgi.framework.internal.core.FrameworkProperties;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.junit.refactoring.AbstractLinkedEditingIntegrationTest;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring.ui.RefactoringType;
import org.eclipse.xtext.ui.refactoring.ui.RenameRefactoringController;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xtext.ui.Activator;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import org.eclipse.xtext.xtext.ui.refactoring.EcoreRefactoringParticipant;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XtextGrammarRefactoringIntegrationTest extends AbstractLinkedEditingIntegrationTest {

	private static final String REFACTOREDCLASSIFIERNAME = "Greeting123";
	private static final Logger LOG = Logger.getLogger(XtextGrammarRefactoringIntegrationTest.class);
	@Inject
	private RenameRefactoringController renameRefactoringController;

	private IProject project;
	private static final String TEST_PROJECT = "refactoring.test";
	private static final String GRAMMAR_FILE = TEST_PROJECT + "/src/org/xtext/example/mydsl/" + "MyDsl.xtext";
	private static final String ECORE_FILE = TEST_PROJECT + "/src/org/xtext/example/mydsl/" + "MyDsl.ecore";
	private static final String CLASSIFIERNAME = "Greeting";
	private String grammar;
	private IFile grammaFile;
	private URI ecoreURI;
	private URI grammarUri;
	private EPackage initialModelRoot;
	protected Change undoChange;
	private URI greetingParserRuleUri;
	private URI modelParserRuleUri;

	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	@SuppressWarnings("static-access")
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		FrameworkProperties.setProperty(EcoreRefactoringParticipant.ECORE_REFACTORING_PARTICIPANT_SHOW_WARNING_OPTION,
				"false");
		project = createProject(TEST_PROJECT);
		IJavaProject javaProject = makeJavaProject(project);
		addNature(javaProject.getProject(), XtextProjectHelper.NATURE_ID);
		Injector injector = Activator.getInstance().getInjector(getEditorId());
		injector.injectMembers(this);
		grammar = "grammar org.xtext.example.mydsl.MyDsl hidden(WS) generate myDsl 'http://testrefactoring' import 'http://www.eclipse.org/emf/2002/Ecore' as ecore Model: greetings+="
				+ CLASSIFIERNAME
				+ "*; "
				+ CLASSIFIERNAME
				+ ": 'Hello' name=ID '!'; terminal ID : '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*; terminal WS: (' '|'\t'|'\r'|'\n')+;";
		grammaFile = IResourcesSetupUtil.createFile(GRAMMAR_FILE, grammar);
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

							public boolean apply(ParserRule input) {
								return input.getName().equals(CLASSIFIERNAME);
							}

						}).iterator().next();
		ParserRule modelParserRule = Iterables
				.filter(EcoreUtil2.getAllContentsOfType(grammarResource.getContents().get(0), ParserRule.class),
						new Predicate<ParserRule>() {

							public boolean apply(ParserRule input) {
								return input.getName().equals("Model");
							}

						}).iterator().next();
		greetingParserRuleUri = EcoreUtil.getURI(greetingsParserRule);
		modelParserRuleUri = EcoreUtil.getURI(modelParserRule);
		grammarResource.unload();
	}

	public void testRefactorXtextGrammarWithoutGeneratedClassifier() throws Exception {
		waitForAutoBuild();
		final XtextEditor editor = openEditor(grammaFile);
		doRefactoring(editor);
		waitForReconciler(editor);
		waitForDisplay();
		waitForAutoBuild();
		checkConsistenceOfGrammar(editor);
	}

	public void testRefactorXtextGrammarWithGeneratedClassifier() throws Exception {
		ResourceSet rs = resourceSetProvider.get();
		Resource ecoreResource = createEcoreModel(rs, ecoreURI, initialModelRoot);
		final EClass greetingClass = getGreetingClass(ecoreResource);
		final EReference greetingRef = getReferenceoGreeting(ecoreResource, greetingClass);
		String greetingClassFragment = EcoreUtil.getURI(greetingClass).fragment();
		String greetingRefFragment = EcoreUtil.getURI(greetingRef).fragment();
		ecoreResource.unload();
		waitForAutoBuild();
		final XtextEditor editor = openEditor(grammaFile);
		doRefactoring(editor);
		waitForAutoBuild();
		checkConsistenceOfGrammar(editor);
		ecoreResource.load(null);
		assertEquals(REFACTOREDCLASSIFIERNAME, SimpleAttributeResolver.NAME_RESOLVER.apply(ecoreResource
				.getEObject(greetingClassFragment.replaceFirst(CLASSIFIERNAME, REFACTOREDCLASSIFIERNAME))));
		EReference greetingReference = (EReference) ecoreResource.getEObject(greetingRefFragment);
		EClassifier eType = greetingReference.getEType();
		assertFalse(eType.eIsProxy());
		assertEquals(REFACTOREDCLASSIFIERNAME, eType.getName());
	}

	
	/**
	 *	FIXME (dennis) Reactivate Testcase if fixed
	 */
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
		XtextEditor editor = openEditor(grammaFile);
		doRefactoring(editor);
		waitForAutoBuild();
		checkConsistenceOfGrammar(editor);
		ecoreModelResource.load(null);
		EObject fromEObject = ecoreModelResource.getEObject(greetingClassFragment.replaceFirst(CLASSIFIERNAME,
				REFACTOREDCLASSIFIERNAME));
		LOG.info("Get name from:" + fromEObject);
		LOG.warn("Activate this Test!");
//		String greetingName = SimpleAttributeResolver.NAME_RESOLVER.apply(fromEObject);
//		LOG.info("Got:" + greetingName);
//		assertEquals(REFACTOREDCLASSIFIERNAME, greetingName);
//		EReference greetingReference = (EReference) ecoreModelResource.getEObject(greetingRefFragment);
//		EClassifier eType = greetingReference.getEType();
//		assertFalse(eType.eIsProxy());
//		assertEquals(REFACTOREDCLASSIFIERNAME, eType.getName());
//
//		refToGreetingResource.load(null);
//		EReference externalReferenceToGreeting = getReferenceoGreeting(refToGreetingResource, eType);
//		assertFalse(externalReferenceToGreeting.getEType().eIsProxy());
//		assertEquals(REFACTOREDCLASSIFIERNAME, externalReferenceToGreeting.getEType().getName());

	}

	private EReference getReferenceoGreeting(Resource ecoreResource, final EClassifier classifier) {
		final EReference greetingRef = Iterables
				.filter(EcoreUtil2.getAllContentsOfType(ecoreResource.getContents().get(0), EReference.class),
						new Predicate<EReference>() {
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
		renameRefactoringController.initialize(context);
		renameRefactoringController.startRefactoring(RefactoringType.LINKED_EDITING);
		waitForDisplay();
		pressKeys(editor, REFACTOREDCLASSIFIERNAME + "\n");
		waitForDisplay();
		return editor;
	}

	private void checkConsistenceOfGrammar(XtextEditor editor) {
		waitForAutoBuild();
		assertEquals(REFACTOREDCLASSIFIERNAME, editor.getDocument().readOnly(new IUnitOfWork<String, XtextResource>() {
			public String exec(XtextResource state) throws Exception {
				return SimpleAttributeResolver.NAME_RESOLVER.apply(state.getEObject(greetingParserRuleUri.fragment()
						.replaceFirst(CLASSIFIERNAME, REFACTOREDCLASSIFIERNAME)));
			}
		}));
		editor.getDocument().readOnly(new IUnitOfWork<Boolean, XtextResource>() {
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
	protected void tearDown() throws Exception {
		super.tearDown();
		FrameworkProperties.setProperty(EcoreRefactoringParticipant.ECORE_REFACTORING_PARTICIPANT_SHOW_WARNING_OPTION,
				"true");
	}

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.Xtext";
	}
}
