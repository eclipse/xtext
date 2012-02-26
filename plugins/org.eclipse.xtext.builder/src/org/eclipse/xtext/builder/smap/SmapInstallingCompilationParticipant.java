package org.eclipse.xtext.builder.smap;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.BuildContext;
import org.eclipse.jdt.core.compiler.CompilationParticipant;
import org.eclipse.jdt.internal.core.Region;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceInformation;
import org.eclipse.xtext.generator.trace.SmapSupport;
import org.eclipse.xtext.resource.IResourceServiceProvider;

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
				ITypeRoot javaElement = (ITypeRoot) JavaCore.create(ctx.getFile());
				ITrace information = traceInformation.getTraceToSource(ctx.getFile());
				if (information == null)
					continue;
				final AbstractTraceRegion rootTraceRegion = ((ITrace.Internal) information).getRootTraceRegion();
				if (rootTraceRegion == null)
					continue;
				String smap = smapSupport.generateSmap(rootTraceRegion, information.getLocalURI().lastSegment());
				System.out.println(smap);
				
				// install into bytecode
				Region region = new Region();
				region.add(javaElement);
				IResource[] resources = JavaCore.getGeneratedResources(region, false);
				for (IResource res : resources) {
					if (res instanceof IFile) {
						IFile file = (IFile) res;
						InputStream newByteCode = smapSupport.getModifiedByteCode(smap, file.getContents());
						file.setContents(newByteCode, IResource.KEEP_HISTORY, null);
					}
				}
			}
			files = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
