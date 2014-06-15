package org.eclipse.xtext.example.domainmodel.xpect.tests;

import org.eclipse.xtext.example.domainmodel.xpect.tests.jvmmodelinferrer.DMJvmModelInferrerTest;
import org.eclipse.xtext.example.domainmodel.xpect.tests.linking.DMLinkingTest;
import org.eclipse.xtext.example.domainmodel.xpect.tests.modify.SemanticModificationTest;
import org.eclipse.xtext.example.domainmodel.xpect.tests.parser.ParserTest;
import org.eclipse.xtext.example.domainmodel.xpect.tests.resourcedescription.DMResourceDescriptionTest;
import org.eclipse.xtext.example.domainmodel.xpect.tests.scoping.DMScopingTest;
import org.eclipse.xtext.example.domainmodel.xpect.tests.testsuite.DMXtextTests;
import org.eclipse.xtext.example.domainmodel.xpect.tests.validation.DMValidationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@SuiteClasses({
/*    */DMJvmModelInferrerTest.class, //
		DMLinkingTest.class,//
		SemanticModificationTest.class,//
		ParserTest.class,//
		DMResourceDescriptionTest.class,//
		DMScopingTest.class,//
		DMXtextTests.class,//
		DMValidationTest.class //
})
@RunWith(Suite.class)
public class AllDomainModelXpectTests {

}
