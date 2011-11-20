package org.eclipse.xtext.xtend2.compiler.batch;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static java.util.Arrays.*;
import static org.eclipse.xtext.util.Strings.*;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.compiler.batch.BatchCompiler;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.mwe.NameBasedFilter;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class Xtend2BatchCompiler {
	protected final static Logger log = Logger.getLogger(Xtend2BatchCompiler.class.getName());
	@Inject
	private Provider<ResourceSet> resourceSetProvider;
	@Inject
	private Provider<JavaIoFileSystemAccess> javaIoFileSystemAccessProvider;
	@Inject
	private FileExtensionProvider fileExtensionProvider;
	@Inject
	private Provider<ResourceSetBasedResourceDescriptions> resourceSetDescriptionsProvider;
	@Inject
	private JvmModelGenerator generator;
	@Inject
	private IXtend2JvmAssociations xtend2JvmAssociations;
	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;
	@Inject
	private IndexedJvmTypeAccess indexedJvmTypeAccess;

	private String sourcePath;
	private String classPath;
	private String outputPath;
	private String complianceLevel = "1.5";
	private boolean verbose = true;
	private List<File> tempFolders = Lists.newArrayList();

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}

	private String getComplianceLevel() {
		return complianceLevel;
	}

	private boolean isVerbose() {
		return verbose;
	}

	public void compile() {
		try {
			ResourceSet resourceSet = loadXtendFiles();
			File sourceDirectory = createClassStubs(resourceSet);
			File classDirectory = preCompile(sourceDirectory);
			installJvmTypeProvider(resourceSet, classDirectory);
			List<Issue> issues = validate(resourceSet);
			if (reportIssues(issues)) {
				return;
			}
			generateJavaFiles(resourceSet);
		} finally {
			deleteTmpFolders();
		}
	}

	protected ResourceSet loadXtendFiles() {
		final ResourceSet resourceSet = resourceSetProvider.get();
		final NameBasedFilter nameBasedFilter = new NameBasedFilter();
		nameBasedFilter.setExtension(fileExtensionProvider.getPrimaryFileExtension());
		PathTraverser pathTraverser = new PathTraverser();
		pathTraverser.resolvePathes(getSourcePathDirectories(), new Predicate<URI>() {
			public boolean apply(URI input) {
				boolean matches = nameBasedFilter.matches(input);
				if (matches) {
					if (log.isInfoEnabled()) {
						log.info("Load '" + input + "'");
					}
					resourceSet.getResource(input, true);
				}
				return matches;
			}
		});
		return resourceSet;
	}

	private File createClassStubs(ResourceSet resourceSet) {
		File outputDirectory = createTempDir();
		JavaIoFileSystemAccess fileSystemAccess = javaIoFileSystemAccessProvider.get();
		fileSystemAccess.setOutputPath(outputDirectory.toString());
		for (Resource resource : resourceSet.getResources()) {
			XtendClass xtendClass = getXtendClass(resource);
			if (xtendClass == null) {
				continue;
			}
			StringConcatenation classSignatureBuilder = new StringConcatenation();
			classSignatureBuilder.append("package " + xtendClass.getPackageName() + ";");
			classSignatureBuilder.newLine();
			classSignatureBuilder.append("public class " + xtendClass.getName() + "{}");
			fileSystemAccess.generateFile(getJavaFileName(xtendClass), classSignatureBuilder.toString());
		}
		return outputDirectory;
	}

	private File preCompile(File tmpSourceDirectory) {
		File classDirectory = createTempDir();
		List<String> commandLine = Lists.newArrayList();
		// todo args
		if (isVerbose()) {
			commandLine.add("-verbose");
		}
		if (!isEmpty(classPath)) {
			commandLine.add("-cp " + concat(" ", getClassPathEntries()));
		}
		commandLine.add("-d " + classDirectory.toString());
		commandLine.add("-" + getComplianceLevel());
		commandLine.add("-proceedOnError");
		List<String> sourceDirectories = newArrayList(getSourcePathDirectories());
		sourceDirectories.add(tmpSourceDirectory.toString());
		commandLine.add(concat(" ", sourceDirectories));
		BatchCompiler.compile(concat(" ", commandLine), getPrintWriter(), getPrintWriter(), null);
		return classDirectory;
	}

	protected PrintWriter getPrintWriter() {
		return new PrintWriter(new Writer() {
			@Override
			public void write(char[] cbuf, int off, int len) throws IOException {
				log.debug(String.copyValueOf(cbuf, off, len));
			}
			@Override
			public void flush() throws IOException {}
			@Override
			public void close() throws IOException {}
		});
	}

	private List<Issue> validate(ResourceSet resourceSet) {
		List<Issue> issues = Lists.newArrayList();
		List<Resource> resources = Lists.newArrayList(resourceSet.getResources());
		for (Resource resource : resources) {
			IResourceServiceProvider resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE
					.getResourceServiceProvider(resource.getURI());
			IResourceValidator resourceValidator = resourceServiceProvider.getResourceValidator();
			List<Issue> result = resourceValidator.validate(resource, CheckMode.ALL, null);
			addAll(issues, result);
		}
		return issues;
	}

	private void installJvmTypeProvider(ResourceSet resourceSet, File tmpClassDirectory) {
		Iterable<String> classPathEntries = concat(getClassPathEntries(), getSourcePathDirectories(),
				asList(tmpClassDirectory.toString()));
		classPathEntries = filter(classPathEntries, new Predicate<String>() {
			public boolean apply(String input) {
				return !Strings.isEmpty(input.trim());
			}
		});
		Iterable<URL> classPathUrls = Iterables.transform(classPathEntries, new Function<String, URL>() {

			public URL apply(String from) {
				try {
					return new File(from).toURI().toURL();
				} catch (MalformedURLException e) {
					throw new RuntimeException(e);
				}
			}
		});
		if (log.isDebugEnabled()) {
			log.debug("Classpath used for Xtend compilation : "+classPathUrls);
		}
		URLClassLoader urlClassLoader = new URLClassLoader(toArray(classPathUrls, URL.class), getClass().getClassLoader());
		new ClasspathTypeProvider(urlClassLoader, resourceSet, indexedJvmTypeAccess);
		((XtextResourceSet) resourceSet).setClasspathURIContext(urlClassLoader);
	}

	protected boolean reportIssues(List<Issue> issues) {
		boolean hasErrorOrWarnings = false;
		for (Issue issue : issues) {
			if (Severity.WARNING == issue.getSeverity() || Severity.ERROR == issue.getSeverity()) {
				URI resourceUri = issue.getUriToProblem().trimFragment();
				StringBuilder issueBuilder = new StringBuilder("\n");
				issueBuilder.append(issue.getSeverity()).append(": \t");
				issueBuilder.append(resourceUri.lastSegment()).append(" - ");
				if (resourceUri.isFile()) {
					issueBuilder.append(resourceUri.toFileString());
				}
				issueBuilder.append("\n").append(issue.getLineNumber()).append(": ").append(issue.getMessage());
				log.error(issueBuilder);
				hasErrorOrWarnings = true;
			}
		}
		return hasErrorOrWarnings;
	}

	protected void generateJavaFiles(ResourceSet resourceSet) {
		JavaIoFileSystemAccess javaIoFileSystemAccess = javaIoFileSystemAccessProvider.get();
		javaIoFileSystemAccess.setOutputPath(outputPath);
		ResourceSetBasedResourceDescriptions resourceDescriptions = getResourceDescriptions(resourceSet);
		for (IEObjectDescription eObjectDescription : resourceDescriptions
				.getExportedObjectsByType(Xtend2Package.eINSTANCE.getXtendClass())) {
			XtendClass xtendClass = (XtendClass) eObjectDescription.getEObjectOrProxy();
			JvmGenericType jvmGenericType = xtend2JvmAssociations.getInferredType(xtendClass);
			CharSequence generatedType = generator.generateType(jvmGenericType);
			if (log.isInfoEnabled()) {
				log.info("Generate '" + getJavaFileName(xtendClass) + "'");
			}
			javaIoFileSystemAccess.generateFile(getJavaFileName(xtendClass), generatedType);
		}
	}

	protected ResourceSetBasedResourceDescriptions getResourceDescriptions(ResourceSet resourceSet) {
		ResourceSetBasedResourceDescriptions resourceDescriptions = resourceSetDescriptionsProvider.get();
		resourceDescriptions.setContext(resourceSet);
		resourceDescriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE);
		return resourceDescriptions;
	}

	protected String getJavaFileName(XtendClass xtendClass) {
		return Strings.concat("/", getFullyQualifiedName(xtendClass).getSegments()) + ".java";
	}

	protected QualifiedName getFullyQualifiedName(XtendClass xtendClass) {
		return qualifiedNameProvider.getFullyQualifiedName(xtendClass);
	}

	protected XtendClass getXtendClass(Resource resource) {
		XtextResource xtextResource = (XtextResource) resource;
		IParseResult parseResult = xtextResource.getParseResult();
		if (parseResult.getRootASTElement() instanceof XtendFile) {
			XtendFile xtendFile = (XtendFile) parseResult.getRootASTElement();
			return xtendFile.getXtendClass();
		}
		return null;
	}

	protected List<String> getClassPathEntries() {
		return getDirectories(classPath);
	}

	protected List<String> getSourcePathDirectories() {
		return getDirectories(sourcePath);
	}

	protected List<String> getDirectories(String path) {
		if (Strings.isEmpty(path))
			return new java.util.ArrayList<String>();
		final List<String> split = split(emptyIfNull(path), getPathSeparator());
		return transform(split, new Function<String,String>(){
			public String apply(String from) {
				try {
					return new File(from).getCanonicalPath();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}});
	}

	protected String getPathSeparator() {
		return System.getProperty("path.separator");
	}

	protected File createTempDir() {
		File baseDir = new File(System.getProperty("java.io.tmpdir"));
		File tempDir = new File(baseDir, "tmpdir" + String.valueOf(System.nanoTime()));
		tempDir.mkdir();
		tempFolders.add(tempDir);
		return tempDir;
	}

	protected void deleteTmpFolders() {
		for (File file : tempFolders) {
			try {
				Files.cleanFolder(file, new FileFilter() {
					public boolean accept(File pathname) {
						return true;
					}
				}, true, true);
			} catch (FileNotFoundException fileNotFoundException) {
			}
		}
	}

}
