/*******************************************************************************
 * Copyright (c) 2011, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.RepeatedTest;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.occurrences.IOccurrenceComputer;
import org.eclipse.xtext.ui.editor.occurrences.MarkOccurrenceActionContributor;
import org.eclipse.xtext.ui.editor.occurrences.OccurrenceMarker;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.testing.AbstractEditorTest;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.tests.editor.outline.ui.tests.OutlineTestLanguageUiInjectorProvider;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(OutlineTestLanguageUiInjectorProvider.class)
public class MarkOccurrencesTest extends AbstractEditorTest {

	private static final int TIMEOUT = 10000;

	@Rule public RepeatedTest.Rule rule = new RepeatedTest.Rule(false); 
	
	@Inject
	private IPreferenceStoreAccess preferenceStoreAccess;

	@Inject
	private MarkOccurrenceActionContributor contributor;

	@Inject
	private IOccurrenceComputer occurrenceComputer;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		IJavaProject project = JavaProjectSetupUtil.createJavaProject("MarkOccurrencesTest");
		IResourcesSetupUtil.addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IResourcesSetupUtil.waitForBuild();
		setMarkOccurrences(false);
	}

	@Override
	public void tearDown() throws Exception {
		setMarkOccurrences(false);
		super.tearDown();
	}

	@Test public void testMarkOccurrences() throws Exception {
		String model = "Foo { Bar(Foo) {} Baz(Foo Bar) {} }";
		IFile modelFile = IResourcesSetupUtil.createFile("MarkOccurrencesTest/src/Test.outlinetestlanguage", model);
		XtextEditor editor = openEditor(modelFile);
		ISelectionProvider selectionProvider = editor.getSelectionProvider();
		selectionProvider.setSelection(new TextSelection(0, 1));
		IAnnotationModel annotationModel = editor.getDocumentProvider().getAnnotationModel(editor.getEditorInput());
		ExpectationBuilder listener = new ExpectationBuilder(editor, annotationModel).added(DECLARATION_ANNOTATION_TYPE, 0, 3)
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
		IFile modelFile1 = IResourcesSetupUtil.createFile("MarkOccurrencesTest/src/Test1.outlinetestlanguage", model1);
		IResourcesSetupUtil.createFile("MarkOccurrencesTest/src/Test2.outlinetestlanguage", model2);
		IResourcesSetupUtil.waitForBuild();
		XtextEditor editor = openEditor(modelFile1);
		ISelectionProvider selectionProvider = editor.getSelectionProvider();
		selectionProvider.setSelection(new TextSelection(model1.indexOf("Foo"), 1));
		IAnnotationModel annotationModel = editor.getDocumentProvider().getAnnotationModel(editor.getEditorInput());
		ExpectationBuilder listener = new ExpectationBuilder(editor, annotationModel)
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

		List<Triple<String, Integer, Integer>> added = newArrayList();
		List<Triple<String, Integer, Integer>> removed = newArrayList();

		private AnnotationModelEvent event;

		private IAnnotationModel sender;

		private XtextEditor editor;

		public ExpectationBuilder(XtextEditor editor, IAnnotationModel sender) {
			this.editor = editor;
			this.sender = sender;
		}

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
			event = null;
		}

		public void verify(int timeout) throws TimeoutException, InterruptedException {
			OccurrenceMarker occurrenceMarker = contributor.findOccurrenceMarker(editor);
			assertNotNull(occurrenceMarker);
			occurrenceMarker.joinMarkOccurrenceJob();
			try {
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
			} finally {
				event = null;
			}
		}

		@Override
		public void modelChanged(AnnotationModelEvent event) {
			if (sender == event.getAnnotationModel()) {
				if (event.isWorldChange()) {
					Assert.assertEquals("addAnnotationModelListener", Thread.currentThread().getStackTrace()[2].getMethodName());
				} else {
					if (event.getAddedAnnotations().length != event.getRemovedAnnotations().length) {
						Assert.assertNull(this.event);
						this.event = event;
					}
				}
			}
		}

		@Override
		public void modelChanged(IAnnotationModel model) {
			throw new UnsupportedOperationException();
		}
	}
}
