<?php

	# Set the theme for your project's web pages.
	# See the Committer Tools "How Do I" for list of themes
	# https://dev.eclipse.org/committers/
	# Optional: defaults to system theme 
	$theme = "Nova";
	
	// create this file locally - it is on CVS ignore
	$isLocalVersion = file_exists ("islocalversion");

	# Define your project-wide Nav bars here.
	# Format is Link text, link URL (can be http://www.someothersite.com/), target (_self, _blank), level (1, 2 or 3)
	# these are optional
#	$Nav->setLinkList(array());#
#	$Nav->addNavSeparator("Xtext", 	"/Xtext");
#	$Nav->addCustomNav("Download", "/Xtext/download", "_self", 3);
#	$Nav->addCustomNav("Documentation", "/Xtext/documentation", "_self", 3);
#	$Nav->addCustomNav("Support", "/Xtext/support", "_self", 3);
#	$Nav->addCustomNav("Community", "/Xtext/community", "_self", 3);
#	$Nav->addCustomNav("Developers", "/Xtext/developers", "_self", 3);
#	$Nav->addCustomNav("Partners", "/Xtext/partners", "_self", 3);
	
	$pageKeywords	= "xtext, dsl, modeling, domain specific language, textual";
	$pageAuthor		= "Heiko Behrens";
	$pageTitle 		= "Xtext";

	$Menu->setMenuItemList(array());
	$Menu->addMenuItem("Home", "/Xtext", "_self");
	$Menu->addMenuItem("Download", "/Xtext/download", "_self");
	$Menu->addMenuItem("Documentation", "/Xtext/documentation", "_self");
	$Menu->addMenuItem("Support", "/Xtext/support", "_self");
	$Menu->addMenuItem("Community", "/Xtext/community", "_self");
	$Menu->addMenuItem("Developers", "/Xtext/developers", "_self");
#	$Menu->addMenuItem("Partners", "/Xtext/partners", "_self");
	
	$App->AddExtraHtmlHeader('<link rel="stylesheet" type="text/css" href="/Xtext/style.css"/>' . "\n\t");
	$App->AddExtraHtmlHeader('<link rel="stylesheet" type="text/css" href="style2.css"/>' . "\n\t");
	
	$App->Promotion = TRUE;
	
	$App->SetGoogleAnalyticsTrackingCode("UA-2429174-3");
?>
