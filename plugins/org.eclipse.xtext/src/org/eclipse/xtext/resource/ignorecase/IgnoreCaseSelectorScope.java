package org.eclipse.xtext.resource.ignorecase;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;
import org.eclipse.xtext.scoping.ISelector.SelectByName;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IgnoreCaseSelectorScope implements IScope {
	private final IScope scope;

	public IgnoreCaseSelectorScope(IScope scope) {
		this.scope = scope;
	}

	public IEObjectDescription getSingleElement(ISelector selector) {
		return scope.getSingleElement(makeSelectorIgnorCase(selector));
	}

	protected ISelector makeSelectorIgnorCase(ISelector selector) {
		if (selector instanceof ISelector.SelectByName) {
			ISelector.SelectByName selectByName = (SelectByName) selector;
			final QualifiedName lowerCase = selectByName.getName().toLowerCase();
			final ISelector.SelectByName selectByName2 = new ISelector.SelectByName(lowerCase) {
				@Override
				public boolean apply(IEObjectDescription input) {
					return lowerCase.equals(input.getName().toLowerCase());
				}
			};
			selectByName2.getDelegateSelectors().addAll(selectByName.getDelegateSelectors());
			return selectByName2;
		}
		return null;
	}

	public Iterable<IEObjectDescription> getElements(ISelector selector) {
		return scope.getElements(makeSelectorIgnorCase(selector));
	}
}