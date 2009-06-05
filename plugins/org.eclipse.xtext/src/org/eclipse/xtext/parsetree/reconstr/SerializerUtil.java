package org.eclipse.xtext.parsetree.reconstr;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatter.IFormatter;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenOutputStream;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenStringBuffer;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializerUtil {

	private IParseTreeConstructor parseTreeReconstructor;
	private IFormatter formatter;
	private IHiddenTokenMerger merger;

	@Inject
	public SerializerUtil(IParseTreeConstructor ptc, IFormatter fmt,
			IHiddenTokenMerger mgr) {
		this.parseTreeReconstructor = ptc;
		this.formatter = fmt;
		this.merger = mgr;
	}

	protected CompositeNode getNode(EObject obj) {
		NodeAdapter adapter = NodeUtil.getNodeAdapter(obj);
		if (adapter == null)
			return null;
		CompositeNode n = adapter.getParserNode();
		return n.getParent() == null ? n : n.getParent();
	}

	public void serialize(EObject obj, ITokenStream out, CompositeNode node,
			boolean format) throws IOException {
		ITokenStream t = formatter.createFormatterStream(null, out, !format);
		if (node != null)
			t = merger.createHiddenTokenMerger(t, node);
		parseTreeReconstructor.serialize(obj, t);
	}

	public void serialize(EObject obj, OutputStream out, CompositeNode node,
			boolean format) throws IOException {
		serialize(obj, new TokenOutputStream(out), node, format);
	}

	public String serialize(EObject obj) {
		return serialize(obj, true);
	}

	public String serialize(EObject obj, boolean format) {
		TokenStringBuffer out = new TokenStringBuffer();
		try {
			serialize(obj, out, getNode(obj), format);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return out.toString();
	}

}
