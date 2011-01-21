package org.eclipse.xtext.xtend2.tests.validation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.validation.Xtend2JavaValidator;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

public class Xtend2JavaValidatorTest extends AbstractXtend2TestCase {

	@Inject
	protected ValidationTestHelper helper;

	public void testAssignmentToFunctionParameter() throws Exception {
		XtendFunction function = function("void foo(int bar) bar=7");
		helper.assertError(function, XbasePackage.Literals.XASSIGNMENT, XbaseJavaValidator.ASSIGNMENT_TO_FINAL,
				"Assignment", "final", "parameter");
	}

	public void testFileNamingConventions_0() throws Exception {
		XtendFile xtendFile = loadExampleXtendFile();
		helper.assertNoError(xtendFile, Xtend2JavaValidator.WRONG_PACKAGE);
		helper.assertNoError(xtendFile, Xtend2JavaValidator.WRONG_FILE);
	}
	
	public void testFileNamingConventions_1() throws Exception {
		XtendFile xtendFile = loadExampleXtendFile();
			xtendFile.getClasses().get(0).setName("Bar");
		helper.assertNoError(xtendFile, Xtend2JavaValidator.WRONG_PACKAGE);
		helper.assertError(xtendFile, Xtend2Package.Literals.XTEND_CLASS, Xtend2JavaValidator.WRONG_FILE);
	}
		
	public void testFileNamingConventions_2() throws Exception {
		XtendFile xtendFile = loadExampleXtendFile();
		Resource resource = xtendFile.eResource();
		URI resourceURI = resource.getURI();
		URI invalidPackageURI = resourceURI.trimSegments(1).appendSegment("invalid").appendSegment(resourceURI.lastSegment());
		resource.setURI(invalidPackageURI);
		helper.assertError(xtendFile, Xtend2Package.Literals.XTEND_FILE, Xtend2JavaValidator.WRONG_PACKAGE);
		helper.assertNoError(xtendFile, Xtend2JavaValidator.WRONG_FILE);
	}
	
	protected XtendFile loadExampleXtendFile() {
		XtextResourceSet resourceSet = new XtextResourceSet();
		resourceSet.setClasspathURIContext(this);
		URI classpathURI = URI.createURI("classpath:/test/Foo.xtend");
		URI normalizedURI = resourceSet.getURIConverter().normalize(classpathURI);
		Resource resource = resourceSet.getResource(normalizedURI, true);
		return (XtendFile) resource.getContents().get(0);
	}
}
