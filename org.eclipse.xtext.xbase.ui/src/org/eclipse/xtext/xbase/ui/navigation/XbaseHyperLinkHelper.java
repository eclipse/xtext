/*******************************************************************************
 * Copyright (c) 2014, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.navigation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.common.types.xtext.ui.TypeAwareHyperlinkHelper;
import org.eclipse.xtext.documentation.EObjectInComment;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.ISourceViewerAware;
import org.eclipse.xtext.ui.editor.hyperlinking.AbstractHyperlink;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.ui.editor.hyperlinking.SingleHoverShowingHyperlinkPresenter;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbasePackage;
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
public class XbaseHyperLinkHelper extends TypeAwareHyperlinkHelper implements ISourceViewerAware {

	/**
	 * An acceptor that knows if it can accept more than one useful hyperlink.
	 * 
	 * @since 2.8
	 */
	protected static class XbaseHyperlinkAcceptor extends HyperlinkAcceptor {

		private boolean canShowMany;

		public XbaseHyperlinkAcceptor(List<IHyperlink> links, boolean canShowMany) {
			super(links);
			this.canShowMany = canShowMany;
		}
		
		public boolean canShowMany() {
			return canShowMany;
		}
		
	}
	
	@Inject
	private IBatchTypeResolver typeResolver;

	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Inject
	private StaticallyImportedMemberProvider staticImpMemberProvider;
	
	@Inject
	private IJavaElementFinder javaElementFinder;
	
	@Inject
	private JvmImplementationOpener implOpener;
	
	@Inject
	private IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider;

	protected ISourceViewer sourceViewer;
	
	@Override
	public void setSourceViewer(ISourceViewer sourceViewer) {
		this.sourceViewer = sourceViewer; 
	}

	/**
	 * If multiple links are requested, all ambiguous candidates are provided for feature and constructor calls.
	 */
	@Override
	public IHyperlink[] createHyperlinksByOffset(XtextResource resource, int offset, boolean createMultipleHyperlinks) {
		List<IHyperlink> links = Lists.newArrayList();
		IHyperlinkAcceptor acceptor = new XbaseHyperlinkAcceptor(links, createMultipleHyperlinks);
		super.createHyperlinksByOffset(resource, offset, acceptor);
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
		if (canShowMany(acceptor)) {
			if (element instanceof XVariableDeclaration) {
				XVariableDeclaration variableDeclaration = (XVariableDeclaration) element;
				ILeafNode node = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
				if (isNameNode(element, XbasePackage.Literals.XVARIABLE_DECLARATION__NAME, node) && variableDeclaration.getType()==null) {
					addOpenInferredTypeHyperlink(resource, variableDeclaration, node, acceptor);
				}
			}
			if (element instanceof JvmFormalParameter) {
				JvmFormalParameter param = (JvmFormalParameter) element;
				ILeafNode node = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
				if (isNameNode(element, TypesPackage.Literals.JVM_FORMAL_PARAMETER__NAME, node) && param.getParameterType()==null) {
					addOpenInferredTypeHyperlink(resource, param, node, acceptor);
				}
			}
		}
		
		createHyperlinksInJavaDoc(resource, offset, acceptor);
	}

	/**
	 * Creates hyperlinks on types referenced in javadoc comments.
	 * 
	 * @since 2.16
	 */
	protected void createHyperlinksInJavaDoc(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		EObjectInComment eObjectReferencedInComment = javaDocTypeReferenceProvider.computeEObjectReferencedInComment(resource, offset);
		if(eObjectReferencedInComment != null) {
			EObject target = eObjectReferencedInComment.getEObject();
			ITextRegion region = eObjectReferencedInComment.getRegion();
			createHyperlinksTo(resource, new Region(region.getOffset(), region.getLength()), target, acceptor);
		}
	}

	/**
	 * Returns false if the acceptor can definitely not accept more than one hyperlink.
	 * Otherwise or if in doubt, returns true.
	 * 
	 * Only handles {@link XbaseHyperlinkAcceptor XbaseHyperlinkAcceptors} well. All other cases will assume true.
	 * @since 2.8
	 */
	protected boolean canShowMany(final IHyperlinkAcceptor acceptor) {
		if (acceptor instanceof XbaseHyperlinkAcceptor)
			return ((XbaseHyperlinkAcceptor)acceptor).canShowMany();
		return true;
	}

	protected void addOpenInferredTypeHyperlink(final XtextResource resource, JvmIdentifiableElement typedElement,
			ILeafNode node, final IHyperlinkAcceptor acceptor) {
		IResolvedTypes resolveTypes = typeResolver.resolveTypes(resource);
		final LightweightTypeReference type = resolveTypes.getActualType(typedElement);
		if (type != null && !type.isUnknown() && type.getType() != null) {
			createHyperlinksTo(resource, new Region(node.getOffset(), node.getLength()), type.getType(), new IHyperlinkAcceptor() {
				@Override
				public void accept(IHyperlink hyperlink) {
					if (hyperlink instanceof AbstractHyperlink) {
						AbstractHyperlink abstractHyperlink = (AbstractHyperlink) hyperlink;
						abstractHyperlink.setHyperlinkText("Open Inferred Type - " + type.getSimpleName());
						abstractHyperlink.setTypeLabel(SingleHoverShowingHyperlinkPresenter.SHOW_ALWAYS);
					}
					acceptor.accept(hyperlink);
				}
			});
		}
	}

	protected boolean isNameNode(EObject element, EStructuralFeature feature, ILeafNode node) {
		List<INode> nameNode = NodeModelUtils.findNodesForFeature(element, feature);
		for (INode iNode : nameNode) {
			if (iNode.getOffset() <= node.getOffset() && iNode.getLength()>= node.getLength()) {
				return true;
			}
		}
		return false;
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
			
			IJavaElement javaElement = javaElementFinder.findExactElementFor(targetElement);
			if (sourceViewer != null && javaElement != null && (javaElement.getElementType() == IJavaElement.METHOD && canBeOverridden((IMethod) javaElement))) {
				acceptor.accept(new XbaseImplementatorsHyperlink(javaElement, new Region(crossRefNode.getOffset(), crossRefNode.getLength()), sourceViewer, implOpener));
			}
			
			LightweightTypeReference typeReference = resolveTypes.getActualType(featureCall);
			if (typeReference == null || typeReference.isPrimitive() || typeReference.isPrimitiveVoid()) {
				return;
			}
			final JvmType type = typeReference.getType();
			if(type != null)
				createHyperlinksTo(resource, crossRefNode, type, new IHyperlinkAcceptor() {
					@Override
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
							// special case for variables in switch and for loops
							if (targetElement.eContainer() instanceof XSwitchExpression
								|| targetElement.eContainer() instanceof XForLoopExpression) {
								target = "Variable";
							} else {
								target = "Parameter";
							}
						} else if (targetElement instanceof XVariableDeclaration) {
							target = "Variable";
						}
						return target;
					}
				});
		}
	}

	@SuppressWarnings("restriction")
	protected boolean canBeOverridden(IMethod method) {
		try {
			return !(org.eclipse.jdt.internal.corext.util.JdtFlags.isPrivate(method) 
					|| org.eclipse.jdt.internal.corext.util.JdtFlags.isStatic(method) 
					|| org.eclipse.jdt.internal.corext.util.JdtFlags.isFinal(method) 
					|| org.eclipse.jdt.internal.corext.util.JdtFlags.isFinal(method.getDeclaringType()) 
					|| method.isConstructor());
		} catch (JavaModelException e) {
			org.eclipse.jdt.internal.ui.JavaPlugin.log(e);
			return false;
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
