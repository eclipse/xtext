package org.eclipse.xtext.example.gmf.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.xtext.example.gmf.diagram.part.EntitiesVisualIDRegistry;

/**
 * @generated
 */
public class EntitiesNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 5003;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof EntitiesNavigatorItem) {
			EntitiesNavigatorItem item = (EntitiesNavigatorItem) element;
			return EntitiesVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
