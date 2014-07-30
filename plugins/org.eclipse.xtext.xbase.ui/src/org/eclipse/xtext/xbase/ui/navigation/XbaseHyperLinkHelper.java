/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.navigation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.xtext.ui.TypeAwareHyperlinkHelper;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.AbstractHyperlink;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.imports.StaticallyImportedMemberProvider;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XtypePackage;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XbaseHyperLinkHelper extends TypeAwareHyperlinkHelper {

	@Inject
	private IBatchTypeResolver typeResolver;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	private StaticallyImportedMemberProvider staticImpMemberProvider;

	/**
	 * If multiple links are requested, all ambiguous candidates are provided for feature and constructor calls.
	 */
	@Override
	public IHyperlink[] createHyperlinksByOffset(XtextResource resource, int offset, boolean createMultipleHyperlinks) {
		if (!createMultipleHyperlinks) {
			return super.createHyperlinksByOffset(resource, offset, createMultipleHyperlinks);
		}
		List<IHyperlink> links = Lists.newArrayList();
		IHyperlinkAcceptor acceptor = new HyperlinkAcceptor(links);
		INode crossRefNode = getEObjectAtOffsetHelper().getCrossReferenceNode(resource, new TextRegion(offset, 0));
		if (crossRefNode == null) {
			this.createHyperlinksByOffset(resource, offset, acceptor);
		} else {
			this.createHyperlinksForCrossRef(resource, crossRefNode, acceptor);
		}
		if (!links.isEmpty())
			return Iterables.toArray(links, IHyperlink.class);
		return null;
	}

	@Override
	public void createHyperlinksByOffset(final XtextResource resource, final int offset,
			final IHyperlinkAcceptor acceptor) {
		final EObject element = getEObjectAtOffsetHelper().resolveElementAt(resource, offset);
		if (element instanceof XImportDeclaration) {
			XImportDeclaration importDeclaration = (XImportDeclaration) element;
			if (importDeclaration.isStatic() && !importDeclaration.isWildcard()) {
				final ITextRegion textRegion = getTextRegion(importDeclaration, offset);
				if (textRegion != null) {
					final Region region = new Region(textRegion.getOffset(), textRegion.getLength());
					Iterable<JvmFeature> _allFeatures = staticImpMemberProvider.getAllFeatures(importDeclaration);
					for (final JvmFeature feature : _allFeatures) {
						this.createHyperlinksTo(resource, region, feature, acceptor);
					}
				}
			}
		}
		super.createHyperlinksByOffset(resource, offset, acceptor);
	}

	protected void createHyperlinksForCrossRef(XtextResource resource, INode crossRefNode,
			final IHyperlinkAcceptor acceptor) {
		EObject containedElementAt = getEObjectAtOffsetHelper().resolveContainedElementAt(resource,
				crossRefNode.getOffset());
		if (containedElementAt instanceof XAbstractFeatureCall) {
			IResolvedTypes resolveTypes = typeResolver.resolveTypes(resource);
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall) containedElementAt;
			final JvmIdentifiableElement targetElement = featureCall.getFeature();
			if (targetElement instanceof JvmType || featureCall.getFeature() instanceof JvmEnumerationLiteral) {
				return;
			}
			LightweightTypeReference typeReference = resolveTypes.getActualType(featureCall);
			if (typeReference == null || typeReference.isPrimitive() || typeReference.isPrimitiveVoid()) {
				return;
			}
			final JvmType type = typeReference.getType();
			createHyperlinksTo(resource, crossRefNode, type, new IHyperlinkAcceptor() {
				public void accept(IHyperlink hyperlink) {
					if (hyperlink instanceof AbstractHyperlink) {
						String target = labelForTargetElement(targetElement);
						((AbstractHyperlink) hyperlink).setHyperlinkText("Open " + target + " Type - "
								+ type.getSimpleName());
					}
					acceptor.accept(hyperlink);
				}

				private String labelForTargetElement(final JvmIdentifiableElement targetElement) {
					String target = "Return";
					if (targetElement instanceof JvmField) {
						target = "Field";
					} else if (targetElement instanceof JvmFormalParameter) {
						target = "Parameter";
					} else if (targetElement instanceof XVariableDeclaration) {
						target = "Variable";
					}
					return target;
				}
			});
		}
	}

	@Override
	protected void createHyperlinksTo(XtextResource resource, INode node, EObject target, IHyperlinkAcceptor acceptor) {
		EObject semanticObj = NodeModelUtils.findActualSemanticObjectFor(node);
		if (semanticObj instanceof XImportDeclaration) {
			if (((XImportDeclaration) semanticObj).isStatic()) {
				final ITextRegion textRegion = this.locationInFileProvider.getSignificantTextRegion(semanticObj,
						XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE, 0);
				int _offset = textRegion.getOffset();
				int _length = textRegion.getLength();
				final Region region = new Region(_offset, _length);
				this.createHyperlinksTo(resource, region, target, acceptor);
			}
		} else if (semanticObj instanceof XAbstractFeatureCall) {
			if (target instanceof JvmType) {
				XAbstractFeatureCall casted = (XAbstractFeatureCall) semanticObj;
				while (casted.isPackageFragment()) {
					casted = (XAbstractFeatureCall) casted.eContainer();
				}
				if (casted.isTypeLiteral()) {
					ITextRegion textRegion = locationInFileProvider.getSignificantTextRegion(casted);
					Region jfaceRegion = new Region(textRegion.getOffset(), textRegion.getLength());
					createHyperlinksTo(resource, jfaceRegion, target, acceptor);
					return;
				}
			}
		}
		super.createHyperlinksTo(resource, node, target, acceptor);
	}

	private ITextRegion getTextRegion(final XImportDeclaration it, final int offset) {
		final List<INode> nodes = NodeModelUtils.findNodesForFeature(it,
				XtypePackage.Literals.XIMPORT_DECLARATION__MEMBER_NAME);
		for (final INode node : nodes) {
			final ITextRegion textRegion = node.getTextRegion();
			if (textRegion.contains(offset)) {
				return textRegion;
			}
		}
		return null;
	}

	public IBatchTypeResolver getBatchTypeResolver() {
		return typeResolver;
	}

}
