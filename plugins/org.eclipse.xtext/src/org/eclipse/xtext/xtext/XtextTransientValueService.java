package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parsetree.reconstr.impl.SimpleTransientValueService;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtextTransientValueService extends SimpleTransientValueService {

	public boolean isTransient(EObject owner, EStructuralFeature feature,
			int index) {

		// System.out.println(owner.eClass().getName() + "."+feature.getName());
		// FIXME: there are actually meta model references that need to be
		// serialized
		if (feature == XtextPackage.eINSTANCE.getTypeRef_Metamodel()) {
			AbstractMetamodelDeclaration m = (AbstractMetamodelDeclaration) owner
					.eGet(feature);
			return m == null || m.getAlias() == null || m.getAlias().equals("");
		}

		return super.isTransient(owner, feature, index);
	}

}
