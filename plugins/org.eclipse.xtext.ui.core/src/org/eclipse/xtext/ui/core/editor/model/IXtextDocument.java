package org.eclipse.xtext.ui.core.editor.model;

import org.eclipse.jface.text.IDocument;

public interface IXtextDocument extends IDocument {

	public <T> T readOnly(UnitOfWork<T> work);

	public <T> T modify(UnitOfWork<T> work);
	
	public <T> T getAdapter(Class<T> adapterType);

}
