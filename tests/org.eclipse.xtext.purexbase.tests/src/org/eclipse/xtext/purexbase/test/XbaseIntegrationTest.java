//package org.eclipse.xtext.purexbase.test;
//
//import java.lang.reflect.Method;
//
//import org.eclipse.xtext.junit4.InjectWith;
//import org.eclipse.xtext.junit4.XtextRunner;
//import org.eclipse.xtext.purexbase.PureXbaseInjectorProvider;
//import org.eclipse.xtext.util.IAcceptor;
//import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
//import org.eclipse.xtext.xbase.compiler.CompilationTestHelper.Result;
//import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
//import org.junit.runner.RunWith;
//
//import com.google.inject.Inject;
//
//
//@RunWith(XtextRunner.class)
//@InjectWith(PureXbaseInjectorProvider.class)
//@SuppressWarnings("restriction")
//public class XbaseIntegrationTest extends AbstractXbaseEvaluationTest {
//	
//	@Inject CompilationTestHelper helper;
//
//	protected Object invokeXbaseExpression(String expression) throws Exception {
//		final Object[] result = new Object[1];
//		helper.compile(expression, new IAcceptor<CompilationTestHelper.Result>() {
//			public void accept(Result t) {
//				try {
//					final Class<?> compiledClass = t.getCompiledClass();
//					Object instance = compiledClass.newInstance();
//					final Method method = compiledClass.getDeclaredMethod("myMethod");
//					result[0] = method.invoke(instance);
//				} catch (Exception e) {
//					e.printStackTrace();
//					fail(e.toString());
//				}
//			}
//		});
//		return result[0];
//	}
//	
//}
