/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.refactoring.ElementRenameInfo;
import org.eclipse.xtext.ui.refactoring.IRefactoringDocument;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * @author koehnlein - Initial contribution and API
 */
public class CrossRefRenameInfo {
	
	private IRefactoringDocument referringDocument;

	private URI referrerElementURI;

	private EReference eReference;

	private int index;

	private ElementRenameInfo renamedTarget;

	public CrossRefRenameInfo(IRefactoringDocument referringDocument, URI referrerElementURI, EReference eReference, int index,
			ElementRenameInfo renamedTarget) {
		this.referringDocument = referringDocument; 
		this.referrerElementURI = referrerElementURI;
		this.eReference = eReference;
		this.index = index;
		this.renamedTarget = renamedTarget;
	}
	
	public IRefactoringDocument getReferringDocument() {
		return referringDocument;
	}
	
	public URI getReferrerElementURI() {
		return referrerElementURI;
	}

	public EReference getEReference() {
		return eReference;
	}

	public int getIndex() {
		return index;
	}

	public ElementRenameInfo getRenamedTarget() {
		return renamedTarget;
	}

	public static class Table {

		private Multimap<IRefactoringDocument, CrossRefRenameInfo> document2crossRef = HashMultimap.create();

		public void add(IRefactoringDocument referringDocument, IReferenceDescription referenceDescription,
				ElementRenameInfo renamedTarget) {
			document2crossRef.put(referringDocument, new CrossRefRenameInfo(referringDocument, 
					referenceDescription.getSourceEObjectUri(), referenceDescription.getEReference(),
					referenceDescription.getIndexInList(), renamedTarget));
		}

		public void add(IRefactoringDocument referringDocument, EObject sourceEObject, EReference eReference,
				int indexInList, ElementRenameInfo renamedTarget) {
			document2crossRef.put(referringDocument, new CrossRefRenameInfo(referringDocument, EcoreUtil.getURI(sourceEObject),
					eReference, indexInList, renamedTarget));
		}

		public Iterable<CrossRefRenameInfo> getByDocument(IRefactoringDocument document) {
			return document2crossRef.get(document);
		}
		
		public Iterable<IRefactoringDocument> getDocuments() {
			return document2crossRef.keySet();
		}

	}

}
