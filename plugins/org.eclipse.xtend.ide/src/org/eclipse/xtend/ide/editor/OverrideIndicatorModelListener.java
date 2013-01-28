/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.editor;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.nodemodel.util.NodeModelUtils.findNodesForFeature;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.xtend.core.typing.XtendOverridesService;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback.NullImpl;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class OverrideIndicatorModelListener extends NullImpl implements IXtextModelListener {
	private XtextEditor xtextEditor;
	private Set<Annotation> overrideIndicatorAnnotations = Sets.newHashSet();
	private XtendOverridesService xtendOverridesService;

	@Inject
	public void setXtendOverridesService(XtendOverridesService xtendOverridesService) {
		this.xtendOverridesService = xtendOverridesService;
	}

	@Override
	public void afterCreatePartControl(XtextEditor xtextEditor) {
		this.xtextEditor = xtextEditor;
		installModelListener(xtextEditor);
	}

	
	@Override
	public void afterSetInput(XtextEditor xtextEditor) {
		installModelListener(xtextEditor);
	}

	@Override
	public void beforeDispose(XtextEditor xtextEditor) {
		if (this.xtextEditor != null) {
			this.xtextEditor = null;
		}
	}

	public void modelChanged(XtextResource resource) {
		asyncUpdateAnnotationModel();
	}

	private void asyncUpdateAnnotationModel() {
		Runnable runnable = new Runnable() {
			public void run() {
				updateAnnotationModel();
			}
		};
		Display display = getDisplay();
		if (display == null) {
			return;
		}
		display.asyncExec(runnable);
	}

	private void updateAnnotationModel() {
		if (xtextEditor == null || xtextEditor.getDocument() == null
				|| xtextEditor.getInternalSourceViewer().getAnnotationModel() == null) {
			return;
		}
		IXtextDocument xtextDocument = xtextEditor.getDocument();
		IAnnotationModel annotationModel = xtextEditor.getInternalSourceViewer().getAnnotationModel();
		Map<Annotation, Position> annotationToPosition = xtextDocument
				.readOnly(new IUnitOfWork<Map<Annotation, Position>, XtextResource>() {

					public Map<Annotation, Position> exec(XtextResource xtextResource) {
						if (xtextResource == null)
							return Collections.emptyMap();
						return createOverrideIndicatorAnnotationMap(xtextResource);
					}

				});
		if (annotationModel instanceof IAnnotationModelExtension) {
			IAnnotationModelExtension annotationModelExtension = (IAnnotationModelExtension) annotationModel;
			Object lockObject = getLockObject(annotationModel);
			synchronized (lockObject) {
				annotationModelExtension.replaceAnnotations(overrideIndicatorAnnotations.toArray(new Annotation[] {}),
						annotationToPosition);
			}
			overrideIndicatorAnnotations = annotationToPosition.keySet();
		}
	}

	private Object getLockObject(IAnnotationModel annotationModel) {
		if (annotationModel instanceof ISynchronizable) {
			Object lock = ((ISynchronizable) annotationModel).getLockObject();
			if (lock != null)
				return lock;
		}
		return annotationModel;
	}

	private Display getDisplay() {
		if (xtextEditor == null) {
			return null;
		}
		IWorkbenchPartSite site = xtextEditor.getSite();
		if (site == null) {
			return null;
		}
		Shell shell = site.getShell();
		if (shell == null || shell.isDisposed()) {
			return null;
		}
		Display display = shell.getDisplay();
		if (display == null || display.isDisposed()) {
			return null;
		}
		return display;
	}

	protected Map<Annotation, Position> createOverrideIndicatorAnnotationMap(XtextResource xtextResource) {
		EObject eObject = xtextResource.getEObject("/"); //$NON-NLS-1$
		if (!(eObject instanceof XtendFile)) {
			return Maps.newHashMap();
		}
		XtendFile xtendFile = (XtendFile) eObject;
		Map<Annotation, Position> annotationToPosition = Maps.newHashMap();
		for (XtendFunction xtendFunction : getXtendFunctions(xtendFile)) {
			if (xtendFunction.isOverride()) {
				INode node = NodeModelUtils.getNode(xtendFunction);
				JvmOperation jvmOperation = xtendOverridesService.findOverriddenOperation(xtendFunction);
				if (node != null && jvmOperation != null) {
					boolean overwriteIndicator = isOverwriteIndicator(jvmOperation);
					String text = (overwriteIndicator ? "overrides " : "implements ") + jvmOperation.getQualifiedName(); //$NON-NLS-1$ //$NON-NLS-2$
					node = getFirst(findNodesForFeature(xtendFunction, XtendPackage.eINSTANCE.getXtendFunction_Name()),
							node);
					annotationToPosition.put(
							new OverrideIndicatorAnnotation(overwriteIndicator, text, xtextResource
									.getURIFragment(xtendFunction)), new Position(node.getOffset()));
				}
			}
		}
		return annotationToPosition;
	}

	private Iterable<XtendFunction> getXtendFunctions(XtendFile xtendFile) {
		return concat(transform(xtendFile.getXtendTypes(), new Function<XtendTypeDeclaration, Iterable<XtendFunction>>(){
			public java.lang.Iterable<XtendFunction> apply(XtendTypeDeclaration input) {
				return filter(input.getMembers(), XtendFunction.class);
			}
		}));
	}

	protected boolean isOverwriteIndicator(JvmOperation jvmOperation) {
		JvmDeclaredType jvmDeclaredType = jvmOperation.getDeclaringType();
		if (jvmDeclaredType instanceof JvmGenericType) {
			JvmGenericType jvmGenericType = (JvmGenericType) jvmDeclaredType;
			if (jvmGenericType.isInterface()) {
				return false;
			}
		}
		return true;
	}
	
	private void installModelListener(XtextEditor xtextEditor) {
		if (xtextEditor.getDocument() != null) {
			asyncUpdateAnnotationModel();
			xtextEditor.getDocument().addModelListener(this);
		}
	}

}
