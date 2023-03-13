/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.ide.common.outline.IXtendOutlineContext;
import org.eclipse.xtend.ide.labeling.XtendJvmLabelProvider;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;

import com.google.inject.Inject;

/**
 * Customization of the default outline structure.
 * 
 * @author Dennis Huebner
 */
public class XtendOutlineJvmTreeProvider extends AbstractMultiModeOutlineTreeProvider {

	@Inject
	private XtendJvmLabelProvider xtendJvmLableProvider;
	
	@Override
	public IXtendOutlineContext buildXtendNode(EObject modelElement, IXtendOutlineContext context) {
		IXtendOutlineContext resultedContext = super.buildXtendNode(modelElement, context);
		
		if (!context.isShowInherited()) {
			EclipseXtendOutlineContext eclipseXtendOutlineContext = (EclipseXtendOutlineContext) context;
			IOutlineNode parentNode = eclipseXtendOutlineContext.getParentNode();
			if (parentNode instanceof DocumentRootNode) {
				if (modelElement instanceof JvmDeclaredType) {
					JvmDeclaredType jvmDeclaredType = (JvmDeclaredType) modelElement;
					String packageName = jvmDeclaredType.getPackageName();
					if (packageName != null) {
						EObject rootElement = modelElement.eResource().getContents().get(0);
						if (rootElement instanceof XtendFile) {
							XtendFile xtendFile = (XtendFile) rootElement;
							String primaryPackage = xtendFile.getPackage();
							if (!packageName.equals(primaryPackage)) {
								EObjectNode typeNode = (EObjectNode) ((EclipseXtendOutlineContext) resultedContext).getParentNode();
								if (typeNode.getText() instanceof StyledString) {
									typeNode.setText(((StyledString) typeNode.getText()).append(new StyledString(" - "
											+ packageName, StyledString.QUALIFIER_STYLER)));
								}
							}
						}
					}
				}
			}
		}
		return resultedContext;
	}

	@Override
	protected ILabelProvider getLabelProvider() {
		return xtendJvmLableProvider;
	}

	@Override
	protected IXtendOutlineContext newContext(IOutlineNode parentNode) {
		EclipseXtendOutlineContext context = new EclipseXtendOutlineContext();
		context.setShowInherited(isShowInherited());
		context.setParentNode(parentNode);
		return context;
	}

}
