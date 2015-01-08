package bootstrap

import com.google.inject.Inject
import java.util.List
import java.util.Map
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.xtext.xdoc.xdoc.AbstractSection
import org.eclipse.xtext.xdoc.xdoc.Document
import org.eclipse.xtext.xdoc.xdoc.Identifiable

class TargetPaths {
	
	@Inject extension XdocExtensions
	 
	def splitAt(Document document, (AbstractSection)=>boolean predicate, String prefix) {
		val adapter = new TargetPathAdapter
		traverseChildren(document, adapter, prefix, "", predicate);
		document.eResource.resourceSet.eAdapters.add(adapter)
	}

	def getTargetPath(Identifiable element) {
		element.targetPathAdapter?.targetPaths?.get(element)
		?: ''
	}

	def isTargetRootElement(AbstractSection element) {
		val targetFileRoots = element.targetPathAdapter?.targetFileRoots
		if(targetFileRoots != null)
			targetFileRoots.contains(element)
		else
			element instanceof Document
	}

	def getTargetRoots(Document document) {
		document.targetPathAdapter?.targetFileRoots ?: newArrayList(document)
	}

	def protected void traverseChildren(Identifiable element, TargetPathAdapter adapter, String prefix, 
		String parentPath, (AbstractSection)=>boolean predicate) {
		var String thisPath = parentPath
		if (element instanceof AbstractSection) {
			val resolved = (element as AbstractSection).resolve
			if(resolved != element) {
				traverseChildren(resolved, adapter, prefix, parentPath, predicate)
				return
			}
			if(predicate.apply(element as AbstractSection)) {
				thisPath = 
					if(adapter.targetFileRoots.empty)
						prefix + ".html"
					else
						prefix + adapter.targetFileRoots.size + ".html"
				adapter.targetFileRoots.add(element as AbstractSection)
			}
		} 
		adapter.targetPaths.put(element, thisPath)
		for(child : element.eContents.filter(typeof(Identifiable))) {
			traverseChildren(child, adapter, prefix, thisPath, predicate)
		}
	}
	
	def protected getTargetPathAdapter(Identifiable element) {
		element?.eResource?.resourceSet?.eAdapters
			?.filter(typeof(TargetPathAdapter))?.head
	}
}

@Data
class TargetPathAdapter extends AdapterImpl {
	val Map<Identifiable, String> targetPaths = newHashMap()
	val List<AbstractSection> targetFileRoots = newArrayList()
}
	
