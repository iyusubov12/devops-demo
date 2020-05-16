#!/usr/bin/env bash
set -x
docker build . -t java-k8s-gradle-gcloud:1.0
docker tag java-k8s-gradle-gcloud:1.0 gcr.io/ingress-lms-276014/java-k8s-gradle-gcloud:1.0
docker push gcr.io/ingress-lms-276014/java-k8s-gradle-gcloud:1.0