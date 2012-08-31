/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IAcceptor;
import org.junit.Assert;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge
 */
public class CompilationTestHelper {
	
	@Inject private OnTheFlyJavaCompiler javaCompiler;
	
	@Inject private ParseHelper<EObject> parseHelper;
	
	@Inject private ValidationTestHelper validationTestHelper;
	
	@Inject private IGenerator generator;
	
	/**
	 * Asserts that the expected code is generated for the given source.
	 * Assumes that
	 * 
	 * @param source some valid source code written in the language under test
	 * @param expected the expected Java source code.
	 */
	public void assertCompilesTo(CharSequence source, final CharSequence expected) {
		final boolean[] called = {false};
		compile(source, new IAcceptor<CompilationTestHelper.Result>() {
			public void accept(Result r) {
				Assert.assertEquals(expected.toString(), r.getGeneratedCode());
				called[0] = true;
			}
		});
		Assert.assertTrue("Nothing was generated but the expectation was :\n"+expected, called[0]);
	}
	
	/**
	 * A result contains information about various aspects of a compiled piece of code.
	 *   
	 */
	public static interface Result {
		/**
		 * @return the outlet-relative path of the generated artifact
		 */
		String getGeneratedPath();
		
		/**
		 * @return the actual generated code
		 */
		String getGeneratedCode();
		
		/**
		 * @return the loaded, validated and fully linked source resource
		 */
		Resource getSource();
		
		/**
		 * @return the dynamically loaded class of the generated code.
		 */
		Class<?> getCompiledClass();
		
		/**
		 * @return access to all generated artifacts. The key points to the pathesa dn the values are the generated code.
		 */
		Map<String,CharSequence> getAllGeneratedResources();
	}
	
	/**
	 * Parses, validates and compiles the given source. Calls the given acceptor for each
	 * resource which is generated from the source.
	 *  
	 * @param source some code written in the language under test.
	 * @param acceptor gets called once for each file generated in {@link IGenerator}
	 */
	public void compile(CharSequence source, IAcceptor<Result> acceptor) {
		try {
			final EObject parsed = parseHelper.parse(source);
			validationTestHelper.assertNoErrors(parsed);
			final InMemoryFileSystemAccess access = new InMemoryFileSystemAccess();
			generator.doGenerate(parsed.eResource(), access);
			if (access.getFiles().size() != 1) {
				throw new AssertionError("Expected one generated Java source, but found "+access.getFiles().keySet());
			}
			for (final Entry<String, CharSequence> e : access.getFiles().entrySet()) {
				acceptor.accept(new Result() {
					
					private Class<?> compiledClass = null;

					public String getGeneratedPath() {
						return e.getKey();
					}

					public String getGeneratedCode() {
						return e.getValue().toString();
					}

					public Resource getSource() {
						return (Resource) parsed.eResource();
					}

					public Class<?> getCompiledClass() {
						if (compiledClass == null) {
							String name = e.getKey().substring("DEFAULT_OUTPUT".length(), e.getKey().length() - ".java".length());
							name = name.replace('/', '.');
							compiledClass = javaCompiler.compileToClass(name, e.getValue().toString());
						}
						return compiledClass;
					}

					public Map<String, CharSequence> getAllGeneratedResources() {
						return access.getFiles();
					}
					
				});
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
