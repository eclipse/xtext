package org.eclipse.xtext.builder.smap;

import java.io.InputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.BuildContext;
import org.eclipse.jdt.core.compiler.CompilationParticipant;
import org.eclipse.jdt.internal.core.Region;
import org.eclipse.xtext.generator.trace.ITraceInformation;
import org.eclipse.xtext.generator.trace.SmapSupport;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.Files;

import com.google.inject.Inject;

public class SmapInstallingCompilationParticipant extends CompilationParticipant {

	@Inject
	private ITraceInformation traceInformation;
	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;
	
	@Inject private SmapSupport smapSupport;

	@Override
	public boolean isActive(IJavaProject project) {
		return org.eclipse.xtext.ui.XtextProjectHelper.hasNature(project.getProject());
	}

	private BuildContext[] files;

	@Override
	public void buildStarting(BuildContext[] files, boolean isBatch) {
		super.buildStarting(files, isBatch);
		this.files = files;
	}

	@Override
	public void buildFinished(IJavaProject project) {
		try {
			super.buildFinished(project);
			if (files == null)
				return;
			for (BuildContext ctx : files) {
				IJavaElement element = JavaCore.create(ctx.getFile());
				if (element != null && element.exists()) {
					IFile smapFile = findSmapFile(ctx);
					if (smapFile != null && smapFile.exists()) {
						try {
							String smapAsString = Files.readStreamIntoString(smapFile.getContents());
							// install into bytecode
							Region region = new Region();
							region.add(element);
							IResource[] resources = JavaCore.getGeneratedResources(region, false);
							for (IResource res : resources) {
								if (res instanceof IFile) {
									IFile file = (IFile) res;
									InputStream newByteCode = smapSupport.getModifiedByteCode(smapAsString, file.getContents());
									file.setContents(newByteCode, IResource.KEEP_HISTORY, null);
								}
							}
						} finally {
							smapFile.delete(true, null);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			files = null;
		}
	}

	protected IFile findSmapFile(BuildContext ctx) {
		final IContainer container = ctx.getFile().getParent();
		return container.getFile(new Path(ctx.getFile().getName().toString().replace(".java", ".smap")));
	}

}
