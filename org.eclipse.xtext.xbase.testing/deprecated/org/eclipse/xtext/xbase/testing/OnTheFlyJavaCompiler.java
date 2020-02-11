/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testing;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static java.util.Collections.singletonMap;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.RuntimeIOException;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noreference This class is not intended to be referenced by clients.
 * 
 * @since 2.7
 * 
 * @deprecated use {@link InMemoryJavaCompiler}
 */
@Deprecated
public class OnTheFlyJavaCompiler {

	static class DelegateOutStream extends OutputStream {

		private OutputStream delegate;

		@Override
		public void close() throws IOException {
			delegate.close();
		}

		@Override
		public boolean equals(Object obj) {
			return delegate.equals(obj);
		}

		@Override
		public void flush() throws IOException {
			delegate.flush();
		}

		@Override
		public int hashCode() {
			return delegate.hashCode();
		}

		public void setDelegate(OutputStream delegate) {
			this.delegate = delegate;
		}

		@Override
		public String toString() {
			return delegate.toString();
		}

		@Override
		public void write(byte[] b) throws IOException {
			delegate.write(b);
		}

		@Override
		public void write(byte[] b, int off, int len) throws IOException {
			delegate.write(b, off, len);
		}

		@Override
		public void write(int b) throws IOException {
			delegate.write(b);
		}

	}

	public static class EclipseRuntimeDependentJavaCompiler extends
			OnTheFlyJavaCompiler {
		@Override
		protected URL resolveBundleResourceURL(URL url) throws IOException {
			return FileLocator.resolve(url);
		}
	}
	
	public static class ClassPathAssembler {
		
		@Inject
		private ClassLoader parentClassLoader;
		
		public void assembleCompilerClassPath(OnTheFlyJavaCompiler compiler) {
			if (parentClassLoader instanceof URLClassLoader) {
				URL[] urLs = ((URLClassLoader) parentClassLoader).getURLs();
				for (URL url : urLs) {
					final String urlAsString = url.getFile();
					compiler.addClassPath(urlAsString);
				}
			}
		}
		
		public ClassLoader getClassLoader() {
			return parentClassLoader;
		}
	}

	private List<String> classpath = newArrayList();

	private DelegateOutStream errorStream = new DelegateOutStream();

	@Inject
	private ClassPathAssembler classPathAssembler = new ClassPathAssembler();
	
	@Inject(optional=true)
	private TemporaryFolder temporaryFolder;
	
	@Inject(optional=true)
	private IGeneratorConfigProvider generatorConfigProvider;

	public void addClassPath(String classpath) {
		this.classpath.add(classpath);
	}
	
	public void setTemporaryFolder(TemporaryFolder temporaryFolder) {
		this.temporaryFolder = temporaryFolder;
	}

	public void addClassPathOfClass(Class<?> clazz) {
		final String classNameAsPath = "/"
				+ clazz.getName().replace('.', '/');
		String resourceName = classNameAsPath + ".class";
		URL url = clazz.getResource(resourceName);
		if (url == null)
			throw new IllegalArgumentException(resourceName + " not found");
		String pathToFolderOrJar = null;
		if (url.getProtocol().startsWith("bundleresource")) {
			try {
				url = resolveBundleResourceURL(url);
			} catch (IOException e) {
				throw new WrappedException(e);
			}
		}
		if (url.getProtocol().startsWith("jar")) {
			try {
				final String path = url.getPath().substring(0,
						url.getPath().indexOf('!'));
				String encodedPath = path.replace(" ","%20");
				pathToFolderOrJar = new URL(encodedPath).toURI().getRawPath();
			} catch (Exception e) {
				throw new WrappedException(e);
			}
		} else {
			String resolvedRawPath;
			try {
				if (url.toExternalForm().contains(" "))
					resolvedRawPath = URIUtil.toURI(url).getRawPath();
				else
					resolvedRawPath = url.toURI().getRawPath();
			} catch (URISyntaxException e) {
				throw new WrappedException(e);
			}
			pathToFolderOrJar = resolvedRawPath.substring(0,
					resolvedRawPath.indexOf(classNameAsPath));
		}
		this.classpath.add(pathToFolderOrJar);
	}

	public void clearClassPath() {
		classpath.clear();
	}

	protected boolean compile(String arguments) {
		// return BatchCompiler.compile(sb.toString(), new PrintWriter(new
		// OutputStreamWriter(System.out)), new PrintWriter(
		// new OutputStreamWriter(errorStream)), null);
		return getMain().compile(Main.tokenize(arguments));
	}

	public Class<?> compileToClass(String classname, String code) {
		return compileToClasses(singletonMap(classname, code)).get(classname);
	}
	
	public Map<String,Class<?>> compileToClasses(Map<String,String> sources) {
		return internalCompileToClasses(sources).getSecond();
	}
	
	public Pair<ClassLoader, Map<String,Class<?>>> internalCompileToClasses(Map<String,String> sources) {
		File tempDir = createTempDir();
		try {
			for (Entry<String, String> entry : sources.entrySet()) {
				String classname = entry.getKey();
				String code = entry.getValue();
				final String classNameAsPath = classname.replace('.', File.separatorChar);
				final File srcFile = new File(tempDir, classNameAsPath + ".java");
				createFolderStructure(srcFile.getParentFile());
				srcFile.createNewFile();
				Files.writeStringIntoFile(srcFile.getCanonicalPath(), code);
			}
			errorStream.setDelegate(new ByteArrayOutputStream());
			StringBuilder sb = new StringBuilder(getComplianceLevelArg());
			sb.append(" ");
			sb.append(getClasspathArgs());
			sb.append(" ");
			sb.append('\"');
			sb.append(tempDir.getCanonicalPath());
			sb.append('\"');
			boolean compile = compile(sb.toString());
			if (!compile)
				throw new IllegalArgumentException("Couldn't compile : "
						+ errorStream.toString() + "\n" + sources);
			final URL url = tempDir.toURI().toURL();
			final URLClassLoader loader = new URLClassLoader(new URL[] { url },
					classPathAssembler.getClassLoader());
			Map<String,Class<?>> result = newHashMap();
			for (String name : sources.keySet()) {
				String qname = name.replace('/','.');
				Class<?> clazz = loader.loadClass(qname);
				result.put(name, clazz);
			}
			return Tuples.<ClassLoader, Map<String,Class<?>>>create(loader, result);
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			cleanUpTmpFolder(tempDir);
		}
	}

	protected File createTempDir() {
		if (temporaryFolder != null && temporaryFolder.isInitialized()) {
			try {
				return temporaryFolder.newFolder();
			} catch (IOException e) {
				throw new RuntimeIOException(e);
			}
		}
		return com.google.common.io.Files.createTempDir();
	}
	
	protected void cleanUpTmpFolder(File tempDir) {
		if (temporaryFolder == null || !temporaryFolder.isInitialized()) {
			try {
				tempDir.deleteOnExit();
				// Classloader needs .class files to lazy load an anonymous non static classes
				Files.cleanFolder(tempDir, new FileFilter() {
					@Override
					public boolean accept(File pathname) {
						boolean isClass = pathname.getName().endsWith(".class");
						if(isClass) {
							pathname.deleteOnExit();
						}
						return !isClass;
					}
				}, true, true);
			} catch (FileNotFoundException e) {
				// ignore
			}
		}
	}

	protected void createFolderStructure(File parent) {
		if (parent.exists())
			return;
		parent.mkdirs();
	}

	protected Pair<String, String> createFullCode(String statementCode,
			Type returnType, @SuppressWarnings("unchecked") Pair<Type, String>... params) {
		String className = "_$GeneratedClass";
		StringBuilder sb = new StringBuilder("public class ").append(className)
				.append(" implements ")
				.append("org.eclipse.xtext.xbase.lib.Functions.Function")
				.append(params.length).append("<");
		for (Pair<Type, String> type : params) {
			sb.append(toString(type.getFirst())).append(",");
		}
		sb.append(toString(returnType));
		sb.append("> {\n");
		sb.append("public ").append(toString(returnType));
		sb.append(" apply(");

		for (int i = 0; i < params.length; i++) {
			Pair<Type, String> pair = params[i];
			sb.append(toString(pair.getFirst())).append(" ")
					.append(pair.getSecond());
			if (i + 1 < params.length)
				sb.append(",");
		}
		sb.append(") {\n");
		sb.append(statementCode);
		sb.append("\n}}");
		return Tuples.pair(className, sb.toString());
	}

	@SuppressWarnings("unchecked")
	public <RT> Functions.Function0<RT> createFunction(String expression,
			Class<RT> returnType) {
		return (Function0<RT>) internalCreateFunction(expression, returnType);
	}

	@SuppressWarnings("unchecked")
	public <RT, T> Functions.Function1<T, RT> createFunction(String body,
			Class<RT> returnType, Class<T> paramType) {
		return (Functions.Function1<T, RT>) internalCreateFunction(body,
				returnType, Tuples.pair((Type) paramType, "p"));
	}

	@SuppressWarnings("unchecked")
	public <RT, T1, T2> Functions.Function2<T1, T2, RT> createFunction(
			String body, Class<RT> returnType, Class<T1> paramType1,
			Class<T2> paramType2) {
		return (Functions.Function2<T1, T2, RT>) internalCreateFunction(body,
				returnType, Tuples.pair((Type) paramType1, "p1"),
				Tuples.pair((Type) paramType2, "p2"));
	}

	public String getClasspathArgs() {
		StringBuilder sb = new StringBuilder();
		sb.append("-classpath ");
		if (classpath.isEmpty()) {
			initializeClassPath();
		}
		// no classpath
		if (classpath.isEmpty())
			return "";
		sb.append('"');
		for (int i = 0; i < classpath.size(); i++) {
			sb.append(URLDecoder.decode(classpath.get(i)));
			if (i + 1 < classpath.size())
				sb.append(File.pathSeparator);
		}
		sb.append('"');
		return sb.toString().replace("%20", " ");
	}

	public void initializeClassPath() {
		clearClassPath();
		classPathAssembler.assembleCompilerClassPath(this);
	}

	protected String getComplianceLevelArg() {
		JavaVersion javaVersion = JavaVersion.JAVA5;
		if (generatorConfigProvider != null) {
			GeneratorConfig generatorConfig = generatorConfigProvider.get(null);
			javaVersion = generatorConfig.getJavaSourceVersion();
		}
		return javaVersion.getComplianceLevelArg();
	}

	protected Main getMain() {
		return new Main(new PrintWriter(new OutputStreamWriter(
				System.out)), new PrintWriter(new OutputStreamWriter(
				errorStream)), false /* systemExit */, null /* options */, null);
	}

	protected Object internalCreateFunction(String code, Type returnType,
			@SuppressWarnings("unchecked") Pair<Type, String>... params) {
		Pair<String, String> fullCode = createFullCode(code, returnType, params);
		Class<?> class1 = compileToClass(fullCode.getFirst(),
				fullCode.getSecond());
		try {
			return class1.getDeclaredConstructor().newInstance();
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new WrappedException(e);
		}
	}

	/**
	 * @param url the location of the class file.
	 */
	protected URL resolveBundleResourceURL(URL url) throws IOException {
		return FileLocator.resolve(url);
	}

	public void setParentClassLoader(ClassLoader parentClassLoader) {
		this.classPathAssembler.parentClassLoader = parentClassLoader;
	}

	protected String toString(Type returnType) {
		return returnType instanceof Class ? ((Class<?>) returnType).getName() : returnType.toString();
	}

}
