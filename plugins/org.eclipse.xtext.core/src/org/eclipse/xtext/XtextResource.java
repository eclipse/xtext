package org.eclipse.xtext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.IParser;
import org.eclipse.xtext.core.parsetree.CompositeNode;
import org.eclipse.xtext.core.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.core.parsetree.NodeAdapter;

public class XtextResource extends ResourceImpl {

	private ILanguageFacade languageFacade;

	public XtextResource(ILanguageFacade languageFacade, URI uri) {
		super(uri);
		this.languageFacade = languageFacade;
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		IParser parser = languageFacade.getParser();
		IElementFactory elementFactory = languageFacade.getElementFactory();
		EObject rootElement = (EObject) parser.parse(inputStream,
				elementFactory);
		getContents().add(rootElement);
	}

	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		for (EObject rootElement : contents) {
			IParseTreeConstructor parsetreeConstructor = languageFacade
					.getParsetreeConstructor();
			parsetreeConstructor.update(rootElement);
			NodeAdapter rootNodeAdapter = getNodeAdapter(rootElement);
			if(rootNodeAdapter != null) {
				CompositeNode rootNode = rootNodeAdapter.getParserNode();
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
						outputStream);
				outputStreamWriter.append(rootNode.serialize());
			}
		}
	}

	private NodeAdapter getNodeAdapter(EObject object) {
		EList<Adapter> adapters = object.eAdapters();
		for (Adapter adapter : adapters) {
			if (adapter.isAdapterForType(NodeAdapter.class)) {
				return (NodeAdapter) adapter;
			}
		}
		return null;
	}
}
