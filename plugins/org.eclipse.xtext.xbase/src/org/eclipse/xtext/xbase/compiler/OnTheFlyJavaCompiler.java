/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLClassLoader;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.core.compiler.batch.BatchCompiler;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

import com.google.inject.internal.MoreTypes;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class OnTheFlyJavaCompiler {

	@SuppressWarnings("unchecked")
	public <RT> Functions.Function0<RT> createFunction(String expression, Class<RT> returnType) {
		return (Function0<RT>) internalCreateFunction(expression, returnType);
	}
	
	@SuppressWarnings("unchecked")
	public <RT, T> Functions.Function1<T,RT> createFunction(String expression, Class<RT> returnType, Class<T> paramType) {
		return (Functions.Function1<T,RT>) internalCreateFunction(expression, returnType, Tuples.pair((Type) paramType, "p"));
	}
	
	@SuppressWarnings("unchecked")
	public <RT,T1,T2> Functions.Function2<T1,T2,RT> createFunction(String expression, Class<RT> returnType, Class<T1> paramType1, Class<T2> paramType2) {
		return (Functions.Function2<T1,T2,RT>) internalCreateFunction(expression, returnType, Tuples.pair((Type) paramType2, "p1"), Tuples.pair((Type) paramType2, "p2"));
	}

	protected Object internalCreateFunction(String code, Type returnType, Pair<Type, String>... params) {
		Pair<String, String> fullCode = createFullCode(code, returnType, params);
		Class<?> class1 = compileToClass(fullCode.getFirst(), fullCode.getSecond());
		try {
			return class1.newInstance();
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new WrappedException(e);
		}
	}

	public Class<?> compileToClass(String classname, String code) {
		String tempDir = System.getProperty("java.io.tmpdir");
		if (tempDir == null)
			tempDir = "./";
		final File srcFile = new File(tempDir + classname.replace('.', '/') + ".java");
		final File targetFile = new File(tempDir + classname.replace('.', '/') + ".class");
		try {
			Files.writeStringIntoFile(srcFile.getCanonicalPath(), code);
			ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
			boolean compile = BatchCompiler.compile(new String[] { srcFile.getCanonicalPath(), "-1.5" }, new PrintWriter(new OutputStreamWriter(System.out)), new PrintWriter(
					new OutputStreamWriter(errorStream)), null);
			if (!compile)
				throw new IllegalArgumentException("Couldn't compile : " + errorStream.toString());
			URLClassLoader loader = new URLClassLoader(new URL[] { targetFile.getParentFile().toURI().toURL() });
			Class<?> class1 = loader.loadClass(classname);
			return class1;
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new WrappedException(e);
		} finally {
			if (srcFile.exists())
				srcFile.delete();
			if (targetFile.exists())
				targetFile.delete();
		}
	}

	protected Pair<String, String> createFullCode(String statementCode, Type returnType, Pair<Type, String>... params) {
		String className = "_$GeneratedClass";
		StringBuilder sb = new StringBuilder("public class ").append(className).append(" implements ")
				.append("org.eclipse.xtext.xbase.lib.Functions.Function").append(params.length).append("<");
		for (Pair<Type, String> type : params) {
			sb.append(toString(type.getFirst())).append(",");
		}
		sb.append(toString(returnType));
		sb.append("> {\n");
		sb.append("public ").append(toString(returnType));
		sb.append(" apply(");

		for (int i = 0; i < params.length; i++) {
			Pair<Type, String> pair = params[i];
			sb.append(toString(pair.getFirst())).append(" ").append(pair.getSecond());
			if (i + 1 < params.length)
				sb.append(",");
		}
		sb.append(") {\n");
		sb.append(statementCode);
		sb.append("\n}}");
		return Tuples.pair(className, sb.toString());
	}

	protected String toString(Type returnType) {
		return MoreTypes.toString(returnType);
	}

}
