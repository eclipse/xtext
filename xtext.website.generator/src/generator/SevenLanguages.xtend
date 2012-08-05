package generator

class SevenLanguages extends AbstractWebsite {

	override path() {
		'7languages.html'
	}
	
	override contents() '''
		<!--Container-->
		<div id="header_wrapper" class="container" >
		</div>
		<div id="page" class="languages">
			<div class="container">
				<h1>7 Languages For The JVM<small>- Learning By Example</small></h1>
				<hr />
				<div class="row">
					<div class="span6" style="margin: 4px; text-align: justify;">
						<p style="margin: 5pt;">
							Structural DSLs are great but at some point a software system needs behavior. Xtext now lets you reuse and integrate all kinds of Java language constructs right in your language. The new approach allows for embedding the powerful expressions known from Xtend as well as Java type references and annotations. As a result you get a holistic development experience and a fully-integrated Eclipse IDE, too.
						</p>
						<p style="margin: 5pt;">
							<a href="7languagesDoc.html">Learn this new API by example and have a look at the 7 different languages we've built with it (in less than 7 weeks). It is surprisingly simple!</a>
						</p>
					</div>
					«language('Scripting Language','7languagesDoc.html#scripting','images/red-glossy-scripting.png','''
					A simple scripting language that allows you to write code into a blank file without any
							structural boilerplate like class or method definitions.<br/>
							It translates to a Java class with a main method.
					''')»
				</div>
				<div class="row">
					«language('Build Language','7languagesDoc.html#builddsl','images/red-glossy-helmet.png','''
							A little language that lets you define tasks and dependencies between them. 
							Much like a nice and concise Ant or a statically typed Gradle.
					''')»
					«language('DSL for MongoDB','7languagesDoc.html#mongoDB','images/red-glossy-database.png','''
							Document structures for MongoDB can be defined with this language. It generates
							a handy Java API to interact with MongoDB in a statically typed and structured manner.
					''')»
				</div>
				<div class="row">
					«language('DSL for Guice','7languagesDoc.html#guice','images/red-glossy-guice.png','''
							This language allows you to declare Google Guice modules in a more readable and declarative way.
							Thereby many of the runtime checks can be done at compile time.
					''')»
					«language('Http Routing Language','7languagesDoc.html#httpRouting','images/red-glossy-web.png','''
							Web.xml on steroids and without the XML: Write a URL pattern and map it to a method call in Java.
							Similar to how the Play! framework does it, but with great Eclipse integration and not limited to static methods.
					''')»
				</div>
				<div class="row">
					«language('Template Language','7languagesDoc.html#template','images/red-glossy-template.png','''
							A straight forward template language which allows for statically-typed expressions and 
							named arguments with default values.
					''')»
					«language('Little Tortoise','7languagesDoc.html#tortoise','images/red-glossy-turtle.png','''
							Remember Logo? A cute little tortoise painting on a canvas whatever you want.
					''')»
				</div>
			</div>
		</div>
	'''
	def language(String title, String href, String img, CharSequence description) '''
		<div class="span6 float language-card">
		<a href="«href»" class="anchor-in-div"></a>
		<table>
			<tr>
				<td >
					<img class="language-icon" src="«img»" alt="Image" />
				</td>
				<td>
					<h2>«title»</h2>
					<p>
						«description»
					</p>
				</td>
			</tr>
		</table>
		</div>
	'''

	
}