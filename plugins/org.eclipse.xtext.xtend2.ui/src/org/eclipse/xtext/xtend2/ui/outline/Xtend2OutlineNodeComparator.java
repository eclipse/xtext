package org.eclipse.xtext.xtend2.ui.outline;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.SortOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.EStructuralFeatureNode;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2OutlineNodeComparator extends SortOutlineContribution.DefaultComparator {
	@Override
	public int getCategory(IOutlineNode node) {
		if (node instanceof EStructuralFeatureNode) {
			EStructuralFeature feature = ((EStructuralFeatureNode) node).getEStructuralFeature();
			if (feature == Xtend2Package.Literals.XTEND_FILE__PACKAGE)
				return 0;
			else
				return 10;
		}
		boolean isStatic = node instanceof XtendFeatureNode && ((XtendFeatureNode) node).isStatic();
		if (node instanceof EObjectNode) {
			EClass eClass = ((EObjectNode) node).getEClass();
			if (eClass == Xtend2Package.Literals.XTEND_CLASS)
				return 20;
			if (eClass == Xtend2Package.Literals.XTEND_FIELD || eClass == TypesPackage.Literals.JVM_FIELD) 
				return isStatic ? 30 : 50;
			if (eClass == Xtend2Package.Literals.XTEND_CONSTRUCTOR || eClass == TypesPackage.Literals.JVM_CONSTRUCTOR)
				return 60;
			if (eClass == Xtend2Package.Literals.XTEND_FUNCTION || eClass == TypesPackage.Literals.JVM_OPERATION) {
				if(isStatic) 
					return 40; 
				else 
					return (node instanceof XtendFeatureNode && ((XtendFeatureNode) node).isDispatch()) ? 70 : 80;
			}
		}
		return Integer.MAX_VALUE;
	}

}
