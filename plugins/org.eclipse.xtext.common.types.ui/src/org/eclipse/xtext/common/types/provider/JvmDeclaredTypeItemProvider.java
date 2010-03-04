/**
 * <copyright>
 * </copyright>
 *
 * $Id: JvmDeclaredTypeItemProvider.java,v 1.2 2010/03/04 10:26:33 szarnekow Exp $
 */
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

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.xtext.common.types.JvmDeclaredType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class JvmDeclaredTypeItemProvider
	extends JvmComponentTypeItemProvider
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
	public JvmDeclaredTypeItemProvider(AdapterFactory adapterFactory) {
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

			addVisibilityPropertyDescriptor(object);
			addFullyQualifiedNamePropertyDescriptor(object);
			addAbstractPropertyDescriptor(object);
			addStaticPropertyDescriptor(object);
			addFinalPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Visibility feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVisibilityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JvmMember_visibility_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JvmMember_visibility_feature", "_UI_JvmMember_type"),
				 TypesPackage.Literals.JVM_MEMBER__VISIBILITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
				 getString("_UI_JvmMember_fullyQualifiedName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JvmMember_fullyQualifiedName_feature", "_UI_JvmMember_type"),
				 TypesPackage.Literals.JVM_MEMBER__FULLY_QUALIFIED_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Abstract feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAbstractPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JvmDeclaredType_abstract_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JvmDeclaredType_abstract_feature", "_UI_JvmDeclaredType_type"),
				 TypesPackage.Literals.JVM_DECLARED_TYPE__ABSTRACT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Static feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStaticPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JvmDeclaredType_static_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JvmDeclaredType_static_feature", "_UI_JvmDeclaredType_type"),
				 TypesPackage.Literals.JVM_DECLARED_TYPE__STATIC,
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
	protected void addFinalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_JvmDeclaredType_final_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_JvmDeclaredType_final_feature", "_UI_JvmDeclaredType_type"),
				 TypesPackage.Literals.JVM_DECLARED_TYPE__FINAL,
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
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(TypesPackage.Literals.JVM_ANNOTATION_TARGET__ANNOTATIONS);
			childrenFeatures.add(TypesPackage.Literals.JVM_DECLARED_TYPE__SUPER_TYPES);
			childrenFeatures.add(TypesPackage.Literals.JVM_DECLARED_TYPE__MEMBERS);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((JvmDeclaredType)object).getFullyQualifiedName();
		return label == null || label.length() == 0 ?
			getString("_UI_JvmDeclaredType_type") :
			getString("_UI_JvmDeclaredType_type") + " " + label;
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

		switch (notification.getFeatureID(JvmDeclaredType.class)) {
			case TypesPackage.JVM_DECLARED_TYPE__VISIBILITY:
			case TypesPackage.JVM_DECLARED_TYPE__FULLY_QUALIFIED_NAME:
			case TypesPackage.JVM_DECLARED_TYPE__ABSTRACT:
			case TypesPackage.JVM_DECLARED_TYPE__STATIC:
			case TypesPackage.JVM_DECLARED_TYPE__FINAL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case TypesPackage.JVM_DECLARED_TYPE__ANNOTATIONS:
			case TypesPackage.JVM_DECLARED_TYPE__SUPER_TYPES:
			case TypesPackage.JVM_DECLARED_TYPE__MEMBERS:
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
				(TypesPackage.Literals.JVM_ANNOTATION_TARGET__ANNOTATIONS,
				 TypesFactory.eINSTANCE.createJvmAnnotationReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_DECLARED_TYPE__SUPER_TYPES,
				 TypesFactory.eINSTANCE.createJvmParameterizedTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_DECLARED_TYPE__SUPER_TYPES,
				 TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_DECLARED_TYPE__MEMBERS,
				 TypesFactory.eINSTANCE.createJvmAnnotationType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_DECLARED_TYPE__MEMBERS,
				 TypesFactory.eINSTANCE.createJvmEnumerationType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_DECLARED_TYPE__MEMBERS,
				 TypesFactory.eINSTANCE.createJvmGenericType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_DECLARED_TYPE__MEMBERS,
				 TypesFactory.eINSTANCE.createJvmField()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_DECLARED_TYPE__MEMBERS,
				 TypesFactory.eINSTANCE.createJvmConstructor()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.JVM_DECLARED_TYPE__MEMBERS,
				 TypesFactory.eINSTANCE.createJvmOperation()));
	}

}
