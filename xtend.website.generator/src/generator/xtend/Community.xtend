package generator.xtend

class Community extends AbstractXtendWebsite {

	override path() {
		'community.html'
	}
	
	override contents() '''
		<div id="page">
			<div id="team" class="container clearfix"> 
				<h2>Resources</h2>
		        <hr>
				«entry('''
						icon_forum.png
					''','''
						Got Questions?
					''','''
						http://www.eclipse.org/forums/index.php?t=thread&frm_id=27
					''','''
						<p>The <strong>Xtext forum</strong> is the first source for getting answers in case you got stuck.
						The community is very friendly. 
						<br>Please ask any questions clearly and with sufficient information attached.</p>
					''')»
				«entry('''
						icon_bugzilla.png
					''','''
						Found a Bug?
					''','''
						https://bugs.eclipse.org/bugs/buglist.cgi?query_format=advanced&short_desc_type=allwordssubstr&short_desc=&classification=Modeling&product=TMF&component=Xtext&long_desc_type=allwordssubstr&long_desc=&bug_file_loc_type=allwordssubstr&bug_file_loc=&status_whiteboard_type=allwordssubstr&status_whiteboard=&keywords_type=allwords&keywords=&bug_status=NEW&bug_status=ASSIGNED&bug_status=REOPENED&emailtype1=exact&email1=&emailtype2=substring&email2=&bugidtype=include&bug_id=&votes=&chfieldfrom=&chfieldto=Now&chfieldvalue=&cmdtype=doit&order=Reuse+same+sort+as+last+time&field0-0-0=noop&type0-0-0=noop&value0-0-0=
					''','''
						<p>Bug reports and enhancement request are tracked at <strong>bugs.eclipse.org</strong>. Please 
						explain the problem and provide a reduced but reproducable eample.
						Also please explain the concrete use case when requesting enhancements.</p>
					''')»
				«entry('''
						icon_twitter.png
					''','''
						Xtext on Twitter
					''','''
						http://www.eclipse.org/forums/index.php?t=thread&frm_id=27
					''','''
						<p>If you are on twitter and want to get notified about all things Xtext, you should consider following <strong>@Xtext</strong>.</p>
					''')»
				«entry('''
						icon_prof_support.png
					''','''
						Professional Support
					''','''
						http://xtext.itemis.com
					''','''
						<p>Need training, problem solving, a prototype, or just a top-notch IDE for your language? 
						<br><strong>itemis</strong> offers all kinds of professional consulting around Xtext.</p>
					''')»
			</div>
			<br/><br/>
		</div>
	'''
	
	def entry(String img, String title, String link, String description) '''
		<div class="row">
			<div class="span1">&nbsp;</div>
			<div class="span9 team">
		    <a href="«link.trim»" class="anchor-in-div"></a>
		    <div class="row">
			  <div class="span1 ">
			    <img src="images/«img.trim»" alt="image" class="image_left">
			  </div>
			  <div class="span2 ">
			    <h3>«title.trim»</h3>
			 	</div>
				<div class="span6 ">
					«description»
				</div>
				</div>
			</div>
		  <div class="span1">&nbsp;</div>
		</div>
	'''
	
}