/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.crossref.internal;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.crossref.ILinker;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.Inject;

public final class Linker implements ILinker {

	@Inject
	private ILinkingService linkingService;

	public List<XtextResource.Diagnostic> ensureLinked(EObject obj) {
		List<XtextResource.Diagnostic> brokenLinks = new ArrayList<XtextResource.Diagnostic>();
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(obj);
		if (nodeAdapter == null)
			return brokenLinks;
		CompositeNode node = nodeAdapter.getParserNode();
		EList<AbstractNode> children = node.getChildren();
		for (AbstractNode abstractNode : children) {
			if (abstractNode instanceof LeafNode && abstractNode.getGrammarElement() instanceof CrossReference) {
				CrossReference ref = (CrossReference) abstractNode.getGrammarElement();
				brokenLinks.addAll(ensureIsLinked(obj, (LeafNode) abstractNode, ref));
			}
		}
		return brokenLinks;
	}

	private XtextResource.Diagnostic createError(LeafNode linkInformation) {
		return new XtextLinkingDiagnostic(linkInformation);
	}

	@SuppressWarnings("unchecked")
	private List<XtextResource.Diagnostic> ensureIsLinked(EObject obj, LeafNode node, CrossReference ref) {
		List<XtextResource.Diagnostic> brokenLinks = new ArrayList<XtextResource.Diagnostic>();
		List<EObject> links = linkingService.getLinkedObjects(obj, ref, (LeafNode) node);

		if (links == null || links.size() == 0) {
			brokenLinks.add(createError(node));
			return brokenLinks;
		}

		EReference eRef = getReference(ref, obj.eClass());
		if (eRef == null) {
			brokenLinks.add(new XtextLinkingDiagnostic(node, "Cannot find reference " + ref));
			return brokenLinks;
		}

		if (eRef.getUpperBound() >= 0 && links.size() > eRef.getUpperBound()) {
			brokenLinks.add(new XtextLinkingDiagnostic(node, "Too many matches (" + links.size() + ") for "
					+ node.getText() + ". Feature " + eRef.getName() + " can only hold " + eRef.getUpperBound()
					+ " reference(s)."));
			return brokenLinks;
		}

		if (eRef.getUpperBound() == 1) {
			obj.eSet(eRef, links.get(0));
		}
		else { // eRef.getUpperBound() == -1 || 
			// eRef.getUpperBound() < links.size
			// TODO extract and check weather equals or identity is used by list
			List<EObject> list = (List<EObject>) obj.eGet(eRef);
			if (eRef.isUnique() && (list instanceof BasicEList)) {
				Set<EObject> addUs = new LinkedHashSet<EObject>(links);
				//addUs.removeAll(list); // removeAll calls most likely list.contains() which is rather slow
				for (int i = 0; i < list.size(); i++)
					addUs.remove(list.get(i));
				((BasicEList) list).addAllUnique(addUs);
			}
			else
				list.addAll(links);
		}
		return brokenLinks;
	}

	private EReference getReference(CrossReference ref, EClass class1) {
		EList<EReference> references = class1.getEAllReferences();
		String feature = GrammarUtil.containingAssignment(ref).getFeature();
		for (EReference reference : references) {
			if (!reference.isContainment() && reference.getName().equals(feature))
				return reference;
		}
		return null;
	}
}
