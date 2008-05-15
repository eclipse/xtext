/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractNodeImpl.java,v 1.1 2008/05/15 11:39:43 sefftinge Exp $
 */
package org.eclipse.xtext.core.parsetree.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.xtext.core.parsetree.AbstractNode;
import org.eclipse.xtext.core.parsetree.CompositeNode;
import org.eclipse.xtext.core.parsetree.ParsetreePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.core.parsetree.impl.AbstractNodeImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.xtext.core.parsetree.impl.AbstractNodeImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.xtext.core.parsetree.impl.AbstractNodeImpl#getGrammarElement <em>Grammar Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractNodeImpl extends EObjectImpl implements AbstractNode {
	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected CompositeNode parent;

	/**
	 * The default value of the '{@link #getElement() <em>Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected static final Object ELEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected Object element = ELEMENT_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParsetreePackage.Literals.ABSTRACT_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeNode getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (CompositeNode)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParsetreePackage.ABSTRACT_NODE__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeNode basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(CompositeNode newParent, NotificationChain msgs) {
		CompositeNode oldParent = parent;
		parent = newParent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParsetreePackage.ABSTRACT_NODE__PARENT, oldParent, newParent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(CompositeNode newParent) {
		if (newParent != parent) {
			NotificationChain msgs = null;
			if (parent != null)
				msgs = ((InternalEObject)parent).eInverseRemove(this, ParsetreePackage.COMPOSITE_NODE__CHILDREN, CompositeNode.class, msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, ParsetreePackage.COMPOSITE_NODE__CHILDREN, CompositeNode.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParsetreePackage.ABSTRACT_NODE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(Object newElement) {
		Object oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParsetreePackage.ABSTRACT_NODE__ELEMENT, oldElement, element));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParsetreePackage.ABSTRACT_NODE__GRAMMAR_ELEMENT, oldGrammarElement, grammarElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ParsetreePackage.ABSTRACT_NODE__GRAMMAR_ELEMENT, oldGrammarElement, grammarElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int length() {
		if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.length((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.length((LeafNodeImpl) this);} else {return ParsetreeUtil.length((AbstractNodeImpl) this);}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int offset() {
		if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.offset((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.offset((LeafNodeImpl) this);} else {return ParsetreeUtil.offset((AbstractNodeImpl) this);}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int line() {
		if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.line((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.line((LeafNodeImpl) this);} else {return ParsetreeUtil.line((AbstractNodeImpl) this);}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String serialize() {
		if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.serialize((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.serialize((LeafNodeImpl) this);} else {return ParsetreeUtil.serialize((AbstractNodeImpl) this);}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParsetreePackage.ABSTRACT_NODE__PARENT:
				if (parent != null)
					msgs = ((InternalEObject)parent).eInverseRemove(this, ParsetreePackage.COMPOSITE_NODE__CHILDREN, CompositeNode.class, msgs);
				return basicSetParent((CompositeNode)otherEnd, msgs);
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
			case ParsetreePackage.ABSTRACT_NODE__PARENT:
				return basicSetParent(null, msgs);
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
			case ParsetreePackage.ABSTRACT_NODE__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ParsetreePackage.ABSTRACT_NODE__ELEMENT:
				return getElement();
			case ParsetreePackage.ABSTRACT_NODE__GRAMMAR_ELEMENT:
				if (resolve) return getGrammarElement();
				return basicGetGrammarElement();
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
			case ParsetreePackage.ABSTRACT_NODE__PARENT:
				setParent((CompositeNode)newValue);
				return;
			case ParsetreePackage.ABSTRACT_NODE__ELEMENT:
				setElement(newValue);
				return;
			case ParsetreePackage.ABSTRACT_NODE__GRAMMAR_ELEMENT:
				setGrammarElement((EObject)newValue);
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
			case ParsetreePackage.ABSTRACT_NODE__PARENT:
				setParent((CompositeNode)null);
				return;
			case ParsetreePackage.ABSTRACT_NODE__ELEMENT:
				setElement(ELEMENT_EDEFAULT);
				return;
			case ParsetreePackage.ABSTRACT_NODE__GRAMMAR_ELEMENT:
				setGrammarElement((EObject)null);
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
			case ParsetreePackage.ABSTRACT_NODE__PARENT:
				return parent != null;
			case ParsetreePackage.ABSTRACT_NODE__ELEMENT:
				return ELEMENT_EDEFAULT == null ? element != null : !ELEMENT_EDEFAULT.equals(element);
			case ParsetreePackage.ABSTRACT_NODE__GRAMMAR_ELEMENT:
				return grammarElement != null;
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
		result.append(" (element: ");
		result.append(element);
		result.append(')');
		return result.toString();
	}

} //AbstractNodeImpl
