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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;

import com.google.inject.Inject;

import static com.google.common.collect.Maps.*;

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
				Assert.assertEquals(expected.toString(), r.getSingleGeneratedCode());
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
		
		Map<String,String> getGeneratedCode();

		String getGeneratedCode(String typeName);
		
		String getSingleGeneratedCode();

		Resource getResource();

		Class<?> getCompiledClass();
		
		Class<?> getCompiledClass(String className);

		Map<String, CharSequence> getAllGeneratedResources();
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
			acceptor.accept(new Result() {
				
				private Map<String,Class<?>> compiledClasses;
				private Map<String,String> generatedCode;
				
				public Map<String,Class<?>> getCompiledClasses() {
					if (compiledClasses == null) {
						compiledClasses = javaCompiler.compileToClasses(getGeneratedCode());
					}
					return compiledClasses;
				}
				
				public Map<String,String> getGeneratedCode() {
					if (generatedCode == null) {
						generatedCode = newHashMap();
						for (final Entry<String, CharSequence> e : access.getFiles().entrySet()) {
							String name = e.getKey().substring("DEFAULT_OUTPUT".length(), e.getKey().length() - ".java".length());
							generatedCode.put(name, e.getValue().toString());
						}
					}
					return generatedCode;
				}

				public String getGeneratedCode(String typeName) {
					for (final Entry<String, CharSequence> e : access.getFiles().entrySet()) {
						String name = e.getKey().substring("DEFAULT_OUTPUT".length(), e.getKey().length() - ".java".length());
						if (name.equals(typeName))
							return e.getValue().toString();
					}
					return null;
				}
				
				public String getSingleGeneratedCode() {
					if (access.getFiles().size() == 1)
						return access.getFiles().values().iterator().next().toString();
					return null;
				}

				public Resource getResource() {
					return (Resource) parsed.eResource();
				}

				public Class<?> getCompiledClass() {
					return IterableExtensions.head(getCompiledClasses().values());
				}
				
				public Class<?> getCompiledClass(String className) {
					return getCompiledClasses().get(className);
				}

				public Map<String, CharSequence> getAllGeneratedResources() {
					return access.getFiles();
				}
				
			});
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
