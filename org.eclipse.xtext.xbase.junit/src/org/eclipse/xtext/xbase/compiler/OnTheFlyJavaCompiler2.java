/**
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.compiler;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noreference This class is not intended to be referenced by clients.
 * 
 * @since 2.9
 * @deprecated Use org.eclipse.xtext.xbase.testing.OnTheFlyJavaCompiler2 instead
 */
@Deprecated(forRemoval = true)
@Singleton
public class OnTheFlyJavaCompiler2 {
	private InMemoryJavaCompiler inMemoryCompiler;

	/**
	 * Creates a new OnTheFlyCompiler that accepts Java6 compliant code.
	 */
	@Inject
	public OnTheFlyJavaCompiler2(ClassLoader scope) {
		this(scope, JavaVersion.JAVA8);
	}

	public OnTheFlyJavaCompiler2(ClassLoader scope, JavaVersion version) {
		this.inMemoryCompiler = new InMemoryJavaCompiler(scope, version);
	}

	public Class<?> compileToClass( String classname,  String code) {
		InMemoryJavaCompiler.Result result = inMemoryCompiler.compile(new JavaSource(toJavaFile(classname), code));
		try {
			if (IterableExtensions.exists(result.getCompilationProblems(), CategorizedProblem::isError)) {
				StringConcatenation richString = new StringConcatenation();
				richString.append("Java code compiled with errors:");
				richString.newLine();
				richString.append(Joiner.on("\n")
						.join(IterableExtensions.filter(result.getCompilationProblems(), CategorizedProblem::isError)));
				richString.newLineIfNotEmpty();
				richString.newLine();
				richString.append("Code was:");
				richString.newLine();
				richString.append(code);
				richString.newLineIfNotEmpty();
				throw new IllegalArgumentException(richString.toString());
			}
			return result.getClassLoader().loadClass(classname);
		} catch (Throwable t) {
			if (t instanceof ClassNotFoundException) {
				ClassNotFoundException e = (ClassNotFoundException) t;
				StringConcatenation richString = new StringConcatenation();
				richString.append("Couldn\'t load \'");
				richString.append(classname);
				richString.append("\' ");
				richString.newLineIfNotEmpty();
				richString.append("source :");
				richString.newLine();
				richString.append("\t");
				richString.append(code, "\t");
				richString.newLineIfNotEmpty();
				richString.newLine();
				richString.append("PROBLEMS : ");
				richString.newLine();
				richString.append("\t");
				richString.append(Joiner.on("\n").join(result.getCompilationProblems()), "\t");
				richString.newLineIfNotEmpty();
				throw new IllegalStateException(richString.toString(), e);
			} else {
				throw Exceptions.sneakyThrow(t);
			}
		}
	}

	private String toJavaFile(String string) {
		return string.replace(".", "/") + ".java";
	}

	public Map<String, Class<?>> compileToClasses(Map<String, String> sources) {
		InMemoryJavaCompiler.Result result = inMemoryCompiler
				.compile(((JavaSource[]) Conversions.unwrapArray(
						Iterables.transform(sources.entrySet(),
								(Map.Entry<String, String> it) -> new JavaSource(toJavaFile(it.getKey()), it.getValue())),
						JavaSource.class)));
		try {
			if (IterableExtensions.exists(result.getCompilationProblems(), CategorizedProblem::isError)) {
				StringConcatenation richString = new StringConcatenation();
				richString.append("Java code compiled with errors:");
				richString.newLine();
				richString.append(
						Joiner.on("\n").join(IterableExtensions.filter(result.getCompilationProblems(), CategorizedProblem::isError)));
				richString.newLineIfNotEmpty();
				richString.newLine();
				richString.append("Code was:");
				richString.newLine();
				richString.append("=========");
				richString.newLine();
				richString.append(Joiner.on("\n=========\n").join(sources.values()));
				richString.newLineIfNotEmpty();
				richString.append("=========");
				richString.newLine();
				throw new IllegalArgumentException(richString.toString());
			}
			ClassLoader classLoader = result.getClassLoader();
			return IterableExtensions.toMap(Iterables.transform(sources.keySet(), (String it) -> {
				try {
					return classLoader.loadClass(it);
				} catch (ClassNotFoundException e) {
					throw Exceptions.sneakyThrow(e);
				}
			}), Class::getName);
		} catch (Throwable t) {
			if (t instanceof ClassNotFoundException) {
				ClassNotFoundException e = (ClassNotFoundException) t;
				StringConcatenation richString = new StringConcatenation();
				richString.append(e.getMessage());
				richString.append(" ");
				richString.newLineIfNotEmpty();
				richString.append("source :");
				richString.newLine();
				richString.append("\t");
				richString.append(sources, "\t");
				richString.newLineIfNotEmpty();
				richString.newLine();
				richString.append("PROBLEMS : ");
				richString.newLine();
				richString.append("\t");
				String _join_2 = Joiner.on("\n").join(result.getCompilationProblems());
				richString.append(_join_2, "\t");
				richString.newLineIfNotEmpty();
				throw new IllegalStateException(richString.toString(), e);
			} else {
				throw Exceptions.sneakyThrow(t);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public <RT extends Object> Function0<RT> createFunction(String expression, Class<RT> returnType) {
		try {
			StringConcatenation richString = new StringConcatenation();
			richString.append("public class __Generated implements org.eclipse.xtext.xbase.lib.Functions.Function0<");
			richString.append(returnType.getName());
			richString.append("> {");
			richString.newLineIfNotEmpty();
			richString.append("\t");
			richString.append("public ");
			richString.append(returnType.getName(), "\t");
			richString.append(" apply() {");
			richString.newLineIfNotEmpty();
			richString.append("\t\t");
			richString.append(expression, "\t\t");
			richString.newLineIfNotEmpty();
			richString.append("\t");
			richString.append("}");
			richString.newLine();
			richString.append("}");
			richString.newLine();
			Class<?> clazz = compileToClass("__Generated", richString.toString());
			return (Function0<RT>) clazz.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}
}
