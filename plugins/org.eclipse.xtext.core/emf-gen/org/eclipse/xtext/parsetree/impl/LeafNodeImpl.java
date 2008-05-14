/**
 * <copyright>
 * </copyright>
 *
 * $Id: LeafNodeImpl.java,v 1.1 2008/05/14 15:56:00 jkohnlein Exp $
 */
package org.eclipse.xtext.parsetree.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.ParsetreePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Leaf Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.LeafNodeImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.LeafNodeImpl#getGrammarElement <em>Grammar Element</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.LeafNodeImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LeafNodeImpl extends AbstractParserNodeImpl implements LeafNode {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;
	/**
	 * The cached value of the '{@link #getGrammarElement() <em>Grammar Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrammarElement()
	 * @generated
	 * @ordered
	 */
	protected EObject grammarElement;

	/**
	 * The default value of the '{@link #getFeature() <em>Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected String feature = FEATURE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LeafNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParsetreePackage.Literals.LEAF_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParsetreePackage.LEAF_NODE__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getGrammarElement() {
		if (grammarElement != null && grammarElement.eIsProxy()) {
			InternalEObject oldGrammarElement = (InternalEObject)grammarElement;
			grammarElement = eResolveProxy(oldGrammarElement);
			if (grammarElement != oldGrammarElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParsetreePackage.LEAF_NODE__GRAMMAR_ELEMENT, oldGrammarElement, grammarElement));
			}
		}
		return grammarElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetGrammarElement() {
		return grammarElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrammarElement(EObject newGrammarElement) {
		EObject oldGrammarElement = grammarElement;
		grammarElement = newGrammarElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParsetreePackage.LEAF_NODE__GRAMMAR_ELEMENT, oldGrammarElement, grammarElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(String newFeature) {
		String oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParsetreePackage.LEAF_NODE__FEATURE, oldFeature, feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ParsetreePackage.LEAF_NODE__TEXT:
				return getText();
			case ParsetreePackage.LEAF_NODE__GRAMMAR_ELEMENT:
				if (resolve) return getGrammarElement();
				return basicGetGrammarElement();
			case ParsetreePackage.LEAF_NODE__FEATURE:
				return getFeature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ParsetreePackage.LEAF_NODE__TEXT:
				setText((String)newValue);
				return;
			case ParsetreePackage.LEAF_NODE__GRAMMAR_ELEMENT:
				setGrammarElement((EObject)newValue);
				return;
			case ParsetreePackage.LEAF_NODE__FEATURE:
				setFeature((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ParsetreePackage.LEAF_NODE__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case ParsetreePackage.LEAF_NODE__GRAMMAR_ELEMENT:
				setGrammarElement((EObject)null);
				return;
			case ParsetreePackage.LEAF_NODE__FEATURE:
				setFeature(FEATURE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ParsetreePackage.LEAF_NODE__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case ParsetreePackage.LEAF_NODE__GRAMMAR_ELEMENT:
				return grammarElement != null;
			case ParsetreePackage.LEAF_NODE__FEATURE:
				return FEATURE_EDEFAULT == null ? feature != null : !FEATURE_EDEFAULT.equals(feature);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (text: ");
		result.append(text);
		result.append(", feature: ");
		result.append(feature);
		result.append(')');
		return result.toString();
	}

} //LeafNodeImpl
