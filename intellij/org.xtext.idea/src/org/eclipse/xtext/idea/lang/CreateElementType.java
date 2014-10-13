package org.eclipse.xtext.idea.lang;

import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.tree.IElementType;

public class CreateElementType extends IElementType {

	private final IElementType elementType;
	private final CreateCallback createCallback;

	public CreateElementType(IElementType elementType, CreateCallback createCallback) {
		super(CreateElementType.class.getName(), elementType.getLanguage(), false);
		this.elementType = elementType;
		this.createCallback = createCallback;
	}
	
	public IElementType getElementType() {
		return elementType;
	}
	
	public CreateCallback getCreateCallback() {
		return createCallback;
	}
	
	@Override
	public String toString() {
		return "CreateElementType [" + elementType.toString() + "]";
	}

	public interface CreateCallback {

		void onCreate(CompositeElement composite);
		
	}

}
