/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceInformation;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextReadonlyEditorInput;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

/**
 * This enhances the Xtext editor with functionality that allows to reveal the originating offsets 
 * for selected java elements. Thus the XbaseEditor is capable to work with {@link IEditorInput input}
 * that points to {@link JavaCore#isJavaLikeFileName(String) java resources}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseEditor extends XtextEditor {

	private final static Logger log = Logger.getLogger(XbaseEditor.class);
	
	protected static final String TAG_ASSOCIATED_JAVA_RESOURCE= "javaResourcePath"; //$NON-NLS-1$
	
	@Inject
	private ITraceInformation traceInformation;

	@Inject
	private IJvmModelAssociations associations;
	
	@Inject
	private ILocationInFileProvider locationProvider;
	
	@Inject
	private IWorkspace workspace;
	
	@Inject
	private LanguageInfo languageInfo;
	
	@Inject
	private StacktraceBasedEditorDecider calleeAnalyzer;

	private IResource javaResource = null;
	
	private int expectJavaSelection = 0;
	private boolean expectLineSelection = false;
	private boolean isIgnoreCall = false;
	
	@Override
	public void saveState(IMemento memento) {
		super.saveState(memento);
		if (javaResource != null && javaResource.getFullPath() != null) {
			memento.putString(TAG_ASSOCIATED_JAVA_RESOURCE, javaResource.getFullPath().toPortableString());
		}
	}
	
	@Override
	protected void doRestoreState(IMemento memento) {
		super.doRestoreState(memento);
		String pathString = memento.getString(TAG_ASSOCIATED_JAVA_RESOURCE);
		if (pathString != null) {
			IPath path = Path.fromPortableString(pathString);
			IResource foundResource = workspace.getRoot().findMember(path);
			if (foundResource != null && foundResource.exists()) {
				javaResource = foundResource;
			}
		}
	}
	
	@Override
	protected boolean containsSavedState(IMemento memento) {
		boolean result = super.containsSavedState(memento);
		if (!result) {
			return memento.getString(TAG_ASSOCIATED_JAVA_RESOURCE) != null;	
		}
		return result;
	}
	
	@Override
	protected void doSetInput(IEditorInput input) throws CoreException {
		try {
			// TODO set javaResource to null if input is Xbase file that does not match the Java case (needs reversed trace data)
			IFile resource = ResourceUtil.getFile(input);
			ITrace trace = traceInformation.getTraceToSource(resource);
			if (trace == null) {
				super.doSetInput(input);
				return;
			}
			Iterator<ILocationInResource> allLocations = trace.getAllAssociatedLocations().iterator();
			ILocationInResource sourceInformation = null;
			while(allLocations.hasNext() && sourceInformation == null) {
				ILocationInResource candidate = allLocations.next();
				if (languageInfo.equals(candidate.getLanguage())) {
					sourceInformation = candidate;
				}
			}
			if (sourceInformation == null) {
				super.doSetInput(input);
				return;
			}
			IStorage originalStorage = sourceInformation.getStorage();
			if (originalStorage instanceof IFile) {
				super.doSetInput(new FileEditorInput((IFile) originalStorage));
			} else {
				super.doSetInput(new XtextReadonlyEditorInput(originalStorage));
			}
			if (JavaCore.isJavaLikeFileName(resource.getName())) {
				markNextSelectionAsJavaOffset(resource);
			}
			return;
		} catch(CoreException e) { 
			// ignore
		}
		super.doSetInput(input);
	}
	
	private Exception lastCall = null;

	public void markNextSelectionAsJavaOffset(IResource javaResource) {
		if (expectJavaSelection > 0) {
			if (!isIgnoreCall) {
				if (lastCall!= null) {
					log.warn("The editor is already awaiting a select and reveal call from : ", lastCall);
					log.warn("Now called from : ", new Exception());
				}
				this.expectJavaSelection = 0;
			} else {
				this.expectJavaSelection = 0;
			}
		}
		
		lastCall = new Exception();
		this.expectJavaSelection++;
		if (calleeAnalyzer.isEditorUtilityIsOpenInEditor() || calleeAnalyzer.isOpenEditorAction())
			isIgnoreCall = true;
		else
			isIgnoreCall = false;
		if (calleeAnalyzer.isCalledFromFindReferences())
			this.expectJavaSelection++;
		this.javaResource = javaResource;
	}
	
	int reentrantCallFromSelf = 0;
	
	@Override
	protected void safelySanityCheckState(IEditorInput input) {
		try {
			reentrantCallFromSelf++;
			super.safelySanityCheckState(input);
		} finally {
			reentrantCallFromSelf--;
		}
	}
	
	@Override
	public boolean isDirty() {
		try {
			reentrantCallFromSelf++;
			return super.isDirty();
		} finally {
			reentrantCallFromSelf--;
		}
	}
	
	@Override
	public IDocumentProvider getDocumentProvider() {
		if (expectJavaSelection > 0 && reentrantCallFromSelf == 0) {
			if (calleeAnalyzer.isLineBasedOpenEditorAction()) {
				expectLineSelection = true;
				return new DocumentProviderStub() {
					@Override
					public IDocument getDocument(Object element) {
						try {
							String string = Files.readStreamIntoString(((IStorage) javaResource).getContents());
							final Document document = new Document(string);
							return document;
						} catch(CoreException e) {
							return XbaseEditor.super.getDocumentProvider().getDocument(element);
						}
					}
					@Override
					public void connect(Object element) throws CoreException {
						// do nothing
					}
					@Override
					public void disconnect(Object element) {
						// do nothing
					}
				};
			}
		}
		return super.getDocumentProvider();
	}
	
	@Override
	protected void selectAndReveal(final int selectionStart, final int selectionLength, final int revealStart, final int revealLength) {
		try {
			reentrantCallFromSelf++;
			if (expectJavaSelection > 0) {
				try {
					ITrace traceToSource = traceInformation.getTraceToSource((IStorage) javaResource);
					if (traceToSource != null) {
						if (expectLineSelection && javaResource instanceof IStorage) {
							try {
								String string = Files.readStreamIntoString(((IStorage) javaResource).getContents());
								Document javaDocument = new Document(string);
								int line = getLineInJavaDocument(javaDocument, selectionStart, selectionLength);
								if (line != -1) {
									int startOffsetOfContents = getStartOffsetOfContentsInJava(javaDocument, line);
									if (startOffsetOfContents != -1) {
										ILocationInResource bestSelection = traceToSource.getBestAssociatedLocation(new TextRegion(startOffsetOfContents, 0));
										if (bestSelection != null) {
											final ITextRegionWithLineInformation textRegion = bestSelection.getTextRegion();
											if (textRegion != null) {
												int lineToSelect = textRegion.getLineNumber();
												try {
													IRegion lineInfo = getDocument().getLineInformation(lineToSelect);
													super.selectAndReveal(lineInfo.getOffset(), lineInfo.getLength(), lineInfo.getOffset(), lineInfo.getLength());
													return;
												} catch (BadLocationException e) {
													log.error(e);
												}
											}
										}
									}
								}
							} catch(BadLocationException e) {
								// do nothing
							} catch(CoreException e) {
								// do nothing
							}
						} else {
							ILocationInResource bestSelection = traceToSource.getBestAssociatedLocation(new TextRegion(selectionStart, selectionLength));
							if (bestSelection != null) {
								ILocationInResource bestReveal = bestSelection;
								if (selectionStart != revealStart || selectionLength != revealLength) {
									bestReveal = traceToSource.getBestAssociatedLocation(new TextRegion(revealStart, revealLength));
									if (bestReveal == null) {
										bestReveal = bestSelection;
									}
								}
								ITextRegion fixedSelection = bestSelection.getTextRegion();
								if (fixedSelection != null) {
									ITextRegion fixedReveal = bestReveal.getTextRegion();
									if (fixedReveal == null) {
										fixedReveal = fixedSelection;
									}
									super.selectAndReveal(fixedSelection.getOffset(), fixedSelection.getLength(), fixedReveal.getOffset(), fixedReveal.getLength());
									return;
								}
							}
						}
					}
				} finally {
					expectLineSelection = false;
					expectJavaSelection--;
				}
			}
			super.selectAndReveal(selectionStart, selectionLength, revealStart, revealLength);
		} finally {
			reentrantCallFromSelf--;
		}
	}
	
	/**
	 * Returns the line of the given selection. It is assumed that it covers an entire line in the
	 * Java file.
	 * @return the line in the Java file (zero based) or <code>-1</code> if the selection does not cover a complete line.
	 */
	protected int getLineInJavaDocument(Document document, int selectionStart, int selectionLength) throws BadLocationException {
		int line = document.getLineOfOffset(selectionStart);
		int length = document.getLineLength(line);
		int lineOffset = document.getLineOffset(line);
		if (lineOffset == selectionStart && length == selectionLength) {
			return line;
		}
		IRegion region = document.getLineInformation(line);
		if (region.getOffset() == selectionStart || region.getLength() == selectionLength) {
			return line;
		}
		return -1;
	}
	
	protected int getStartOffsetOfContentsInJava(Document document, int line) throws BadLocationException {
		IRegion lineInformation = document.getLineInformation(line);
		String lineText = document.get(lineInformation.getOffset(), lineInformation.getLength());
		String contents = lineText.trim();
		if (contents.length() == 0) {
			log.warn("selection points to an empty line!", new IllegalStateException());
			return -1;
		}
		int contentsStarts = lineText.indexOf(contents);
		return lineInformation.getOffset() + contentsStarts;
	}

	@Override
	public void reveal(int offset, int length) {
		/* 
		 * This is only overwritten for documentation purpose.
		 * It is not necessary to fix the offset and length for #reveal since this API is 
		 * private to Xtext and never used from JDT thus the given offset and length are
		 * always relative the our own objects and not relative the the derived java files.
		 */
		super.reveal(offset, length);
	}

}
