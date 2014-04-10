/**
 * Copyright (c) 2011-2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.common.types.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.xtext.common.types.JvmOperation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class JvmOperationItemProvider extends JvmExecutableItemProvider
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmOperationItemProvider(AdapterFactory adapterFactory)
	{
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
	{
		if (itemPropertyDescriptors == null)
		{
			super.getPropertyDescriptors(object);

			addStaticPropertyDescriptor(object);
			addFinalPropertyDescriptor(object);
			addAbstractPropertyDescriptor(object);
			addSynchronizedPropertyDescriptor(object);
			addDefaultPropertyDescriptor(object);
			addNativePropertyDescriptor(object);
			addStrictFloatingPointPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Static feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStaticPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JvmOperation_static_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JvmOperation_static_feature", "_UI_JvmOperation_type"),
				 TypesPackage.Literals.JVM_OPERATION__STATIC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Final feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFinalPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JvmOperation_final_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JvmOperation_final_feature", "_UI_JvmOperation_type"),
				 TypesPackage.Literals.JVM_OPERATION__FINAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Abstract feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAbstractPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JvmOperation_abstract_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JvmOperation_abstract_feature", "_UI_JvmOperation_type"),
				 TypesPackage.Literals.JVM_OPERATION__ABSTRACT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Synchronized feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @since 2.4
	 */
	protected void addSynchronizedPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JvmOperation_synchronized_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JvmOperation_synchronized_feature", "_UI_JvmOperation_type"),
				 TypesPackage.Literals.JVM_OPERATION__SYNCHRONIZED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.4
	 * @generated
	 */
	protected void addDefaultPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JvmOperation_default_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JvmOperation_default_feature", "_UI_JvmOperation_type"),
				 TypesPackage.Literals.JVM_OPERATION__DEFAULT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Native feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @since 2.4
	 */
	protected void addNativePropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JvmOperation_native_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JvmOperation_native_feature", "_UI_JvmOperation_type"),
				 TypesPackage.Literals.JVM_OPERATION__NATIVE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Strict Floating Point feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @since 2.4
	 */
	protected void addStrictFloatingPointPropertyDescriptor(Object object)
	{
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JvmOperation_strictFloatingPoint_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JvmOperation_strictFloatingPoint_feature", "_UI_JvmOperation_type"),
				 TypesPackage.Literals.JVM_OPERATION__STRICT_FLOATING_POINT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
	{
		if (childrenFeatures == null)
		{
			super.getChildrenFeatures(object);
			childrenFeatures.add(TypesPackage.Literals.JVM_OPERATION__RETURN_TYPE);
			childrenFeatures.add(TypesPackage.Literals.JVM_OPERATION__DEFAULT_VALUE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child)
	{
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns JvmOperation.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object)
	{
		return overlayImage(object, getResourceLocator().getImage("full/obj16/JvmOperation"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object)
	{
		String label = ((JvmOperation)object).getSimpleName();
		return label == null || label.length() == 0 ?
			getString("_UI_JvmOperation_type") :
			getString("_UI_JvmOperation_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification)
	{
		updateChildren(notification);

		switch (notification.getFeatureID(JvmOperation.class))
		{
			case TypesPackage.JVM_OPERATION__STATIC:
			case TypesPackage.JVM_OPERATION__FINAL:
			case TypesPackage.JVM_OPERATION__ABSTRACT:
			case TypesPackage.JVM_OPERATION__SYNCHRONIZED:
			case TypesPackage.JVM_OPERATION__DEFAULT:
			case TypesPackage.JVM_OPERATION__NATIVE:
			case TypesPackage.JVM_OPERATION__STRICT_FLOATING_POINT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TypesPackage.JVM_OPERATION__RETURN_TYPE:
			case TypesPackage.JVM_OPERATION__DEFAULT_VALUE:
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
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
	{
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__RETURN_TYPE,
				 TypesFactory.eINSTANCE.createJvmParameterizedTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__RETURN_TYPE,
				 TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__RETURN_TYPE,
				 TypesFactory.eINSTANCE.createJvmWildcardTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__RETURN_TYPE,
				 TypesFactory.eINSTANCE.createJvmAnyTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__RETURN_TYPE,
				 TypesFactory.eINSTANCE.createJvmMultiTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__RETURN_TYPE,
				 TypesFactory.eINSTANCE.createJvmDelegateTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__RETURN_TYPE,
				 TypesFactory.eINSTANCE.createJvmSynonymTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__RETURN_TYPE,
				 TypesFactory.eINSTANCE.createJvmUnknownTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__DEFAULT_VALUE,
				 TypesFactory.eINSTANCE.createJvmIntAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__DEFAULT_VALUE,
				 TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__DEFAULT_VALUE,
				 TypesFactory.eINSTANCE.createJvmByteAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__DEFAULT_VALUE,
				 TypesFactory.eINSTANCE.createJvmShortAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__DEFAULT_VALUE,
				 TypesFactory.eINSTANCE.createJvmLongAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__DEFAULT_VALUE,
				 TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__DEFAULT_VALUE,
				 TypesFactory.eINSTANCE.createJvmFloatAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__DEFAULT_VALUE,
				 TypesFactory.eINSTANCE.createJvmCharAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__DEFAULT_VALUE,
				 TypesFactory.eINSTANCE.createJvmStringAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__DEFAULT_VALUE,
				 TypesFactory.eINSTANCE.createJvmTypeAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__DEFAULT_VALUE,
				 TypesFactory.eINSTANCE.createJvmAnnotationAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__DEFAULT_VALUE,
				 TypesFactory.eINSTANCE.createJvmEnumAnnotationValue()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_OPERATION__DEFAULT_VALUE,
				 TypesFactory.eINSTANCE.createJvmCustomAnnotationValue()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection)
	{
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == TypesPackage.Literals.JVM_EXECUTABLE__EXCEPTIONS ||
			childFeature == TypesPackage.Literals.JVM_OPERATION__RETURN_TYPE;

		if (qualify)
		{
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
