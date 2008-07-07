package org.eclipse.xtext.parsetree.reconstr;

@SuppressWarnings("serial")
public class XtextSerializationException extends RuntimeException {
	private IInstanceDescription desc;
	
	public XtextSerializationException(IInstanceDescription desc, String msg) {
		super(msg);
		this.desc = desc;
	}
	
	public IInstanceDescription getDesc() {
		return desc;
	}
}
