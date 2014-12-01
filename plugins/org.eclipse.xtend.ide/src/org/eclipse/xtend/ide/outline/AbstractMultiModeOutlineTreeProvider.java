/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.outline;

import static com.google.common.collect.Sets.*;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.internal.ui.viewsupport.ColoringLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.custom.StyleRange;
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
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.BackgroundOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedExecutable;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeature;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedField;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("restriction")
public abstract class AbstractMultiModeOutlineTreeProvider extends BackgroundOutlineTreeProvider {

	@Inject
	private IXtendJvmAssociations associations;

	@Inject
	private JvmTypeExtensions typeExtensions;
	
	@Inject
	private CommonTypeComputationServices services;

	private IOutlineTreeProvider.ModeAware modeAware;

	protected XtendFeatureNode createNodeForFeature(IOutlineNode parentNode, final JvmDeclaredType inferredType,
			JvmFeature jvmFeature, EObject semanticFeature, int inheritanceDepth) {
		final boolean synthetic = typeExtensions.isSynthetic(jvmFeature);
		Object text = computeDecoratedText(synthetic ? jvmFeature : semanticFeature, inheritanceDepth);
		ImageDescriptor image = getImageDescriptor(synthetic ? jvmFeature : semanticFeature);
		if (isShowInherited()) {
			return getOutlineNodeFactory().createXtendFeatureNode(parentNode, jvmFeature, image, text, true, synthetic,
					inheritanceDepth);
		}
		return getOutlineNodeFactory().createXtendFeatureNode(parentNode, synthetic ? jvmFeature : semanticFeature,
				image, text, true, synthetic, inheritanceDepth);
	}

	protected final void createFeatureNodesForType(IOutlineNode parentNode, JvmDeclaredType inferredType,
			final JvmDeclaredType baseType, Set<JvmMember> processedMembers, int inheritanceDepth, boolean showInherited) {
		for (JvmMember member : inferredType.getMembers()) {
			if (!processedMembers.contains(member)) {
				if (member instanceof JvmDeclaredType) {
					JvmDeclaredType jvmNestedType = (JvmDeclaredType) member;
					if (showInherited) {
						Set<JvmMember> forgetProcessed = newHashSet();
						EObject sourceElement = associations.getPrimarySourceElement(member);
						if (sourceElement instanceof XtendTypeDeclaration) {
							createNodeForType(parentNode, sourceElement, forgetProcessed, inheritanceDepth, showInherited);
						} else {
							createNodeForType(parentNode, jvmNestedType, forgetProcessed, inheritanceDepth, showInherited);
						}
					} else {
						createNodeForType(parentNode, jvmNestedType, processedMembers, inheritanceDepth, showInherited);
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
							Set<JvmMember> forgetProcessed = newHashSet();
							createNodeForType(featureNode, jvmGenericType, forgetProcessed, inheritanceDepth, showInherited);
						}
					}
				}
				rememberJvmMember(processedMembers, member);
			}
		}

		if (showInherited) {
			handleInheritedMembers(parentNode, inferredType, processedMembers, inheritanceDepth);
		}
	}

	/**
	 * Adds all the members from the hierarchy
	 */
	protected void handleInheritedMembers(IOutlineNode parentNode, JvmDeclaredType inferredType,
			Set<JvmMember> processedMembers, int inheritanceDepth) {
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, inferredType.eResource().getResourceSet());
		LightweightTypeReference typeReference = owner.toLightweightTypeReference(inferredType);
		List<LightweightTypeReference> superTypes = typeReference.getAllSuperTypes();
		for (LightweightTypeReference superTypeRef : superTypes) {
			inheritanceDepth = inheritanceDepth +1;
			ResolvedFeatures resolvedFeatures = new ResolvedFeatures(superTypeRef);
			List<IResolvedField> declaredFields = resolvedFeatures.getDeclaredFields();
			for (IResolvedField jvmField : declaredFields) {
				if (!skipFeature(jvmField.getDeclaration()))
					createNodeForResolvedFeature(parentNode, inferredType, jvmField, inheritanceDepth);
			}
			List<IResolvedConstructor> constructors = resolvedFeatures.getDeclaredConstructors();
			for (IResolvedConstructor constructor : constructors) {
				if (!skipFeature(constructor.getDeclaration()))
					createNodeForResolvedFeature(parentNode, inferredType, constructor, inheritanceDepth);
			}
			List<IResolvedOperation> operations = resolvedFeatures.getDeclaredOperations();
			for (IResolvedOperation operation : operations) {
				if (!skipFeature(operation.getDeclaration()) && !processedMembers.contains(operation.getDeclaration()))
					createNodeForResolvedFeature(parentNode, inferredType, operation, inheritanceDepth);
			}
			JvmType jvmType = superTypeRef.getType();
			if (jvmType instanceof JvmDeclaredType) {
				JvmDeclaredType declaredType = (JvmDeclaredType) jvmType;
				for (JvmMember e : declaredType.getMembers()) {
					if (e instanceof JvmDeclaredType) {
						JvmDeclaredType nestedType = (JvmDeclaredType) e;
						createNodeForType(parentNode, nestedType, processedMembers, inheritanceDepth, false);
					}
				}
			}
		}
	}

	protected XtendFeatureNode createNodeForResolvedFeature(IOutlineNode parentNode, JvmDeclaredType inferredType,
			IResolvedFeature feature, int inheritanceDepth) {
		final boolean synthetic = typeExtensions.isSynthetic(feature.getDeclaration());
		Object text = computeDecoratedText(feature, inheritanceDepth);
		ImageDescriptor image = getImageDescriptor(feature);
		return getOutlineNodeFactory().createXtendFeatureNode(parentNode, feature.getDeclaration(), image, text, true, synthetic,
				inheritanceDepth);
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
			Set<JvmMember> processedMembers, int inheritanceDepth, boolean showInheritance);

	protected EObjectNode createNodeForType(IOutlineNode parentNode, JvmDeclaredType typeElement,
			Set<JvmMember> processedMembers, int inheritanceDepth, boolean showInheritance) {
		XtendEObjectNode classNode = createXtendNode(parentNode, typeElement, inheritanceDepth);
		if (!processedMembers.contains(typeElement)) {
			processedMembers.add(typeElement);
			createFeatureNodesForType(classNode, typeElement, typeElement, processedMembers, inheritanceDepth, showInheritance);
		}
		return classNode;
	}

	protected boolean isShowInherited() {
		if (modeAware != null) {
			return modeAware.getCurrentMode() == XtendOutlineModes.SHOW_INHERITED_MODE;
		}
		return false;
	}

	@Override
	public void internalCreateChildren(DocumentRootNode parentNode, EObject modelElement) {
		super.internalCreateChildren(parentNode, modelElement);
	}

	protected void rememberJvmMember(Set<JvmMember> processedMembers, JvmMember feature) {
		processedMembers.add(feature);
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
		boolean syntatic = false;
		if (modelElement instanceof JvmIdentifiableElement) {
			syntatic = typeExtensions.isSynthetic((JvmIdentifiableElement) modelElement);
		}
		XtendEObjectNode objectNode = getOutlineNodeFactory().createXtendEOBjectNode(parentNode, modelElement, image,
				text, true, syntatic, inheritanceDepth);
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
				String qualifier = createQualifier(((IResolvedFeature) modelElement).getDeclaration());
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
			qualifier = jvmMember.getDeclaringType().getIdentifier();
		} else if (jvmMember instanceof JvmDeclaredType) {
			if (jvmMember.eContainer() instanceof JvmDeclaredType) {
				qualifier = ((JvmDeclaredType) jvmMember.eContainer()).getQualifiedName('.');
			} else {
				JvmDeclaredType jvmDeclaredType = (JvmDeclaredType) jvmMember;
				if (StringUtils.isEmpty(jvmDeclaredType.getPackageName())) {
					qualifier = "(default package)";
				} else {
					qualifier = jvmDeclaredType.getPackageName();
				}
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

	public void setModeAware(IOutlineTreeProvider.ModeAware modeAware) {
		this.modeAware = modeAware;
	}
}
