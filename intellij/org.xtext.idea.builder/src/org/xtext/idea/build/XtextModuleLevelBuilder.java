package org.xtext.idea.build;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.jetbrains.jps.ModuleChunk;
import org.jetbrains.jps.builders.DirtyFilesHolder;
import org.jetbrains.jps.builders.java.JavaSourceRootDescriptor;
import org.jetbrains.jps.incremental.BuilderCategory;
import org.jetbrains.jps.incremental.CompileContext;
import org.jetbrains.jps.incremental.FSOperations;
import org.jetbrains.jps.incremental.ModuleBuildTarget;
import org.jetbrains.jps.incremental.ModuleLevelBuilder;
import org.jetbrains.jps.incremental.ProjectBuildException;
import org.jetbrains.jps.incremental.messages.CustomBuilderMessage;
import org.jetbrains.jps.model.module.JpsModuleSourceRoot;
import org.jetbrains.jps.service.JpsServiceManager;
import org.xtext.idea.generator.IdeaFileSystemAccess.IdeaFileSystemAccessProvider;

import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.util.Processor;

public class XtextModuleLevelBuilder extends ModuleLevelBuilder {
	
	private static final Logger LOG = Logger.getInstance("org.xtext.idea.build.XtextModuleLevelBuilder");
	
	public static final String BUILDER_NAME = "xtext";

	@Inject
	private XtextIdeaRefreshComponent refreshComponent;

	private final Collection<Injector> injectors;

	protected XtextModuleLevelBuilder() {
		super(BuilderCategory.SOURCE_GENERATOR);
		injectors = new ArrayList<Injector>();
		for (ISetup setup : JpsServiceManager.getInstance().getExtensions(ISetup.class)) {
			injectors.add(setup.createInjectorAndDoEMFRegistration());
		}
	}
	
	@Override
	public void buildFinished(CompileContext context) {
		Collection<String> filesToRefresh = refreshComponent.getFilesToRefresh();
		if (LOG.isDebugEnabled()) {
			LOG.debug("filesToRefresh: " + filesToRefresh);
		}
		if (!filesToRefresh.isEmpty()) {
			for (String file : filesToRefresh) {
				context.processMessage(new CustomBuilderMessage(BUILDER_NAME, "generated", file));
			}
			context.processMessage(new CustomBuilderMessage(BUILDER_NAME, "refresh", ""));
		}
	}

	@Override
	public ExitCode build(
			CompileContext context,
			ModuleChunk chunk,
			DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder,
			OutputConsumer outputConsumer) throws ProjectBuildException,
			IOException {
		ExitCode exitCode = ExitCode.NOTHING_DONE;

		File output = getOutput(chunk);
		if (cleanOutput(context, output)) {
			exitCode = ExitCode.OK;
		}

		for (Injector injector : injectors) {
			if (build(context, chunk, dirtyFilesHolder, outputConsumer, output, injector)) {
				exitCode = ExitCode.OK;
			}
		}

		return exitCode;
	}
	
	protected boolean build(
			CompileContext context, 
			ModuleChunk chunk,
			DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder,
			OutputConsumer outputConsumer,
			File output,
			Injector injector) {
		List<File> filesToCompile = getFilesToCompile(chunk, injector);
		if (filesToCompile.isEmpty()) {
			return false;
		}
		IGenerator generator = injector.getInstance(IGenerator.class);
		IFileSystemAccess fsa = getFileSystemAccess(output, context, chunk, outputConsumer, injector);
		ResourceSet resourceSet = loadFiles(filesToCompile);
		for (File file : filesToCompile) {
			Resource resource = resourceSet.getResource(URI.createFileURI(file.getAbsolutePath()), false);
			generator.doGenerate(resource, fsa);
		}
		return true;
	}

	@Override
	public List<String> getCompilableFileExtensions() {
		List<String> extensions = new ArrayList<String>();
		for (Injector injector : injectors) {
			Set<String> fileExtensions = getFileExtensions(injector);
			extensions.addAll(fileExtensions);
		}
		return extensions;
	}

	protected Set<String> getFileExtensions(Injector injector) {
		FileExtensionProvider fileExtensionProvider = getFileExtensionProvider(injector);
		return fileExtensionProvider.getFileExtensions();
	}

	protected FileExtensionProvider getFileExtensionProvider(Injector injector) {
		return injector.getInstance(FileExtensionProvider.class);
	}
	
	protected boolean cleanOutput(final CompileContext context, final File outputDir) {
		final boolean result[] = {false};
		FileUtil.processFilesRecursively(outputDir, new Processor<File>() {

			@Override
			public boolean process(File file) {
				if (file.isFile()) {
					refreshComponent.refresh(file.getPath());
					try {
						FSOperations.markDeleted(context, file);
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
				return true;
			}
			
		});
		FileUtil.processFilesRecursively(outputDir, new Processor<File>() {

			@Override
			public boolean process(File file) {
				if (outputDir != file) {
					FileUtil.delete(file);
					result[0] = true;
				}
				return true;
			}

		}, new Processor<File>() {
			
			@Override
			public boolean process(File dir) {
				return outputDir == dir;
			}
			
		});
		return result[0];
	}

	protected ResourceSet loadFiles(List<File> filesToCompile) {
		ResourceSet resourceSet = new XtextResourceSet();
		for (File file : filesToCompile) {
			resourceSet.getResource(URI.createFileURI(file.getAbsolutePath()), true);
		}
		EcoreUtil.resolveAll(resourceSet);
		return resourceSet;
	}

	protected IFileSystemAccess getFileSystemAccess(File output, CompileContext context, ModuleChunk chunk, OutputConsumer outputConsumer, Injector injector) {
		IdeaFileSystemAccessProvider ideaFileSystemAccessProvider = injector.getInstance(IdeaFileSystemAccessProvider.class);
		return ideaFileSystemAccessProvider.get(context, chunk, output, outputConsumer, refreshComponent);
	}

	protected List<File> getFilesToCompile(ModuleChunk chunk, Injector injector) {
		final FileExtensionProvider fileExtensionProvider = getFileExtensionProvider(injector);
		final List<File> filesToCompile = new ArrayList<File>();
		File root = getInput(chunk);
		FileUtil.processFilesRecursively(root, new Processor<File>() {
			
			@Override
			public boolean process(File file) {
				if (file.isFile()) {
					String fileExtension = Files.getFileExtension(file.getName());
					if (fileExtensionProvider.isValid(fileExtension)) {
						filesToCompile.add(file);
					}
				}
				return true;
			}
			
		});
		return filesToCompile;
	}

	protected File getInput(ModuleChunk chunk) {
		return getSourceRoot(chunk, "src");
	}

	protected File getOutput(ModuleChunk chunk) {
		return getSourceRoot(chunk, "src-gen");
	}

	protected File getSourceRoot(ModuleChunk chunk, String name) {
		for (JpsModuleSourceRoot sourceRoot : chunk.representativeTarget().getModule().getSourceRoots()) {
			File file = sourceRoot.getFile();
			if (file.getName().equals(name)) {
				return file;
			}
		}
		throw new IllegalStateException("Source root '" + name + "' does not exist.");
	}

	@Override
	public String getPresentableName() {
		return BUILDER_NAME;
	}

}
