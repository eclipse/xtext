/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompositeNodeImpl.java,v 1.1 2008/05/14 15:56:00 jkohnlein Exp $
 */
package org.eclipse.xtext.parsetree.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.xtext.parsetree.AbstractParserNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.ParsetreePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.CompositeNodeImpl#getGrammarElement <em>Grammar Element</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.CompositeNodeImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeNodeImpl extends AbstractParserNodeImpl implements CompositeNode {
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
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractParserNode> children;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParsetreePackage.Literals.COMPOSITE_NODE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParsetreePackage.COMPOSITE_NODE__GRAMMAR_ELEMENT, oldGrammarElement, grammarElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ParsetreePackage.COMPOSITE_NODE__GRAMMAR_ELEMENT, oldGrammarElement, grammarElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractParserNode> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseResolvingEList<AbstractParserNode>(AbstractParserNode.class, this, ParsetreePackage.COMPOSITE_NODE__CHILDREN, ParsetreePackage.ABSTRACT_PARSER_NODE__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParsetreePackage.COMPOSITE_NODE__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParsetreePackage.COMPOSITE_NODE__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ParsetreePackage.COMPOSITE_NODE__GRAMMAR_ELEMENT:
				if (resolve) return getGrammarElement();
				return basicGetGrammarElement();
			case ParsetreePackage.COMPOSITE_NODE__CHILDREN:
				return getChildren();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ParsetreePackage.COMPOSITE_NODE__GRAMMAR_ELEMENT:
				setGrammarElement((EObject)newValue);
				return;
			case ParsetreePackage.COMPOSITE_NODE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends AbstractParserNode>)newValue);
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
			case ParsetreePackage.COMPOSITE_NODE__GRAMMAR_ELEMENT:
				setGrammarElement((EObject)null);
				return;
			case ParsetreePackage.COMPOSITE_NODE__CHILDREN:
				getChildren().clear();
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
			case ParsetreePackage.COMPOSITE_NODE__GRAMMAR_ELEMENT:
				return grammarElement != null;
			case ParsetreePackage.COMPOSITE_NODE__CHILDREN:
				return children != null && !children.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeNodeImpl
