package org.eclipse.xtext.idea.sdomain.idea.tests.linking;

import org.eclipse.xtext.psi.PsiNamedEObject;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;

public class MyDslLinkingTest extends LightCodeInsightFixtureTestCase {
	
	@Override
	protected String getTestDataPath() {
		return "./testData";
	}
	
	public void testLocalLinking() {
		myFixture.configureByFiles("LocalLinkingTestData.sdomain");
		PsiElement element = myFixture.getFile().findElementAt(myFixture.getCaretOffset()).getParent();
		assertEquals("Foo", ((com.intellij.psi.PsiNamedElement) element.getParent().getParent()).getName());
		
		PsiReference reference = element.getReference();
		assertNotNull(reference);
		
		PsiElement resolved = reference.resolve();
		assertTrue("" + resolved, resolved instanceof PsiNamedEObject);
		
		PsiNamedEObject<?> namedEObject = (PsiNamedEObject<?>) resolved;
		assertEquals("Foo", namedEObject.getName());
	}
	
	public void testGlobalLinking() {
		myFixture.configureByFiles("GlobalLinkingTestData.sdomain", "LocalLinkingTestData.sdomain");
		PsiElement element = myFixture.getFile().findElementAt(myFixture.getCaretOffset()).getParent();
		assertEquals("Bar", ((com.intellij.psi.PsiNamedElement) element.getParent().getParent()).getName());
		
		PsiReference reference = element.getReference();
		assertNotNull(reference);
		
		PsiElement resolved = reference.resolve();
		assertTrue("" + resolved, resolved instanceof PsiNamedEObject);
		
		PsiNamedEObject<?> namedEObject = (PsiNamedEObject<?>) resolved;
		assertEquals("Foo", namedEObject.getName());
	}

}
