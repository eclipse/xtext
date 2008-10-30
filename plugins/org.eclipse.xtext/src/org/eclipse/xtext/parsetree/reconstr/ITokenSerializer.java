package org.eclipse.xtext.parsetree.reconstr;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.IAbstractToken;

public interface ITokenSerializer {
	public void serialize(IAbstractToken firstToken, OutputStream out)
			throws IOException;
}
