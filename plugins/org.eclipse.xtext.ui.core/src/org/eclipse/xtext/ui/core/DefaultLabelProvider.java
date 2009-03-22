package org.eclipse.xtext.ui.core;

import java.util.Collections;

import org.eclipse.emf.common.util.WrappedException;
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
	
	private PolymorphicDispatcher<String> getText = new PolymorphicDispatcher<String>("text",1,1,Collections.singletonList(this), 
	new PolymorphicDispatcher.ErrorHandler<String>(){

		private PolymorphicDispatcher<String> recoverText = new PolymorphicDispatcher<String>("error_text",2,2,Collections.singletonList(DefaultLabelProvider.this));
		public String handle(Object[] params, Throwable e) {
			return recoverText.invoke(params[0],e);
		}
	});
	
	private PolymorphicDispatcher<Image> getImage = new PolymorphicDispatcher<Image>("image",1,1,Collections.singletonList(this), 
	new PolymorphicDispatcher.ErrorHandler<Image>(){
		
		private PolymorphicDispatcher<Image> recoverImage = new PolymorphicDispatcher<Image>("error_image",2,2,Collections.singletonList(DefaultLabelProvider.this));
		public Image handle(Object[] params, Throwable e) {
			return recoverImage.invoke(params[0],e);
		}
	});
	
	@Override
	public final String getText(Object element) {
		return getText.invoke(element);
	}
	
	@Override
	public final Image getImage(Object element) {
		return getImage.invoke(element);
	}

	public String error_text(Object object, Exception e) {
		throw new WrappedException(e);
	}
	public String error_text(Object object, NullPointerException e) {
		return text(object);
	}
	
	public String text(Object object) {
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
	
	public Image error_image(Object object, Exception e) {
		throw new WrappedException(e);
	}
	public Image error_image(Object object, NullPointerException e) {
		return image(object);
	}
	public Image image(Object obj) {
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
