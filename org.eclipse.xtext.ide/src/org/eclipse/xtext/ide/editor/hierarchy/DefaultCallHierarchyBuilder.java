/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.findReferences.ReferenceAcceptor;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

import com.google.common.collect.Lists;

/**
 * <p>
 * Default implementation of a call hierarchy builder.
 * </p>
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public class DefaultCallHierarchyBuilder extends AbstractHierarchyBuilder implements ICallHierarchyBuilder {
	private CallHierarchyType hierarchyType = CallHierarchyType.CALLER;

	@Override
	public Collection<IHierarchyNode> buildRoots(URI rootURI, IProgressMonitor monitor) {
		IEObjectDescription rootDeclaration = findDeclaration(rootURI);
		if (rootDeclaration == null) {
			return Collections.emptyList();
		}
		return Lists.newArrayList(createRoot(rootDeclaration));
	}

	@Override
	public Collection<IHierarchyNode> buildChildren(IHierarchyNode parent, IProgressMonitor monitor) {
		if (!parent.mayHaveChildren()) {
			return Collections.emptyList();
		}
		Map<URI, IHierarchyNode> children = new LinkedHashMap<>();
		findDeclarations(parent, monitor, (IEObjectDescription declaration, IReferenceDescription reference) -> {
			IHierarchyNode childNode = createChild(children, declaration, parent);
			if (childNode != null) {
				IHierarchyNodeReference nodeReference = createNodeReference(reference);
				if (nodeReference != null) {
					childNode.getReferences().add(nodeReference);
				}
			}
		});
		return children.values();
	}

	protected void findDeclarations(IHierarchyNode parent, IProgressMonitor monitor,
			Procedure2<? super IEObjectDescription, ? super IReferenceDescription> acceptor) {
		if (hierarchyType != null) {
			switch (hierarchyType) {
			case CALLEE:
				findTargetDeclarations(parent.getElement().getEObjectURI(), monitor, acceptor);
				break;
			default:
				findSourceDeclarations(parent.getElement().getEObjectURI(), monitor, acceptor);
				break;
			}
		} else {
			findSourceDeclarations(parent.getElement().getEObjectURI(), monitor, acceptor);
		}
	}

	protected void findTargetDeclarations(URI sourceDeclarationURI, IProgressMonitor monitor,
			Procedure2<? super IEObjectDescription, ? super IReferenceDescription> acceptor) {
		readOnly(sourceDeclarationURI, (EObject sourceDeclaration) -> {
			ReferenceAcceptor referenceAcceptor = new ReferenceAcceptor(getResourceServiceProviderRegistry(),
					reference -> {
						if (filterReference(reference)) {
							IEObjectDescription targetDeclaration = null;
							if (reference != null) {
								targetDeclaration = findTargetDeclaration(reference);
							}
							acceptor.apply(targetDeclaration, reference);
						}
					});
			getReferenceFinder().findAllReferences(sourceDeclaration, referenceAcceptor, monitor);
			return null;
		});
	}

	protected void findSourceDeclarations(URI targetDeclarationURI, IProgressMonitor monitor,
			Procedure2<? super IEObjectDescription, ? super IReferenceDescription> acceptor) {
		TargetURIs targetURIs = collectTargetURIs(targetDeclarationURI);
		ReferenceAcceptor referenceAcceptor = new ReferenceAcceptor(getResourceServiceProviderRegistry(),
				reference -> {
					if (filterReference(reference)) {
						IEObjectDescription sourceDeclaration = null;
						if (reference != null) {
							sourceDeclaration = findSourceDeclaration(reference);
						}
						acceptor.apply(sourceDeclaration, reference);
					}
				});
		getReferenceFinder().findAllReferences(targetURIs, getResourceAccess(), getIndexData(), referenceAcceptor,
				monitor);
	}

	protected TargetURIs collectTargetURIs(URI targetURI) {
		TargetURIs targetURIs = getTargetURIProvider().get();
		if (targetURI == null) {
			return targetURIs;
		}
		readOnly(targetURI, (EObject targetObject) -> {
			if (targetObject != null) {
				getTargetURICollector().add(targetObject, targetURIs);
			}
			return null;
		});
		return targetURIs;
	}

	protected boolean filterReference(IReferenceDescription reference) {
		return reference != null;
	}

	protected IEObjectDescription findDeclaration(URI objectURI) {
		return getDescription(objectURI);
	}

	protected IEObjectDescription findTargetDeclaration(IReferenceDescription reference) {
		return findDeclaration(reference.getTargetEObjectUri());
	}

	protected IEObjectDescription findSourceDeclaration(IReferenceDescription reference) {
		return findDeclaration(reference.getContainerEObjectURI());
	}

	/**
	 * @return a root hierarchy node for the given declaration; cannot be <code>null</code>
	 */
	protected IHierarchyNode createRoot(IEObjectDescription declaration) {
		DefaultHierarchyNode node = new DefaultHierarchyNode();
		node.setElement(declaration);
		node.setMayHaveChildren(true);
		return node;
	}

	/**
	 * @return a child node for the given declaration and the parent node; cannot be <code>null</code>
	 */
	protected IHierarchyNode createChild(IEObjectDescription declaration, IHierarchyNode parent) {
		DefaultHierarchyNode node = new DefaultHierarchyNode();
		node.setParent(parent);
		node.setElement(declaration);
		node.setMayHaveChildren(!node.isRecursive());
		return node;
	}

	protected IHierarchyNode createChild(Map<URI, IHierarchyNode> children, IEObjectDescription declaration,
			IHierarchyNode parent) {
		if (declaration == null) {
			return null;
		}
		IHierarchyNode childNode = children.get(declaration.getEObjectURI());
		if (childNode == null) {
			childNode = createChild(declaration, parent);
			children.put(declaration.getEObjectURI(), childNode);
		}
		return childNode;
	}

	/**
	 * @return a hierarchy node reference for the given reference; cannot be <code>null</code>
	 */
	protected IHierarchyNodeReference createNodeReference(IReferenceDescription reference) {
		return readOnly(reference.getSourceEObjectUri(), (EObject sourceObject) -> {
			ITextRegionWithLineInformation textRegion = getTextRegion(sourceObject, reference.getEReference(),
					reference.getIndexInList());
			String text = getText(sourceObject, textRegion);
			return new DefaultHierarchyNodeReference(text, textRegion, reference);
		});
	}

	protected ITextRegionWithLineInformation getTextRegion(EObject obj, EReference reference, int indexInList) {
		return getHierarchyNodeLocationProvider().getTextRegion(obj, reference, indexInList);
	}

	protected String getText(EObject obj, ITextRegionWithLineInformation textRegion) {
		if (obj == null || textRegion == ITextRegionWithLineInformation.EMPTY_REGION) {
			return "";
		}
		ICompositeNode node = NodeModelUtils.getNode(EcoreUtil.getRootContainer(obj));
		if (node == null) {
			return "";
		}
		int endOffset = textRegion.getOffset() + textRegion.getLength();
		return node.getRootNode().getText().substring(textRegion.getOffset(), endOffset);
	}

	public ICallHierarchyBuilder.CallHierarchyType getHierarchyType() {
		return hierarchyType;
	}

	public void setHierarchyType(ICallHierarchyBuilder.CallHierarchyType hierarchyType) {
		this.hierarchyType = hierarchyType;
	}
}
