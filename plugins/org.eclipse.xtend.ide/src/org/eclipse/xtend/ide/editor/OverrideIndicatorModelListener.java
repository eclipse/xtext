/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.editor;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.nodemodel.util.NodeModelUtils.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback.NullImpl;
import org.eclipse.xtext.ui.editor.SchedulingRuleFactory;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class OverrideIndicatorModelListener extends NullImpl implements IXtextModelListener {
	
	public static final String JOB_NAME = "Override Indicator Updater";
	private static ISchedulingRule SCHEDULING_RULE = SchedulingRuleFactory.INSTANCE.newSequence();

	private XtextEditor xtextEditor;
	private Set<Annotation> overrideIndicatorAnnotations = Sets.newHashSet();

	private Job currentJob;

	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private OverrideHelper overrideHelper;
	
	@Inject
	private IBatchTypeResolver typeResolver;
	
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
		if (currentJob != null) {
			currentJob.cancel();
		}

		currentJob = new Job(JOB_NAME) {
			@Override
			public IStatus run(IProgressMonitor monitor) {
				return updateAnnotationModel(monitor);
			}
		};
		currentJob.setRule(SCHEDULING_RULE);
		currentJob.setPriority(Job.DECORATE);
		currentJob.setSystem(true);
		currentJob.schedule();
	}

	private IStatus updateAnnotationModel(IProgressMonitor monitor) {
		if (xtextEditor == null || xtextEditor.getDocument() == null
				|| xtextEditor.getInternalSourceViewer().getAnnotationModel() == null) {
			return Status.OK_STATUS;
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

		if (monitor.isCanceled())
			return Status.CANCEL_STATUS;
		if (annotationModel instanceof IAnnotationModelExtension) {
			IAnnotationModelExtension annotationModelExtension = (IAnnotationModelExtension) annotationModel;
			Object lockObject = getLockObject(annotationModel);
			synchronized (lockObject) {
				annotationModelExtension.replaceAnnotations(
						overrideIndicatorAnnotations.toArray(new Annotation[overrideIndicatorAnnotations.size()]),
						annotationToPosition);
			}
			overrideIndicatorAnnotations = annotationToPosition.keySet();
		}
		return Status.OK_STATUS;
	}

	private Object getLockObject(IAnnotationModel annotationModel) {
		if (annotationModel instanceof ISynchronizable) {
			Object lock = ((ISynchronizable) annotationModel).getLockObject();
			if (lock != null)
				return lock;
		}
		return annotationModel;
	}

	protected Map<Annotation, Position> createOverrideIndicatorAnnotationMap(XtextResource xtextResource) {
		List<EObject> contents = xtextResource.getContents();
		if (contents.isEmpty())
			return Maps.newHashMap();
		EObject eObject = contents.get(0);
		if (!(eObject instanceof XtendFile)) {
			return Maps.newHashMap();
		}
		XtendFile xtendFile = (XtendFile) eObject;
		Map<Annotation, Position> annotationToPosition = Maps.newHashMap();
		for (XtendFunction xtendFunction : getXtendFunctions(xtendFile)) {
			if (xtendFunction.isOverride()) {
				typeResolver.resolveTypes(xtendFunction);
				INode node = NodeModelUtils.getNode(xtendFunction);
				JvmOperation inferredOperation = associations.getDirectlyInferredOperation(xtendFunction);
				if (inferredOperation != null) {
					JvmOperation jvmOperation = overrideHelper.findOverriddenOperation(inferredOperation);
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
		}
		return annotationToPosition;
	}

	private Iterable<XtendFunction> getXtendFunctions(XtendFile xtendFile) {
		List<XtendFunction> xtendFunctions = newArrayList();
		for(Iterator<EObject> i = xtendFile.eAllContents(); i.hasNext();) {
			EObject next = i.next();
			if (next instanceof XtendFunction) {
				xtendFunctions.add((XtendFunction) next);
			}
		}
		return xtendFunctions;
	}

	protected boolean isOverwriteIndicator(JvmOperation jvmOperation) {
		return !jvmOperation.isAbstract();
	}
	
	private void installModelListener(XtextEditor xtextEditor) {
		if (xtextEditor.getDocument() != null) {
			asyncUpdateAnnotationModel();
			xtextEditor.getDocument().addModelListener(this);
		}
	}

}
