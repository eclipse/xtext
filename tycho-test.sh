if [ -z "$JENKINS_URL" ]; then
  # if not set in environment use default
  JENKINS_URL=https://ci.eclipse.org/xtext/
fi

# THIS RUNS THE TESTS

mvn \
  -f org.eclipse.xtext.p2.releng \
  clean verify \
  -P useJenkinsSnapshots \
  -P buildP2Repository \
  --batch-mode \
  --update-snapshots \
  -Dmaven.repo.local=.m2/repository \
  -DJENKINS_URL=$JENKINS_URL \
  -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn \
  $@