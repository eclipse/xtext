/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.internal.ui.javaeditor.IClassFileEditorInput;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.builder.smap.XbaseBreakpointUtil;
import org.eclipse.xtext.common.types.ui.trace.ITraceForTypeRootProvider;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.ui.editor.model.JarFileMarkerAnnotationModel;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.generator.trace.IEclipseTrace;
import org.eclipse.xtext.ui.generator.trace.ILocationInEclipseResource;
import org.eclipse.xtext.ui.generator.trace.WrappedCoreException;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XbaseDocumentProvider extends XtextDocumentProvider {

	protected class ClassFileInfo extends ElementInfo {
		public ClassFileInfo(IDocument document, IAnnotationModel model) {
			super(document, model);
		}
	}

	@Inject
	private ITraceForTypeRootProvider traceForTypeRootProvider;

	@Inject
	private XbaseBreakpointUtil breakpointUtil;
	
	@Inject
	private AbstractUIPlugin plugin;

	protected ILocationInEclipseResource getClassFileSourceStorage(IClassFile classFile) {
		IEclipseTrace traceToSource = traceForTypeRootProvider.getTraceToSource(classFile);
		if (traceToSource != null) {
			for (ILocationInEclipseResource loc : traceToSource.getAllAssociatedLocations())
				return loc;
		}
		return null;
	}

	@Override
	protected boolean setDocumentContent(IDocument document, IEditorInput input, String encoding) throws CoreException {
		if (input instanceof IClassFileEditorInput && document instanceof XtextDocument) {
			IClassFile classFile = ((IClassFileEditorInput) input).getClassFile();
			ILocationInEclipseResource source = getClassFileSourceStorage(classFile);
			if (source == null) {
				return false;
			}
			InputStream contents = null;
			try {
				contents = source.getContents();
				if (contents != null)
					setDocumentContent(document, contents, encoding);
			} catch(WrappedCoreException e) {
				throw e.getCause();
			} catch(IOException e) {
				throw new CoreException(new Status(IStatus.ERROR, plugin.getBundle().getSymbolicName(), e.getMessage(), e));
			} finally {
				try {
					if (contents != null)
						contents.close();
				} catch (IOException e1) {
				}
			}
			setDocumentResource((XtextDocument) document, input, encoding);
			return true;
		}
		return super.setDocumentContent(document, input, encoding);
	}

	@Override
	protected ElementInfo createElementInfo(Object element) throws CoreException {
		if (element instanceof IClassFileEditorInput) {
			IDocument document = null;
			IStatus status = null;
			try {
				document = createDocument(element);
			} catch (CoreException x) {
				status = x.getStatus();
				document = createEmptyDocument();
			}
			ClassFileInfo info = new ClassFileInfo(document, createAnnotationModel(element));
			info.fStatus = status;
			registerAnnotationInfoProcessor(info);
			return info;
		}
		return super.createElementInfo(element);
	}

	@Override
	protected IAnnotationModel createAnnotationModel(Object element) throws CoreException {
		if (element instanceof IEditorInput) {
			IEditorInput editorInput = (IEditorInput) element;
			SourceRelativeURI breakpointURI = breakpointUtil.getBreakpointURI(editorInput);
			if (breakpointURI != null) { // we only get a URI here if the EditorInput points into a JAR
				IResource breakpointResource = breakpointUtil.getBreakpointResource(editorInput);
				return new JarFileMarkerAnnotationModel(breakpointResource, breakpointURI);
			}
		}
		return super.createAnnotationModel(element);
	}
}
