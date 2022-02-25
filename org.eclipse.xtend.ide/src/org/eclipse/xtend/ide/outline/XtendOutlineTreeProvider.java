/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.outline;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.ide.common.outline.XtendOutlineJvmTreeBuilder;
import org.eclipse.xtend.ide.common.outline.XtendOutlineSourceTreeBuilder;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineMode;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Composite TreeProvider which delegates to the active {@link AbstractMultiModeOutlineTreeProvider} implementation
 * 
 * @author Dennis Huebner
 */
public class XtendOutlineTreeProvider implements IOutlineTreeStructureProvider, IOutlineTreeProvider,
		IOutlineTreeProvider.ModeAware, IOutlineTreeProvider.Background {

	@Inject
	private Provider<XtendOutlineSourceTreeProvider> sourceProvider;

	@Inject
	private Provider<XtendOutlineSourceTreeBuilder> xtendOutlineSourceTreeBuilderProvider;

	@Inject
	private Provider<XtendOutlineJvmTreeProvider> jvmProvider;

	@Inject
	private Provider<XtendOutlineJvmTreeBuilder> xtendOutlineJvmTreeBuilderProvider;

	@Inject
	private IOutlineTreeProvider.ModeAware modeAware;

	private XtendOutlineSourceTreeProvider sourceTreeProvider;

	private XtendOutlineJvmTreeProvider jvmTreeProvider;

	@Inject
	private IPreferenceStoreAccess preferenceStoreAccess;

	private boolean showJvmModel;

	@Override
	public IOutlineNode createRoot(IXtextDocument document) {
		readCurrentModeFromPrefStore();
		return treeProviderInUse().createRoot(document);
	}

	@Override
	public void createChildren(IOutlineNode parentNode, EObject modelElement) {
		readCurrentModeFromPrefStore();
		treeProviderInUse().createChildren(parentNode, modelElement);
	}

	private void readCurrentModeFromPrefStore() {
		this.showJvmModel = preferenceStoreAccess.getPreferenceStore().getBoolean(
				SwitchOutlineModeContribution.PREFERENCE_KEY);
	}

	private AbstractMultiModeOutlineTreeProvider treeProviderInUse() {
		if (showJvmModel) {
			return getJvmTreeProvider();
		}
		return getSourceTreeProvider();
	}

	private final XtendOutlineJvmTreeProvider getJvmTreeProvider() {
		if (jvmTreeProvider == null) {
			jvmTreeProvider = jvmProvider.get();
			jvmTreeProvider.setModeAware(modeAware);
			
			XtendOutlineJvmTreeBuilder xtendOutlineJvmTreeBuilder = xtendOutlineJvmTreeBuilderProvider.get();
			xtendOutlineJvmTreeBuilder.setXtendOutlineNodeBuilder(jvmTreeProvider);
			
			jvmTreeProvider.setXtendOutlineTreeBuilder(xtendOutlineJvmTreeBuilder);
		}
		return jvmTreeProvider;
	}

	private final XtendOutlineSourceTreeProvider getSourceTreeProvider() {
		if (sourceTreeProvider == null) {
			sourceTreeProvider = sourceProvider.get();
			sourceTreeProvider.setModeAware(modeAware);
			
			XtendOutlineSourceTreeBuilder xtendOutlineSourceTreeBuilder = xtendOutlineSourceTreeBuilderProvider.get();
			xtendOutlineSourceTreeBuilder.setXtendOutlineNodeBuilder(sourceTreeProvider);
			
			sourceTreeProvider.setXtendOutlineTreeBuilder(xtendOutlineSourceTreeBuilder);
		}
		return sourceTreeProvider;
	}

	@Override
	public List<OutlineMode> getOutlineModes() {
		return modeAware.getOutlineModes();
	}

	@Override
	public OutlineMode getCurrentMode() {
		return modeAware.getCurrentMode();
	}

	@Override
	public OutlineMode getNextMode() {
		return modeAware.getNextMode();
	}

	@Override
	public void setCurrentMode(OutlineMode outlineMode) {
		modeAware.setCurrentMode(outlineMode);
	}

}
