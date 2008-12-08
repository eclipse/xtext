package org.eclipse.xtext.parsetree.reconstr.impl;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.IAbstractToken;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DefaultTokenSerializer implements ITokenSerializer {

	public void serialize(IAbstractToken firstToken, OutputStream out) throws IOException {

	}

}
