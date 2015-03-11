/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter.IComparator;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter.IFilter;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.outline.outlineTest.Model;
import org.eclipse.xtext.ui.tests.editor.outline.outlineTest.OutlineTestFactory;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Injector;


/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OutlineFilterAndSorterTest extends AbstractXtextTests {

	private List<IOutlineNode> nodes;
	private OutlineFilterAndSorter filterAndSorter;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		final Injector injector = Activator.getInstance().getInjector("org.eclipse.xtext.ui.tests.editor.outline.OutlineTestLanguage");
		with(new ISetup() {
			@Override
			public Injector createInjectorAndDoEMFRegistration() {
				return injector;
			}
		});
		Model model = OutlineTestFactory.eINSTANCE.createModel();
		nodes = Lists.newArrayList();
		nodes.add(new EObjectNode(model, null, (ImageDescriptor) null, "one", true));
		nodes.add(new EObjectNode(model, null, (ImageDescriptor) null, "two", true));
		nodes.add(new EObjectNode(model, null, (ImageDescriptor) null, "three", true));
		filterAndSorter = new OutlineFilterAndSorter();
	}

	@Test public void testFilter() throws Exception{
		assertTextsEqual(filterAndSorter.filterAndSort(nodes), "one", "two", "three");
		TestFilter testFilter = new TestFilter("three");
		filterAndSorter.addFilter(testFilter);
		assertTextsEqual(filterAndSorter.filterAndSort(nodes), "one", "two", "three");
		testFilter.setEnabled(true);
		assertTextsEqual(filterAndSorter.filterAndSort(nodes), "one", "two");
	}

	@Test public void testSort() throws Exception {
		assertTextsEqual(filterAndSorter.filterAndSort(nodes), "one", "two", "three");
		TestComparator testComparator = new TestComparator();
		filterAndSorter.setComparator(testComparator);
		assertTextsEqual(filterAndSorter.filterAndSort(nodes), "one", "two", "three");
		testComparator.setEnabled(true);
		assertTextsEqual(filterAndSorter.filterAndSort(nodes), "two", "three", "one");
	}

	@Test public void testFilterAndSort() {
		TestComparator testComparator = new TestComparator();
		TestFilter testFilter = new TestFilter("three");
		filterAndSorter.setComparator(testComparator);
		filterAndSorter.addFilter(testFilter);
		assertTextsEqual(filterAndSorter.filterAndSort(nodes), "one", "two", "three");
		testComparator.setEnabled(true);
		assertTextsEqual(filterAndSorter.filterAndSort(nodes), "two", "three", "one");
		testFilter.setEnabled(true);
		assertTextsEqual(filterAndSorter.filterAndSort(nodes), "two", "one");
		testComparator.setEnabled(false);
		assertTextsEqual(filterAndSorter.filterAndSort(nodes), "one", "two");
	}
	
	@Test public void testMulitpleFilters() {
		TestFilter testFilter0 = new TestFilter("three");
		filterAndSorter.addFilter(testFilter0);
		TestFilter testFilter1 = new TestFilter("one");
		filterAndSorter.addFilter(testFilter1);
		assertTextsEqual(filterAndSorter.filterAndSort(nodes), "one", "two", "three");
		testFilter0.setEnabled(true);
		assertTextsEqual(filterAndSorter.filterAndSort(nodes), "one", "two");
		testFilter1.setEnabled(true);
		assertTextsEqual(filterAndSorter.filterAndSort(nodes), "two");
		testFilter0.setEnabled(false);
		assertTextsEqual(filterAndSorter.filterAndSort(nodes), "two", "three");
	}
	
	protected void assertTextsEqual(IOutlineNode[] nodes, String...texts) {
		assertEquals(nodes.length, texts.length);
		for(int i=0; i<nodes.length; ++i) 
			assertEquals(nodes[i].getText().toString(), texts[i]);
	}
	
	protected static class TestFilter implements IFilter {
		
		private boolean isEnabled = false;

		private String rejected;
		
		public TestFilter(String rejected) {
			this.rejected = rejected;
		}
		
		@Override
		public boolean apply(IOutlineNode input) {
			return !rejected.equals(input.getText().toString());
		}

		@Override
		public boolean isEnabled() {
			return isEnabled;
		}
		
		public void setEnabled(boolean isEnabled) {
			this.isEnabled = isEnabled;
		}
	}
	
	protected static class TestComparator implements IComparator {

		private boolean isEnabled = false;

		@Override
		public int compare(IOutlineNode o1, IOutlineNode o2) {
			return o2.getText().toString().compareTo(o1.getText().toString());
		}

		@Override
		public boolean isEnabled() {
			return isEnabled;
		}
		
		public void setEnabled(boolean isEnabled) {
			this.isEnabled = isEnabled;
		}
		
	}
	
}
