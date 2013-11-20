/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static java.util.Collections.emptyMap;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.file.ProjectConfig;
import org.eclipse.xtext.xbase.file.RuntimeWorkspaceConfigProvider;
import org.eclipse.xtext.xbase.file.WorkspaceConfig;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;

import com.google.common.base.Joiner;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge
 */
public class CompilationTestHelper {
	
	private final static Logger log = Logger.getLogger(CompilationTestHelper.class);
	
	@Inject private OnTheFlyJavaCompiler javaCompiler;
	
	@Inject private Provider<XtextResourceSet> resourceSetProvider;
	
	@Inject private FileExtensionProvider extensionProvider;

	@Inject private Provider<InMemoryFileSystemAccess> fileSystemAccessProvider;
	
	@Inject private RuntimeWorkspaceConfigProvider configProvider;
	
	public void setJavaCompilerClassPath(Class<?> ...classes) {
		javaCompiler.clearClassPath();
		for (Class<?> clazz : classes) {
			javaCompiler.addClassPathOfClass(clazz);
		}
	}
	
	public void configureFreshWorkspace() {
		File tempDir = createFreshTempDir();
		WorkspaceConfig config = new WorkspaceConfig(tempDir.getAbsolutePath());
		ProjectConfig projectConfig = new ProjectConfig("myProject");
		projectConfig.addSourceFolderMapping("src", "xtend-gen");
		config.addProjectConfig(projectConfig);
		configProvider.setWorkspaceConfig(config); 
	}
	
	protected File createFreshTempDir() {
		File tempDir;
		try {
			tempDir = File.createTempFile("temp", Long.toString(System.nanoTime()));
			if (!tempDir.delete()) {
				throw new IllegalStateException("couldn't delete temp file.");
			}
			if (!tempDir.mkdir()) {
				throw new IllegalStateException("couldn't create temp dir.");
			}
			return tempDir;
		} catch (IOException e) {
			throw new AssertionError(e);
		}
	}
	
	/**
	 * Asserts that the expected code is generated for the given source.
	 * Assumes that
	 * 
	 * @param source some valid source code written in the language under test
	 * @param expected the expected Java source code.
	 * @throws IOException if the resource loading fails 
	 */
	public void assertCompilesTo(CharSequence source, final CharSequence expected) throws IOException {
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

		ResourceSet getResourceSet();

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
	 * @throws IOException if the resource loading fails 
	 */
	@SuppressWarnings("unchecked")
	public void compile(CharSequence source, IAcceptor<Result> acceptor) throws IOException {
		String fileName = getSourceFolderPath()+"MyFile."+extensionProvider.getPrimaryFileExtension();
		compile(resourceSet(new Pair<String, CharSequence>(fileName, source)), acceptor);
	}
	
	protected String getSourceFolderPath() {
		Map<String, ProjectConfig> projects = configProvider.get().getProjects();
		if (!projects.isEmpty()) {
			ProjectConfig next = projects.values().iterator().next();
			if (!next.getSourceFolderMappings().isEmpty())
				return next.getSourceFolderMappings().keySet().iterator().next().toString()+"/";
		}
		return "/";
	}

	/**
	 * Parses, validates and compiles the given source. Calls the given acceptor for each
	 * resource which is generated from the source.
	 *  
	 * @param resourceSet - the {@link ResourceSet} to use
	 * @param acceptor gets called once for each file generated in {@link IGenerator}
	 */
	public void compile(final ResourceSet resourceSet, IAcceptor<Result> acceptor) {
		try {
			boolean hasErrors = false;
			List<Issue> allErrors = newArrayList();
			List<Resource> resourcesToCheck = newArrayList(resourceSet.getResources());
			for (Resource resource : resourcesToCheck) {
				if (resource instanceof XtextResource) {
					XtextResource xtextResource = (XtextResource) resource;
					if (!xtextResource.isLoaded()) {
						xtextResource.load(resourceSet.getLoadOptions());
					}
					List<Issue> issues = xtextResource.getResourceServiceProvider().getResourceValidator().validate(xtextResource, CheckMode.ALL, CancelIndicator.NullImpl);
					for (Issue issue : issues) {
						if (issue.getSeverity() == Severity.ERROR) {
							hasErrors = true;
							log.error(issue);
							allErrors.add(issue);
						} else {
							log.info(issue);
						}
					}
				}
			}
			if (hasErrors) {
				throw new IllegalStateException("One or more resources contained errors : "+Joiner.on(',').join(allErrors));
			}
			
			final InMemoryFileSystemAccess access = fileSystemAccessProvider.get();
			for (Resource resource : resourcesToCheck) {
				if (resource instanceof XtextResource) {
					XtextResource xtextResource = (XtextResource) resource;
					IGenerator generator = xtextResource.getResourceServiceProvider().get(IGenerator.class);
					if (generator != null)
						generator.doGenerate(xtextResource, access);
				}
			}
			acceptor.accept(new Result() {
				
				private Map<String,Class<?>> compiledClasses;
				private Map<String,String> generatedCode;
				
				public Map<String,Class<?>> getCompiledClasses() {
					if (compiledClasses == null) {
						try {
							compiledClasses = javaCompiler.compileToClasses(getGeneratedCode());
						} catch (IllegalArgumentException e) {
							throw new AssertionError(e);
						}
					}
					return compiledClasses;
				}
				
				public Map<String,String> getGeneratedCode() {
					if (generatedCode == null) {
						generatedCode = newHashMap();
						for (final Entry<String, CharSequence> e : access.getTextFiles().entrySet()) {
							String name = e.getKey().substring("DEFAULT_OUTPUT".length(), e.getKey().length() - ".java".length());
							generatedCode.put(name.replace('/', '.'), e.getValue().toString());
						}
					}
					return generatedCode;
				}

				public String getGeneratedCode(String typeName) {
					return getGeneratedCode().get(typeName);
				}
				
				public String getSingleGeneratedCode() {
					if (access.getTextFiles().size() == 1)
						return access.getTextFiles().values().iterator().next().toString();
					String separator = System.getProperty("line.separator");
					if (separator == null)
						separator = "\n";
					List<Entry<String,CharSequence>> files = newArrayList(access.getTextFiles().entrySet());
					Collections.sort(files, new Comparator<Entry<String,CharSequence>>() {
						public int compare(Entry<String, CharSequence> o1,
								Entry<String, CharSequence> o2) {
							return o1.getKey().compareTo(o2.getKey());
						}
					});
					StringBuilder result = new StringBuilder("MULTIPLE FILES WERE GENERATED"+separator+separator);
					int i = 1;
					for (Entry<String,CharSequence> entry: files) {
						result.append("File "+i+" : "+entry.getKey().replace("DEFAULT_OUTPUT", "")+separator+separator);
						result.append(entry.getValue()).append(separator);
						i++;
					}
					return result.toString();
				}

				public ResourceSet getResourceSet() {
					return resourceSet;
				}

				public Class<?> getCompiledClass() {
					return IterableExtensions.head(getCompiledClasses().values());
				}
				
				public Class<?> getCompiledClass(String className) {
					return getCompiledClasses().get(className);
				}

				public Map<String, CharSequence> getAllGeneratedResources() {
					return access.getTextFiles();
				}
				
			});
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * creates a fresh resource set with the given resources
	 * 
	 * @param resources - pairs of file names and their contents 
	 * @return a ResourceSet, containing the given resources.
	 * @throws IOException if the resource loading fails 
	 */
	public ResourceSet resourceSet(Pair<String,? extends CharSequence> ...resources ) throws IOException {
		XtextResourceSet result = resourceSetProvider.get();
		for (Pair<String, ? extends CharSequence> entry : resources) {
			final URI uri = URI.createURI(entry.getKey());
			Resource resource = result.createResource(uri);
			if (resource == null)
				throw new IllegalStateException("Couldn't create resource for URI "+uri+". Resource.Factory not registered?");
			resource.load(new StringInputStream(entry.getValue().toString()), emptyMap());
		}
		return result;
	}
	
	public ResourceSet unLoadedResourceSet(Pair<String,? extends CharSequence> ...resources ) throws IOException {
		XtextResourceSet result = resourceSetProvider.get();
		final Map<URI, CharSequence> uri2Content = newHashMap();
		result.setURIConverter(new ExtensibleURIConverterImpl() {
			@Override
			public InputStream createInputStream(URI uri, Map<?, ?> options)
					throws IOException {
				CharSequence charSequence = uri2Content.get(uri);
				if (charSequence != null)
					return new StringInputStream(charSequence.toString());
				return super.createInputStream(uri, options);
			}
		});
		for (Pair<String, ? extends CharSequence> entry : resources) {
			final URI uri = URI.createURI(entry.getKey());
			Resource resource = result.createResource(uri);
			if (resource == null)
				throw new IllegalStateException("Couldn't create resource for URI "+uri+". Resource.Factory not registered?");
			uri2Content.put(uri, entry.getValue());
		}
		return result;
	}
	
	
	
}
