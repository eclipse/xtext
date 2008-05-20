package org.eclipse.xtext.xtext2ecore;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.generator.tests.AbstractGeneratorTest;
import org.eclipse.xtext.testlanguages.ActionTestLanguage;
import org.eclipse.xtext.testlanguages.ActionTestLanguageLanguageFacade;
import org.eclipse.xtext.testlanguages.parser.ActionTestLanguageASTFactory;

public class ActionTest extends AbstractGeneratorTest {

	
	public void testMetamodelCreation() throws Exception {
		EClass model = checkEClassExists("Model");
		EClass type = checkEClassExists("Type");
		EClass item = checkEClassExists("Item");
		EClass thing = checkEClassExists("Thing");
		checkContainmentReferenceExists(model, type, "children");
		checkContainmentReferenceExists(item, type, "items");
		checkContainmentReferenceExists(thing, type, "content");
		assertTrue(item.getESuperTypes().contains(type));
		assertTrue(thing.getESuperTypes().contains(type));
		assertNull(ActionTestLanguageLanguageFacade.getActionLangEPackage().getEClassifier("Element"));
	}
	
	private EClass checkEClassExists(String name) {
		EPackage actionLangEPackage = ActionTestLanguageLanguageFacade.getActionLangEPackage();
		EClassifier classifier = actionLangEPackage.getEClassifier(name);
		assertNotNull(classifier);
		assertTrue(classifier instanceof EClass);
		return (EClass) classifier;
	}
	
	private void checkContainmentReferenceExists(EClass eClass, EClass type, String name) {
		EStructuralFeature structuralFeature = eClass.getEStructuralFeature(name);
		assertNotNull(structuralFeature);
		assertTrue(structuralFeature instanceof EReference);
		assertTrue(((EReference)structuralFeature).isContainment());
		assertEquals(type, structuralFeature.getEType());
	}
	
	@Override
	protected IElementFactory getASTFactory() throws Exception {
		return new ActionTestLanguageASTFactory();
	}
	
	@Override
	protected Class<?> getTheClass() {
		return ActionTestLanguage.class;
	}
}
