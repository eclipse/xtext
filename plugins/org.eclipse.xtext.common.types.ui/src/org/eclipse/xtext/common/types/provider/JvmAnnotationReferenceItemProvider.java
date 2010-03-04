/**
 * <copyright>
 * </copyright>
 *
 * $Id: JvmAnnotationReferenceItemProvider.java,v 1.2 2010/03/04 10:26:33 szarnekow Exp $
 */
package org.eclipse.xtext.common.types.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.xtext.common.types.JvmAnnotationReference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class JvmAnnotationReferenceItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmAnnotationReferenceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addAnnotationPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Annotation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAnnotationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JvmAnnotationReference_annotation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JvmAnnotationReference_annotation_feature", "_UI_JvmAnnotationReference_type"),
				 TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__ANNOTATION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__VALUES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns JvmAnnotationReference.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/JvmAnnotationReference"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_JvmAnnotationReference_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(JvmAnnotationReference.class)) {
			case TypesPackage.JVM_ANNOTATION_REFERENCE__VALUES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__VALUES,
				 TypesFactory.eINSTANCE.createJvmIntAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__VALUES,
				 TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__VALUES,
				 TypesFactory.eINSTANCE.createJvmByteAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__VALUES,
				 TypesFactory.eINSTANCE.createJvmShortAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__VALUES,
				 TypesFactory.eINSTANCE.createJvmLongAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__VALUES,
				 TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__VALUES,
				 TypesFactory.eINSTANCE.createJvmFloatAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__VALUES,
				 TypesFactory.eINSTANCE.createJvmCharAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__VALUES,
				 TypesFactory.eINSTANCE.createJvmStringAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__VALUES,
				 TypesFactory.eINSTANCE.createJvmTypeAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__VALUES,
				 TypesFactory.eINSTANCE.createJvmAnnotationAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__VALUES,
				 TypesFactory.eINSTANCE.createJvmEnumAnnotationValue()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return TypesEditPlugin.INSTANCE;
	}

}
