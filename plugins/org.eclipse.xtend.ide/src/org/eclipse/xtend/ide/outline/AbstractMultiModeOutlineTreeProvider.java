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
import org.eclipse.xtend.core.xtend.XtendMember;
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
			return getOutlineNodeFactory().createXtendFeatureNode(parentNode, jvmFeature, image, text, true, synthetic,
					inheritanceDepth);
		}
		return getOutlineNodeFactory().createXtendFeatureNode(parentNode, synthetic ? jvmFeature : semanticFeature,
				image, text, true, synthetic, inheritanceDepth);
	}

	protected final void createFeatureNodesForType(IOutlineNode parentNode, JvmDeclaredType inferredType,
			final JvmDeclaredType baseType, Set<JvmMember> processedMembers, int inheritanceDepth) {
		for (JvmMember member : inferredType.getMembers()) {
			if (!processedMembers.contains(member)) {
				if (member instanceof JvmDeclaredType) {
					JvmDeclaredType jvmNestedType = (JvmDeclaredType) member;
					if (isShowInherited()) {
						Set<JvmMember> hideSuper = newHashSet(processedMembers);
						hideSuper.addAll(newHashSet(baseType.getAllFeatures()));
						EObject sourceElement = associations.getPrimarySourceElement(member);
						if (sourceElement instanceof XtendTypeDeclaration) {
							createNodeForType(parentNode, sourceElement, hideSuper, inheritanceDepth);
						} else {
							createNodeForType(parentNode, jvmNestedType, hideSuper, inheritanceDepth);
						}
					} else {
						createNodeForType(parentNode, jvmNestedType, processedMembers, inheritanceDepth);
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
							createNodeForType(featureNode, jvmGenericType, processedMembers, inheritanceDepth);
						}
					}
				}
				addJvmFeature(processedMembers, member);
			}
		}

		if (isShowInherited()) {
			if (inferredType instanceof JvmGenericType) {
				JvmTypeReference extendedClass = ((JvmGenericType) inferredType).getExtendedClass();
				if (extendedClass != null)
					createInheritedFeatureNodes(parentNode, baseType, processedMembers, inheritanceDepth, extendedClass);
				for (JvmTypeReference extendedInterface : ((JvmGenericType) inferredType).getExtendedInterfaces()) {
					createInheritedFeatureNodes(parentNode, baseType, processedMembers, inheritanceDepth,
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
			Set<JvmMember> processedMembers, int inheritanceDepth);

	protected EObjectNode createNodeForType(IOutlineNode parentNode, JvmDeclaredType typeElement,
			Set<JvmMember> processedMembers, int inheritanceDepth) {
		XtendEObjectNode classNode = createXtendNode(parentNode, typeElement, inheritanceDepth);
		if (!processedMembers.contains(typeElement)) {
			processedMembers.add(typeElement);
			createFeatureNodesForType(classNode, typeElement, typeElement, processedMembers, inheritanceDepth);
		}
		return classNode;
	}

	abstract protected void createInheritedFeatureNodes(IOutlineNode parentNode, JvmDeclaredType baseType,
			Set<JvmMember> processedMembers, int inheritanceDepth, JvmTypeReference superType);

	protected boolean isShowInherited() {
		return modeAware.getCurrentMode() == XtendOutlineModes.SHOW_INHERITED_MODE;
	}

	@Override
	public void internalCreateChildren(DocumentRootNode parentNode, EObject modelElement) {
		super.internalCreateChildren(parentNode, modelElement);
	}

	protected void addJvmFeature(Set<JvmMember> processedMembers, JvmMember feature) {
		processedMembers.add(feature);
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
		return objectNode;
	}

	@Override
	protected Object getText(Object modelElement) {
		Object supertext = super.getText(modelElement);
		if (!(supertext instanceof StyledString)) {
			return supertext;
		}
		StyledString styledText = (StyledString) supertext;
		if (modelElement instanceof JvmMember) {
			JvmMember jvmMember = (JvmMember) modelElement;
			if (!getAssociations().getSourceElements(jvmMember).isEmpty()
					&& !getAssociations().isPrimaryJvmElement(jvmMember)) {
				styledText = new StyledString(styledText.toString(), StyledString.QUALIFIER_STYLER);
			}
			if (isShowInherited()) {
				String qualifier = createQualifier(jvmMember);
				if (qualifier != null) {
					styledText = new StyledString().append(styledText).append(" - " + qualifier,
							StyledString.QUALIFIER_STYLER);
				}
			}
		} else if (isShowInherited() && modelElement instanceof XtendMember) {
			XtendMember xtendMember = (XtendMember) modelElement;
			if (xtendMember.eContainer() instanceof XtendTypeDeclaration) {
				String qualifiedName = createQualifier((XtendTypeDeclaration) xtendMember.eContainer(), '.');
				styledText = new StyledString().append(styledText).append(" - " + qualifiedName,
						StyledString.QUALIFIER_STYLER);
			}
		}
		return styledText;
	}

	private String createQualifier(JvmMember jvmMember) {
		String qualifier = null;
		if (jvmMember instanceof JvmFeature) {
			qualifier = jvmMember.getDeclaringType().getIdentifier();
		} else if (jvmMember instanceof JvmDeclaredType) {
			((JvmDeclaredType) jvmMember).getPackageName();
			if (jvmMember.eContainer() instanceof JvmGenericType) {
				qualifier = ((JvmGenericType) jvmMember.eContainer()).getQualifiedName('.');
			} else if (jvmMember instanceof JvmDeclaredType) {
				qualifier = ((JvmDeclaredType) jvmMember).getPackageName();
			}
		}
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
			String packageName = createPackagename(xtendType);
			if (Strings.isEmpty(packageName))
				return xtendType.getName();
			return packageName + "." + xtendType.getName();
		}
		String parentName = createQualifier(declaringType, innerClassDelimiter);
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
