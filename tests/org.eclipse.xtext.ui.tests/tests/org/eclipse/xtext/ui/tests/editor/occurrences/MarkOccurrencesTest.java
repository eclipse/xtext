/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.occurrences;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.ui.editor.occurrences.DefaultOccurrenceComputer.*;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModelEvent;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelListener;
import org.eclipse.jface.text.source.IAnnotationModelListenerExtension;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.occurrences.IOccurrenceComputer;
import org.eclipse.xtext.ui.editor.occurrences.MarkOccurrenceActionContributor;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.outline.DisplaySafeSyncer;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class MarkOccurrencesTest extends AbstractEditorTest {

	private static final int TIMEOUT = 10000;

	@Inject
	private IPreferenceStoreAccess preferenceStoreAccess;

	@Inject
	private MarkOccurrenceActionContributor contributor;

	@Inject
	private IOccurrenceComputer occurrenceComputer;

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.editor.outline.OutlineTestLanguage";
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		Activator.getInstance().getInjector(getEditorId()).injectMembers(this);
		IJavaProject project = JavaProjectSetupUtil.createJavaProject("test");
		IResourcesSetupUtil.addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		setMarkOccurrences(false);
	}

	@Override
	public void tearDown() throws Exception {
		setMarkOccurrences(false);
		super.tearDown();
	}

	@Test public void testMarkOccurrences() throws Exception {
		String model = "Foo { Bar(Foo) {} Baz(Foo Bar) {} }";
		IFile modelFile = IResourcesSetupUtil.createFile("test/src/Test.outlinetestlanguage", model);
		XtextEditor editor = openEditor(modelFile);
		ISelectionProvider selectionProvider = editor.getSelectionProvider();
		selectionProvider.setSelection(new TextSelection(0, 1));
		IAnnotationModel annotationModel = editor.getDocumentProvider().getAnnotationModel(editor.getEditorInput());
		ExpectationBuilder listener = new ExpectationBuilder().added(DECLARATION_ANNOTATION_TYPE, 0, 3)
				.added(OCCURRENCE_ANNOTATION_TYPE, model.indexOf("Foo", 3), 3)
				.added(OCCURRENCE_ANNOTATION_TYPE, model.lastIndexOf("Foo"), 3);
		listener.start();
		annotationModel.addAnnotationModelListener(listener);
		setMarkOccurrences(true);
		listener.verify(TIMEOUT);

		listener.start();
		listener.removed(DECLARATION_ANNOTATION_TYPE, 0, 3)
				.removed(OCCURRENCE_ANNOTATION_TYPE, model.indexOf("Foo", 3), 3)
				.removed(OCCURRENCE_ANNOTATION_TYPE, model.lastIndexOf("Foo"), 3)
				.added(DECLARATION_ANNOTATION_TYPE, model.indexOf("Bar"), 3)
				.added(OCCURRENCE_ANNOTATION_TYPE, model.lastIndexOf("Bar"), 3);
		selectionProvider.setSelection(new TextSelection(model.lastIndexOf("Bar"), 1));
		listener.verify(TIMEOUT);

		listener.start();
		listener.removed(DECLARATION_ANNOTATION_TYPE, model.indexOf("Bar"), 3).removed(OCCURRENCE_ANNOTATION_TYPE,
				model.lastIndexOf("Bar"), 3);
		setMarkOccurrences(false);
		listener.verify(TIMEOUT);
	}
	
	@Test public void testMarkOccurrencesCrossFile() throws Exception {
		String model1 = "Zonk { Bar(Foo) {} Baz(Foo Bar) {} }";
		String model2 = "Foo {}";
		IFile modelFile1 = IResourcesSetupUtil.createFile("test/src/Test1.outlinetestlanguage", model1);
		IResourcesSetupUtil.createFile("test/src/Test2.outlinetestlanguage", model2);
		IResourcesSetupUtil.waitForBuild();
		XtextEditor editor = openEditor(modelFile1);
		ISelectionProvider selectionProvider = editor.getSelectionProvider();
		selectionProvider.setSelection(new TextSelection(model1.indexOf("Foo"), 1));
		IAnnotationModel annotationModel = editor.getDocumentProvider().getAnnotationModel(editor.getEditorInput());
		ExpectationBuilder listener = new ExpectationBuilder()
				.added(OCCURRENCE_ANNOTATION_TYPE, model1.indexOf("Foo", 3), 3)
				.added(OCCURRENCE_ANNOTATION_TYPE, model1.lastIndexOf("Foo"), 3);
		listener.start();
		annotationModel.addAnnotationModelListener(listener);
		setMarkOccurrences(true);
		listener.verify(TIMEOUT);
	}

	protected void setMarkOccurrences(boolean isMarkOccurrences) {
		preferenceStoreAccess.getWritablePreferenceStore().setValue(contributor.getPreferenceKey(), isMarkOccurrences);
	}

	public class ExpectationBuilder extends Assert implements IAnnotationModelListener,
			IAnnotationModelListenerExtension {

		DisplaySafeSyncer syncer = new DisplaySafeSyncer();

		List<Triple<String, Integer, Integer>> added = newArrayList();
		List<Triple<String, Integer, Integer>> removed = newArrayList();

		private AnnotationModelEvent event;

		public ExpectationBuilder added(String type, int offset, int length) {
			added.add(Tuples.create(type, offset, length));
			return this;
		}

		public ExpectationBuilder removed(String type, int offset, int length) {
			removed.add(Tuples.create(type, offset, length));
			return this;
		}

		protected Triple<String, Integer, Integer> tuple(Annotation a, Position position) {
			return Tuples.create(a.getType(), position.getOffset(), position.getLength());
		}

		public void start() throws InterruptedException {
			syncer.start();
		}

		@SuppressWarnings("unchecked")
		public void verify(int timeout) throws TimeoutException, InterruptedException {
			syncer.awaitSignal(timeout);
			for (Annotation a : event.getRemovedAnnotations()) {
				Position position = event.getPositionOfRemovedAnnotation(a);
				if (occurrenceComputer.hasAnnotationType(a.getType())) {
					Triple<String, Integer, Integer> tuple = tuple(a, position);
					assertTrue("Unexpected removal of " + tuple.toString(), removed.remove(tuple));
				}
			}
			assertTrue(removed.toString(), removed.isEmpty());
			IAnnotationModel annotationModel = event.getAnnotationModel();
			for (Iterator<Annotation> i = annotationModel.getAnnotationIterator(); i.hasNext();) {
				Annotation a = i.next();
				if (occurrenceComputer.hasAnnotationType(a.getType())) {
					Position position = annotationModel.getPosition(a);
					Triple<String, Integer, Integer> tuple = tuple(a, position);
					assertTrue("Unexpected adding of " + tuple.toString(), added.remove(tuple));
				}
			}
			assertTrue(added.toString(), added.isEmpty());
		}

		@Override
		public void modelChanged(AnnotationModelEvent event) {
			if (event.getAddedAnnotations().length != event.getRemovedAnnotations().length) {
				this.event = event;
				syncer.signal();
			}
		}

		@Override
		public void modelChanged(IAnnotationModel model) {
		}
	}
}
