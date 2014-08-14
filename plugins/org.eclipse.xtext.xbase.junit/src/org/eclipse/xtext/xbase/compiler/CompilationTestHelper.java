/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.junit4.TemporaryFolder;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.compiler.RegisteringFileSystemAccess.GeneratedFile;
import org.eclipse.xtext.xbase.file.ProjectConfig;
import org.eclipse.xtext.xbase.file.RuntimeWorkspaceConfigProvider;
import org.eclipse.xtext.xbase.file.WorkspaceConfig;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * A utility class for testing Xtext languages that compile to Java code.
 * It's designed to be used as an injected extension in unit tests written in Xtend.
 * 
 * Example:
 * <code>
 * @RunWith(XtextRunner)
 * @InjectWith(MyLanguageInjectorProvider) 
 * class CompilerTest {
 *	
 *	@Rule @Inject public TemporaryFolder temporaryFolder
 *	@Inject extension CompilationTestHelper
 *	
 *	@Test def void myTest() {
 *	  '''
 *	    // DSL code
 *	    Foo bla
 *	  '''.assertCompilesTo('''
 *	    class Foo {
 *	       String bla
 *	    }
 *	  '''
 *	}
 *  }
 * </code>
 * 
 * @author Sven Efftinge
 * 
 * @since 2.7
 */
public class CompilationTestHelper {
	
	public final static String PROJECT_NAME = "myProject";
	
	@Inject private TemporaryFolder temporaryFolder;
	
	@Inject private OnTheFlyJavaCompiler javaCompiler;
	
	@Inject private Provider<XtextResourceSet> resourceSetProvider;
	
	@Inject private FileExtensionProvider extensionProvider;

	@Inject private IOutputConfigurationProvider outputConfigurationProvider;
	
	@Inject private Provider<Result> resultProvider;

	private RuntimeWorkspaceConfigProvider configProvider;

	@Inject
	private void setWorkspaceConfig(RuntimeWorkspaceConfigProvider configProvider) {
		this.configProvider = configProvider;
		configureFreshWorkspace();
	}
	
	public void configureFreshWorkspace() {
		File tempDir = createFreshTempDir();
		WorkspaceConfig config = new WorkspaceConfig(tempDir.getAbsolutePath());
		ProjectConfig projectConfig = new ProjectConfig(PROJECT_NAME);
		projectConfig.addSourceFolderMapping("src", "src-gen");
		config.addProjectConfig(projectConfig);
		configProvider.setWorkspaceConfig(config);
	}
	
	protected String getSourceFolderPath() {
		return "/"+PROJECT_NAME+"/src";
	}
	
	protected File createFreshTempDir() {
		try {
			return temporaryFolder.newFolder();
		} catch (IOException e) {
			throw new AssertionError(e);
		}
	}
	
	public void setJavaCompilerClassPath(Class<?> ...classes) {
		javaCompiler.clearClassPath();
		for (Class<?> clazz : classes) {
			javaCompiler.addClassPathOfClass(clazz);
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
	 * Parses, validates and compiles the given source. Calls the given acceptor for each
	 * resource which is generated from the source.
	 *  
	 * @param source some code written in the language under test.
	 * @param acceptor gets called once for each file generated in {@link IGenerator}
	 * @throws IOException if the resource loading fails 
	 */
	@SuppressWarnings("unchecked")
	public void compile(CharSequence source, IAcceptor<Result> acceptor) throws IOException {
		String fileName = "MyFile."+extensionProvider.getPrimaryFileExtension();
		compile(resourceSet(new Pair<String, CharSequence>(fileName, source)), acceptor);
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
			List<Resource> resourcesToCheck = newArrayList(resourceSet.getResources());
			Result result = resultProvider.get();
			result.setJavaCompiler(javaCompiler);
			result.setResources(resourcesToCheck);
			result.setResourceSet(resourceSet);
			result.setOutputConfigurations(getOutputConfigurations());
			result.doGenerate();
			acceptor.accept(result);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected Iterable<? extends OutputConfiguration> getOutputConfigurations() {
		return outputConfigurationProvider.getOutputConfigurations();
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
			URI uri = copyToWorkspace(getSourceFolderPath()+"/"+entry.getKey(), entry.getValue());
			Resource resource = result.createResource(uri);
			if (resource == null)
				throw new IllegalStateException("Couldn't create resource for URI "+uri+". Resource.Factory not registered?");
			resource.load(newHashMap());
		}
		return result;
	}
	
	/**
	 * Physically copies the given files to the currently used worksapce root (a temporary folder).
	 * @param workspacefilePath the workspace relative path
	 * @param contents the file contents
	 */
	public URI copyToWorkspace(String workspacefilePath, CharSequence contents) {
		File workspaceRoot = new File(this.configProvider.getWorkspaceConfig().getAbsoluteFileSystemPath());
		File fullPath = new File(workspaceRoot.getAbsolutePath()+"/"+workspacefilePath);
		if (fullPath.exists()) {
			fullPath.delete();
		} else {
			mkDir(fullPath.getParentFile());
		}
		URI uri = URI.createFileURI(fullPath.getAbsolutePath());
		Files.writeStringIntoFile(uri.toFileString(), contents.toString());
		return uri;
	}
	
	private void mkDir(File file) {
		if (!file.getParentFile().exists()) {
			mkDir(file.getParentFile());
		}
		if (!file.exists()) {
			file.mkdir();
		}
	}
	
	/**
	 * same as {@link #resourceSet(Pair...)} but without actually loading the created resources.
	 */
	public ResourceSet unLoadedResourceSet(Pair<String,? extends CharSequence> ...resources ) throws IOException {
		XtextResourceSet result = resourceSetProvider.get();
		for (Pair<String, ? extends CharSequence> entry : resources) {
			URI uri = copyToWorkspace(getSourceFolderPath()+"/"+entry.getKey(), entry.getValue());
			Resource resource = result.createResource(uri);
			if (resource == null)
				throw new IllegalStateException("Couldn't create resource for URI "+uri+". Resource.Factory not registered?");
		}
		return result;
	}
	
	/**
	 * A result contains information about various aspects of a compiled piece of code.
	 */
	public static class Result {
		
		@Inject private IResourceServiceProvider.Registry serviceRegistry;
		@Inject private Provider<RegisteringFileSystemAccess> fileSystemAccessProvider;
		
		private OnTheFlyJavaCompiler javaCompiler;
		private ResourceSet resourceSet;
		private List<Resource> sources;
		private Map<String,OutputConfiguration> outputConfigurations;
		
		public void setResourceSet(ResourceSet resourceSet) {
			this.resourceSet = resourceSet;
		}
		
		public void setResources(List<Resource> sources) {
			this.sources = sources;
		}
		
		public void setJavaCompiler(OnTheFlyJavaCompiler javaCompiler) {
			this.javaCompiler = javaCompiler;
		}
		
		public void setOutputConfigurations(Iterable<? extends OutputConfiguration> outputConfiguration) {
			this.outputConfigurations = newHashMap();
			for (OutputConfiguration conf : outputConfiguration) {
				outputConfigurations.put(conf.getName(), conf);
			}
		}
		
		private ClassLoader classLoader;
		private Map<String,Class<?>> compiledClasses;
		private Map<String,String> generatedCode;
		private RegisteringFileSystemAccess access;
		private ResourceDescriptionsData index;
		private List<Issue> allErrorsAndWarnings;
		
		
		public List<Issue> getErrorsAndWarnings() {
			doValidation();
			return allErrorsAndWarnings;
		}

		public Map<String,Class<?>> getCompiledClasses() {
			doCompile();
			return compiledClasses;
		}
		
		public ClassLoader getClassLoader() {
			doCompile();
			return classLoader;
		}
		
		public Map<String,String> getGeneratedCode() {
			doGenerate();
			return generatedCode;
		}

		public String getGeneratedCode(String typeName) {
			return getGeneratedCode().get(typeName);
		}
		
		public String getSingleGeneratedCode() {
			doGenerate();
			if (access.getTextFiles().size() == 1)
				return access.getTextFiles().iterator().next().getContents().toString();
			String separator = System.getProperty("line.separator");
			if (separator == null)
				separator = "\n";
			List<GeneratedFile> files = newArrayList(access.getTextFiles());
			Collections.sort(files, new Comparator<GeneratedFile>() {
				public int compare(GeneratedFile o1,
						GeneratedFile o2) {
					return o1.getPath().toString().compareTo(o2.getPath().toString());
				}
			});
			StringBuilder result = new StringBuilder("MULTIPLE FILES WERE GENERATED"+separator+separator);
			int i = 1;
			for (GeneratedFile file: files) {
				result.append("File "+i+" : "+file.getPath().toString()+separator+separator);
				result.append(file.getContents()).append(separator);
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
			doGenerate();
			Map<String,CharSequence> result = newHashMap();
			for (GeneratedFile f: access.getTextFiles()) {
				result.put(f.getPath().toString(), f.getContents());
			}
			return result;
		}
		
		protected void doIndex() {
			if (index == null) {
				// indexing
				List<IResourceDescription> descriptions = newArrayList();
				for (Resource resource : sources) {
					IResourceServiceProvider serviceProvider = serviceRegistry.getResourceServiceProvider(resource.getURI());
					IResourceDescription description = serviceProvider.getResourceDescriptionManager().getResourceDescription(resource);
					descriptions.add(description);
				}
				index = new ResourceDescriptionsData(descriptions);
				ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(resourceSet, index);
			}
		}
		
		protected void doLinking() {
			doIndex();
			for (Resource resource : sources) {
				EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
			}
		}
		
		protected void doValidation() {
			if (allErrorsAndWarnings == null) {
				
				doLinking();
				
				allErrorsAndWarnings = newArrayList();
				// validation
				for (Resource resource : sources) {
					if (resource instanceof XtextResource) {
						XtextResource xtextResource = (XtextResource) resource;
						List<Issue> issues = xtextResource.getResourceServiceProvider().getResourceValidator().validate(xtextResource, CheckMode.ALL, CancelIndicator.NullImpl);
						for (Issue issue : issues) {
							allErrorsAndWarnings.add(issue);
						}
					}
				}
			}
		}
		
		protected void doGenerate() {
			if (access == null) {
				doValidation();
				access = fileSystemAccessProvider.get();
				access.setOutputConfigurations(outputConfigurations);
				access.setCurrentSource("src");
				access.setProjectName(PROJECT_NAME);
				for (Resource resource : sources) {
					if (resource instanceof XtextResource) {
						XtextResource xtextResource = (XtextResource) resource;
						IGenerator generator = xtextResource.getResourceServiceProvider().get(IGenerator.class);
						if (generator != null) {
							generator.doGenerate(xtextResource, access);
						}
					}
				}
				generatedCode = newHashMap();
				for (final GeneratedFile e : access.getTextFiles()) {
					if (e.getJavaClassName() != null) {
						generatedCode.put(e.getJavaClassName(), e.getContents().toString());
					}
				}
			}
		}
		
		protected void doCompile() {
			if (compiledClasses == null || classLoader==null) {
				doGenerate();
				try {
					org.eclipse.xtext.util.Pair<ClassLoader, Map<String, Class<?>>> compilationResult = javaCompiler.internalCompileToClasses(getGeneratedCode());
					this.classLoader = compilationResult.getFirst();
					this.compiledClasses = compilationResult.getSecond();
				} catch (IllegalArgumentException e) {
					throw new AssertionError(e);
				}
			}
		}
	}
	

	
}
