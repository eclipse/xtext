package org.eclipse.xtext.generator.trace.internal;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.eclipse.xtext.workspace.IProjectConfig;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 */
public abstract class AbstractLocationInResource implements ILocationInResource {
	private final AbstractTrace trace;
	private AbsoluteURI absoluteURI;

	protected AbstractLocationInResource(AbstractTrace trace) {
		this.trace = trace;
	}

	@Override
	public abstract SourceRelativeURI getSrcRelativeResourceURI();
	protected abstract int getOffset();
	protected abstract int getLength();
	protected abstract int getLineNumber();
	protected abstract int getEndLineNumber();
	
	@Override
	public ITextRegionWithLineInformation getTextRegion() {
		ITextRegionWithLineInformation result = new TextRegionWithLineInformation(getOffset(), getLength(), getLineNumber(), getEndLineNumber());
		return result;
	}
	
	@Override
	public AbsoluteURI getAbsoluteResourceURI() {
		if (absoluteURI == null) {
			absoluteURI = trace.resolvePath(getSrcRelativeResourceURI());
		}
		return absoluteURI;
	}
	
	/* @Nullable */
	@Override
	public InputStream getContents() throws IOException {
		return trace.getContents(getSrcRelativeResourceURI(), getProjectConfig());
	}
	
	@Override
	public /* @NonNull */ IProjectConfig getProjectConfig() {
		return trace.getLocalProjectConfig();
	}
	
	@Override
	public LanguageInfo getLanguage() {
		LanguageInfo result = trace.findLanguage(getAbsoluteResourceURI());
		return result;
	}

//	@Override
//	public URI getEObjectURI() {
//		if (eObjectURI == null && !triedToComputeURI) {
//			Resource resource = trace.getResource(getAbsoluteResourceURI(), getProjectConfig());
//			if (resource instanceof XtextResource) {
//				IParseResult parseResult = ((XtextResource) resource).getParseResult();
//				if (parseResult != null) {
//					ICompositeNode rootNode = parseResult.getRootNode();
//					int end = getOffset() + getLength();
//					INode node = NodeModelUtils.findLeafNodeAtOffset(rootNode, getOffset());
//					while (node != null) {
//						if (node.getTotalEndOffset() >= end) {
//							EObject object = NodeModelUtils.findActualSemanticObjectFor(node);
//							if (object != null) {
//								URI result = EcoreUtil.getURI(object);
//								eObjectURI = result;
//								triedToComputeURI = true;
//								return result;
//							}
//						}
//						node = node.getParent();
//					}
//				}
//			}
//			triedToComputeURI = true;
//		}
//		return eObjectURI;
//	}
	
	protected AbstractTrace getTrace() {
		return trace;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " @ " + getTextRegion();
	}
	
}
