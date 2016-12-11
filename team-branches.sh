#!/bin/bash

git checkout master -b team-a
sed -e 's/csd.starter/csd.starter.teama/g' pom.xml | tee pom.xml
git add .
git commit -m "Team A"

git checkout master -b team-b
sed -e 's/csd.starter/csd.starter.teamb/g' pom.xml | tee pom.xml
git add .
git commit -m "Team B"

git checkout master -b team-c
sed -e 's/csd.starter/csd.starter.teamc/g' pom.xml | tee pom.xml
git add .
git commit -m "Team C"

git checkout master -b team-d
sed -e 's/csd.starter/csd.starter.teamd/g' pom.xml | tee pom.xml
git add .
git commit -m "Team D"

git checkout master -b team-e
sed -e 's/csd.starter/csd.starter.teame/g' pom.xml | tee pom.xml
git add .
git commit -m "Team E"
