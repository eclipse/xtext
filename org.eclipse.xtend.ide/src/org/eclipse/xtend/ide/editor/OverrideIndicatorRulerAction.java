/*******************************************************************************
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.editor;

import java.util.Iterator;
import java.util.ResourceBundle;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModelExtension2;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.IUpdate;
import org.eclipse.ui.texteditor.ResourceAction;
import org.eclipse.ui.texteditor.SelectMarkerRulerAction;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextMarkerRulerAction;
import org.eclipse.xtext.ui.editor.actions.IActionContributor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class OverrideIndicatorRulerAction extends ResourceAction implements IActionContributor, IUpdate {
	private static final String RESOURCE_KEY_PREFIX = "XtendSelectAnnotationRulerAction.OpenSuperImplementation.";//$NON-NLS-1$
	private static final String BUNDLE_NAME = "org.eclipse.xtend.ide.editor.messages";//$NON-NLS-1$
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	private GlobalURIEditorOpener uriEditorOpener;
	private IJavaElementFinder javaElementFinder;
	private XtextEditor editor;
	private SelectMarkerRulerAction selectMarkerRulerAction;
	private OverrideIndicatorAnnotation overrideIndicatorAnnotation;
	
	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private OverrideHelper overrideHelper;

	@Inject
	public void setUriEditorOpener(GlobalURIEditorOpener uriEditorOpener) {
		this.uriEditorOpener = uriEditorOpener;
	}

	@Inject
	public void setJavaElementFinder(IJavaElementFinder javaElementFinder) {
		this.javaElementFinder = javaElementFinder;
	}

	public OverrideIndicatorRulerAction() {
		super(RESOURCE_BUNDLE, RESOURCE_KEY_PREFIX);
		setId(OverrideIndicatorRulerAction.class.getName());
		setActionDefinitionId(getId());
	}

	@Override
	public void contributeActions(XtextEditor editor) {
		this.editor = editor;
		selectMarkerRulerAction = new XtextMarkerRulerAction(XtextUIMessages.getResourceBundle(),
				"XtextSelectAnnotationRulerAction.", editor, getVerticalRuler()); //$NON-NLS-1$
		editor.setAction(ITextEditorActionConstants.RULER_CLICK, this);
		setEnabled(true);
	}

	@Override
	public void editorDisposed(XtextEditor editor) {
	}

	@Override
	public void update() {
		overrideIndicatorAnnotation = findOverrideIndicatorAnnotation();
		selectMarkerRulerAction.update();
		setEnabled(selectMarkerRulerAction.isEnabled() || overrideIndicatorAnnotation != null);
	}

	private OverrideIndicatorAnnotation findOverrideIndicatorAnnotation() {
		IDocument document = getDocument();
		IVerticalRuler verticalRuler = getVerticalRuler();
		int lineOfLastMouseButtonActivity = verticalRuler.getLineOfLastMouseButtonActivity();
		IAnnotationModelExtension2 annotationModel = (IAnnotationModelExtension2) verticalRuler.getModel();
		if (annotationModel != null) {
			Iterator<?> iterator = ImmutableSet.<Object>of().iterator();
			try {
				IRegion line = document.getLineInformation(lineOfLastMouseButtonActivity);
				iterator = annotationModel.getAnnotationIterator(line.getOffset(), line.getLength() + 1, true, true);
			} catch (BadLocationException e) {
			}
			while (iterator.hasNext()) {
				Annotation annotation = (Annotation) iterator.next();
				if (annotation instanceof OverrideIndicatorAnnotation) {
					return (OverrideIndicatorAnnotation) annotation;
				}
			}
		}
		return null;
	}

	@Override
	public void run() {
		if (overrideIndicatorAnnotation != null) {
			initialize(getResourceBundle(), getResourceKeyPrefix());
			runInternal();
		} else {
			initialize(XtextUIMessages.getResourceBundle(), "XtextSelectAnnotationRulerAction."); //$NON-NLS-1$
			selectMarkerRulerAction.run();
		}
	}

	protected void runInternal() {
		getDocument().priorityReadOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource resource) throws Exception {
				XtendFunction xtendFunction = (XtendFunction) resource.getEObject(overrideIndicatorAnnotation.getFunctionURIFragment());
				JvmOperation operation = associations.getDirectlyInferredOperation(xtendFunction);
				if (operation != null) {
					JvmOperation overridden = overrideHelper.findOverriddenOperation(operation);
					uriEditorOpener.open(EcoreUtil.getURI(overridden), javaElementFinder.findElementFor(overridden), true);
				}
			}
		});
	}

	protected IVerticalRuler getVerticalRuler() {
		IVerticalRuler verticalRuler = (IVerticalRuler) editor.getAdapter(IVerticalRulerInfo.class);
		return verticalRuler;
	}

	protected IXtextDocument getDocument() {
		IXtextDocument xtextDocument = editor.getDocument();
		return xtextDocument;
	}

	protected ResourceBundle getResourceBundle() {
		return RESOURCE_BUNDLE;
	}

	protected String getResourceKeyPrefix() {
		return RESOURCE_KEY_PREFIX;
	}

}
