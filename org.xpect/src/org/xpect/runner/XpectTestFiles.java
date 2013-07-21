/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.runner;

import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.xpect.runner.XpectTestFiles.XpectTestFileCollector;
import org.xpect.util.DotClasspath;
import org.xpect.util.IFileForClassProvider;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@XpectURIProvider(XpectTestFileCollector.class)
public @interface XpectTestFiles {

	@XpectTestFiles(fileExtensions = "xt")
	public static class Default {
		public static XpectTestFileCollector create(Class<?> owner) {
			XpectTestFiles annotation = Default.class.getAnnotation(XpectTestFiles.class);
			return new XpectTestFileCollector(owner, annotation);
		}
	}

	public static enum FileRoot {
		CLASS, CURRENT, PROJECT
	}

	public static class XpectTestFileCollector implements IXpectURIProvider {
		public static class FilePredicate implements Predicate<File> {
			private final String[] fileExtensions;

			public FilePredicate(String... fileExts) {
				this.fileExtensions = fileExts;
			}

			public boolean apply(File input) {
				for (String ext : fileExtensions)
					if (input.getName().endsWith("." + ext))
						return true;
				return false;
			}
		}

		protected XpectTestFiles ctx;
		protected Class<?> owner;

		public XpectTestFileCollector(Class<?> owner, XpectTestFiles ctx) {
			this.owner = owner;
			this.ctx = ctx;
		}

		protected List<URI> collectFiles(Collection<File> directories, Predicate<File> shouldCollect) {
			List<URI> result = Lists.newArrayList();
			for (File directory : directories) {
				if (!directory.isDirectory())
					throw new RuntimeException("Directory not found: " + directory);
				collectFiles(directory, result, shouldCollect);
			}
			return result;
		}

		protected List<URI> collectFiles(Collection<File> directories, String... files) {
			List<URI> result = Lists.newArrayList();
			for (File directory : directories) {
				for (String file : files) {
					File f = new File(directory + "/" + file);
					if (!f.exists())
						throw new RuntimeException("File not found: " + file);
					result.add(createURI(f));
				}
			}
			return result;
		}

		protected void collectFiles(File dir, List<URI> result, Predicate<File> shouldCollect) {
			for (File child : dir.listFiles()) {
				if (shouldCollect.apply(child))
					result.add(createURI(child));
				if (child.isDirectory())
					collectFiles(child, result, shouldCollect);
			}
		}

		protected List<URI> collectFilesWithExt(Collection<File> directory, String... fileExtensions) {
			return collectFiles(directory, new FilePredicate(fileExtensions));
		}

		protected URI createURI(File file) {
			return URI.createFileURI(file.getAbsolutePath());
		}

		public Collection<URI> getAllURIs() {
			List<URI> result = Lists.newArrayList();
			result.addAll(collectFilesWithExt(getBaseDirs(), ctx.fileExtensions()));
			result.addAll(collectFiles(getBaseDirs(), ctx.files()));
			return result;
		}

		protected Collection<File> getBaseDirs() {
			Collection<File> roots = getRoots();
			if (Strings.isNullOrEmpty(ctx.baseDir()))
				return roots;
			List<File> result = Lists.newArrayList();
			for (File root : roots)
				result.add(new File(root + "/" + ctx.baseDir()));
			return result;
		}

		protected Collection<File> getPackageFragmentsSourceFolders(Class<?> clazz) {
			File classFile = IFileForClassProvider.INSTANCE.getFile(clazz);
			File current = classFile.getParentFile();
			File dotClasspathFile = null;
			while (current != null && !(dotClasspathFile = new File(current + "/.classpath")).exists())
				current = current.getParentFile();
			if (dotClasspathFile == null)
				return Collections.emptyList();
			DotClasspath cp = new DotClasspath(dotClasspathFile);
			File project = dotClasspathFile.getParentFile();
			File output = new File(project + "/" + cp.getOutput());
			if (!output.isDirectory() || !classFile.toString().startsWith(output.toString()))
				return Collections.emptyList();
			URI classFileInClasspath = URI.createURI(output.toURI().relativize(classFile.toURI()).toString());
			File packagePathInClasspath = new File(classFileInClasspath.trimSegments(1).toString());
			List<File> files = Lists.newArrayList();
			for (String path : cp.getSources()) {
				File result = new File(project + "/" + path + "/" + packagePathInClasspath);
				if (result.isDirectory())
					files.add(result);
			}
			return files;
		}

		protected File getProjectRootFolder(Class<?> clazz) {
			File classFile = IFileForClassProvider.INSTANCE.getFile(clazz);
			File current = classFile.getParentFile();
			while (current != null) {
				if (new File(current + "/.project").exists())
					return current;
				current = current.getParentFile();
			}
			throw new IllegalStateException("not .project file found in containing folder of " + classFile);
		}

		protected Collection<File> getRoots() {
			switch (ctx.relativeTo()) {
			case CURRENT:
				return Collections.singletonList(new File("."));
			case CLASS:
				return getPackageFragmentsSourceFolders(owner);
			case PROJECT:
				return Collections.singletonList(getProjectRootFolder(owner));
			}
			throw new UnsupportedOperationException();
		}

		public String getTitle(URI uri) {
			return uri.lastSegment();
		}

		public URI resolveURI(URI base, String newURI) {
			return URI.createURI(newURI).resolve(base);
		}

	}

	String baseDir() default "";

	String[] fileExtensions() default { "xt", "xpect" };

	String[] files() default {};

	FileRoot relativeTo() default FileRoot.CLASS;

}
