package bootstrap

import com.google.inject.Inject
import java.util.List
import java.util.Map
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xdoc.xdoc.Anchor
import org.eclipse.xtext.xdoc.xdoc.ChapterRef
import org.eclipse.xtext.xdoc.xdoc.Code
import org.eclipse.xtext.xdoc.xdoc.CodeBlock
import org.eclipse.xtext.xdoc.xdoc.CodeRef
import org.eclipse.xtext.xdoc.xdoc.Emphasize
import org.eclipse.xtext.xdoc.xdoc.Identifiable
import org.eclipse.xtext.xdoc.xdoc.ImageRef
import org.eclipse.xtext.xdoc.xdoc.Item
import org.eclipse.xtext.xdoc.xdoc.Link
import org.eclipse.xtext.xdoc.xdoc.OrderedList
import org.eclipse.xtext.xdoc.xdoc.Ref
import org.eclipse.xtext.xdoc.xdoc.Section2Ref
import org.eclipse.xtext.xdoc.xdoc.SectionRef
import org.eclipse.xtext.xdoc.xdoc.Table
import org.eclipse.xtext.xdoc.xdoc.TableData
import org.eclipse.xtext.xdoc.xdoc.TableRow
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup
import org.eclipse.xtext.xdoc.xdoc.TextPart
import org.eclipse.xtext.xdoc.xdoc.Todo
import org.eclipse.xtext.xdoc.xdoc.UnorderedList
import com.google.inject.Singleton

class ArtificialIds extends AdapterImpl {
	public Map<Identifiable, String> artificialHrefs = newHashMap() 	
}

@Singleton
class HtmlExtensions {
	
	@Inject extension CodeRefs
	@Inject extension ImageExtensions

	def href(Identifiable id) {
		val it = switch id {
			ChapterRef : id.chapter
			SectionRef : id.section
			Section2Ref : id.section2
			default : id
		}
		if(name != null) { 
			name 
		} else if(artificialHrefs.containsKey(it)) {
			artificialHrefs.get(it)
		} else {
			val newHref = '_'+artificialHrefs.size()
			artificialHrefs.put(it, newHref)
			newHref
		}  
	}
	
	def protected artificialHrefs(Identifiable id) {
		val adapters = id.eResource.resourceSet.eAdapters
		val adapter = adapters.filter(typeof(ArtificialIds)).head 
						?: (new ArtificialIds => [
							adapters.add(it)
						])
		return adapter.artificialHrefs
	}
	
	
	def protected dispatch CharSequence toHtml(TextOrMarkup it, boolean inParagraph) {
		val contentsToHtml = contents.toHtml(true).toString.trim
		if(!contentsToHtml.nullOrEmpty) {
			if(!inParagraph) {
				val result = '''
					<p>
						«contentsToHtml»
					</p>
				'''
				result
			} else {
				contentsToHtml
			}
		} else {
			''
		}
		
	}
	
//	def protected isParagraph(TextOrMarkup it) {
//		switch eContainingFeature {
//			case contents.size==1 
//			&& (contents.head instanceof CodeBlock 
//				|| contents.head instanceof OrderedList
//				|| contents.head instanceof UnorderedList): false
//			case XdocPackage$Literals::ABSTRACT_SECTION__CONTENTS : true
//			default : false
//		}
//	}

	def toHtmlText(Object element) {
		toHtml(element, true)
	}

	def toHtmlParagraph(Object element) {
		toHtml(element, false)
	}

	def protected dispatch CharSequence toHtml(List<EObject> it, boolean inParagraph) {
		map[toHtml(inParagraph)].join
	}

	def protected dispatch CharSequence toHtml(TextPart it, boolean inParagraph) '''«text.quote»'''
	
	def protected dispatch CharSequence toHtml(Emphasize it, boolean inParagraph) '''<strong>«contents.toHtml(inParagraph)»</strong>'''

	def protected dispatch CharSequence toHtml(Anchor it, boolean inParagraph) '''
		<a name="«name.quote»"></a>
	'''
	
	def protected dispatch CharSequence toHtml(Ref it, boolean inParagraph) '''<a href="#«ref.href»">«contents.toHtml(inParagraph)»</a>'''
	
	def protected dispatch CharSequence toHtml(OrderedList it, boolean inParagraph) { '''
			<ol>
				«FOR item:items»
					«item.toHtml(inParagraph)»
				«ENDFOR»
			</ol>
		'''.insert(inParagraph)
	}
	
	def protected dispatch CharSequence toHtml(Item it, boolean inParagraph) '''
		<li>«contents.toHtml(false)»</li>
	'''
	
	def protected dispatch CharSequence toHtml(UnorderedList it, boolean inParagraph) { '''
			<ul>
				«FOR item:items»
					«item.toHtml(inParagraph)»
				«ENDFOR»
			</ul>
		'''.insert(inParagraph)
	}
	
	def protected dispatch CharSequence toHtml(ImageRef it, boolean inParagraph) {
		val dimension = it.dimension
		val caption = it.caption?.trim
		'''
			<div class="thumbnail">
				<img src="«path»" alt="«caption»" «IF dimension!=null»width="«dimension.width»" height="«dimension.height»"«ENDIF»>
			</div>
		'''.insert(inParagraph)
	}
	
	def protected dispatch CharSequence toHtml(Todo it, boolean inParagraph) {
		println("TODO: " + text)
		return ""
	}
	
	def protected dispatch CharSequence toHtml(CodeRef it, boolean inParagraph) {
		val sourceCodeURI = element?.sourceCodeURI
		val javaDocURI = element?.javaDocURI
		'''
		«IF javaDocURI != null
			»<a href="«javaDocURI»">«
		ENDIF»«
		IF altText != null
			»«altText.toHtml(inParagraph)»«
		ELSE
			»<abbr title="«element?.identifier»">«element?.simpleName?.trim»</abbr>«
		ENDIF»«
		IF javaDocURI != null 
			»</a>«
		ENDIF»«
		IF sourceCodeURI!=null
			» <a href="«sourceCodeURI»">(src)</a>«
		ENDIF»'''
	}
	
	def protected dispatch CharSequence toHtml(Code it, boolean inParagraph) {
		contents.quote
	}
	
	def protected dispatch CharSequence toHtml(CodeBlock it, boolean inParagraph) {
		val code = contents.toHtml(inParagraph).toString
		if (code.contains('\n') && !code.contains('\r')) {
			'''<pre class="prettyprint lang-«language?.name?.toLowerCase?:'xtend'» linenums">«markCodeBegin»
			«code.trimCode»«markCodeEnd»</pre>'''.insert(inParagraph)
		} else {
			'''<code class="prettyprint lang-«language?.name?.toLowerCase?:'xtend'»">«code.trimCode»</code>'''
		}
	}
	
	def protected dispatch CharSequence toHtml(Link it, boolean inParagraph) '''<a href="«url»">«text»</a>'''

	def protected dispatch CharSequence toHtml(Table it, boolean inParagraph) { '''
			<table class="table table-bordered table-condensed">
			«FOR row:rows»
				«row.toHtml(inParagraph)»
			«ENDFOR»
			</table>
		'''.insert(inParagraph)
	}
	
	def protected dispatch CharSequence toHtml(TableRow it, boolean inParagraph) '''
		<tr>«data.toHtml(inParagraph)»</tr>
	'''
	
	def protected dispatch CharSequence toHtml(TableData it, boolean inParagraph) '''
		<td>«contents.toHtml(inParagraph)»</td>
	'''
	
	def protected dispatch CharSequence toHtml(EObject it, boolean inParagraph) {
		println("Missing toHtml for " + eClass.name)
		""
	}
	
	def markCodeBegin() {
		'###xdoc code begin###'
	}	
	def markCodeEnd() {
		'###xdoc code end###'
	}	
	
	def protected insert(CharSequence content, boolean inParagraph) {
		if(inParagraph) '''
			</p>
			«content»
			<p>
		''' else content
	}
	
	def protected trimCode(String it) {
		if(nullOrEmpty) 
			return ''
		var start = 0
		while(start < length()-1 && (substring(start, start+1) == ' ' || substring(start,start+1) == '\t'))
			start = start + 1;
		if(substring(start,start+1) =='\n')
			start = start + 1;
		var end = length()-1
		while(end >0 && Character::isWhitespace(charAt(end)))
			end = end - 1
		substring(start, end+1)
	}
	
	def protected quote(CharSequence it) {
		toString.replace('&', '&amp;')
			.replace('<', '&lt;').replace('>', '&gt;')
			.replace('«', '&laquo;').replace('»', '&raquo;')
			.replace('\\[', '[').replace('\\]',']')
			.replace('´',"'").replace('`',"'")
	}

}