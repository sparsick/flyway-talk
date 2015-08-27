#!/usr/bin/env bash

export PYTHONUNBUFFERED=1 
export ANSIBLE_FORCE_COLOR=1 

sudo apt-get install software-properties-common -y
sudo apt-add-repository ppa:ansible/ansible -y
sudo apt-get update -y
sudo apt-get install ansible -y

mkdir -p /tmp/ansible
cp -r /vagrant/provisioning /tmp/ansible/.
cd /tmp/ansible/provisioning
ansible-playbook site.yml --connection=local --user=vagrant