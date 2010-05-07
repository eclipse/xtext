package org.eclipse.xtext.example.gmf.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.EntityEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.EntityExtendsEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.ModelEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.ReferenceEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.SimplePropertyEditPart;
import org.eclipse.xtext.example.gmf.diagram.edit.parts.SimpleTypeEditPart;
import org.eclipse.xtext.example.gmf.diagram.part.EntitiesDiagramEditorPlugin;
import org.eclipse.xtext.example.gmf.entities.EntitiesPackage;

/**
 * @generated
 */
public class EntitiesElementTypes {

	/**
	 * @generated
	 */
	private EntitiesElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Model_79 = getElementType("org.eclipse.xtext.example.gmf.diagram.Model_79"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Entity_1001 = getElementType("org.eclipse.xtext.example.gmf.diagram.Entity_1001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType SimpleType_1002 = getElementType("org.eclipse.xtext.example.gmf.diagram.SimpleType_1002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType SimpleProperty_2001 = getElementType("org.eclipse.xtext.example.gmf.diagram.SimpleProperty_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Reference_3001 = getElementType("org.eclipse.xtext.example.gmf.diagram.Reference_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EntityExtends_3002 = getElementType("org.eclipse.xtext.example.gmf.diagram.EntityExtends_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return EntitiesDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Model_79, EntitiesPackage.eINSTANCE.getModel());

			elements.put(Entity_1001, EntitiesPackage.eINSTANCE.getEntity());

			elements.put(SimpleType_1002,
					EntitiesPackage.eINSTANCE.getSimpleType());

			elements.put(SimpleProperty_2001,
					EntitiesPackage.eINSTANCE.getSimpleProperty());

			elements.put(Reference_3001,
					EntitiesPackage.eINSTANCE.getReference());

			elements.put(EntityExtends_3002,
					EntitiesPackage.eINSTANCE.getEntity_Extends());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Model_79);
			KNOWN_ELEMENT_TYPES.add(Entity_1001);
			KNOWN_ELEMENT_TYPES.add(SimpleType_1002);
			KNOWN_ELEMENT_TYPES.add(SimpleProperty_2001);
			KNOWN_ELEMENT_TYPES.add(Reference_3001);
			KNOWN_ELEMENT_TYPES.add(EntityExtends_3002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ModelEditPart.VISUAL_ID:
			return Model_79;
		case EntityEditPart.VISUAL_ID:
			return Entity_1001;
		case SimpleTypeEditPart.VISUAL_ID:
			return SimpleType_1002;
		case SimplePropertyEditPart.VISUAL_ID:
			return SimpleProperty_2001;
		case ReferenceEditPart.VISUAL_ID:
			return Reference_3001;
		case EntityExtendsEditPart.VISUAL_ID:
			return EntityExtends_3002;
		}
		return null;
	}

}
