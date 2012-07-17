package org.eclipse.xpect.runner;

import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xpect.runner.XpectTestFiles.XpectTestFileCollector;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@XpectURIProvider(XpectTestFileCollector.class)
public @interface XpectTestFiles {
	public static enum FileRoot {
		CLASS, PROJECT
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

		protected void collectFiles(File dir, List<URI> result, Predicate<File> shouldCollect) {
			for (File child : dir.listFiles()) {
				if (shouldCollect.apply(child))
					result.add(createURI(child));
				if (child.isDirectory())
					collectFiles(child, result, shouldCollect);
			}
		}

		protected List<URI> collectFiles(File directory, Predicate<File> shouldCollect) {
			if (!directory.isDirectory())
				throw new RuntimeException("Directory not found: " + directory);
			List<URI> result = Lists.newArrayList();
			collectFiles(directory, result, shouldCollect);
			return result;
		}

		protected List<URI> collectFiles(File base, String... files) {
			List<URI> result = Lists.newArrayList();
			for (String file : files) {
				File f = new File(base + "/" + file);
				if (!f.exists())
					throw new RuntimeException("File not found: " + file);
				result.add(createURI(f));
			}
			return result;
		}

		protected List<URI> collectFilesWithExt(File directory, String... fileExtensions) {
			return collectFiles(directory, new FilePredicate(fileExtensions));
		}

		protected URI createURI(File file) {
			return URI.createFileURI(file.getAbsolutePath());
		}

		@Override
		public Collection<URI> getAllURIs() {
			List<URI> result = Lists.newArrayList();
			result.addAll(collectFilesWithExt(getBaseDir(), ctx.fileExtensions()));
			result.addAll(collectFiles(getBaseDir(), ctx.files()));
			return result;
		}

		protected File getBaseDir() {
			switch (ctx.relativeTo()) {
			case CLASS:
				File base = getFolder(owner);
				if (ctx.baseDir() != null && !"".equals(ctx.baseDir()))
					return new File(base + "/" + ctx.baseDir());
				else
					return base;
			case PROJECT:
			}
			throw new UnsupportedOperationException();
		}

		protected File getFolder(Class<?> clazz) {
			URL resource = clazz.getClassLoader().getResource(clazz.getName().replace(".", "/") + ".class");
			try {
				return new File(resource.toURI()).getParentFile();
			} catch (URISyntaxException e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public String getTitle(URI uri) {
			return uri.lastSegment();
		}

		@Override
		public URI resolveURI(URI base, String newURI) {
			return URI.createURI(newURI).resolve(base);
		}

	}

	String baseDir() default "";

	String[] fileExtensions() default {};

	String[] files() default {};

	FileRoot relativeTo() default FileRoot.CLASS;

}
