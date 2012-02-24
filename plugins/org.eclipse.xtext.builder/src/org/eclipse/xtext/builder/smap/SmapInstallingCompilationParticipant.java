package org.eclipse.xtext.builder.smap;

import static com.google.common.collect.Maps.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.BuildContext;
import org.eclipse.jdt.core.compiler.CompilationParticipant;
import org.eclipse.jdt.internal.core.Region;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceInformation;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.smap.SDEInstaller;
import org.eclipse.xtext.smap.SmapGenerator;
import org.eclipse.xtext.smap.SmapStratum;
import org.eclipse.xtext.util.Files;

import com.google.inject.Inject;

public class SmapInstallingCompilationParticipant extends CompilationParticipant {

	@Inject
	private ITraceInformation traceInformation;
	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

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
				SmapGenerator generator = new SmapGenerator();
				generator.setOutputFileName(information.getLocalURI().lastSegment());
				Map<String,SmapStratum> strata = newHashMap(); 
				createSmapInfo(rootTraceRegion, strata, -1);

				for (SmapStratum stratum : strata.values()) {
					generator.addStratum(stratum, true);
				}
				String smap = generator.getString();
				System.out.println(smap);
				
				// install into bytecode
				Region region = new Region();
				region.add(javaElement);
				IResource[] resources = JavaCore.getGeneratedResources(region, false);
				for (IResource res : resources) {
					if (res instanceof IFile) {
						IFile file = (IFile) res;
						byte[] byteCode = Files.readStreamIntoByteArray(file.getContents());
						InputStream newByteCode = new ByteArrayInputStream(
								new SDEInstaller(byteCode, smap.getBytes()).getUpdatedByteCode());
						file.setContents(newByteCode, IResource.KEEP_HISTORY, null);
					}
				}
			}
			files = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void createSmapInfo(AbstractTraceRegion targetRegion, Map<String,SmapStratum> strata, int mappedLine) {
		if (mappedLine == targetRegion.getMyLineNumber()) {
			if (mappedLine == targetRegion.getMyEndLineNumber())
				return; //SKIP
			for (AbstractTraceRegion nested: targetRegion.getNestedRegions()) {
				createSmapInfo(nested, strata, mappedLine);
			}
		}
		ILocationData location = targetRegion.getMergedAssociatedLocation();
		if (location != null) {
			final URI path = targetRegion.getAssociatedPath();
			if (path != null) {
				final String fileName = path.trimFragment().lastSegment();
				SmapStratum stratum = strata.get(fileName);
				if (stratum == null) {
					IResourceServiceProvider provider = serviceProviderRegistry.getResourceServiceProvider(path.trimFragment());
					String name = provider.get(LanguageInfo.class).getShortName();
					stratum = new SmapStratum(name);
					strata.put(fileName, stratum);
				}
				stratum.addFile(fileName, getPath(path));
				stratum.addLineData(location.getLineNumber()+1, fileName, 1, targetRegion.getMyLineNumber()+1, 1);
			}
		}
		if (targetRegion.getMyLineNumber() != targetRegion.getMyEndLineNumber()) {
			for (AbstractTraceRegion nested: targetRegion.getNestedRegions()) {
				createSmapInfo(nested, strata, targetRegion.getMyLineNumber());
			}
		}
	}

	protected String getPath(URI path) {
		String fullPath = path.trimFragment().toPlatformString(true);
		final String substring = fullPath.substring(fullPath.substring(1).indexOf('/')+1);
		System.out.println(substring);
		return substring;
	}
}
