/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.outline;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.BackgroundOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineMode;
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
		if (jvmFeature.getDeclaringType() != inferredType) {
			if (isShowInherited()) {
				StyledString label = (text instanceof StyledString) ? (StyledString) text : new StyledString(
						text.toString());
				label.append(new StyledString(" - " + jvmFeature.getDeclaringType().getIdentifier(),
						StyledString.QUALIFIER_STYLER));
				return getOutlineNodeFactory().createXtendFeatureNode(parentNode, jvmFeature, image, label, true,
						synthetic, inheritanceDepth);
			}
			return null;
		} else {
			if (!associations.isPrimaryJvmElement(jvmFeature)) {
				if (text instanceof StyledString) {
					text = new StyledString(text.toString(), StyledString.QUALIFIER_STYLER);
				}
			}
			return getOutlineNodeFactory().createXtendFeatureNode(parentNode, semanticFeature, image, text, true,
					synthetic, inheritanceDepth);
		}
	}

	protected boolean isShowInherited() {
		return modeAware.getCurrentMode() == XtendOutlineModes.SHOW_INHERITED_MODE;
	}

	@Override
	public void internalCreateChildren(DocumentRootNode parentNode, EObject modelElement) {
		super.internalCreateChildren(parentNode, modelElement);
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
