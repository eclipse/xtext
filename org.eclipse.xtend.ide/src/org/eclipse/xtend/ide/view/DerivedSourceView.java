/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.view;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.jface.resource.JFaceResources.*;
import static org.eclipse.ui.editors.text.EditorsUI.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import org.eclipse.core.internal.utils.WrappedRuntimeException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.javaeditor.JavaSourceViewer;
import org.eclipse.jdt.internal.ui.text.SimpleJavaSourceViewerConfiguration;
import org.eclipse.jdt.ui.text.IJavaPartitions;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.AnnotationRulerColumn;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.DefaultAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.LineNumberRulerColumn;
import org.eclipse.jface.text.source.OverviewRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.internal.editors.text.EditorsPlugin;
import org.eclipse.ui.part.IShowInTarget;
import org.eclipse.ui.part.ShowInContext;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;
import org.eclipse.ui.texteditor.MarkerAnnotationPreferences;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.xtend.ide.labeling.XtendImages;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.ui.editor.SchedulingRuleFactory;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.generator.trace.IEclipseTrace;
import org.eclipse.xtext.ui.generator.trace.ILocationInEclipseResource;
import org.eclipse.xtext.ui.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.ui.views.AbstractSourceView;
import org.eclipse.xtext.ui.views.DefaultWorkbenchPartSelection;
import org.eclipse.xtext.ui.views.IWorkbenchPartSelection;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.TextRegion;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 * @author Karsten Thoms - Bug 434688, 505760
 */
@SuppressWarnings("restriction")
public class DerivedSourceView extends AbstractSourceView implements IResourceChangeListener, IShowInTarget {
	protected static final int VERTICAL_RULER_WIDTH = 12;
	protected static final int OVERVIEW_RULER_WIDTH = 12;
	private static final String SEARCH_ANNOTATION_TYPE = "org.eclipse.search.results"; //$NON-NLS-1$
	private static final ISchedulingRule SEQUENCE_RULE = SchedulingRuleFactory.INSTANCE.newSequence();
	@Inject
	private ITraceForStorageProvider traceInformation;
	@Inject
	private XtendImages xtendImages;
	@Inject
	private IPreferenceStoreAccess preferenceStoreAccess;
	@Inject
	private IWorkspace workspace;

	private DefaultMarkerAnnotationAccess defaultMarkerAnnotationAccess = new DefaultMarkerAnnotationAccess();
	private SourceViewerDecorationSupport sourceViewerDecorationSupport;
	private JavaSourceViewer javaSourceViewer;
	private SimpleJavaSourceViewerConfiguration javaSourceViewerConfiguration;
	private IStorage selectedSource;
	private Set<IStorage> derivedSources = Sets.newHashSet();
	private RefreshJob refreshJob = new RefreshJob(SEQUENCE_RULE);
	private MarkerAnnotationPreferences markerAnnotationPreferences = EditorsPlugin.getDefault()
			.getMarkerAnnotationPreferences();
	private OpenEditorAction openEditorAction;
	private LineNumberRulerColumn lineNumberRulerColumn;

	IStorage getSelectedSource() {
		return selectedSource;
	}

	Set<IStorage> getDerivedSources() {
		return derivedSources;
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		createActions();
	}

	private void createActions() {
		IActionBars actionBars = getViewSite().getActionBars();
		IToolBarManager toolBarManager = actionBars.getToolBarManager();
		openEditorAction = new OpenEditorAction(this);
		openEditorAction.setEnabled(false);
		toolBarManager.add(openEditorAction);
		toolBarManager.add(new DerivedSourceDropDownAction(this));
	}

	@Override
	protected SourceViewer createSourceViewer(Composite parent) {
		IPreferenceStore store = JavaPlugin.getDefault().getCombinedPreferenceStore();
		IOverviewRuler overviewRuler = new OverviewRuler(defaultMarkerAnnotationAccess, OVERVIEW_RULER_WIDTH,
				getSharedTextColors());
		AnnotationRulerColumn annotationRulerColumn = new AnnotationRulerColumn(VERTICAL_RULER_WIDTH,
				defaultMarkerAnnotationAccess);
		List<AnnotationPreference> annotationPreferences = markerAnnotationPreferences.getAnnotationPreferences();
		for (AnnotationPreference annotationPreference : annotationPreferences) {
			String key = annotationPreference.getVerticalRulerPreferenceKey();
			boolean showAnnotation = true;
			if (key != null && store.contains(key)) {
				showAnnotation = store.getBoolean(key);
			}
			if (showAnnotation) {
				annotationRulerColumn.addAnnotationType(annotationPreference.getAnnotationType());
			}
		}
		annotationRulerColumn.addAnnotationType(Annotation.TYPE_UNKNOWN);
		lineNumberRulerColumn = new LineNumberRulerColumn();
		CompositeRuler compositeRuler = new CompositeRuler();
		compositeRuler.addDecorator(0, annotationRulerColumn);
		compositeRuler.addDecorator(1, lineNumberRulerColumn);
		javaSourceViewer = new JavaSourceViewer(parent, compositeRuler, overviewRuler, true, SWT.V_SCROLL
				| SWT.H_SCROLL, store);
		javaSourceViewerConfiguration = new SimpleJavaSourceViewerConfiguration(JavaPlugin.getDefault()
				.getJavaTextTools().getColorManager(), store, null, IJavaPartitions.JAVA_PARTITIONING, true) {
			@Override
			public IInformationControlCreator getInformationControlCreator(ISourceViewer sourceViewer) {
				return new IInformationControlCreator() {
					@Override
					public IInformationControl createInformationControl(final Shell parent) {
						return new DefaultInformationControl(parent, true);
					}
				};
			}
			@Override
			public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
				return new DefaultAnnotationHover();
			}
		};
		javaSourceViewer.configure(javaSourceViewerConfiguration);
		javaSourceViewer.setEditable(false);
		javaSourceViewer.showAnnotations(true);
		sourceViewerDecorationSupport = new SourceViewerDecorationSupport(javaSourceViewer, overviewRuler,
				defaultMarkerAnnotationAccess, getSharedTextColors());
		for (AnnotationPreference annotationPreference : annotationPreferences) {
			sourceViewerDecorationSupport.setAnnotationPreference(annotationPreference);
		}
		sourceViewerDecorationSupport.install(preferenceStoreAccess.getPreferenceStore());
		return javaSourceViewer;
	}

	@Override
	protected void inititalizeColors() {
		IPreferenceStore store = preferenceStoreAccess.getPreferenceStore();
		getColorRegistry().addListener(this);
		StyledText textWidget = getSourceViewer().getTextWidget();
		textWidget.setForeground(
				getColorFromStore(store, 
						AbstractTextEditor.PREFERENCE_COLOR_FOREGROUND_SYSTEM_DEFAULT, 
						SWT.COLOR_WIDGET_FOREGROUND, 
						AbstractTextEditor.PREFERENCE_COLOR_FOREGROUND));
		textWidget.setBackground(
				getColorFromStore(store, 
						AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND_SYSTEM_DEFAULT, 
						SWT.COLOR_INFO_BACKGROUND, 
						AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND));

		lineNumberRulerColumn.setForeground(
				getColorFromStore(store, 
						AbstractDecoratedTextEditorPreferenceConstants.EDITOR_LINE_NUMBER_RULER_COLOR,
						SWT.COLOR_WIDGET_FOREGROUND,
						AbstractDecoratedTextEditorPreferenceConstants.EDITOR_LINE_NUMBER_RULER_COLOR));
		lineNumberRulerColumn.setBackground(
				getColorFromStore(store, 
						AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND_SYSTEM_DEFAULT, 
						SWT.COLOR_WIDGET_BACKGROUND, 
						AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND));
		lineNumberRulerColumn.setFont(getFont(getViewerFontName()));
	}
	
	private Color getColorFromStore(IPreferenceStore store, String isDefaultKey, int systemDefault, String key) {
		String isDefault = store.getString(isDefaultKey);
		if(Strings.isEmpty(isDefault) || Strings.equal("true", isDefault)) {
			return getDisplay().getSystemColor(systemDefault);
		} else {
			RGB rgb = PreferenceConverter.getColor(store, key);
			return EditorsPlugin.getDefault().getSharedTextColors().getColor(rgb);
		}
	}
	
	@Override
	protected boolean isValidSelection(IWorkbenchPartSelection workbenchPartSelection) {
		return super.isValidSelection(workbenchPartSelection)
				&& traceInformation.getTraceToTarget(getEditorResource(workbenchPartSelection)) != null;
	}

	@Override
	protected String getBackgroundColorKey() {
		return getLanguageName() + ".ui.DerivedSourceView.backgroundColor"; //$NON-NLS-1$
	}

	@Override
	protected String getViewerFontName() {
		return "org.eclipse.xtend.ui.editors.textfont"; //$NON-NLS-1$
	}
	
	@Override
	protected String computeInput(IWorkbenchPartSelection workbenchPartSelection) {
		openEditorAction.setInputFile(null);
		openEditorAction.setSelectedRegion(null);
		IEclipseTrace trace = traceInformation.getTraceToTarget(getEditorResource(workbenchPartSelection));
		if (trace != null) {
			if (workbenchPartSelection instanceof DerivedSourceSelection) {
				DerivedSourceSelection derivedSourceSelection = (DerivedSourceSelection) workbenchPartSelection;
				selectedSource = derivedSourceSelection.getStorage();
			} else {
				derivedSources = Sets.newHashSet();
				TextRegion localRegion = mapTextRegion(workbenchPartSelection);
				Iterable<IStorage> transform = Iterables.filter(transform(trace.getAllAssociatedLocations(localRegion),
						new Function<ILocationInEclipseResource, IStorage>() {
							@Override
							public IStorage apply(ILocationInEclipseResource input) {
								return input.getPlatformResource();
							}
						}), Predicates.notNull());
				addAll(derivedSources, transform);
				ILocationInEclipseResource bestAssociatedLocation = trace.getBestAssociatedLocation(localRegion);
				if (bestAssociatedLocation != null) {
					selectedSource = bestAssociatedLocation.getPlatformResource();
				} else if (!derivedSources.isEmpty()) {
					selectedSource = derivedSources.iterator().next();
				}
			}
		}
		IFile file = getSelectedFile();
		if (file != null) {
			try {
				file.refreshLocal(1, new NullProgressMonitor());
				if (file.exists()) {
					openEditorAction.setInputFile(file);
					try (InputStream contents = file.getContents()) {
						return Files.readStreamIntoString(contents);
					}
				}
			} catch (CoreException | IOException e) {
				throw new WrappedRuntimeException(e);
			}
		}
		return null;
	}

	protected XtendImages getXtendImages() {
		return xtendImages;
	}
	
	protected IFile getSelectedFile() {
		return selectedSource != null ? workspace.getRoot().getFile(selectedSource.getFullPath()) : null;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
		if (javaSourceViewerConfiguration.affectsTextPresentation(event)) {
			javaSourceViewerConfiguration.handlePropertyChangeEvent(event);
			javaSourceViewer.invalidateTextPresentation();
		}
	}

	@Override
	public void partVisible(IWorkbenchPartReference ref) {
		super.partVisible(ref);
		if (ref.getId().equals(getSite().getId())) {
			workspace.addResourceChangeListener(this);
		}
	}

	@Override
	public void partHidden(IWorkbenchPartReference workbenchPartReference) {
		super.partHidden(workbenchPartReference);
		if (workbenchPartReference.getId().equals(getSite().getId())) {
			workspace.removeResourceChangeListener(this);
		}
		if (getWorkbenchPartSelection() != null && workbenchPartReference.getPart(false) == getWorkbenchPartSelection().getWorkbenchPart()) {
			selectedSource = null;
			openEditorAction.setInputFile(null);
			openEditorAction.setSelectedRegion(null);
			setWorkbenchPartSelection(null);
			setContentDescription("");
			setInput("");
		}
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		if (selectedSource == null || getWorkbenchPartSelection() == null) {
			return;
		}
		IResourceDelta delta = event.getDelta();
		if (delta != null) {
			IResourceDelta child = delta.findMember(selectedSource.getFullPath());
			if (child != null) {
				refreshJob.reschedule();
			}
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		if (sourceViewerDecorationSupport != null) {
			sourceViewerDecorationSupport.dispose();
		}
		workspace.removeResourceChangeListener(this);
	}

	@Override
	protected String computeDescription(IWorkbenchPartSelection workbenchPartSelection) {
		if (selectedSource == null) {
			return super.computeDescription(workbenchPartSelection);
		}
		XtextEditor xtextEditor = (XtextEditor) workbenchPartSelection.getWorkbenchPart();
		if (xtextEditor.isDirty()) {
			return Messages.DerivedSourceView_EditorDirty;
		} else {
			return selectedSource.getFullPath().toString();
		}
	}

	@Override
	protected IDocument createDocument(String input) {
		IDocument document = super.createDocument(input);
		JavaPlugin.getDefault().getJavaTextTools()
				.setupJavaDocumentPartitioner(document, IJavaPartitions.JAVA_PARTITIONING);
		return document;
	}

	@Override
	protected AnnotationModel createAnnotationModel() {
		IFile file = getSelectedFile();
		return file != null ? new ResourceMarkerAnnotationModel(file) : super.createAnnotationModel();
	}

	@Override
	protected void selectAndReveal(IWorkbenchPartSelection workbenchPartSelection) {
		if (selectedSource != null) {
			IAnnotationModel annotationModel = getSourceViewer().getAnnotationModel();
			TextRegion localRegion = mapTextRegion(workbenchPartSelection);
			IEclipseTrace trace = traceInformation.getTraceToTarget(getEditorResource(workbenchPartSelection));
			if (trace != null) {
				Iterable<? extends ILocationInEclipseResource> allAssociatedLocations = trace.getAllAssociatedLocations(localRegion,
						selectedSource);
				ILocationInResource firstLocationInResource = Iterables.getFirst(allAssociatedLocations, null);
				if (firstLocationInResource != null) {
					ITextRegion textRegion = firstLocationInResource.getTextRegion();
					if (textRegion != null) {
						openEditorAction.setSelectedRegion(textRegion);
						getSourceViewer().revealRange(textRegion.getOffset(), textRegion.getLength());
					}
				}
				for (ILocationInResource locationInResource : allAssociatedLocations) {
					ITextRegion textRegion = locationInResource.getTextRegion();
					if (textRegion != null) {
						annotationModel.addAnnotation(new Annotation(SEARCH_ANNOTATION_TYPE, true, null), new Position(
								textRegion.getOffset(), textRegion.getLength()));
					}
				}
			}
		}
	}

	private TextRegion mapTextRegion(IWorkbenchPartSelection workbenchPartSelection) {
		ITextSelection textSelection = (ITextSelection) workbenchPartSelection.getSelection();
		TextRegion localRegion = new TextRegion(textSelection.getOffset(), textSelection.getLength());
		return localRegion;
	}

	protected class RefreshJob extends UIJob {

		public RefreshJob(ISchedulingRule schedulingRule) {
			super(Messages.DerivedSourceView_RefreshJobTitle);
			setRule(schedulingRule);
		}

		@Override
		public IStatus runInUIThread(final IProgressMonitor monitor) {
			computeAndSetInput(new DefaultWorkbenchPartSelection(getSite().getPage().getActivePart(), getSite()
					.getPage().getSelection()), true);
			if (monitor.isCanceled())
				return Status.CANCEL_STATUS;
			return Status.OK_STATUS;
		}

		protected void reschedule() {
			cancel();
			schedule();
		}
	}

	@Override
	public boolean show(ShowInContext context) {
		selectionChanged(getSite().getPage().getActiveEditor(), context.getSelection());
		return true;
	}

}
