package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EObject;

public interface IInstanceDescription {

	public abstract boolean isInstanceOf(String string);

	public abstract boolean isOfType(String string);

	public abstract EObject getDelegate();

	public abstract Object get(String feature);

	public abstract boolean isConsumable(String feature);

	public abstract boolean isConsumed();

	public abstract int getConsumed(String feature);

}