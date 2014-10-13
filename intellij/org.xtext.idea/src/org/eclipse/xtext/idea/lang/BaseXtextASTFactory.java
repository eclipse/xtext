package org.eclipse.xtext.idea.lang;

import com.intellij.lang.DefaultASTFactoryImpl;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.tree.IElementType;

public class BaseXtextASTFactory extends DefaultASTFactoryImpl {
	
	@Override
	public CompositeElement createComposite(IElementType type) {
		if (type instanceof CreateElementType) {
			CreateElementType userDataElementType = (CreateElementType) type;
			CompositeElement composite = super.createComposite(userDataElementType.getElementType());
			userDataElementType.getCreateCallback().onCreate(composite);
			return composite;
		}
		return super.createComposite(type);
	}

}
