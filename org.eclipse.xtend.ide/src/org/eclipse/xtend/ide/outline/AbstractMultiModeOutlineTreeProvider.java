/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.outline;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.internal.ui.viewsupport.ColoringLabelProvider;
import org.eclipse.jdt.ui.JavaElementImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.common.outline.IXtendOutlineContext;
import org.eclipse.xtend.ide.common.outline.IXtendOutlineNodeBuilder;
import org.eclipse.xtend.ide.common.outline.IXtendOutlineTreeBuilder;
import org.eclipse.xtend.ide.labeling.XtendImages;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.BackgroundOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.EStructuralFeatureNode;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeature;
import org.eclipse.xtext.xbase.ui.labeling.XbaseImageAdornments;
import org.eclipse.xtext.xtype.XtypePackage;

import com.google.common.base.Strings;
import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("restriction")
public abstract class AbstractMultiModeOutlineTreeProvider extends BackgroundOutlineTreeProvider implements IXtendOutlineNodeBuilder {

	@Inject
	private XtendImages images;

	@Inject
	private XbaseImageAdornments adornments;

	@Inject
	private IXtendJvmAssociations associations;

	@Inject
	private JvmTypeExtensions typeExtensions;

	private IOutlineTreeProvider.ModeAware modeAware;
	
	private IXtendOutlineTreeBuilder xtendOutlineTreeBuilder;

	@Override
	public void internalCreateChildren(DocumentRootNode parentNode, EObject modelElement) {
		IXtendOutlineContext context = newContext(parentNode);
		xtendOutlineTreeBuilder.build(modelElement, context);
	}

	@Override
	protected void internalCreateChildren(IOutlineNode parentNode, EObject modelElement) {
		IXtendOutlineContext context = newContext(parentNode);
		xtendOutlineTreeBuilder.build(modelElement, context);
	}

	protected abstract IXtendOutlineContext newContext(IOutlineNode parentNode);

	@Override
	public IXtendOutlineContext buildEObjectNode(EObject modelElement, IXtendOutlineContext context) {
		EclipseXtendOutlineContext eclipseXtendOutlineContext = (EclipseXtendOutlineContext) context;
		IOutlineNode parentNode = eclipseXtendOutlineContext.getParentNode();
		EObjectNode node = createNode(parentNode, modelElement);
		return eclipseXtendOutlineContext.withParentNode(node);
	}

	@Override
	public IXtendOutlineContext buildXtendNode(EObject modelElement, IXtendOutlineContext context) {
		EclipseXtendOutlineContext eclipseXtendOutlineContext = (EclipseXtendOutlineContext) context;
		IOutlineNode parentNode = eclipseXtendOutlineContext.getParentNode();
		int inheritanceDepth = eclipseXtendOutlineContext.getInheritanceDepth();
		EObjectNode xtendNode = createXtendNode(parentNode, modelElement, inheritanceDepth);
		return eclipseXtendOutlineContext.withParentNode(xtendNode);
	}

	@Override
	public IXtendOutlineContext buildFeatureNode(JvmDeclaredType inferredType, EObject semanticFeature, IXtendOutlineContext context) {
		EclipseXtendOutlineContext eclipseXtendOutlineContext = (EclipseXtendOutlineContext) context;
		IOutlineNode parentNode = eclipseXtendOutlineContext.getParentNode();
		int inheritanceDepth = eclipseXtendOutlineContext.getInheritanceDepth();
		XtendFeatureNode featureNode = createNodeForFeature(parentNode, inferredType, semanticFeature, inheritanceDepth);
		return eclipseXtendOutlineContext.withParentNode(featureNode);
	}

	@Override
	public IXtendOutlineContext buildDispatcherNode(JvmDeclaredType baseType, JvmFeature dispatcher,
			List<JvmOperation> dispatchCases, IXtendOutlineContext context) {
		EclipseXtendOutlineContext eclipseXtendOutlineContext = (EclipseXtendOutlineContext) context;
		IOutlineNode parentNode = eclipseXtendOutlineContext.getParentNode();
		int inheritanceDepth = eclipseXtendOutlineContext.getInheritanceDepth();
		XtendFeatureNode dispatcherNode = createNodeForFeature(parentNode, baseType, dispatcher, inheritanceDepth);
		dispatcherNode.setDispatch(true);
		if (isInheritsDispatchCases(baseType, dispatchCases)) {
			dispatcherNode.setImageDescriptor(images.forDispatcherFunction(dispatcher.getVisibility(),
					adornments.get(dispatcher) | JavaElementImageDescriptor.OVERRIDES));
		}
		return eclipseXtendOutlineContext.withParentNode(dispatcherNode);
	}

	@Override
	public IXtendOutlineContext buildPackageNode(XtendFile xtendFile, IXtendOutlineContext context) {
		EclipseXtendOutlineContext eclipseXtendOutlineContext = (EclipseXtendOutlineContext) context;
		IOutlineNode parentNode = eclipseXtendOutlineContext.getParentNode();
		String primaryPackage = xtendFile.getPackage();
		EStructuralFeatureNode node = getOutlineNodeFactory().createEStructuralFeatureNode(parentNode, xtendFile, 
				XtendPackage.Literals.XTEND_FILE__PACKAGE,
				images.forPackage(), primaryPackage, true);
		return eclipseXtendOutlineContext.withParentNode(node);
	}

	@Override
	public IXtendOutlineContext buildImportSectionNode(XtendFile xtendFile, IXtendOutlineContext context) {
		EclipseXtendOutlineContext eclipseXtendOutlineContext = (EclipseXtendOutlineContext) context;
		IOutlineNode parentNode = eclipseXtendOutlineContext.getParentNode();
		EStructuralFeatureNode node = getOutlineNodeFactory().createEStructuralFeatureNode(parentNode, xtendFile.getImportSection(),
				XtypePackage.Literals.XIMPORT_SECTION__IMPORT_DECLARATIONS, images.forImportContainer(),
				"import declarations", false);
		return eclipseXtendOutlineContext.withParentNode(node);
	}

	@Override
	public IXtendOutlineContext buildResolvedFeatureNode(JvmDeclaredType inferredType,
			IResolvedFeature resolvedFeature, IXtendOutlineContext context) {
		EclipseXtendOutlineContext eclipseXtendOutlineContext = (EclipseXtendOutlineContext) context;
		IOutlineNode parentNode = eclipseXtendOutlineContext.getParentNode();
		int inheritanceDepth = eclipseXtendOutlineContext.getInheritanceDepth();
		XtendFeatureNode node = createNodeForResolvedFeature(parentNode, inferredType, resolvedFeature, inheritanceDepth);
		return eclipseXtendOutlineContext.withParentNode(node);
	}

	protected boolean isInheritsDispatchCases(JvmDeclaredType baseType, List<JvmOperation> dispatchCases) {
		for (JvmOperation dispatchCase : dispatchCases) {
			if (dispatchCase.getDeclaringType() != baseType) {
				return true;
			}
		}
		return false;
	}

	protected XtendFeatureNode createNodeForFeature(IOutlineNode parentNode, final JvmDeclaredType inferredType, EObject featureElement, int inheritanceDepth) {
		boolean synthetic = false;
		if (featureElement instanceof JvmFeature) {
			synthetic = typeExtensions.isSynthetic((JvmIdentifiableElement) featureElement);		
		}
		Object text = computeDecoratedText(featureElement, inheritanceDepth);
		ImageDescriptor image = getImageDescriptor(featureElement);
		if (isShowInherited()) {
			return getOutlineNodeFactory().createXtendFeatureNode(parentNode, featureElement, image, text, true, synthetic, inheritanceDepth);
		}
		return getOutlineNodeFactory().createXtendFeatureNode(parentNode, featureElement, image, text, true, synthetic, inheritanceDepth);
	}

	protected XtendFeatureNode createNodeForResolvedFeature(IOutlineNode parentNode, JvmDeclaredType inferredType,
			IResolvedFeature feature, int inheritanceDepth) {
		final boolean synthetic = typeExtensions.isSynthetic(feature.getDeclaration());
		Object text = computeDecoratedText(feature, inheritanceDepth);
		ImageDescriptor image = getImageDescriptor(feature);
		return getOutlineNodeFactory().createXtendFeatureNode(parentNode, feature.getDeclaration(), image, text, true, synthetic,
				inheritanceDepth);
	}

	protected boolean isShowInherited() {
		if (modeAware != null) {
			return modeAware.getCurrentMode() == XtendOutlineModes.SHOW_INHERITED_MODE;
		}
		return false;
	}

	@Override
	protected boolean isLeaf(EObject modelElement) {
		if (modelElement instanceof JvmDeclaredType) {
			return ((JvmDeclaredType) modelElement).getMembers().isEmpty();
		} else if (modelElement instanceof XtendTypeDeclaration) {
			return ((XtendTypeDeclaration) modelElement).getMembers().isEmpty();
		}
		return super.isLeaf(modelElement);
	}

	protected XtendEObjectNode createXtendNode(IOutlineNode parentNode, EObject modelElement, int inheritanceDepth) {
		Object text = computeDecoratedText(modelElement, inheritanceDepth);

		ImageDescriptor image = getImageDescriptor(modelElement);
		XtendEObjectNode objectNode = getOutlineNodeFactory().createXtendEObjectNode(parentNode, modelElement, image,
				text, true, inheritanceDepth);
		return objectNode;
	}

	protected Object computeDecoratedText(final Object modelElement, final int inheritanceDepth) {
		Object supertext = super.getText(modelElement);
		if (!(supertext instanceof StyledString)) {
			return supertext;
		}
		StyledString styledText = (StyledString) supertext;
		if (inheritanceDepth > 0) {
			styledText = applyStylerToFirstSegment(styledText, ColoringLabelProvider.INHERITED_STYLER);
		}
		if (modelElement instanceof JvmIdentifiableElement) {
			JvmIdentifiableElement jvmElement = (JvmIdentifiableElement) modelElement;
			if (!getAssociations().getSourceElements(jvmElement).isEmpty()
					&& !getAssociations().isPrimaryJvmElement(jvmElement)) {
				styledText = applyStylerToFirstSegment(styledText, StyledString.QUALIFIER_STYLER);
			}
		}
		if (isShowInherited()) {
			if (modelElement instanceof IResolvedFeature) {
				String qualifier = createQualifier((IResolvedFeature) modelElement);
				appendQualifier(styledText, qualifier);
			} else if (modelElement instanceof JvmMember) {
				String qualifier = createQualifier((JvmMember) modelElement);
				appendQualifier(styledText, qualifier);
			} else if (modelElement instanceof XtendMember) {
				XtendMember xtendMember = (XtendMember) modelElement;
				if (xtendMember.eContainer() instanceof XtendTypeDeclaration) {
					String qualifiedName = createQualifier((XtendTypeDeclaration) xtendMember.eContainer(), '.');
					appendQualifier(styledText, qualifiedName);
				} else if (xtendMember instanceof XtendTypeDeclaration) {
					XtendFile xtendFile = EcoreUtil2.getContainerOfType(xtendMember, XtendFile.class);
					String qualifiedName = xtendFile.getPackage()==null ? "(default package)" : xtendFile.getPackage();
					appendQualifier(styledText, qualifiedName);
				}
			}
		}
		return styledText;
	}


	private void appendQualifier(StyledString styledText, String qualifier) {
		if (qualifier != null) {
			styledText.append(" - " + qualifier, StyledString.QUALIFIER_STYLER);
		}
	}

	private StyledString applyStylerToFirstSegment(StyledString styledText, Styler styler) {
		if (styledText.getStyleRanges().length > 0) {
			StyleRange textStyle = styledText.getStyleRanges()[0];
			if (textStyle.start != 0) {
				styledText.setStyle(0, textStyle.start, styler);
			} else {
				styledText.setStyle(0, textStyle.length, styler);
			}
		} else {
			styledText = new StyledString(styledText.getString(), styler);
		}
		return styledText;
	}

	private String createQualifier(JvmMember jvmMember) {
		String qualifier = null;
		if (jvmMember instanceof JvmFeature) {
			JvmDeclaredType declaringType = jvmMember.getDeclaringType();
			qualifier = getPackageFreeNameForType(declaringType);
		} else if (jvmMember instanceof JvmDeclaredType) {
			if (jvmMember.eContainer() instanceof JvmDeclaredType) {
				qualifier = getPackageFreeNameForType((JvmDeclaredType) jvmMember.eContainer());
			} else {
				JvmDeclaredType jvmDeclaredType = (JvmDeclaredType) jvmMember;
				if (Strings.isNullOrEmpty(jvmDeclaredType.getPackageName())) {
					qualifier = "(default package)";
				} else {
					qualifier = jvmDeclaredType.getPackageName();
				}
			}
		}
		return qualifier;
	}

	private String getPackageFreeNameForType(JvmDeclaredType declaringType) {
		String qualifier;
		qualifier = declaringType.getSimpleName();
		while (declaringType.eContainer() instanceof JvmDeclaredType) {
			declaringType = (JvmDeclaredType) declaringType.eContainer();
			qualifier = declaringType.getSimpleName()+'.'+qualifier;
		}
		return qualifier;
	}
	
	private String createQualifier(IResolvedFeature feature) {
		String qualifier = feature.getContextType().getHumanReadableName();
		return qualifier;
	}

	private String createQualifier(XtendTypeDeclaration xtendType, char innerClassDelimiter) {
		if (xtendType.getName() == null)
			return null;
		XtendTypeDeclaration declaringType = null;
		if (xtendType.eContainer() instanceof XtendTypeDeclaration) {
			declaringType = (XtendTypeDeclaration) xtendType.eContainer();
		}
		if (declaringType == null) {
			return xtendType.getName();
		}
		String qualifier = xtendType.getName();
		while (xtendType.eContainer() instanceof XtendTypeDeclaration) {
			XtendTypeDeclaration parent = (XtendTypeDeclaration) xtendType.eContainer(); 
			qualifier = parent.getName() + innerClassDelimiter + qualifier;
			xtendType = parent;
		}
		return qualifier;
	}

	@Override
	protected XtendOutlineNodeFactory getOutlineNodeFactory() {
		return (XtendOutlineNodeFactory) super.getOutlineNodeFactory();
	}

	protected IXtendJvmAssociations getAssociations() {
		return associations;
	}

	public void setModeAware(IOutlineTreeProvider.ModeAware modeAware) {
		this.modeAware = modeAware;
	}
	
	public void setXtendOutlineTreeBuilder(IXtendOutlineTreeBuilder xtendOutlineTreeBuilder) {
		this.xtendOutlineTreeBuilder = xtendOutlineTreeBuilder;
	}
}
