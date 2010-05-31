/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.xtext.index.IndexTestLanguageStandaloneSetup;

/**
 * @author koehnlein - Initial contribution and API
 */
public class ResourceSetBasedSlotEntryReaderTest extends AbstractReaderTest {

	@Override
	protected SlotEntry createSlotEntry() {
		return new ResourceSetBasedSlotEntry();
	}
	
	@SuppressWarnings("unchecked")
	public void testLoadAll() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());
		SlotEntry entry = createSlotEntry();
		reader.addLoad(entry);
		
		WorkflowContext ctx = ctx();
		reader.invoke(ctx, monitor(), issues());
		List<EObject> elements = (List<EObject>) ctx.get("model");
		assertEquals(11,elements.size());
	}

	@SuppressWarnings("unchecked")
	public void testLoadFileElements() throws Exception {
		Reader reader = getReader();
		reader.addPath(pathTo("emptyFolder"));
		reader.addPath(pathTo("nonemptyFolder"));
		reader.addRegister(new IndexTestLanguageStandaloneSetup());
		SlotEntry entry = createSlotEntry();
		entry.setType("File");
		reader.addLoad(entry);
		
		WorkflowContext ctx = ctx();
		reader.invoke(ctx, monitor(), issues());
		List<EObject> elements = (List<EObject>) ctx.get("model");
		assertEquals(2,elements.size());
	}
}
