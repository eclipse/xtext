package org.xtext.idea.generator;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.RuntimeIOException;
import org.jetbrains.jps.ModuleChunk;
import org.jetbrains.jps.incremental.CompileContext;
import org.jetbrains.jps.incremental.FSOperations;
import org.jetbrains.jps.incremental.ModuleLevelBuilder.OutputConsumer;
import org.xtext.idea.build.XtextIdeaRefreshComponent;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

public class IdeaFileSystemAccess extends JavaIoFileSystemAccess {

	private ModuleChunk chunk;

	private CompileContext context;

	private OutputConsumer outputConsumer;

	private XtextIdeaRefreshComponent refreshComponent;

	@Override
	public void generateFile(String fileName, String outputConfigName, CharSequence contents) throws RuntimeIOException {
		super.generateFile(fileName, outputConfigName, contents);
		File file = getFile(fileName, outputConfigName);
  		refresh(file.getPath());
		markDirty(file);
	}
	
	@Override
	public void deleteFile(String fileName, String outputConfiguration) {
		super.deleteFile(fileName, outputConfiguration);
		File file = getFile(fileName, outputConfiguration);
		refresh(file.getPath());
		markDeleted(file);
	}

	protected void registerOutputFile(File file, String outputConfigName) {
		String outlet = getPathes().get(outputConfigName);
		try {
			outputConsumer.registerOutputFile(chunk.representativeTarget(), file, Arrays.asList(outlet));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/** 
	 * mark dirty to re-compile
	 * 
	 * @param file
	 */
    protected void markDirty(File file) {
    	 try {
			FSOperations.markDirty(context, file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/** 
	 * mark deleted
	 * 
	 * @param file
	 */
    protected void markDeleted(File file) {
    	 try {
			FSOperations.markDeleted(context, file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/** 
	 * refresh virtual file in IDEA
	 * 
	 * @param file
	 */
	protected void refresh(String path) {
		refreshComponent.refresh(path);
	}
	
    @Singleton
	public static class IdeaFileSystemAccessProvider {
		
		@Inject
		private Provider<IdeaFileSystemAccess> fsaProvider;

		public IdeaFileSystemAccess get(CompileContext context, ModuleChunk chunk, File output, OutputConsumer outputConsumer, XtextIdeaRefreshComponent refreshComponent) {
			IdeaFileSystemAccess fsa = fsaProvider.get();
			fsa.setChunk(chunk);
			fsa.setContext(context);
			fsa.setOutputPath(output.getPath());
			fsa.setOutputConsumer(outputConsumer);
			fsa.setRefreshComponent(refreshComponent);
			return fsa;
		}
		
	}

	public void setChunk(ModuleChunk chunk) {
		this.chunk = chunk;
	}

	public void setContext(CompileContext context) {
		this.context = context;
	}

	public void setOutputConsumer(OutputConsumer outputConsumer) {
		this.outputConsumer = outputConsumer;
	}

	public void setRefreshComponent(XtextIdeaRefreshComponent refreshComponent) {
		this.refreshComponent = refreshComponent;
	}

}
