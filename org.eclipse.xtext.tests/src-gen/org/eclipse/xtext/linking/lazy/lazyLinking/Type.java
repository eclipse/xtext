/**
 */
package org.eclipse.xtext.linking.lazy.lazyLinking;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.linking.lazy.lazyLinking.Type#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.lazy.lazyLinking.Type#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.lazy.lazyLinking.Type#getParentId <em>Parent Id</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.lazy.lazyLinking.Type#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.lazy.lazyLinking.Type#getUnresolvedProxyProperty <em>Unresolved Proxy Property</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.lazy.lazyLinking.Type#getSubtypes <em>Subtypes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.linking.lazy.lazyLinking.LazyLinkingPackage#getType()
 * @model
 * @generated
 */
public interface Type extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.linking.lazy.lazyLinking.LazyLinkingPackage#getType_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.lazy.lazyLinking.Type#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Extends</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.xtext.linking.lazy.lazyLinking.Type#getSubtypes <em>Subtypes</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extends</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends</em>' reference.
   * @see #setExtends(Type)
   * @see org.eclipse.xtext.linking.lazy.lazyLinking.LazyLinkingPackage#getType_Extends()
   * @see org.eclipse.xtext.linking.lazy.lazyLinking.Type#getSubtypes
   * @model opposite="subtypes"
   * @generated
   */
  Type getExtends();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.lazy.lazyLinking.Type#getExtends <em>Extends</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extends</em>' reference.
   * @see #getExtends()
   * @generated
   */
  void setExtends(Type value);

  /**
   * Returns the value of the '<em><b>Parent Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent Id</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parent Id</em>' reference.
   * @see #setParentId(Property)
   * @see org.eclipse.xtext.linking.lazy.lazyLinking.LazyLinkingPackage#getType_ParentId()
   * @model
   * @generated
   */
  Property getParentId();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.lazy.lazyLinking.Type#getParentId <em>Parent Id</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent Id</em>' reference.
   * @see #getParentId()
   * @generated
   */
  void setParentId(Property value);

  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.linking.lazy.lazyLinking.Property}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference list.
   * @see org.eclipse.xtext.linking.lazy.lazyLinking.LazyLinkingPackage#getType_Properties()
   * @model containment="true"
   * @generated
   */
  EList<Property> getProperties();

  /**
   * Returns the value of the '<em><b>Unresolved Proxy Property</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.linking.lazy.lazyLinking.UnresolvedProxyProperty}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unresolved Proxy Property</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unresolved Proxy Property</em>' containment reference list.
   * @see org.eclipse.xtext.linking.lazy.lazyLinking.LazyLinkingPackage#getType_UnresolvedProxyProperty()
   * @model containment="true"
   * @generated
   */
  EList<UnresolvedProxyProperty> getUnresolvedProxyProperty();

  /**
   * Returns the value of the '<em><b>Subtypes</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.linking.lazy.lazyLinking.Type}.
   * It is bidirectional and its opposite is '{@link org.eclipse.xtext.linking.lazy.lazyLinking.Type#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subtypes</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subtypes</em>' reference list.
   * @see org.eclipse.xtext.linking.lazy.lazyLinking.LazyLinkingPackage#getType_Subtypes()
   * @see org.eclipse.xtext.linking.lazy.lazyLinking.Type#getExtends
   * @model opposite="extends"
   * @generated
   */
  EList<Type> getSubtypes();

} // Type
