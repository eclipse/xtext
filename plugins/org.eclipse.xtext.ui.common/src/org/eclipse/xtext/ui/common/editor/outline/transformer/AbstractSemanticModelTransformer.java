/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.transformer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.filter.IOutlineFilter;

import com.google.inject.Inject;

/**
 * @author Peter Friese - Initial contribution and API
 */
public abstract class AbstractSemanticModelTransformer implements ISemanticModelTransformer {

	public static final String INVISIBLE_ROOT_NODE = "Invisible Root Node";
	public static final List<EObject> NO_CHILDREN = Collections.emptyList();
	public static final ContentOutlineNode HIDDEN_NODE = new ContentOutlineNode() {
		@Override
		public String getLabel() {
			return "hidden node";
		}
	};
	
	private boolean sorted = false;
	private HashMap<Class<?>, IOutlineFilter> filters;

	public ContentOutlineNode transformSemanticModel(EObject semanticModel) {
		ContentOutlineNode outlineModel = new ContentOutlineNode();
		outlineModel.setLabel(INVISIBLE_ROOT_NODE);

		transformSemanticNode(semanticModel, outlineModel);
		return outlineModel;
	}

	public void transformSemanticNode(EObject semanticNode, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode;
		if (consumeSemanticNode(semanticNode)) {
			outlineNode = createOutlineNode(semanticNode, outlineParentNode);
		}
		else {
			outlineNode = outlineParentNode;
		}
		if (outlineNode == HIDDEN_NODE) {
			outlineNode = outlineParentNode;
		}
		transformSemanticChildNodes(semanticNode, outlineNode);

	}

	private void transformSemanticChildNodes(EObject semanticNode, ContentOutlineNode outlineNode) {
		if (consumeSemanticChildNodes(semanticNode)) {
			EObject[] array = sortChildren(semanticNode);
			for (EObject semanticChildNode : array) {
				transformSemanticNode(semanticChildNode, outlineNode);
			}
		}
	}

	private EObject[] sortChildren(EObject semanticNode) {
		List<EObject> list = getChildNodes(semanticNode);
		EObject[] result = list.toArray(new EObject[list.size()]);
		if (sorted) {
			Arrays.sort(result, new Comparator<EObject>() {
				public int compare(EObject arg0, EObject arg1) {
					String txt0 = getText(arg0);
					String txt1 = getText(arg1);
					return txt0.compareTo(txt1);
				}
			});
		}
		return result;
	}

	protected List<EObject> getChildNodes(EObject semanticNode) {
		return getChildren(semanticNode);
	}

	protected List<EObject> getChildren(EObject semanticNode) {
		return semanticNode.eContents();
	}

	public void setSorted(boolean on) {
		this.sorted = on;
	}

	public void enableFilter(IOutlineFilter filterSpec) {
		if (filters == null) {
			filters = new HashMap<Class<?>, IOutlineFilter>();
		}
		filters.put(filterSpec.getClass(), filterSpec);
	}

	public void disableFilter(IOutlineFilter filterSpec) {
		if (filters != null) {
			filters.remove(filterSpec.getClass());
		}
	}

	public boolean isFilterActive(IOutlineFilter filterSpec) {
		if (filters != null) {
			return filters.containsKey(filterSpec.getClass());
		}
		return false;
	}

	public boolean isFilterActive(Class<?> clazz) {
		if (filters != null) {
			return filters.containsKey(clazz);
		}
		return false;
	}

	protected abstract boolean doSortChildren(EObject semanticNode);

	protected abstract ContentOutlineNode createOutlineNode(EObject semanticNode, ContentOutlineNode outlineParentNode);

	protected abstract boolean consumeSemanticChildNodes(EObject semanticNode);

	protected abstract boolean consumeSemanticNode(EObject semanticNode);

	protected ILabelProvider labelProvider;

	@Inject
	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	public String getText(EObject object) {
		return labelProvider.getText(object);
	}

	public Image getImage(EObject object) {
		return labelProvider.getImage(object);
	}

}