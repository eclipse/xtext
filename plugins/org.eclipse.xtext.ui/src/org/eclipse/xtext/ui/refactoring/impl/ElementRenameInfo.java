/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.internal.Maps;

/**
 * @author koehnlein - Initial contribution and API
 */
public class ElementRenameInfo {

	private final URI renamedElementURI;
	
	private final int offset;

	private final IRefactoringDocument document;
	
	public ElementRenameInfo(IRefactoringDocument document, URI renamedElementURI, int offset) {
		super();
		this.document = document;
		this.renamedElementURI = renamedElementURI;
		this.offset = offset;
	}

	public int getOffset() {
		return offset;
	}
	
	public URI getRenamedElementURI() {
		return renamedElementURI;
	}

	public IRefactoringDocument getDocument() {
		return document;
	}
	
	public static class Table {
		
		private Multimap<IRefactoringDocument, ElementRenameInfo> document2info = HashMultimap.create();
		private Map<URI, ElementRenameInfo> uri2info = Maps.newHashMap();		
		
		public void add(ElementRenameInfo info) {
			document2info.put(info.getDocument(), info);
			uri2info.put(info.getRenamedElementURI(), info);
		}
		
		public Iterable<ElementRenameInfo> getByDocument(IRefactoringDocument document) {
			return document2info.get(document);
		}
		
		public ElementRenameInfo getByURI(URI renamedElementURI) {
			return uri2info.get(renamedElementURI);
		}
		
		public Iterable<IRefactoringDocument> getDocuments() {
			return document2info.keySet();
		}
	}
}
