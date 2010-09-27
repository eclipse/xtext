/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model;

import java.util.List;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DocumentLockerTest extends AbstractXtextDocumentTest {
	
	public void testNoUpdateContentProcessOnReentrant() throws Exception {
		final List<String> s = Lists.newArrayList();

		final XtextDocument document = new XtextDocument() {
			@Override
			protected <T> void updateContentBeforeRead() {
				s.add("x");
			}
		};
		document.setInput(new XtextResource());

		assertEquals(0, s.size());
		document.readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				assertEquals(1, s.size());
				document.readOnly(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource state) throws Exception {
						assertEquals(1, s.size());
						document.readOnly(new IUnitOfWork.Void<XtextResource>() {
							@Override
							public void process(XtextResource state) throws Exception {
								assertEquals(1, s.size());
							}
						});
					}
				});
			}
		});
		assertEquals(1, s.size());
	}
}
