/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import static com.google.common.collect.Lists.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.core.compiler.batch.BatchCompiler;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

import com.google.inject.Inject;
import com.google.inject.internal.MoreTypes;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class OnTheFlyJavaCompiler {
	
	@Inject
	private ClassLoader parentClassLoader;
	private List<String> classpath = newArrayList();
	
	public void setParentClassLoader(ClassLoader parentClassLoader) {
		this.parentClassLoader = parentClassLoader;
	}
	
	public void addClassPathOfClass(Class<?> clazz) {
		final String classNameAsPath = "/"+clazz.getCanonicalName().replace('.', '/');
		URL url = clazz.getResource(classNameAsPath+".class");
		String pathToFolderOrJar = null;
		if (url.getProtocol().startsWith("jar")) {
			try {
				pathToFolderOrJar = new URL(url.getPath().substring(0,url.getPath().indexOf('!'))).toURI().getRawPath();
			} catch (Exception e) {
				throw new WrappedException(e);
			}
		} else {
			if (url.getProtocol().startsWith("bundleresource")) {
				try {
					url = resolveBundleResourceURL(url);
				} catch (IOException e) {
					throw new WrappedException(e);
				}
			}
			String resolvedRawPath;
			try {
				resolvedRawPath = url.toURI().getRawPath();
			} catch (URISyntaxException e) {
				throw new WrappedException(e);
			}
			pathToFolderOrJar = resolvedRawPath.substring(0,resolvedRawPath.indexOf(classNameAsPath));
		}
		this.classpath.add(pathToFolderOrJar);
	}

	protected URL resolveBundleResourceURL(URL url) throws IOException {
		throw new UnsupportedOperationException();
	}
	
	public static class EclipseRuntimeDependentJavaCompiler extends OnTheFlyJavaCompiler {
		@Override
		protected URL resolveBundleResourceURL(URL url) throws IOException {
			return FileLocator.resolve(url);
		}
	}

	public void addClassPath(String classpath) {
		this.classpath.add(classpath);
	}
	
	public String getClasspathArgs() {
		StringBuilder sb = new StringBuilder();
		sb.append("-classpath ");
		for (int i = 0; i < classpath.size(); i++) {
			sb.append(classpath.get(i));
			if (i+1<classpath.size())
				sb.append(File.pathSeparator);
		}
		return sb.toString();
	}

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
			StringBuilder sb = new StringBuilder(getComplianceLevelArg());
			sb.append(" ");
			sb.append(getClasspathArgs());
			sb.append(" ");
			sb.append(srcFile.getCanonicalPath());
			boolean compile = BatchCompiler.compile(sb.toString(), new PrintWriter(new OutputStreamWriter(System.out)), new PrintWriter(
					new OutputStreamWriter(errorStream)), null);
			if (!compile)
				throw new IllegalArgumentException("Couldn't compile : " + errorStream.toString());
			URLClassLoader loader = new URLClassLoader(new URL[] { targetFile.getParentFile().toURI().toURL() }, parentClassLoader);
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

	protected String getComplianceLevelArg() {
		return "-1.5";
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
