/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpect.runner;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xpect.runner.XpectTestFiles.XpectTestFileCollector;
import org.eclipse.xpect.util.IBundleInfo;
import org.eclipse.xpect.util.IBundleInfo.Context;
import org.eclipse.xpect.util.IBundleInfo.Registry;

import com.google.common.base.Joiner;
import com.google.common.base.Predicates;
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

	static class Builder implements XpectTestFiles {

		private String baseDir = "";
		private List<String> files = Lists.newArrayList();
		private FileRoot relativeTo = FileRoot.CLASS;

		public Builder addFile(String file) {
			this.files.add(file);
			return this;
		}

		public Class<? extends Annotation> annotationType() {
			return XpectTestFiles.class;
		}

		public String baseDir() {
			return baseDir;
		}

		public IXpectURIProvider create(Class<?> owner) {
			return new XpectTestFileCollector(owner, this);
		}

		public String[] fileExtensions() {
			return new String[] { "xt" };
		}

		public String[] files() {
			return files.toArray(new String[files.size()]);
		}

		public FileRoot relativeTo() {
			return relativeTo;
		}

		public Builder relativeTo(FileRoot relativeTo) {
			this.relativeTo = relativeTo;
			return this;
		}

		public Builder withBaseDir(String baseDir) {
			this.baseDir = baseDir;
			return this;
		}
	}

	public static enum FileRoot {
		CLASS, CURRENT, PROJECT, SOURCE
	}

	public static class XpectTestFileCollector implements IXpectURIProvider {

		protected final XpectTestFiles ctx;
		protected final Class<?> owner;
		protected IBundleInfo project;

		protected XpectTestFileCollector(Class<?> owner, XpectTestFiles ctx) {
			this.owner = owner;
			this.ctx = ctx;
		}

		protected URI createURI(File file) {
			return URI.createFileURI(file.getAbsolutePath());
		}

		public URI deresolveToProject(URI uri) {
			return uri.deresolve(getProject().getRootURI());
		}

		public Collection<URI> getAllURIs() {
			IBundleInfo bundle = getBundle();
			Context context = getContext();
			List<URI> result = Lists.newArrayList();
			String localPath = getLocalPath();
			if (ctx.files().length == 0) {
				result.addAll(bundle.find(context, localPath, Predicates.<String> alwaysTrue(), ctx.fileExtensions()));
			} else {
				for (String file : ctx.files()) {
					if (!Strings.isNullOrEmpty(localPath))
						file = localPath + "/" + file;
					result.add(bundle.find(context, file));
				}
			}
			return result;
		}

		protected IBundleInfo getBundle() {
			Registry registry = IBundleInfo.Registry.INSTANCE;
			if (ctx.relativeTo() == FileRoot.CURRENT)
				return registry.getBundle(URI.createFileURI(new File(".").getAbsolutePath()));
			return getProject();
		}

		protected IBundleInfo.Context getContext() {
			switch (ctx.relativeTo()) {
			case SOURCE:
			case CLASS:
				return Context.SOURCE;
			case PROJECT:
			case CURRENT:
				return Context.ROOT;
			}
			return Context.ROOT;
		}

		protected String getLocalPath() {
			List<String> segments = Lists.newArrayList();
			if (ctx.relativeTo() == FileRoot.CLASS)
				Collections.addAll(segments, owner.getPackage().getName().split("\\."));
			if (!Strings.isNullOrEmpty(ctx.baseDir()))
				Collections.addAll(segments, ctx.baseDir().split("/"));
			return Joiner.on('/').join(segments);
		}

		protected IBundleInfo getProject() {
			if (project == null)
				project = IBundleInfo.Registry.INSTANCE.getBundle(owner);
			return project;
		}

		protected URI resolvePlatformResourceURI(URI uri) {
			List<String> segments = uri.segmentsList();
			if (segments.size() < 2)
				throw new RuntimeException("URI " + uri + " has an invalid format");
			String symbolicName = segments.get(1);
			IBundleInfo bundle = IBundleInfo.Registry.INSTANCE.getBundle(symbolicName);
			if (bundle == null)
				throw new RuntimeException("Bundle " + symbolicName + " not found.");
			URI uriInBundle = URI.createURI(Joiner.on('/').join(segments.subList(2, segments.size())));
			return uriInBundle.resolve(bundle.getRootURI());
		}

		protected URI resolveProjectRelativeURI(URI uri) {
			List<String> segments = uri.segmentsList();
			URI uriInProject = URI.createURI(Joiner.on('/').join(segments));
			return uriInProject.resolve(getProject().getRootURI());
		}

		public URI resolveURI(URI base, String newURI) {
			URI uri = URI.createURI(newURI);
			if (uri.isPlatformResource())
				return resolvePlatformResourceURI(uri);
			if (uri.hasAbsolutePath())
				return resolveProjectRelativeURI(uri);
			return uri.resolve(base);
		}

		@Override
		public String toString() {
			List<String> items = Lists.newArrayList();
			items.add("relativeTo=" + ctx.relativeTo().name());
			if (ctx.files().length > 0)
				items.add("files=" + Joiner.on(",").join(ctx.files()));
			if (!Strings.isNullOrEmpty(ctx.baseDir()))
				items.add("baseDir=" + ctx.baseDir());
			items.add("fileExtensions=" + Joiner.on(",").join(ctx.fileExtensions()));
			return "@" + XpectTestFiles.class.getSimpleName() + "(" + Joiner.on(", ").join(items) + ")";
		}
	}

	String baseDir() default "";

	String[] fileExtensions() default { "xt", "xpect" };

	String[] files() default {};

	FileRoot relativeTo() default FileRoot.CLASS;

}
