/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor;

import java.util.ResourceBundle;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.TextEditorAction;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.common.types.ui.trace.ITraceForTypeRootProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.ui.editor.actions.IClipboardActionFactory;

import com.google.inject.Inject;

/**
 * This enhances the Xtext editor with functionality that allows to reveal the originating offsets for selected java
 * elements. Thus the XbaseEditor is capable to work with {@link IEditorInput input} that points to
 * {@link JavaCore#isJavaLikeFileName(String) java resources}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseEditor extends XtextEditor {

	private final static Logger log = Logger.getLogger(XbaseEditor.class);

	protected static final String HANDLER_IDENTIFIER = "HANDLER_IDENTIFIER"; //$NON-NLS-1$

	@Inject
	private ITraceForTypeRootProvider traceInformation;

	@Inject
	private StacktraceBasedEditorDecider calleeAnalyzer;

	@Inject
	private EclipseOutputConfigurationProvider outputConfigurationProvider;

	@Inject
	private XbaseEditorInputRedirector editorInputRedirector;
	/**
	 * {@link IClipboardActionFactory} may be optional. If so, the default CCP {@link TextEditorAction}'s added in
	 * {@link org.eclipse.ui.texteditor.AbstractTextEditor} will be used.
	 * 
	 * @see #createClipboardActions()
	 * @see org.eclipse.xtext.xbase.ui.editor.actions.ImportsAwareClipboardAction.Factory
	 */
	@Inject(optional = true)
	private IClipboardActionFactory clipboardActionFactory;
	private ITypeRoot typeRoot = null;

	private int expectJavaSelection = 0;
	private boolean expectLineSelection = false;
	private boolean isIgnoreCall = false;
	private @Inject FoldingPreferences foldingPreferences;

	@Override
	public void saveState(IMemento memento) {
		super.saveState(memento);
		if (typeRoot != null) {
			memento.putString(HANDLER_IDENTIFIER, typeRoot.getHandleIdentifier());
		}
	}

	@Override
	protected void doRestoreState(IMemento memento) {
		super.doRestoreState(memento);
		String handleIdentifier = memento.getString(HANDLER_IDENTIFIER);
		if (handleIdentifier != null) {
			IJavaElement handle = JavaCore.create(handleIdentifier);
			if (handle instanceof ITypeRoot && handle.exists()) {
				typeRoot = (ITypeRoot) handle;
			}
		}
	}

	@Override
	protected boolean containsSavedState(IMemento memento) {
		boolean result = super.containsSavedState(memento);
		if (!result) {
			return memento.getString(HANDLER_IDENTIFIER) != null;
		}
		return result;
	}

	@Override
	protected void doSetInput(IEditorInput input) throws CoreException {
		try {
			// TODO set javaResource to null if input is Xbase file that does not match the Java case (needs reversed trace data)
			IEditorInput inputToUse = editorInputRedirector.findOriginalSource(input);
			super.doSetInput(inputToUse);
			ITypeRoot typeRoot = editorInputRedirector.getTypeRoot(input);
			if (typeRoot != null) {
				markNextSelectionAsJavaOffset(typeRoot);
			}
			return;
		} catch (CoreException e) {
			// ignore
		}
		super.doSetInput(input);
	}

	private Exception lastCall = null;

	public void markNextSelectionAsJavaOffset(ITypeRoot typeRoot) {
		if (expectJavaSelection > 0) {
			if (!isIgnoreCall) {
				if (lastCall != null) {
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
		this.typeRoot = typeRoot;
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
				if (isCompiledWithJSR45()) {
					return new DocumentProviderStub() {
						@Override
						public IDocument getDocument(Object element) {
							if (typeRoot == null) {
								return XbaseEditor.super.getDocumentProvider().getDocument(element);
							}
							IResource javaResource = typeRoot.getResource();
							if (!(javaResource instanceof IStorage)) {
								return XbaseEditor.super.getDocumentProvider().getDocument(element);
							}
							try {
								String string = Files.readStreamIntoString(((IStorage) javaResource).getContents());
								final Document document = new Document(string);
								return document;
							} catch (CoreException e) {
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
		}
		return super.getDocumentProvider();
	}

	@Override
	protected void selectAndReveal(final int selectionStart, final int selectionLength, final int revealStart,
			final int revealLength) {
		try {
			reentrantCallFromSelf++;
			if (expectJavaSelection > 0) {
				try {
					ITrace traceToSource = getTraceStorage();
					if (traceToSource != null) {
						IResource javaResource = typeRoot.getResource();
						if (expectLineSelection && javaResource instanceof IStorage) {
							if (isCompiledWithJSR45()) {
								try {
									String string = Files.readStreamIntoString(((IStorage) javaResource).getContents());
									Document javaDocument = new Document(string);
									int line = getLineInJavaDocument(javaDocument, selectionStart, selectionLength);
									if (line != -1) {
										int startOffsetOfContents = getStartOffsetOfContentsInJava(javaDocument, line);
										if (startOffsetOfContents != -1) {
											ILocationInResource bestSelection = traceToSource
													.getBestAssociatedLocation(new TextRegion(startOffsetOfContents, 0));
											if (bestSelection != null) {
												final ITextRegionWithLineInformation textRegion = bestSelection
														.getTextRegion();
												if (textRegion != null) {
													int lineToSelect = textRegion.getLineNumber();
													try {
														IRegion lineInfo = getDocument().getLineInformation(
																lineToSelect);
														super.selectAndReveal(lineInfo.getOffset(),
																lineInfo.getLength(), lineInfo.getOffset(),
																lineInfo.getLength());
														return;
													} catch (BadLocationException e) {
														log.error(e.getMessage(), e);
													}
												}
											}
										}
									}
								} catch (BadLocationException e) {
									// do nothing
								} catch (CoreException e) {
									// do nothing
								}
							}
						} else if (selectionStart >= 0 && selectionLength >= 0) {
							ILocationInResource bestSelection = traceToSource.getBestAssociatedLocation(new TextRegion(
									selectionStart, selectionLength));
							if (bestSelection != null) {
								ILocationInResource bestReveal = bestSelection;
								if (selectionStart != revealStart || selectionLength != revealLength) {
									bestReveal = traceToSource.getBestAssociatedLocation(new TextRegion(revealStart,
											revealLength));
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
									super.selectAndReveal(fixedSelection.getOffset(), fixedSelection.getLength(),
											fixedReveal.getOffset(), fixedReveal.getLength());
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

	protected ITrace getTraceStorage() {
		if (typeRoot == null) {
			return null;
		}
		return traceInformation.getTraceToSource(typeRoot);
	}

	protected ILocationInResource getLocationInResource(ITrace traceToSource) {
		if (traceToSource == null) {
			return null;
		}
		for (ILocationInResource locationInResource : traceToSource.getAllAssociatedLocations()) {
			return locationInResource;
		}
		return null;
	}

	protected boolean isCompiledWithJSR45() {
		//TODO the information whether this was compiled with JSR-45, needs to be done on a per resource base, since a project might 
		// have a different configuration than its jars. Storing it in the trace file (together with other compilation options and version information) seems appropriate.
		// is this editor is not based on a resource it doesn't live in a project. We don't know whether it was compiled with JSR-45.
		if (getResource() == null)
			return true;
		Set<OutputConfiguration> configurations = outputConfigurationProvider.getOutputConfigurations(getResource()
				.getProject());
		for (OutputConfiguration config : configurations) {
			if (config.isInstallDslAsPrimarySource()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns the line of the given selection. It is assumed that it covers an entire line in the Java file.
	 * 
	 * @return the line in the Java file (zero based) or <code>-1</code> if the selection does not cover a complete
	 *         line.
	 */
	protected int getLineInJavaDocument(Document document, int selectionStart, int selectionLength)
			throws BadLocationException {
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

	@Override
	protected void createActions() {
		super.createActions();
		createClipboardActions();
	}

	/**
	 * replace default cut/copy/paste actions with a version that provided by the factory, if one is injected
	 */
	protected void createClipboardActions() {
		IClipboardActionFactory actionsFactory = getClipboardActionFactory();
		if (actionsFactory != null) {
			ResourceBundle bundle = XbaseEditorMessages.getBundleForConstructedKeys();
			TextEditorAction action = actionsFactory.create(bundle, "Editor.Cut.", this, ITextOperationTarget.CUT); //$NON-NLS-1$
			setAction(ITextEditorActionConstants.CUT, action);
			action = actionsFactory.create(bundle, "Editor.Copy.", this, ITextOperationTarget.COPY); //$NON-NLS-1$
			setAction(ITextEditorActionConstants.COPY, action);
			action = actionsFactory.create(bundle, "Editor.Paste.", this, ITextOperationTarget.PASTE); //$NON-NLS-1$
			setAction(ITextEditorActionConstants.PASTE, action);
		}
	}

	protected IClipboardActionFactory getClipboardActionFactory() {
		return clipboardActionFactory;
	}

	@Override
	protected void installFoldingSupport(ProjectionViewer projectionViewer) {
		if (foldingPreferences.isEnabled()) {
			super.installFoldingSupport(projectionViewer);
		}
	}

	@Override
	protected void handlePreferenceStoreChanged(PropertyChangeEvent event) {
		super.handlePreferenceStoreChanged(event);
		String property = event.getProperty();
		if (property.equals(org.eclipse.jdt.ui.PreferenceConstants.EDITOR_FOLDING_ENABLED)) {
			ProjectionViewer projectionViewer = (ProjectionViewer) getSourceViewer();
			if (event.getNewValue() != null && Boolean.valueOf(event.getNewValue().toString())) {
				if (!projectionViewer.isProjectionMode()) {
					installFoldingSupport(projectionViewer);
				}
			} else {
				if (projectionViewer.isProjectionMode()) {
					uninstallFoldingSupport();
					projectionViewer.disableProjection();
				}
			}
		}
	}
}
