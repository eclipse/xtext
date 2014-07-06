/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.outline;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.BackgroundOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineMode;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;

import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public abstract class AbstractMultiModeOutlineTreeProvider extends BackgroundOutlineTreeProvider {
	@Inject
	private IXtendJvmAssociations associations;

	@Inject
	private JvmTypeExtensions typeExtensions;

	@Inject
	private IOutlineTreeProvider.ModeAware modeAware;

	protected XtendFeatureNode createNodeForFeature(IOutlineNode parentNode, final JvmDeclaredType inferredType,
			JvmFeature jvmFeature, EObject semanticFeature, int inheritanceDepth) {
		final boolean synthetic = typeExtensions.isSynthetic(jvmFeature);
		Object text = getText(synthetic ? jvmFeature : semanticFeature);
		ImageDescriptor image = getImageDescriptor(synthetic ? jvmFeature : semanticFeature);
		if (isShowInherited()) {
			StyledString label = (text instanceof StyledString) ? (StyledString) text : new StyledString(
					text.toString());
			label.append(new StyledString(" - " + jvmFeature.getDeclaringType().getIdentifier(),
					StyledString.QUALIFIER_STYLER));
			return getOutlineNodeFactory().createXtendFeatureNode(parentNode, jvmFeature, image, label, true,
					synthetic, inheritanceDepth);
		}
		if (!associations.isPrimaryJvmElement(jvmFeature)) {
			if (text instanceof StyledString) {
				text = new StyledString(text.toString(), StyledString.QUALIFIER_STYLER);
			}
		}
		return getOutlineNodeFactory().createXtendFeatureNode(parentNode, synthetic ? jvmFeature : semanticFeature,
				image, text, true, synthetic, inheritanceDepth);
	}

	protected final void createFeatureNodesForType(IOutlineNode parentNode, JvmDeclaredType inferredType,
			final JvmDeclaredType baseType, Set<JvmMember> processedFeatures, int inheritanceDepth) {
		for (JvmMember member : inferredType.getMembers()) {
			if (!processedFeatures.contains(member)) {
				if (member instanceof JvmDeclaredType) {
					JvmDeclaredType jvmNestedType = (JvmDeclaredType) member;
					if (isShowInherited()) {
						Set<JvmMember> hideSuper = newHashSet(processedFeatures);
						hideSuper.addAll(newHashSet(baseType.getAllFeatures()));
						EObject sourceElement = associations.getPrimarySourceElement(member);
						if (sourceElement instanceof XtendTypeDeclaration) {
							createNodeForType(parentNode, sourceElement, hideSuper, inheritanceDepth);
						} else {
							createNodeForType(parentNode, jvmNestedType, hideSuper, inheritanceDepth);
						}
					} else {
						createNodeForType(parentNode, jvmNestedType, processedFeatures, inheritanceDepth);
					}
				} else if (member instanceof JvmFeature) {
					JvmFeature feature = (JvmFeature) member;
					if (skipFeature(feature)) {
						continue;
					}
					IOutlineNode featureNode = createNodeForFeature(parentNode, baseType, feature, feature,
							inheritanceDepth);
					EList<JvmGenericType> localClasses = feature.getLocalClasses();
					if (!localClasses.isEmpty()) {
						for (JvmGenericType jvmGenericType : localClasses) {
							createNodeForType(featureNode, jvmGenericType, processedFeatures, inheritanceDepth);
						}
					}
				}
				addJvmFeature(processedFeatures, member);
			}
		}

		if (isShowInherited()) {
			if (inferredType instanceof JvmGenericType) {
				JvmTypeReference extendedClass = ((JvmGenericType) inferredType).getExtendedClass();
				if (extendedClass != null)
					createInheritedFeatureNodes(parentNode, baseType, processedFeatures, inheritanceDepth,
							extendedClass);
				for (JvmTypeReference extendedInterface : ((JvmGenericType) inferredType).getExtendedInterfaces()) {
					createInheritedFeatureNodes(parentNode, baseType, processedFeatures, inheritanceDepth,
							extendedInterface);
				}
			}
		}
	}

	protected boolean skipFeature(JvmFeature feature) {
		if (feature instanceof JvmConstructor) {
			if (feature.getDeclaringType().isLocal()
					|| typeExtensions.isSingleSyntheticDefaultConstructor((JvmConstructor) feature)) {
				return true;
			}
		}
		return false;
	}

	protected abstract void createNodeForType(IOutlineNode parentNode, EObject someType,
			Set<JvmMember> processedFeatures, int inheritanceDepth);

	protected EObjectNode createNodeForType(IOutlineNode parentNode, JvmDeclaredType typeElement,
			Set<JvmMember> processedFeatures, int inheritanceDepth) {
		XtendEObjectNode classNode = createXtendNode(parentNode, typeElement, inheritanceDepth);
		if (!processedFeatures.contains(typeElement)) {
			processedFeatures.add(typeElement);
			createFeatureNodesForType(classNode, typeElement, typeElement, processedFeatures, inheritanceDepth);
		}
		return classNode;
	}

	abstract protected void createInheritedFeatureNodes(IOutlineNode parentNode, JvmDeclaredType baseType,
			Set<JvmMember> processedFeatures, int inheritanceDepth, JvmTypeReference superType);

	protected boolean isShowInherited() {
		return modeAware.getCurrentMode() == XtendOutlineModes.SHOW_INHERITED_MODE;
	}

	@Override
	public void internalCreateChildren(DocumentRootNode parentNode, EObject modelElement) {
		super.internalCreateChildren(parentNode, modelElement);
	}

	protected void addJvmFeature(Set<JvmMember> processedFeatures, JvmMember feature) {
		processedFeatures.add(feature);
	}

	public IOutlineTreeProvider.ModeAware getModeAware() {
		return modeAware;
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
		Object text = getText(modelElement);
		ImageDescriptor image = getImageDescriptor(modelElement);
		boolean syntatic = false;
		if (modelElement instanceof JvmIdentifiableElement) {
			syntatic = typeExtensions.isSynthetic((JvmIdentifiableElement) modelElement);
		}
		XtendEObjectNode objectNode = getOutlineNodeFactory().createXtendEOBjectNode(parentNode, modelElement, image,
				text, true, syntatic, inheritanceDepth);
		if (isShowInherited()) {
			if (modelElement instanceof JvmDeclaredType) {
				if (text instanceof StyledString) {
					JvmDeclaredType jvmDeclaredType = (JvmDeclaredType) modelElement;
					String qualifier = jvmDeclaredType.getPackageName();
					if (jvmDeclaredType.eContainer() instanceof JvmGenericType) {
						qualifier = ((JvmGenericType) jvmDeclaredType.eContainer()).getQualifiedName('.');
					}
					text = new StyledString().append((StyledString) text).append(" - " + qualifier,
							StyledString.QUALIFIER_STYLER);
				}
			} else if (modelElement instanceof XtendTypeDeclaration) {
				XtendTypeDeclaration xtendType = (XtendTypeDeclaration) modelElement;
				if (xtendType.eContainer() instanceof XtendTypeDeclaration) {
					String qualifiedName = getQualifiedName((XtendTypeDeclaration) xtendType.eContainer(), '.');
					text = new StyledString().append((StyledString) text).append(" - " + qualifiedName,
							StyledString.QUALIFIER_STYLER);
				}
			}
			objectNode.setText(text);
		}
		return objectNode;
	}

	private String getQualifiedName(XtendTypeDeclaration xtendType, char innerClassDelimiter) {
		if (xtendType.getName() == null)
			return null;
		XtendTypeDeclaration declaringType = null;
		if (xtendType.eContainer() instanceof XtendTypeDeclaration) {
			declaringType = (XtendTypeDeclaration) xtendType.eContainer();
		}
		if (declaringType == null) {
			String packageName = createPackagename(xtendType);
			if (Strings.isEmpty(packageName))
				return xtendType.getName();
			return packageName + "." + xtendType.getName();
		}
		String parentName = getQualifiedName(declaringType, innerClassDelimiter);
		if (parentName == null)
			return null;
		return parentName + innerClassDelimiter + xtendType.getName();
	}

	private String createPackagename(XtendTypeDeclaration xtendType) {
		XtendFile xtendFile = EcoreUtil2.getContainerOfType(xtendType, XtendFile.class);
		if (xtendFile != null) {
			return xtendFile.getPackage();
		}
		return "";

	}

	@Override
	protected XtendOutlineNodeFactory getOutlineNodeFactory() {
		return (XtendOutlineNodeFactory) super.getOutlineNodeFactory();
	}

	protected IXtendJvmAssociations getAssociations() {
		return associations;
	}

	/**
	 * Xtend QuickOutline Mode manager
	 * 
	 */
	public static class XtendOutlineModes implements ModeAware {
		public static final OutlineMode HIDE_INHERITED_MODE = new OutlineMode("hide", "hide inherited members");

		public static final OutlineMode SHOW_INHERITED_MODE = new OutlineMode("show", "show inherited members");

		private static final List<OutlineMode> MODES = newArrayList(HIDE_INHERITED_MODE, SHOW_INHERITED_MODE);

		private int currentModeIndex = 0;

		public List<OutlineMode> getOutlineModes() {
			return MODES;
		}

		public OutlineMode getCurrentMode() {
			return getOutlineModes().get(currentModeIndex);
		}

		public OutlineMode getNextMode() {
			return getOutlineModes().get((currentModeIndex + 1) % getOutlineModes().size());
		}

		public void setCurrentMode(OutlineMode outlineMode) {
			int newIndex = getOutlineModes().indexOf(outlineMode);
			if (newIndex != -1)
				currentModeIndex = newIndex;
		}

	}
}
