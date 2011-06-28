<?php require_once($_SERVER['DOCUMENT_ROOT'] . "/eclipse.org-common/system/app.class.php");	require_once($_SERVER['DOCUMENT_ROOT'] . "/eclipse.org-common/system/nav.class.php"); 	require_once($_SERVER['DOCUMENT_ROOT'] . "/eclipse.org-common/system/menu.class.php"); 	$App 	= new App();	$Nav	= new Nav();	$Menu 	= new Menu();		include($App->getProjectCommon());    # All on the same line to unclutter the user's desktop'
	include("include.php");
	$pageTitle 		= "Content Assist";
	
	$html = file_get_contents('150-contentassist.html');

	$Nav->setLinkList(array());
	
	$App->AddExtraHtmlHeader('
	<script type="text/javascript">
	function init() {
		var docName = "150-contentassist.html";
	    initTocMenu(docName);
		highlightCurrentSection(docName);
	}
	
	function initTocMenu(ActiveSubTocElementId){
		var menu = document.getElementById("leftnav");
	
		var chapters = menu.children;
		addHideSubsectionFunction(chapters);
		var subToc = document.getElementById(ActiveSubTocElementId).parentNode;
		if(subToc) {
			subToc.style.display = "block";
			subToc.previousElementSibling.children[0].style.display = "none"
			subToc.previousElementSibling.children[1].style.display = "inline"
		}
	}
	
	function switchImages(chap) {
		
	}
	
	function addHideSubsectionFunction(items){
		for (var i = 0; i < items.length; i++) {
			if (items[i].firstElementChild != null && items[i].className == "separator"){
				if(items[i].firstElementChild.firstElementChild != null){
					items[i].firstElementChild.firstElementChild.onclick = function(){this.nextElementSibling.style.display="inline";this.style.display = "none"; toc_toggle_subsections(this.parentNode.parentNode);};
					items[i].firstElementChild.firstElementChild.nextElementSibling.onclick = function(){this.previousElementSibling.style.display="inline";this.style.display = "none"; toc_toggle_subsections(this.parentNode.parentNode);};
				}
	 			items[i].firstElementChild.style.cursor = "pointer";
			}
		}
	}
	
	function toc_toggle_subsections(chap){
		if ( chap.children[1].style.display != "none" ) {
			chap.children[1].style.display = "none"
		} else {
			chap.children[1].style.display = "block"
		}
	}
	
	function highlightCurrentSection(sec) {
		document.getElementById(sec).style.backgroundColor= "#D0D0D0"
	}
	
	if ( window.addEventListener ) { 
		window.addEventListener( "load", init, false );
	}
	else if ( window.attachEvent ) { 
		window.attachEvent( "onload", init );
	} else 
		if ( window.onLoad ) {
			window.onload = init;
	}
	</script>');
	
	# Generate the web page
	$App->generatePage("Nova", $Menu, NULL, $pageAuthor, $pageKeywords, $pageTitle, $html);
?>
