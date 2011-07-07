#!/bin/sh
wget -O commitStatsRequest.txt "http://dash.eclipse.org/dash/commits/web-api/commit-summary.php?top=y&month=x&project=modeling.tmf.xtext"
wget -O pipesNewsRequest.txt "http://pipes.yahoo.com/pipes/pipe.run?_id=c90e6166f0e980bf8df929fce8213a4e&_render=php"
wget -O pipesFastNewsRequest.txt "http://pipes.yahoo.com/pipes/pipe.run?_id=28f2285b56f4d72661235fca175d2156&_render=php"
