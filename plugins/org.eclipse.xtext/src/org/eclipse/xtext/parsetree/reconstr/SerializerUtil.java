package org.eclipse.xtext.parsetree.reconstr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.ecore.EObject;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializerUtil {
	
	private final IParseTreeConstructor parseTreeReconstructor;
	private final ITokenSerializer tokenSerializer;

	@Inject
	public SerializerUtil(IParseTreeConstructor ptc, ITokenSerializer tokenserializer) {
		this.parseTreeReconstructor = ptc;
		this.tokenSerializer = tokenserializer;
	}
	
	public void serialize(EObject obj, OutputStream out)
			throws IOException {
		tokenSerializer.serialize(parseTreeReconstructor.serialize(obj), obj, out);
	}

	public String serialize(EObject obj) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			serialize(obj, out);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return out.toString();
	}

}
