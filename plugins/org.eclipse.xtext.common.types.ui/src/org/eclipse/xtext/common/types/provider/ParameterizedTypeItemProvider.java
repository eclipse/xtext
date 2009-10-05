/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.xtext.common.types.ParameterizedType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.xtext.common.types.ParameterizedType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ParameterizedTypeItemProvider
	extends ComponentTypeItemProvider
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
	public ParameterizedTypeItemProvider(AdapterFactory adapterFactory) {
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

			addFullyQualifiedNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Fully Qualified Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFullyQualifiedNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ParameterizedType_fullyQualifiedName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ParameterizedType_fullyQualifiedName_feature", "_UI_ParameterizedType_type"),
				 TypesPackage.Literals.PARAMETERIZED_TYPE__FULLY_QUALIFIED_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(TypesPackage.Literals.PARAMETERIZED_TYPE__ARGUMENTS);
			childrenFeatures.add(TypesPackage.Literals.PARAMETERIZED_TYPE__RAW_TYPE);
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
	 * This returns ParameterizedType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ParameterizedType"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ParameterizedType)object).getFullyQualifiedName();
		return label == null || label.length() == 0 ?
			getString("_UI_ParameterizedType_type") :
			getString("_UI_ParameterizedType_type") + " " + label;
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

		switch (notification.getFeatureID(ParameterizedType.class)) {
			case TypesPackage.PARAMETERIZED_TYPE__FULLY_QUALIFIED_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TypesPackage.PARAMETERIZED_TYPE__ARGUMENTS:
			case TypesPackage.PARAMETERIZED_TYPE__RAW_TYPE:
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
				(TypesPackage.Literals.PARAMETERIZED_TYPE__ARGUMENTS,
				 TypesFactory.eINSTANCE.createWildcardTypeArgument()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PARAMETERIZED_TYPE__ARGUMENTS,
				 TypesFactory.eINSTANCE.createReferenceTypeArgument()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PARAMETERIZED_TYPE__RAW_TYPE,
				 TypesFactory.eINSTANCE.createVoid()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PARAMETERIZED_TYPE__RAW_TYPE,
				 TypesFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PARAMETERIZED_TYPE__RAW_TYPE,
				 TypesFactory.eINSTANCE.createWildcard()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PARAMETERIZED_TYPE__RAW_TYPE,
				 TypesFactory.eINSTANCE.createArrayType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PARAMETERIZED_TYPE__RAW_TYPE,
				 TypesFactory.eINSTANCE.createTypeParameter()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PARAMETERIZED_TYPE__RAW_TYPE,
				 TypesFactory.eINSTANCE.createAnnotationType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PARAMETERIZED_TYPE__RAW_TYPE,
				 TypesFactory.eINSTANCE.createEnumerationType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PARAMETERIZED_TYPE__RAW_TYPE,
				 TypesFactory.eINSTANCE.createGenericType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PARAMETERIZED_TYPE__RAW_TYPE,
				 TypesFactory.eINSTANCE.createParameterizedType()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == TypesPackage.Literals.COMPONENT_TYPE__ARRAY_TYPE ||
			childFeature == TypesPackage.Literals.PARAMETERIZED_TYPE__RAW_TYPE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
