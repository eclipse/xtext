if [ -z "$JENKINS_URL" ]; then
  # if not set in environment use default
  JENKINS_URL=https://ci.eclipse.org/xtext/
fi

mvn \
  -f releng \
  --batch-mode \
  --update-snapshots \
  -Dmaven.repo.local=.m2/repository \
  -Dtycho.disableP2Mirrors=true \
  -DJENKINS_URL=$JENKINS_URL \
  -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn \
  clean install