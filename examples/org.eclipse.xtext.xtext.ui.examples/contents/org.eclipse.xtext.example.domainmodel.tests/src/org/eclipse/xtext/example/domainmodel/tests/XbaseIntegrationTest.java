package org.eclipse.xtext.example.domainmodel.tests;

import java.lang.reflect.Method;

import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xbase.lib.Functions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Supplier;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Xbase integration test.
 * 
 * runs all Xbase tests from {@link AbstractXbaseEvaluationTest} in the context of an
 * entity operation.
 * 
 * Unsupported features can be disabled by overriding the respective test method.
 * 
 * @author Sven Efftinge
 */
@RunWith(XtextRunner.class)
@InjectWith(InjectorProviderCustom.class)
public class XbaseIntegrationTest extends AbstractXbaseEvaluationTest {

	@Inject
	private EclipseRuntimeDependentJavaCompiler javaCompiler;

	@Inject
	private ParseHelper<DomainModel> parseHelper;

	@Inject
	private ValidationTestHelper validationHelper;
	
	@Inject
	private JvmModelGenerator generator;
	
	@Before
	public void initializeClassPath() throws Exception {
		javaCompiler.addClassPathOfClass(getClass()); // this bundle
		javaCompiler.addClassPathOfClass(AbstractXbaseEvaluationTest.class); // xbase.junit
		javaCompiler.addClassPathOfClass(Functions.class); // xbase.lib
		javaCompiler.addClassPathOfClass(Provider.class);  // google guice
		javaCompiler.addClassPathOfClass(Supplier.class);  // google collect
		javaCompiler.addClassPathOfClass(javax.inject.Inject.class);  // javax inject
	}

	protected Object invokeXbaseExpression(String expression) throws Exception {
		DomainModel parse = parseHelper.parse("entity Foo { op doStuff() : Object { "+expression+" } } ");
		validationHelper.assertNoErrors(parse);
		InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
		generator.doGenerate(parse.eResource(), fsa);
		CharSequence concatenation = fsa.getFiles().values().iterator().next();
		Class<?> class1 = javaCompiler.compileToClass("Foo", concatenation.toString());
		Object foo = class1.newInstance();
		Method method = class1.getDeclaredMethod("doStuff");
		return method.invoke(foo);
	}
	
	@Override
	@Test
	@Ignore
	public void testImplicitOneArgClosure_01() throws Exception {
		super.testImplicitOneArgClosure_01();
	}
	
	@Override
	@Test
	@Ignore
	public void testClosure_06_1() throws Exception {
		super.testClosure_06_1();
	}
	
	@Override
	@Test
	@Ignore
	public void testClosure_10() throws Exception {
		super.testClosure_10();
	}
	
	@Override
	@Test
	@Ignore
	public void testClosure_10_2() throws Exception {
		super.testClosure_10_2();
	}
	
	@Override
	@Test
	@Ignore
	public void testStaticMethod_02() throws Exception {
		super.testStaticMethod_02();
	}

}
