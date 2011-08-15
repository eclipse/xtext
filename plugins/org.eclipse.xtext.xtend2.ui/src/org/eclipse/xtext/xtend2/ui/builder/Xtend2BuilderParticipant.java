/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.builder;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.util.Strings.*;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xtend2.compiler.Xtend2Compiler;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2BuilderParticipant implements IXtextBuilderParticipant {

	private static final Logger LOG = Logger.getLogger(Xtend2BuilderParticipant.class);

	@Inject 
	private FileExtensionProvider fileExtensionProvider;

	@Inject
	private Xtend2Compiler compiler;

	@Inject
	private CompilationFileProvider compilationFileProvider;

	@Inject
	private IEncodingProvider encodingProvider;

	@Inject
	private FolderUtil folderUtil;

	public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
		try {
			if (!JavaCore.create(context.getBuiltProject()).exists())
				return;
			Iterable<Delta> xtendDeltas = filter(context.getDeltas(), new Predicate<Delta>() {
				public boolean apply(Delta input) {
					return fileExtensionProvider.isValid(input.getUri().fileExtension());
				}
			});
			if (!isEmpty(xtendDeltas)) {
				final SubMonitor progress = SubMonitor.convert(monitor, size(xtendDeltas) + 3);
				IFolder targetFolder = compilationFileProvider.getTargetFolder(context.getBuiltProject(), progress.newChild(1));
				wipeTargetFolder(targetFolder, context, progress.newChild(1));
				for (Delta delta : xtendDeltas) {
					processDelta(delta, context, progress.newChild(1));
				}
				folderUtil.removeEmptySubFolders(targetFolder, progress.newChild(1));
				context.needRebuild();
			}
//		} catch (CoreException ce) {
//			throw ce;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
//			throw new CoreException(new Status(IStatus.ERROR, Xtend2Activator.getInstance().getBundle()
//					.getSymbolicName(), "Error during compilation of Xtend2 resources", e));
		}
	}

	protected void processDelta(Delta delta, IBuildContext context, final SubMonitor progress) {
		progress.setWorkRemaining(100);
		URI sourceURI = delta.getUri();
		if (sourceURI.isArchive())
			return;
		IFile sourceFile = null;
		try {
			sourceFile = compilationFileProvider.getFile(sourceURI, context.getBuiltProject());
			if (sourceFile == null)
				return;
			if (sourceFile.exists() && hasErrors(sourceFile))
				return;
			if (!sourceFile.exists() && delta.getNew() != null)
				return;
			IFile targetFile = compilationFileProvider.getTargetFile(sourceURI, context.getBuiltProject(),
					progress.newChild(10));
			if (delta.getNew() != null) {
				Resource sourceResource = null;
				sourceResource = context.getResourceSet().getResource(sourceURI, true);
				if (sourceResource == null)
					throw new IllegalStateException("Cannot load source Xtend2 resource "
							+ notNull(sourceURI));
				EcoreUtil.resolveAll(sourceResource);
				if (!sourceResource.getErrors().isEmpty())
					return;
				if (!sourceResource.getContents().isEmpty()) {
					compile(sourceResource, targetFile, progress.newChild(80));
				}
			} else if (delta.getOld() != null) {
				targetFile.delete(true, progress.newChild(10));
			}
		} catch (Exception e) {
			LOG.error("Error compiling " + notNull(sourceURI), e);
		}
	}

	protected boolean hasErrors(IFile sourceFile) throws CoreException {
		return sourceFile.findMaxProblemSeverity(null, true, IResource.DEPTH_ZERO) == IMarker.SEVERITY_ERROR;
	}

	protected void wipeTargetFolder(IFolder targetFolder, IBuildContext context, final SubMonitor progress)
			throws CoreException {
		switch (context.getBuildType()) {
			case CLEAN:
			case RECOVERY:
				folderUtil.clearFolder(targetFolder, progress);
				break;
			case INCREMENTAL:
			case FULL:
				break;
		}
	}

	protected void compile(Resource sourceResource, IFile targetFile, final SubMonitor progress) throws CoreException,
			UnsupportedEncodingException {
		progress.setWorkRemaining(100);
		StringWriter appendable = new StringWriter();
		compiler.compile((XtendFile)sourceResource.getContents().get(0), appendable);
		progress.worked(50);
		String encoding = encodingProvider.getEncoding(sourceResource.getURI());
		folderUtil.createParentFolders(targetFile, progress.newChild(10));
		String newContentAsString = appendable.toString();
		if (targetFile.exists()) {
			// TODO this is duplicated from EclipseResourceFileSystemAccess which should be used here, too
			boolean contentChanged = false;
			encoding = targetFile.getCharset();
			BufferedInputStream oldContent = null;
			StringInputStream newContent = new StringInputStream(newContentAsString, encoding);
			try {
				oldContent = new BufferedInputStream(targetFile.getContents());
				int newByte = newContent.read();
				int oldByte = oldContent.read();
				while(newByte != -1 && oldByte != -1 && newByte == oldByte) {
					newByte = newContent.read();
					oldByte = oldContent.read();
				}
				contentChanged = newByte != oldByte;
			} catch (CoreException e) {
				contentChanged = true;
			} catch (IOException e) {
				contentChanged = true;
			} finally {
				if (oldContent != null) {
					try {
						oldContent.close();
					} catch (IOException e) {
						// ignore
					}
				}
				// reset to offset zero allows to reuse internal byte[]
				newContent.reset();
			}
			if (contentChanged)
				targetFile.setContents(newContent, true, false, progress.newChild(40));
		}
		else
			targetFile.create(new StringInputStream(newContentAsString, encoding), true, progress.newChild(40));
		targetFile.setDerived(true);
		if(!equal(targetFile.getCharset(), encoding))
			targetFile.setCharset(encoding, progress);
	}

}
