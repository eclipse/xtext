package org.eclipse.xtext.ui.core;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.util.PolymorphicDispatcher;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Peter Friese - Implementation
 */
public class DefaultLabelProvider extends LabelProvider {
	
	private PolymorphicDispatcher<String> getText = new PolymorphicDispatcher<String>("getTextFor",this);
	private PolymorphicDispatcher<Image> getImage = new PolymorphicDispatcher<Image>("getImageFor",this);
	
	@Override
	public final String getText(Object element) {
		return getText.invoke(element);
	}
	
	@Override
	public final Image getImage(Object element) {
		return getImage.invoke(element);
	}

	public String getTextFor(Object object) {
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			EClass eClass = eObject.eClass();

			EStructuralFeature feature = getLabelFeature(eClass);
			if (feature != null) {
				Object value = eObject.eGet(feature);
				if (value != null) {
					return value.toString();
				}
			}
			return eClass.getName();
		}
		return "<unknown>";
	}
	
	public Image getImageFor(Object obj) {
		return null;
	}

	protected EStructuralFeature getLabelFeature(EClass eClass) {
		EAttribute result = null;
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {
			if (!eAttribute.isMany() && eAttribute.getEType().getInstanceClass() != FeatureMap.Entry.class) {
				if ("name".equalsIgnoreCase(eAttribute.getName())) {
					result = eAttribute;
					break;
				}
				else if (result == null) {
					result = eAttribute;
				}
				else if (eAttribute.getEAttributeType().getInstanceClass() == String.class
						&& result.getEAttributeType().getInstanceClass() != String.class) {
					result = eAttribute;
				}
			}
		}
		return result;
	}
}
